package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.files.RelocationArg;

/* JADX INFO: loaded from: classes4.dex */
public class CopyV2Builder {
    private final RelocationArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    CopyV2Builder(DbxUserFilesRequests dbxUserFilesRequests, RelocationArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public CopyV2Builder withAllowSharedFolder(Boolean bool) {
        this._builder.withAllowSharedFolder(bool);
        return this;
    }

    public CopyV2Builder withAutorename(Boolean bool) {
        this._builder.withAutorename(bool);
        return this;
    }

    public CopyV2Builder withAllowOwnershipTransfer(Boolean bool) {
        this._builder.withAllowOwnershipTransfer(bool);
        return this;
    }

    public RelocationResult start() throws DbxException {
        return this._client.copyV2(this._builder.build());
    }
}
