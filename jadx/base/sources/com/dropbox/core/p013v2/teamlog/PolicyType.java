package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum PolicyType {
    DISPOSITION,
    RETENTION,
    OTHER;

    static class Serializer extends UnionSerializer<PolicyType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PolicyType policyType, JsonGenerator jsonGenerator) throws IOException {
            int i = C45081.$SwitchMap$com$dropbox$core$v2$teamlog$PolicyType[policyType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disposition");
            } else if (i == 2) {
                jsonGenerator.writeString("retention");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PolicyType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PolicyType policyType;
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
            if ("disposition".equals(tag)) {
                policyType = PolicyType.DISPOSITION;
            } else if ("retention".equals(tag)) {
                policyType = PolicyType.RETENTION;
            } else {
                policyType = PolicyType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return policyType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.PolicyType$1 */
    static /* synthetic */ class C45081 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$PolicyType;

        static {
            int[] iArr = new int[PolicyType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$PolicyType = iArr;
            try {
                iArr[PolicyType.DISPOSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PolicyType[PolicyType.RETENTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
