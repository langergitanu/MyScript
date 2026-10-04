package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.files.CreateFolderBatchArg;

/* JADX INFO: loaded from: classes4.dex */
public class CreateFolderBatchBuilder {
    private final CreateFolderBatchArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    CreateFolderBatchBuilder(DbxUserFilesRequests dbxUserFilesRequests, CreateFolderBatchArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public CreateFolderBatchBuilder withAutorename(Boolean bool) {
        this._builder.withAutorename(bool);
        return this;
    }

    public CreateFolderBatchBuilder withForceAsync(Boolean bool) {
        this._builder.withForceAsync(bool);
        return this;
    }

    public CreateFolderBatchLaunch start() throws DbxException {
        return this._client.createFolderBatch(this._builder.build());
    }
}
