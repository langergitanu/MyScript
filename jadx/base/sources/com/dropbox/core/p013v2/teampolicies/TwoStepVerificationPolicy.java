package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TwoStepVerificationPolicy {
    REQUIRE_TFA_ENABLE,
    REQUIRE_TFA_DISABLE,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.TwoStepVerificationPolicy$1 */
    static /* synthetic */ class C45601 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teampolicies$TwoStepVerificationPolicy */
        static final /* synthetic */ int[] f814x2f8a4c1c;

        static {
            int[] iArr = new int[TwoStepVerificationPolicy.values().length];
            f814x2f8a4c1c = iArr;
            try {
                iArr[TwoStepVerificationPolicy.REQUIRE_TFA_ENABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f814x2f8a4c1c[TwoStepVerificationPolicy.REQUIRE_TFA_DISABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<TwoStepVerificationPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TwoStepVerificationPolicy twoStepVerificationPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45601.f814x2f8a4c1c[twoStepVerificationPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("require_tfa_enable");
            } else if (i == 2) {
                jsonGenerator.writeString("require_tfa_disable");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TwoStepVerificationPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TwoStepVerificationPolicy twoStepVerificationPolicy;
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
            if ("require_tfa_enable".equals(tag)) {
                twoStepVerificationPolicy = TwoStepVerificationPolicy.REQUIRE_TFA_ENABLE;
            } else if ("require_tfa_disable".equals(tag)) {
                twoStepVerificationPolicy = TwoStepVerificationPolicy.REQUIRE_TFA_DISABLE;
            } else {
                twoStepVerificationPolicy = TwoStepVerificationPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return twoStepVerificationPolicy;
        }
    }
}
