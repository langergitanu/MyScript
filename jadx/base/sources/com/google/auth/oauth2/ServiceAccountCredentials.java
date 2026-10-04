package com.google.auth.oauth2;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.credentials.provider.CredentialEntry;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffIOExceptionHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.IdTokenProvider;
import com.google.auth.oauth2.JwtClaims;
import com.google.auth.oauth2.MetricsUtils;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes6.dex */
public class ServiceAccountCredentials extends GoogleCredentials implements ServiceAccountSigner, IdTokenProvider, JwtProvider {
    private static final int DEFAULT_LIFETIME_IN_SECONDS = 3600;
    private static final String GRANT_TYPE = "urn:ietf:params:oauth:grant-type:jwt-bearer";
    private static final String PARSE_ERROR_PREFIX = "Error parsing token refresh response. ";
    private static final int TWELVE_HOURS_IN_SECONDS = 43200;
    private static final long serialVersionUID = 7807543542681217978L;
    private final String clientEmail;
    private final String clientId;
    private final boolean defaultRetriesEnabled;
    private final Collection<String> defaultScopes;
    private final int lifetime;
    private final PrivateKey privateKey;
    private final String privateKeyId;
    private final String projectId;
    private final Collection<String> scopes;
    private transient JwtCredentials selfSignedJwtCredentialsWithScope;
    private final String serviceAccountUser;
    private final URI tokenServerUri;
    private transient HttpTransportFactory transportFactory;
    private final String transportFactoryClassName;
    private final boolean useJwtAccessWithScope;

    ServiceAccountCredentials(Builder builder) {
        ImmutableSet immutableSetCopyOf;
        super(builder);
        this.selfSignedJwtCredentialsWithScope = null;
        this.clientId = builder.clientId;
        this.clientEmail = (String) Preconditions.checkNotNull(builder.clientEmail);
        this.privateKey = (PrivateKey) Preconditions.checkNotNull(builder.privateKey);
        this.privateKeyId = builder.privateKeyId;
        this.scopes = builder.scopes == null ? ImmutableSet.m813of() : ImmutableSet.copyOf(builder.scopes);
        if (builder.defaultScopes == null) {
            immutableSetCopyOf = ImmutableSet.m813of();
        } else {
            immutableSetCopyOf = ImmutableSet.copyOf(builder.defaultScopes);
        }
        this.defaultScopes = immutableSetCopyOf;
        HttpTransportFactory httpTransportFactory = (HttpTransportFactory) MoreObjects.firstNonNull(builder.transportFactory, getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
        this.transportFactory = httpTransportFactory;
        this.transportFactoryClassName = httpTransportFactory.getClass().getName();
        this.tokenServerUri = builder.tokenServerUri == null ? OAuth2Utils.TOKEN_SERVER_URI : builder.tokenServerUri;
        this.serviceAccountUser = builder.serviceAccountUser;
        this.projectId = builder.projectId;
        if (builder.lifetime > TWELVE_HOURS_IN_SECONDS) {
            throw new IllegalStateException("lifetime must be less than or equal to 43200");
        }
        this.lifetime = builder.lifetime;
        this.useJwtAccessWithScope = builder.useJwtAccessWithScope;
        this.defaultRetriesEnabled = builder.defaultRetriesEnabled;
    }

    static ServiceAccountCredentials fromJson(Map<String, Object> map, HttpTransportFactory httpTransportFactory) throws IOException {
        URI uri;
        String str = (String) map.get("client_id");
        String str2 = (String) map.get("client_email");
        String str3 = (String) map.get("private_key");
        String str4 = (String) map.get("private_key_id");
        String str5 = (String) map.get("project_id");
        String str6 = (String) map.get("token_uri");
        String str7 = (String) map.get("quota_project_id");
        String str8 = (String) map.get("universe_domain");
        if (str6 != null) {
            try {
                uri = new URI(str6);
            } catch (URISyntaxException unused) {
                throw new IOException("Token server URI specified in 'token_uri' could not be parsed.");
            }
        } else {
            uri = null;
        }
        if (str == null || str2 == null || str3 == null || str4 == null) {
            throw new IOException("Error reading service account credential from JSON, expecting  'client_id', 'client_email', 'private_key' and 'private_key_id'.");
        }
        return fromPkcs8(str3, newBuilder().setClientId(str).setClientEmail(str2).setPrivateKeyId(str4).setHttpTransportFactory(httpTransportFactory).setTokenServerUri(uri).setProjectId(str5).setQuotaProjectId(str7).setUniverseDomain(str8));
    }

    public static ServiceAccountCredentials fromPkcs8(String str, String str2, String str3, String str4, Collection<String> collection) throws IOException {
        return fromPkcs8(str3, newBuilder().setClientId(str).setClientEmail(str2).setPrivateKeyId(str4).setScopes(collection));
    }

    public static ServiceAccountCredentials fromPkcs8(String str, String str2, String str3, String str4, Collection<String> collection, Collection<String> collection2) throws IOException {
        return fromPkcs8(str3, newBuilder().setClientId(str).setClientEmail(str2).setPrivateKeyId(str4).setScopes(collection, collection2));
    }

    public static ServiceAccountCredentials fromPkcs8(String str, String str2, String str3, String str4, Collection<String> collection, HttpTransportFactory httpTransportFactory, URI uri) throws IOException {
        return fromPkcs8(str3, newBuilder().setClientId(str).setClientEmail(str2).setPrivateKeyId(str4).setScopes(collection).setHttpTransportFactory(httpTransportFactory).setTokenServerUri(uri));
    }

    public static ServiceAccountCredentials fromPkcs8(String str, String str2, String str3, String str4, Collection<String> collection, Collection<String> collection2, HttpTransportFactory httpTransportFactory, URI uri) throws IOException {
        return fromPkcs8(str3, newBuilder().setClientId(str).setClientEmail(str2).setPrivateKeyId(str4).setScopes(collection, collection2).setHttpTransportFactory(httpTransportFactory).setTokenServerUri(uri));
    }

    public static ServiceAccountCredentials fromPkcs8(String str, String str2, String str3, String str4, Collection<String> collection, HttpTransportFactory httpTransportFactory, URI uri, String str5) throws IOException {
        return fromPkcs8(str3, newBuilder().setClientId(str).setClientEmail(str2).setPrivateKeyId(str4).setScopes(collection).setHttpTransportFactory(httpTransportFactory).setTokenServerUri(uri).setServiceAccountUser(str5));
    }

    public static ServiceAccountCredentials fromPkcs8(String str, String str2, String str3, String str4, Collection<String> collection, Collection<String> collection2, HttpTransportFactory httpTransportFactory, URI uri, String str5) throws IOException {
        return fromPkcs8(str3, newBuilder().setClientId(str).setClientEmail(str2).setPrivateKeyId(str4).setScopes(collection, collection2).setHttpTransportFactory(httpTransportFactory).setTokenServerUri(uri).setServiceAccountUser(str5));
    }

    static ServiceAccountCredentials fromPkcs8(String str, Builder builder) throws IOException {
        builder.setPrivateKey(OAuth2Utils.privateKeyFromPkcs8(str));
        return new ServiceAccountCredentials(builder);
    }

    public static ServiceAccountCredentials fromStream(InputStream inputStream) throws IOException {
        return fromStream(inputStream, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
    }

    public static ServiceAccountCredentials fromStream(InputStream inputStream, HttpTransportFactory httpTransportFactory) throws IOException {
        ServiceAccountCredentials serviceAccountCredentials = (ServiceAccountCredentials) GoogleCredentials.fromStream(inputStream, httpTransportFactory);
        if (serviceAccountCredentials != null) {
            return serviceAccountCredentials;
        }
        throw new IOException("Error reading credentials from stream, ServiceAccountCredentials type is not recognized.");
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public boolean createScopedRequired() {
        return this.scopes.isEmpty() && this.defaultScopes.isEmpty();
    }

    boolean isConfiguredForDomainWideDelegation() {
        String str = this.serviceAccountUser;
        return str != null && str.length() > 0;
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public AccessToken refreshAccessToken() throws IOException {
        JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
        String strCreateAssertion = createAssertion(jsonFactory, this.clock.currentTimeMillis());
        GenericData genericData = new GenericData();
        genericData.set("grant_type", GRANT_TYPE);
        genericData.set("assertion", strCreateAssertion);
        HttpRequest httpRequestBuildPostRequest = this.transportFactory.create().createRequestFactory().buildPostRequest(new GenericUrl(this.tokenServerUri), new UrlEncodedContent(genericData));
        MetricsUtils.setMetricsHeader(httpRequestBuildPostRequest, MetricsUtils.getGoogleCredentialsMetricsHeader(MetricsUtils.RequestType.ACCESS_TOKEN_REQUEST, getMetricsCredentialType()));
        if (this.defaultRetriesEnabled) {
            httpRequestBuildPostRequest.setNumberOfRetries(3);
        } else {
            httpRequestBuildPostRequest.setNumberOfRetries(0);
        }
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(jsonFactory));
        ExponentialBackOff exponentialBackOffBuild = new ExponentialBackOff.Builder().setInitialIntervalMillis(1000).setRandomizationFactor(0.1d).setMultiplier(2.0d).build();
        httpRequestBuildPostRequest.setUnsuccessfulResponseHandler(new HttpBackOffUnsuccessfulResponseHandler(exponentialBackOffBuild).setBackOffRequired(new HttpBackOffUnsuccessfulResponseHandler.BackOffRequired() { // from class: com.google.auth.oauth2.ServiceAccountCredentials$$ExternalSyntheticLambda1
            @Override // com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired
            public final boolean isRequired(HttpResponse httpResponse) {
                return OAuth2Utils.TOKEN_ENDPOINT_RETRYABLE_STATUS_CODES.contains(Integer.valueOf(httpResponse.getStatusCode()));
            }
        }));
        httpRequestBuildPostRequest.setIOExceptionHandler(new HttpBackOffIOExceptionHandler(exponentialBackOffBuild));
        try {
            GenericData genericData2 = (GenericData) httpRequestBuildPostRequest.execute().parseAs(GenericData.class);
            return new AccessToken(OAuth2Utils.validateString(genericData2, "access_token", PARSE_ERROR_PREFIX), new Date(this.clock.currentTimeMillis() + (((long) OAuth2Utils.validateInt32(genericData2, "expires_in", PARSE_ERROR_PREFIX)) * 1000)));
        } catch (HttpResponseException e) {
            throw GoogleAuthException.createWithTokenEndpointResponseException(e, String.format("Error getting access token for service account: %s, iss: %s", e.getMessage(), getIssuer()));
        } catch (IOException e2) {
            throw GoogleAuthException.createWithTokenEndpointIOException(e2, String.format("Error getting access token for service account: %s, iss: %s", e2.getMessage(), getIssuer()));
        }
    }

    @Override // com.google.auth.oauth2.IdTokenProvider
    public IdToken idTokenWithAudience(String str, List<IdTokenProvider.Option> list) throws IOException {
        if (isDefaultUniverseDomain()) {
            return getIdTokenOauthEndpoint(str);
        }
        return getIdTokenIamEndpoint(str);
    }

    private IdToken getIdTokenOauthEndpoint(String str) throws IOException {
        ImmutableMap immutableMapM787of = ImmutableMap.m787of("grant_type", GRANT_TYPE, "assertion", createAssertionForIdToken(this.clock.currentTimeMillis(), this.tokenServerUri.toString(), str));
        GenericData genericData = new GenericData();
        immutableMapM787of.forEach(new ServiceAccountCredentials$$ExternalSyntheticLambda0(genericData));
        HttpRequest httpRequestBuildIdTokenRequest = buildIdTokenRequest(this.tokenServerUri, this.transportFactory, new UrlEncodedContent(genericData));
        MetricsUtils.setMetricsHeader(httpRequestBuildIdTokenRequest, MetricsUtils.getGoogleCredentialsMetricsHeader(MetricsUtils.RequestType.ID_TOKEN_REQUEST, getMetricsCredentialType()));
        return IdToken.create(OAuth2Utils.validateString((GenericData) executeRequest(httpRequestBuildIdTokenRequest).parseAs(GenericData.class), "id_token", PARSE_ERROR_PREFIX));
    }

    private IdToken getIdTokenIamEndpoint(String str) throws IOException {
        String str2 = createSelfSignedJwtCredentials(null, ImmutableList.m767of("https://www.googleapis.com/auth/iam")).getRequestMetadata(null).get("Authorization").get(0);
        ImmutableMap immutableMapM788of = ImmutableMap.m788of("audience", str, "includeEmail", CredentialEntry.TRUE_STRING, "useEmailAzp", CredentialEntry.TRUE_STRING);
        GenericData genericData = new GenericData();
        immutableMapM788of.forEach(new ServiceAccountCredentials$$ExternalSyntheticLambda0(genericData));
        HttpRequest httpRequestBuildIdTokenRequest = buildIdTokenRequest(URI.create(String.format("https://iamcredentials.%s/v1/projects/-/serviceAccounts/%s:generateIdToken", getUniverseDomain(), this.clientEmail)), this.transportFactory, new UrlEncodedContent(genericData));
        httpRequestBuildIdTokenRequest.setHeaders(new HttpHeaders().set("Authorization", (Object) str2));
        return IdToken.create(OAuth2Utils.validateString((GenericData) executeRequest(httpRequestBuildIdTokenRequest).parseAs(GenericData.class), "token", PARSE_ERROR_PREFIX));
    }

    private HttpRequest buildIdTokenRequest(URI uri, HttpTransportFactory httpTransportFactory, HttpContent httpContent) throws IOException {
        JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
        HttpRequest httpRequestBuildPostRequest = httpTransportFactory.create().createRequestFactory().buildPostRequest(new GenericUrl(uri), httpContent);
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(jsonFactory));
        return httpRequestBuildPostRequest;
    }

    private HttpResponse executeRequest(HttpRequest httpRequest) throws IOException {
        try {
            return httpRequest.execute();
        } catch (IOException e) {
            throw new IOException(String.format("Error getting id token for service account: %s, iss: %s", e.getMessage(), getIssuer()), e);
        }
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public ServiceAccountCredentials createWithCustomRetryStrategy(boolean z) {
        return toBuilder().setDefaultRetriesEnabled(z).build();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public GoogleCredentials createScoped(Collection<String> collection) {
        return createScoped(collection, null);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public GoogleCredentials createScoped(Collection<String> collection, Collection<String> collection2) {
        return toBuilder().setScopes(collection, collection2).setAccessToken((AccessToken) null).build();
    }

    public ServiceAccountCredentials createWithCustomLifetime(int i) {
        return toBuilder().setLifetime(i).build();
    }

    public ServiceAccountCredentials createWithUseJwtAccessWithScope(boolean z) {
        return toBuilder().setUseJwtAccessWithScope(z).build();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public GoogleCredentials createDelegated(String str) {
        return toBuilder().setServiceAccountUser(str).build();
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientEmail() {
        return this.clientEmail;
    }

    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public final String getPrivateKeyId() {
        return this.privateKeyId;
    }

    public final Collection<String> getScopes() {
        return this.scopes;
    }

    public final Collection<String> getDefaultScopes() {
        return this.defaultScopes;
    }

    public final String getServiceAccountUser() {
        return this.serviceAccountUser;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final URI getTokenServerUri() {
        return this.tokenServerUri;
    }

    private String getIssuer() {
        return this.clientEmail;
    }

    int getLifetime() {
        return this.lifetime;
    }

    public boolean getUseJwtAccessWithScope() {
        return this.useJwtAccessWithScope;
    }

    JwtCredentials getSelfSignedJwtCredentialsWithScope() {
        return this.selfSignedJwtCredentialsWithScope;
    }

    @Override // com.google.auth.ServiceAccountSigner
    public String getAccount() {
        return getClientEmail();
    }

    @Override // com.google.auth.ServiceAccountSigner
    public byte[] sign(byte[] bArr) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(getPrivateKey());
            signature.update(bArr);
            return signature.sign();
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            throw new ServiceAccountSigner.SigningException("Failed to sign the provided bytes", e);
        }
    }

    @Override // com.google.auth.oauth2.JwtProvider
    public JwtCredentials jwtWithClaims(JwtClaims jwtClaims) {
        return JwtCredentials.newBuilder().setPrivateKey(this.privateKey).setPrivateKeyId(this.privateKeyId).setJwtClaims(JwtClaims.newBuilder().setIssuer(getIssuer()).setSubject(this.clientEmail).build().merge(jwtClaims)).setClock(this.clock).build();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public int hashCode() {
        return Objects.hash(this.clientId, this.clientEmail, this.privateKey, this.privateKeyId, this.transportFactoryClassName, this.tokenServerUri, this.scopes, this.defaultScopes, Integer.valueOf(this.lifetime), Boolean.valueOf(this.useJwtAccessWithScope), Boolean.valueOf(this.defaultRetriesEnabled), Integer.valueOf(super.hashCode()));
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    protected MoreObjects.ToStringHelper toStringHelper() {
        return super.toStringHelper().add("clientId", this.clientId).add("clientEmail", this.clientEmail).add("privateKeyId", this.privateKeyId).add("transportFactoryClassName", this.transportFactoryClassName).add("tokenServerUri", this.tokenServerUri).add("scopes", this.scopes).add("defaultScopes", this.defaultScopes).add("serviceAccountUser", this.serviceAccountUser).add("lifetime", this.lifetime).add("useJwtAccessWithScope", this.useJwtAccessWithScope).add("defaultRetriesEnabled", this.defaultRetriesEnabled);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public boolean equals(Object obj) {
        if (!(obj instanceof ServiceAccountCredentials) || !super.equals(obj)) {
            return false;
        }
        ServiceAccountCredentials serviceAccountCredentials = (ServiceAccountCredentials) obj;
        return Objects.equals(this.clientId, serviceAccountCredentials.clientId) && Objects.equals(this.clientEmail, serviceAccountCredentials.clientEmail) && Objects.equals(this.privateKey, serviceAccountCredentials.privateKey) && Objects.equals(this.privateKeyId, serviceAccountCredentials.privateKeyId) && Objects.equals(this.transportFactoryClassName, serviceAccountCredentials.transportFactoryClassName) && Objects.equals(this.tokenServerUri, serviceAccountCredentials.tokenServerUri) && Objects.equals(this.scopes, serviceAccountCredentials.scopes) && Objects.equals(this.defaultScopes, serviceAccountCredentials.defaultScopes) && Objects.equals(Integer.valueOf(this.lifetime), Integer.valueOf(serviceAccountCredentials.lifetime)) && Objects.equals(Boolean.valueOf(this.useJwtAccessWithScope), Boolean.valueOf(serviceAccountCredentials.useJwtAccessWithScope)) && Objects.equals(Boolean.valueOf(this.defaultRetriesEnabled), Boolean.valueOf(serviceAccountCredentials.defaultRetriesEnabled));
    }

    String createAssertion(JsonFactory jsonFactory, long j) throws IOException {
        JsonWebSignature.Header header = new JsonWebSignature.Header();
        header.setAlgorithm("RS256");
        header.setType("JWT");
        header.setKeyId(this.privateKeyId);
        JsonWebToken.Payload payload = new JsonWebToken.Payload();
        payload.setIssuer(getIssuer());
        long j2 = j / 1000;
        payload.setIssuedAtTimeSeconds(Long.valueOf(j2));
        payload.setExpirationTimeSeconds(Long.valueOf(j2 + ((long) this.lifetime)));
        payload.setSubject(this.serviceAccountUser);
        if (this.scopes.isEmpty()) {
            payload.put("scope", (Object) Joiner.m725on(TokenParser.f2383SP).join(this.defaultScopes));
        } else {
            payload.put("scope", (Object) Joiner.m725on(TokenParser.f2383SP).join(this.scopes));
        }
        payload.setAudience(OAuth2Utils.TOKEN_SERVER_URI.toString());
        try {
            return JsonWebSignature.signUsingRsaSha256(this.privateKey, jsonFactory, header, payload);
        } catch (GeneralSecurityException e) {
            throw new IOException("Error signing service account access token request with private key.", e);
        }
    }

    String createAssertionForIdToken(long j, String str, String str2) throws IOException {
        JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
        JsonWebSignature.Header header = new JsonWebSignature.Header();
        header.setAlgorithm("RS256");
        header.setType("JWT");
        header.setKeyId(this.privateKeyId);
        JsonWebToken.Payload payload = new JsonWebToken.Payload();
        payload.setIssuer(getIssuer());
        long j2 = j / 1000;
        payload.setIssuedAtTimeSeconds(Long.valueOf(j2));
        payload.setExpirationTimeSeconds(Long.valueOf(j2 + ((long) this.lifetime)));
        payload.setSubject(this.serviceAccountUser);
        if (str == null) {
            payload.setAudience(OAuth2Utils.TOKEN_SERVER_URI.toString());
        } else {
            payload.setAudience(str);
        }
        try {
            payload.set("target_audience", (Object) str2);
            return JsonWebSignature.signUsingRsaSha256(this.privateKey, jsonFactory, header, payload);
        } catch (GeneralSecurityException e) {
            throw new IOException("Error signing service account access token request with private key.", e);
        }
    }

    static URI getUriForSelfSignedJWT(URI uri) {
        if (uri != null && uri.getScheme() != null && uri.getHost() != null) {
            try {
                return new URI(uri.getScheme(), uri.getHost(), DomExceptionUtils.SEPARATOR, null);
            } catch (URISyntaxException unused) {
            }
        }
        return uri;
    }

    JwtCredentials createSelfSignedJwtCredentials(URI uri) {
        return createSelfSignedJwtCredentials(uri, this.scopes.isEmpty() ? this.defaultScopes : this.scopes);
    }

    JwtCredentials createSelfSignedJwtCredentials(URI uri, Collection<String> collection) {
        JwtClaims.Builder subject = JwtClaims.newBuilder().setIssuer(this.clientEmail).setSubject(this.clientEmail);
        if (uri == null) {
            subject.setAdditionalClaims(Collections.singletonMap("scope", Joiner.m725on(TokenParser.f2383SP).join(collection)));
        } else {
            subject.setAudience(getUriForSelfSignedJWT(uri).toString());
        }
        return JwtCredentials.newBuilder().setPrivateKey(this.privateKey).setPrivateKeyId(this.privateKeyId).setJwtClaims(subject.build()).setClock(this.clock).build();
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials, com.google.auth.Credentials
    public void getRequestMetadata(URI uri, Executor executor, RequestMetadataCallback requestMetadataCallback) {
        try {
            if (!this.useJwtAccessWithScope && isDefaultUniverseDomain()) {
                super.getRequestMetadata(uri, executor, requestMetadataCallback);
                return;
            }
            blockingGetToCallback(uri, requestMetadataCallback);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials, com.google.auth.Credentials
    public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
        if (createScopedRequired() && uri == null) {
            throw new IOException("Scopes and uri are not configured for service account. Specify the scopes by calling createScoped or passing scopes to constructor or providing uri to getRequestMetadata.");
        }
        if (isDefaultUniverseDomain()) {
            return getRequestMetadataForGdu(uri);
        }
        return getRequestMetadataForNonGdu(uri);
    }

    @Override // com.google.auth.Credentials
    public CredentialTypeForMetrics getMetricsCredentialType() {
        return shouldUseAssertionFlowForGdu() ? CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT : CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_JWT;
    }

    boolean shouldUseAssertionFlowForGdu() {
        return !(createScopedRequired() || this.useJwtAccessWithScope) || isConfiguredForDomainWideDelegation();
    }

    private Map<String, List<String>> getRequestMetadataForGdu(URI uri) throws IOException {
        if (shouldUseAssertionFlowForGdu()) {
            return super.getRequestMetadata(uri);
        }
        return getRequestMetadataWithSelfSignedJwt(uri);
    }

    private Map<String, List<String>> getRequestMetadataForNonGdu(URI uri) throws IOException {
        if (isConfiguredForDomainWideDelegation()) {
            throw new IOException(String.format("Service Account user is configured for the credential. Domain-wide delegation is not supported in universes different than %s.", Credentials.GOOGLE_DEFAULT_UNIVERSE));
        }
        return getRequestMetadataWithSelfSignedJwt(uri);
    }

    private Map<String, List<String>> getRequestMetadataWithSelfSignedJwt(URI uri) throws IOException {
        JwtCredentials jwtCredentialsCreateSelfSignedJwtCredentials;
        if (!createScopedRequired()) {
            if (this.selfSignedJwtCredentialsWithScope == null) {
                this.selfSignedJwtCredentialsWithScope = createSelfSignedJwtCredentials(null);
            }
            jwtCredentialsCreateSelfSignedJwtCredentials = this.selfSignedJwtCredentialsWithScope;
        } else {
            jwtCredentialsCreateSelfSignedJwtCredentials = createSelfSignedJwtCredentials(uri);
        }
        return addQuotaProjectIdToRequestMetadata(this.quotaProjectId, jwtCredentialsCreateSelfSignedJwtCredentials.getRequestMetadata(null));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.transportFactory = (HttpTransportFactory) newInstance(this.transportFactoryClassName);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public Builder toBuilder() {
        return new Builder(this);
    }

    public static class Builder extends GoogleCredentials.Builder {
        private String clientEmail;
        private String clientId;
        private boolean defaultRetriesEnabled;
        private Collection<String> defaultScopes;
        private int lifetime;
        private PrivateKey privateKey;
        private String privateKeyId;
        private String projectId;
        private Collection<String> scopes;
        private String serviceAccountUser;
        private URI tokenServerUri;
        private HttpTransportFactory transportFactory;
        private boolean useJwtAccessWithScope;

        protected Builder() {
            this.lifetime = 3600;
            this.useJwtAccessWithScope = false;
            this.defaultRetriesEnabled = true;
        }

        protected Builder(ServiceAccountCredentials serviceAccountCredentials) {
            super(serviceAccountCredentials);
            this.lifetime = 3600;
            this.useJwtAccessWithScope = false;
            this.defaultRetriesEnabled = true;
            this.clientId = serviceAccountCredentials.clientId;
            this.clientEmail = serviceAccountCredentials.clientEmail;
            this.privateKey = serviceAccountCredentials.privateKey;
            this.privateKeyId = serviceAccountCredentials.privateKeyId;
            this.scopes = serviceAccountCredentials.scopes;
            this.defaultScopes = serviceAccountCredentials.defaultScopes;
            this.transportFactory = serviceAccountCredentials.transportFactory;
            this.tokenServerUri = serviceAccountCredentials.tokenServerUri;
            this.serviceAccountUser = serviceAccountCredentials.serviceAccountUser;
            this.projectId = serviceAccountCredentials.projectId;
            this.lifetime = serviceAccountCredentials.lifetime;
            this.useJwtAccessWithScope = serviceAccountCredentials.useJwtAccessWithScope;
            this.defaultRetriesEnabled = serviceAccountCredentials.defaultRetriesEnabled;
        }

        public Builder setClientId(String str) {
            this.clientId = str;
            return this;
        }

        public Builder setClientEmail(String str) {
            this.clientEmail = str;
            return this;
        }

        public Builder setPrivateKey(PrivateKey privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        public Builder setPrivateKeyString(String str) throws IOException {
            this.privateKey = OAuth2Utils.privateKeyFromPkcs8(str);
            return this;
        }

        public Builder setPrivateKeyId(String str) {
            this.privateKeyId = str;
            return this;
        }

        public Builder setScopes(Collection<String> collection) {
            this.scopes = collection;
            this.defaultScopes = ImmutableSet.m813of();
            return this;
        }

        public Builder setScopes(Collection<String> collection, Collection<String> collection2) {
            this.scopes = collection;
            this.defaultScopes = collection2;
            return this;
        }

        public Builder setServiceAccountUser(String str) {
            this.serviceAccountUser = str;
            return this;
        }

        public Builder setProjectId(String str) {
            this.projectId = str;
            return this;
        }

        public Builder setTokenServerUri(URI uri) {
            this.tokenServerUri = uri;
            return this;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.transportFactory = httpTransportFactory;
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setQuotaProjectId(String str) {
            super.setQuotaProjectId(str);
            return this;
        }

        public Builder setLifetime(int i) {
            if (i == 0) {
                i = 3600;
            }
            this.lifetime = i;
            return this;
        }

        public Builder setUseJwtAccessWithScope(boolean z) {
            this.useJwtAccessWithScope = z;
            return this;
        }

        public Builder setDefaultRetriesEnabled(boolean z) {
            this.defaultRetriesEnabled = z;
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setUniverseDomain(String str) {
            this.universeDomain = str;
            return this;
        }

        public String getClientId() {
            return this.clientId;
        }

        public String getClientEmail() {
            return this.clientEmail;
        }

        public PrivateKey getPrivateKey() {
            return this.privateKey;
        }

        public String getPrivateKeyId() {
            return this.privateKeyId;
        }

        public Collection<String> getScopes() {
            return this.scopes;
        }

        public Collection<String> getDefaultScopes() {
            return this.defaultScopes;
        }

        public String getServiceAccountUser() {
            return this.serviceAccountUser;
        }

        public String getProjectId() {
            return this.projectId;
        }

        public URI getTokenServerUri() {
            return this.tokenServerUri;
        }

        public HttpTransportFactory getHttpTransportFactory() {
            return this.transportFactory;
        }

        public int getLifetime() {
            return this.lifetime;
        }

        public boolean getUseJwtAccessWithScope() {
            return this.useJwtAccessWithScope;
        }

        public boolean isDefaultRetriesEnabled() {
            return this.defaultRetriesEnabled;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public ServiceAccountCredentials build() {
            return new ServiceAccountCredentials(this);
        }
    }
}
