package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.files.SearchV2Arg;

/* JADX INFO: loaded from: classes4.dex */
public class SearchV2Builder {
    private final SearchV2Arg.Builder _builder;
    private final DbxUserFilesRequests _client;

    SearchV2Builder(DbxUserFilesRequests dbxUserFilesRequests, SearchV2Arg.Builder builder) {
        if (dbxUserFilesRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserFilesRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public SearchV2Builder withOptions(SearchOptions searchOptions) {
        this._builder.withOptions(searchOptions);
        return this;
    }

    public SearchV2Builder withMatchFieldOptions(SearchMatchFieldOptions searchMatchFieldOptions) {
        this._builder.withMatchFieldOptions(searchMatchFieldOptions);
        return this;
    }

    public SearchV2Builder withIncludeHighlights(Boolean bool) {
        this._builder.withIncludeHighlights(bool);
        return this;
    }

    public SearchV2Result start() throws DbxException {
        return this._client.searchV2(this._builder.build());
    }
}
