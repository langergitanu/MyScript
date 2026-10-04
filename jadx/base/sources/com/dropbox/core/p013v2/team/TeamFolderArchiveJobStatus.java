package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamFolderArchiveError;
import com.dropbox.core.p013v2.team.TeamFolderMetadata;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class TeamFolderArchiveJobStatus {
    public static final TeamFolderArchiveJobStatus IN_PROGRESS = new TeamFolderArchiveJobStatus().withTag(Tag.IN_PROGRESS);
    private Tag _tag;
    private TeamFolderMetadata completeValue;
    private TeamFolderArchiveError failedValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    private TeamFolderArchiveJobStatus() {
    }

    private TeamFolderArchiveJobStatus withTag(Tag tag) {
        TeamFolderArchiveJobStatus teamFolderArchiveJobStatus = new TeamFolderArchiveJobStatus();
        teamFolderArchiveJobStatus._tag = tag;
        return teamFolderArchiveJobStatus;
    }

    private TeamFolderArchiveJobStatus withTagAndComplete(Tag tag, TeamFolderMetadata teamFolderMetadata) {
        TeamFolderArchiveJobStatus teamFolderArchiveJobStatus = new TeamFolderArchiveJobStatus();
        teamFolderArchiveJobStatus._tag = tag;
        teamFolderArchiveJobStatus.completeValue = teamFolderMetadata;
        return teamFolderArchiveJobStatus;
    }

    private TeamFolderArchiveJobStatus withTagAndFailed(Tag tag, TeamFolderArchiveError teamFolderArchiveError) {
        TeamFolderArchiveJobStatus teamFolderArchiveJobStatus = new TeamFolderArchiveJobStatus();
        teamFolderArchiveJobStatus._tag = tag;
        teamFolderArchiveJobStatus.failedValue = teamFolderArchiveError;
        return teamFolderArchiveJobStatus;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInProgress() {
        return this._tag == Tag.IN_PROGRESS;
    }

    public boolean isComplete() {
        return this._tag == Tag.COMPLETE;
    }

    public static TeamFolderArchiveJobStatus complete(TeamFolderMetadata teamFolderMetadata) {
        if (teamFolderMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderArchiveJobStatus().withTagAndComplete(Tag.COMPLETE, teamFolderMetadata);
    }

    public TeamFolderMetadata getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isFailed() {
        return this._tag == Tag.FAILED;
    }

    public static TeamFolderArchiveJobStatus failed(TeamFolderArchiveError teamFolderArchiveError) {
        if (teamFolderArchiveError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderArchiveJobStatus().withTagAndFailed(Tag.FAILED, teamFolderArchiveError);
    }

    public TeamFolderArchiveError getFailedValue() {
        if (this._tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + this._tag.name());
        }
        return this.failedValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.completeValue, this.failedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TeamFolderArchiveJobStatus)) {
            return false;
        }
        TeamFolderArchiveJobStatus teamFolderArchiveJobStatus = (TeamFolderArchiveJobStatus) obj;
        if (this._tag != teamFolderArchiveJobStatus._tag) {
            return false;
        }
        int i = C44031.f767x4b528ea7[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                TeamFolderArchiveError teamFolderArchiveError = this.failedValue;
                TeamFolderArchiveError teamFolderArchiveError2 = teamFolderArchiveJobStatus.failedValue;
                return teamFolderArchiveError == teamFolderArchiveError2 || teamFolderArchiveError.equals(teamFolderArchiveError2);
            }
            TeamFolderMetadata teamFolderMetadata = this.completeValue;
            TeamFolderMetadata teamFolderMetadata2 = teamFolderArchiveJobStatus.completeValue;
            if (teamFolderMetadata != teamFolderMetadata2 && !teamFolderMetadata.equals(teamFolderMetadata2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderArchiveJobStatus$1 */
    static /* synthetic */ class C44031 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveJobStatus$Tag */
        static final /* synthetic */ int[] f767x4b528ea7;

        static {
            int[] iArr = new int[Tag.values().length];
            f767x4b528ea7 = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f767x4b528ea7[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f767x4b528ea7[Tag.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<TeamFolderArchiveJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderArchiveJobStatus teamFolderArchiveJobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C44031.f767x4b528ea7[teamFolderArchiveJobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                TeamFolderMetadata.Serializer.INSTANCE.serialize(teamFolderArchiveJobStatus.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("failed", jsonGenerator);
                jsonGenerator.writeFieldName("failed");
                TeamFolderArchiveError.Serializer.INSTANCE.serialize(teamFolderArchiveJobStatus.failedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + teamFolderArchiveJobStatus.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderArchiveJobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderArchiveJobStatus teamFolderArchiveJobStatusFailed;
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
            if ("in_progress".equals(tag)) {
                teamFolderArchiveJobStatusFailed = TeamFolderArchiveJobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                teamFolderArchiveJobStatusFailed = TeamFolderArchiveJobStatus.complete(TeamFolderMetadata.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failed".equals(tag)) {
                expectField("failed", jsonParser);
                teamFolderArchiveJobStatusFailed = TeamFolderArchiveJobStatus.failed(TeamFolderArchiveError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderArchiveJobStatusFailed;
        }
    }
}
