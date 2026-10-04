package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum OfficeAddInPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.OfficeAddInPolicy$1 */
    static /* synthetic */ class C45471 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teampolicies$OfficeAddInPolicy;

        static {
            int[] iArr = new int[OfficeAddInPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teampolicies$OfficeAddInPolicy = iArr;
            try {
                iArr[OfficeAddInPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teampolicies$OfficeAddInPolicy[OfficeAddInPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<OfficeAddInPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(OfficeAddInPolicy officeAddInPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45471.$SwitchMap$com$dropbox$core$v2$teampolicies$OfficeAddInPolicy[officeAddInPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public OfficeAddInPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            OfficeAddInPolicy officeAddInPolicy;
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
                officeAddInPolicy = OfficeAddInPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                officeAddInPolicy = OfficeAddInPolicy.ENABLED;
            } else {
                officeAddInPolicy = OfficeAddInPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return officeAddInPolicy;
        }
    }
}
