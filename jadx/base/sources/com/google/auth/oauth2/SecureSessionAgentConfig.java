package com.google.auth.oauth2;

/* JADX INFO: loaded from: classes6.dex */
public class SecureSessionAgentConfig {
    private final String mtlsAddress;
    private final String plaintextAddress;

    public static Builder createBuilder() {
        return new Builder();
    }

    public String getPlaintextAddress() {
        return this.plaintextAddress;
    }

    public String getMtlsAddress() {
        return this.mtlsAddress;
    }

    public static final class Builder {
        private String plaintextAddress = "";
        private String mtlsAddress = "";

        Builder() {
        }

        public Builder setPlaintextAddress(String str) {
            this.plaintextAddress = str;
            return this;
        }

        public Builder setMtlsAddress(String str) {
            this.mtlsAddress = str;
            return this;
        }

        public SecureSessionAgentConfig build() {
            return new SecureSessionAgentConfig(this.plaintextAddress, this.mtlsAddress);
        }
    }

    private SecureSessionAgentConfig(String str, String str2) {
        this.plaintextAddress = str;
        this.mtlsAddress = str2;
    }
}
