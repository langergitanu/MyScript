package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class ThumbnailError {
    private Tag _tag;
    private LookupError pathValue;
    public static final ThumbnailError UNSUPPORTED_EXTENSION = new ThumbnailError().withTag(Tag.UNSUPPORTED_EXTENSION);
    public static final ThumbnailError UNSUPPORTED_IMAGE = new ThumbnailError().withTag(Tag.UNSUPPORTED_IMAGE);
    public static final ThumbnailError CONVERSION_ERROR = new ThumbnailError().withTag(Tag.CONVERSION_ERROR);

    public enum Tag {
        PATH,
        UNSUPPORTED_EXTENSION,
        UNSUPPORTED_IMAGE,
        CONVERSION_ERROR
    }

    private ThumbnailError() {
    }

    private ThumbnailError withTag(Tag tag) {
        ThumbnailError thumbnailError = new ThumbnailError();
        thumbnailError._tag = tag;
        return thumbnailError;
    }

    private ThumbnailError withTagAndPath(Tag tag, LookupError lookupError) {
        ThumbnailError thumbnailError = new ThumbnailError();
        thumbnailError._tag = tag;
        thumbnailError.pathValue = lookupError;
        return thumbnailError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static ThumbnailError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ThumbnailError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isUnsupportedExtension() {
        return this._tag == Tag.UNSUPPORTED_EXTENSION;
    }

    public boolean isUnsupportedImage() {
        return this._tag == Tag.UNSUPPORTED_IMAGE;
    }

    public boolean isConversionError() {
        return this._tag == Tag.CONVERSION_ERROR;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ThumbnailError)) {
            return false;
        }
        ThumbnailError thumbnailError = (ThumbnailError) obj;
        if (this._tag != thumbnailError._tag) {
            return false;
        }
        int i = C42071.$SwitchMap$com$dropbox$core$v2$files$ThumbnailError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = thumbnailError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ThumbnailError$1 */
    static /* synthetic */ class C42071 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ThumbnailError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ThumbnailError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailError$Tag[Tag.UNSUPPORTED_EXTENSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailError$Tag[Tag.UNSUPPORTED_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailError$Tag[Tag.CONVERSION_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<ThumbnailError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ThumbnailError thumbnailError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42071.$SwitchMap$com$dropbox$core$v2$files$ThumbnailError$Tag[thumbnailError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(thumbnailError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("unsupported_extension");
            } else if (i == 3) {
                jsonGenerator.writeString("unsupported_image");
            } else {
                if (i == 4) {
                    jsonGenerator.writeString("conversion_error");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + thumbnailError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ThumbnailError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ThumbnailError thumbnailErrorPath;
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
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                thumbnailErrorPath = ThumbnailError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("unsupported_extension".equals(tag)) {
                thumbnailErrorPath = ThumbnailError.UNSUPPORTED_EXTENSION;
            } else if ("unsupported_image".equals(tag)) {
                thumbnailErrorPath = ThumbnailError.UNSUPPORTED_IMAGE;
            } else if ("conversion_error".equals(tag)) {
                thumbnailErrorPath = ThumbnailError.CONVERSION_ERROR;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return thumbnailErrorPath;
        }
    }
}
