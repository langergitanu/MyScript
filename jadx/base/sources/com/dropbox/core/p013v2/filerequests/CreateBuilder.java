package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.filerequests.CreateFileRequestArgs;

/* JADX INFO: loaded from: classes4.dex */
public class CreateBuilder {
    private final CreateFileRequestArgs.Builder _builder;
    private final DbxUserFileRequestsRequests _client;

    CreateBuilder(DbxUserFileRequestsRequests dbxUserFileRequestsRequests, CreateFileRequestArgs.Builder builder) {
        if (dbxUserFileRequestsRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFileRequestsRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public CreateBuilder withDeadline(FileRequestDeadline fileRequestDeadline) {
        this._builder.withDeadline(fileRequestDeadline);
        return this;
    }

    public CreateBuilder withOpen(Boolean bool) {
        this._builder.withOpen(bool);
        return this;
    }

    public CreateBuilder withDescription(String str) {
        this._builder.withDescription(str);
        return this;
    }

    public FileRequest start() throws DbxException {
        return this._client.create(this._builder.build());
    }
}
