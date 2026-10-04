package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxDownloadStyleBuilder;
import com.dropbox.core.p013v2.files.ThumbnailArg;

/* JADX INFO: loaded from: classes4.dex */
public class GetThumbnailBuilder extends DbxDownloadStyleBuilder<FileMetadata> {
    private final ThumbnailArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    GetThumbnailBuilder(DbxUserFilesRequests dbxUserFilesRequests, ThumbnailArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public GetThumbnailBuilder withFormat(ThumbnailFormat thumbnailFormat) {
        this._builder.withFormat(thumbnailFormat);
        return this;
    }

    public GetThumbnailBuilder withSize(ThumbnailSize thumbnailSize) {
        this._builder.withSize(thumbnailSize);
        return this;
    }

    public GetThumbnailBuilder withMode(ThumbnailMode thumbnailMode) {
        this._builder.withMode(thumbnailMode);
        return this;
    }

    @Override // com.dropbox.core.p013v2.DbxDownloadStyleBuilder
    public DbxDownloader<FileMetadata> start() throws DbxException {
        return this._client.getThumbnail(this._builder.build(), getHeaders());
    }
}
