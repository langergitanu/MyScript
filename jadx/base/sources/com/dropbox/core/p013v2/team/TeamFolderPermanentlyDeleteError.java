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
public final class TeamFolderPermanentlyDeleteError {
    public static final TeamFolderPermanentlyDeleteError OTHER = new TeamFolderPermanentlyDeleteError().withTag(Tag.OTHER);
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

    private TeamFolderPermanentlyDeleteError() {
    }

    private TeamFolderPermanentlyDeleteError withTag(Tag tag) {
        TeamFolderPermanentlyDeleteError teamFolderPermanentlyDeleteError = new TeamFolderPermanentlyDeleteError();
        teamFolderPermanentlyDeleteError._tag = tag;
        return teamFolderPermanentlyDeleteError;
    }

    private TeamFolderPermanentlyDeleteError withTagAndAccessError(Tag tag, TeamFolderAccessError teamFolderAccessError) {
        TeamFolderPermanentlyDeleteError teamFolderPermanentlyDeleteError = new TeamFolderPermanentlyDeleteError();
        teamFolderPermanentlyDeleteError._tag = tag;
        teamFolderPermanentlyDeleteError.accessErrorValue = teamFolderAccessError;
        return teamFolderPermanentlyDeleteError;
    }

    private TeamFolderPermanentlyDeleteError withTagAndStatusError(Tag tag, TeamFolderInvalidStatusError teamFolderInvalidStatusError) {
        TeamFolderPermanentlyDeleteError teamFolderPermanentlyDeleteError = new TeamFolderPermanentlyDeleteError();
        teamFolderPermanentlyDeleteError._tag = tag;
        teamFolderPermanentlyDeleteError.statusErrorValue = teamFolderInvalidStatusError;
        return teamFolderPermanentlyDeleteError;
    }

    private TeamFolderPermanentlyDeleteError withTagAndTeamSharedDropboxError(Tag tag, TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError) {
        TeamFolderPermanentlyDeleteError teamFolderPermanentlyDeleteError = new TeamFolderPermanentlyDeleteError();
        teamFolderPermanentlyDeleteError._tag = tag;
        teamFolderPermanentlyDeleteError.teamSharedDropboxErrorValue = teamFolderTeamSharedDropboxError;
        return teamFolderPermanentlyDeleteError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static TeamFolderPermanentlyDeleteError accessError(TeamFolderAccessError teamFolderAccessError) {
        if (teamFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderPermanentlyDeleteError().withTagAndAccessError(Tag.ACCESS_ERROR, teamFolderAccessError);
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

    public static TeamFolderPermanentlyDeleteError statusError(TeamFolderInvalidStatusError teamFolderInvalidStatusError) {
        if (teamFolderInvalidStatusError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderPermanentlyDeleteError().withTagAndStatusError(Tag.STATUS_ERROR, teamFolderInvalidStatusError);
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

    public static TeamFolderPermanentlyDeleteError teamSharedDropboxError(TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError) {
        if (teamFolderTeamSharedDropboxError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderPermanentlyDeleteError().withTagAndTeamSharedDropboxError(Tag.TEAM_SHARED_DROPBOX_ERROR, teamFolderTeamSharedDropboxError);
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
        if (obj == null || !(obj instanceof TeamFolderPermanentlyDeleteError)) {
            return false;
        }
        TeamFolderPermanentlyDeleteError teamFolderPermanentlyDeleteError = (TeamFolderPermanentlyDeleteError) obj;
        if (this._tag != teamFolderPermanentlyDeleteError._tag) {
            return false;
        }
        int i = C44091.f768x3f9e771c[this._tag.ordinal()];
        if (i == 1) {
            TeamFolderAccessError teamFolderAccessError = this.accessErrorValue;
            TeamFolderAccessError teamFolderAccessError2 = teamFolderPermanentlyDeleteError.accessErrorValue;
            return teamFolderAccessError == teamFolderAccessError2 || teamFolderAccessError.equals(teamFolderAccessError2);
        }
        if (i == 2) {
            TeamFolderInvalidStatusError teamFolderInvalidStatusError = this.statusErrorValue;
            TeamFolderInvalidStatusError teamFolderInvalidStatusError2 = teamFolderPermanentlyDeleteError.statusErrorValue;
            return teamFolderInvalidStatusError == teamFolderInvalidStatusError2 || teamFolderInvalidStatusError.equals(teamFolderInvalidStatusError2);
        }
        if (i != 3) {
            return i == 4;
        }
        TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError = this.teamSharedDropboxErrorValue;
        TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError2 = teamFolderPermanentlyDeleteError.teamSharedDropboxErrorValue;
        return teamFolderTeamSharedDropboxError == teamFolderTeamSharedDropboxError2 || teamFolderTeamSharedDropboxError.equals(teamFolderTeamSharedDropboxError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderPermanentlyDeleteError$1 */
    static /* synthetic */ class C44091 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$TeamFolderPermanentlyDeleteError$Tag */
        static final /* synthetic */ int[] f768x3f9e771c;

        static {
            int[] iArr = new int[Tag.values().length];
            f768x3f9e771c = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f768x3f9e771c[Tag.STATUS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f768x3f9e771c[Tag.TEAM_SHARED_DROPBOX_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f768x3f9e771c[Tag.OTHER.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<TeamFolderPermanentlyDeleteError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderPermanentlyDeleteError teamFolderPermanentlyDeleteError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44091.f768x3f9e771c[teamFolderPermanentlyDeleteError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                TeamFolderAccessError.Serializer.INSTANCE.serialize(teamFolderPermanentlyDeleteError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("status_error", jsonGenerator);
                jsonGenerator.writeFieldName("status_error");
                TeamFolderInvalidStatusError.Serializer.INSTANCE.serialize(teamFolderPermanentlyDeleteError.statusErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i != 3) {
                if (i == 4) {
                    jsonGenerator.writeString("other");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + teamFolderPermanentlyDeleteError.tag());
            }
            jsonGenerator.writeStartObject();
            writeTag("team_shared_dropbox_error", jsonGenerator);
            jsonGenerator.writeFieldName("team_shared_dropbox_error");
            TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.serialize(teamFolderPermanentlyDeleteError.teamSharedDropboxErrorValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderPermanentlyDeleteError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderPermanentlyDeleteError teamFolderPermanentlyDeleteErrorTeamSharedDropboxError;
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
                teamFolderPermanentlyDeleteErrorTeamSharedDropboxError = TeamFolderPermanentlyDeleteError.accessError(TeamFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("status_error".equals(tag)) {
                expectField("status_error", jsonParser);
                teamFolderPermanentlyDeleteErrorTeamSharedDropboxError = TeamFolderPermanentlyDeleteError.statusError(TeamFolderInvalidStatusError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("team_shared_dropbox_error".equals(tag)) {
                expectField("team_shared_dropbox_error", jsonParser);
                teamFolderPermanentlyDeleteErrorTeamSharedDropboxError = TeamFolderPermanentlyDeleteError.teamSharedDropboxError(TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("other".equals(tag)) {
                teamFolderPermanentlyDeleteErrorTeamSharedDropboxError = TeamFolderPermanentlyDeleteError.OTHER;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderPermanentlyDeleteErrorTeamSharedDropboxError;
        }
    }
}
