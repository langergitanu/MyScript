package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.team.TeamReportFailureReason;
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
public class RansomwareAlertCreateReportFailedDetails {

    @Nonnull
    protected final TeamReportFailureReason failureReason;

    public RansomwareAlertCreateReportFailedDetails(@Nonnull TeamReportFailureReason teamReportFailureReason) {
        if (teamReportFailureReason == null) {
            throw new IllegalArgumentException("Required value for 'failureReason' is null");
        }
        this.failureReason = teamReportFailureReason;
    }

    @Nonnull
    public TeamReportFailureReason getFailureReason() {
        return this.failureReason;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.failureReason});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamReportFailureReason teamReportFailureReason = this.failureReason;
        TeamReportFailureReason teamReportFailureReason2 = ((RansomwareAlertCreateReportFailedDetails) obj).failureReason;
        return teamReportFailureReason == teamReportFailureReason2 || teamReportFailureReason.equals(teamReportFailureReason2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RansomwareAlertCreateReportFailedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RansomwareAlertCreateReportFailedDetails ransomwareAlertCreateReportFailedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("failure_reason");
            TeamReportFailureReason.Serializer.INSTANCE.serialize(ransomwareAlertCreateReportFailedDetails.failureReason, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RansomwareAlertCreateReportFailedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamReportFailureReason teamReportFailureReasonDeserialize = null;
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
                    if ("failure_reason".equals(currentName)) {
                        teamReportFailureReasonDeserialize = TeamReportFailureReason.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamReportFailureReasonDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"failure_reason\" missing.");
                }
                RansomwareAlertCreateReportFailedDetails ransomwareAlertCreateReportFailedDetails = new RansomwareAlertCreateReportFailedDetails(teamReportFailureReasonDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(ransomwareAlertCreateReportFailedDetails, ransomwareAlertCreateReportFailedDetails.toStringMultiline());
                return ransomwareAlertCreateReportFailedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
