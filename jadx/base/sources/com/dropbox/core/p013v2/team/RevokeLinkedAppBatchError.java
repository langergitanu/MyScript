package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum RevokeLinkedAppBatchError {
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.RevokeLinkedAppBatchError$1 */
    static /* synthetic */ class C43941 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$RevokeLinkedAppBatchError = new int[RevokeLinkedAppBatchError.values().length];
    }

    static class Serializer extends UnionSerializer<RevokeLinkedAppBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RevokeLinkedAppBatchError revokeLinkedAppBatchError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43941.$SwitchMap$com$dropbox$core$v2$team$RevokeLinkedAppBatchError[revokeLinkedAppBatchError.ordinal()];
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RevokeLinkedAppBatchError deserialize(JsonParser jsonParser) throws IOException {
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
            RevokeLinkedAppBatchError revokeLinkedAppBatchError = RevokeLinkedAppBatchError.OTHER;
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return revokeLinkedAppBatchError;
        }
    }
}
