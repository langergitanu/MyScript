package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxDownloadStyleBuilder;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadBuilder extends DbxDownloadStyleBuilder<FileMetadata> {
    private final DbxUserFilesRequests _client;
    private final String path;
    private String rev;

    DownloadBuilder(DbxUserFilesRequests dbxUserFilesRequests, String str) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        this.path = str;
        this.rev = null;
    }

    public DownloadBuilder withRev(String str) {
        if (str != null) {
            if (str.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", str)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
        }
        this.rev = str;
        return this;
    }

    @Override // com.dropbox.core.p013v2.DbxDownloadStyleBuilder
    public DbxDownloader<FileMetadata> start() throws DbxException {
        return this._client.download(new DownloadArg(this.path, this.rev), getHeaders());
    }
}
