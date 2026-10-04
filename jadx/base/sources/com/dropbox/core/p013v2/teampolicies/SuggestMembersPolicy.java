package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SuggestMembersPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<SuggestMembersPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SuggestMembersPolicy suggestMembersPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45591.$SwitchMap$com$dropbox$core$v2$teampolicies$SuggestMembersPolicy[suggestMembersPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SuggestMembersPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SuggestMembersPolicy suggestMembersPolicy;
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
                suggestMembersPolicy = SuggestMembersPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                suggestMembersPolicy = SuggestMembersPolicy.ENABLED;
            } else {
                suggestMembersPolicy = SuggestMembersPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return suggestMembersPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.SuggestMembersPolicy$1 */
    static /* synthetic */ class C45591 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teampolicies$SuggestMembersPolicy;

        static {
            int[] iArr = new int[SuggestMembersPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teampolicies$SuggestMembersPolicy = iArr;
            try {
                iArr[SuggestMembersPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teampolicies$SuggestMembersPolicy[SuggestMembersPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
