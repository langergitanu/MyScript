package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamName;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class TeamProfileChangeNameDetails {

    @Nonnull
    protected final TeamName newValue;

    @Nullable
    protected final TeamName previousValue;

    public TeamProfileChangeNameDetails(@Nonnull TeamName teamName, @Nullable TeamName teamName2) {
        this.previousValue = teamName2;
        if (teamName == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = teamName;
    }

    public TeamProfileChangeNameDetails(@Nonnull TeamName teamName) {
        this(teamName, null);
    }

    @Nonnull
    public TeamName getNewValue() {
        return this.newValue;
    }

    @Nullable
    public TeamName getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        TeamName teamName;
        TeamName teamName2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamProfileChangeNameDetails teamProfileChangeNameDetails = (TeamProfileChangeNameDetails) obj;
        TeamName teamName3 = this.newValue;
        TeamName teamName4 = teamProfileChangeNameDetails.newValue;
        return (teamName3 == teamName4 || teamName3.equals(teamName4)) && ((teamName = this.previousValue) == (teamName2 = teamProfileChangeNameDetails.previousValue) || (teamName != null && teamName.equals(teamName2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamProfileChangeNameDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamProfileChangeNameDetails teamProfileChangeNameDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            TeamName.Serializer.INSTANCE.serialize(teamProfileChangeNameDetails.newValue, jsonGenerator);
            if (teamProfileChangeNameDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullableStruct(TeamName.Serializer.INSTANCE).serialize(teamProfileChangeNameDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamProfileChangeNameDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamName teamNameDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TeamName teamName = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        teamNameDeserialize = TeamName.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        teamName = (TeamName) StoneSerializers.nullableStruct(TeamName.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamNameDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                TeamProfileChangeNameDetails teamProfileChangeNameDetails = new TeamProfileChangeNameDetails(teamNameDeserialize, teamName);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamProfileChangeNameDetails, teamProfileChangeNameDetails.toStringMultiline());
                return teamProfileChangeNameDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
