package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.files.SyncSettingsError;
import com.dropbox.core.p013v2.team.TeamFolderAccessError;
import com.dropbox.core.p013v2.team.TeamFolderInvalidStatusError;
import com.dropbox.core.p013v2.team.TeamFolderTeamSharedDropboxError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class TeamFolderUpdateSyncSettingsError {
    public static final TeamFolderUpdateSyncSettingsError OTHER = new TeamFolderUpdateSyncSettingsError().withTag(Tag.OTHER);
    private Tag _tag;
    private TeamFolderAccessError accessErrorValue;
    private TeamFolderInvalidStatusError statusErrorValue;
    private SyncSettingsError syncSettingsErrorValue;
    private TeamFolderTeamSharedDropboxError teamSharedDropboxErrorValue;

    public enum Tag {
        ACCESS_ERROR,
        STATUS_ERROR,
        TEAM_SHARED_DROPBOX_ERROR,
        OTHER,
        SYNC_SETTINGS_ERROR
    }

    private TeamFolderUpdateSyncSettingsError() {
    }

    private TeamFolderUpdateSyncSettingsError withTag(Tag tag) {
        TeamFolderUpdateSyncSettingsError teamFolderUpdateSyncSettingsError = new TeamFolderUpdateSyncSettingsError();
        teamFolderUpdateSyncSettingsError._tag = tag;
        return teamFolderUpdateSyncSettingsError;
    }

    private TeamFolderUpdateSyncSettingsError withTagAndAccessError(Tag tag, TeamFolderAccessError teamFolderAccessError) {
        TeamFolderUpdateSyncSettingsError teamFolderUpdateSyncSettingsError = new TeamFolderUpdateSyncSettingsError();
        teamFolderUpdateSyncSettingsError._tag = tag;
        teamFolderUpdateSyncSettingsError.accessErrorValue = teamFolderAccessError;
        return teamFolderUpdateSyncSettingsError;
    }

    private TeamFolderUpdateSyncSettingsError withTagAndStatusError(Tag tag, TeamFolderInvalidStatusError teamFolderInvalidStatusError) {
        TeamFolderUpdateSyncSettingsError teamFolderUpdateSyncSettingsError = new TeamFolderUpdateSyncSettingsError();
        teamFolderUpdateSyncSettingsError._tag = tag;
        teamFolderUpdateSyncSettingsError.statusErrorValue = teamFolderInvalidStatusError;
        return teamFolderUpdateSyncSettingsError;
    }

    private TeamFolderUpdateSyncSettingsError withTagAndTeamSharedDropboxError(Tag tag, TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError) {
        TeamFolderUpdateSyncSettingsError teamFolderUpdateSyncSettingsError = new TeamFolderUpdateSyncSettingsError();
        teamFolderUpdateSyncSettingsError._tag = tag;
        teamFolderUpdateSyncSettingsError.teamSharedDropboxErrorValue = teamFolderTeamSharedDropboxError;
        return teamFolderUpdateSyncSettingsError;
    }

    private TeamFolderUpdateSyncSettingsError withTagAndSyncSettingsError(Tag tag, SyncSettingsError syncSettingsError) {
        TeamFolderUpdateSyncSettingsError teamFolderUpdateSyncSettingsError = new TeamFolderUpdateSyncSettingsError();
        teamFolderUpdateSyncSettingsError._tag = tag;
        teamFolderUpdateSyncSettingsError.syncSettingsErrorValue = syncSettingsError;
        return teamFolderUpdateSyncSettingsError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static TeamFolderUpdateSyncSettingsError accessError(TeamFolderAccessError teamFolderAccessError) {
        if (teamFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderUpdateSyncSettingsError().withTagAndAccessError(Tag.ACCESS_ERROR, teamFolderAccessError);
    }

    public TeamFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isStatusError() {
        return this._tag == Tag.STATUS_ERROR;
    }

    public static TeamFolderUpdateSyncSettingsError statusError(TeamFolderInvalidStatusError teamFolderInvalidStatusError) {
        if (teamFolderInvalidStatusError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderUpdateSyncSettingsError().withTagAndStatusError(Tag.STATUS_ERROR, teamFolderInvalidStatusError);
    }

    public TeamFolderInvalidStatusError getStatusErrorValue() {
        if (this._tag != Tag.STATUS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.STATUS_ERROR, but was Tag." + this._tag.name());
        }
        return this.statusErrorValue;
    }

    public boolean isTeamSharedDropboxError() {
        return this._tag == Tag.TEAM_SHARED_DROPBOX_ERROR;
    }

    public static TeamFolderUpdateSyncSettingsError teamSharedDropboxError(TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError) {
        if (teamFolderTeamSharedDropboxError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderUpdateSyncSettingsError().withTagAndTeamSharedDropboxError(Tag.TEAM_SHARED_DROPBOX_ERROR, teamFolderTeamSharedDropboxError);
    }

    public TeamFolderTeamSharedDropboxError getTeamSharedDropboxErrorValue() {
        if (this._tag != Tag.TEAM_SHARED_DROPBOX_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_SHARED_DROPBOX_ERROR, but was Tag." + this._tag.name());
        }
        return this.teamSharedDropboxErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public boolean isSyncSettingsError() {
        return this._tag == Tag.SYNC_SETTINGS_ERROR;
    }

    public static TeamFolderUpdateSyncSettingsError syncSettingsError(SyncSettingsError syncSettingsError) {
        if (syncSettingsError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderUpdateSyncSettingsError().withTagAndSyncSettingsError(Tag.SYNC_SETTINGS_ERROR, syncSettingsError);
    }

    public SyncSettingsError getSyncSettingsErrorValue() {
        if (this._tag != Tag.SYNC_SETTINGS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.SYNC_SETTINGS_ERROR, but was Tag." + this._tag.name());
        }
        return this.syncSettingsErrorValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue, this.statusErrorValue, this.teamSharedDropboxErrorValue, this.syncSettingsErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TeamFolderUpdateSyncSettingsError)) {
            return false;
        }
        TeamFolderUpdateSyncSettingsError teamFolderUpdateSyncSettingsError = (TeamFolderUpdateSyncSettingsError) obj;
        if (this._tag != teamFolderUpdateSyncSettingsError._tag) {
            return false;
        }
        int i = C44131.f770x8f73d9f3[this._tag.ordinal()];
        if (i == 1) {
            TeamFolderAccessError teamFolderAccessError = this.accessErrorValue;
            TeamFolderAccessError teamFolderAccessError2 = teamFolderUpdateSyncSettingsError.accessErrorValue;
            return teamFolderAccessError == teamFolderAccessError2 || teamFolderAccessError.equals(teamFolderAccessError2);
        }
        if (i == 2) {
            TeamFolderInvalidStatusError teamFolderInvalidStatusError = this.statusErrorValue;
            TeamFolderInvalidStatusError teamFolderInvalidStatusError2 = teamFolderUpdateSyncSettingsError.statusErrorValue;
            return teamFolderInvalidStatusError == teamFolderInvalidStatusError2 || teamFolderInvalidStatusError.equals(teamFolderInvalidStatusError2);
        }
        if (i == 3) {
            TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError = this.teamSharedDropboxErrorValue;
            TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError2 = teamFolderUpdateSyncSettingsError.teamSharedDropboxErrorValue;
            return teamFolderTeamSharedDropboxError == teamFolderTeamSharedDropboxError2 || teamFolderTeamSharedDropboxError.equals(teamFolderTeamSharedDropboxError2);
        }
        if (i != 4) {
            if (i != 5) {
                return false;
            }
            SyncSettingsError syncSettingsError = this.syncSettingsErrorValue;
            SyncSettingsError syncSettingsError2 = teamFolderUpdateSyncSettingsError.syncSettingsErrorValue;
            if (syncSettingsError != syncSettingsError2 && !syncSettingsError.equals(syncSettingsError2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderUpdateSyncSettingsError$1 */
    static /* synthetic */ class C44131 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$TeamFolderUpdateSyncSettingsError$Tag */
        static final /* synthetic */ int[] f770x8f73d9f3;

        static {
            int[] iArr = new int[Tag.values().length];
            f770x8f73d9f3 = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f770x8f73d9f3[Tag.STATUS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f770x8f73d9f3[Tag.TEAM_SHARED_DROPBOX_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f770x8f73d9f3[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f770x8f73d9f3[Tag.SYNC_SETTINGS_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<TeamFolderUpdateSyncSettingsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderUpdateSyncSettingsError teamFolderUpdateSyncSettingsError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44131.f770x8f73d9f3[teamFolderUpdateSyncSettingsError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                TeamFolderAccessError.Serializer.INSTANCE.serialize(teamFolderUpdateSyncSettingsError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("status_error", jsonGenerator);
                jsonGenerator.writeFieldName("status_error");
                TeamFolderInvalidStatusError.Serializer.INSTANCE.serialize(teamFolderUpdateSyncSettingsError.statusErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("team_shared_dropbox_error", jsonGenerator);
                jsonGenerator.writeFieldName("team_shared_dropbox_error");
                TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.serialize(teamFolderUpdateSyncSettingsError.teamSharedDropboxErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("other");
                return;
            }
            if (i == 5) {
                jsonGenerator.writeStartObject();
                writeTag("sync_settings_error", jsonGenerator);
                jsonGenerator.writeFieldName("sync_settings_error");
                SyncSettingsError.Serializer.INSTANCE.serialize(teamFolderUpdateSyncSettingsError.syncSettingsErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + teamFolderUpdateSyncSettingsError.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderUpdateSyncSettingsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderUpdateSyncSettingsError teamFolderUpdateSyncSettingsErrorSyncSettingsError;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                teamFolderUpdateSyncSettingsErrorSyncSettingsError = TeamFolderUpdateSyncSettingsError.accessError(TeamFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("status_error".equals(tag)) {
                expectField("status_error", jsonParser);
                teamFolderUpdateSyncSettingsErrorSyncSettingsError = TeamFolderUpdateSyncSettingsError.statusError(TeamFolderInvalidStatusError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("team_shared_dropbox_error".equals(tag)) {
                expectField("team_shared_dropbox_error", jsonParser);
                teamFolderUpdateSyncSettingsErrorSyncSettingsError = TeamFolderUpdateSyncSettingsError.teamSharedDropboxError(TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("other".equals(tag)) {
                teamFolderUpdateSyncSettingsErrorSyncSettingsError = TeamFolderUpdateSyncSettingsError.OTHER;
            } else if ("sync_settings_error".equals(tag)) {
                expectField("sync_settings_error", jsonParser);
                teamFolderUpdateSyncSettingsErrorSyncSettingsError = TeamFolderUpdateSyncSettingsError.syncSettingsError(SyncSettingsError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderUpdateSyncSettingsErrorSyncSettingsError;
        }
    }
}
