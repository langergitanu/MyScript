package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.MembersListArg;

/* JADX INFO: loaded from: classes5.dex */
public class MembersListBuilder {
    private final MembersListArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    MembersListBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, MembersListArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public MembersListBuilder withLimit(Long l) {
        this._builder.withLimit(l);
        return this;
    }

    public MembersListBuilder withIncludeRemoved(Boolean bool) {
        this._builder.withIncludeRemoved(bool);
        return this;
    }

    public MembersListResult start() throws DbxException {
        return this._client.membersList(this._builder.build());
    }
}
