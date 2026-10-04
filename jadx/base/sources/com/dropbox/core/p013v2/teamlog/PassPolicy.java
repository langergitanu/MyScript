package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum PassPolicy {
    ALLOW,
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<PassPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PassPolicy passPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45061.$SwitchMap$com$dropbox$core$v2$teamlog$PassPolicy[passPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("allow");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("disabled");
            } else if (i == 3) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PassPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PassPolicy passPolicy;
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
            if ("allow".equals(tag)) {
                passPolicy = PassPolicy.ALLOW;
            } else if ("disabled".equals(tag)) {
                passPolicy = PassPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                passPolicy = PassPolicy.ENABLED;
            } else {
                passPolicy = PassPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return passPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.PassPolicy$1 */
    static /* synthetic */ class C45061 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$PassPolicy;

        static {
            int[] iArr = new int[PassPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$PassPolicy = iArr;
            try {
                iArr[PassPolicy.ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PassPolicy[PassPolicy.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PassPolicy[PassPolicy.ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
