package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum PasswordStrengthPolicy {
    MINIMAL_REQUIREMENTS,
    MODERATE_PASSWORD,
    STRONG_PASSWORD,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.PasswordStrengthPolicy$1 */
    static /* synthetic */ class C45501 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teampolicies$PasswordStrengthPolicy */
        static final /* synthetic */ int[] f808x122cb817;

        static {
            int[] iArr = new int[PasswordStrengthPolicy.values().length];
            f808x122cb817 = iArr;
            try {
                iArr[PasswordStrengthPolicy.MINIMAL_REQUIREMENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f808x122cb817[PasswordStrengthPolicy.MODERATE_PASSWORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f808x122cb817[PasswordStrengthPolicy.STRONG_PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<PasswordStrengthPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PasswordStrengthPolicy passwordStrengthPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45501.f808x122cb817[passwordStrengthPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("minimal_requirements");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("moderate_password");
            } else if (i == 3) {
                jsonGenerator.writeString("strong_password");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PasswordStrengthPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PasswordStrengthPolicy passwordStrengthPolicy;
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
            if ("minimal_requirements".equals(tag)) {
                passwordStrengthPolicy = PasswordStrengthPolicy.MINIMAL_REQUIREMENTS;
            } else if ("moderate_password".equals(tag)) {
                passwordStrengthPolicy = PasswordStrengthPolicy.MODERATE_PASSWORD;
            } else if ("strong_password".equals(tag)) {
                passwordStrengthPolicy = PasswordStrengthPolicy.STRONG_PASSWORD;
            } else {
                passwordStrengthPolicy = PasswordStrengthPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return passwordStrengthPolicy;
        }
    }
}
