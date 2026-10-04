package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum CustomQuotaError {
    TOO_MANY_USERS,
    OTHER;

    static class Serializer extends UnionSerializer<CustomQuotaError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CustomQuotaError customQuotaError, JsonGenerator jsonGenerator) throws IOException {
            if (C43221.$SwitchMap$com$dropbox$core$v2$team$CustomQuotaError[customQuotaError.ordinal()] == 1) {
                jsonGenerator.writeString("too_many_users");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CustomQuotaError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CustomQuotaError customQuotaError;
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
            if ("too_many_users".equals(tag)) {
                customQuotaError = CustomQuotaError.TOO_MANY_USERS;
            } else {
                customQuotaError = CustomQuotaError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return customQuotaError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.CustomQuotaError$1 */
    static /* synthetic */ class C43221 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$CustomQuotaError;

        static {
            int[] iArr = new int[CustomQuotaError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$CustomQuotaError = iArr;
            try {
                iArr[CustomQuotaError.TOO_MANY_USERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
