package com.google.auth;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Credentials implements Serializable {
    public static final String GOOGLE_DEFAULT_UNIVERSE = "googleapis.com";
    private static final long serialVersionUID = 808575179767517313L;

    public abstract String getAuthenticationType();

    public abstract Map<String, List<String>> getRequestMetadata(URI uri) throws IOException;

    public abstract boolean hasRequestMetadata();

    public abstract boolean hasRequestMetadataOnly();

    public abstract void refresh() throws IOException;

    public String getUniverseDomain() throws IOException {
        return GOOGLE_DEFAULT_UNIVERSE;
    }

    public CredentialTypeForMetrics getMetricsCredentialType() {
        return CredentialTypeForMetrics.DO_NOT_SEND;
    }

    public Map<String, List<String>> getRequestMetadata() throws IOException {
        return getRequestMetadata(null);
    }

    public void getRequestMetadata(final URI uri, Executor executor, final RequestMetadataCallback requestMetadataCallback) {
        executor.execute(new Runnable() { // from class: com.google.auth.Credentials.1
            @Override // java.lang.Runnable
            public void run() {
                Credentials.this.blockingGetToCallback(uri, requestMetadataCallback);
            }
        });
    }

    protected final void blockingGetToCallback(URI uri, RequestMetadataCallback requestMetadataCallback) {
        try {
            requestMetadataCallback.onSuccess(getRequestMetadata(uri));
        } catch (Throwable th) {
            requestMetadataCallback.onFailure(th);
        }
    }
}
