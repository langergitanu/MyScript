package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.GetSharedLinkMetadataArg;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAppGetSharedLinkMetadataBuilder {
    private final GetSharedLinkMetadataArg.Builder _builder;
    private final DbxAppSharingRequests _client;

    DbxAppGetSharedLinkMetadataBuilder(DbxAppSharingRequests dbxAppSharingRequests, GetSharedLinkMetadataArg.Builder builder) {
        if (dbxAppSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxAppSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DbxAppGetSharedLinkMetadataBuilder withPath(String str) {
        this._builder.withPath(str);
        return this;
    }

    public DbxAppGetSharedLinkMetadataBuilder withLinkPassword(String str) {
        this._builder.withLinkPassword(str);
        return this;
    }

    public SharedLinkMetadata start() throws DbxException {
        return this._client.getSharedLinkMetadata(this._builder.build());
    }
}
