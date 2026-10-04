package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.p013v2.files.ContentSyncSettingArg;
import com.dropbox.core.p013v2.files.SyncSettingArg;
import com.dropbox.core.p013v2.team.TeamFolderUpdateSyncSettingsArg;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class TeamFolderUpdateSyncSettingsBuilder {
    private final TeamFolderUpdateSyncSettingsArg.Builder _builder;
    private final DbxTeamTeamRequests _client;

    TeamFolderUpdateSyncSettingsBuilder(DbxTeamTeamRequests dbxTeamTeamRequests, TeamFolderUpdateSyncSettingsArg.Builder builder) {
        if (dbxTeamTeamRequests == null) {
            throw new NullPointerException("_client");
        }
        this._client = dbxTeamTeamRequests;
        if (builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = builder;
    }

    public TeamFolderUpdateSyncSettingsBuilder withSyncSetting(SyncSettingArg syncSettingArg) {
        this._builder.withSyncSetting(syncSettingArg);
        return this;
    }

    public TeamFolderUpdateSyncSettingsBuilder withContentSyncSettings(List<ContentSyncSettingArg> list) {
        this._builder.withContentSyncSettings(list);
        return this;
    }

    public TeamFolderMetadata start() throws DbxException {
        return this._client.teamFolderUpdateSyncSettings(this._builder.build());
    }
}
