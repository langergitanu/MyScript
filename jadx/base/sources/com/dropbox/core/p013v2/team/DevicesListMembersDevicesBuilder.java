package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.ListMembersDevicesArg;

/* JADX INFO: loaded from: classes5.dex */
public class DevicesListMembersDevicesBuilder {
    private final ListMembersDevicesArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    DevicesListMembersDevicesBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, ListMembersDevicesArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DevicesListMembersDevicesBuilder withCursor(String str) {
        this._builder.withCursor(str);
        return this;
    }

    public DevicesListMembersDevicesBuilder withIncludeWebSessions(Boolean bool) {
        this._builder.withIncludeWebSessions(bool);
        return this;
    }

    public DevicesListMembersDevicesBuilder withIncludeDesktopClients(Boolean bool) {
        this._builder.withIncludeDesktopClients(bool);
        return this;
    }

    public DevicesListMembersDevicesBuilder withIncludeMobileClients(Boolean bool) {
        this._builder.withIncludeMobileClients(bool);
        return this;
    }

    public ListMembersDevicesResult start() throws DbxException {
        return this._client.devicesListMembersDevices(this._builder.build());
    }
}
