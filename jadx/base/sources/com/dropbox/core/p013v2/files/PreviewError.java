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
public final class PreviewError {
    private Tag _tag;
    private LookupError pathValue;
    public static final PreviewError IN_PROGRESS = new PreviewError().withTag(Tag.IN_PROGRESS);
    public static final PreviewError UNSUPPORTED_EXTENSION = new PreviewError().withTag(Tag.UNSUPPORTED_EXTENSION);
    public static final PreviewError UNSUPPORTED_CONTENT = new PreviewError().withTag(Tag.UNSUPPORTED_CONTENT);

    public enum Tag {
        PATH,
        IN_PROGRESS,
        UNSUPPORTED_EXTENSION,
        UNSUPPORTED_CONTENT
    }

    private PreviewError() {
    }

    private PreviewError withTag(Tag tag) {
        PreviewError previewError = new PreviewError();
        previewError._tag = tag;
        return previewError;
    }

    private PreviewError withTagAndPath(Tag tag, LookupError lookupError) {
        PreviewError previewError = new PreviewError();
        previewError._tag = tag;
        previewError.pathValue = lookupError;
        return previewError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static PreviewError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PreviewError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isInProgress() {
        return this._tag == Tag.IN_PROGRESS;
    }

    public boolean isUnsupportedExtension() {
        return this._tag == Tag.UNSUPPORTED_EXTENSION;
    }

    public boolean isUnsupportedContent() {
        return this._tag == Tag.UNSUPPORTED_CONTENT;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof PreviewError)) {
            return false;
        }
        PreviewError previewError = (PreviewError) obj;
        if (this._tag != previewError._tag) {
            return false;
        }
        int i = C41831.$SwitchMap$com$dropbox$core$v2$files$PreviewError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = previewError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.PreviewError$1 */
    static /* synthetic */ class C41831 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$PreviewError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$PreviewError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PreviewError$Tag[Tag.IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PreviewError$Tag[Tag.UNSUPPORTED_EXTENSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PreviewError$Tag[Tag.UNSUPPORTED_CONTENT.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<PreviewError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PreviewError previewError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41831.$SwitchMap$com$dropbox$core$v2$files$PreviewError$Tag[previewError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(previewError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("in_progress");
            } else if (i == 3) {
                jsonGenerator.writeString("unsupported_extension");
            } else {
                if (i == 4) {
                    jsonGenerator.writeString("unsupported_content");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + previewError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PreviewError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PreviewError previewErrorPath;
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
                previewErrorPath = PreviewError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("in_progress".equals(tag)) {
                previewErrorPath = PreviewError.IN_PROGRESS;
            } else if ("unsupported_extension".equals(tag)) {
                previewErrorPath = PreviewError.UNSUPPORTED_EXTENSION;
            } else if ("unsupported_content".equals(tag)) {
                previewErrorPath = PreviewError.UNSUPPORTED_CONTENT;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return previewErrorPath;
        }
    }
}
