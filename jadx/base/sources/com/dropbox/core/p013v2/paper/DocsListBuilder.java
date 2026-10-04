package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.paper.ListPaperDocsArgs;

/* JADX INFO: loaded from: classes4.dex */
public class DocsListBuilder {
    private final ListPaperDocsArgs.Builder _builder;
    private final DbxUserPaperRequests _client;

    DocsListBuilder(DbxUserPaperRequests dbxUserPaperRequests, ListPaperDocsArgs.Builder builder) {
        if (dbxUserPaperRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserPaperRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DocsListBuilder withFilterBy(ListPaperDocsFilterBy listPaperDocsFilterBy) {
        this._builder.withFilterBy(listPaperDocsFilterBy);
        return this;
    }

    public DocsListBuilder withSortBy(ListPaperDocsSortBy listPaperDocsSortBy) {
        this._builder.withSortBy(listPaperDocsSortBy);
        return this;
    }

    public DocsListBuilder withSortOrder(ListPaperDocsSortOrder listPaperDocsSortOrder) {
        this._builder.withSortOrder(listPaperDocsSortOrder);
        return this;
    }

    public DocsListBuilder withLimit(Integer num) {
        this._builder.withLimit(num);
        return this;
    }

    public ListPaperDocsResponse start() throws DbxException {
        return this._client.docsList(this._builder.build());
    }
}
