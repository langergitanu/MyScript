package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum WatermarkingPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<WatermarkingPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(WatermarkingPolicy watermarkingPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45401.$SwitchMap$com$dropbox$core$v2$teamlog$WatermarkingPolicy[watermarkingPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public WatermarkingPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            WatermarkingPolicy watermarkingPolicy;
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
                watermarkingPolicy = WatermarkingPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                watermarkingPolicy = WatermarkingPolicy.ENABLED;
            } else {
                watermarkingPolicy = WatermarkingPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return watermarkingPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.WatermarkingPolicy$1 */
    static /* synthetic */ class C45401 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$WatermarkingPolicy;

        static {
            int[] iArr = new int[WatermarkingPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$WatermarkingPolicy = iArr;
            try {
                iArr[WatermarkingPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$WatermarkingPolicy[WatermarkingPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
