package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamMemberInfoV2;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class TeamMemberInfoV2Result {

    @Nonnull
    protected final TeamMemberInfoV2 memberInfo;

    public TeamMemberInfoV2Result(@Nonnull TeamMemberInfoV2 teamMemberInfoV2) {
        if (teamMemberInfoV2 == null) {
            throw new IllegalArgumentException("Required value for 'memberInfo' is null");
        }
        this.memberInfo = teamMemberInfoV2;
    }

    @Nonnull
    public TeamMemberInfoV2 getMemberInfo() {
        return this.memberInfo;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.memberInfo});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMemberInfoV2 teamMemberInfoV2 = this.memberInfo;
        TeamMemberInfoV2 teamMemberInfoV22 = ((TeamMemberInfoV2Result) obj).memberInfo;
        return teamMemberInfoV2 == teamMemberInfoV22 || teamMemberInfoV2.equals(teamMemberInfoV22);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMemberInfoV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMemberInfoV2Result teamMemberInfoV2Result, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("member_info");
            TeamMemberInfoV2.Serializer.INSTANCE.serialize(teamMemberInfoV2Result.memberInfo, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMemberInfoV2Result deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamMemberInfoV2 teamMemberInfoV2Deserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("member_info".equals(currentName)) {
                        teamMemberInfoV2Deserialize = TeamMemberInfoV2.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamMemberInfoV2Deserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member_info\" missing.");
                }
                TeamMemberInfoV2Result teamMemberInfoV2Result = new TeamMemberInfoV2Result(teamMemberInfoV2Deserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMemberInfoV2Result, teamMemberInfoV2Result.toStringMultiline());
                return teamMemberInfoV2Result;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
