package com.dropbox.core;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxOAuth1AccessToken {
    private final String key;
    private final String secret;

    public DbxOAuth1AccessToken(String str, String str2) {
        this.key = str;
        this.secret = str2;
    }

    public String getKey() {
        return this.key;
    }

    public String getSecret() {
        return this.secret;
    }
}
