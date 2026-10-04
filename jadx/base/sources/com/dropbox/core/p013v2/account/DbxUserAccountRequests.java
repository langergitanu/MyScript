package com.dropbox.core.p013v2.account;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.account.SetProfilePhotoArg;
import com.dropbox.core.p013v2.account.SetProfilePhotoError;
import com.dropbox.core.p013v2.account.SetProfilePhotoResult;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserAccountRequests {
    private final DbxRawClientV2 client;

    public DbxUserAccountRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    SetProfilePhotoResult setProfilePhoto(SetProfilePhotoArg setProfilePhotoArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SetProfilePhotoResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/account/set_profile_photo", setProfilePhotoArg, false, SetProfilePhotoArg.Serializer.INSTANCE, SetProfilePhotoResult.Serializer.INSTANCE, SetProfilePhotoError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SetProfilePhotoErrorException("2/account/set_profile_photo", e.getRequestId(), e.getUserMessage(), (SetProfilePhotoError) e.getErrorValue());
        }
    }

    public SetProfilePhotoResult setProfilePhoto(PhotoSourceArg photoSourceArg) throws DbxException {
        return setProfilePhoto(new SetProfilePhotoArg(photoSourceArg));
    }
}
