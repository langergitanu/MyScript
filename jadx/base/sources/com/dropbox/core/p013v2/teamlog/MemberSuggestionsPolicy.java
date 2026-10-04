package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MemberSuggestionsPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<MemberSuggestionsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberSuggestionsPolicy memberSuggestionsPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44971.$SwitchMap$com$dropbox$core$v2$teamlog$MemberSuggestionsPolicy[memberSuggestionsPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberSuggestionsPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberSuggestionsPolicy memberSuggestionsPolicy;
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
                memberSuggestionsPolicy = MemberSuggestionsPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                memberSuggestionsPolicy = MemberSuggestionsPolicy.ENABLED;
            } else {
                memberSuggestionsPolicy = MemberSuggestionsPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberSuggestionsPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.MemberSuggestionsPolicy$1 */
    static /* synthetic */ class C44971 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$MemberSuggestionsPolicy;

        static {
            int[] iArr = new int[MemberSuggestionsPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$MemberSuggestionsPolicy = iArr;
            try {
                iArr[MemberSuggestionsPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberSuggestionsPolicy[MemberSuggestionsPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
