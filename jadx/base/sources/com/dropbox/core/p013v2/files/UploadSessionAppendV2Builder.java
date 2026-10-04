package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxUploadStyleBuilder;
import com.dropbox.core.p013v2.files.UploadSessionAppendArg;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSessionAppendV2Builder extends DbxUploadStyleBuilder<Void, UploadSessionAppendError, UploadSessionAppendErrorException> {
    private final UploadSessionAppendArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    UploadSessionAppendV2Builder(DbxUserFilesRequests dbxUserFilesRequests, UploadSessionAppendArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public UploadSessionAppendV2Builder withClose(Boolean bool) {
        this._builder.withClose(bool);
        return this;
    }

    public UploadSessionAppendV2Builder withContentHash(String str) {
        this._builder.withContentHash(str);
        return this;
    }

    @Override // com.dropbox.core.p013v2.DbxUploadStyleBuilder
    public UploadSessionAppendV2Uploader start() throws DbxException {
        return this._client.uploadSessionAppendV2(this._builder.build());
    }
}
