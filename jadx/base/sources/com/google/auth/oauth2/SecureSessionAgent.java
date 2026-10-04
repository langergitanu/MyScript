package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffIOExceptionHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.GenericData;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class SecureSessionAgent {
    static final String GOOGLE = "Google";
    static final String METADATA_FLAVOR = "Metadata-Flavor";
    private static final String PARSE_ERROR_S2A = "Error parsing S2A Config from MDS JSON response.";
    static final String S2A_MTLS_ADDRESS_JSON_KEY = "mtls_address";
    static final String S2A_PLAINTEXT_ADDRESS_JSON_KEY = "plaintext_address";
    private transient HttpTransportFactory transportFactory;
    private static final Set<Integer> RETRYABLE_STATUS_CODES = new HashSet(Arrays.asList(500, 502, 503));
    static final String S2A_CONFIG_ENDPOINT_POSTFIX = "/computeMetadata/v1/instance/platform-security/auto-mtls-configuration";
    private static final String MDS_MTLS_ENDPOINT = ComputeEngineCredentials.getMetadataServerUrl() + S2A_CONFIG_ENDPOINT_POSTFIX;

    SecureSessionAgent(Builder builder) {
        this.transportFactory = builder.getHttpTransportFactory();
    }

    public SecureSessionAgentConfig getConfig() {
        return getSecureSessionAgentConfigFromMDS();
    }

    public static SecureSessionAgent create() {
        return newBuilder().build();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private HttpTransportFactory transportFactory;

        protected Builder() {
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.transportFactory = httpTransportFactory;
            return this;
        }

        public HttpTransportFactory getHttpTransportFactory() {
            return this.transportFactory;
        }

        public SecureSessionAgent build() {
            return new SecureSessionAgent(this);
        }
    }

    private SecureSessionAgentConfig getSecureSessionAgentConfigFromMDS() {
        String strValidateString;
        String strValidateString2 = "";
        if (this.transportFactory == null) {
            this.transportFactory = (HttpTransportFactory) Iterables.getFirst(ServiceLoader.load(HttpTransportFactory.class), OAuth2Utils.HTTP_TRANSPORT_FACTORY);
        }
        try {
            HttpRequest httpRequestBuildGetRequest = this.transportFactory.create().createRequestFactory().buildGetRequest(new GenericUrl(MDS_MTLS_ENDPOINT));
            httpRequestBuildGetRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
            httpRequestBuildGetRequest.getHeaders().set(METADATA_FLAVOR, (Object) GOOGLE);
            httpRequestBuildGetRequest.setThrowExceptionOnExecuteError(false);
            httpRequestBuildGetRequest.setNumberOfRetries(3);
            ExponentialBackOff exponentialBackOffBuild = new ExponentialBackOff.Builder().setInitialIntervalMillis(1000).setRandomizationFactor(0.1d).setMultiplier(2.0d).build();
            httpRequestBuildGetRequest.setUnsuccessfulResponseHandler(new HttpBackOffUnsuccessfulResponseHandler(exponentialBackOffBuild).setBackOffRequired(new HttpBackOffUnsuccessfulResponseHandler.BackOffRequired() { // from class: com.google.auth.oauth2.SecureSessionAgent$$ExternalSyntheticLambda0
                @Override // com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired
                public final boolean isRequired(HttpResponse httpResponse) {
                    return SecureSessionAgent.RETRYABLE_STATUS_CODES.contains(Integer.valueOf(httpResponse.getStatusCode()));
                }
            }));
            httpRequestBuildGetRequest.setIOExceptionHandler(new HttpBackOffIOExceptionHandler(exponentialBackOffBuild));
            try {
                HttpResponse httpResponseExecute = httpRequestBuildGetRequest.execute();
                if (httpResponseExecute.getContent() == null) {
                    return SecureSessionAgentConfig.createBuilder().build();
                }
                GenericData genericData = (GenericData) httpResponseExecute.parseAs(GenericData.class);
                try {
                    strValidateString = OAuth2Utils.validateString(genericData, S2A_PLAINTEXT_ADDRESS_JSON_KEY, PARSE_ERROR_S2A);
                } catch (IOException unused) {
                    strValidateString = "";
                }
                try {
                    strValidateString2 = OAuth2Utils.validateString(genericData, S2A_MTLS_ADDRESS_JSON_KEY, PARSE_ERROR_S2A);
                } catch (IOException unused2) {
                }
                return SecureSessionAgentConfig.createBuilder().setPlaintextAddress(strValidateString).setMtlsAddress(strValidateString2).build();
            } catch (IOException unused3) {
                return SecureSessionAgentConfig.createBuilder().build();
            }
        } catch (IOException unused4) {
            return SecureSessionAgentConfig.createBuilder().build();
        }
    }
}
