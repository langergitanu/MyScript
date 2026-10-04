package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SecondaryMailsPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<SecondaryMailsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SecondaryMailsPolicy secondaryMailsPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45121.$SwitchMap$com$dropbox$core$v2$teamlog$SecondaryMailsPolicy[secondaryMailsPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SecondaryMailsPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SecondaryMailsPolicy secondaryMailsPolicy;
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
                secondaryMailsPolicy = SecondaryMailsPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                secondaryMailsPolicy = SecondaryMailsPolicy.ENABLED;
            } else {
                secondaryMailsPolicy = SecondaryMailsPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return secondaryMailsPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SecondaryMailsPolicy$1 */
    static /* synthetic */ class C45121 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$SecondaryMailsPolicy;

        static {
            int[] iArr = new int[SecondaryMailsPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$SecondaryMailsPolicy = iArr;
            try {
                iArr[SecondaryMailsPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SecondaryMailsPolicy[SecondaryMailsPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
