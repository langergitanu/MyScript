package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersRecoverError {
    USER_NOT_FOUND,
    USER_UNRECOVERABLE,
    USER_NOT_IN_TEAM,
    TEAM_LICENSE_LIMIT,
    OTHER;

    static class Serializer extends UnionSerializer<MembersRecoverError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersRecoverError membersRecoverError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43771.$SwitchMap$com$dropbox$core$v2$team$MembersRecoverError[membersRecoverError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("user_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("user_unrecoverable");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("user_not_in_team");
            } else if (i == 4) {
                jsonGenerator.writeString("team_license_limit");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersRecoverError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersRecoverError membersRecoverError;
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
                membersRecoverError = MembersRecoverError.USER_NOT_FOUND;
            } else if ("user_unrecoverable".equals(tag)) {
                membersRecoverError = MembersRecoverError.USER_UNRECOVERABLE;
            } else if ("user_not_in_team".equals(tag)) {
                membersRecoverError = MembersRecoverError.USER_NOT_IN_TEAM;
            } else if ("team_license_limit".equals(tag)) {
                membersRecoverError = MembersRecoverError.TEAM_LICENSE_LIMIT;
            } else {
                membersRecoverError = MembersRecoverError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersRecoverError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersRecoverError$1 */
    static /* synthetic */ class C43771 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersRecoverError;

        static {
            int[] iArr = new int[MembersRecoverError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersRecoverError = iArr;
            try {
                iArr[MembersRecoverError.USER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRecoverError[MembersRecoverError.USER_UNRECOVERABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRecoverError[MembersRecoverError.USER_NOT_IN_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRecoverError[MembersRecoverError.TEAM_LICENSE_LIMIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
