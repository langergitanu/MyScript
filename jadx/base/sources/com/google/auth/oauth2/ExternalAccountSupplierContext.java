package com.google.auth.oauth2;

import com.google.auth.oauth2.ExternalAccountCredentials;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ExternalAccountSupplierContext implements Serializable {
    private static final long serialVersionUID = -7852130853542313494L;
    private final String audience;
    private final String subjectTokenType;

    private ExternalAccountSupplierContext(Builder builder) {
        this.audience = builder.audience;
        this.subjectTokenType = builder.subjectTokenType;
    }

    public String getAudience() {
        return this.audience;
    }

    public String getSubjectTokenType() {
        return this.subjectTokenType;
    }

    static Builder newBuilder() {
        return new Builder();
    }

    static class Builder {
        protected String audience;
        protected String subjectTokenType;

        Builder() {
        }

        Builder setAudience(String str) {
            this.audience = str;
            return this;
        }

        Builder setSubjectTokenType(String str) {
            this.subjectTokenType = str;
            return this;
        }

        Builder setSubjectTokenType(ExternalAccountCredentials.SubjectTokenTypes subjectTokenTypes) {
            this.subjectTokenType = subjectTokenTypes.value;
            return this;
        }

        ExternalAccountSupplierContext build() {
            return new ExternalAccountSupplierContext(this);
        }
    }
}
