package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamExtensionsPolicy;
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
public class TeamExtensionsPolicyChangedDetails {

    @Nonnull
    protected final TeamExtensionsPolicy newValue;

    @Nonnull
    protected final TeamExtensionsPolicy previousValue;

    public TeamExtensionsPolicyChangedDetails(@Nonnull TeamExtensionsPolicy teamExtensionsPolicy, @Nonnull TeamExtensionsPolicy teamExtensionsPolicy2) {
        if (teamExtensionsPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = teamExtensionsPolicy;
        if (teamExtensionsPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = teamExtensionsPolicy2;
    }

    @Nonnull
    public TeamExtensionsPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public TeamExtensionsPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        TeamExtensionsPolicy teamExtensionsPolicy;
        TeamExtensionsPolicy teamExtensionsPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamExtensionsPolicyChangedDetails teamExtensionsPolicyChangedDetails = (TeamExtensionsPolicyChangedDetails) obj;
        TeamExtensionsPolicy teamExtensionsPolicy3 = this.newValue;
        TeamExtensionsPolicy teamExtensionsPolicy4 = teamExtensionsPolicyChangedDetails.newValue;
        return (teamExtensionsPolicy3 == teamExtensionsPolicy4 || teamExtensionsPolicy3.equals(teamExtensionsPolicy4)) && ((teamExtensionsPolicy = this.previousValue) == (teamExtensionsPolicy2 = teamExtensionsPolicyChangedDetails.previousValue) || teamExtensionsPolicy.equals(teamExtensionsPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamExtensionsPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamExtensionsPolicyChangedDetails teamExtensionsPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            TeamExtensionsPolicy.Serializer.INSTANCE.serialize(teamExtensionsPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            TeamExtensionsPolicy.Serializer.INSTANCE.serialize(teamExtensionsPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamExtensionsPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamExtensionsPolicy teamExtensionsPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TeamExtensionsPolicy teamExtensionsPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        teamExtensionsPolicyDeserialize = TeamExtensionsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        teamExtensionsPolicyDeserialize2 = TeamExtensionsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamExtensionsPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (teamExtensionsPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                TeamExtensionsPolicyChangedDetails teamExtensionsPolicyChangedDetails = new TeamExtensionsPolicyChangedDetails(teamExtensionsPolicyDeserialize, teamExtensionsPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamExtensionsPolicyChangedDetails, teamExtensionsPolicyChangedDetails.toStringMultiline());
                return teamExtensionsPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
