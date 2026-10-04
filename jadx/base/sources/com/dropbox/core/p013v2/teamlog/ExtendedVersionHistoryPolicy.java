package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ExtendedVersionHistoryPolicy {
    EXPLICITLY_LIMITED,
    EXPLICITLY_UNLIMITED,
    IMPLICITLY_LIMITED,
    IMPLICITLY_UNLIMITED,
    OTHER;

    static class Serializer extends UnionSerializer<ExtendedVersionHistoryPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ExtendedVersionHistoryPolicy extendedVersionHistoryPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44681.f787x8957d612[extendedVersionHistoryPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("explicitly_limited");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("explicitly_unlimited");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("implicitly_limited");
            } else if (i == 4) {
                jsonGenerator.writeString("implicitly_unlimited");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ExtendedVersionHistoryPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ExtendedVersionHistoryPolicy extendedVersionHistoryPolicy;
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
            if ("explicitly_limited".equals(tag)) {
                extendedVersionHistoryPolicy = ExtendedVersionHistoryPolicy.EXPLICITLY_LIMITED;
            } else if ("explicitly_unlimited".equals(tag)) {
                extendedVersionHistoryPolicy = ExtendedVersionHistoryPolicy.EXPLICITLY_UNLIMITED;
            } else if ("implicitly_limited".equals(tag)) {
                extendedVersionHistoryPolicy = ExtendedVersionHistoryPolicy.IMPLICITLY_LIMITED;
            } else if ("implicitly_unlimited".equals(tag)) {
                extendedVersionHistoryPolicy = ExtendedVersionHistoryPolicy.IMPLICITLY_UNLIMITED;
            } else {
                extendedVersionHistoryPolicy = ExtendedVersionHistoryPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return extendedVersionHistoryPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ExtendedVersionHistoryPolicy$1 */
    static /* synthetic */ class C44681 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$ExtendedVersionHistoryPolicy */
        static final /* synthetic */ int[] f787x8957d612;

        static {
            int[] iArr = new int[ExtendedVersionHistoryPolicy.values().length];
            f787x8957d612 = iArr;
            try {
                iArr[ExtendedVersionHistoryPolicy.EXPLICITLY_LIMITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f787x8957d612[ExtendedVersionHistoryPolicy.EXPLICITLY_UNLIMITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f787x8957d612[ExtendedVersionHistoryPolicy.IMPLICITLY_LIMITED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f787x8957d612[ExtendedVersionHistoryPolicy.IMPLICITLY_UNLIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
