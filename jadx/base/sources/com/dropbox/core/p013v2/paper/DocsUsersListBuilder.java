package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.paper.ListUsersOnPaperDocArgs;

/* JADX INFO: loaded from: classes4.dex */
public class DocsUsersListBuilder {
    private final ListUsersOnPaperDocArgs.Builder _builder;
    private final DbxUserPaperRequests _client;

    DocsUsersListBuilder(DbxUserPaperRequests dbxUserPaperRequests, ListUsersOnPaperDocArgs.Builder builder) {
        if (dbxUserPaperRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserPaperRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DocsUsersListBuilder withLimit(Integer num) {
        this._builder.withLimit(num);
        return this;
    }

    public DocsUsersListBuilder withFilterBy(UserOnPaperDocFilter userOnPaperDocFilter) {
        this._builder.withFilterBy(userOnPaperDocFilter);
        return this;
    }

    public ListUsersOnPaperDocResponse start() throws DbxException {
        return this._client.docsUsersList(this._builder.build());
    }
}
