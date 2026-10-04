package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SsoPolicy {
    DISABLED,
    OPTIONAL,
    REQUIRED,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.SsoPolicy$1 */
    static /* synthetic */ class C45581 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teampolicies$SsoPolicy;

        static {
            int[] iArr = new int[SsoPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teampolicies$SsoPolicy = iArr;
            try {
                iArr[SsoPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teampolicies$SsoPolicy[SsoPolicy.OPTIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teampolicies$SsoPolicy[SsoPolicy.REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<SsoPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SsoPolicy ssoPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45581.$SwitchMap$com$dropbox$core$v2$teampolicies$SsoPolicy[ssoPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("optional");
            } else if (i == 3) {
                jsonGenerator.writeString("required");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SsoPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SsoPolicy ssoPolicy;
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
                ssoPolicy = SsoPolicy.DISABLED;
            } else if ("optional".equals(tag)) {
                ssoPolicy = SsoPolicy.OPTIONAL;
            } else if ("required".equals(tag)) {
                ssoPolicy = SsoPolicy.REQUIRED;
            } else {
                ssoPolicy = SsoPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return ssoPolicy;
        }
    }
}
