package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TwoAccountPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<TwoAccountPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TwoAccountPolicy twoAccountPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45391.$SwitchMap$com$dropbox$core$v2$teamlog$TwoAccountPolicy[twoAccountPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TwoAccountPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TwoAccountPolicy twoAccountPolicy;
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
                twoAccountPolicy = TwoAccountPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                twoAccountPolicy = TwoAccountPolicy.ENABLED;
            } else {
                twoAccountPolicy = TwoAccountPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return twoAccountPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TwoAccountPolicy$1 */
    static /* synthetic */ class C45391 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$TwoAccountPolicy;

        static {
            int[] iArr = new int[TwoAccountPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$TwoAccountPolicy = iArr;
            try {
                iArr[TwoAccountPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TwoAccountPolicy[TwoAccountPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
