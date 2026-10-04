package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum DeleteAllClosedFileRequestsError {
    DISABLED_FOR_TEAM,
    OTHER,
    NOT_FOUND,
    NOT_A_FOLDER,
    APP_LACKS_ACCESS,
    NO_PERMISSION,
    EMAIL_UNVERIFIED,
    VALIDATION_ERROR;

    static class Serializer extends UnionSerializer<DeleteAllClosedFileRequestsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeleteAllClosedFileRequestsError deleteAllClosedFileRequestsError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41331.f680x8bcd23fc[deleteAllClosedFileRequestsError.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("disabled_for_team");
                    return;
                case 2:
                    jsonGenerator.writeString("other");
                    return;
                case 3:
                    jsonGenerator.writeString("not_found");
                    return;
                case 4:
                    jsonGenerator.writeString("not_a_folder");
                    return;
                case 5:
                    jsonGenerator.writeString("app_lacks_access");
                    return;
                case 6:
                    jsonGenerator.writeString("no_permission");
                    return;
                case 7:
                    jsonGenerator.writeString("email_unverified");
                    return;
                case 8:
                    jsonGenerator.writeString("validation_error");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + deleteAllClosedFileRequestsError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeleteAllClosedFileRequestsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeleteAllClosedFileRequestsError deleteAllClosedFileRequestsError;
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
            if ("disabled_for_team".equals(tag)) {
                deleteAllClosedFileRequestsError = DeleteAllClosedFileRequestsError.DISABLED_FOR_TEAM;
            } else if ("other".equals(tag)) {
                deleteAllClosedFileRequestsError = DeleteAllClosedFileRequestsError.OTHER;
            } else if ("not_found".equals(tag)) {
                deleteAllClosedFileRequestsError = DeleteAllClosedFileRequestsError.NOT_FOUND;
            } else if ("not_a_folder".equals(tag)) {
                deleteAllClosedFileRequestsError = DeleteAllClosedFileRequestsError.NOT_A_FOLDER;
            } else if ("app_lacks_access".equals(tag)) {
                deleteAllClosedFileRequestsError = DeleteAllClosedFileRequestsError.APP_LACKS_ACCESS;
            } else if ("no_permission".equals(tag)) {
                deleteAllClosedFileRequestsError = DeleteAllClosedFileRequestsError.NO_PERMISSION;
            } else if ("email_unverified".equals(tag)) {
                deleteAllClosedFileRequestsError = DeleteAllClosedFileRequestsError.EMAIL_UNVERIFIED;
            } else if ("validation_error".equals(tag)) {
                deleteAllClosedFileRequestsError = DeleteAllClosedFileRequestsError.VALIDATION_ERROR;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deleteAllClosedFileRequestsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.filerequests.DeleteAllClosedFileRequestsError$1 */
    static /* synthetic */ class C41331 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$filerequests$DeleteAllClosedFileRequestsError */
        static final /* synthetic */ int[] f680x8bcd23fc;

        static {
            int[] iArr = new int[DeleteAllClosedFileRequestsError.values().length];
            f680x8bcd23fc = iArr;
            try {
                iArr[DeleteAllClosedFileRequestsError.DISABLED_FOR_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f680x8bcd23fc[DeleteAllClosedFileRequestsError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f680x8bcd23fc[DeleteAllClosedFileRequestsError.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f680x8bcd23fc[DeleteAllClosedFileRequestsError.NOT_A_FOLDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f680x8bcd23fc[DeleteAllClosedFileRequestsError.APP_LACKS_ACCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f680x8bcd23fc[DeleteAllClosedFileRequestsError.NO_PERMISSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f680x8bcd23fc[DeleteAllClosedFileRequestsError.EMAIL_UNVERIFIED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f680x8bcd23fc[DeleteAllClosedFileRequestsError.VALIDATION_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
