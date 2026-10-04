package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum DeleteFileRequestError {
    DISABLED_FOR_TEAM,
    OTHER,
    NOT_FOUND,
    NOT_A_FOLDER,
    APP_LACKS_ACCESS,
    NO_PERMISSION,
    EMAIL_UNVERIFIED,
    VALIDATION_ERROR,
    FILE_REQUEST_OPEN;

    static class Serializer extends UnionSerializer<DeleteFileRequestError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeleteFileRequestError deleteFileRequestError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41341.f681x666bdbf6[deleteFileRequestError.ordinal()]) {
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
                case 9:
                    jsonGenerator.writeString("file_request_open");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + deleteFileRequestError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeleteFileRequestError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeleteFileRequestError deleteFileRequestError;
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
                deleteFileRequestError = DeleteFileRequestError.DISABLED_FOR_TEAM;
            } else if ("other".equals(tag)) {
                deleteFileRequestError = DeleteFileRequestError.OTHER;
            } else if ("not_found".equals(tag)) {
                deleteFileRequestError = DeleteFileRequestError.NOT_FOUND;
            } else if ("not_a_folder".equals(tag)) {
                deleteFileRequestError = DeleteFileRequestError.NOT_A_FOLDER;
            } else if ("app_lacks_access".equals(tag)) {
                deleteFileRequestError = DeleteFileRequestError.APP_LACKS_ACCESS;
            } else if ("no_permission".equals(tag)) {
                deleteFileRequestError = DeleteFileRequestError.NO_PERMISSION;
            } else if ("email_unverified".equals(tag)) {
                deleteFileRequestError = DeleteFileRequestError.EMAIL_UNVERIFIED;
            } else if ("validation_error".equals(tag)) {
                deleteFileRequestError = DeleteFileRequestError.VALIDATION_ERROR;
            } else if ("file_request_open".equals(tag)) {
                deleteFileRequestError = DeleteFileRequestError.FILE_REQUEST_OPEN;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deleteFileRequestError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.filerequests.DeleteFileRequestError$1 */
    static /* synthetic */ class C41341 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$filerequests$DeleteFileRequestError */
        static final /* synthetic */ int[] f681x666bdbf6;

        static {
            int[] iArr = new int[DeleteFileRequestError.values().length];
            f681x666bdbf6 = iArr;
            try {
                iArr[DeleteFileRequestError.DISABLED_FOR_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f681x666bdbf6[DeleteFileRequestError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f681x666bdbf6[DeleteFileRequestError.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f681x666bdbf6[DeleteFileRequestError.NOT_A_FOLDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f681x666bdbf6[DeleteFileRequestError.APP_LACKS_ACCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f681x666bdbf6[DeleteFileRequestError.NO_PERMISSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f681x666bdbf6[DeleteFileRequestError.EMAIL_UNVERIFIED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f681x666bdbf6[DeleteFileRequestError.VALIDATION_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f681x666bdbf6[DeleteFileRequestError.FILE_REQUEST_OPEN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
