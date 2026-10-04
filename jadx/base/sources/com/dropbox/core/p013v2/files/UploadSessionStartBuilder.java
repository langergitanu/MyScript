package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.DbxUploadStyleBuilder;
import com.dropbox.core.p013v2.files.UploadSessionStartArg;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSessionStartBuilder extends DbxUploadStyleBuilder<UploadSessionStartResult, UploadSessionStartError, UploadSessionStartErrorException> {
    private final UploadSessionStartArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    UploadSessionStartBuilder(DbxUserFilesRequests dbxUserFilesRequests, UploadSessionStartArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public UploadSessionStartBuilder withClose(Boolean bool) {
        this._builder.withClose(bool);
        return this;
    }

    public UploadSessionStartBuilder withSessionType(UploadSessionType uploadSessionType) {
        this._builder.withSessionType(uploadSessionType);
        return this;
    }

    public UploadSessionStartBuilder withContentHash(String str) {
        this._builder.withContentHash(str);
        return this;
    }

    @Override // com.dropbox.core.p013v2.DbxUploadStyleBuilder
    public UploadSessionStartUploader start() throws DbxException {
        return this._client.uploadSessionStart(this._builder.build());
    }
}
