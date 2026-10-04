package com.dropbox.core.p013v2.auth;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum InvalidAccountTypeError {
    ENDPOINT,
    FEATURE,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.auth.InvalidAccountTypeError$1 */
    static /* synthetic */ class C41091 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$auth$InvalidAccountTypeError;

        static {
            int[] iArr = new int[InvalidAccountTypeError.values().length];
            $SwitchMap$com$dropbox$core$v2$auth$InvalidAccountTypeError = iArr;
            try {
                iArr[InvalidAccountTypeError.ENDPOINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$InvalidAccountTypeError[InvalidAccountTypeError.FEATURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<InvalidAccountTypeError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(InvalidAccountTypeError invalidAccountTypeError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41091.$SwitchMap$com$dropbox$core$v2$auth$InvalidAccountTypeError[invalidAccountTypeError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("endpoint");
            } else if (i == 2) {
                jsonGenerator.writeString("feature");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public InvalidAccountTypeError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            InvalidAccountTypeError invalidAccountTypeError;
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
            if ("endpoint".equals(tag)) {
                invalidAccountTypeError = InvalidAccountTypeError.ENDPOINT;
            } else if ("feature".equals(tag)) {
                invalidAccountTypeError = InvalidAccountTypeError.FEATURE;
            } else {
                invalidAccountTypeError = InvalidAccountTypeError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return invalidAccountTypeError;
        }
    }
}
