package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamcommon.TimeRange;
import com.dropbox.core.p013v2.teamlog.EventCategory;
import com.dropbox.core.p013v2.teamlog.EventTypeArg;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class GetTeamEventsArg {

    @Nullable
    protected final String accountId;

    @Nullable
    protected final EventCategory category;

    @Nullable
    protected final EventTypeArg eventType;
    protected final long limit;

    @Nullable
    protected final TimeRange time;

    public GetTeamEventsArg(long j, @Nullable String str, @Nullable TimeRange timeRange, @Nullable EventCategory eventCategory, @Nullable EventTypeArg eventTypeArg) {
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = j;
        if (str != null) {
            if (str.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (str.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
            }
        }
        this.accountId = str;
        this.time = timeRange;
        this.category = eventCategory;
        this.eventType = eventTypeArg;
    }

    public GetTeamEventsArg() {
        this(1000L, null, null, null, null);
    }

    public long getLimit() {
        return this.limit;
    }

    @Nullable
    public String getAccountId() {
        return this.accountId;
    }

    @Nullable
    public TimeRange getTime() {
        return this.time;
    }

    @Nullable
    public EventCategory getCategory() {
        return this.category;
    }

    @Nullable
    public EventTypeArg getEventType() {
        return this.eventType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected long limit = 1000;
        protected String accountId = null;
        protected TimeRange time = null;
        protected EventCategory category = null;
        protected EventTypeArg eventType = null;

        protected Builder() {
        }

        public Builder withLimit(Long l) {
            if (l.longValue() < 1) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (l.longValue() > 1000) {
                throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
            }
            if (l != null) {
                this.limit = l.longValue();
                return this;
            }
            this.limit = 1000L;
            return this;
        }

        public Builder withAccountId(String str) {
            if (str != null) {
                if (str.length() < 40) {
                    throw new IllegalArgumentException("String 'accountId' is shorter than 40");
                }
                if (str.length() > 40) {
                    throw new IllegalArgumentException("String 'accountId' is longer than 40");
                }
            }
            this.accountId = str;
            return this;
        }

        public Builder withTime(TimeRange timeRange) {
            this.time = timeRange;
            return this;
        }

        public Builder withCategory(EventCategory eventCategory) {
            this.category = eventCategory;
            return this;
        }

        public Builder withEventType(EventTypeArg eventTypeArg) {
            this.eventType = eventTypeArg;
            return this;
        }

        public GetTeamEventsArg build() {
            return new GetTeamEventsArg(this.limit, this.accountId, this.time, this.category, this.eventType);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.limit), this.accountId, this.time, this.category, this.eventType});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        TimeRange timeRange;
        TimeRange timeRange2;
        EventCategory eventCategory;
        EventCategory eventCategory2;
        EventTypeArg eventTypeArg;
        EventTypeArg eventTypeArg2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            GetTeamEventsArg getTeamEventsArg = (GetTeamEventsArg) obj;
            if (this.limit == getTeamEventsArg.limit && (((str = this.accountId) == (str2 = getTeamEventsArg.accountId) || (str != null && str.equals(str2))) && (((timeRange = this.time) == (timeRange2 = getTeamEventsArg.time) || (timeRange != null && timeRange.equals(timeRange2))) && (((eventCategory = this.category) == (eventCategory2 = getTeamEventsArg.category) || (eventCategory != null && eventCategory.equals(eventCategory2))) && ((eventTypeArg = this.eventType) == (eventTypeArg2 = getTeamEventsArg.eventType) || (eventTypeArg != null && eventTypeArg.equals(eventTypeArg2))))))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetTeamEventsArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetTeamEventsArg getTeamEventsArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(Long.valueOf(getTeamEventsArg.limit), jsonGenerator);
            if (getTeamEventsArg.accountId != null) {
                jsonGenerator.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(getTeamEventsArg.accountId, jsonGenerator);
            }
            if (getTeamEventsArg.time != null) {
                jsonGenerator.writeFieldName("time");
                StoneSerializers.nullableStruct(TimeRange.Serializer.INSTANCE).serialize(getTeamEventsArg.time, jsonGenerator);
            }
            if (getTeamEventsArg.category != null) {
                jsonGenerator.writeFieldName("category");
                StoneSerializers.nullable(EventCategory.Serializer.INSTANCE).serialize(getTeamEventsArg.category, jsonGenerator);
            }
            if (getTeamEventsArg.eventType != null) {
                jsonGenerator.writeFieldName("event_type");
                StoneSerializers.nullable(EventTypeArg.Serializer.INSTANCE).serialize(getTeamEventsArg.eventType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetTeamEventsArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = 1000L;
                String str = null;
                TimeRange timeRange = null;
                EventCategory eventCategory = null;
                EventTypeArg eventTypeArg = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("limit".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else if ("account_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("time".equals(currentName)) {
                        timeRange = (TimeRange) StoneSerializers.nullableStruct(TimeRange.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("category".equals(currentName)) {
                        eventCategory = (EventCategory) StoneSerializers.nullable(EventCategory.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("event_type".equals(currentName)) {
                        eventTypeArg = (EventTypeArg) StoneSerializers.nullable(EventTypeArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                GetTeamEventsArg getTeamEventsArg = new GetTeamEventsArg(lDeserialize.longValue(), str, timeRange, eventCategory, eventTypeArg);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getTeamEventsArg, getTeamEventsArg.toStringMultiline());
                return getTeamEventsArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
