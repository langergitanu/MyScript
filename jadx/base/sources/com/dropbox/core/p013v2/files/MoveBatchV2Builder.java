package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.files.MoveBatchArg;

/* JADX INFO: loaded from: classes4.dex */
public class MoveBatchV2Builder {
    private final MoveBatchArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    MoveBatchV2Builder(DbxUserFilesRequests dbxUserFilesRequests, MoveBatchArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public MoveBatchV2Builder withAutorename(Boolean bool) {
        this._builder.withAutorename(bool);
        return this;
    }

    public MoveBatchV2Builder withAllowOwnershipTransfer(Boolean bool) {
        this._builder.withAllowOwnershipTransfer(bool);
        return this;
    }

    public RelocationBatchV2Launch start() throws DbxException {
        return this._client.moveBatchV2(this._builder.build());
    }
}
