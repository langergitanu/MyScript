package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxDownloadStyleBuilder;

/* JADX INFO: loaded from: classes4.dex */
public class DocsDownloadBuilder extends DbxDownloadStyleBuilder<PaperDocExportResult> {
    private final DbxUserPaperRequests _client;
    private final String docId;
    private final ExportFormat exportFormat;

    DocsDownloadBuilder(DbxUserPaperRequests dbxUserPaperRequests, String str, ExportFormat exportFormat) {
        if (dbxUserPaperRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserPaperRequests;
        this.docId = str;
        this.exportFormat = exportFormat;
    }

    @Override // com.dropbox.core.p013v2.DbxDownloadStyleBuilder
    public DbxDownloader<PaperDocExportResult> start() throws DbxException {
        return this._client.docsDownload(new PaperDocExport(this.docId, this.exportFormat), getHeaders());
    }
}
