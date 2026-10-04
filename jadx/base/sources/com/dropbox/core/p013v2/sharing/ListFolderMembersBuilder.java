package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.ListFolderMembersArgs;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ListFolderMembersBuilder {
    private final ListFolderMembersArgs.Builder _builder;
    private final DbxUserSharingRequests _client;

    ListFolderMembersBuilder(DbxUserSharingRequests dbxUserSharingRequests, ListFolderMembersArgs.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public ListFolderMembersBuilder withActions(List<MemberAction> list) {
        this._builder.withActions(list);
        return this;
    }

    public ListFolderMembersBuilder withLimit(Long l) {
        this._builder.withLimit(l);
        return this;
    }

    public SharedFolderMembers start() throws DbxException {
        return this._client.listFolderMembers(this._builder.build());
    }
}
