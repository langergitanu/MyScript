package com.dropbox.core.p013v2.team;

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
public final class TeamFolderRenameError {
    private Tag _tag;
    private TeamFolderAccessError accessErrorValue;
    private TeamFolderInvalidStatusError statusErrorValue;
    private TeamFolderTeamSharedDropboxError teamSharedDropboxErrorValue;
    public static final TeamFolderRenameError OTHER = new TeamFolderRenameError().withTag(Tag.OTHER);
    public static final TeamFolderRenameError INVALID_FOLDER_NAME = new TeamFolderRenameError().withTag(Tag.INVALID_FOLDER_NAME);
    public static final TeamFolderRenameError FOLDER_NAME_ALREADY_USED = new TeamFolderRenameError().withTag(Tag.FOLDER_NAME_ALREADY_USED);
    public static final TeamFolderRenameError FOLDER_NAME_RESERVED = new TeamFolderRenameError().withTag(Tag.FOLDER_NAME_RESERVED);

    public enum Tag {
        ACCESS_ERROR,
        STATUS_ERROR,
        TEAM_SHARED_DROPBOX_ERROR,
        OTHER,
        INVALID_FOLDER_NAME,
        FOLDER_NAME_ALREADY_USED,
        FOLDER_NAME_RESERVED
    }

    private TeamFolderRenameError() {
    }

    private TeamFolderRenameError withTag(Tag tag) {
        TeamFolderRenameError teamFolderRenameError = new TeamFolderRenameError();
        teamFolderRenameError._tag = tag;
        return teamFolderRenameError;
    }

    private TeamFolderRenameError withTagAndAccessError(Tag tag, TeamFolderAccessError teamFolderAccessError) {
        TeamFolderRenameError teamFolderRenameError = new TeamFolderRenameError();
        teamFolderRenameError._tag = tag;
        teamFolderRenameError.accessErrorValue = teamFolderAccessError;
        return teamFolderRenameError;
    }

    private TeamFolderRenameError withTagAndStatusError(Tag tag, TeamFolderInvalidStatusError teamFolderInvalidStatusError) {
        TeamFolderRenameError teamFolderRenameError = new TeamFolderRenameError();
        teamFolderRenameError._tag = tag;
        teamFolderRenameError.statusErrorValue = teamFolderInvalidStatusError;
        return teamFolderRenameError;
    }

    private TeamFolderRenameError withTagAndTeamSharedDropboxError(Tag tag, TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError) {
        TeamFolderRenameError teamFolderRenameError = new TeamFolderRenameError();
        teamFolderRenameError._tag = tag;
        teamFolderRenameError.teamSharedDropboxErrorValue = teamFolderTeamSharedDropboxError;
        return teamFolderRenameError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static TeamFolderRenameError accessError(TeamFolderAccessError teamFolderAccessError) {
        if (teamFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderRenameError().withTagAndAccessError(Tag.ACCESS_ERROR, teamFolderAccessError);
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

    public static TeamFolderRenameError statusError(TeamFolderInvalidStatusError teamFolderInvalidStatusError) {
        if (teamFolderInvalidStatusError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderRenameError().withTagAndStatusError(Tag.STATUS_ERROR, teamFolderInvalidStatusError);
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

    public static TeamFolderRenameError teamSharedDropboxError(TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError) {
        if (teamFolderTeamSharedDropboxError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderRenameError().withTagAndTeamSharedDropboxError(Tag.TEAM_SHARED_DROPBOX_ERROR, teamFolderTeamSharedDropboxError);
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

    public boolean isInvalidFolderName() {
        return this._tag == Tag.INVALID_FOLDER_NAME;
    }

    public boolean isFolderNameAlreadyUsed() {
        return this._tag == Tag.FOLDER_NAME_ALREADY_USED;
    }

    public boolean isFolderNameReserved() {
        return this._tag == Tag.FOLDER_NAME_RESERVED;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue, this.statusErrorValue, this.teamSharedDropboxErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TeamFolderRenameError)) {
            return false;
        }
        TeamFolderRenameError teamFolderRenameError = (TeamFolderRenameError) obj;
        if (this._tag != teamFolderRenameError._tag) {
            return false;
        }
        switch (C44101.$SwitchMap$com$dropbox$core$v2$team$TeamFolderRenameError$Tag[this._tag.ordinal()]) {
            case 1:
                TeamFolderAccessError teamFolderAccessError = this.accessErrorValue;
                TeamFolderAccessError teamFolderAccessError2 = teamFolderRenameError.accessErrorValue;
                return teamFolderAccessError == teamFolderAccessError2 || teamFolderAccessError.equals(teamFolderAccessError2);
            case 2:
                TeamFolderInvalidStatusError teamFolderInvalidStatusError = this.statusErrorValue;
                TeamFolderInvalidStatusError teamFolderInvalidStatusError2 = teamFolderRenameError.statusErrorValue;
                return teamFolderInvalidStatusError == teamFolderInvalidStatusError2 || teamFolderInvalidStatusError.equals(teamFolderInvalidStatusError2);
            case 3:
                TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError = this.teamSharedDropboxErrorValue;
                TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError2 = teamFolderRenameError.teamSharedDropboxErrorValue;
                return teamFolderTeamSharedDropboxError == teamFolderTeamSharedDropboxError2 || teamFolderTeamSharedDropboxError.equals(teamFolderTeamSharedDropboxError2);
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderRenameError$1 */
    static /* synthetic */ class C44101 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamFolderRenameError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamFolderRenameError$Tag = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderRenameError$Tag[Tag.STATUS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderRenameError$Tag[Tag.TEAM_SHARED_DROPBOX_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderRenameError$Tag[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderRenameError$Tag[Tag.INVALID_FOLDER_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderRenameError$Tag[Tag.FOLDER_NAME_ALREADY_USED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderRenameError$Tag[Tag.FOLDER_NAME_RESERVED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<TeamFolderRenameError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderRenameError teamFolderRenameError, JsonGenerator jsonGenerator) throws IOException {
            switch (C44101.$SwitchMap$com$dropbox$core$v2$team$TeamFolderRenameError$Tag[teamFolderRenameError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("access_error", jsonGenerator);
                    jsonGenerator.writeFieldName("access_error");
                    TeamFolderAccessError.Serializer.INSTANCE.serialize(teamFolderRenameError.accessErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("status_error", jsonGenerator);
                    jsonGenerator.writeFieldName("status_error");
                    TeamFolderInvalidStatusError.Serializer.INSTANCE.serialize(teamFolderRenameError.statusErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag("team_shared_dropbox_error", jsonGenerator);
                    jsonGenerator.writeFieldName("team_shared_dropbox_error");
                    TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.serialize(teamFolderRenameError.teamSharedDropboxErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 4:
                    jsonGenerator.writeString("other");
                    return;
                case 5:
                    jsonGenerator.writeString("invalid_folder_name");
                    return;
                case 6:
                    jsonGenerator.writeString("folder_name_already_used");
                    return;
                case 7:
                    jsonGenerator.writeString("folder_name_reserved");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + teamFolderRenameError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderRenameError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderRenameError teamFolderRenameErrorTeamSharedDropboxError;
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
                teamFolderRenameErrorTeamSharedDropboxError = TeamFolderRenameError.accessError(TeamFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("status_error".equals(tag)) {
                expectField("status_error", jsonParser);
                teamFolderRenameErrorTeamSharedDropboxError = TeamFolderRenameError.statusError(TeamFolderInvalidStatusError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("team_shared_dropbox_error".equals(tag)) {
                expectField("team_shared_dropbox_error", jsonParser);
                teamFolderRenameErrorTeamSharedDropboxError = TeamFolderRenameError.teamSharedDropboxError(TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("other".equals(tag)) {
                teamFolderRenameErrorTeamSharedDropboxError = TeamFolderRenameError.OTHER;
            } else if ("invalid_folder_name".equals(tag)) {
                teamFolderRenameErrorTeamSharedDropboxError = TeamFolderRenameError.INVALID_FOLDER_NAME;
            } else if ("folder_name_already_used".equals(tag)) {
                teamFolderRenameErrorTeamSharedDropboxError = TeamFolderRenameError.FOLDER_NAME_ALREADY_USED;
            } else if ("folder_name_reserved".equals(tag)) {
                teamFolderRenameErrorTeamSharedDropboxError = TeamFolderRenameError.FOLDER_NAME_RESERVED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderRenameErrorTeamSharedDropboxError;
        }
    }
}
