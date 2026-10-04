package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamMergeRequestExpiredExtraDetails;
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
public class TeamMergeRequestExpiredDetails {

    @Nonnull
    protected final TeamMergeRequestExpiredExtraDetails requestExpiredDetails;

    public TeamMergeRequestExpiredDetails(@Nonnull TeamMergeRequestExpiredExtraDetails teamMergeRequestExpiredExtraDetails) {
        if (teamMergeRequestExpiredExtraDetails == null) {
            throw new IllegalArgumentException("Required value for 'requestExpiredDetails' is null");
        }
        this.requestExpiredDetails = teamMergeRequestExpiredExtraDetails;
    }

    @Nonnull
    public TeamMergeRequestExpiredExtraDetails getRequestExpiredDetails() {
        return this.requestExpiredDetails;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.requestExpiredDetails});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMergeRequestExpiredExtraDetails teamMergeRequestExpiredExtraDetails = this.requestExpiredDetails;
        TeamMergeRequestExpiredExtraDetails teamMergeRequestExpiredExtraDetails2 = ((TeamMergeRequestExpiredDetails) obj).requestExpiredDetails;
        return teamMergeRequestExpiredExtraDetails == teamMergeRequestExpiredExtraDetails2 || teamMergeRequestExpiredExtraDetails.equals(teamMergeRequestExpiredExtraDetails2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMergeRequestExpiredDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMergeRequestExpiredDetails teamMergeRequestExpiredDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("request_expired_details");
            TeamMergeRequestExpiredExtraDetails.Serializer.INSTANCE.serialize(teamMergeRequestExpiredDetails.requestExpiredDetails, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMergeRequestExpiredDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamMergeRequestExpiredExtraDetails teamMergeRequestExpiredExtraDetailsDeserialize = null;
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
                    if ("request_expired_details".equals(currentName)) {
                        teamMergeRequestExpiredExtraDetailsDeserialize = TeamMergeRequestExpiredExtraDetails.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamMergeRequestExpiredExtraDetailsDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"request_expired_details\" missing.");
                }
                TeamMergeRequestExpiredDetails teamMergeRequestExpiredDetails = new TeamMergeRequestExpiredDetails(teamMergeRequestExpiredExtraDetailsDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMergeRequestExpiredDetails, teamMergeRequestExpiredDetails.toStringMultiline());
                return teamMergeRequestExpiredDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
