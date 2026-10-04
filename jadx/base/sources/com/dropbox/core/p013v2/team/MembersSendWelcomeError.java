package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersSendWelcomeError {
    USER_NOT_FOUND,
    USER_NOT_IN_TEAM,
    OTHER;

    static class Serializer extends UnionSerializer<MembersSendWelcomeError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersSendWelcomeError membersSendWelcomeError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43791.$SwitchMap$com$dropbox$core$v2$team$MembersSendWelcomeError[membersSendWelcomeError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("user_not_found");
            } else if (i == 2) {
                jsonGenerator.writeString("user_not_in_team");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersSendWelcomeError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersSendWelcomeError membersSendWelcomeError;
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
            if ("user_not_found".equals(tag)) {
                membersSendWelcomeError = MembersSendWelcomeError.USER_NOT_FOUND;
            } else if ("user_not_in_team".equals(tag)) {
                membersSendWelcomeError = MembersSendWelcomeError.USER_NOT_IN_TEAM;
            } else {
                membersSendWelcomeError = MembersSendWelcomeError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersSendWelcomeError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersSendWelcomeError$1 */
    static /* synthetic */ class C43791 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersSendWelcomeError;

        static {
            int[] iArr = new int[MembersSendWelcomeError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersSendWelcomeError = iArr;
            try {
                iArr[MembersSendWelcomeError.USER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSendWelcomeError[MembersSendWelcomeError.USER_NOT_IN_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
