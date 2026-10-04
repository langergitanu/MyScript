package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.files.ContentSyncSettingArg;
import com.dropbox.core.p013v2.files.SyncSettingArg;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class TeamFolderUpdateSyncSettingsArg extends TeamFolderIdArg {

    @Nullable
    protected final List<ContentSyncSettingArg> contentSyncSettings;

    @Nullable
    protected final SyncSettingArg syncSetting;

    public TeamFolderUpdateSyncSettingsArg(@Nonnull String str, @Nullable SyncSettingArg syncSettingArg, @Nullable List<ContentSyncSettingArg> list) {
        super(str);
        this.syncSetting = syncSettingArg;
        if (list != null) {
            Iterator<ContentSyncSettingArg> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'contentSyncSettings' is null");
                }
            }
        }
        this.contentSyncSettings = list;
    }

    public TeamFolderUpdateSyncSettingsArg(@Nonnull String str) {
        this(str, null, null);
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    @Nonnull
    public String getTeamFolderId() {
        return this.teamFolderId;
    }

    @Nullable
    public SyncSettingArg getSyncSetting() {
        return this.syncSetting;
    }

    @Nullable
    public List<ContentSyncSettingArg> getContentSyncSettings() {
        return this.contentSyncSettings;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected List<ContentSyncSettingArg> contentSyncSettings;
        protected SyncSettingArg syncSetting;
        protected final String teamFolderId;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'teamFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
                throw new IllegalArgumentException("String 'teamFolderId' does not match pattern");
            }
            this.teamFolderId = str;
            this.syncSetting = null;
            this.contentSyncSettings = null;
        }

        public Builder withSyncSetting(SyncSettingArg syncSettingArg) {
            this.syncSetting = syncSettingArg;
            return this;
        }

        public Builder withContentSyncSettings(List<ContentSyncSettingArg> list) {
            if (list != null) {
                Iterator<ContentSyncSettingArg> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'contentSyncSettings' is null");
                    }
                }
            }
            this.contentSyncSettings = list;
            return this;
        }

        public TeamFolderUpdateSyncSettingsArg build() {
            return new TeamFolderUpdateSyncSettingsArg(this.teamFolderId, this.syncSetting, this.contentSyncSettings);
        }
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.syncSetting, this.contentSyncSettings});
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public boolean equals(Object obj) {
        SyncSettingArg syncSettingArg;
        SyncSettingArg syncSettingArg2;
        List<ContentSyncSettingArg> list;
        List<ContentSyncSettingArg> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamFolderUpdateSyncSettingsArg teamFolderUpdateSyncSettingsArg = (TeamFolderUpdateSyncSettingsArg) obj;
        return (this.teamFolderId == teamFolderUpdateSyncSettingsArg.teamFolderId || this.teamFolderId.equals(teamFolderUpdateSyncSettingsArg.teamFolderId)) && ((syncSettingArg = this.syncSetting) == (syncSettingArg2 = teamFolderUpdateSyncSettingsArg.syncSetting) || (syncSettingArg != null && syncSettingArg.equals(syncSettingArg2))) && ((list = this.contentSyncSettings) == (list2 = teamFolderUpdateSyncSettingsArg.contentSyncSettings) || (list != null && list.equals(list2)));
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamFolderUpdateSyncSettingsArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamFolderUpdateSyncSettingsArg teamFolderUpdateSyncSettingsArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_folder_id");
            StoneSerializers.string().serialize(teamFolderUpdateSyncSettingsArg.teamFolderId, jsonGenerator);
            if (teamFolderUpdateSyncSettingsArg.syncSetting != null) {
                jsonGenerator.writeFieldName("sync_setting");
                StoneSerializers.nullable(SyncSettingArg.Serializer.INSTANCE).serialize(teamFolderUpdateSyncSettingsArg.syncSetting, jsonGenerator);
            }
            if (teamFolderUpdateSyncSettingsArg.contentSyncSettings != null) {
                jsonGenerator.writeFieldName("content_sync_settings");
                StoneSerializers.nullable(StoneSerializers.list(ContentSyncSettingArg.Serializer.INSTANCE)).serialize(teamFolderUpdateSyncSettingsArg.contentSyncSettings, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamFolderUpdateSyncSettingsArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SyncSettingArg syncSettingArg = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("sync_setting".equals(currentName)) {
                        syncSettingArg = (SyncSettingArg) StoneSerializers.nullable(SyncSettingArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("content_sync_settings".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(ContentSyncSettingArg.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_folder_id\" missing.");
                }
                TeamFolderUpdateSyncSettingsArg teamFolderUpdateSyncSettingsArg = new TeamFolderUpdateSyncSettingsArg(strDeserialize, syncSettingArg, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamFolderUpdateSyncSettingsArg, teamFolderUpdateSyncSettingsArg.toStringMultiline());
                return teamFolderUpdateSyncSettingsArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
