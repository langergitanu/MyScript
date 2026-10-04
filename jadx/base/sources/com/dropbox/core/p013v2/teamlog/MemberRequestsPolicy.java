package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MemberRequestsPolicy {
    AUTO_ACCEPT,
    DISABLED,
    REQUIRE_APPROVAL,
    OTHER;

    static class Serializer extends UnionSerializer<MemberRequestsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberRequestsPolicy memberRequestsPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44941.$SwitchMap$com$dropbox$core$v2$teamlog$MemberRequestsPolicy[memberRequestsPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("auto_accept");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("disabled");
            } else if (i == 3) {
                jsonGenerator.writeString("require_approval");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberRequestsPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberRequestsPolicy memberRequestsPolicy;
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
            if ("auto_accept".equals(tag)) {
                memberRequestsPolicy = MemberRequestsPolicy.AUTO_ACCEPT;
            } else if ("disabled".equals(tag)) {
                memberRequestsPolicy = MemberRequestsPolicy.DISABLED;
            } else if ("require_approval".equals(tag)) {
                memberRequestsPolicy = MemberRequestsPolicy.REQUIRE_APPROVAL;
            } else {
                memberRequestsPolicy = MemberRequestsPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberRequestsPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.MemberRequestsPolicy$1 */
    static /* synthetic */ class C44941 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$MemberRequestsPolicy;

        static {
            int[] iArr = new int[MemberRequestsPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$MemberRequestsPolicy = iArr;
            try {
                iArr[MemberRequestsPolicy.AUTO_ACCEPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberRequestsPolicy[MemberRequestsPolicy.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberRequestsPolicy[MemberRequestsPolicy.REQUIRE_APPROVAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
