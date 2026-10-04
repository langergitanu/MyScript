package com.dropbox.core.p013v2.auth;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.auth.TokenFromOAuth1Arg;
import com.dropbox.core.p013v2.auth.TokenFromOAuth1Error;
import com.dropbox.core.p013v2.auth.TokenFromOAuth1Result;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAppAuthRequests {
    private final DbxRawClientV2 client;

    public DbxAppAuthRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    TokenFromOAuth1Result tokenFromOauth1(TokenFromOAuth1Arg tokenFromOAuth1Arg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TokenFromOAuth1Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/auth/token/from_oauth1", tokenFromOAuth1Arg, false, TokenFromOAuth1Arg.Serializer.INSTANCE, TokenFromOAuth1Result.Serializer.INSTANCE, TokenFromOAuth1Error.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TokenFromOAuth1ErrorException("2/auth/token/from_oauth1", e.getRequestId(), e.getUserMessage(), (TokenFromOAuth1Error) e.getErrorValue());
        }
    }

    @Deprecated
    public TokenFromOAuth1Result tokenFromOauth1(String str, String str2) throws DbxException {
        return tokenFromOauth1(new TokenFromOAuth1Arg(str, str2));
    }
}
