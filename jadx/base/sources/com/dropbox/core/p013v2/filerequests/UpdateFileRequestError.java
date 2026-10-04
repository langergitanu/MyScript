package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum UpdateFileRequestError {
    DISABLED_FOR_TEAM,
    OTHER,
    NOT_FOUND,
    NOT_A_FOLDER,
    APP_LACKS_ACCESS,
    NO_PERMISSION,
    EMAIL_UNVERIFIED,
    VALIDATION_ERROR;

    static class Serializer extends UnionSerializer<UpdateFileRequestError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UpdateFileRequestError updateFileRequestError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41401.f690x6c279314[updateFileRequestError.ordinal()]) {
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
                    throw new IllegalArgumentException("Unrecognized tag: " + updateFileRequestError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UpdateFileRequestError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UpdateFileRequestError updateFileRequestError;
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
                updateFileRequestError = UpdateFileRequestError.DISABLED_FOR_TEAM;
            } else if ("other".equals(tag)) {
                updateFileRequestError = UpdateFileRequestError.OTHER;
            } else if ("not_found".equals(tag)) {
                updateFileRequestError = UpdateFileRequestError.NOT_FOUND;
            } else if ("not_a_folder".equals(tag)) {
                updateFileRequestError = UpdateFileRequestError.NOT_A_FOLDER;
            } else if ("app_lacks_access".equals(tag)) {
                updateFileRequestError = UpdateFileRequestError.APP_LACKS_ACCESS;
            } else if ("no_permission".equals(tag)) {
                updateFileRequestError = UpdateFileRequestError.NO_PERMISSION;
            } else if ("email_unverified".equals(tag)) {
                updateFileRequestError = UpdateFileRequestError.EMAIL_UNVERIFIED;
            } else if ("validation_error".equals(tag)) {
                updateFileRequestError = UpdateFileRequestError.VALIDATION_ERROR;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return updateFileRequestError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.filerequests.UpdateFileRequestError$1 */
    static /* synthetic */ class C41401 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$filerequests$UpdateFileRequestError */
        static final /* synthetic */ int[] f690x6c279314;

        static {
            int[] iArr = new int[UpdateFileRequestError.values().length];
            f690x6c279314 = iArr;
            try {
                iArr[UpdateFileRequestError.DISABLED_FOR_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f690x6c279314[UpdateFileRequestError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f690x6c279314[UpdateFileRequestError.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f690x6c279314[UpdateFileRequestError.NOT_A_FOLDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f690x6c279314[UpdateFileRequestError.APP_LACKS_ACCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f690x6c279314[UpdateFileRequestError.NO_PERMISSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f690x6c279314[UpdateFileRequestError.EMAIL_UNVERIFIED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f690x6c279314[UpdateFileRequestError.VALIDATION_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
