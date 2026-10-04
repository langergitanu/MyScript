package com.dropbox.core.p013v2.auth;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum TokenFromOAuth1Error {
    INVALID_OAUTH1_TOKEN_INFO,
    APP_ID_MISMATCH,
    OTHER;

    static class Serializer extends UnionSerializer<TokenFromOAuth1Error> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TokenFromOAuth1Error tokenFromOAuth1Error, JsonGenerator jsonGenerator) throws IOException {
            int i = C41121.$SwitchMap$com$dropbox$core$v2$auth$TokenFromOAuth1Error[tokenFromOAuth1Error.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invalid_oauth1_token_info");
            } else if (i == 2) {
                jsonGenerator.writeString("app_id_mismatch");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TokenFromOAuth1Error deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TokenFromOAuth1Error tokenFromOAuth1Error;
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
            if ("invalid_oauth1_token_info".equals(tag)) {
                tokenFromOAuth1Error = TokenFromOAuth1Error.INVALID_OAUTH1_TOKEN_INFO;
            } else if ("app_id_mismatch".equals(tag)) {
                tokenFromOAuth1Error = TokenFromOAuth1Error.APP_ID_MISMATCH;
            } else {
                tokenFromOAuth1Error = TokenFromOAuth1Error.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return tokenFromOAuth1Error;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.auth.TokenFromOAuth1Error$1 */
    static /* synthetic */ class C41121 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$auth$TokenFromOAuth1Error;

        static {
            int[] iArr = new int[TokenFromOAuth1Error.values().length];
            $SwitchMap$com$dropbox$core$v2$auth$TokenFromOAuth1Error = iArr;
            try {
                iArr[TokenFromOAuth1Error.INVALID_OAUTH1_TOKEN_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$TokenFromOAuth1Error[TokenFromOAuth1Error.APP_ID_MISMATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
