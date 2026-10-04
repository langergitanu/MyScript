package com.dropbox.core.p013v2.openid;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.openid.UserInfoArgs;
import com.dropbox.core.p013v2.openid.UserInfoError;
import com.dropbox.core.p013v2.openid.UserInfoResult;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserOpenidRequests {
    private final DbxRawClientV2 client;

    public DbxUserOpenidRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    UserInfoResult userinfo(UserInfoArgs userInfoArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (UserInfoResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/openid/userinfo", userInfoArgs, false, UserInfoArgs.Serializer.INSTANCE, UserInfoResult.Serializer.INSTANCE, UserInfoError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new UserInfoErrorException("2/openid/userinfo", e.getRequestId(), e.getUserMessage(), (UserInfoError) e.getErrorValue());
        }
    }

    public UserInfoResult userinfo() throws DbxException {
        return userinfo(new UserInfoArgs());
    }
}
