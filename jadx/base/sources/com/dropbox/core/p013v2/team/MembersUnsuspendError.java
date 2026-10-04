package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersUnsuspendError {
    USER_NOT_FOUND,
    USER_NOT_IN_TEAM,
    OTHER,
    UNSUSPEND_NON_SUSPENDED_MEMBER,
    TEAM_LICENSE_LIMIT;

    static class Serializer extends UnionSerializer<MembersUnsuspendError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersUnsuspendError membersUnsuspendError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43861.$SwitchMap$com$dropbox$core$v2$team$MembersUnsuspendError[membersUnsuspendError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("user_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("user_not_in_team");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("other");
            } else if (i == 4) {
                jsonGenerator.writeString("unsuspend_non_suspended_member");
            } else {
                if (i == 5) {
                    jsonGenerator.writeString("team_license_limit");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + membersUnsuspendError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersUnsuspendError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersUnsuspendError membersUnsuspendError;
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
                membersUnsuspendError = MembersUnsuspendError.USER_NOT_FOUND;
            } else if ("user_not_in_team".equals(tag)) {
                membersUnsuspendError = MembersUnsuspendError.USER_NOT_IN_TEAM;
            } else if ("other".equals(tag)) {
                membersUnsuspendError = MembersUnsuspendError.OTHER;
            } else if ("unsuspend_non_suspended_member".equals(tag)) {
                membersUnsuspendError = MembersUnsuspendError.UNSUSPEND_NON_SUSPENDED_MEMBER;
            } else if ("team_license_limit".equals(tag)) {
                membersUnsuspendError = MembersUnsuspendError.TEAM_LICENSE_LIMIT;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersUnsuspendError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersUnsuspendError$1 */
    static /* synthetic */ class C43861 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersUnsuspendError;

        static {
            int[] iArr = new int[MembersUnsuspendError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersUnsuspendError = iArr;
            try {
                iArr[MembersUnsuspendError.USER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersUnsuspendError[MembersUnsuspendError.USER_NOT_IN_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersUnsuspendError[MembersUnsuspendError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersUnsuspendError[MembersUnsuspendError.UNSUSPEND_NON_SUSPENDED_MEMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersUnsuspendError[MembersUnsuspendError.TEAM_LICENSE_LIMIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
