package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LockConflictError;
import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class LockFileError {
    private Tag _tag;
    private LockConflictError lockConflictValue;
    private LookupError pathLookupValue;
    public static final LockFileError TOO_MANY_WRITE_OPERATIONS = new LockFileError().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);
    public static final LockFileError TOO_MANY_FILES = new LockFileError().withTag(Tag.TOO_MANY_FILES);
    public static final LockFileError NO_WRITE_PERMISSION = new LockFileError().withTag(Tag.NO_WRITE_PERMISSION);
    public static final LockFileError CANNOT_BE_LOCKED = new LockFileError().withTag(Tag.CANNOT_BE_LOCKED);
    public static final LockFileError FILE_NOT_SHARED = new LockFileError().withTag(Tag.FILE_NOT_SHARED);
    public static final LockFileError INTERNAL_ERROR = new LockFileError().withTag(Tag.INTERNAL_ERROR);
    public static final LockFileError OTHER = new LockFileError().withTag(Tag.OTHER);

    public enum Tag {
        PATH_LOOKUP,
        TOO_MANY_WRITE_OPERATIONS,
        TOO_MANY_FILES,
        NO_WRITE_PERMISSION,
        CANNOT_BE_LOCKED,
        FILE_NOT_SHARED,
        LOCK_CONFLICT,
        INTERNAL_ERROR,
        OTHER
    }

    private LockFileError() {
    }

    private LockFileError withTag(Tag tag) {
        LockFileError lockFileError = new LockFileError();
        lockFileError._tag = tag;
        return lockFileError;
    }

    private LockFileError withTagAndPathLookup(Tag tag, LookupError lookupError) {
        LockFileError lockFileError = new LockFileError();
        lockFileError._tag = tag;
        lockFileError.pathLookupValue = lookupError;
        return lockFileError;
    }

    private LockFileError withTagAndLockConflict(Tag tag, LockConflictError lockConflictError) {
        LockFileError lockFileError = new LockFileError();
        lockFileError._tag = tag;
        lockFileError.lockConflictValue = lockConflictError;
        return lockFileError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPathLookup() {
        return this._tag == Tag.PATH_LOOKUP;
    }

    public static LockFileError pathLookup(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LockFileError().withTagAndPathLookup(Tag.PATH_LOOKUP, lookupError);
    }

    public LookupError getPathLookupValue() {
        if (this._tag != Tag.PATH_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_LOOKUP, but was Tag." + this._tag.name());
        }
        return this.pathLookupValue;
    }

    public boolean isTooManyWriteOperations() {
        return this._tag == Tag.TOO_MANY_WRITE_OPERATIONS;
    }

    public boolean isTooManyFiles() {
        return this._tag == Tag.TOO_MANY_FILES;
    }

    public boolean isNoWritePermission() {
        return this._tag == Tag.NO_WRITE_PERMISSION;
    }

    public boolean isCannotBeLocked() {
        return this._tag == Tag.CANNOT_BE_LOCKED;
    }

    public boolean isFileNotShared() {
        return this._tag == Tag.FILE_NOT_SHARED;
    }

    public boolean isLockConflict() {
        return this._tag == Tag.LOCK_CONFLICT;
    }

    public static LockFileError lockConflict(LockConflictError lockConflictError) {
        if (lockConflictError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LockFileError().withTagAndLockConflict(Tag.LOCK_CONFLICT, lockConflictError);
    }

    public LockConflictError getLockConflictValue() {
        if (this._tag != Tag.LOCK_CONFLICT) {
            throw new IllegalStateException("Invalid tag: required Tag.LOCK_CONFLICT, but was Tag." + this._tag.name());
        }
        return this.lockConflictValue;
    }

    public boolean isInternalError() {
        return this._tag == Tag.INTERNAL_ERROR;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathLookupValue, this.lockConflictValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof LockFileError)) {
            return false;
        }
        LockFileError lockFileError = (LockFileError) obj;
        if (this._tag != lockFileError._tag) {
            return false;
        }
        switch (C41721.$SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag[this._tag.ordinal()]) {
            case 1:
                LookupError lookupError = this.pathLookupValue;
                LookupError lookupError2 = lockFileError.pathLookupValue;
                return lookupError == lookupError2 || lookupError.equals(lookupError2);
            case 7:
                LockConflictError lockConflictError = this.lockConflictValue;
                LockConflictError lockConflictError2 = lockFileError.lockConflictValue;
                if (lockConflictError != lockConflictError2 && !lockConflictError.equals(lockConflictError2)) {
                    return false;
                }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.LockFileError$1 */
    static /* synthetic */ class C41721 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag = iArr;
            try {
                iArr[Tag.PATH_LOOKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag[Tag.TOO_MANY_WRITE_OPERATIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag[Tag.TOO_MANY_FILES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag[Tag.NO_WRITE_PERMISSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag[Tag.CANNOT_BE_LOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag[Tag.FILE_NOT_SHARED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag[Tag.LOCK_CONFLICT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag[Tag.INTERNAL_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag[Tag.OTHER.ordinal()] = 9;
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

    static class Serializer extends UnionSerializer<LockFileError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LockFileError lockFileError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41721.$SwitchMap$com$dropbox$core$v2$files$LockFileError$Tag[lockFileError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("path_lookup", jsonGenerator);
                    jsonGenerator.writeFieldName("path_lookup");
                    LookupError.Serializer.INSTANCE.serialize(lockFileError.pathLookupValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeString("too_many_write_operations");
                    break;
                case 3:
                    jsonGenerator.writeString("too_many_files");
                    break;
                case 4:
                    jsonGenerator.writeString("no_write_permission");
                    break;
                case 5:
                    jsonGenerator.writeString("cannot_be_locked");
                    break;
                case 6:
                    jsonGenerator.writeString("file_not_shared");
                    break;
                case 7:
                    jsonGenerator.writeStartObject();
                    writeTag("lock_conflict", jsonGenerator);
                    LockConflictError.Serializer.INSTANCE.serialize(lockFileError.lockConflictValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 8:
                    jsonGenerator.writeString("internal_error");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LockFileError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LockFileError lockFileErrorLockConflict;
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
                lockFileErrorLockConflict = LockFileError.pathLookup(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("too_many_write_operations".equals(tag)) {
                lockFileErrorLockConflict = LockFileError.TOO_MANY_WRITE_OPERATIONS;
            } else if ("too_many_files".equals(tag)) {
                lockFileErrorLockConflict = LockFileError.TOO_MANY_FILES;
            } else if ("no_write_permission".equals(tag)) {
                lockFileErrorLockConflict = LockFileError.NO_WRITE_PERMISSION;
            } else if ("cannot_be_locked".equals(tag)) {
                lockFileErrorLockConflict = LockFileError.CANNOT_BE_LOCKED;
            } else if ("file_not_shared".equals(tag)) {
                lockFileErrorLockConflict = LockFileError.FILE_NOT_SHARED;
            } else if ("lock_conflict".equals(tag)) {
                lockFileErrorLockConflict = LockFileError.lockConflict(LockConflictError.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("internal_error".equals(tag)) {
                lockFileErrorLockConflict = LockFileError.INTERNAL_ERROR;
            } else {
                lockFileErrorLockConflict = LockFileError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return lockFileErrorLockConflict;
        }
    }
}
