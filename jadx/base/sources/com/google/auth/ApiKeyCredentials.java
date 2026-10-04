package com.google.auth;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ApiKeyCredentials extends Credentials {
    static final String API_KEY_HEADER_KEY = "x-goog-api-key";
    private final String apiKey;

    @Override // com.google.auth.Credentials
    public boolean hasRequestMetadata() {
        return true;
    }

    @Override // com.google.auth.Credentials
    public boolean hasRequestMetadataOnly() {
        return true;
    }

    @Override // com.google.auth.Credentials
    public void refresh() throws IOException {
    }

    ApiKeyCredentials(String str) {
        this.apiKey = str;
    }

    public static ApiKeyCredentials create(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("API key cannot be null or blank");
        }
        return new ApiKeyCredentials(str);
    }

    @Override // com.google.auth.Credentials
    public String getAuthenticationType() {
        return "API-Key";
    }

    @Override // com.google.auth.Credentials
    public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
        return Collections.singletonMap(API_KEY_HEADER_KEY, Collections.singletonList(this.apiKey));
    }
}
