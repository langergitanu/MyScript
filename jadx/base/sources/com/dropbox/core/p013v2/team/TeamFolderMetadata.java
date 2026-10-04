package com.dropbox.core.p013v2.team;

import androidx.core.app.NotificationCompat;
import com.dropbox.core.p013v2.files.ContentSyncSetting;
import com.dropbox.core.p013v2.files.SyncSetting;
import com.dropbox.core.p013v2.team.TeamFolderStatus;
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

/* JADX INFO: loaded from: classes5.dex */
public class TeamFolderMetadata {

    @Nonnull
    protected final List<ContentSyncSetting> contentSyncSettings;
    protected final boolean isTeamSharedDropbox;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final TeamFolderStatus status;

    @Nonnull
    protected final SyncSetting syncSetting;

    @Nonnull
    protected final String teamFolderId;

    public TeamFolderMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull TeamFolderStatus teamFolderStatus, boolean z, @Nonnull SyncSetting syncSetting, @Nonnull List<ContentSyncSetting> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'teamFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'teamFolderId' does not match pattern");
        }
        this.teamFolderId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        if (teamFolderStatus == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = teamFolderStatus;
        this.isTeamSharedDropbox = z;
        if (syncSetting == null) {
            throw new IllegalArgumentException("Required value for 'syncSetting' is null");
        }
        this.syncSetting = syncSetting;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'contentSyncSettings' is null");
        }
        Iterator<ContentSyncSetting> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'contentSyncSettings' is null");
            }
        }
        this.contentSyncSettings = list;
    }

    @Nonnull
    public String getTeamFolderId() {
        return this.teamFolderId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public TeamFolderStatus getStatus() {
        return this.status;
    }

    public boolean getIsTeamSharedDropbox() {
        return this.isTeamSharedDropbox;
    }

    @Nonnull
    public SyncSetting getSyncSetting() {
        return this.syncSetting;
    }

    @Nonnull
    public List<ContentSyncSetting> getContentSyncSettings() {
        return this.contentSyncSettings;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamFolderId, this.name, this.status, Boolean.valueOf(this.isTeamSharedDropbox), this.syncSetting, this.contentSyncSettings});
    }

    public boolean equals(Object obj) {
        TeamFolderMetadata teamFolderMetadata;
        String str;
        String str2;
        String str3;
        String str4;
        TeamFolderStatus teamFolderStatus;
        TeamFolderStatus teamFolderStatus2;
        SyncSetting syncSetting;
        SyncSetting syncSetting2;
        List<ContentSyncSetting> list;
        List<ContentSyncSetting> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.teamFolderId) == (str2 = (teamFolderMetadata = (TeamFolderMetadata) obj).teamFolderId) || str.equals(str2)) && (((str3 = this.name) == (str4 = teamFolderMetadata.name) || str3.equals(str4)) && (((teamFolderStatus = this.status) == (teamFolderStatus2 = teamFolderMetadata.status) || teamFolderStatus.equals(teamFolderStatus2)) && this.isTeamSharedDropbox == teamFolderMetadata.isTeamSharedDropbox && (((syncSetting = this.syncSetting) == (syncSetting2 = teamFolderMetadata.syncSetting) || syncSetting.equals(syncSetting2)) && ((list = this.contentSyncSettings) == (list2 = teamFolderMetadata.contentSyncSettings) || list.equals(list2)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamFolderMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamFolderMetadata teamFolderMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_folder_id");
            StoneSerializers.string().serialize(teamFolderMetadata.teamFolderId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(teamFolderMetadata.name, jsonGenerator);
            jsonGenerator.writeFieldName(NotificationCompat.CATEGORY_STATUS);
            TeamFolderStatus.Serializer.INSTANCE.serialize(teamFolderMetadata.status, jsonGenerator);
            jsonGenerator.writeFieldName("is_team_shared_dropbox");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(teamFolderMetadata.isTeamSharedDropbox), jsonGenerator);
            jsonGenerator.writeFieldName("sync_setting");
            SyncSetting.Serializer.INSTANCE.serialize(teamFolderMetadata.syncSetting, jsonGenerator);
            jsonGenerator.writeFieldName("content_sync_settings");
            StoneSerializers.list(ContentSyncSetting.Serializer.INSTANCE).serialize(teamFolderMetadata.contentSyncSettings, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamFolderMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                TeamFolderStatus teamFolderStatusDeserialize = null;
                SyncSetting syncSettingDeserialize = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if (NotificationCompat.CATEGORY_STATUS.equals(currentName)) {
                        teamFolderStatusDeserialize = TeamFolderStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("is_team_shared_dropbox".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("sync_setting".equals(currentName)) {
                        syncSettingDeserialize = SyncSetting.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("content_sync_settings".equals(currentName)) {
                        list = (List) StoneSerializers.list(ContentSyncSetting.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_folder_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (teamFolderStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"status\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_team_shared_dropbox\" missing.");
                }
                if (syncSettingDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"sync_setting\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"content_sync_settings\" missing.");
                }
                TeamFolderMetadata teamFolderMetadata = new TeamFolderMetadata(strDeserialize, strDeserialize2, teamFolderStatusDeserialize, boolDeserialize.booleanValue(), syncSettingDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamFolderMetadata, teamFolderMetadata.toStringMultiline());
                return teamFolderMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
