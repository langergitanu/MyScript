package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum IntegrationPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<IntegrationPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(IntegrationPolicy integrationPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44861.$SwitchMap$com$dropbox$core$v2$teamlog$IntegrationPolicy[integrationPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public IntegrationPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            IntegrationPolicy integrationPolicy;
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
                integrationPolicy = IntegrationPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                integrationPolicy = IntegrationPolicy.ENABLED;
            } else {
                integrationPolicy = IntegrationPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return integrationPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.IntegrationPolicy$1 */
    static /* synthetic */ class C44861 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$IntegrationPolicy;

        static {
            int[] iArr = new int[IntegrationPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$IntegrationPolicy = iArr;
            try {
                iArr[IntegrationPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$IntegrationPolicy[IntegrationPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
