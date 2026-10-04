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
public final class ExportError {
    private Tag _tag;
    private LookupError pathValue;
    public static final ExportError NON_EXPORTABLE = new ExportError().withTag(Tag.NON_EXPORTABLE);
    public static final ExportError INVALID_EXPORT_FORMAT = new ExportError().withTag(Tag.INVALID_EXPORT_FORMAT);
    public static final ExportError RETRY_ERROR = new ExportError().withTag(Tag.RETRY_ERROR);
    public static final ExportError OTHER = new ExportError().withTag(Tag.OTHER);

    public enum Tag {
        PATH,
        NON_EXPORTABLE,
        INVALID_EXPORT_FORMAT,
        RETRY_ERROR,
        OTHER
    }

    private ExportError() {
    }

    private ExportError withTag(Tag tag) {
        ExportError exportError = new ExportError();
        exportError._tag = tag;
        return exportError;
    }

    private ExportError withTagAndPath(Tag tag, LookupError lookupError) {
        ExportError exportError = new ExportError();
        exportError._tag = tag;
        exportError.pathValue = lookupError;
        return exportError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static ExportError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ExportError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isNonExportable() {
        return this._tag == Tag.NON_EXPORTABLE;
    }

    public boolean isInvalidExportFormat() {
        return this._tag == Tag.INVALID_EXPORT_FORMAT;
    }

    public boolean isRetryError() {
        return this._tag == Tag.RETRY_ERROR;
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
        if (obj == null || !(obj instanceof ExportError)) {
            return false;
        }
        ExportError exportError = (ExportError) obj;
        if (this._tag != exportError._tag) {
            return false;
        }
        int i = C41571.$SwitchMap$com$dropbox$core$v2$files$ExportError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4 || i == 5;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = exportError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ExportError$1 */
    static /* synthetic */ class C41571 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ExportError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ExportError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ExportError$Tag[Tag.NON_EXPORTABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ExportError$Tag[Tag.INVALID_EXPORT_FORMAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ExportError$Tag[Tag.RETRY_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ExportError$Tag[Tag.OTHER.ordinal()] = 5;
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

    public static class Serializer extends UnionSerializer<ExportError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ExportError exportError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41571.$SwitchMap$com$dropbox$core$v2$files$ExportError$Tag[exportError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(exportError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("non_exportable");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("invalid_export_format");
            } else if (i == 4) {
                jsonGenerator.writeString("retry_error");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ExportError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ExportError exportErrorPath;
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
                exportErrorPath = ExportError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("non_exportable".equals(tag)) {
                exportErrorPath = ExportError.NON_EXPORTABLE;
            } else if ("invalid_export_format".equals(tag)) {
                exportErrorPath = ExportError.INVALID_EXPORT_FORMAT;
            } else if ("retry_error".equals(tag)) {
                exportErrorPath = ExportError.RETRY_ERROR;
            } else {
                exportErrorPath = ExportError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return exportErrorPath;
        }
    }
}
