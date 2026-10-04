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
public final class ThumbnailV2Error {
    private Tag _tag;
    private LookupError pathValue;
    public static final ThumbnailV2Error UNSUPPORTED_EXTENSION = new ThumbnailV2Error().withTag(Tag.UNSUPPORTED_EXTENSION);
    public static final ThumbnailV2Error UNSUPPORTED_IMAGE = new ThumbnailV2Error().withTag(Tag.UNSUPPORTED_IMAGE);
    public static final ThumbnailV2Error CONVERSION_ERROR = new ThumbnailV2Error().withTag(Tag.CONVERSION_ERROR);
    public static final ThumbnailV2Error ACCESS_DENIED = new ThumbnailV2Error().withTag(Tag.ACCESS_DENIED);
    public static final ThumbnailV2Error NOT_FOUND = new ThumbnailV2Error().withTag(Tag.NOT_FOUND);
    public static final ThumbnailV2Error OTHER = new ThumbnailV2Error().withTag(Tag.OTHER);

    public enum Tag {
        PATH,
        UNSUPPORTED_EXTENSION,
        UNSUPPORTED_IMAGE,
        CONVERSION_ERROR,
        ACCESS_DENIED,
        NOT_FOUND,
        OTHER
    }

    private ThumbnailV2Error() {
    }

    private ThumbnailV2Error withTag(Tag tag) {
        ThumbnailV2Error thumbnailV2Error = new ThumbnailV2Error();
        thumbnailV2Error._tag = tag;
        return thumbnailV2Error;
    }

    private ThumbnailV2Error withTagAndPath(Tag tag, LookupError lookupError) {
        ThumbnailV2Error thumbnailV2Error = new ThumbnailV2Error();
        thumbnailV2Error._tag = tag;
        thumbnailV2Error.pathValue = lookupError;
        return thumbnailV2Error;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static ThumbnailV2Error path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ThumbnailV2Error().withTagAndPath(Tag.PATH, lookupError);
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

    public boolean isAccessDenied() {
        return this._tag == Tag.ACCESS_DENIED;
    }

    public boolean isNotFound() {
        return this._tag == Tag.NOT_FOUND;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ThumbnailV2Error)) {
            return false;
        }
        ThumbnailV2Error thumbnailV2Error = (ThumbnailV2Error) obj;
        if (this._tag != thumbnailV2Error._tag) {
            return false;
        }
        switch (C42111.$SwitchMap$com$dropbox$core$v2$files$ThumbnailV2Error$Tag[this._tag.ordinal()]) {
            case 1:
                LookupError lookupError = this.pathValue;
                LookupError lookupError2 = thumbnailV2Error.pathValue;
                return lookupError == lookupError2 || lookupError.equals(lookupError2);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ThumbnailV2Error$1 */
    static /* synthetic */ class C42111 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ThumbnailV2Error$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ThumbnailV2Error$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailV2Error$Tag[Tag.UNSUPPORTED_EXTENSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailV2Error$Tag[Tag.UNSUPPORTED_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailV2Error$Tag[Tag.CONVERSION_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailV2Error$Tag[Tag.ACCESS_DENIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailV2Error$Tag[Tag.NOT_FOUND.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ThumbnailV2Error$Tag[Tag.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<ThumbnailV2Error> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ThumbnailV2Error thumbnailV2Error, JsonGenerator jsonGenerator) throws IOException {
            switch (C42111.$SwitchMap$com$dropbox$core$v2$files$ThumbnailV2Error$Tag[thumbnailV2Error.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                    jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                    LookupError.Serializer.INSTANCE.serialize(thumbnailV2Error.pathValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeString("unsupported_extension");
                    break;
                case 3:
                    jsonGenerator.writeString("unsupported_image");
                    break;
                case 4:
                    jsonGenerator.writeString("conversion_error");
                    break;
                case 5:
                    jsonGenerator.writeString("access_denied");
                    break;
                case 6:
                    jsonGenerator.writeString("not_found");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ThumbnailV2Error deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ThumbnailV2Error thumbnailV2ErrorPath;
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
                thumbnailV2ErrorPath = ThumbnailV2Error.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("unsupported_extension".equals(tag)) {
                thumbnailV2ErrorPath = ThumbnailV2Error.UNSUPPORTED_EXTENSION;
            } else if ("unsupported_image".equals(tag)) {
                thumbnailV2ErrorPath = ThumbnailV2Error.UNSUPPORTED_IMAGE;
            } else if ("conversion_error".equals(tag)) {
                thumbnailV2ErrorPath = ThumbnailV2Error.CONVERSION_ERROR;
            } else if ("access_denied".equals(tag)) {
                thumbnailV2ErrorPath = ThumbnailV2Error.ACCESS_DENIED;
            } else if ("not_found".equals(tag)) {
                thumbnailV2ErrorPath = ThumbnailV2Error.NOT_FOUND;
            } else {
                thumbnailV2ErrorPath = ThumbnailV2Error.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return thumbnailV2ErrorPath;
        }
    }
}
