package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum CreateFileRequestError {
    DISABLED_FOR_TEAM,
    OTHER,
    NOT_FOUND,
    NOT_A_FOLDER,
    APP_LACKS_ACCESS,
    NO_PERMISSION,
    EMAIL_UNVERIFIED,
    VALIDATION_ERROR,
    INVALID_LOCATION,
    RATE_LIMIT;

    static class Serializer extends UnionSerializer<CreateFileRequestError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CreateFileRequestError createFileRequestError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41321.f679xf7943547[createFileRequestError.ordinal()]) {
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
                    jsonGenerator.writeString("invalid_location");
                    return;
                case 10:
                    jsonGenerator.writeString("rate_limit");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + createFileRequestError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CreateFileRequestError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CreateFileRequestError createFileRequestError;
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
                createFileRequestError = CreateFileRequestError.DISABLED_FOR_TEAM;
            } else if ("other".equals(tag)) {
                createFileRequestError = CreateFileRequestError.OTHER;
            } else if ("not_found".equals(tag)) {
                createFileRequestError = CreateFileRequestError.NOT_FOUND;
            } else if ("not_a_folder".equals(tag)) {
                createFileRequestError = CreateFileRequestError.NOT_A_FOLDER;
            } else if ("app_lacks_access".equals(tag)) {
                createFileRequestError = CreateFileRequestError.APP_LACKS_ACCESS;
            } else if ("no_permission".equals(tag)) {
                createFileRequestError = CreateFileRequestError.NO_PERMISSION;
            } else if ("email_unverified".equals(tag)) {
                createFileRequestError = CreateFileRequestError.EMAIL_UNVERIFIED;
            } else if ("validation_error".equals(tag)) {
                createFileRequestError = CreateFileRequestError.VALIDATION_ERROR;
            } else if ("invalid_location".equals(tag)) {
                createFileRequestError = CreateFileRequestError.INVALID_LOCATION;
            } else if ("rate_limit".equals(tag)) {
                createFileRequestError = CreateFileRequestError.RATE_LIMIT;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return createFileRequestError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.filerequests.CreateFileRequestError$1 */
    static /* synthetic */ class C41321 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$filerequests$CreateFileRequestError */
        static final /* synthetic */ int[] f679xf7943547;

        static {
            int[] iArr = new int[CreateFileRequestError.values().length];
            f679xf7943547 = iArr;
            try {
                iArr[CreateFileRequestError.DISABLED_FOR_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f679xf7943547[CreateFileRequestError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f679xf7943547[CreateFileRequestError.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f679xf7943547[CreateFileRequestError.NOT_A_FOLDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f679xf7943547[CreateFileRequestError.APP_LACKS_ACCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f679xf7943547[CreateFileRequestError.NO_PERMISSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f679xf7943547[CreateFileRequestError.EMAIL_UNVERIFIED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f679xf7943547[CreateFileRequestError.VALIDATION_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f679xf7943547[CreateFileRequestError.INVALID_LOCATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f679xf7943547[CreateFileRequestError.RATE_LIMIT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }
}
