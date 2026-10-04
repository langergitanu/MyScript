package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PaperCreateError {
    INSUFFICIENT_PERMISSIONS,
    CONTENT_MALFORMED,
    DOC_LENGTH_EXCEEDED,
    IMAGE_SIZE_EXCEEDED,
    OTHER,
    INVALID_PATH,
    EMAIL_UNVERIFIED,
    INVALID_FILE_EXTENSION,
    PAPER_DISABLED;

    static class Serializer extends UnionSerializer<PaperCreateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperCreateError paperCreateError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41791.$SwitchMap$com$dropbox$core$v2$files$PaperCreateError[paperCreateError.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("insufficient_permissions");
                    return;
                case 2:
                    jsonGenerator.writeString("content_malformed");
                    return;
                case 3:
                    jsonGenerator.writeString("doc_length_exceeded");
                    return;
                case 4:
                    jsonGenerator.writeString("image_size_exceeded");
                    return;
                case 5:
                    jsonGenerator.writeString("other");
                    return;
                case 6:
                    jsonGenerator.writeString("invalid_path");
                    return;
                case 7:
                    jsonGenerator.writeString("email_unverified");
                    return;
                case 8:
                    jsonGenerator.writeString("invalid_file_extension");
                    return;
                case 9:
                    jsonGenerator.writeString("paper_disabled");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + paperCreateError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperCreateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperCreateError paperCreateError;
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
            if ("insufficient_permissions".equals(tag)) {
                paperCreateError = PaperCreateError.INSUFFICIENT_PERMISSIONS;
            } else if ("content_malformed".equals(tag)) {
                paperCreateError = PaperCreateError.CONTENT_MALFORMED;
            } else if ("doc_length_exceeded".equals(tag)) {
                paperCreateError = PaperCreateError.DOC_LENGTH_EXCEEDED;
            } else if ("image_size_exceeded".equals(tag)) {
                paperCreateError = PaperCreateError.IMAGE_SIZE_EXCEEDED;
            } else if ("other".equals(tag)) {
                paperCreateError = PaperCreateError.OTHER;
            } else if ("invalid_path".equals(tag)) {
                paperCreateError = PaperCreateError.INVALID_PATH;
            } else if ("email_unverified".equals(tag)) {
                paperCreateError = PaperCreateError.EMAIL_UNVERIFIED;
            } else if ("invalid_file_extension".equals(tag)) {
                paperCreateError = PaperCreateError.INVALID_FILE_EXTENSION;
            } else if ("paper_disabled".equals(tag)) {
                paperCreateError = PaperCreateError.PAPER_DISABLED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperCreateError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.PaperCreateError$1 */
    static /* synthetic */ class C41791 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$PaperCreateError;

        static {
            int[] iArr = new int[PaperCreateError.values().length];
            $SwitchMap$com$dropbox$core$v2$files$PaperCreateError = iArr;
            try {
                iArr[PaperCreateError.INSUFFICIENT_PERMISSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperCreateError[PaperCreateError.CONTENT_MALFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperCreateError[PaperCreateError.DOC_LENGTH_EXCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperCreateError[PaperCreateError.IMAGE_SIZE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperCreateError[PaperCreateError.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperCreateError[PaperCreateError.INVALID_PATH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperCreateError[PaperCreateError.EMAIL_UNVERIFIED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperCreateError[PaperCreateError.INVALID_FILE_EXTENSION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperCreateError[PaperCreateError.PAPER_DISABLED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
