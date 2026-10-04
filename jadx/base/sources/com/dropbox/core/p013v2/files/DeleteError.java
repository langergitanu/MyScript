package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.p013v2.files.WriteError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class DeleteError {
    private Tag _tag;
    private LookupError pathLookupValue;
    private WriteError pathWriteValue;
    public static final DeleteError TOO_MANY_WRITE_OPERATIONS = new DeleteError().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);
    public static final DeleteError TOO_MANY_FILES = new DeleteError().withTag(Tag.TOO_MANY_FILES);
    public static final DeleteError OTHER = new DeleteError().withTag(Tag.OTHER);

    public enum Tag {
        PATH_LOOKUP,
        PATH_WRITE,
        TOO_MANY_WRITE_OPERATIONS,
        TOO_MANY_FILES,
        OTHER
    }

    private DeleteError() {
    }

    private DeleteError withTag(Tag tag) {
        DeleteError deleteError = new DeleteError();
        deleteError._tag = tag;
        return deleteError;
    }

    private DeleteError withTagAndPathLookup(Tag tag, LookupError lookupError) {
        DeleteError deleteError = new DeleteError();
        deleteError._tag = tag;
        deleteError.pathLookupValue = lookupError;
        return deleteError;
    }

    private DeleteError withTagAndPathWrite(Tag tag, WriteError writeError) {
        DeleteError deleteError = new DeleteError();
        deleteError._tag = tag;
        deleteError.pathWriteValue = writeError;
        return deleteError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPathLookup() {
        return this._tag == Tag.PATH_LOOKUP;
    }

    public static DeleteError pathLookup(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteError().withTagAndPathLookup(Tag.PATH_LOOKUP, lookupError);
    }

    public LookupError getPathLookupValue() {
        if (this._tag != Tag.PATH_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_LOOKUP, but was Tag." + this._tag.name());
        }
        return this.pathLookupValue;
    }

    public boolean isPathWrite() {
        return this._tag == Tag.PATH_WRITE;
    }

    public static DeleteError pathWrite(WriteError writeError) {
        if (writeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteError().withTagAndPathWrite(Tag.PATH_WRITE, writeError);
    }

    public WriteError getPathWriteValue() {
        if (this._tag != Tag.PATH_WRITE) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_WRITE, but was Tag." + this._tag.name());
        }
        return this.pathWriteValue;
    }

    public boolean isTooManyWriteOperations() {
        return this._tag == Tag.TOO_MANY_WRITE_OPERATIONS;
    }

    public boolean isTooManyFiles() {
        return this._tag == Tag.TOO_MANY_FILES;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathLookupValue, this.pathWriteValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteError)) {
            return false;
        }
        DeleteError deleteError = (DeleteError) obj;
        if (this._tag != deleteError._tag) {
            return false;
        }
        int i = C41541.$SwitchMap$com$dropbox$core$v2$files$DeleteError$Tag[this._tag.ordinal()];
        if (i == 1) {
            LookupError lookupError = this.pathLookupValue;
            LookupError lookupError2 = deleteError.pathLookupValue;
            return lookupError == lookupError2 || lookupError.equals(lookupError2);
        }
        if (i != 2) {
            return i == 3 || i == 4 || i == 5;
        }
        WriteError writeError = this.pathWriteValue;
        WriteError writeError2 = deleteError.pathWriteValue;
        return writeError == writeError2 || writeError.equals(writeError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.DeleteError$1 */
    static /* synthetic */ class C41541 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$DeleteError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$DeleteError$Tag = iArr;
            try {
                iArr[Tag.PATH_LOOKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DeleteError$Tag[Tag.PATH_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DeleteError$Tag[Tag.TOO_MANY_WRITE_OPERATIONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DeleteError$Tag[Tag.TOO_MANY_FILES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DeleteError$Tag[Tag.OTHER.ordinal()] = 5;
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

    static class Serializer extends UnionSerializer<DeleteError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeleteError deleteError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41541.$SwitchMap$com$dropbox$core$v2$files$DeleteError$Tag[deleteError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("path_lookup", jsonGenerator);
                jsonGenerator.writeFieldName("path_lookup");
                LookupError.Serializer.INSTANCE.serialize(deleteError.pathLookupValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("path_write", jsonGenerator);
                jsonGenerator.writeFieldName("path_write");
                WriteError.Serializer.INSTANCE.serialize(deleteError.pathWriteValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("too_many_write_operations");
            } else if (i == 4) {
                jsonGenerator.writeString("too_many_files");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeleteError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeleteError deleteErrorPathWrite;
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
            if ("path_lookup".equals(tag)) {
                expectField("path_lookup", jsonParser);
                deleteErrorPathWrite = DeleteError.pathLookup(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("path_write".equals(tag)) {
                expectField("path_write", jsonParser);
                deleteErrorPathWrite = DeleteError.pathWrite(WriteError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("too_many_write_operations".equals(tag)) {
                deleteErrorPathWrite = DeleteError.TOO_MANY_WRITE_OPERATIONS;
            } else if ("too_many_files".equals(tag)) {
                deleteErrorPathWrite = DeleteError.TOO_MANY_FILES;
            } else {
                deleteErrorPathWrite = DeleteError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deleteErrorPathWrite;
        }
    }
}
