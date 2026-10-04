package com.dropbox.core.p013v2.teamcommon;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class TimeRange {

    @Nullable
    protected final Date endTime;

    @Nullable
    protected final Date startTime;

    public TimeRange(@Nullable Date date, @Nullable Date date2) {
        this.startTime = LangUtil.truncateMillis(date);
        this.endTime = LangUtil.truncateMillis(date2);
    }

    public TimeRange() {
        this(null, null);
    }

    @Nullable
    public Date getStartTime() {
        return this.startTime;
    }

    @Nullable
    public Date getEndTime() {
        return this.endTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected Date startTime = null;
        protected Date endTime = null;

        protected Builder() {
        }

        public Builder withStartTime(Date date) {
            this.startTime = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withEndTime(Date date) {
            this.endTime = LangUtil.truncateMillis(date);
            return this;
        }

        public TimeRange build() {
            return new TimeRange(this.startTime, this.endTime);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.startTime, this.endTime});
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
        TimeRange timeRange = (TimeRange) obj;
        Date date3 = this.startTime;
        Date date4 = timeRange.startTime;
        return (date3 == date4 || (date3 != null && date3.equals(date4))) && ((date = this.endTime) == (date2 = timeRange.endTime) || (date != null && date.equals(date2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<TimeRange> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TimeRange timeRange, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (timeRange.startTime != null) {
                jsonGenerator.writeFieldName("start_time");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(timeRange.startTime, jsonGenerator);
            }
            if (timeRange.endTime != null) {
                jsonGenerator.writeFieldName("end_time");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(timeRange.endTime, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TimeRange deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("start_time".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("end_time".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                TimeRange timeRange = new TimeRange(date, date2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(timeRange, timeRange.toStringMultiline());
                return timeRange;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
