package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamBrandingPolicy;
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
public class TeamBrandingPolicyChangedDetails {

    @Nonnull
    protected final TeamBrandingPolicy newValue;

    @Nonnull
    protected final TeamBrandingPolicy previousValue;

    public TeamBrandingPolicyChangedDetails(@Nonnull TeamBrandingPolicy teamBrandingPolicy, @Nonnull TeamBrandingPolicy teamBrandingPolicy2) {
        if (teamBrandingPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = teamBrandingPolicy;
        if (teamBrandingPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = teamBrandingPolicy2;
    }

    @Nonnull
    public TeamBrandingPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public TeamBrandingPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        TeamBrandingPolicy teamBrandingPolicy;
        TeamBrandingPolicy teamBrandingPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamBrandingPolicyChangedDetails teamBrandingPolicyChangedDetails = (TeamBrandingPolicyChangedDetails) obj;
        TeamBrandingPolicy teamBrandingPolicy3 = this.newValue;
        TeamBrandingPolicy teamBrandingPolicy4 = teamBrandingPolicyChangedDetails.newValue;
        return (teamBrandingPolicy3 == teamBrandingPolicy4 || teamBrandingPolicy3.equals(teamBrandingPolicy4)) && ((teamBrandingPolicy = this.previousValue) == (teamBrandingPolicy2 = teamBrandingPolicyChangedDetails.previousValue) || teamBrandingPolicy.equals(teamBrandingPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamBrandingPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamBrandingPolicyChangedDetails teamBrandingPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            TeamBrandingPolicy.Serializer.INSTANCE.serialize(teamBrandingPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            TeamBrandingPolicy.Serializer.INSTANCE.serialize(teamBrandingPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamBrandingPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamBrandingPolicy teamBrandingPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TeamBrandingPolicy teamBrandingPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        teamBrandingPolicyDeserialize = TeamBrandingPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        teamBrandingPolicyDeserialize2 = TeamBrandingPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamBrandingPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (teamBrandingPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                TeamBrandingPolicyChangedDetails teamBrandingPolicyChangedDetails = new TeamBrandingPolicyChangedDetails(teamBrandingPolicyDeserialize, teamBrandingPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamBrandingPolicyChangedDetails, teamBrandingPolicyChangedDetails.toStringMultiline());
                return teamBrandingPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
