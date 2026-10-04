package com.dropbox.core.p013v2.teamlog;

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
public class SharedContentChangeLinkExpiryDetails {

    @Nullable
    protected final Date newValue;

    @Nullable
    protected final Date previousValue;

    public SharedContentChangeLinkExpiryDetails(@Nullable Date date, @Nullable Date date2) {
        this.newValue = LangUtil.truncateMillis(date);
        this.previousValue = LangUtil.truncateMillis(date2);
    }

    public SharedContentChangeLinkExpiryDetails() {
        this(null, null);
    }

    @Nullable
    public Date getNewValue() {
        return this.newValue;
    }

    @Nullable
    public Date getPreviousValue() {
        return this.previousValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected Date newValue = null;
        protected Date previousValue = null;

        protected Builder() {
        }

        public Builder withNewValue(Date date) {
            this.newValue = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withPreviousValue(Date date) {
            this.previousValue = LangUtil.truncateMillis(date);
            return this;
        }

        public SharedContentChangeLinkExpiryDetails build() {
            return new SharedContentChangeLinkExpiryDetails(this.newValue, this.previousValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
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
        SharedContentChangeLinkExpiryDetails sharedContentChangeLinkExpiryDetails = (SharedContentChangeLinkExpiryDetails) obj;
        Date date3 = this.newValue;
        Date date4 = sharedContentChangeLinkExpiryDetails.newValue;
        return (date3 == date4 || (date3 != null && date3.equals(date4))) && ((date = this.previousValue) == (date2 = sharedContentChangeLinkExpiryDetails.previousValue) || (date != null && date.equals(date2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentChangeLinkExpiryDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentChangeLinkExpiryDetails sharedContentChangeLinkExpiryDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharedContentChangeLinkExpiryDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(sharedContentChangeLinkExpiryDetails.newValue, jsonGenerator);
            }
            if (sharedContentChangeLinkExpiryDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(sharedContentChangeLinkExpiryDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentChangeLinkExpiryDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("new_value".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharedContentChangeLinkExpiryDetails sharedContentChangeLinkExpiryDetails = new SharedContentChangeLinkExpiryDetails(date, date2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentChangeLinkExpiryDetails, sharedContentChangeLinkExpiryDetails.toStringMultiline());
                return sharedContentChangeLinkExpiryDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
