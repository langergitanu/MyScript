package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum RevokeDeviceSessionError {
    DEVICE_SESSION_NOT_FOUND,
    MEMBER_NOT_FOUND,
    OTHER;

    static class Serializer extends UnionSerializer<RevokeDeviceSessionError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RevokeDeviceSessionError revokeDeviceSessionError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43931.$SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionError[revokeDeviceSessionError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("device_session_not_found");
            } else if (i == 2) {
                jsonGenerator.writeString("member_not_found");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RevokeDeviceSessionError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RevokeDeviceSessionError revokeDeviceSessionError;
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
            if ("device_session_not_found".equals(tag)) {
                revokeDeviceSessionError = RevokeDeviceSessionError.DEVICE_SESSION_NOT_FOUND;
            } else if ("member_not_found".equals(tag)) {
                revokeDeviceSessionError = RevokeDeviceSessionError.MEMBER_NOT_FOUND;
            } else {
                revokeDeviceSessionError = RevokeDeviceSessionError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return revokeDeviceSessionError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.RevokeDeviceSessionError$1 */
    static /* synthetic */ class C43931 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionError;

        static {
            int[] iArr = new int[RevokeDeviceSessionError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionError = iArr;
            try {
                iArr[RevokeDeviceSessionError.DEVICE_SESSION_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionError[RevokeDeviceSessionError.MEMBER_NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
