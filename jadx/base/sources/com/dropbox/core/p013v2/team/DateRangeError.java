package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum DateRangeError {
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.DateRangeError$1 */
    static /* synthetic */ class C43241 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$DateRangeError = new int[DateRangeError.values().length];
    }

    static class Serializer extends UnionSerializer<DateRangeError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DateRangeError dateRangeError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43241.$SwitchMap$com$dropbox$core$v2$team$DateRangeError[dateRangeError.ordinal()];
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DateRangeError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            DateRangeError dateRangeError = DateRangeError.OTHER;
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return dateRangeError;
        }
    }
}
