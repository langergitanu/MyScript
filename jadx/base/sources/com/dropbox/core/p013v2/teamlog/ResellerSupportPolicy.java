package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ResellerSupportPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<ResellerSupportPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ResellerSupportPolicy resellerSupportPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45101.$SwitchMap$com$dropbox$core$v2$teamlog$ResellerSupportPolicy[resellerSupportPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ResellerSupportPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ResellerSupportPolicy resellerSupportPolicy;
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
                resellerSupportPolicy = ResellerSupportPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                resellerSupportPolicy = ResellerSupportPolicy.ENABLED;
            } else {
                resellerSupportPolicy = ResellerSupportPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return resellerSupportPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ResellerSupportPolicy$1 */
    static /* synthetic */ class C45101 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ResellerSupportPolicy;

        static {
            int[] iArr = new int[ResellerSupportPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ResellerSupportPolicy = iArr;
            try {
                iArr[ResellerSupportPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ResellerSupportPolicy[ResellerSupportPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
