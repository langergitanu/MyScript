package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.files.RelocationArg;

/* JADX INFO: loaded from: classes4.dex */
public class CopyBuilder {
    private final RelocationArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    CopyBuilder(DbxUserFilesRequests dbxUserFilesRequests, RelocationArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public CopyBuilder withAllowSharedFolder(Boolean bool) {
        this._builder.withAllowSharedFolder(bool);
        return this;
    }

    public CopyBuilder withAutorename(Boolean bool) {
        this._builder.withAutorename(bool);
        return this;
    }

    public CopyBuilder withAllowOwnershipTransfer(Boolean bool) {
        this._builder.withAllowOwnershipTransfer(bool);
        return this;
    }

    public Metadata start() throws DbxException {
        return this._client.copy(this._builder.build());
    }
}
