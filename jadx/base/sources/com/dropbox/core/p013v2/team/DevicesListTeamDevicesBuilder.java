package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.team.ListTeamDevicesArg;

/* JADX INFO: loaded from: classes5.dex */
public class DevicesListTeamDevicesBuilder {
    private final ListTeamDevicesArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    DevicesListTeamDevicesBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, ListTeamDevicesArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public DevicesListTeamDevicesBuilder withCursor(String str) {
        this._builder.withCursor(str);
        return this;
    }

    public DevicesListTeamDevicesBuilder withIncludeWebSessions(Boolean bool) {
        this._builder.withIncludeWebSessions(bool);
        return this;
    }

    public DevicesListTeamDevicesBuilder withIncludeDesktopClients(Boolean bool) {
        this._builder.withIncludeDesktopClients(bool);
        return this;
    }

    public DevicesListTeamDevicesBuilder withIncludeMobileClients(Boolean bool) {
        this._builder.withIncludeMobileClients(bool);
        return this;
    }

    public ListTeamDevicesResult start() throws DbxException {
        return this._client.devicesListTeamDevices(this._builder.build());
    }
}
