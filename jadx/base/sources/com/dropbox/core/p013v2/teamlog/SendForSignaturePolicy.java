package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SendForSignaturePolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<SendForSignaturePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SendForSignaturePolicy sendForSignaturePolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45131.$SwitchMap$com$dropbox$core$v2$teamlog$SendForSignaturePolicy[sendForSignaturePolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SendForSignaturePolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SendForSignaturePolicy sendForSignaturePolicy;
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
            if ("disabled".equals(tag)) {
                sendForSignaturePolicy = SendForSignaturePolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                sendForSignaturePolicy = SendForSignaturePolicy.ENABLED;
            } else {
                sendForSignaturePolicy = SendForSignaturePolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sendForSignaturePolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SendForSignaturePolicy$1 */
    static /* synthetic */ class C45131 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$SendForSignaturePolicy;

        static {
            int[] iArr = new int[SendForSignaturePolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$SendForSignaturePolicy = iArr;
            try {
                iArr[SendForSignaturePolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SendForSignaturePolicy[SendForSignaturePolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
