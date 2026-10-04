package com.dropbox.core.p013v2.team;

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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class DateRange {

    @Nullable
    protected final Date endDate;

    @Nullable
    protected final Date startDate;

    public DateRange(@Nullable Date date, @Nullable Date date2) {
        this.startDate = LangUtil.truncateMillis(date);
        this.endDate = LangUtil.truncateMillis(date2);
    }

    public DateRange() {
        this(null, null);
    }

    @Nullable
    public Date getStartDate() {
        return this.startDate;
    }

    @Nullable
    public Date getEndDate() {
        return this.endDate;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected Date startDate = null;
        protected Date endDate = null;

        protected Builder() {
        }

        public Builder withStartDate(Date date) {
            this.startDate = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withEndDate(Date date) {
            this.endDate = LangUtil.truncateMillis(date);
            return this;
        }

        public DateRange build() {
            return new DateRange(this.startDate, this.endDate);
        }
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
        DateRange dateRange = (DateRange) obj;
        Date date3 = this.startDate;
        Date date4 = dateRange.startDate;
        return (date3 == date4 || (date3 != null && date3.equals(date4))) && ((date = this.endDate) == (date2 = dateRange.endDate) || (date != null && date.equals(date2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DateRange> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DateRange dateRange, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (dateRange.startDate != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.START_DATE);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(dateRange.startDate, jsonGenerator);
            }
            if (dateRange.endDate != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.END_DATE);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(dateRange.endDate, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DateRange deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Date date = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Date date2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (FirebaseAnalytics.Param.START_DATE.equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.END_DATE.equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                DateRange dateRange = new DateRange(date, date2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(dateRange, dateRange.toStringMultiline());
                return dateRange;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
