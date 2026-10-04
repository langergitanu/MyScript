package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.GroupCreateArg;
import com.dropbox.core.p013v2.teamcommon.GroupManagementType;

/* JADX INFO: loaded from: classes5.dex */
public class GroupsCreateBuilder {
    private final GroupCreateArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    GroupsCreateBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, GroupCreateArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public GroupsCreateBuilder withAddCreatorAsOwner(Boolean bool) {
        this._builder.withAddCreatorAsOwner(bool);
        return this;
    }

    public GroupsCreateBuilder withGroupExternalId(String str) {
        this._builder.withGroupExternalId(str);
        return this;
    }

    public GroupsCreateBuilder withGroupManagementType(GroupManagementType groupManagementType) {
        this._builder.withGroupManagementType(groupManagementType);
        return this;
    }

    public GroupFullInfo start() throws DbxException {
        return this._client.groupsCreate(this._builder.build());
    }
}
