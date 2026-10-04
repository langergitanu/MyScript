package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PropertiesSearchContinueError {
    RESET,
    OTHER;

    static class Serializer extends UnionSerializer<PropertiesSearchContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PropertiesSearchContinueError propertiesSearchContinueError, JsonGenerator jsonGenerator) throws IOException {
            if (C41221.f671x38d55abf[propertiesSearchContinueError.ordinal()] == 1) {
                jsonGenerator.writeString("reset");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PropertiesSearchContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PropertiesSearchContinueError propertiesSearchContinueError;
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
            if ("reset".equals(tag)) {
                propertiesSearchContinueError = PropertiesSearchContinueError.RESET;
            } else {
                propertiesSearchContinueError = PropertiesSearchContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return propertiesSearchContinueError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.PropertiesSearchContinueError$1 */
    static /* synthetic */ class C41221 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$fileproperties$PropertiesSearchContinueError */
        static final /* synthetic */ int[] f671x38d55abf;

        static {
            int[] iArr = new int[PropertiesSearchContinueError.values().length];
            f671x38d55abf = iArr;
            try {
                iArr[PropertiesSearchContinueError.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
