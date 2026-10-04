package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersRemoveError {
    USER_NOT_FOUND,
    USER_NOT_IN_TEAM,
    OTHER,
    REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER,
    REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER,
    TRANSFER_DEST_USER_NOT_FOUND,
    TRANSFER_DEST_USER_NOT_IN_TEAM,
    TRANSFER_ADMIN_USER_NOT_IN_TEAM,
    TRANSFER_ADMIN_USER_NOT_FOUND,
    UNSPECIFIED_TRANSFER_ADMIN_ID,
    TRANSFER_ADMIN_IS_NOT_ADMIN,
    RECIPIENT_NOT_VERIFIED,
    REMOVE_LAST_ADMIN,
    CANNOT_KEEP_ACCOUNT_AND_TRANSFER,
    CANNOT_KEEP_ACCOUNT_AND_DELETE_DATA,
    EMAIL_ADDRESS_TOO_LONG_TO_BE_DISABLED,
    CANNOT_KEEP_INVITED_USER_ACCOUNT,
    CANNOT_RETAIN_SHARES_WHEN_DATA_WIPED,
    CANNOT_RETAIN_SHARES_WHEN_NO_ACCOUNT_KEPT,
    CANNOT_RETAIN_SHARES_WHEN_TEAM_EXTERNAL_SHARING_OFF,
    CANNOT_KEEP_ACCOUNT,
    CANNOT_KEEP_ACCOUNT_UNDER_LEGAL_HOLD,
    CANNOT_KEEP_ACCOUNT_REQUIRED_TO_SIGN_TOS;

    static class Serializer extends UnionSerializer<MembersRemoveError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersRemoveError membersRemoveError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43781.$SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[membersRemoveError.ordinal()]) {
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
                    jsonGenerator.writeString("removed_and_transfer_dest_should_differ");
                    return;
                case 5:
                    jsonGenerator.writeString("removed_and_transfer_admin_should_differ");
                    return;
                case 6:
                    jsonGenerator.writeString("transfer_dest_user_not_found");
                    return;
                case 7:
                    jsonGenerator.writeString("transfer_dest_user_not_in_team");
                    return;
                case 8:
                    jsonGenerator.writeString("transfer_admin_user_not_in_team");
                    return;
                case 9:
                    jsonGenerator.writeString("transfer_admin_user_not_found");
                    return;
                case 10:
                    jsonGenerator.writeString("unspecified_transfer_admin_id");
                    return;
                case 11:
                    jsonGenerator.writeString("transfer_admin_is_not_admin");
                    return;
                case 12:
                    jsonGenerator.writeString("recipient_not_verified");
                    return;
                case 13:
                    jsonGenerator.writeString("remove_last_admin");
                    return;
                case 14:
                    jsonGenerator.writeString("cannot_keep_account_and_transfer");
                    return;
                case 15:
                    jsonGenerator.writeString("cannot_keep_account_and_delete_data");
                    return;
                case 16:
                    jsonGenerator.writeString("email_address_too_long_to_be_disabled");
                    return;
                case 17:
                    jsonGenerator.writeString("cannot_keep_invited_user_account");
                    return;
                case 18:
                    jsonGenerator.writeString("cannot_retain_shares_when_data_wiped");
                    return;
                case 19:
                    jsonGenerator.writeString("cannot_retain_shares_when_no_account_kept");
                    return;
                case 20:
                    jsonGenerator.writeString("cannot_retain_shares_when_team_external_sharing_off");
                    return;
                case 21:
                    jsonGenerator.writeString("cannot_keep_account");
                    return;
                case 22:
                    jsonGenerator.writeString("cannot_keep_account_under_legal_hold");
                    return;
                case 23:
                    jsonGenerator.writeString("cannot_keep_account_required_to_sign_tos");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + membersRemoveError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersRemoveError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersRemoveError membersRemoveError;
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
                membersRemoveError = MembersRemoveError.USER_NOT_FOUND;
            } else if ("user_not_in_team".equals(tag)) {
                membersRemoveError = MembersRemoveError.USER_NOT_IN_TEAM;
            } else if ("other".equals(tag)) {
                membersRemoveError = MembersRemoveError.OTHER;
            } else if ("removed_and_transfer_dest_should_differ".equals(tag)) {
                membersRemoveError = MembersRemoveError.REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER;
            } else if ("removed_and_transfer_admin_should_differ".equals(tag)) {
                membersRemoveError = MembersRemoveError.REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER;
            } else if ("transfer_dest_user_not_found".equals(tag)) {
                membersRemoveError = MembersRemoveError.TRANSFER_DEST_USER_NOT_FOUND;
            } else if ("transfer_dest_user_not_in_team".equals(tag)) {
                membersRemoveError = MembersRemoveError.TRANSFER_DEST_USER_NOT_IN_TEAM;
            } else if ("transfer_admin_user_not_in_team".equals(tag)) {
                membersRemoveError = MembersRemoveError.TRANSFER_ADMIN_USER_NOT_IN_TEAM;
            } else if ("transfer_admin_user_not_found".equals(tag)) {
                membersRemoveError = MembersRemoveError.TRANSFER_ADMIN_USER_NOT_FOUND;
            } else if ("unspecified_transfer_admin_id".equals(tag)) {
                membersRemoveError = MembersRemoveError.UNSPECIFIED_TRANSFER_ADMIN_ID;
            } else if ("transfer_admin_is_not_admin".equals(tag)) {
                membersRemoveError = MembersRemoveError.TRANSFER_ADMIN_IS_NOT_ADMIN;
            } else if ("recipient_not_verified".equals(tag)) {
                membersRemoveError = MembersRemoveError.RECIPIENT_NOT_VERIFIED;
            } else if ("remove_last_admin".equals(tag)) {
                membersRemoveError = MembersRemoveError.REMOVE_LAST_ADMIN;
            } else if ("cannot_keep_account_and_transfer".equals(tag)) {
                membersRemoveError = MembersRemoveError.CANNOT_KEEP_ACCOUNT_AND_TRANSFER;
            } else if ("cannot_keep_account_and_delete_data".equals(tag)) {
                membersRemoveError = MembersRemoveError.CANNOT_KEEP_ACCOUNT_AND_DELETE_DATA;
            } else if ("email_address_too_long_to_be_disabled".equals(tag)) {
                membersRemoveError = MembersRemoveError.EMAIL_ADDRESS_TOO_LONG_TO_BE_DISABLED;
            } else if ("cannot_keep_invited_user_account".equals(tag)) {
                membersRemoveError = MembersRemoveError.CANNOT_KEEP_INVITED_USER_ACCOUNT;
            } else if ("cannot_retain_shares_when_data_wiped".equals(tag)) {
                membersRemoveError = MembersRemoveError.CANNOT_RETAIN_SHARES_WHEN_DATA_WIPED;
            } else if ("cannot_retain_shares_when_no_account_kept".equals(tag)) {
                membersRemoveError = MembersRemoveError.CANNOT_RETAIN_SHARES_WHEN_NO_ACCOUNT_KEPT;
            } else if ("cannot_retain_shares_when_team_external_sharing_off".equals(tag)) {
                membersRemoveError = MembersRemoveError.CANNOT_RETAIN_SHARES_WHEN_TEAM_EXTERNAL_SHARING_OFF;
            } else if ("cannot_keep_account".equals(tag)) {
                membersRemoveError = MembersRemoveError.CANNOT_KEEP_ACCOUNT;
            } else if ("cannot_keep_account_under_legal_hold".equals(tag)) {
                membersRemoveError = MembersRemoveError.CANNOT_KEEP_ACCOUNT_UNDER_LEGAL_HOLD;
            } else if ("cannot_keep_account_required_to_sign_tos".equals(tag)) {
                membersRemoveError = MembersRemoveError.CANNOT_KEEP_ACCOUNT_REQUIRED_TO_SIGN_TOS;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersRemoveError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersRemoveError$1 */
    static /* synthetic */ class C43781 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError;

        static {
            int[] iArr = new int[MembersRemoveError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError = iArr;
            try {
                iArr[MembersRemoveError.USER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.USER_NOT_IN_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.TRANSFER_DEST_USER_NOT_FOUND.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.TRANSFER_DEST_USER_NOT_IN_TEAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.TRANSFER_ADMIN_USER_NOT_IN_TEAM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.TRANSFER_ADMIN_USER_NOT_FOUND.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.UNSPECIFIED_TRANSFER_ADMIN_ID.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.TRANSFER_ADMIN_IS_NOT_ADMIN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.RECIPIENT_NOT_VERIFIED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.REMOVE_LAST_ADMIN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.CANNOT_KEEP_ACCOUNT_AND_TRANSFER.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.CANNOT_KEEP_ACCOUNT_AND_DELETE_DATA.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.EMAIL_ADDRESS_TOO_LONG_TO_BE_DISABLED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.CANNOT_KEEP_INVITED_USER_ACCOUNT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.CANNOT_RETAIN_SHARES_WHEN_DATA_WIPED.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.CANNOT_RETAIN_SHARES_WHEN_NO_ACCOUNT_KEPT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.CANNOT_RETAIN_SHARES_WHEN_TEAM_EXTERNAL_SHARING_OFF.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.CANNOT_KEEP_ACCOUNT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.CANNOT_KEEP_ACCOUNT_UNDER_LEGAL_HOLD.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersRemoveError[MembersRemoveError.CANNOT_KEEP_ACCOUNT_REQUIRED_TO_SIGN_TOS.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }
}
