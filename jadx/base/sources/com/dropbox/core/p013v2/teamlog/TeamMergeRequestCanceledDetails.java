package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamMergeRequestCanceledExtraDetails;
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
public class TeamMergeRequestCanceledDetails {

    @Nonnull
    protected final TeamMergeRequestCanceledExtraDetails requestCanceledDetails;

    public TeamMergeRequestCanceledDetails(@Nonnull TeamMergeRequestCanceledExtraDetails teamMergeRequestCanceledExtraDetails) {
        if (teamMergeRequestCanceledExtraDetails == null) {
            throw new IllegalArgumentException("Required value for 'requestCanceledDetails' is null");
        }
        this.requestCanceledDetails = teamMergeRequestCanceledExtraDetails;
    }

    @Nonnull
    public TeamMergeRequestCanceledExtraDetails getRequestCanceledDetails() {
        return this.requestCanceledDetails;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.requestCanceledDetails});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMergeRequestCanceledExtraDetails teamMergeRequestCanceledExtraDetails = this.requestCanceledDetails;
        TeamMergeRequestCanceledExtraDetails teamMergeRequestCanceledExtraDetails2 = ((TeamMergeRequestCanceledDetails) obj).requestCanceledDetails;
        return teamMergeRequestCanceledExtraDetails == teamMergeRequestCanceledExtraDetails2 || teamMergeRequestCanceledExtraDetails.equals(teamMergeRequestCanceledExtraDetails2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMergeRequestCanceledDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMergeRequestCanceledDetails teamMergeRequestCanceledDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("request_canceled_details");
            TeamMergeRequestCanceledExtraDetails.Serializer.INSTANCE.serialize(teamMergeRequestCanceledDetails.requestCanceledDetails, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMergeRequestCanceledDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamMergeRequestCanceledExtraDetails teamMergeRequestCanceledExtraDetailsDeserialize = null;
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
                    if ("request_canceled_details".equals(currentName)) {
                        teamMergeRequestCanceledExtraDetailsDeserialize = TeamMergeRequestCanceledExtraDetails.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamMergeRequestCanceledExtraDetailsDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"request_canceled_details\" missing.");
                }
                TeamMergeRequestCanceledDetails teamMergeRequestCanceledDetails = new TeamMergeRequestCanceledDetails(teamMergeRequestCanceledExtraDetailsDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMergeRequestCanceledDetails, teamMergeRequestCanceledDetails.toStringMultiline());
                return teamMergeRequestCanceledDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
