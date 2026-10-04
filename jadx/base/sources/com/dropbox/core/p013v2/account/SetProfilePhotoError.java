package com.dropbox.core.p013v2.account;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SetProfilePhotoError {
    FILE_TYPE_ERROR,
    FILE_SIZE_ERROR,
    DIMENSION_ERROR,
    THUMBNAIL_ERROR,
    TRANSIENT_ERROR,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.account.SetProfilePhotoError$1 */
    static /* synthetic */ class C41021 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$account$SetProfilePhotoError;

        static {
            int[] iArr = new int[SetProfilePhotoError.values().length];
            $SwitchMap$com$dropbox$core$v2$account$SetProfilePhotoError = iArr;
            try {
                iArr[SetProfilePhotoError.FILE_TYPE_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$account$SetProfilePhotoError[SetProfilePhotoError.FILE_SIZE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$account$SetProfilePhotoError[SetProfilePhotoError.DIMENSION_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$account$SetProfilePhotoError[SetProfilePhotoError.THUMBNAIL_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$account$SetProfilePhotoError[SetProfilePhotoError.TRANSIENT_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<SetProfilePhotoError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SetProfilePhotoError setProfilePhotoError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41021.$SwitchMap$com$dropbox$core$v2$account$SetProfilePhotoError[setProfilePhotoError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("file_type_error");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("file_size_error");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("dimension_error");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("thumbnail_error");
            } else if (i == 5) {
                jsonGenerator.writeString("transient_error");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SetProfilePhotoError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SetProfilePhotoError setProfilePhotoError;
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
            if ("file_type_error".equals(tag)) {
                setProfilePhotoError = SetProfilePhotoError.FILE_TYPE_ERROR;
            } else if ("file_size_error".equals(tag)) {
                setProfilePhotoError = SetProfilePhotoError.FILE_SIZE_ERROR;
            } else if ("dimension_error".equals(tag)) {
                setProfilePhotoError = SetProfilePhotoError.DIMENSION_ERROR;
            } else if ("thumbnail_error".equals(tag)) {
                setProfilePhotoError = SetProfilePhotoError.THUMBNAIL_ERROR;
            } else if ("transient_error".equals(tag)) {
                setProfilePhotoError = SetProfilePhotoError.TRANSIENT_ERROR;
            } else {
                setProfilePhotoError = SetProfilePhotoError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return setProfilePhotoError;
        }
    }
}
