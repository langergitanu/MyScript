package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.files.ListRevisionsArg;

/* JADX INFO: loaded from: classes4.dex */
public class ListRevisionsBuilder {
    private final ListRevisionsArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    ListRevisionsBuilder(DbxUserFilesRequests dbxUserFilesRequests, ListRevisionsArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public ListRevisionsBuilder withMode(ListRevisionsMode listRevisionsMode) {
        this._builder.withMode(listRevisionsMode);
        return this;
    }

    public ListRevisionsBuilder withLimit(Long l) {
        this._builder.withLimit(l);
        return this;
    }

    public ListRevisionsResult start() throws DbxException {
        return this._client.listRevisions(this._builder.build());
    }
}
