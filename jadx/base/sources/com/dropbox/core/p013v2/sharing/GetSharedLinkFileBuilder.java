package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxDownloadStyleBuilder;
import com.dropbox.core.p013v2.sharing.GetSharedLinkMetadataArg;

/* JADX INFO: loaded from: classes4.dex */
public class GetSharedLinkFileBuilder extends DbxDownloadStyleBuilder<SharedLinkMetadata> {
    private final GetSharedLinkMetadataArg.Builder _builder;
    private final DbxUserSharingRequests _client;

    GetSharedLinkFileBuilder(DbxUserSharingRequests dbxUserSharingRequests, GetSharedLinkMetadataArg.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public GetSharedLinkFileBuilder withPath(String str) {
        this._builder.withPath(str);
        return this;
    }

    public GetSharedLinkFileBuilder withLinkPassword(String str) {
        this._builder.withLinkPassword(str);
        return this;
    }

    @Override // com.dropbox.core.p013v2.DbxDownloadStyleBuilder
    public DbxDownloader<SharedLinkMetadata> start() throws DbxException {
        return this._client.getSharedLinkFile(this._builder.build(), getHeaders());
    }
}
