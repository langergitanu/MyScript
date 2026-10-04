package com.dropbox.core.p013v2.teamlog;

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

/* JADX INFO: loaded from: classes5.dex */
public class TeamMergeRequestReminderShownToSecondaryTeamDetails {

    @Nonnull
    protected final String sentTo;

    public TeamMergeRequestReminderShownToSecondaryTeamDetails(@Nonnull String str) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sentTo' is null");
        }
        this.sentTo = str;
    }

    @Nonnull
    public String getSentTo() {
        return this.sentTo;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sentTo});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        String str = this.sentTo;
        String str2 = ((TeamMergeRequestReminderShownToSecondaryTeamDetails) obj).sentTo;
        return str == str2 || str.equals(str2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMergeRequestReminderShownToSecondaryTeamDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMergeRequestReminderShownToSecondaryTeamDetails teamMergeRequestReminderShownToSecondaryTeamDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("sent_to");
            StoneSerializers.string().serialize(teamMergeRequestReminderShownToSecondaryTeamDetails.sentTo, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMergeRequestReminderShownToSecondaryTeamDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
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
                    if ("sent_to".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"sent_to\" missing.");
                }
                TeamMergeRequestReminderShownToSecondaryTeamDetails teamMergeRequestReminderShownToSecondaryTeamDetails = new TeamMergeRequestReminderShownToSecondaryTeamDetails(strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMergeRequestReminderShownToSecondaryTeamDetails, teamMergeRequestReminderShownToSecondaryTeamDetails.toStringMultiline());
                return teamMergeRequestReminderShownToSecondaryTeamDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
