package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.ListFoldersArgs;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ListFoldersBuilder {
    private final ListFoldersArgs.Builder _builder;
    private final DbxUserSharingRequests _client;

    ListFoldersBuilder(DbxUserSharingRequests dbxUserSharingRequests, ListFoldersArgs.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public ListFoldersBuilder withLimit(Long l) {
        this._builder.withLimit(l);
        return this;
    }

    public ListFoldersBuilder withActions(List<FolderAction> list) {
        this._builder.withActions(list);
        return this;
    }

    public ListFoldersResult start() throws DbxException {
        return this._client.listFolders(this._builder.build());
    }
}
