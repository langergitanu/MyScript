package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.MembersSetProfileArg;

/* JADX INFO: loaded from: classes5.dex */
public class MembersSetProfileV2Builder {
    private final MembersSetProfileArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    MembersSetProfileV2Builder(DbxTeamTeamRequests dbxTeamTeamRequests, MembersSetProfileArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public MembersSetProfileV2Builder withNewEmail(String str) {
        this._builder.withNewEmail(str);
        return this;
    }

    public MembersSetProfileV2Builder withNewExternalId(String str) {
        this._builder.withNewExternalId(str);
        return this;
    }

    public MembersSetProfileV2Builder withNewGivenName(String str) {
        this._builder.withNewGivenName(str);
        return this;
    }

    public MembersSetProfileV2Builder withNewSurname(String str) {
        this._builder.withNewSurname(str);
        return this;
    }

    public MembersSetProfileV2Builder withNewPersistentId(String str) {
        this._builder.withNewPersistentId(str);
        return this;
    }

    public MembersSetProfileV2Builder withNewIsDirectoryRestricted(Boolean bool) {
        this._builder.withNewIsDirectoryRestricted(bool);
        return this;
    }

    public TeamMemberInfoV2Result start() throws DbxException {
        return this._client.membersSetProfileV2(this._builder.build());
    }
}
