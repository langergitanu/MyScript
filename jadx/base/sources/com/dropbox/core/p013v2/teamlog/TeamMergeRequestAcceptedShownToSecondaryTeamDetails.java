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
public class TeamMergeRequestAcceptedShownToSecondaryTeamDetails {

    @Nonnull
    protected final String primaryTeam;

    @Nonnull
    protected final String sentBy;

    public TeamMergeRequestAcceptedShownToSecondaryTeamDetails(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'primaryTeam' is null");
        }
        this.primaryTeam = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'sentBy' is null");
        }
        this.sentBy = str2;
    }

    @Nonnull
    public String getPrimaryTeam() {
        return this.primaryTeam;
    }

    @Nonnull
    public String getSentBy() {
        return this.sentBy;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.primaryTeam, this.sentBy});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMergeRequestAcceptedShownToSecondaryTeamDetails teamMergeRequestAcceptedShownToSecondaryTeamDetails = (TeamMergeRequestAcceptedShownToSecondaryTeamDetails) obj;
        String str3 = this.primaryTeam;
        String str4 = teamMergeRequestAcceptedShownToSecondaryTeamDetails.primaryTeam;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.sentBy) == (str2 = teamMergeRequestAcceptedShownToSecondaryTeamDetails.sentBy) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMergeRequestAcceptedShownToSecondaryTeamDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMergeRequestAcceptedShownToSecondaryTeamDetails teamMergeRequestAcceptedShownToSecondaryTeamDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("primary_team");
            StoneSerializers.string().serialize(teamMergeRequestAcceptedShownToSecondaryTeamDetails.primaryTeam, jsonGenerator);
            jsonGenerator.writeFieldName("sent_by");
            StoneSerializers.string().serialize(teamMergeRequestAcceptedShownToSecondaryTeamDetails.sentBy, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMergeRequestAcceptedShownToSecondaryTeamDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("primary_team".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("sent_by".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"primary_team\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"sent_by\" missing.");
                }
                TeamMergeRequestAcceptedShownToSecondaryTeamDetails teamMergeRequestAcceptedShownToSecondaryTeamDetails = new TeamMergeRequestAcceptedShownToSecondaryTeamDetails(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMergeRequestAcceptedShownToSecondaryTeamDetails, teamMergeRequestAcceptedShownToSecondaryTeamDetails.toStringMultiline());
                return teamMergeRequestAcceptedShownToSecondaryTeamDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
