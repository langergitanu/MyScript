package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SetCustomQuotaError {
    TOO_MANY_USERS,
    OTHER,
    SOME_USERS_ARE_EXCLUDED;

    static class Serializer extends UnionSerializer<SetCustomQuotaError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SetCustomQuotaError setCustomQuotaError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43961.$SwitchMap$com$dropbox$core$v2$team$SetCustomQuotaError[setCustomQuotaError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("too_many_users");
            } else if (i == 2) {
                jsonGenerator.writeString("other");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("some_users_are_excluded");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + setCustomQuotaError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SetCustomQuotaError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SetCustomQuotaError setCustomQuotaError;
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
                setCustomQuotaError = SetCustomQuotaError.TOO_MANY_USERS;
            } else if ("other".equals(tag)) {
                setCustomQuotaError = SetCustomQuotaError.OTHER;
            } else if ("some_users_are_excluded".equals(tag)) {
                setCustomQuotaError = SetCustomQuotaError.SOME_USERS_ARE_EXCLUDED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return setCustomQuotaError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.SetCustomQuotaError$1 */
    static /* synthetic */ class C43961 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$SetCustomQuotaError;

        static {
            int[] iArr = new int[SetCustomQuotaError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$SetCustomQuotaError = iArr;
            try {
                iArr[SetCustomQuotaError.TOO_MANY_USERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$SetCustomQuotaError[SetCustomQuotaError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$SetCustomQuotaError[SetCustomQuotaError.SOME_USERS_ARE_EXCLUDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
