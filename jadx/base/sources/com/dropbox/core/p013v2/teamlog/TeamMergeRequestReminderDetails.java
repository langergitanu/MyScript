package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamMergeRequestReminderExtraDetails;
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
public class TeamMergeRequestReminderDetails {

    @Nonnull
    protected final TeamMergeRequestReminderExtraDetails requestReminderDetails;

    public TeamMergeRequestReminderDetails(@Nonnull TeamMergeRequestReminderExtraDetails teamMergeRequestReminderExtraDetails) {
        if (teamMergeRequestReminderExtraDetails == null) {
            throw new IllegalArgumentException("Required value for 'requestReminderDetails' is null");
        }
        this.requestReminderDetails = teamMergeRequestReminderExtraDetails;
    }

    @Nonnull
    public TeamMergeRequestReminderExtraDetails getRequestReminderDetails() {
        return this.requestReminderDetails;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.requestReminderDetails});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMergeRequestReminderExtraDetails teamMergeRequestReminderExtraDetails = this.requestReminderDetails;
        TeamMergeRequestReminderExtraDetails teamMergeRequestReminderExtraDetails2 = ((TeamMergeRequestReminderDetails) obj).requestReminderDetails;
        return teamMergeRequestReminderExtraDetails == teamMergeRequestReminderExtraDetails2 || teamMergeRequestReminderExtraDetails.equals(teamMergeRequestReminderExtraDetails2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMergeRequestReminderDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMergeRequestReminderDetails teamMergeRequestReminderDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("request_reminder_details");
            TeamMergeRequestReminderExtraDetails.Serializer.INSTANCE.serialize(teamMergeRequestReminderDetails.requestReminderDetails, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMergeRequestReminderDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamMergeRequestReminderExtraDetails teamMergeRequestReminderExtraDetailsDeserialize = null;
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
                    if ("request_reminder_details".equals(currentName)) {
                        teamMergeRequestReminderExtraDetailsDeserialize = TeamMergeRequestReminderExtraDetails.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamMergeRequestReminderExtraDetailsDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"request_reminder_details\" missing.");
                }
                TeamMergeRequestReminderDetails teamMergeRequestReminderDetails = new TeamMergeRequestReminderDetails(teamMergeRequestReminderExtraDetailsDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMergeRequestReminderDetails, teamMergeRequestReminderDetails.toStringMultiline());
                return teamMergeRequestReminderDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
