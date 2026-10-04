package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum LegalHoldsPolicyCreateError {
    UNKNOWN_LEGAL_HOLD_ERROR,
    INSUFFICIENT_PERMISSIONS,
    OTHER,
    START_DATE_IS_LATER_THAN_END_DATE,
    EMPTY_MEMBERS_LIST,
    INVALID_MEMBERS,
    NUMBER_OF_USERS_ON_HOLD_IS_GREATER_THAN_HOLD_LIMITATION,
    TRANSIENT_ERROR,
    NAME_MUST_BE_UNIQUE,
    TEAM_EXCEEDED_LEGAL_HOLD_QUOTA,
    INVALID_DATE;

    static class Serializer extends UnionSerializer<LegalHoldsPolicyCreateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LegalHoldsPolicyCreateError legalHoldsPolicyCreateError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43561.$SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[legalHoldsPolicyCreateError.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("unknown_legal_hold_error");
                    return;
                case 2:
                    jsonGenerator.writeString("insufficient_permissions");
                    return;
                case 3:
                    jsonGenerator.writeString("other");
                    return;
                case 4:
                    jsonGenerator.writeString("start_date_is_later_than_end_date");
                    return;
                case 5:
                    jsonGenerator.writeString("empty_members_list");
                    return;
                case 6:
                    jsonGenerator.writeString("invalid_members");
                    return;
                case 7:
                    jsonGenerator.writeString("number_of_users_on_hold_is_greater_than_hold_limitation");
                    return;
                case 8:
                    jsonGenerator.writeString("transient_error");
                    return;
                case 9:
                    jsonGenerator.writeString("name_must_be_unique");
                    return;
                case 10:
                    jsonGenerator.writeString("team_exceeded_legal_hold_quota");
                    return;
                case 11:
                    jsonGenerator.writeString("invalid_date");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + legalHoldsPolicyCreateError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LegalHoldsPolicyCreateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LegalHoldsPolicyCreateError legalHoldsPolicyCreateError;
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
            if ("unknown_legal_hold_error".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.UNKNOWN_LEGAL_HOLD_ERROR;
            } else if ("insufficient_permissions".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.OTHER;
            } else if ("start_date_is_later_than_end_date".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.START_DATE_IS_LATER_THAN_END_DATE;
            } else if ("empty_members_list".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.EMPTY_MEMBERS_LIST;
            } else if ("invalid_members".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.INVALID_MEMBERS;
            } else if ("number_of_users_on_hold_is_greater_than_hold_limitation".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.NUMBER_OF_USERS_ON_HOLD_IS_GREATER_THAN_HOLD_LIMITATION;
            } else if ("transient_error".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.TRANSIENT_ERROR;
            } else if ("name_must_be_unique".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.NAME_MUST_BE_UNIQUE;
            } else if ("team_exceeded_legal_hold_quota".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.TEAM_EXCEEDED_LEGAL_HOLD_QUOTA;
            } else if ("invalid_date".equals(tag)) {
                legalHoldsPolicyCreateError = LegalHoldsPolicyCreateError.INVALID_DATE;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return legalHoldsPolicyCreateError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.LegalHoldsPolicyCreateError$1 */
    static /* synthetic */ class C43561 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError;

        static {
            int[] iArr = new int[LegalHoldsPolicyCreateError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError = iArr;
            try {
                iArr[LegalHoldsPolicyCreateError.UNKNOWN_LEGAL_HOLD_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[LegalHoldsPolicyCreateError.INSUFFICIENT_PERMISSIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[LegalHoldsPolicyCreateError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[LegalHoldsPolicyCreateError.START_DATE_IS_LATER_THAN_END_DATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[LegalHoldsPolicyCreateError.EMPTY_MEMBERS_LIST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[LegalHoldsPolicyCreateError.INVALID_MEMBERS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[LegalHoldsPolicyCreateError.NUMBER_OF_USERS_ON_HOLD_IS_GREATER_THAN_HOLD_LIMITATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[LegalHoldsPolicyCreateError.TRANSIENT_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[LegalHoldsPolicyCreateError.NAME_MUST_BE_UNIQUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[LegalHoldsPolicyCreateError.TEAM_EXCEEDED_LEGAL_HOLD_QUOTA.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyCreateError[LegalHoldsPolicyCreateError.INVALID_DATE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }
}
