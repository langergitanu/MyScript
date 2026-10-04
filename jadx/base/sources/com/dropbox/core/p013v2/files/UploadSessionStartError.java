package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum UploadSessionStartError {
    CONCURRENT_SESSION_DATA_NOT_ALLOWED,
    CONCURRENT_SESSION_CLOSE_NOT_ALLOWED,
    PAYLOAD_TOO_LARGE,
    CONTENT_HASH_MISMATCH,
    OTHER;

    static class Serializer extends UnionSerializer<UploadSessionStartError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UploadSessionStartError uploadSessionStartError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42191.$SwitchMap$com$dropbox$core$v2$files$UploadSessionStartError[uploadSessionStartError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("concurrent_session_data_not_allowed");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("concurrent_session_close_not_allowed");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("payload_too_large");
            } else if (i == 4) {
                jsonGenerator.writeString("content_hash_mismatch");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UploadSessionStartError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UploadSessionStartError uploadSessionStartError;
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
            if ("concurrent_session_data_not_allowed".equals(tag)) {
                uploadSessionStartError = UploadSessionStartError.CONCURRENT_SESSION_DATA_NOT_ALLOWED;
            } else if ("concurrent_session_close_not_allowed".equals(tag)) {
                uploadSessionStartError = UploadSessionStartError.CONCURRENT_SESSION_CLOSE_NOT_ALLOWED;
            } else if ("payload_too_large".equals(tag)) {
                uploadSessionStartError = UploadSessionStartError.PAYLOAD_TOO_LARGE;
            } else if ("content_hash_mismatch".equals(tag)) {
                uploadSessionStartError = UploadSessionStartError.CONTENT_HASH_MISMATCH;
            } else {
                uploadSessionStartError = UploadSessionStartError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return uploadSessionStartError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.UploadSessionStartError$1 */
    static /* synthetic */ class C42191 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$UploadSessionStartError;

        static {
            int[] iArr = new int[UploadSessionStartError.values().length];
            $SwitchMap$com$dropbox$core$v2$files$UploadSessionStartError = iArr;
            try {
                iArr[UploadSessionStartError.CONCURRENT_SESSION_DATA_NOT_ALLOWED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$UploadSessionStartError[UploadSessionStartError.CONCURRENT_SESSION_CLOSE_NOT_ALLOWED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$UploadSessionStartError[UploadSessionStartError.PAYLOAD_TOO_LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$UploadSessionStartError[UploadSessionStartError.CONTENT_HASH_MISMATCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
