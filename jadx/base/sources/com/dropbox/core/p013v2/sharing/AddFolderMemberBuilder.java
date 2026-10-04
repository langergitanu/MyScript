package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.sharing.AddFolderMemberArg;

/* JADX INFO: loaded from: classes4.dex */
public class AddFolderMemberBuilder {
    private final AddFolderMemberArg.Builder _builder;
    private final DbxUserSharingRequests _client;

    AddFolderMemberBuilder(DbxUserSharingRequests dbxUserSharingRequests, AddFolderMemberArg.Builder builder) {
        if (dbxUserSharingRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxUserSharingRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public AddFolderMemberBuilder withQuiet(Boolean bool) {
        this._builder.withQuiet(bool);
        return this;
    }

    public AddFolderMemberBuilder withCustomMessage(String str) {
        this._builder.withCustomMessage(str);
        return this;
    }

    public void start() throws DbxException {
        this._client.addFolderMember(this._builder.build());
    }
}
