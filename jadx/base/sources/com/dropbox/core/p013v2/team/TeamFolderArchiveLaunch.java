package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamFolderMetadata;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class TeamFolderArchiveLaunch {
    private Tag _tag;
    private String asyncJobIdValue;
    private TeamFolderMetadata completeValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE
    }

    private TeamFolderArchiveLaunch() {
    }

    private TeamFolderArchiveLaunch withTag(Tag tag) {
        TeamFolderArchiveLaunch teamFolderArchiveLaunch = new TeamFolderArchiveLaunch();
        teamFolderArchiveLaunch._tag = tag;
        return teamFolderArchiveLaunch;
    }

    private TeamFolderArchiveLaunch withTagAndAsyncJobId(Tag tag, String str) {
        TeamFolderArchiveLaunch teamFolderArchiveLaunch = new TeamFolderArchiveLaunch();
        teamFolderArchiveLaunch._tag = tag;
        teamFolderArchiveLaunch.asyncJobIdValue = str;
        return teamFolderArchiveLaunch;
    }

    private TeamFolderArchiveLaunch withTagAndComplete(Tag tag, TeamFolderMetadata teamFolderMetadata) {
        TeamFolderArchiveLaunch teamFolderArchiveLaunch = new TeamFolderArchiveLaunch();
        teamFolderArchiveLaunch._tag = tag;
        teamFolderArchiveLaunch.completeValue = teamFolderMetadata;
        return teamFolderArchiveLaunch;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static TeamFolderArchiveLaunch asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new TeamFolderArchiveLaunch().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
    }

    public String getAsyncJobIdValue() {
        if (this._tag != Tag.ASYNC_JOB_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.ASYNC_JOB_ID, but was Tag." + this._tag.name());
        }
        return this.asyncJobIdValue;
    }

    public boolean isComplete() {
        return this._tag == Tag.COMPLETE;
    }

    public static TeamFolderArchiveLaunch complete(TeamFolderMetadata teamFolderMetadata) {
        if (teamFolderMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderArchiveLaunch().withTagAndComplete(Tag.COMPLETE, teamFolderMetadata);
    }

    public TeamFolderMetadata getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.asyncJobIdValue, this.completeValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TeamFolderArchiveLaunch)) {
            return false;
        }
        TeamFolderArchiveLaunch teamFolderArchiveLaunch = (TeamFolderArchiveLaunch) obj;
        if (this._tag != teamFolderArchiveLaunch._tag) {
            return false;
        }
        int i = C44041.$SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveLaunch$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.asyncJobIdValue;
            String str2 = teamFolderArchiveLaunch.asyncJobIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return false;
        }
        TeamFolderMetadata teamFolderMetadata = this.completeValue;
        TeamFolderMetadata teamFolderMetadata2 = teamFolderArchiveLaunch.completeValue;
        return teamFolderMetadata == teamFolderMetadata2 || teamFolderMetadata.equals(teamFolderMetadata2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderArchiveLaunch$1 */
    static /* synthetic */ class C44041 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveLaunch$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveLaunch$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveLaunch$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<TeamFolderArchiveLaunch> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderArchiveLaunch teamFolderArchiveLaunch, JsonGenerator jsonGenerator) throws IOException {
            int i = C44041.$SwitchMap$com$dropbox$core$v2$team$TeamFolderArchiveLaunch$Tag[teamFolderArchiveLaunch.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(teamFolderArchiveLaunch.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                TeamFolderMetadata.Serializer.INSTANCE.serialize(teamFolderArchiveLaunch.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + teamFolderArchiveLaunch.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderArchiveLaunch deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderArchiveLaunch teamFolderArchiveLaunchComplete;
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
            if ("async_job_id".equals(tag)) {
                expectField("async_job_id", jsonParser);
                teamFolderArchiveLaunchComplete = TeamFolderArchiveLaunch.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                teamFolderArchiveLaunchComplete = TeamFolderArchiveLaunch.complete(TeamFolderMetadata.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderArchiveLaunchComplete;
        }
    }
}
