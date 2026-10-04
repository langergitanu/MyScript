package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes6.dex */
public class UserAuthorizer {
    static final URI DEFAULT_CALLBACK_URI = URI.create("/oauth2callback");
    private final String FETCH_TOKEN_ERROR;
    private final String TOKEN_STORE_ERROR;
    private final URI callbackUri;
    private final ClientAuthenticationType clientAuthenticationType;
    private final ClientId clientId;
    private final PKCEProvider pkce;
    private final Collection<String> scopes;
    private final URI tokenServerUri;
    private final TokenStore tokenStore;
    private final HttpTransportFactory transportFactory;
    private final URI userAuthUri;

    public enum ClientAuthenticationType {
        CLIENT_SECRET_POST,
        CLIENT_SECRET_BASIC,
        NONE
    }

    private UserAuthorizer(Builder builder) {
        this.TOKEN_STORE_ERROR = "Error parsing stored token data.";
        this.FETCH_TOKEN_ERROR = "Error reading result of Token API:";
        this.clientId = (ClientId) Preconditions.checkNotNull(builder.clientId);
        this.scopes = ImmutableList.copyOf((Collection) Preconditions.checkNotNull(builder.scopes));
        this.callbackUri = builder.callbackUri == null ? DEFAULT_CALLBACK_URI : builder.callbackUri;
        this.transportFactory = builder.transportFactory == null ? OAuth2Utils.HTTP_TRANSPORT_FACTORY : builder.transportFactory;
        this.tokenServerUri = builder.tokenServerUri == null ? OAuth2Utils.TOKEN_SERVER_URI : builder.tokenServerUri;
        this.userAuthUri = builder.userAuthUri == null ? OAuth2Utils.USER_AUTH_URI : builder.userAuthUri;
        this.tokenStore = builder.tokenStore == null ? new MemoryTokensStorage() : builder.tokenStore;
        this.pkce = builder.pkce;
        this.clientAuthenticationType = builder.clientAuthenticationType == null ? ClientAuthenticationType.CLIENT_SECRET_POST : builder.clientAuthenticationType;
    }

    public ClientId getClientId() {
        return this.clientId;
    }

    public Collection<String> getScopes() {
        return this.scopes;
    }

    public URI getCallbackUri() {
        return this.callbackUri;
    }

    public URI getCallbackUri(URI uri) {
        if (this.callbackUri.isAbsolute()) {
            return this.callbackUri;
        }
        if (uri == null || !uri.isAbsolute()) {
            throw new IllegalStateException("If the callback URI is relative, the baseUri passed must be an absolute URI");
        }
        return uri.resolve(this.callbackUri);
    }

    public TokenStore getTokenStore() {
        return this.tokenStore;
    }

    public ClientAuthenticationType getClientAuthenticationType() {
        return this.clientAuthenticationType;
    }

    public URL getAuthorizationUrl(String str, String str2, URI uri) {
        return getAuthorizationUrl(str, str2, uri, null);
    }

    public URL getAuthorizationUrl(String str, String str2, URI uri, Map<String, String> map) {
        URI callbackUri = getCallbackUri(uri);
        String strJoin = Joiner.m725on(TokenParser.f2383SP).join(this.scopes);
        GenericUrl genericUrl = new GenericUrl(this.userAuthUri);
        genericUrl.put("response_type", (Object) "code");
        genericUrl.put("client_id", (Object) this.clientId.getClientId());
        genericUrl.put("redirect_uri", (Object) callbackUri);
        genericUrl.put("scope", (Object) strJoin);
        if (str2 != null) {
            genericUrl.put("state", (Object) str2);
        }
        genericUrl.put("access_type", (Object) "offline");
        genericUrl.put("approval_prompt", (Object) "force");
        if (str != null) {
            genericUrl.put("login_hint", (Object) str);
        }
        genericUrl.put("include_granted_scopes", (Object) true);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                genericUrl.put(entry.getKey(), (Object) entry.getValue());
            }
        }
        PKCEProvider pKCEProvider = this.pkce;
        if (pKCEProvider != null) {
            genericUrl.put("code_challenge", (Object) pKCEProvider.getCodeChallenge());
            genericUrl.put("code_challenge_method", (Object) this.pkce.getCodeChallengeMethod());
        }
        return genericUrl.toURL();
    }

    public UserCredentials getCredentials(String str) throws IOException {
        Preconditions.checkNotNull(str);
        TokenStore tokenStore = this.tokenStore;
        if (tokenStore == null) {
            throw new IllegalStateException("Method cannot be called if token store is not specified.");
        }
        String strLoad = tokenStore.load(str);
        if (strLoad == null) {
            return null;
        }
        GenericJson json = OAuth2Utils.parseJson(strLoad);
        String strValidateString = OAuth2Utils.validateString(json, "access_token", "Error parsing stored token data.");
        Date date = new Date(Long.valueOf(OAuth2Utils.validateLong(json, "expiration_time_millis", "Error parsing stored token data.")).longValue());
        UserCredentials userCredentialsBuild = UserCredentials.newBuilder().setClientId(this.clientId.getClientId()).setClientSecret(this.clientId.getClientSecret()).setRefreshToken(OAuth2Utils.validateOptionalString(json, "refresh_token", "Error parsing stored token data.")).setAccessToken(AccessToken.newBuilder().setExpirationTime(date).setTokenValue(strValidateString).setScopes(OAuth2Utils.validateOptionalListString(json, "scope", "Error reading result of Token API:")).build()).setHttpTransportFactory(this.transportFactory).setTokenServerUri(this.tokenServerUri).build();
        monitorCredentials(str, userCredentialsBuild);
        return userCredentialsBuild;
    }

    public UserCredentials getCredentialsFromCode(String str, URI uri) throws IOException {
        return getCredentialsFromCode(str, uri, null);
    }

    public UserCredentials getCredentialsFromCode(String str, URI uri, Map<String, String> map) throws IOException {
        TokenResponseWithConfig credentialsFromCodeInternal = getCredentialsFromCodeInternal(str, uri, map);
        return UserCredentials.newBuilder().setClientId(credentialsFromCodeInternal.getClientId()).setClientSecret(credentialsFromCodeInternal.getClientSecret()).setAccessToken(credentialsFromCodeInternal.getAccessToken()).setRefreshToken(credentialsFromCodeInternal.getRefreshToken()).setHttpTransportFactory(credentialsFromCodeInternal.getHttpTransportFactory()).setTokenServerUri(credentialsFromCodeInternal.getTokenServerUri()).build();
    }

    public TokenResponseWithConfig getTokenResponseFromAuthCodeExchange(String str, URI uri, Map<String, String> map) throws IOException {
        return getCredentialsFromCodeInternal(str, uri, map);
    }

    public UserCredentials getAndStoreCredentialsFromCode(String str, String str2, URI uri) throws IOException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        UserCredentials credentialsFromCode = getCredentialsFromCode(str2, uri);
        storeCredentials(str, credentialsFromCode);
        monitorCredentials(str, credentialsFromCode);
        return credentialsFromCode;
    }

    public void revokeAuthorization(String str) throws IOException {
        Preconditions.checkNotNull(str);
        TokenStore tokenStore = this.tokenStore;
        if (tokenStore == null) {
            throw new IllegalStateException("Method cannot be called if token store is not specified.");
        }
        String strLoad = tokenStore.load(str);
        if (strLoad == null) {
            return;
        }
        try {
            this.tokenStore.delete(str);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        GenericJson json = OAuth2Utils.parseJson(strLoad);
        String strValidateOptionalString = OAuth2Utils.validateOptionalString(json, "access_token", "Error parsing stored token data.");
        String strValidateOptionalString2 = OAuth2Utils.validateOptionalString(json, "refresh_token", "Error parsing stored token data.");
        if (strValidateOptionalString2 != null) {
            strValidateOptionalString = strValidateOptionalString2;
        }
        GenericUrl genericUrl = new GenericUrl(OAuth2Utils.TOKEN_REVOKE_URI);
        GenericData genericData = new GenericData();
        genericData.put("token", (Object) strValidateOptionalString);
        this.transportFactory.create().createRequestFactory().buildPostRequest(genericUrl, new UrlEncodedContent(genericData)).execute();
        if (e != null) {
            throw e;
        }
    }

    public void storeCredentials(String str, UserCredentials userCredentials) throws IOException {
        Date expirationTime;
        List<String> scopes;
        String tokenValue;
        if (this.tokenStore == null) {
            throw new IllegalStateException("Cannot store tokens if tokenStore is not specified.");
        }
        AccessToken accessToken = userCredentials.getAccessToken();
        ArrayList arrayList = new ArrayList();
        if (accessToken != null) {
            tokenValue = accessToken.getTokenValue();
            expirationTime = accessToken.getExpirationTime();
            scopes = accessToken.getScopes();
        } else {
            expirationTime = null;
            scopes = arrayList;
            tokenValue = null;
        }
        String refreshToken = userCredentials.getRefreshToken();
        GenericJson genericJson = new GenericJson();
        genericJson.setFactory(OAuth2Utils.JSON_FACTORY);
        genericJson.put("access_token", (Object) tokenValue);
        genericJson.put("scope", (Object) scopes);
        genericJson.put("expiration_time_millis", (Object) Long.valueOf(expirationTime.getTime()));
        if (refreshToken != null) {
            genericJson.put("refresh_token", (Object) refreshToken);
        }
        this.tokenStore.store(str, genericJson.toString());
    }

    protected void monitorCredentials(String str, UserCredentials userCredentials) {
        userCredentials.addChangeListener(new UserCredentialsListener(str));
    }

    private TokenResponseWithConfig getCredentialsFromCodeInternal(String str, URI uri, Map<String, String> map) throws IOException {
        Preconditions.checkNotNull(str);
        URI callbackUri = getCallbackUri(uri);
        GenericData genericData = new GenericData();
        genericData.put("code", (Object) str);
        genericData.put("client_id", (Object) this.clientId.getClientId());
        genericData.put("redirect_uri", (Object) callbackUri);
        genericData.put("grant_type", (Object) "authorization_code");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                genericData.put(entry.getKey(), (Object) entry.getValue());
            }
        }
        PKCEProvider pKCEProvider = this.pkce;
        if (pKCEProvider != null) {
            genericData.put("code_verifier", (Object) pKCEProvider.getCodeVerifier());
        }
        if (this.clientAuthenticationType == ClientAuthenticationType.CLIENT_SECRET_POST) {
            genericData.put("client_secret", (Object) this.clientId.getClientSecret());
        }
        HttpRequest httpRequestBuildPostRequest = this.transportFactory.create().createRequestFactory().buildPostRequest(new GenericUrl(this.tokenServerUri), new UrlEncodedContent(genericData));
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
        if (this.clientAuthenticationType == ClientAuthenticationType.CLIENT_SECRET_BASIC) {
            httpRequestBuildPostRequest.getHeaders().setAuthorization(OAuth2Utils.generateBasicAuthHeader(this.clientId.getClientId(), this.clientId.getClientSecret()));
        }
        GenericJson genericJson = (GenericJson) httpRequestBuildPostRequest.execute().parseAs(GenericJson.class);
        String strValidateString = OAuth2Utils.validateString(genericJson, "access_token", "Error reading result of Token API:");
        Date date = new Date(new Date().getTime() + ((long) (OAuth2Utils.validateInt32(genericJson, "expires_in", "Error reading result of Token API:") * 1000)));
        AccessToken accessTokenBuild = AccessToken.newBuilder().setExpirationTime(date).setTokenValue(strValidateString).setScopes(OAuth2Utils.validateOptionalString(genericJson, "scope", "Error reading result of Token API:")).build();
        return TokenResponseWithConfig.newBuilder().setClientId(this.clientId.getClientId()).setClientSecret(this.clientId.getClientSecret()).setAccessToken(accessTokenBuild).setRefreshToken(OAuth2Utils.validateOptionalString(genericJson, "refresh_token", "Error reading result of Token API:")).setHttpTransportFactory(this.transportFactory).setTokenServerUri(this.tokenServerUri).build();
    }

    private class UserCredentialsListener implements OAuth2Credentials.CredentialsChangedListener {
        private final String userId;

        public UserCredentialsListener(String str) {
            this.userId = str;
        }

        @Override // com.google.auth.oauth2.OAuth2Credentials.CredentialsChangedListener
        public void onChanged(OAuth2Credentials oAuth2Credentials) throws IOException {
            UserAuthorizer.this.storeCredentials(this.userId, (UserCredentials) oAuth2Credentials);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public static class Builder {
        private URI callbackUri;
        private ClientAuthenticationType clientAuthenticationType;
        private ClientId clientId;
        private PKCEProvider pkce;
        private Collection<String> scopes;
        private URI tokenServerUri;
        private TokenStore tokenStore;
        private HttpTransportFactory transportFactory;
        private URI userAuthUri;

        protected Builder() {
        }

        protected Builder(UserAuthorizer userAuthorizer) {
            this.clientId = userAuthorizer.clientId;
            this.scopes = userAuthorizer.scopes;
            this.transportFactory = userAuthorizer.transportFactory;
            this.tokenServerUri = userAuthorizer.tokenServerUri;
            this.tokenStore = userAuthorizer.tokenStore;
            this.callbackUri = userAuthorizer.callbackUri;
            this.userAuthUri = userAuthorizer.userAuthUri;
            this.pkce = new DefaultPKCEProvider();
            this.clientAuthenticationType = userAuthorizer.clientAuthenticationType;
        }

        public Builder setClientId(ClientId clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder setTokenStore(TokenStore tokenStore) {
            this.tokenStore = tokenStore;
            return this;
        }

        public Builder setScopes(Collection<String> collection) {
            this.scopes = collection;
            return this;
        }

        public Builder setTokenServerUri(URI uri) {
            this.tokenServerUri = uri;
            return this;
        }

        public Builder setCallbackUri(URI uri) {
            this.callbackUri = uri;
            return this;
        }

        public Builder setUserAuthUri(URI uri) {
            this.userAuthUri = uri;
            return this;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.transportFactory = httpTransportFactory;
            return this;
        }

        public Builder setPKCEProvider(PKCEProvider pKCEProvider) {
            if (pKCEProvider != null && (pKCEProvider.getCodeChallenge() == null || pKCEProvider.getCodeVerifier() == null || pKCEProvider.getCodeChallengeMethod() == null)) {
                throw new IllegalArgumentException("PKCE provider contained null implementations. PKCE object must implement all PKCEProvider methods.");
            }
            this.pkce = pKCEProvider;
            return this;
        }

        public Builder setClientAuthenticationType(ClientAuthenticationType clientAuthenticationType) {
            this.clientAuthenticationType = clientAuthenticationType;
            return this;
        }

        public ClientId getClientId() {
            return this.clientId;
        }

        public TokenStore getTokenStore() {
            return this.tokenStore;
        }

        public Collection<String> getScopes() {
            return this.scopes;
        }

        public URI getTokenServerUri() {
            return this.tokenServerUri;
        }

        public URI getCallbackUri() {
            return this.callbackUri;
        }

        public URI getUserAuthUri() {
            return this.userAuthUri;
        }

        public HttpTransportFactory getHttpTransportFactory() {
            return this.transportFactory;
        }

        public PKCEProvider getPKCEProvider() {
            return this.pkce;
        }

        public ClientAuthenticationType getClientAuthenticationType() {
            return this.clientAuthenticationType;
        }

        public UserAuthorizer build() {
            return new UserAuthorizer(this);
        }
    }

    public static class TokenResponseWithConfig {
        private final AccessToken accessToken;
        private final String clientId;
        private final String clientSecret;
        private final HttpTransportFactory httpTransportFactory;
        private final String refreshToken;
        private URI tokenServerUri;

        private TokenResponseWithConfig(Builder builder) {
            this.clientId = builder.clientId;
            this.clientSecret = builder.clientSecret;
            this.accessToken = builder.accessToken;
            this.httpTransportFactory = builder.httpTransportFactory;
            this.tokenServerUri = builder.tokenServerUri;
            this.refreshToken = builder.refreshToken;
        }

        public String getClientId() {
            return this.clientId;
        }

        public String getClientSecret() {
            return this.clientSecret;
        }

        public AccessToken getAccessToken() {
            return this.accessToken;
        }

        public HttpTransportFactory getHttpTransportFactory() {
            return this.httpTransportFactory;
        }

        public URI getTokenServerUri() {
            return this.tokenServerUri;
        }

        @Nullable
        public String getRefreshToken() {
            return this.refreshToken;
        }

        static Builder newBuilder() {
            return new Builder();
        }

        static class Builder {
            private AccessToken accessToken;
            private String clientId;
            private String clientSecret;
            private HttpTransportFactory httpTransportFactory;
            private String refreshToken;
            private URI tokenServerUri;

            Builder() {
            }

            Builder setClientId(String str) {
                this.clientId = str;
                return this;
            }

            Builder setClientSecret(String str) {
                this.clientSecret = str;
                return this;
            }

            Builder setRefreshToken(String str) {
                this.refreshToken = str;
                return this;
            }

            Builder setAccessToken(AccessToken accessToken) {
                this.accessToken = accessToken;
                return this;
            }

            Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
                this.httpTransportFactory = httpTransportFactory;
                return this;
            }

            Builder setTokenServerUri(URI uri) {
                this.tokenServerUri = uri;
                return this;
            }

            TokenResponseWithConfig build() {
                return new TokenResponseWithConfig(this);
            }
        }
    }
}
