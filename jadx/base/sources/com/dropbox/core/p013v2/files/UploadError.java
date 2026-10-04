package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.InvalidPropertyGroupError;
import com.dropbox.core.p013v2.files.UploadWriteFailed;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class UploadError {
    private Tag _tag;
    private UploadWriteFailed pathValue;
    private InvalidPropertyGroupError propertiesErrorValue;
    public static final UploadError PAYLOAD_TOO_LARGE = new UploadError().withTag(Tag.PAYLOAD_TOO_LARGE);
    public static final UploadError CONTENT_HASH_MISMATCH = new UploadError().withTag(Tag.CONTENT_HASH_MISMATCH);
    public static final UploadError OTHER = new UploadError().withTag(Tag.OTHER);

    public enum Tag {
        PATH,
        PROPERTIES_ERROR,
        PAYLOAD_TOO_LARGE,
        CONTENT_HASH_MISMATCH,
        OTHER
    }

    private UploadError() {
    }

    private UploadError withTag(Tag tag) {
        UploadError uploadError = new UploadError();
        uploadError._tag = tag;
        return uploadError;
    }

    private UploadError withTagAndPath(Tag tag, UploadWriteFailed uploadWriteFailed) {
        UploadError uploadError = new UploadError();
        uploadError._tag = tag;
        uploadError.pathValue = uploadWriteFailed;
        return uploadError;
    }

    private UploadError withTagAndPropertiesError(Tag tag, InvalidPropertyGroupError invalidPropertyGroupError) {
        UploadError uploadError = new UploadError();
        uploadError._tag = tag;
        uploadError.propertiesErrorValue = invalidPropertyGroupError;
        return uploadError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static UploadError path(UploadWriteFailed uploadWriteFailed) {
        if (uploadWriteFailed == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadError().withTagAndPath(Tag.PATH, uploadWriteFailed);
    }

    public UploadWriteFailed getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isPropertiesError() {
        return this._tag == Tag.PROPERTIES_ERROR;
    }

    public static UploadError propertiesError(InvalidPropertyGroupError invalidPropertyGroupError) {
        if (invalidPropertyGroupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadError().withTagAndPropertiesError(Tag.PROPERTIES_ERROR, invalidPropertyGroupError);
    }

    public InvalidPropertyGroupError getPropertiesErrorValue() {
        if (this._tag != Tag.PROPERTIES_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.PROPERTIES_ERROR, but was Tag." + this._tag.name());
        }
        return this.propertiesErrorValue;
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
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue, this.propertiesErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UploadError)) {
            return false;
        }
        UploadError uploadError = (UploadError) obj;
        if (this._tag != uploadError._tag) {
            return false;
        }
        int i = C42121.$SwitchMap$com$dropbox$core$v2$files$UploadError$Tag[this._tag.ordinal()];
        if (i == 1) {
            UploadWriteFailed uploadWriteFailed = this.pathValue;
            UploadWriteFailed uploadWriteFailed2 = uploadError.pathValue;
            return uploadWriteFailed == uploadWriteFailed2 || uploadWriteFailed.equals(uploadWriteFailed2);
        }
        if (i != 2) {
            return i == 3 || i == 4 || i == 5;
        }
        InvalidPropertyGroupError invalidPropertyGroupError = this.propertiesErrorValue;
        InvalidPropertyGroupError invalidPropertyGroupError2 = uploadError.propertiesErrorValue;
        return invalidPropertyGroupError == invalidPropertyGroupError2 || invalidPropertyGroupError.equals(invalidPropertyGroupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.UploadError$1 */
    static /* synthetic */ class C42121 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$UploadError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$UploadError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$UploadError$Tag[Tag.PROPERTIES_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$UploadError$Tag[Tag.PAYLOAD_TOO_LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$UploadError$Tag[Tag.CONTENT_HASH_MISMATCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$UploadError$Tag[Tag.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<UploadError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UploadError uploadError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42121.$SwitchMap$com$dropbox$core$v2$files$UploadError$Tag[uploadError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                UploadWriteFailed.Serializer.INSTANCE.serialize(uploadError.pathValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("properties_error", jsonGenerator);
                jsonGenerator.writeFieldName("properties_error");
                InvalidPropertyGroupError.Serializer.INSTANCE.serialize(uploadError.propertiesErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
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
        public UploadError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UploadError uploadErrorPropertiesError;
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
            if (ClientCookie.PATH_ATTR.equals(tag)) {
                uploadErrorPropertiesError = UploadError.path(UploadWriteFailed.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("properties_error".equals(tag)) {
                expectField("properties_error", jsonParser);
                uploadErrorPropertiesError = UploadError.propertiesError(InvalidPropertyGroupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("payload_too_large".equals(tag)) {
                uploadErrorPropertiesError = UploadError.PAYLOAD_TOO_LARGE;
            } else if ("content_hash_mismatch".equals(tag)) {
                uploadErrorPropertiesError = UploadError.CONTENT_HASH_MISMATCH;
            } else {
                uploadErrorPropertiesError = UploadError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return uploadErrorPropertiesError;
        }
    }
}
