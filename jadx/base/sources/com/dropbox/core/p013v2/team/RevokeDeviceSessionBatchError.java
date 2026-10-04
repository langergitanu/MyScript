package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum RevokeDeviceSessionBatchError {
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.RevokeDeviceSessionBatchError$1 */
    static /* synthetic */ class C43921 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionBatchError */
        static final /* synthetic */ int[] f764x46d5a6cf = new int[RevokeDeviceSessionBatchError.values().length];
    }

    static class Serializer extends UnionSerializer<RevokeDeviceSessionBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RevokeDeviceSessionBatchError revokeDeviceSessionBatchError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43921.f764x46d5a6cf[revokeDeviceSessionBatchError.ordinal()];
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RevokeDeviceSessionBatchError deserialize(JsonParser jsonParser) throws IOException {
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
            RevokeDeviceSessionBatchError revokeDeviceSessionBatchError = RevokeDeviceSessionBatchError.OTHER;
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return revokeDeviceSessionBatchError;
        }
    }
}
