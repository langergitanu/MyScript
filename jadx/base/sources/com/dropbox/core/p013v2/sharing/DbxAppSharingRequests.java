package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.sharing.GetSharedLinkMetadataArg;
import com.dropbox.core.p013v2.sharing.SharedLinkError;
import com.dropbox.core.p013v2.sharing.SharedLinkMetadata;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAppSharingRequests {
    private final DbxRawClientV2 client;

    public DbxAppSharingRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    SharedLinkMetadata getSharedLinkMetadata(GetSharedLinkMetadataArg getSharedLinkMetadataArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedLinkMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/get_shared_link_metadata", getSharedLinkMetadataArg, false, GetSharedLinkMetadataArg.Serializer.INSTANCE, SharedLinkMetadata.Serializer.INSTANCE, SharedLinkError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharedLinkErrorException("2/sharing/get_shared_link_metadata", e.getRequestId(), e.getUserMessage(), (SharedLinkError) e.getErrorValue());
        }
    }

    public SharedLinkMetadata getSharedLinkMetadata(String str) throws DbxException {
        return getSharedLinkMetadata(new GetSharedLinkMetadataArg(str));
    }

    public DbxAppGetSharedLinkMetadataBuilder getSharedLinkMetadataBuilder(String str) {
        return new DbxAppGetSharedLinkMetadataBuilder(this, GetSharedLinkMetadataArg.newBuilder(str));
    }
}
