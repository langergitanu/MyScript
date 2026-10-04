package com.dropbox.core.p013v2.files;

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
public final class SaveCopyReferenceError {
    private Tag _tag;
    private WriteError pathValue;
    public static final SaveCopyReferenceError INVALID_COPY_REFERENCE = new SaveCopyReferenceError().withTag(Tag.INVALID_COPY_REFERENCE);
    public static final SaveCopyReferenceError NO_PERMISSION = new SaveCopyReferenceError().withTag(Tag.NO_PERMISSION);
    public static final SaveCopyReferenceError NOT_FOUND = new SaveCopyReferenceError().withTag(Tag.NOT_FOUND);
    public static final SaveCopyReferenceError TOO_MANY_FILES = new SaveCopyReferenceError().withTag(Tag.TOO_MANY_FILES);
    public static final SaveCopyReferenceError OTHER = new SaveCopyReferenceError().withTag(Tag.OTHER);

    public enum Tag {
        PATH,
        INVALID_COPY_REFERENCE,
        NO_PERMISSION,
        NOT_FOUND,
        TOO_MANY_FILES,
        OTHER
    }

    private SaveCopyReferenceError() {
    }

    private SaveCopyReferenceError withTag(Tag tag) {
        SaveCopyReferenceError saveCopyReferenceError = new SaveCopyReferenceError();
        saveCopyReferenceError._tag = tag;
        return saveCopyReferenceError;
    }

    private SaveCopyReferenceError withTagAndPath(Tag tag, WriteError writeError) {
        SaveCopyReferenceError saveCopyReferenceError = new SaveCopyReferenceError();
        saveCopyReferenceError._tag = tag;
        saveCopyReferenceError.pathValue = writeError;
        return saveCopyReferenceError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static SaveCopyReferenceError path(WriteError writeError) {
        if (writeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SaveCopyReferenceError().withTagAndPath(Tag.PATH, writeError);
    }

    public WriteError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isInvalidCopyReference() {
        return this._tag == Tag.INVALID_COPY_REFERENCE;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isNotFound() {
        return this._tag == Tag.NOT_FOUND;
    }

    public boolean isTooManyFiles() {
        return this._tag == Tag.TOO_MANY_FILES;
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
        if (obj == null || !(obj instanceof SaveCopyReferenceError)) {
            return false;
        }
        SaveCopyReferenceError saveCopyReferenceError = (SaveCopyReferenceError) obj;
        if (this._tag != saveCopyReferenceError._tag) {
            return false;
        }
        switch (C41941.$SwitchMap$com$dropbox$core$v2$files$SaveCopyReferenceError$Tag[this._tag.ordinal()]) {
            case 1:
                WriteError writeError = this.pathValue;
                WriteError writeError2 = saveCopyReferenceError.pathValue;
                return writeError == writeError2 || writeError.equals(writeError2);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SaveCopyReferenceError$1 */
    static /* synthetic */ class C41941 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SaveCopyReferenceError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SaveCopyReferenceError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveCopyReferenceError$Tag[Tag.INVALID_COPY_REFERENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveCopyReferenceError$Tag[Tag.NO_PERMISSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveCopyReferenceError$Tag[Tag.NOT_FOUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveCopyReferenceError$Tag[Tag.TOO_MANY_FILES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveCopyReferenceError$Tag[Tag.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<SaveCopyReferenceError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SaveCopyReferenceError saveCopyReferenceError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41941.$SwitchMap$com$dropbox$core$v2$files$SaveCopyReferenceError$Tag[saveCopyReferenceError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                WriteError.Serializer.INSTANCE.serialize(saveCopyReferenceError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("invalid_copy_reference");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("no_permission");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("not_found");
            } else if (i == 5) {
                jsonGenerator.writeString("too_many_files");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SaveCopyReferenceError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SaveCopyReferenceError saveCopyReferenceErrorPath;
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
                saveCopyReferenceErrorPath = SaveCopyReferenceError.path(WriteError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("invalid_copy_reference".equals(tag)) {
                saveCopyReferenceErrorPath = SaveCopyReferenceError.INVALID_COPY_REFERENCE;
            } else if ("no_permission".equals(tag)) {
                saveCopyReferenceErrorPath = SaveCopyReferenceError.NO_PERMISSION;
            } else if ("not_found".equals(tag)) {
                saveCopyReferenceErrorPath = SaveCopyReferenceError.NOT_FOUND;
            } else if ("too_many_files".equals(tag)) {
                saveCopyReferenceErrorPath = SaveCopyReferenceError.TOO_MANY_FILES;
            } else {
                saveCopyReferenceErrorPath = SaveCopyReferenceError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return saveCopyReferenceErrorPath;
        }
    }
}
