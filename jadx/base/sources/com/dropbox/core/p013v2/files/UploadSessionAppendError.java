package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.UploadSessionOffsetError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class UploadSessionAppendError {
    private Tag _tag;
    private UploadSessionOffsetError incorrectOffsetValue;
    public static final UploadSessionAppendError NOT_FOUND = new UploadSessionAppendError().withTag(Tag.NOT_FOUND);
    public static final UploadSessionAppendError CLOSED = new UploadSessionAppendError().withTag(Tag.CLOSED);
    public static final UploadSessionAppendError NOT_CLOSED = new UploadSessionAppendError().withTag(Tag.NOT_CLOSED);
    public static final UploadSessionAppendError TOO_LARGE = new UploadSessionAppendError().withTag(Tag.TOO_LARGE);
    public static final UploadSessionAppendError CONCURRENT_SESSION_INVALID_OFFSET = new UploadSessionAppendError().withTag(Tag.CONCURRENT_SESSION_INVALID_OFFSET);
    public static final UploadSessionAppendError CONCURRENT_SESSION_INVALID_DATA_SIZE = new UploadSessionAppendError().withTag(Tag.CONCURRENT_SESSION_INVALID_DATA_SIZE);
    public static final UploadSessionAppendError PAYLOAD_TOO_LARGE = new UploadSessionAppendError().withTag(Tag.PAYLOAD_TOO_LARGE);
    public static final UploadSessionAppendError OTHER = new UploadSessionAppendError().withTag(Tag.OTHER);
    public static final UploadSessionAppendError CONTENT_HASH_MISMATCH = new UploadSessionAppendError().withTag(Tag.CONTENT_HASH_MISMATCH);

    public enum Tag {
        NOT_FOUND,
        INCORRECT_OFFSET,
        CLOSED,
        NOT_CLOSED,
        TOO_LARGE,
        CONCURRENT_SESSION_INVALID_OFFSET,
        CONCURRENT_SESSION_INVALID_DATA_SIZE,
        PAYLOAD_TOO_LARGE,
        OTHER,
        CONTENT_HASH_MISMATCH
    }

    private UploadSessionAppendError() {
    }

    private UploadSessionAppendError withTag(Tag tag) {
        UploadSessionAppendError uploadSessionAppendError = new UploadSessionAppendError();
        uploadSessionAppendError._tag = tag;
        return uploadSessionAppendError;
    }

    private UploadSessionAppendError withTagAndIncorrectOffset(Tag tag, UploadSessionOffsetError uploadSessionOffsetError) {
        UploadSessionAppendError uploadSessionAppendError = new UploadSessionAppendError();
        uploadSessionAppendError._tag = tag;
        uploadSessionAppendError.incorrectOffsetValue = uploadSessionOffsetError;
        return uploadSessionAppendError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isNotFound() {
        return this._tag == Tag.NOT_FOUND;
    }

    public boolean isIncorrectOffset() {
        return this._tag == Tag.INCORRECT_OFFSET;
    }

    public static UploadSessionAppendError incorrectOffset(UploadSessionOffsetError uploadSessionOffsetError) {
        if (uploadSessionOffsetError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionAppendError().withTagAndIncorrectOffset(Tag.INCORRECT_OFFSET, uploadSessionOffsetError);
    }

    public UploadSessionOffsetError getIncorrectOffsetValue() {
        if (this._tag != Tag.INCORRECT_OFFSET) {
            throw new IllegalStateException("Invalid tag: required Tag.INCORRECT_OFFSET, but was Tag." + this._tag.name());
        }
        return this.incorrectOffsetValue;
    }

    public boolean isClosed() {
        return this._tag == Tag.CLOSED;
    }

    public boolean isNotClosed() {
        return this._tag == Tag.NOT_CLOSED;
    }

    public boolean isTooLarge() {
        return this._tag == Tag.TOO_LARGE;
    }

    public boolean isConcurrentSessionInvalidOffset() {
        return this._tag == Tag.CONCURRENT_SESSION_INVALID_OFFSET;
    }

    public boolean isConcurrentSessionInvalidDataSize() {
        return this._tag == Tag.CONCURRENT_SESSION_INVALID_DATA_SIZE;
    }

    public boolean isPayloadTooLarge() {
        return this._tag == Tag.PAYLOAD_TOO_LARGE;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public boolean isContentHashMismatch() {
        return this._tag == Tag.CONTENT_HASH_MISMATCH;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.incorrectOffsetValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UploadSessionAppendError)) {
            return false;
        }
        UploadSessionAppendError uploadSessionAppendError = (UploadSessionAppendError) obj;
        if (this._tag != uploadSessionAppendError._tag) {
            return false;
        }
        switch (C42131.f709xe57bfbea[this._tag.ordinal()]) {
            case 2:
                UploadSessionOffsetError uploadSessionOffsetError = this.incorrectOffsetValue;
                UploadSessionOffsetError uploadSessionOffsetError2 = uploadSessionAppendError.incorrectOffsetValue;
                if (uploadSessionOffsetError != uploadSessionOffsetError2 && !uploadSessionOffsetError.equals(uploadSessionOffsetError2)) {
                    return false;
                }
            case 1:
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.UploadSessionAppendError$1 */
    static /* synthetic */ class C42131 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$UploadSessionAppendError$Tag */
        static final /* synthetic */ int[] f709xe57bfbea;

        static {
            int[] iArr = new int[Tag.values().length];
            f709xe57bfbea = iArr;
            try {
                iArr[Tag.NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f709xe57bfbea[Tag.INCORRECT_OFFSET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f709xe57bfbea[Tag.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f709xe57bfbea[Tag.NOT_CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f709xe57bfbea[Tag.TOO_LARGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f709xe57bfbea[Tag.CONCURRENT_SESSION_INVALID_OFFSET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f709xe57bfbea[Tag.CONCURRENT_SESSION_INVALID_DATA_SIZE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f709xe57bfbea[Tag.PAYLOAD_TOO_LARGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f709xe57bfbea[Tag.OTHER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f709xe57bfbea[Tag.CONTENT_HASH_MISMATCH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<UploadSessionAppendError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UploadSessionAppendError uploadSessionAppendError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42131.f709xe57bfbea[uploadSessionAppendError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeString("not_found");
                    return;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("incorrect_offset", jsonGenerator);
                    UploadSessionOffsetError.Serializer.INSTANCE.serialize(uploadSessionAppendError.incorrectOffsetValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    return;
                case 3:
                    jsonGenerator.writeString("closed");
                    return;
                case 4:
                    jsonGenerator.writeString("not_closed");
                    return;
                case 5:
                    jsonGenerator.writeString("too_large");
                    return;
                case 6:
                    jsonGenerator.writeString("concurrent_session_invalid_offset");
                    return;
                case 7:
                    jsonGenerator.writeString("concurrent_session_invalid_data_size");
                    return;
                case 8:
                    jsonGenerator.writeString("payload_too_large");
                    return;
                case 9:
                    jsonGenerator.writeString("other");
                    return;
                case 10:
                    jsonGenerator.writeString("content_hash_mismatch");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + uploadSessionAppendError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UploadSessionAppendError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UploadSessionAppendError uploadSessionAppendErrorIncorrectOffset;
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
            if ("not_found".equals(tag)) {
                uploadSessionAppendErrorIncorrectOffset = UploadSessionAppendError.NOT_FOUND;
            } else if ("incorrect_offset".equals(tag)) {
                uploadSessionAppendErrorIncorrectOffset = UploadSessionAppendError.incorrectOffset(UploadSessionOffsetError.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("closed".equals(tag)) {
                uploadSessionAppendErrorIncorrectOffset = UploadSessionAppendError.CLOSED;
            } else if ("not_closed".equals(tag)) {
                uploadSessionAppendErrorIncorrectOffset = UploadSessionAppendError.NOT_CLOSED;
            } else if ("too_large".equals(tag)) {
                uploadSessionAppendErrorIncorrectOffset = UploadSessionAppendError.TOO_LARGE;
            } else if ("concurrent_session_invalid_offset".equals(tag)) {
                uploadSessionAppendErrorIncorrectOffset = UploadSessionAppendError.CONCURRENT_SESSION_INVALID_OFFSET;
            } else if ("concurrent_session_invalid_data_size".equals(tag)) {
                uploadSessionAppendErrorIncorrectOffset = UploadSessionAppendError.CONCURRENT_SESSION_INVALID_DATA_SIZE;
            } else if ("payload_too_large".equals(tag)) {
                uploadSessionAppendErrorIncorrectOffset = UploadSessionAppendError.PAYLOAD_TOO_LARGE;
            } else if ("other".equals(tag)) {
                uploadSessionAppendErrorIncorrectOffset = UploadSessionAppendError.OTHER;
            } else if ("content_hash_mismatch".equals(tag)) {
                uploadSessionAppendErrorIncorrectOffset = UploadSessionAppendError.CONTENT_HASH_MISMATCH;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return uploadSessionAppendErrorIncorrectOffset;
        }
    }
}
