package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxDownloadStyleBuilder;
import com.dropbox.core.p013v2.files.ThumbnailV2Arg;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAppGetThumbnailV2Builder extends DbxDownloadStyleBuilder<PreviewResult> {
    private final ThumbnailV2Arg.Builder _builder;
    private final DbxAppFilesRequests _client;

    DbxAppGetThumbnailV2Builder(DbxAppFilesRequests dbxAppFilesRequests, ThumbnailV2Arg.Builder builder) {
        if (dbxAppFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxAppFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DbxAppGetThumbnailV2Builder withFormat(ThumbnailFormat thumbnailFormat) {
        this._builder.withFormat(thumbnailFormat);
        return this;
    }

    public DbxAppGetThumbnailV2Builder withSize(ThumbnailSize thumbnailSize) {
        this._builder.withSize(thumbnailSize);
        return this;
    }

    public DbxAppGetThumbnailV2Builder withMode(ThumbnailMode thumbnailMode) {
        this._builder.withMode(thumbnailMode);
        return this;
    }

    @Override // com.dropbox.core.p013v2.DbxDownloadStyleBuilder
    public DbxDownloader<PreviewResult> start() throws DbxException {
        return this._client.getThumbnailV2(this._builder.build(), getHeaders());
    }
}
