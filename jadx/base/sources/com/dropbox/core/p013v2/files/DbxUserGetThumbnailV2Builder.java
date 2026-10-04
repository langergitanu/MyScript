package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxDownloadStyleBuilder;
import com.dropbox.core.p013v2.files.ThumbnailV2Arg;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserGetThumbnailV2Builder extends DbxDownloadStyleBuilder<PreviewResult> {
    private final ThumbnailV2Arg.Builder _builder;
    private final DbxUserFilesRequests _client;

    DbxUserGetThumbnailV2Builder(DbxUserFilesRequests dbxUserFilesRequests, ThumbnailV2Arg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DbxUserGetThumbnailV2Builder withFormat(ThumbnailFormat thumbnailFormat) {
        this._builder.withFormat(thumbnailFormat);
        return this;
    }

    public DbxUserGetThumbnailV2Builder withSize(ThumbnailSize thumbnailSize) {
        this._builder.withSize(thumbnailSize);
        return this;
    }

    public DbxUserGetThumbnailV2Builder withMode(ThumbnailMode thumbnailMode) {
        this._builder.withMode(thumbnailMode);
        return this;
    }

    @Override // com.dropbox.core.p013v2.DbxDownloadStyleBuilder
    public DbxDownloader<PreviewResult> start() throws DbxException {
        return this._client.getThumbnailV2(this._builder.build(), getHeaders());
    }
}
