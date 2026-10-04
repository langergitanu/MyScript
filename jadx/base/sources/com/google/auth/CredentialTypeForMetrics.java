package com.google.auth;

/* JADX INFO: loaded from: classes6.dex */
public enum CredentialTypeForMetrics {
    USER_CREDENTIALS("u"),
    SERVICE_ACCOUNT_CREDENTIALS_AT("sa"),
    SERVICE_ACCOUNT_CREDENTIALS_JWT("jwt"),
    VM_CREDENTIALS("mds"),
    IMPERSONATED_CREDENTIALS("imp"),
    DO_NOT_SEND("dns");

    private final String label;

    CredentialTypeForMetrics(String str) {
        this.label = str;
    }

    public String getLabel() {
        return this.label;
    }
}
