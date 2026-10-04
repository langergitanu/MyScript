package com.dropbox.core.p013v2.openid;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum OpenIdError {
    INCORRECT_OPENID_SCOPES,
    OTHER;

    static class Serializer extends UnionSerializer<OpenIdError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(OpenIdError openIdError, JsonGenerator jsonGenerator) throws IOException {
            if (C42241.$SwitchMap$com$dropbox$core$v2$openid$OpenIdError[openIdError.ordinal()] == 1) {
                jsonGenerator.writeString("incorrect_openid_scopes");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public OpenIdError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            OpenIdError openIdError;
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
            if ("incorrect_openid_scopes".equals(tag)) {
                openIdError = OpenIdError.INCORRECT_OPENID_SCOPES;
            } else {
                openIdError = OpenIdError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return openIdError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.openid.OpenIdError$1 */
    static /* synthetic */ class C42241 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$openid$OpenIdError;

        static {
            int[] iArr = new int[OpenIdError.values().length];
            $SwitchMap$com$dropbox$core$v2$openid$OpenIdError = iArr;
            try {
                iArr[OpenIdError.INCORRECT_OPENID_SCOPES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
