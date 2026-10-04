package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersSuspendError {
    USER_NOT_FOUND,
    USER_NOT_IN_TEAM,
    OTHER,
    SUSPEND_INACTIVE_USER,
    SUSPEND_LAST_ADMIN,
    TEAM_LICENSE_LIMIT;

    static class Serializer extends UnionSerializer<MembersSuspendError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersSuspendError membersSuspendError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43841.$SwitchMap$com$dropbox$core$v2$team$MembersSuspendError[membersSuspendError.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("user_not_found");
                    return;
                case 2:
                    jsonGenerator.writeString("user_not_in_team");
                    return;
                case 3:
                    jsonGenerator.writeString("other");
                    return;
                case 4:
                    jsonGenerator.writeString("suspend_inactive_user");
                    return;
                case 5:
                    jsonGenerator.writeString("suspend_last_admin");
                    return;
                case 6:
                    jsonGenerator.writeString("team_license_limit");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + membersSuspendError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersSuspendError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersSuspendError membersSuspendError;
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
                membersSuspendError = MembersSuspendError.USER_NOT_FOUND;
            } else if ("user_not_in_team".equals(tag)) {
                membersSuspendError = MembersSuspendError.USER_NOT_IN_TEAM;
            } else if ("other".equals(tag)) {
                membersSuspendError = MembersSuspendError.OTHER;
            } else if ("suspend_inactive_user".equals(tag)) {
                membersSuspendError = MembersSuspendError.SUSPEND_INACTIVE_USER;
            } else if ("suspend_last_admin".equals(tag)) {
                membersSuspendError = MembersSuspendError.SUSPEND_LAST_ADMIN;
            } else if ("team_license_limit".equals(tag)) {
                membersSuspendError = MembersSuspendError.TEAM_LICENSE_LIMIT;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersSuspendError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersSuspendError$1 */
    static /* synthetic */ class C43841 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersSuspendError;

        static {
            int[] iArr = new int[MembersSuspendError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersSuspendError = iArr;
            try {
                iArr[MembersSuspendError.USER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSuspendError[MembersSuspendError.USER_NOT_IN_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSuspendError[MembersSuspendError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSuspendError[MembersSuspendError.SUSPEND_INACTIVE_USER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSuspendError[MembersSuspendError.SUSPEND_LAST_ADMIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSuspendError[MembersSuspendError.TEAM_LICENSE_LIMIT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
