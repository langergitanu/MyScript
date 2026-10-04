package com.dropbox.core.stone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CompositeSerializer<T> extends StoneSerializer<T> {
    protected static final String TAG_FIELD = ".tag";

    protected static boolean hasTag(JsonParser jsonParser) throws IOException {
        return jsonParser.getCurrentToken() == JsonToken.FIELD_NAME && TAG_FIELD.equals(jsonParser.getCurrentName());
    }

    protected static String readTag(JsonParser jsonParser) throws IOException {
        if (!hasTag(jsonParser)) {
            return null;
        }
        jsonParser.nextToken();
        String stringValue = getStringValue(jsonParser);
        jsonParser.nextToken();
        return stringValue;
    }

    protected void writeTag(String str, JsonGenerator jsonGenerator) throws IOException {
        if (str != null) {
            jsonGenerator.writeStringField(TAG_FIELD, str);
        }
    }
}
