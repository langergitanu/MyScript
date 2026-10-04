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
public class TeamMergeRequestExpiredShownToSecondaryTeamDetails {

    @Nonnull
    protected final String sentTo;

    public TeamMergeRequestExpiredShownToSecondaryTeamDetails(@Nonnull String str) {
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
        String str2 = ((TeamMergeRequestExpiredShownToSecondaryTeamDetails) obj).sentTo;
        return str == str2 || str.equals(str2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMergeRequestExpiredShownToSecondaryTeamDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMergeRequestExpiredShownToSecondaryTeamDetails teamMergeRequestExpiredShownToSecondaryTeamDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("sent_to");
            StoneSerializers.string().serialize(teamMergeRequestExpiredShownToSecondaryTeamDetails.sentTo, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to analyze thrown exceptions
        java.util.ConcurrentModificationException
        	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1605)
        	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1628)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.mergeExceptions(MethodThrowsVisitor.java:99)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:86)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
         */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMergeRequestExpiredShownToSecondaryTeamDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                TeamMergeRequestExpiredShownToSecondaryTeamDetails teamMergeRequestExpiredShownToSecondaryTeamDetails = new TeamMergeRequestExpiredShownToSecondaryTeamDetails(strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMergeRequestExpiredShownToSecondaryTeamDetails, teamMergeRequestExpiredShownToSecondaryTeamDetails.toStringMultiline());
                return teamMergeRequestExpiredShownToSecondaryTeamDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
