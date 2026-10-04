package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum InviteMethod {
    AUTO_APPROVE,
    INVITE_LINK,
    MEMBER_INVITE,
    MOVED_FROM_ANOTHER_TEAM,
    OTHER;

    static class Serializer extends UnionSerializer<InviteMethod> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(InviteMethod inviteMethod, JsonGenerator jsonGenerator) throws IOException {
            int i = C44881.$SwitchMap$com$dropbox$core$v2$teamlog$InviteMethod[inviteMethod.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("auto_approve");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("invite_link");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("member_invite");
            } else if (i == 4) {
                jsonGenerator.writeString("moved_from_another_team");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public InviteMethod deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            InviteMethod inviteMethod;
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
            if ("auto_approve".equals(tag)) {
                inviteMethod = InviteMethod.AUTO_APPROVE;
            } else if ("invite_link".equals(tag)) {
                inviteMethod = InviteMethod.INVITE_LINK;
            } else if ("member_invite".equals(tag)) {
                inviteMethod = InviteMethod.MEMBER_INVITE;
            } else if ("moved_from_another_team".equals(tag)) {
                inviteMethod = InviteMethod.MOVED_FROM_ANOTHER_TEAM;
            } else {
                inviteMethod = InviteMethod.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return inviteMethod;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.InviteMethod$1 */
    static /* synthetic */ class C44881 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$InviteMethod;

        static {
            int[] iArr = new int[InviteMethod.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$InviteMethod = iArr;
            try {
                iArr[InviteMethod.AUTO_APPROVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$InviteMethod[InviteMethod.INVITE_LINK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$InviteMethod[InviteMethod.MEMBER_INVITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$InviteMethod[InviteMethod.MOVED_FROM_ANOTHER_TEAM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
