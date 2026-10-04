package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxDownloadStyleBuilder;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadZipBuilder extends DbxDownloadStyleBuilder<DownloadZipResult> {
    private final DbxUserFilesRequests _client;
    private final String path;

    DownloadZipBuilder(DbxUserFilesRequests dbxUserFilesRequests, String str) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        this.path = str;
    }

    @Override // com.dropbox.core.p013v2.DbxDownloadStyleBuilder
    public DbxDownloader<DownloadZipResult> start() throws DbxException {
        return this._client.downloadZip(new DownloadZipArg(this.path), getHeaders());
    }
}
