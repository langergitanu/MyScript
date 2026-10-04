package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.MembersSetProfileArg;

/* JADX INFO: loaded from: classes5.dex */
public class MembersSetProfileBuilder {
    private final MembersSetProfileArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    MembersSetProfileBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, MembersSetProfileArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public MembersSetProfileBuilder withNewEmail(String str) {
        this._builder.withNewEmail(str);
        return this;
    }

    public MembersSetProfileBuilder withNewExternalId(String str) {
        this._builder.withNewExternalId(str);
        return this;
    }

    public MembersSetProfileBuilder withNewGivenName(String str) {
        this._builder.withNewGivenName(str);
        return this;
    }

    public MembersSetProfileBuilder withNewSurname(String str) {
        this._builder.withNewSurname(str);
        return this;
    }

    public MembersSetProfileBuilder withNewPersistentId(String str) {
        this._builder.withNewPersistentId(str);
        return this;
    }

    public MembersSetProfileBuilder withNewIsDirectoryRestricted(Boolean bool) {
        this._builder.withNewIsDirectoryRestricted(bool);
        return this;
    }

    public TeamMemberInfo start() throws DbxException {
        return this._client.membersSetProfile(this._builder.build());
    }
}
