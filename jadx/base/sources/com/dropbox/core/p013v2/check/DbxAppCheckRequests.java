package com.dropbox.core.p013v2.check;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.check.EchoArg;
import com.dropbox.core.p013v2.check.EchoResult;
import com.dropbox.core.stone.StoneSerializers;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAppCheckRequests {
    private final DbxRawClientV2 client;

    public DbxAppCheckRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    EchoResult app(EchoArg echoArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (EchoResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/check/app", echoArg, false, EchoArg.Serializer.INSTANCE, EchoResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"app\":" + e.getErrorValue());
        }
    }

    public EchoResult app() throws DbxException {
        return app(new EchoArg());
    }

    public EchoResult app(String str) throws DbxException {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        if (str.length() > 500) {
            throw new IllegalArgumentException("String 'query' is longer than 500");
        }
        return app(new EchoArg(str));
    }
}
