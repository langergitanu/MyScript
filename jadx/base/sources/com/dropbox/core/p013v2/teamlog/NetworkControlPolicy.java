package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum NetworkControlPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<NetworkControlPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(NetworkControlPolicy networkControlPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44991.$SwitchMap$com$dropbox$core$v2$teamlog$NetworkControlPolicy[networkControlPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public NetworkControlPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            NetworkControlPolicy networkControlPolicy;
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
                networkControlPolicy = NetworkControlPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                networkControlPolicy = NetworkControlPolicy.ENABLED;
            } else {
                networkControlPolicy = NetworkControlPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return networkControlPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.NetworkControlPolicy$1 */
    static /* synthetic */ class C44991 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$NetworkControlPolicy;

        static {
            int[] iArr = new int[NetworkControlPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$NetworkControlPolicy = iArr;
            try {
                iArr[NetworkControlPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$NetworkControlPolicy[NetworkControlPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
