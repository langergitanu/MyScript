package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TokenGetAuthenticatedAdminError {
    MAPPING_NOT_FOUND,
    ADMIN_NOT_ACTIVE,
    OTHER;

    static class Serializer extends UnionSerializer<TokenGetAuthenticatedAdminError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TokenGetAuthenticatedAdminError tokenGetAuthenticatedAdminError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44191.f772xd1cd4e32[tokenGetAuthenticatedAdminError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("mapping_not_found");
            } else if (i == 2) {
                jsonGenerator.writeString("admin_not_active");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TokenGetAuthenticatedAdminError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TokenGetAuthenticatedAdminError tokenGetAuthenticatedAdminError;
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
            if ("mapping_not_found".equals(tag)) {
                tokenGetAuthenticatedAdminError = TokenGetAuthenticatedAdminError.MAPPING_NOT_FOUND;
            } else if ("admin_not_active".equals(tag)) {
                tokenGetAuthenticatedAdminError = TokenGetAuthenticatedAdminError.ADMIN_NOT_ACTIVE;
            } else {
                tokenGetAuthenticatedAdminError = TokenGetAuthenticatedAdminError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return tokenGetAuthenticatedAdminError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TokenGetAuthenticatedAdminError$1 */
    static /* synthetic */ class C44191 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$TokenGetAuthenticatedAdminError */
        static final /* synthetic */ int[] f772xd1cd4e32;

        static {
            int[] iArr = new int[TokenGetAuthenticatedAdminError.values().length];
            f772xd1cd4e32 = iArr;
            try {
                iArr[TokenGetAuthenticatedAdminError.MAPPING_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f772xd1cd4e32[TokenGetAuthenticatedAdminError.ADMIN_NOT_ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
