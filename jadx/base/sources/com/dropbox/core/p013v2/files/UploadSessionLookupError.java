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
public final class UploadSessionLookupError {
    private Tag _tag;
    private UploadSessionOffsetError incorrectOffsetValue;
    public static final UploadSessionLookupError NOT_FOUND = new UploadSessionLookupError().withTag(Tag.NOT_FOUND);
    public static final UploadSessionLookupError CLOSED = new UploadSessionLookupError().withTag(Tag.CLOSED);
    public static final UploadSessionLookupError NOT_CLOSED = new UploadSessionLookupError().withTag(Tag.NOT_CLOSED);
    public static final UploadSessionLookupError TOO_LARGE = new UploadSessionLookupError().withTag(Tag.TOO_LARGE);
    public static final UploadSessionLookupError CONCURRENT_SESSION_INVALID_OFFSET = new UploadSessionLookupError().withTag(Tag.CONCURRENT_SESSION_INVALID_OFFSET);
    public static final UploadSessionLookupError CONCURRENT_SESSION_INVALID_DATA_SIZE = new UploadSessionLookupError().withTag(Tag.CONCURRENT_SESSION_INVALID_DATA_SIZE);
    public static final UploadSessionLookupError PAYLOAD_TOO_LARGE = new UploadSessionLookupError().withTag(Tag.PAYLOAD_TOO_LARGE);
    public static final UploadSessionLookupError OTHER = new UploadSessionLookupError().withTag(Tag.OTHER);

    public enum Tag {
        NOT_FOUND,
        INCORRECT_OFFSET,
        CLOSED,
        NOT_CLOSED,
        TOO_LARGE,
        CONCURRENT_SESSION_INVALID_OFFSET,
        CONCURRENT_SESSION_INVALID_DATA_SIZE,
        PAYLOAD_TOO_LARGE,
        OTHER
    }

    private UploadSessionLookupError() {
    }

    private UploadSessionLookupError withTag(Tag tag) {
        UploadSessionLookupError uploadSessionLookupError = new UploadSessionLookupError();
        uploadSessionLookupError._tag = tag;
        return uploadSessionLookupError;
    }

    private UploadSessionLookupError withTagAndIncorrectOffset(Tag tag, UploadSessionOffsetError uploadSessionOffsetError) {
        UploadSessionLookupError uploadSessionLookupError = new UploadSessionLookupError();
        uploadSessionLookupError._tag = tag;
        uploadSessionLookupError.incorrectOffsetValue = uploadSessionOffsetError;
        return uploadSessionLookupError;
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

    public static UploadSessionLookupError incorrectOffset(UploadSessionOffsetError uploadSessionOffsetError) {
        if (uploadSessionOffsetError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionLookupError().withTagAndIncorrectOffset(Tag.INCORRECT_OFFSET, uploadSessionOffsetError);
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

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.incorrectOffsetValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UploadSessionLookupError)) {
            return false;
        }
        UploadSessionLookupError uploadSessionLookupError = (UploadSessionLookupError) obj;
        if (this._tag != uploadSessionLookupError._tag) {
            return false;
        }
        switch (C42181.f714xa564cd8a[this._tag.ordinal()]) {
            case 2:
                UploadSessionOffsetError uploadSessionOffsetError = this.incorrectOffsetValue;
                UploadSessionOffsetError uploadSessionOffsetError2 = uploadSessionLookupError.incorrectOffsetValue;
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
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.UploadSessionLookupError$1 */
    static /* synthetic */ class C42181 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$UploadSessionLookupError$Tag */
        static final /* synthetic */ int[] f714xa564cd8a;

        static {
            int[] iArr = new int[Tag.values().length];
            f714xa564cd8a = iArr;
            try {
                iArr[Tag.NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f714xa564cd8a[Tag.INCORRECT_OFFSET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f714xa564cd8a[Tag.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f714xa564cd8a[Tag.NOT_CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f714xa564cd8a[Tag.TOO_LARGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f714xa564cd8a[Tag.CONCURRENT_SESSION_INVALID_OFFSET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f714xa564cd8a[Tag.CONCURRENT_SESSION_INVALID_DATA_SIZE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f714xa564cd8a[Tag.PAYLOAD_TOO_LARGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f714xa564cd8a[Tag.OTHER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<UploadSessionLookupError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UploadSessionLookupError uploadSessionLookupError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42181.f714xa564cd8a[uploadSessionLookupError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeString("not_found");
                    break;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("incorrect_offset", jsonGenerator);
                    UploadSessionOffsetError.Serializer.INSTANCE.serialize(uploadSessionLookupError.incorrectOffsetValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 3:
                    jsonGenerator.writeString("closed");
                    break;
                case 4:
                    jsonGenerator.writeString("not_closed");
                    break;
                case 5:
                    jsonGenerator.writeString("too_large");
                    break;
                case 6:
                    jsonGenerator.writeString("concurrent_session_invalid_offset");
                    break;
                case 7:
                    jsonGenerator.writeString("concurrent_session_invalid_data_size");
                    break;
                case 8:
                    jsonGenerator.writeString("payload_too_large");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UploadSessionLookupError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UploadSessionLookupError uploadSessionLookupErrorIncorrectOffset;
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
                uploadSessionLookupErrorIncorrectOffset = UploadSessionLookupError.NOT_FOUND;
            } else if ("incorrect_offset".equals(tag)) {
                uploadSessionLookupErrorIncorrectOffset = UploadSessionLookupError.incorrectOffset(UploadSessionOffsetError.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("closed".equals(tag)) {
                uploadSessionLookupErrorIncorrectOffset = UploadSessionLookupError.CLOSED;
            } else if ("not_closed".equals(tag)) {
                uploadSessionLookupErrorIncorrectOffset = UploadSessionLookupError.NOT_CLOSED;
            } else if ("too_large".equals(tag)) {
                uploadSessionLookupErrorIncorrectOffset = UploadSessionLookupError.TOO_LARGE;
            } else if ("concurrent_session_invalid_offset".equals(tag)) {
                uploadSessionLookupErrorIncorrectOffset = UploadSessionLookupError.CONCURRENT_SESSION_INVALID_OFFSET;
            } else if ("concurrent_session_invalid_data_size".equals(tag)) {
                uploadSessionLookupErrorIncorrectOffset = UploadSessionLookupError.CONCURRENT_SESSION_INVALID_DATA_SIZE;
            } else if ("payload_too_large".equals(tag)) {
                uploadSessionLookupErrorIncorrectOffset = UploadSessionLookupError.PAYLOAD_TOO_LARGE;
            } else {
                uploadSessionLookupErrorIncorrectOffset = UploadSessionLookupError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return uploadSessionLookupErrorIncorrectOffset;
        }
    }
}
