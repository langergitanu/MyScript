package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ShowcaseExternalSharingPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<ShowcaseExternalSharingPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ShowcaseExternalSharingPolicy showcaseExternalSharingPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45221.f796x54de08b[showcaseExternalSharingPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ShowcaseExternalSharingPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ShowcaseExternalSharingPolicy showcaseExternalSharingPolicy;
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
                showcaseExternalSharingPolicy = ShowcaseExternalSharingPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                showcaseExternalSharingPolicy = ShowcaseExternalSharingPolicy.ENABLED;
            } else {
                showcaseExternalSharingPolicy = ShowcaseExternalSharingPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return showcaseExternalSharingPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ShowcaseExternalSharingPolicy$1 */
    static /* synthetic */ class C45221 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$ShowcaseExternalSharingPolicy */
        static final /* synthetic */ int[] f796x54de08b;

        static {
            int[] iArr = new int[ShowcaseExternalSharingPolicy.values().length];
            f796x54de08b = iArr;
            try {
                iArr[ShowcaseExternalSharingPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f796x54de08b[ShowcaseExternalSharingPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
