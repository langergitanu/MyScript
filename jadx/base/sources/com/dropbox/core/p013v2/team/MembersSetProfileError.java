package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersSetProfileError {
    USER_NOT_FOUND,
    USER_NOT_IN_TEAM,
    EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE,
    NO_NEW_DATA_SPECIFIED,
    EMAIL_RESERVED_FOR_OTHER_USER,
    EXTERNAL_ID_USED_BY_OTHER_USER,
    SET_PROFILE_DISALLOWED,
    PARAM_CANNOT_BE_EMPTY,
    PERSISTENT_ID_DISABLED,
    PERSISTENT_ID_USED_BY_OTHER_USER,
    DIRECTORY_RESTRICTED_OFF,
    OTHER;

    static class Serializer extends UnionSerializer<MembersSetProfileError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersSetProfileError membersSetProfileError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43821.$SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[membersSetProfileError.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("user_not_found");
                    break;
                case 2:
                    jsonGenerator.writeString("user_not_in_team");
                    break;
                case 3:
                    jsonGenerator.writeString("external_id_and_new_external_id_unsafe");
                    break;
                case 4:
                    jsonGenerator.writeString("no_new_data_specified");
                    break;
                case 5:
                    jsonGenerator.writeString("email_reserved_for_other_user");
                    break;
                case 6:
                    jsonGenerator.writeString("external_id_used_by_other_user");
                    break;
                case 7:
                    jsonGenerator.writeString("set_profile_disallowed");
                    break;
                case 8:
                    jsonGenerator.writeString("param_cannot_be_empty");
                    break;
                case 9:
                    jsonGenerator.writeString("persistent_id_disabled");
                    break;
                case 10:
                    jsonGenerator.writeString("persistent_id_used_by_other_user");
                    break;
                case 11:
                    jsonGenerator.writeString("directory_restricted_off");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersSetProfileError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersSetProfileError membersSetProfileError;
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
                membersSetProfileError = MembersSetProfileError.USER_NOT_FOUND;
            } else if ("user_not_in_team".equals(tag)) {
                membersSetProfileError = MembersSetProfileError.USER_NOT_IN_TEAM;
            } else if ("external_id_and_new_external_id_unsafe".equals(tag)) {
                membersSetProfileError = MembersSetProfileError.EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE;
            } else if ("no_new_data_specified".equals(tag)) {
                membersSetProfileError = MembersSetProfileError.NO_NEW_DATA_SPECIFIED;
            } else if ("email_reserved_for_other_user".equals(tag)) {
                membersSetProfileError = MembersSetProfileError.EMAIL_RESERVED_FOR_OTHER_USER;
            } else if ("external_id_used_by_other_user".equals(tag)) {
                membersSetProfileError = MembersSetProfileError.EXTERNAL_ID_USED_BY_OTHER_USER;
            } else if ("set_profile_disallowed".equals(tag)) {
                membersSetProfileError = MembersSetProfileError.SET_PROFILE_DISALLOWED;
            } else if ("param_cannot_be_empty".equals(tag)) {
                membersSetProfileError = MembersSetProfileError.PARAM_CANNOT_BE_EMPTY;
            } else if ("persistent_id_disabled".equals(tag)) {
                membersSetProfileError = MembersSetProfileError.PERSISTENT_ID_DISABLED;
            } else if ("persistent_id_used_by_other_user".equals(tag)) {
                membersSetProfileError = MembersSetProfileError.PERSISTENT_ID_USED_BY_OTHER_USER;
            } else if ("directory_restricted_off".equals(tag)) {
                membersSetProfileError = MembersSetProfileError.DIRECTORY_RESTRICTED_OFF;
            } else {
                membersSetProfileError = MembersSetProfileError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersSetProfileError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersSetProfileError$1 */
    static /* synthetic */ class C43821 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError;

        static {
            int[] iArr = new int[MembersSetProfileError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError = iArr;
            try {
                iArr[MembersSetProfileError.USER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[MembersSetProfileError.USER_NOT_IN_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[MembersSetProfileError.EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[MembersSetProfileError.NO_NEW_DATA_SPECIFIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[MembersSetProfileError.EMAIL_RESERVED_FOR_OTHER_USER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[MembersSetProfileError.EXTERNAL_ID_USED_BY_OTHER_USER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[MembersSetProfileError.SET_PROFILE_DISALLOWED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[MembersSetProfileError.PARAM_CANNOT_BE_EMPTY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[MembersSetProfileError.PERSISTENT_ID_DISABLED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[MembersSetProfileError.PERSISTENT_ID_USED_BY_OTHER_USER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersSetProfileError[MembersSetProfileError.DIRECTORY_RESTRICTED_OFF.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }
}
