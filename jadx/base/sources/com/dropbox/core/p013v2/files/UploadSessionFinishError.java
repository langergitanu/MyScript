package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.InvalidPropertyGroupError;
import com.dropbox.core.p013v2.files.UploadSessionLookupError;
import com.dropbox.core.p013v2.files.WriteError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class UploadSessionFinishError {
    private Tag _tag;
    private UploadSessionLookupError lookupFailedValue;
    private WriteError pathValue;
    private InvalidPropertyGroupError propertiesErrorValue;
    public static final UploadSessionFinishError TOO_MANY_SHARED_FOLDER_TARGETS = new UploadSessionFinishError().withTag(Tag.TOO_MANY_SHARED_FOLDER_TARGETS);
    public static final UploadSessionFinishError TOO_MANY_WRITE_OPERATIONS = new UploadSessionFinishError().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);
    public static final UploadSessionFinishError CONCURRENT_SESSION_DATA_NOT_ALLOWED = new UploadSessionFinishError().withTag(Tag.CONCURRENT_SESSION_DATA_NOT_ALLOWED);
    public static final UploadSessionFinishError CONCURRENT_SESSION_NOT_CLOSED = new UploadSessionFinishError().withTag(Tag.CONCURRENT_SESSION_NOT_CLOSED);
    public static final UploadSessionFinishError CONCURRENT_SESSION_MISSING_DATA = new UploadSessionFinishError().withTag(Tag.CONCURRENT_SESSION_MISSING_DATA);
    public static final UploadSessionFinishError PAYLOAD_TOO_LARGE = new UploadSessionFinishError().withTag(Tag.PAYLOAD_TOO_LARGE);
    public static final UploadSessionFinishError CONTENT_HASH_MISMATCH = new UploadSessionFinishError().withTag(Tag.CONTENT_HASH_MISMATCH);
    public static final UploadSessionFinishError OTHER = new UploadSessionFinishError().withTag(Tag.OTHER);

    public enum Tag {
        LOOKUP_FAILED,
        PATH,
        PROPERTIES_ERROR,
        TOO_MANY_SHARED_FOLDER_TARGETS,
        TOO_MANY_WRITE_OPERATIONS,
        CONCURRENT_SESSION_DATA_NOT_ALLOWED,
        CONCURRENT_SESSION_NOT_CLOSED,
        CONCURRENT_SESSION_MISSING_DATA,
        PAYLOAD_TOO_LARGE,
        CONTENT_HASH_MISMATCH,
        OTHER
    }

    private UploadSessionFinishError() {
    }

    private UploadSessionFinishError withTag(Tag tag) {
        UploadSessionFinishError uploadSessionFinishError = new UploadSessionFinishError();
        uploadSessionFinishError._tag = tag;
        return uploadSessionFinishError;
    }

    private UploadSessionFinishError withTagAndLookupFailed(Tag tag, UploadSessionLookupError uploadSessionLookupError) {
        UploadSessionFinishError uploadSessionFinishError = new UploadSessionFinishError();
        uploadSessionFinishError._tag = tag;
        uploadSessionFinishError.lookupFailedValue = uploadSessionLookupError;
        return uploadSessionFinishError;
    }

    private UploadSessionFinishError withTagAndPath(Tag tag, WriteError writeError) {
        UploadSessionFinishError uploadSessionFinishError = new UploadSessionFinishError();
        uploadSessionFinishError._tag = tag;
        uploadSessionFinishError.pathValue = writeError;
        return uploadSessionFinishError;
    }

    private UploadSessionFinishError withTagAndPropertiesError(Tag tag, InvalidPropertyGroupError invalidPropertyGroupError) {
        UploadSessionFinishError uploadSessionFinishError = new UploadSessionFinishError();
        uploadSessionFinishError._tag = tag;
        uploadSessionFinishError.propertiesErrorValue = invalidPropertyGroupError;
        return uploadSessionFinishError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isLookupFailed() {
        return this._tag == Tag.LOOKUP_FAILED;
    }

    public static UploadSessionFinishError lookupFailed(UploadSessionLookupError uploadSessionLookupError) {
        if (uploadSessionLookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishError().withTagAndLookupFailed(Tag.LOOKUP_FAILED, uploadSessionLookupError);
    }

    public UploadSessionLookupError getLookupFailedValue() {
        if (this._tag != Tag.LOOKUP_FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.LOOKUP_FAILED, but was Tag." + this._tag.name());
        }
        return this.lookupFailedValue;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static UploadSessionFinishError path(WriteError writeError) {
        if (writeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishError().withTagAndPath(Tag.PATH, writeError);
    }

    public WriteError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isPropertiesError() {
        return this._tag == Tag.PROPERTIES_ERROR;
    }

    public static UploadSessionFinishError propertiesError(InvalidPropertyGroupError invalidPropertyGroupError) {
        if (invalidPropertyGroupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishError().withTagAndPropertiesError(Tag.PROPERTIES_ERROR, invalidPropertyGroupError);
    }

    public InvalidPropertyGroupError getPropertiesErrorValue() {
        if (this._tag != Tag.PROPERTIES_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.PROPERTIES_ERROR, but was Tag." + this._tag.name());
        }
        return this.propertiesErrorValue;
    }

    public boolean isTooManySharedFolderTargets() {
        return this._tag == Tag.TOO_MANY_SHARED_FOLDER_TARGETS;
    }

    public boolean isTooManyWriteOperations() {
        return this._tag == Tag.TOO_MANY_WRITE_OPERATIONS;
    }

    public boolean isConcurrentSessionDataNotAllowed() {
        return this._tag == Tag.CONCURRENT_SESSION_DATA_NOT_ALLOWED;
    }

    public boolean isConcurrentSessionNotClosed() {
        return this._tag == Tag.CONCURRENT_SESSION_NOT_CLOSED;
    }

    public boolean isConcurrentSessionMissingData() {
        return this._tag == Tag.CONCURRENT_SESSION_MISSING_DATA;
    }

    public boolean isPayloadTooLarge() {
        return this._tag == Tag.PAYLOAD_TOO_LARGE;
    }

    public boolean isContentHashMismatch() {
        return this._tag == Tag.CONTENT_HASH_MISMATCH;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.lookupFailedValue, this.pathValue, this.propertiesErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UploadSessionFinishError)) {
            return false;
        }
        UploadSessionFinishError uploadSessionFinishError = (UploadSessionFinishError) obj;
        if (this._tag != uploadSessionFinishError._tag) {
            return false;
        }
        switch (C42171.f713x75125691[this._tag.ordinal()]) {
            case 1:
                UploadSessionLookupError uploadSessionLookupError = this.lookupFailedValue;
                UploadSessionLookupError uploadSessionLookupError2 = uploadSessionFinishError.lookupFailedValue;
                return uploadSessionLookupError == uploadSessionLookupError2 || uploadSessionLookupError.equals(uploadSessionLookupError2);
            case 2:
                WriteError writeError = this.pathValue;
                WriteError writeError2 = uploadSessionFinishError.pathValue;
                return writeError == writeError2 || writeError.equals(writeError2);
            case 3:
                InvalidPropertyGroupError invalidPropertyGroupError = this.propertiesErrorValue;
                InvalidPropertyGroupError invalidPropertyGroupError2 = uploadSessionFinishError.propertiesErrorValue;
                return invalidPropertyGroupError == invalidPropertyGroupError2 || invalidPropertyGroupError.equals(invalidPropertyGroupError2);
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.UploadSessionFinishError$1 */
    static /* synthetic */ class C42171 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$UploadSessionFinishError$Tag */
        static final /* synthetic */ int[] f713x75125691;

        static {
            int[] iArr = new int[Tag.values().length];
            f713x75125691 = iArr;
            try {
                iArr[Tag.LOOKUP_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f713x75125691[Tag.PATH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f713x75125691[Tag.PROPERTIES_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f713x75125691[Tag.TOO_MANY_SHARED_FOLDER_TARGETS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f713x75125691[Tag.TOO_MANY_WRITE_OPERATIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f713x75125691[Tag.CONCURRENT_SESSION_DATA_NOT_ALLOWED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f713x75125691[Tag.CONCURRENT_SESSION_NOT_CLOSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f713x75125691[Tag.CONCURRENT_SESSION_MISSING_DATA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f713x75125691[Tag.PAYLOAD_TOO_LARGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f713x75125691[Tag.CONTENT_HASH_MISMATCH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f713x75125691[Tag.OTHER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<UploadSessionFinishError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UploadSessionFinishError uploadSessionFinishError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42171.f713x75125691[uploadSessionFinishError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("lookup_failed", jsonGenerator);
                    jsonGenerator.writeFieldName("lookup_failed");
                    UploadSessionLookupError.Serializer.INSTANCE.serialize(uploadSessionFinishError.lookupFailedValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                    jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                    WriteError.Serializer.INSTANCE.serialize(uploadSessionFinishError.pathValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag("properties_error", jsonGenerator);
                    jsonGenerator.writeFieldName("properties_error");
                    InvalidPropertyGroupError.Serializer.INSTANCE.serialize(uploadSessionFinishError.propertiesErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 4:
                    jsonGenerator.writeString("too_many_shared_folder_targets");
                    break;
                case 5:
                    jsonGenerator.writeString("too_many_write_operations");
                    break;
                case 6:
                    jsonGenerator.writeString("concurrent_session_data_not_allowed");
                    break;
                case 7:
                    jsonGenerator.writeString("concurrent_session_not_closed");
                    break;
                case 8:
                    jsonGenerator.writeString("concurrent_session_missing_data");
                    break;
                case 9:
                    jsonGenerator.writeString("payload_too_large");
                    break;
                case 10:
                    jsonGenerator.writeString("content_hash_mismatch");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UploadSessionFinishError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UploadSessionFinishError uploadSessionFinishErrorPropertiesError;
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
            if ("lookup_failed".equals(tag)) {
                expectField("lookup_failed", jsonParser);
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.lookupFailed(UploadSessionLookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.path(WriteError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("properties_error".equals(tag)) {
                expectField("properties_error", jsonParser);
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.propertiesError(InvalidPropertyGroupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("too_many_shared_folder_targets".equals(tag)) {
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.TOO_MANY_SHARED_FOLDER_TARGETS;
            } else if ("too_many_write_operations".equals(tag)) {
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.TOO_MANY_WRITE_OPERATIONS;
            } else if ("concurrent_session_data_not_allowed".equals(tag)) {
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.CONCURRENT_SESSION_DATA_NOT_ALLOWED;
            } else if ("concurrent_session_not_closed".equals(tag)) {
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.CONCURRENT_SESSION_NOT_CLOSED;
            } else if ("concurrent_session_missing_data".equals(tag)) {
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.CONCURRENT_SESSION_MISSING_DATA;
            } else if ("payload_too_large".equals(tag)) {
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.PAYLOAD_TOO_LARGE;
            } else if ("content_hash_mismatch".equals(tag)) {
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.CONTENT_HASH_MISMATCH;
            } else {
                uploadSessionFinishErrorPropertiesError = UploadSessionFinishError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return uploadSessionFinishErrorPropertiesError;
        }
    }
}
