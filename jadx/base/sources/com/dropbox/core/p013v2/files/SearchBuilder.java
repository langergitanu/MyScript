package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.files.SearchArg;

/* JADX INFO: loaded from: classes4.dex */
public class SearchBuilder {
    private final SearchArg.Builder _builder;
    private final DbxUserFilesRequests _client;

    SearchBuilder(DbxUserFilesRequests dbxUserFilesRequests, SearchArg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public SearchBuilder withStart(Long l) {
        this._builder.withStart(l);
        return this;
    }

    public SearchBuilder withMaxResults(Long l) {
        this._builder.withMaxResults(l);
        return this;
    }

    public SearchBuilder withMode(SearchMode searchMode) {
        this._builder.withMode(searchMode);
        return this;
    }

    public SearchResult start() throws DbxException {
        return this._client.search(this._builder.build());
    }
}
