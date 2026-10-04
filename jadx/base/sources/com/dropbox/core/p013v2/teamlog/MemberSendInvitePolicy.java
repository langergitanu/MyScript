package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MemberSendInvitePolicy {
    DISABLED,
    EVERYONE,
    SPECIFIC_MEMBERS,
    OTHER;

    static class Serializer extends UnionSerializer<MemberSendInvitePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberSendInvitePolicy memberSendInvitePolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44951.$SwitchMap$com$dropbox$core$v2$teamlog$MemberSendInvitePolicy[memberSendInvitePolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("everyone");
            } else if (i == 3) {
                jsonGenerator.writeString("specific_members");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberSendInvitePolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberSendInvitePolicy memberSendInvitePolicy;
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
                memberSendInvitePolicy = MemberSendInvitePolicy.DISABLED;
            } else if ("everyone".equals(tag)) {
                memberSendInvitePolicy = MemberSendInvitePolicy.EVERYONE;
            } else if ("specific_members".equals(tag)) {
                memberSendInvitePolicy = MemberSendInvitePolicy.SPECIFIC_MEMBERS;
            } else {
                memberSendInvitePolicy = MemberSendInvitePolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberSendInvitePolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.MemberSendInvitePolicy$1 */
    static /* synthetic */ class C44951 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$MemberSendInvitePolicy;

        static {
            int[] iArr = new int[MemberSendInvitePolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$MemberSendInvitePolicy = iArr;
            try {
                iArr[MemberSendInvitePolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberSendInvitePolicy[MemberSendInvitePolicy.EVERYONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberSendInvitePolicy[MemberSendInvitePolicy.SPECIFIC_MEMBERS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
