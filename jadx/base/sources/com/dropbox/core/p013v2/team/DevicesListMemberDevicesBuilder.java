package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.ListMemberDevicesArg;

/* JADX INFO: loaded from: classes5.dex */
public class DevicesListMemberDevicesBuilder {
    private final ListMemberDevicesArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    DevicesListMemberDevicesBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, ListMemberDevicesArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DevicesListMemberDevicesBuilder withIncludeWebSessions(Boolean bool) {
        this._builder.withIncludeWebSessions(bool);
        return this;
    }

    public DevicesListMemberDevicesBuilder withIncludeDesktopClients(Boolean bool) {
        this._builder.withIncludeDesktopClients(bool);
        return this;
    }

    public DevicesListMemberDevicesBuilder withIncludeMobileClients(Boolean bool) {
        this._builder.withIncludeMobileClients(bool);
        return this;
    }

    public ListMemberDevicesResult start() throws DbxException {
        return this._client.devicesListMemberDevices(this._builder.build());
    }
}
