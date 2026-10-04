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
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class SharedLinkAddExpiryDetails {

    @Nonnull
    protected final Date newValue;

    public SharedLinkAddExpiryDetails(@Nonnull Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = LangUtil.truncateMillis(date);
    }

    @Nonnull
    public Date getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        Date date = this.newValue;
        Date date2 = ((SharedLinkAddExpiryDetails) obj).newValue;
        return date == date2 || date.equals(date2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkAddExpiryDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkAddExpiryDetails sharedLinkAddExpiryDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            StoneSerializers.timestamp().serialize(sharedLinkAddExpiryDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedLinkAddExpiryDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Date dateDeserialize = null;
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
                    if ("new_value".equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharedLinkAddExpiryDetails sharedLinkAddExpiryDetails = new SharedLinkAddExpiryDetails(dateDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedLinkAddExpiryDetails, sharedLinkAddExpiryDetails.toStringMultiline());
                return sharedLinkAddExpiryDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
