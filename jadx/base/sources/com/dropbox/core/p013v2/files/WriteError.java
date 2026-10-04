package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.WriteConflictError;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class WriteError {
    private Tag _tag;
    private WriteConflictError conflictValue;
    private String malformedPathValue;
    public static final WriteError NO_WRITE_PERMISSION = new WriteError().withTag(Tag.NO_WRITE_PERMISSION);
    public static final WriteError INSUFFICIENT_SPACE = new WriteError().withTag(Tag.INSUFFICIENT_SPACE);
    public static final WriteError DISALLOWED_NAME = new WriteError().withTag(Tag.DISALLOWED_NAME);
    public static final WriteError TEAM_FOLDER = new WriteError().withTag(Tag.TEAM_FOLDER);
    public static final WriteError OPERATION_SUPPRESSED = new WriteError().withTag(Tag.OPERATION_SUPPRESSED);
    public static final WriteError TOO_MANY_WRITE_OPERATIONS = new WriteError().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);
    public static final WriteError OTHER = new WriteError().withTag(Tag.OTHER);

    public enum Tag {
        MALFORMED_PATH,
        CONFLICT,
        NO_WRITE_PERMISSION,
        INSUFFICIENT_SPACE,
        DISALLOWED_NAME,
        TEAM_FOLDER,
        OPERATION_SUPPRESSED,
        TOO_MANY_WRITE_OPERATIONS,
        OTHER
    }

    private WriteError() {
    }

    private WriteError withTag(Tag tag) {
        WriteError writeError = new WriteError();
        writeError._tag = tag;
        return writeError;
    }

    private WriteError withTagAndMalformedPath(Tag tag, String str) {
        WriteError writeError = new WriteError();
        writeError._tag = tag;
        writeError.malformedPathValue = str;
        return writeError;
    }

    private WriteError withTagAndConflict(Tag tag, WriteConflictError writeConflictError) {
        WriteError writeError = new WriteError();
        writeError._tag = tag;
        writeError.conflictValue = writeConflictError;
        return writeError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isMalformedPath() {
        return this._tag == Tag.MALFORMED_PATH;
    }

    public static WriteError malformedPath(String str) {
        return new WriteError().withTagAndMalformedPath(Tag.MALFORMED_PATH, str);
    }

    public static WriteError malformedPath() {
        return malformedPath(null);
    }

    public String getMalformedPathValue() {
        if (this._tag != Tag.MALFORMED_PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.MALFORMED_PATH, but was Tag." + this._tag.name());
        }
        return this.malformedPathValue;
    }

    public boolean isConflict() {
        return this._tag == Tag.CONFLICT;
    }

    public static WriteError conflict(WriteConflictError writeConflictError) {
        if (writeConflictError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new WriteError().withTagAndConflict(Tag.CONFLICT, writeConflictError);
    }

    public WriteConflictError getConflictValue() {
        if (this._tag != Tag.CONFLICT) {
            throw new IllegalStateException("Invalid tag: required Tag.CONFLICT, but was Tag." + this._tag.name());
        }
        return this.conflictValue;
    }

    public boolean isNoWritePermission() {
        return this._tag == Tag.NO_WRITE_PERMISSION;
    }

    public boolean isInsufficientSpace() {
        return this._tag == Tag.INSUFFICIENT_SPACE;
    }

    public boolean isDisallowedName() {
        return this._tag == Tag.DISALLOWED_NAME;
    }

    public boolean isTeamFolder() {
        return this._tag == Tag.TEAM_FOLDER;
    }

    public boolean isOperationSuppressed() {
        return this._tag == Tag.OPERATION_SUPPRESSED;
    }

    public boolean isTooManyWriteOperations() {
        return this._tag == Tag.TOO_MANY_WRITE_OPERATIONS;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.malformedPathValue, this.conflictValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof WriteError)) {
            return false;
        }
        WriteError writeError = (WriteError) obj;
        if (this._tag != writeError._tag) {
            return false;
        }
        switch (C42221.$SwitchMap$com$dropbox$core$v2$files$WriteError$Tag[this._tag.ordinal()]) {
            case 1:
                String str = this.malformedPathValue;
                String str2 = writeError.malformedPathValue;
                return str == str2 || (str != null && str.equals(str2));
            case 2:
                WriteConflictError writeConflictError = this.conflictValue;
                WriteConflictError writeConflictError2 = writeError.conflictValue;
                return writeConflictError == writeConflictError2 || writeConflictError.equals(writeConflictError2);
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

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.WriteError$1 */
    static /* synthetic */ class C42221 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$WriteError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$WriteError$Tag = iArr;
            try {
                iArr[Tag.MALFORMED_PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteError$Tag[Tag.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteError$Tag[Tag.NO_WRITE_PERMISSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteError$Tag[Tag.INSUFFICIENT_SPACE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteError$Tag[Tag.DISALLOWED_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteError$Tag[Tag.TEAM_FOLDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteError$Tag[Tag.OPERATION_SUPPRESSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteError$Tag[Tag.TOO_MANY_WRITE_OPERATIONS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteError$Tag[Tag.OTHER.ordinal()] = 9;
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

    static class Serializer extends UnionSerializer<WriteError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(WriteError writeError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42221.$SwitchMap$com$dropbox$core$v2$files$WriteError$Tag[writeError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("malformed_path", jsonGenerator);
                    jsonGenerator.writeFieldName("malformed_path");
                    StoneSerializers.nullable(StoneSerializers.string()).serialize(writeError.malformedPathValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("conflict", jsonGenerator);
                    jsonGenerator.writeFieldName("conflict");
                    WriteConflictError.Serializer.INSTANCE.serialize(writeError.conflictValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 3:
                    jsonGenerator.writeString("no_write_permission");
                    break;
                case 4:
                    jsonGenerator.writeString("insufficient_space");
                    break;
                case 5:
                    jsonGenerator.writeString("disallowed_name");
                    break;
                case 6:
                    jsonGenerator.writeString("team_folder");
                    break;
                case 7:
                    jsonGenerator.writeString("operation_suppressed");
                    break;
                case 8:
                    jsonGenerator.writeString("too_many_write_operations");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public WriteError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            WriteError writeErrorConflict;
            String str;
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
            if ("malformed_path".equals(tag)) {
                if (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                    expectField("malformed_path", jsonParser);
                    str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                } else {
                    str = null;
                }
                if (str == null) {
                    writeErrorConflict = WriteError.malformedPath();
                } else {
                    writeErrorConflict = WriteError.malformedPath(str);
                }
            } else if ("conflict".equals(tag)) {
                expectField("conflict", jsonParser);
                writeErrorConflict = WriteError.conflict(WriteConflictError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("no_write_permission".equals(tag)) {
                writeErrorConflict = WriteError.NO_WRITE_PERMISSION;
            } else if ("insufficient_space".equals(tag)) {
                writeErrorConflict = WriteError.INSUFFICIENT_SPACE;
            } else if ("disallowed_name".equals(tag)) {
                writeErrorConflict = WriteError.DISALLOWED_NAME;
            } else if ("team_folder".equals(tag)) {
                writeErrorConflict = WriteError.TEAM_FOLDER;
            } else if ("operation_suppressed".equals(tag)) {
                writeErrorConflict = WriteError.OPERATION_SUPPRESSED;
            } else if ("too_many_write_operations".equals(tag)) {
                writeErrorConflict = WriteError.TOO_MANY_WRITE_OPERATIONS;
            } else {
                writeErrorConflict = WriteError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return writeErrorConflict;
        }
    }
}
