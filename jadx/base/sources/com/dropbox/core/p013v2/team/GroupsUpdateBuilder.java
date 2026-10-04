package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.GroupUpdateArgs;
import com.dropbox.core.p013v2.teamcommon.GroupManagementType;

/* JADX INFO: loaded from: classes5.dex */
public class GroupsUpdateBuilder {
    private final GroupUpdateArgs.Builder _builder;
    private final DbxTeamTeamRequests _client;

    GroupsUpdateBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, GroupUpdateArgs.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public GroupsUpdateBuilder withReturnMembers(Boolean bool) {
        this._builder.withReturnMembers(bool);
        return this;
    }

    public GroupsUpdateBuilder withNewGroupName(String str) {
        this._builder.withNewGroupName(str);
        return this;
    }

    public GroupsUpdateBuilder withNewGroupExternalId(String str) {
        this._builder.withNewGroupExternalId(str);
        return this;
    }

    public GroupsUpdateBuilder withNewGroupManagementType(GroupManagementType groupManagementType) {
        this._builder.withNewGroupManagementType(groupManagementType);
        return this;
    }

    public GroupFullInfo start() throws DbxException {
        return this._client.groupsUpdate(this._builder.build());
    }
}
