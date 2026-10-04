package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum LegalHoldsPolicyUpdateError {
    UNKNOWN_LEGAL_HOLD_ERROR,
    INSUFFICIENT_PERMISSIONS,
    OTHER,
    TRANSIENT_ERROR,
    INACTIVE_LEGAL_HOLD,
    LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION,
    INVALID_MEMBERS,
    NUMBER_OF_USERS_ON_HOLD_IS_GREATER_THAN_HOLD_LIMITATION,
    EMPTY_MEMBERS_LIST,
    NAME_MUST_BE_UNIQUE,
    LEGAL_HOLD_POLICY_NOT_FOUND;

    static class Serializer extends UnionSerializer<LegalHoldsPolicyUpdateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LegalHoldsPolicyUpdateError legalHoldsPolicyUpdateError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43581.$SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[legalHoldsPolicyUpdateError.ordinal()]) {
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
                    jsonGenerator.writeString("transient_error");
                    return;
                case 5:
                    jsonGenerator.writeString("inactive_legal_hold");
                    return;
                case 6:
                    jsonGenerator.writeString("legal_hold_performing_another_operation");
                    return;
                case 7:
                    jsonGenerator.writeString("invalid_members");
                    return;
                case 8:
                    jsonGenerator.writeString("number_of_users_on_hold_is_greater_than_hold_limitation");
                    return;
                case 9:
                    jsonGenerator.writeString("empty_members_list");
                    return;
                case 10:
                    jsonGenerator.writeString("name_must_be_unique");
                    return;
                case 11:
                    jsonGenerator.writeString("legal_hold_policy_not_found");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + legalHoldsPolicyUpdateError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LegalHoldsPolicyUpdateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LegalHoldsPolicyUpdateError legalHoldsPolicyUpdateError;
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
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.UNKNOWN_LEGAL_HOLD_ERROR;
            } else if ("insufficient_permissions".equals(tag)) {
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.OTHER;
            } else if ("transient_error".equals(tag)) {
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.TRANSIENT_ERROR;
            } else if ("inactive_legal_hold".equals(tag)) {
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.INACTIVE_LEGAL_HOLD;
            } else if ("legal_hold_performing_another_operation".equals(tag)) {
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION;
            } else if ("invalid_members".equals(tag)) {
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.INVALID_MEMBERS;
            } else if ("number_of_users_on_hold_is_greater_than_hold_limitation".equals(tag)) {
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.NUMBER_OF_USERS_ON_HOLD_IS_GREATER_THAN_HOLD_LIMITATION;
            } else if ("empty_members_list".equals(tag)) {
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.EMPTY_MEMBERS_LIST;
            } else if ("name_must_be_unique".equals(tag)) {
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.NAME_MUST_BE_UNIQUE;
            } else if ("legal_hold_policy_not_found".equals(tag)) {
                legalHoldsPolicyUpdateError = LegalHoldsPolicyUpdateError.LEGAL_HOLD_POLICY_NOT_FOUND;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return legalHoldsPolicyUpdateError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.LegalHoldsPolicyUpdateError$1 */
    static /* synthetic */ class C43581 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError;

        static {
            int[] iArr = new int[LegalHoldsPolicyUpdateError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError = iArr;
            try {
                iArr[LegalHoldsPolicyUpdateError.UNKNOWN_LEGAL_HOLD_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[LegalHoldsPolicyUpdateError.INSUFFICIENT_PERMISSIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[LegalHoldsPolicyUpdateError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[LegalHoldsPolicyUpdateError.TRANSIENT_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[LegalHoldsPolicyUpdateError.INACTIVE_LEGAL_HOLD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[LegalHoldsPolicyUpdateError.LEGAL_HOLD_PERFORMING_ANOTHER_OPERATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[LegalHoldsPolicyUpdateError.INVALID_MEMBERS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[LegalHoldsPolicyUpdateError.NUMBER_OF_USERS_ON_HOLD_IS_GREATER_THAN_HOLD_LIMITATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[LegalHoldsPolicyUpdateError.EMPTY_MEMBERS_LIST.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[LegalHoldsPolicyUpdateError.NAME_MUST_BE_UNIQUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$LegalHoldsPolicyUpdateError[LegalHoldsPolicyUpdateError.LEGAL_HOLD_POLICY_NOT_FOUND.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }
}
