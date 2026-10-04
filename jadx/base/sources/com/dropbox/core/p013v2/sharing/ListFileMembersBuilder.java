package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.ListFileMembersArg;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ListFileMembersBuilder {
    private final ListFileMembersArg.Builder _builder;
    private final DbxUserSharingRequests _client;

    ListFileMembersBuilder(DbxUserSharingRequests dbxUserSharingRequests, ListFileMembersArg.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public ListFileMembersBuilder withActions(List<MemberAction> list) {
        this._builder.withActions(list);
        return this;
    }

    public ListFileMembersBuilder withIncludeInherited(Boolean bool) {
        this._builder.withIncludeInherited(bool);
        return this;
    }

    public ListFileMembersBuilder withLimit(Long l) {
        this._builder.withLimit(l);
        return this;
    }

    public SharedFileMembers start() throws DbxException {
        return this._client.listFileMembers(this._builder.build());
    }
}
