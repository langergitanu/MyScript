package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersSetPermissions2Error {
    USER_NOT_FOUND,
    LAST_ADMIN,
    USER_NOT_IN_TEAM,
    CANNOT_SET_PERMISSIONS,
    ROLE_NOT_FOUND,
    OTHER;

    static class Serializer extends UnionSerializer<MembersSetPermissions2Error> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersSetPermissions2Error membersSetPermissions2Error, JsonGenerator jsonGenerator) throws IOException {
            int i = C43801.$SwitchMap$com$dropbox$core$v2$team$MembersSetPermissions2Error[membersSetPermissions2Error.ordinal()];
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
                jsonGenerator.writeString("role_not_found");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersSetPermissions2Error deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersSetPermissions2Error membersSetPermissions2Error;
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
                membersSetPermissions2Error = MembersSetPermissions2Error.USER_NOT_FOUND;
            } else if ("last_admin".equals(tag)) {
                membersSetPermissions2Error = MembersSetPermissions2Error.LAST_ADMIN;
            } else if ("user_not_in_team".equals(tag)) {
                membersSetPermissions2Error = MembersSetPermissions2Error.USER_NOT_IN_TEAM;
            } else if ("cannot_set_permissions".equals(tag)) {
                membersSetPermissions2Error = MembersSetPermissions2Error.CANNOT_SET_PERMISSIONS;
            } else if ("role_not_found".equals(tag)) {
                membersSetPermissions2Error = MembersSetPermissions2Error.ROLE_NOT_FOUND;
            } else {
                membersSetPermissions2Error = MembersSetPermissions2Error.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersSetPermissions2Error;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersSetPermissions2Error$1 */
    static /* synthetic */ class C43801 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissions2Error;

        static {
            int[] iArr = new int[MembersSetPermissions2Error.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissions2Error = iArr;
            try {
                iArr[MembersSetPermissions2Error.USER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissions2Error[MembersSetPermissions2Error.LAST_ADMIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissions2Error[MembersSetPermissions2Error.USER_NOT_IN_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissions2Error[MembersSetPermissions2Error.CANNOT_SET_PERMISSIONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetPermissions2Error[MembersSetPermissions2Error.ROLE_NOT_FOUND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
