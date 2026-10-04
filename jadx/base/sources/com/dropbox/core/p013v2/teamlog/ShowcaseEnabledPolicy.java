package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ShowcaseEnabledPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<ShowcaseEnabledPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ShowcaseEnabledPolicy showcaseEnabledPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45211.$SwitchMap$com$dropbox$core$v2$teamlog$ShowcaseEnabledPolicy[showcaseEnabledPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ShowcaseEnabledPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ShowcaseEnabledPolicy showcaseEnabledPolicy;
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
                showcaseEnabledPolicy = ShowcaseEnabledPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                showcaseEnabledPolicy = ShowcaseEnabledPolicy.ENABLED;
            } else {
                showcaseEnabledPolicy = ShowcaseEnabledPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return showcaseEnabledPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ShowcaseEnabledPolicy$1 */
    static /* synthetic */ class C45211 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ShowcaseEnabledPolicy;

        static {
            int[] iArr = new int[ShowcaseEnabledPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ShowcaseEnabledPolicy = iArr;
            try {
                iArr[ShowcaseEnabledPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ShowcaseEnabledPolicy[ShowcaseEnabledPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
