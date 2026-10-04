package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.ListSharedLinksArg;

/* JADX INFO: loaded from: classes4.dex */
public class ListSharedLinksBuilder {
    private final ListSharedLinksArg.Builder _builder;
    private final DbxUserSharingRequests _client;

    ListSharedLinksBuilder(DbxUserSharingRequests dbxUserSharingRequests, ListSharedLinksArg.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public ListSharedLinksBuilder withPath(String str) {
        this._builder.withPath(str);
        return this;
    }

    public ListSharedLinksBuilder withCursor(String str) {
        this._builder.withCursor(str);
        return this;
    }

    public ListSharedLinksBuilder withDirectOnly(Boolean bool) {
        this._builder.withDirectOnly(bool);
        return this;
    }

    public ListSharedLinksResult start() throws DbxException {
        return this._client.listSharedLinks(this._builder.build());
    }
}
