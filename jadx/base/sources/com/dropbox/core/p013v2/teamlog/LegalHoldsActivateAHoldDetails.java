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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldsActivateAHoldDetails {

    @Nullable
    protected final Date endDate;

    @Nonnull
    protected final String legalHoldId;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final Date startDate;

    public LegalHoldsActivateAHoldDetails(@Nonnull String str, @Nonnull String str2, @Nonnull Date date, @Nullable Date date2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
        }
        this.legalHoldId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'startDate' is null");
        }
        this.startDate = LangUtil.truncateMillis(date);
        this.endDate = LangUtil.truncateMillis(date2);
    }

    public LegalHoldsActivateAHoldDetails(@Nonnull String str, @Nonnull String str2, @Nonnull Date date) {
        this(str, str2, date, null);
    }

    @Nonnull
    public String getLegalHoldId() {
        return this.legalHoldId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public Date getStartDate() {
        return this.startDate;
    }

    @Nullable
    public Date getEndDate() {
        return this.endDate;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.legalHoldId, this.name, this.startDate, this.endDate});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Date date;
        Date date2;
        Date date3;
        Date date4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LegalHoldsActivateAHoldDetails legalHoldsActivateAHoldDetails = (LegalHoldsActivateAHoldDetails) obj;
        String str3 = this.legalHoldId;
        String str4 = legalHoldsActivateAHoldDetails.legalHoldId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.name) == (str2 = legalHoldsActivateAHoldDetails.name) || str.equals(str2)) && (((date = this.startDate) == (date2 = legalHoldsActivateAHoldDetails.startDate) || date.equals(date2)) && ((date3 = this.endDate) == (date4 = legalHoldsActivateAHoldDetails.endDate) || (date3 != null && date3.equals(date4))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsActivateAHoldDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsActivateAHoldDetails legalHoldsActivateAHoldDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(legalHoldsActivateAHoldDetails.legalHoldId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(legalHoldsActivateAHoldDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.START_DATE);
            StoneSerializers.timestamp().serialize(legalHoldsActivateAHoldDetails.startDate, jsonGenerator);
            if (legalHoldsActivateAHoldDetails.endDate != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.END_DATE);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(legalHoldsActivateAHoldDetails.endDate, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsActivateAHoldDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                Date dateDeserialize = null;
                Date date = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("legal_hold_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.START_DATE.equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.END_DATE.equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"legal_hold_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"start_date\" missing.");
                }
                LegalHoldsActivateAHoldDetails legalHoldsActivateAHoldDetails = new LegalHoldsActivateAHoldDetails(strDeserialize, strDeserialize2, dateDeserialize, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsActivateAHoldDetails, legalHoldsActivateAHoldDetails.toStringMultiline());
                return legalHoldsActivateAHoldDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
