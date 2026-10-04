package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffIOExceptionHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.GenericData;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.MetricsUtils;
import com.google.common.p018io.BaseEncoding;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
class IamUtils {
    static final Set<Integer> IAM_RETRYABLE_STATUS_CODES = new HashSet(Arrays.asList(500, 502, 503, 504));
    private static final String ID_TOKEN_URL_FORMAT = "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/%s:generateIdToken";
    private static final String PARSE_ERROR_MESSAGE = "Error parsing error message response. ";
    private static final String PARSE_ERROR_SIGNATURE = "Error parsing signature response. ";
    private static final String SIGN_BLOB_URL_FORMAT = "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/%s:signBlob";

    IamUtils() {
    }

    static byte[] sign(String str, Credentials credentials, HttpTransport httpTransport, byte[] bArr, Map<String, ?> map) {
        BaseEncoding baseEncodingBase64 = BaseEncoding.base64();
        try {
            return baseEncodingBase64.decode(getSignature(str, baseEncodingBase64.encode(bArr), map, httpTransport.createRequestFactory(new HttpCredentialsAdapter(credentials))));
        } catch (IOException e) {
            throw new ServiceAccountSigner.SigningException("Failed to sign the provided bytes", e);
        }
    }

    private static String getSignature(String str, String str2, Map<String, ?> map, HttpRequestFactory httpRequestFactory) throws IOException {
        GenericUrl genericUrl = new GenericUrl(String.format(SIGN_BLOB_URL_FORMAT, str));
        GenericData genericData = new GenericData();
        genericData.set("payload", str2);
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            genericData.set(entry.getKey(), entry.getValue());
        }
        HttpRequest httpRequestBuildPostRequest = httpRequestFactory.buildPostRequest(genericUrl, new JsonHttpContent(OAuth2Utils.JSON_FACTORY, genericData));
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
        httpRequestBuildPostRequest.setThrowExceptionOnExecuteError(false);
        httpRequestBuildPostRequest.setNumberOfRetries(3);
        ExponentialBackOff exponentialBackOffBuild = new ExponentialBackOff.Builder().setInitialIntervalMillis(1000).setRandomizationFactor(0.1d).setMultiplier(2.0d).build();
        httpRequestBuildPostRequest.setUnsuccessfulResponseHandler(new HttpBackOffUnsuccessfulResponseHandler(exponentialBackOffBuild).setBackOffRequired(new HttpBackOffUnsuccessfulResponseHandler.BackOffRequired() { // from class: com.google.auth.oauth2.IamUtils$$ExternalSyntheticLambda0
            @Override // com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired
            public final boolean isRequired(HttpResponse httpResponse) {
                return IamUtils.IAM_RETRYABLE_STATUS_CODES.contains(Integer.valueOf(httpResponse.getStatusCode()));
            }
        }));
        httpRequestBuildPostRequest.setIOExceptionHandler(new HttpBackOffIOExceptionHandler(exponentialBackOffBuild));
        HttpResponse httpResponseExecute = httpRequestBuildPostRequest.execute();
        int statusCode = httpResponseExecute.getStatusCode();
        if (statusCode >= 400 && statusCode < 500) {
            throw new IOException(String.format("Error code %s trying to sign provided bytes: %s", Integer.valueOf(statusCode), OAuth2Utils.validateString(OAuth2Utils.validateMap((GenericData) httpResponseExecute.parseAs(GenericData.class), "error", PARSE_ERROR_MESSAGE), "message", PARSE_ERROR_MESSAGE)));
        }
        if (statusCode != 200) {
            throw new IOException(String.format("Unexpected Error code %s trying to sign provided bytes: %s", Integer.valueOf(statusCode), httpResponseExecute.parseAsString()));
        }
        if (httpResponseExecute.getContent() == null) {
            throw new IOException("Empty content from sign blob server request.");
        }
        return OAuth2Utils.validateString((GenericData) httpResponseExecute.parseAs(GenericData.class), "signedBlob", PARSE_ERROR_SIGNATURE);
    }

    static IdToken getIdToken(String str, Credentials credentials, HttpTransport httpTransport, String str2, boolean z, Map<String, ?> map, CredentialTypeForMetrics credentialTypeForMetrics) throws IOException {
        GenericUrl genericUrl = new GenericUrl(String.format(ID_TOKEN_URL_FORMAT, str));
        GenericData genericData = new GenericData();
        genericData.set("audience", str2);
        genericData.set("includeEmail", Boolean.valueOf(z));
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            genericData.set(entry.getKey(), entry.getValue());
        }
        HttpRequest httpRequestBuildPostRequest = httpTransport.createRequestFactory(new HttpCredentialsAdapter(credentials)).buildPostRequest(genericUrl, new JsonHttpContent(OAuth2Utils.JSON_FACTORY, genericData));
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
        httpRequestBuildPostRequest.setThrowExceptionOnExecuteError(false);
        MetricsUtils.setMetricsHeader(httpRequestBuildPostRequest, MetricsUtils.getGoogleCredentialsMetricsHeader(MetricsUtils.RequestType.ID_TOKEN_REQUEST, credentialTypeForMetrics));
        HttpResponse httpResponseExecute = httpRequestBuildPostRequest.execute();
        int statusCode = httpResponseExecute.getStatusCode();
        if (statusCode >= 400 && statusCode < 500) {
            throw new IOException(String.format("Error code %s trying to getIDToken: %s", Integer.valueOf(statusCode), OAuth2Utils.validateString(OAuth2Utils.validateMap((GenericData) httpResponseExecute.parseAs(GenericData.class), "error", PARSE_ERROR_MESSAGE), "message", PARSE_ERROR_MESSAGE)));
        }
        if (statusCode != 200) {
            throw new IOException(String.format("Unexpected Error code %s trying to getIDToken: %s", Integer.valueOf(statusCode), httpResponseExecute.parseAsString()));
        }
        if (httpResponseExecute.getContent() == null) {
            throw new IOException("Empty content from generateIDToken server request.");
        }
        return IdToken.create(OAuth2Utils.validateString((GenericJson) httpResponseExecute.parseAs(GenericJson.class), "token", PARSE_ERROR_MESSAGE));
    }
}
