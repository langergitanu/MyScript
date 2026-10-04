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
public final class TeamFolderArchiveError {
    public static final TeamFolderArchiveError OTHER = new TeamFolderArchiveError().withTag(Tag.OTHER);
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

    private TeamFolderArchiveError() {
    }

    private TeamFolderArchiveError withTag(Tag tag) {
        TeamFolderArchiveError teamFolderArchiveError = new TeamFolderArchiveError();
        teamFolderArchiveError._tag = tag;
        return teamFolderArchiveError;
    }

    private TeamFolderArchiveError withTagAndAccessError(Tag tag, TeamFolderAccessError teamFolderAccessError) {
        TeamFolderArchiveError teamFolderArchiveError = new TeamFolderArchiveError();
        teamFolderArchiveError._tag = tag;
        teamFolderArchiveError.accessErrorValue = teamFolderAccessError;
        return teamFolderArchiveError;
    }

    private TeamFolderArchiveError withTagAndStatusError(Tag tag, TeamFolderInvalidStatusError teamFolderInvalidStatusError) {
        TeamFolderArchiveError teamFolderArchiveError = new TeamFolderArchiveError();
        teamFolderArchiveError._tag = tag;
        teamFolderArchiveError.statusErrorValue = teamFolderInvalidStatusError;
        return teamFolderArchiveError;
    }

    private TeamFolderArchiveError withTagAndTeamSharedDropboxError(Tag tag, TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError) {
        TeamFolderArchiveError teamFolderArchiveError = new TeamFolderArchiveError();
        teamFolderArchiveError._tag = tag;
        teamFolderArchiveError.teamSharedDropboxErrorValue = teamFolderTeamSharedDropboxError;
        return teamFolderArchiveError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static TeamFolderArchiveError accessError(TeamFolderAccessError teamFolderAccessError) {
        if (teamFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderArchiveError().withTagAndAccessError(Tag.ACCESS_ERROR, teamFolderAccessError);
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

    public static TeamFolderArchiveError statusError(TeamFolderInvalidStatusError teamFolderInvalidStatusError) {
        if (teamFolderInvalidStatusError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderArchiveError().withTagAndStatusError(Tag.STATUS_ERROR, teamFolderInvalidStatusError);
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

    public static TeamFolderArchiveError teamSharedDropboxError(TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError) {
        if (teamFolderTeamSharedDropboxError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderArchiveError().withTagAndTeamSharedDropboxError(Tag.TEAM_SHARED_DROPBOX_ERROR, teamFolderTeamSharedDropboxError);
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
        if (obj == null || !(obj instanceof TeamFolderArchiveError)) {
            return false;
        }
        TeamFolderArchiveError teamFolderArchiveError = (TeamFolderArchiveError) obj;
        if (this._tag != teamFolderArchiveError._tag) {
            return false;
        }
        int i = C44021.$SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveError$Tag[this._tag.ordinal()];
        if (i == 1) {
            TeamFolderAccessError teamFolderAccessError = this.accessErrorValue;
            TeamFolderAccessError teamFolderAccessError2 = teamFolderArchiveError.accessErrorValue;
            return teamFolderAccessError == teamFolderAccessError2 || teamFolderAccessError.equals(teamFolderAccessError2);
        }
        if (i == 2) {
            TeamFolderInvalidStatusError teamFolderInvalidStatusError = this.statusErrorValue;
            TeamFolderInvalidStatusError teamFolderInvalidStatusError2 = teamFolderArchiveError.statusErrorValue;
            return teamFolderInvalidStatusError == teamFolderInvalidStatusError2 || teamFolderInvalidStatusError.equals(teamFolderInvalidStatusError2);
        }
        if (i != 3) {
            return i == 4;
        }
        TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError = this.teamSharedDropboxErrorValue;
        TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError2 = teamFolderArchiveError.teamSharedDropboxErrorValue;
        return teamFolderTeamSharedDropboxError == teamFolderTeamSharedDropboxError2 || teamFolderTeamSharedDropboxError.equals(teamFolderTeamSharedDropboxError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderArchiveError$1 */
    static /* synthetic */ class C44021 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveError$Tag = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveError$Tag[Tag.STATUS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveError$Tag[Tag.TEAM_SHARED_DROPBOX_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveError$Tag[Tag.OTHER.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<TeamFolderArchiveError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        /* JADX WARN: Failed to analyze thrown exceptions
        java.util.ConcurrentModificationException
        	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1605)
        	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1628)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.mergeExceptions(MethodThrowsVisitor.java:100)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:86)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
         */
        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderArchiveError teamFolderArchiveError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44021.$SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveError$Tag[teamFolderArchiveError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                TeamFolderAccessError.Serializer.INSTANCE.serialize(teamFolderArchiveError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("status_error", jsonGenerator);
                jsonGenerator.writeFieldName("status_error");
                TeamFolderInvalidStatusError.Serializer.INSTANCE.serialize(teamFolderArchiveError.statusErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i != 3) {
                if (i == 4) {
                    jsonGenerator.writeString("other");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + teamFolderArchiveError.tag());
            }
            jsonGenerator.writeStartObject();
            writeTag("team_shared_dropbox_error", jsonGenerator);
            jsonGenerator.writeFieldName("team_shared_dropbox_error");
            TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.serialize(teamFolderArchiveError.teamSharedDropboxErrorValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderArchiveError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderArchiveError teamFolderArchiveErrorTeamSharedDropboxError;
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
                teamFolderArchiveErrorTeamSharedDropboxError = TeamFolderArchiveError.accessError(TeamFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("status_error".equals(tag)) {
                expectField("status_error", jsonParser);
                teamFolderArchiveErrorTeamSharedDropboxError = TeamFolderArchiveError.statusError(TeamFolderInvalidStatusError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("team_shared_dropbox_error".equals(tag)) {
                expectField("team_shared_dropbox_error", jsonParser);
                teamFolderArchiveErrorTeamSharedDropboxError = TeamFolderArchiveError.teamSharedDropboxError(TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("other".equals(tag)) {
                teamFolderArchiveErrorTeamSharedDropboxError = TeamFolderArchiveError.OTHER;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderArchiveErrorTeamSharedDropboxError;
        }
    }
}
