package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ExcludedUsersUpdateError {
    USERS_NOT_IN_TEAM,
    TOO_MANY_USERS,
    OTHER;

    static class Serializer extends UnionSerializer<ExcludedUsersUpdateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ExcludedUsersUpdateError excludedUsersUpdateError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43291.$SwitchMap$com$dropbox$core$v2$team$ExcludedUsersUpdateError[excludedUsersUpdateError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("users_not_in_team");
            } else if (i == 2) {
                jsonGenerator.writeString("too_many_users");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ExcludedUsersUpdateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ExcludedUsersUpdateError excludedUsersUpdateError;
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
            if ("users_not_in_team".equals(tag)) {
                excludedUsersUpdateError = ExcludedUsersUpdateError.USERS_NOT_IN_TEAM;
            } else if ("too_many_users".equals(tag)) {
                excludedUsersUpdateError = ExcludedUsersUpdateError.TOO_MANY_USERS;
            } else {
                excludedUsersUpdateError = ExcludedUsersUpdateError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return excludedUsersUpdateError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ExcludedUsersUpdateError$1 */
    static /* synthetic */ class C43291 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$ExcludedUsersUpdateError;

        static {
            int[] iArr = new int[ExcludedUsersUpdateError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$ExcludedUsersUpdateError = iArr;
            try {
                iArr[ExcludedUsersUpdateError.USERS_NOT_IN_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$ExcludedUsersUpdateError[ExcludedUsersUpdateError.TOO_MANY_USERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
