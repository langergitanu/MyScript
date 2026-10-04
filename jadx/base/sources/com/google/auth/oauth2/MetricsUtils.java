package com.google.auth.oauth2;

import com.google.api.client.http.HttpRequest;
import com.google.auth.CredentialTypeForMetrics;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes6.dex */
class MetricsUtils {
    static final String API_CLIENT_HEADER = "x-goog-api-client";
    static final String AUTH_REQUEST_TYPE = "auth-request-type";
    static final String CRED_TYPE = "cred-type";
    private static final String authLibraryVersion = getAuthLibraryVersion();
    private static final String javaLanguageVersion = System.getProperty("java.version");

    MetricsUtils() {
    }

    static String getLanguageAndAuthLibraryVersions() {
        return String.format("gl-java/%s auth/%s", javaLanguageVersion, authLibraryVersion);
    }

    private static String getAuthLibraryVersion() {
        String property = "unknown-version";
        try {
            InputStream resourceAsStream = MetricsUtils.class.getResourceAsStream("/com/google/auth/oauth2/google-auth-library.properties");
            if (resourceAsStream != null) {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    property = properties.getProperty("google-auth-library.version");
                } finally {
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (IOException unused) {
        }
        return property;
    }

    public enum RequestType {
        ACCESS_TOKEN_REQUEST("at"),
        ID_TOKEN_REQUEST("it"),
        METADATA_SERVER_PING("mds"),
        UNTRACKED("untracked");

        private final String label;

        RequestType(String str) {
            this.label = str;
        }

        public String getLabel() {
            return this.label;
        }
    }

    static String getGoogleCredentialsMetricsHeader(RequestType requestType, CredentialTypeForMetrics credentialTypeForMetrics) {
        StringBuilder sb = new StringBuilder(getLanguageAndAuthLibraryVersions());
        if (requestType != RequestType.UNTRACKED) {
            sb.append(String.format(" %s/%s", AUTH_REQUEST_TYPE, requestType.getLabel()));
        }
        if (credentialTypeForMetrics != CredentialTypeForMetrics.DO_NOT_SEND) {
            sb.append(String.format(" %s/%s", CRED_TYPE, credentialTypeForMetrics.getLabel()));
        }
        return sb.toString();
    }

    static void setMetricsHeader(HttpRequest httpRequest, String str) {
        httpRequest.getHeaders().set(API_CLIENT_HEADER, (Object) str);
    }
}
