package com.dropbox.core.oauth;

import com.dropbox.core.DbxException;

/* JADX INFO: loaded from: classes4.dex */
public class DbxOAuthException extends DbxException {
    private static final long serialVersionUID = 0;
    private final DbxOAuthError dbxOAuthError;

    public DbxOAuthException(String str, DbxOAuthError dbxOAuthError) {
        super(str, dbxOAuthError.getErrorDescription());
        this.dbxOAuthError = dbxOAuthError;
    }

    public DbxOAuthError getDbxOAuthError() {
        return this.dbxOAuthError;
    }
}
