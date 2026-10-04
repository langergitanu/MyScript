package com.dropbox.core;

import com.dropbox.core.stone.StoneSerializer;
import com.dropbox.core.stone.StoneSerializers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class LocalizedText {
    static final StoneSerializer<LocalizedText> STONE_SERIALIZER = new StoneSerializer<LocalizedText>() { // from class: com.dropbox.core.LocalizedText.1
        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LocalizedText localizedText, JsonGenerator jsonGenerator) throws IOException {
            throw new UnsupportedOperationException("Error wrapper serialization not supported.");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StoneSerializer
        public LocalizedText deserialize(JsonParser jsonParser) throws IOException {
            expectStartObject(jsonParser);
            String strDeserialize = null;
            String strDeserialize2 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                if ("text".equals(currentName)) {
                    strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                } else if ("locale".equals(currentName)) {
                    strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                } else {
                    skipValue(jsonParser);
                }
            }
            if (strDeserialize == null) {
                throw new JsonParseException(jsonParser, "Required field \"text\" missing.");
            }
            if (strDeserialize2 == null) {
                throw new JsonParseException(jsonParser, "Required field \"locale\" missing.");
            }
            LocalizedText localizedText = new LocalizedText(strDeserialize, strDeserialize2);
            expectEndObject(jsonParser);
            return localizedText;
        }
    };
    private final String locale;
    private final String text;

    public LocalizedText(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("text");
        }
        if (str2 == null) {
            throw new NullPointerException("locale");
        }
        this.text = str;
        this.locale = str2;
    }

    public String getText() {
        return this.text;
    }

    public String getLocale() {
        return this.locale;
    }

    public String toString() {
        return this.text;
    }
}
