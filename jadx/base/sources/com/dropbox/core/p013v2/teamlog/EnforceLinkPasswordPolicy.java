package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum EnforceLinkPasswordPolicy {
    OPTIONAL,
    REQUIRED,
    OTHER;

    static class Serializer extends UnionSerializer<EnforceLinkPasswordPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(EnforceLinkPasswordPolicy enforceLinkPasswordPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44631.$SwitchMap$com$dropbox$core$v2$teamlog$EnforceLinkPasswordPolicy[enforceLinkPasswordPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("optional");
            } else if (i == 2) {
                jsonGenerator.writeString("required");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public EnforceLinkPasswordPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            EnforceLinkPasswordPolicy enforceLinkPasswordPolicy;
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
            if ("optional".equals(tag)) {
                enforceLinkPasswordPolicy = EnforceLinkPasswordPolicy.OPTIONAL;
            } else if ("required".equals(tag)) {
                enforceLinkPasswordPolicy = EnforceLinkPasswordPolicy.REQUIRED;
            } else {
                enforceLinkPasswordPolicy = EnforceLinkPasswordPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return enforceLinkPasswordPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.EnforceLinkPasswordPolicy$1 */
    static /* synthetic */ class C44631 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$EnforceLinkPasswordPolicy;

        static {
            int[] iArr = new int[EnforceLinkPasswordPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$EnforceLinkPasswordPolicy = iArr;
            try {
                iArr[EnforceLinkPasswordPolicy.OPTIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EnforceLinkPasswordPolicy[EnforceLinkPasswordPolicy.REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
