package com.dropbox.core;

import com.dropbox.core.p013v2.auth.AuthError;

/* JADX INFO: loaded from: classes4.dex */
public class InvalidAccessTokenException extends DbxException {
    private static final long serialVersionUID = 0;
    private AuthError authError;

    public InvalidAccessTokenException(String str, String str2, AuthError authError) {
        super(str, str2);
        this.authError = authError;
    }

    public AuthError getAuthError() {
        return this.authError;
    }
}
