package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxDownloadStyleBuilder;

/* JADX INFO: loaded from: classes4.dex */
public class ExportBuilder extends DbxDownloadStyleBuilder<ExportResult> {
    private final DbxUserFilesRequests _client;
    private String exportFormat;
    private final String path;

    ExportBuilder(DbxUserFilesRequests dbxUserFilesRequests, String str) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        this.path = str;
        this.exportFormat = null;
    }

    public ExportBuilder withExportFormat(String str) {
        this.exportFormat = str;
        return this;
    }

    @Override // com.dropbox.core.p013v2.DbxDownloadStyleBuilder
    public DbxDownloader<ExportResult> start() throws DbxException {
        return this._client.export(new ExportArg(this.path, this.exportFormat), getHeaders());
    }
}
