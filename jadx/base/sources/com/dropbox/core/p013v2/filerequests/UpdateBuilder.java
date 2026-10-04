package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.filerequests.UpdateFileRequestArgs;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateBuilder {
    private final UpdateFileRequestArgs.Builder _builder;
    private final DbxUserFileRequestsRequests _client;

    UpdateBuilder(DbxUserFileRequestsRequests dbxUserFileRequestsRequests, UpdateFileRequestArgs.Builder builder) {
        if (dbxUserFileRequestsRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFileRequestsRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public UpdateBuilder withTitle(String str) {
        this._builder.withTitle(str);
        return this;
    }

    public UpdateBuilder withDestination(String str) {
        this._builder.withDestination(str);
        return this;
    }

    public UpdateBuilder withDeadline(UpdateFileRequestDeadline updateFileRequestDeadline) {
        this._builder.withDeadline(updateFileRequestDeadline);
        return this;
    }

    public UpdateBuilder withOpen(Boolean bool) {
        this._builder.withOpen(bool);
        return this;
    }

    public UpdateBuilder withDescription(String str) {
        this._builder.withDescription(str);
        return this;
    }

    public FileRequest start() throws DbxException {
        return this._client.update(this._builder.build());
    }
}
