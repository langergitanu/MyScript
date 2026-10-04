package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.GetSharedLinkMetadataArg;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserGetSharedLinkMetadataBuilder {
    private final GetSharedLinkMetadataArg.Builder _builder;
    private final DbxUserSharingRequests _client;

    DbxUserGetSharedLinkMetadataBuilder(DbxUserSharingRequests dbxUserSharingRequests, GetSharedLinkMetadataArg.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DbxUserGetSharedLinkMetadataBuilder withPath(String str) {
        this._builder.withPath(str);
        return this;
    }

    public DbxUserGetSharedLinkMetadataBuilder withLinkPassword(String str) {
        this._builder.withLinkPassword(str);
        return this;
    }

    public SharedLinkMetadata start() throws DbxException {
        return this._client.getSharedLinkMetadata(this._builder.build());
    }
}
