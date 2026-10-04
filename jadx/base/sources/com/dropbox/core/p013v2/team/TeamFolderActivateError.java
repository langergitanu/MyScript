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
public final class TeamFolderActivateError {
    public static final TeamFolderActivateError OTHER = new TeamFolderActivateError().withTag(Tag.OTHER);
    private Tag _tag;
    private TeamFolderAccessError accessErrorValue;
    private TeamFolderInvalidStatusError statusErrorValue;
    private TeamFolderTeamSharedDropboxError teamSharedDropboxErrorValue;

    public enum Tag {
        ACCESS_ERROR,
        STATUS_ERROR,
        TEAM_SHARED_DROPBOX_ERROR,
        OTHER
    }

    private TeamFolderActivateError() {
    }

    private TeamFolderActivateError withTag(Tag tag) {
        TeamFolderActivateError teamFolderActivateError = new TeamFolderActivateError();
        teamFolderActivateError._tag = tag;
        return teamFolderActivateError;
    }

    private TeamFolderActivateError withTagAndAccessError(Tag tag, TeamFolderAccessError teamFolderAccessError) {
        TeamFolderActivateError teamFolderActivateError = new TeamFolderActivateError();
        teamFolderActivateError._tag = tag;
        teamFolderActivateError.accessErrorValue = teamFolderAccessError;
        return teamFolderActivateError;
    }

    private TeamFolderActivateError withTagAndStatusError(Tag tag, TeamFolderInvalidStatusError teamFolderInvalidStatusError) {
        TeamFolderActivateError teamFolderActivateError = new TeamFolderActivateError();
        teamFolderActivateError._tag = tag;
        teamFolderActivateError.statusErrorValue = teamFolderInvalidStatusError;
        return teamFolderActivateError;
    }

    private TeamFolderActivateError withTagAndTeamSharedDropboxError(Tag tag, TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError) {
        TeamFolderActivateError teamFolderActivateError = new TeamFolderActivateError();
        teamFolderActivateError._tag = tag;
        teamFolderActivateError.teamSharedDropboxErrorValue = teamFolderTeamSharedDropboxError;
        return teamFolderActivateError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static TeamFolderActivateError accessError(TeamFolderAccessError teamFolderAccessError) {
        if (teamFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderActivateError().withTagAndAccessError(Tag.ACCESS_ERROR, teamFolderAccessError);
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

    public static TeamFolderActivateError statusError(TeamFolderInvalidStatusError teamFolderInvalidStatusError) {
        if (teamFolderInvalidStatusError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderActivateError().withTagAndStatusError(Tag.STATUS_ERROR, teamFolderInvalidStatusError);
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

    public static TeamFolderActivateError teamSharedDropboxError(TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError) {
        if (teamFolderTeamSharedDropboxError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderActivateError().withTagAndTeamSharedDropboxError(Tag.TEAM_SHARED_DROPBOX_ERROR, teamFolderTeamSharedDropboxError);
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

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue, this.statusErrorValue, this.teamSharedDropboxErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TeamFolderActivateError)) {
            return false;
        }
        TeamFolderActivateError teamFolderActivateError = (TeamFolderActivateError) obj;
        if (this._tag != teamFolderActivateError._tag) {
            return false;
        }
        int i = C44011.$SwitchMap$com$dropbox$core$v2$team$TeamFolderActivateError$Tag[this._tag.ordinal()];
        if (i == 1) {
            TeamFolderAccessError teamFolderAccessError = this.accessErrorValue;
            TeamFolderAccessError teamFolderAccessError2 = teamFolderActivateError.accessErrorValue;
            return teamFolderAccessError == teamFolderAccessError2 || teamFolderAccessError.equals(teamFolderAccessError2);
        }
        if (i == 2) {
            TeamFolderInvalidStatusError teamFolderInvalidStatusError = this.statusErrorValue;
            TeamFolderInvalidStatusError teamFolderInvalidStatusError2 = teamFolderActivateError.statusErrorValue;
            return teamFolderInvalidStatusError == teamFolderInvalidStatusError2 || teamFolderInvalidStatusError.equals(teamFolderInvalidStatusError2);
        }
        if (i != 3) {
            return i == 4;
        }
        TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError = this.teamSharedDropboxErrorValue;
        TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError2 = teamFolderActivateError.teamSharedDropboxErrorValue;
        return teamFolderTeamSharedDropboxError == teamFolderTeamSharedDropboxError2 || teamFolderTeamSharedDropboxError.equals(teamFolderTeamSharedDropboxError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderActivateError$1 */
    static /* synthetic */ class C44011 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamFolderActivateError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamFolderActivateError$Tag = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderActivateError$Tag[Tag.STATUS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderActivateError$Tag[Tag.TEAM_SHARED_DROPBOX_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderActivateError$Tag[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<TeamFolderActivateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderActivateError teamFolderActivateError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44011.$SwitchMap$com$dropbox$core$v2$team$TeamFolderActivateError$Tag[teamFolderActivateError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                TeamFolderAccessError.Serializer.INSTANCE.serialize(teamFolderActivateError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("status_error", jsonGenerator);
                jsonGenerator.writeFieldName("status_error");
                TeamFolderInvalidStatusError.Serializer.INSTANCE.serialize(teamFolderActivateError.statusErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i != 3) {
                if (i == 4) {
                    jsonGenerator.writeString("other");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + teamFolderActivateError.tag());
            }
            jsonGenerator.writeStartObject();
            writeTag("team_shared_dropbox_error", jsonGenerator);
            jsonGenerator.writeFieldName("team_shared_dropbox_error");
            TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.serialize(teamFolderActivateError.teamSharedDropboxErrorValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderActivateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderActivateError teamFolderActivateErrorTeamSharedDropboxError;
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
                teamFolderActivateErrorTeamSharedDropboxError = TeamFolderActivateError.accessError(TeamFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("status_error".equals(tag)) {
                expectField("status_error", jsonParser);
                teamFolderActivateErrorTeamSharedDropboxError = TeamFolderActivateError.statusError(TeamFolderInvalidStatusError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("team_shared_dropbox_error".equals(tag)) {
                expectField("team_shared_dropbox_error", jsonParser);
                teamFolderActivateErrorTeamSharedDropboxError = TeamFolderActivateError.teamSharedDropboxError(TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("other".equals(tag)) {
                teamFolderActivateErrorTeamSharedDropboxError = TeamFolderActivateError.OTHER;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderActivateErrorTeamSharedDropboxError;
        }
    }
}
