package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.CreateSharedLinkArg;

/* JADX INFO: loaded from: classes4.dex */
public class CreateSharedLinkBuilder {
    private final CreateSharedLinkArg.Builder _builder;
    private final DbxUserSharingRequests _client;

    CreateSharedLinkBuilder(DbxUserSharingRequests dbxUserSharingRequests, CreateSharedLinkArg.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public CreateSharedLinkBuilder withShortUrl(Boolean bool) {
        this._builder.withShortUrl(bool);
        return this;
    }

    public CreateSharedLinkBuilder withPendingUpload(PendingUploadMode pendingUploadMode) {
        this._builder.withPendingUpload(pendingUploadMode);
        return this;
    }

    public PathLinkMetadata start() throws DbxException {
        return this._client.createSharedLink(this._builder.build());
    }
}
