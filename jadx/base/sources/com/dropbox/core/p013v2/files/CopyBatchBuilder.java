package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.files.RelocationBatchArg;

/* JADX INFO: loaded from: classes4.dex */
public class CopyBatchBuilder {
    private final RelocationBatchArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    CopyBatchBuilder(DbxUserFilesRequests dbxUserFilesRequests, RelocationBatchArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public CopyBatchBuilder withAutorename(Boolean bool) {
        this._builder.withAutorename(bool);
        return this;
    }

    public CopyBatchBuilder withAllowSharedFolder(Boolean bool) {
        this._builder.withAllowSharedFolder(bool);
        return this;
    }

    public CopyBatchBuilder withAllowOwnershipTransfer(Boolean bool) {
        this._builder.withAllowOwnershipTransfer(bool);
        return this;
    }

    public RelocationBatchLaunch start() throws DbxException {
        return this._client.copyBatch(this._builder.build());
    }
}
