package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class OutdatedLinkViewCreateReportDetails {

    @Nonnull
    protected final Date endDate;

    @Nonnull
    protected final Date startDate;

    public OutdatedLinkViewCreateReportDetails(@Nonnull Date date, @Nonnull Date date2) {
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'startDate' is null");
        }
        this.startDate = LangUtil.truncateMillis(date);
        if (date2 == null) {
            throw new IllegalArgumentException("Required value for 'endDate' is null");
        }
        this.endDate = LangUtil.truncateMillis(date2);
    }

    @Nonnull
    public Date getStartDate() {
        return this.startDate;
    }

    @Nonnull
    public Date getEndDate() {
        return this.endDate;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.startDate, this.endDate});
    }

    public boolean equals(Object obj) {
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        OutdatedLinkViewCreateReportDetails outdatedLinkViewCreateReportDetails = (OutdatedLinkViewCreateReportDetails) obj;
        Date date3 = this.startDate;
        Date date4 = outdatedLinkViewCreateReportDetails.startDate;
        return (date3 == date4 || date3.equals(date4)) && ((date = this.endDate) == (date2 = outdatedLinkViewCreateReportDetails.endDate) || date.equals(date2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<OutdatedLinkViewCreateReportDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(OutdatedLinkViewCreateReportDetails outdatedLinkViewCreateReportDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.START_DATE);
            StoneSerializers.timestamp().serialize(outdatedLinkViewCreateReportDetails.startDate, jsonGenerator);
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.END_DATE);
            StoneSerializers.timestamp().serialize(outdatedLinkViewCreateReportDetails.endDate, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public OutdatedLinkViewCreateReportDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Date dateDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Date dateDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (FirebaseAnalytics.Param.START_DATE.equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.END_DATE.equals(currentName)) {
                        dateDeserialize2 = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"start_date\" missing.");
                }
                if (dateDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"end_date\" missing.");
                }
                OutdatedLinkViewCreateReportDetails outdatedLinkViewCreateReportDetails = new OutdatedLinkViewCreateReportDetails(dateDeserialize, dateDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(outdatedLinkViewCreateReportDetails, outdatedLinkViewCreateReportDetails.toStringMultiline());
                return outdatedLinkViewCreateReportDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
