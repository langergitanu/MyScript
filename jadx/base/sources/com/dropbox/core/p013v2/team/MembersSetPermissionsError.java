package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersSetPermissionsError {
    USER_NOT_FOUND,
    LAST_ADMIN,
    USER_NOT_IN_TEAM,
    CANNOT_SET_PERMISSIONS,
    TEAM_LICENSE_LIMIT,
    OTHER;

    static class Serializer extends UnionSerializer<MembersSetPermissionsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersSetPermissionsError membersSetPermissionsError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43811.$SwitchMap$com$dropbox$core$v2$team$MembersSetPermissionsError[membersSetPermissionsError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("user_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("last_admin");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("user_not_in_team");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("cannot_set_permissions");
            } else if (i == 5) {
                jsonGenerator.writeString("team_license_limit");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersSetPermissionsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersSetPermissionsError membersSetPermissionsError;
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
                membersSetPermissionsError = MembersSetPermissionsError.USER_NOT_FOUND;
            } else if ("last_admin".equals(tag)) {
                membersSetPermissionsError = MembersSetPermissionsError.LAST_ADMIN;
            } else if ("user_not_in_team".equals(tag)) {
                membersSetPermissionsError = MembersSetPermissionsError.USER_NOT_IN_TEAM;
            } else if ("cannot_set_permissions".equals(tag)) {
                membersSetPermissionsError = MembersSetPermissionsError.CANNOT_SET_PERMISSIONS;
            } else if ("team_license_limit".equals(tag)) {
                membersSetPermissionsError = MembersSetPermissionsError.TEAM_LICENSE_LIMIT;
            } else {
                membersSetPermissionsError = MembersSetPermissionsError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersSetPermissionsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersSetPermissionsError$1 */
    static /* synthetic */ class C43811 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissionsError;

        static {
            int[] iArr = new int[MembersSetPermissionsError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissionsError = iArr;
            try {
                iArr[MembersSetPermissionsError.USER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissionsError[MembersSetPermissionsError.LAST_ADMIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissionsError[MembersSetPermissionsError.USER_NOT_IN_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissionsError[MembersSetPermissionsError.CANNOT_SET_PERMISSIONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissionsError[MembersSetPermissionsError.TEAM_LICENSE_LIMIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
