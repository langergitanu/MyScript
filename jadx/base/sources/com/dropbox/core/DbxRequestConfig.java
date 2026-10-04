package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.http.StandardHttpRequestor;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class DbxRequestConfig {
    private final String clientIdentifier;
    private final HttpRequestor httpRequestor;
    private final int maxRetries;
    private final String userLocale;

    private DbxRequestConfig(String str, String str2, HttpRequestor httpRequestor, int i) {
        if (str == null) {
            throw new NullPointerException("clientIdentifier");
        }
        if (httpRequestor == null) {
            throw new NullPointerException("httpRequestor");
        }
        if (i < 0) {
            throw new IllegalArgumentException("maxRetries");
        }
        this.clientIdentifier = str;
        this.userLocale = toLanguageTag(str2);
        this.httpRequestor = httpRequestor;
        this.maxRetries = i;
    }

    public DbxRequestConfig(String str) {
        this(str, null);
    }

    @Deprecated
    public DbxRequestConfig(String str, String str2) {
        this(str, str2, StandardHttpRequestor.INSTANCE);
    }

    @Deprecated
    public DbxRequestConfig(String str, String str2, HttpRequestor httpRequestor) {
        this(str, str2, httpRequestor, 0);
    }

    public String getClientIdentifier() {
        return this.clientIdentifier;
    }

    public String getUserLocale() {
        return this.userLocale;
    }

    public HttpRequestor getHttpRequestor() {
        return this.httpRequestor;
    }

    public boolean isAutoRetryEnabled() {
        return this.maxRetries > 0;
    }

    public int getMaxRetries() {
        return this.maxRetries;
    }

    public Builder copy() {
        return new Builder(this.clientIdentifier, this.userLocale, this.httpRequestor, this.maxRetries);
    }

    public static Builder newBuilder(String str) {
        if (str == null) {
            throw new NullPointerException("clientIdentifier");
        }
        return new Builder(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String toLanguageTag(Locale locale) {
        if (locale == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage().toLowerCase());
        if (!locale.getCountry().isEmpty()) {
            sb.append("-");
            sb.append(locale.getCountry().toUpperCase());
        }
        return sb.toString();
    }

    private static String toLanguageTag(String str) {
        if (str == null) {
            return null;
        }
        if (!str.contains("_") || str.startsWith("_")) {
            return str;
        }
        String[] strArrSplit = str.split("_", 3);
        return toLanguageTag(new Locale(strArrSplit[0], strArrSplit[1], strArrSplit.length == 3 ? strArrSplit[2] : ""));
    }

    public static final class Builder {
        private final String clientIdentifier;
        private HttpRequestor httpRequestor;
        private int maxRetries;
        private String userLocale;

        private Builder(String str, String str2, HttpRequestor httpRequestor, int i) {
            this.clientIdentifier = str;
            this.userLocale = str2;
            this.httpRequestor = httpRequestor;
            this.maxRetries = i;
        }

        private Builder(String str) {
            this.clientIdentifier = str;
            this.userLocale = null;
            this.httpRequestor = StandardHttpRequestor.INSTANCE;
            this.maxRetries = 0;
        }

        public Builder withUserLocale(String str) {
            this.userLocale = str;
            return this;
        }

        public Builder withUserLocaleFromPreferences() {
            this.userLocale = null;
            return this;
        }

        public Builder withUserLocaleFrom(Locale locale) {
            this.userLocale = DbxRequestConfig.toLanguageTag(locale);
            return this;
        }

        public Builder withHttpRequestor(HttpRequestor httpRequestor) {
            if (httpRequestor == null) {
                throw new NullPointerException("httpRequestor");
            }
            this.httpRequestor = httpRequestor;
            return this;
        }

        public Builder withAutoRetryEnabled() {
            return withAutoRetryEnabled(3);
        }

        public Builder withAutoRetryDisabled() {
            this.maxRetries = 0;
            return this;
        }

        public Builder withAutoRetryEnabled(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxRetries must be positive");
            }
            this.maxRetries = i;
            return this;
        }

        public DbxRequestConfig build() {
            return new DbxRequestConfig(this.clientIdentifier, this.userLocale, this.httpRequestor, this.maxRetries);
        }
    }
}
