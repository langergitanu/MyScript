package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamSelectiveSyncPolicy;
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
public class TeamSelectiveSyncPolicyChangedDetails {

    @Nonnull
    protected final TeamSelectiveSyncPolicy newValue;

    @Nonnull
    protected final TeamSelectiveSyncPolicy previousValue;

    public TeamSelectiveSyncPolicyChangedDetails(@Nonnull TeamSelectiveSyncPolicy teamSelectiveSyncPolicy, @Nonnull TeamSelectiveSyncPolicy teamSelectiveSyncPolicy2) {
        if (teamSelectiveSyncPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = teamSelectiveSyncPolicy;
        if (teamSelectiveSyncPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = teamSelectiveSyncPolicy2;
    }

    @Nonnull
    public TeamSelectiveSyncPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public TeamSelectiveSyncPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        TeamSelectiveSyncPolicy teamSelectiveSyncPolicy;
        TeamSelectiveSyncPolicy teamSelectiveSyncPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamSelectiveSyncPolicyChangedDetails teamSelectiveSyncPolicyChangedDetails = (TeamSelectiveSyncPolicyChangedDetails) obj;
        TeamSelectiveSyncPolicy teamSelectiveSyncPolicy3 = this.newValue;
        TeamSelectiveSyncPolicy teamSelectiveSyncPolicy4 = teamSelectiveSyncPolicyChangedDetails.newValue;
        return (teamSelectiveSyncPolicy3 == teamSelectiveSyncPolicy4 || teamSelectiveSyncPolicy3.equals(teamSelectiveSyncPolicy4)) && ((teamSelectiveSyncPolicy = this.previousValue) == (teamSelectiveSyncPolicy2 = teamSelectiveSyncPolicyChangedDetails.previousValue) || teamSelectiveSyncPolicy.equals(teamSelectiveSyncPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamSelectiveSyncPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamSelectiveSyncPolicyChangedDetails teamSelectiveSyncPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            TeamSelectiveSyncPolicy.Serializer.INSTANCE.serialize(teamSelectiveSyncPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            TeamSelectiveSyncPolicy.Serializer.INSTANCE.serialize(teamSelectiveSyncPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamSelectiveSyncPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamSelectiveSyncPolicy teamSelectiveSyncPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TeamSelectiveSyncPolicy teamSelectiveSyncPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        teamSelectiveSyncPolicyDeserialize = TeamSelectiveSyncPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        teamSelectiveSyncPolicyDeserialize2 = TeamSelectiveSyncPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamSelectiveSyncPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (teamSelectiveSyncPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                TeamSelectiveSyncPolicyChangedDetails teamSelectiveSyncPolicyChangedDetails = new TeamSelectiveSyncPolicyChangedDetails(teamSelectiveSyncPolicyDeserialize, teamSelectiveSyncPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamSelectiveSyncPolicyChangedDetails, teamSelectiveSyncPolicyChangedDetails.toStringMultiline());
                return teamSelectiveSyncPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
