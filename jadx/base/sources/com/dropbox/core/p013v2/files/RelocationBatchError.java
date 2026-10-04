package com.dropbox.core.p013v2.files;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.p013v2.files.MoveIntoFamilyError;
import com.dropbox.core.p013v2.files.MoveIntoVaultError;
import com.dropbox.core.p013v2.files.WriteError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RelocationBatchError {
    private Tag _tag;
    private MoveIntoFamilyError cantMoveIntoFamilyValue;
    private MoveIntoVaultError cantMoveIntoVaultValue;
    private LookupError fromLookupValue;
    private WriteError fromWriteValue;
    private WriteError toValue;
    public static final RelocationBatchError CANT_COPY_SHARED_FOLDER = new RelocationBatchError().withTag(Tag.CANT_COPY_SHARED_FOLDER);
    public static final RelocationBatchError CANT_NEST_SHARED_FOLDER = new RelocationBatchError().withTag(Tag.CANT_NEST_SHARED_FOLDER);
    public static final RelocationBatchError CANT_MOVE_FOLDER_INTO_ITSELF = new RelocationBatchError().withTag(Tag.CANT_MOVE_FOLDER_INTO_ITSELF);
    public static final RelocationBatchError TOO_MANY_FILES = new RelocationBatchError().withTag(Tag.TOO_MANY_FILES);
    public static final RelocationBatchError DUPLICATED_OR_NESTED_PATHS = new RelocationBatchError().withTag(Tag.DUPLICATED_OR_NESTED_PATHS);
    public static final RelocationBatchError CANT_TRANSFER_OWNERSHIP = new RelocationBatchError().withTag(Tag.CANT_TRANSFER_OWNERSHIP);
    public static final RelocationBatchError INSUFFICIENT_QUOTA = new RelocationBatchError().withTag(Tag.INSUFFICIENT_QUOTA);
    public static final RelocationBatchError INTERNAL_ERROR = new RelocationBatchError().withTag(Tag.INTERNAL_ERROR);
    public static final RelocationBatchError CANT_MOVE_SHARED_FOLDER = new RelocationBatchError().withTag(Tag.CANT_MOVE_SHARED_FOLDER);
    public static final RelocationBatchError OTHER = new RelocationBatchError().withTag(Tag.OTHER);
    public static final RelocationBatchError TOO_MANY_WRITE_OPERATIONS = new RelocationBatchError().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);

    public enum Tag {
        FROM_LOOKUP,
        FROM_WRITE,
        TO,
        CANT_COPY_SHARED_FOLDER,
        CANT_NEST_SHARED_FOLDER,
        CANT_MOVE_FOLDER_INTO_ITSELF,
        TOO_MANY_FILES,
        DUPLICATED_OR_NESTED_PATHS,
        CANT_TRANSFER_OWNERSHIP,
        INSUFFICIENT_QUOTA,
        INTERNAL_ERROR,
        CANT_MOVE_SHARED_FOLDER,
        CANT_MOVE_INTO_VAULT,
        CANT_MOVE_INTO_FAMILY,
        OTHER,
        TOO_MANY_WRITE_OPERATIONS
    }

    private RelocationBatchError() {
    }

    private RelocationBatchError withTag(Tag tag) {
        RelocationBatchError relocationBatchError = new RelocationBatchError();
        relocationBatchError._tag = tag;
        return relocationBatchError;
    }

    private RelocationBatchError withTagAndFromLookup(Tag tag, LookupError lookupError) {
        RelocationBatchError relocationBatchError = new RelocationBatchError();
        relocationBatchError._tag = tag;
        relocationBatchError.fromLookupValue = lookupError;
        return relocationBatchError;
    }

    private RelocationBatchError withTagAndFromWrite(Tag tag, WriteError writeError) {
        RelocationBatchError relocationBatchError = new RelocationBatchError();
        relocationBatchError._tag = tag;
        relocationBatchError.fromWriteValue = writeError;
        return relocationBatchError;
    }

    private RelocationBatchError withTagAndTo(Tag tag, WriteError writeError) {
        RelocationBatchError relocationBatchError = new RelocationBatchError();
        relocationBatchError._tag = tag;
        relocationBatchError.toValue = writeError;
        return relocationBatchError;
    }

    private RelocationBatchError withTagAndCantMoveIntoVault(Tag tag, MoveIntoVaultError moveIntoVaultError) {
        RelocationBatchError relocationBatchError = new RelocationBatchError();
        relocationBatchError._tag = tag;
        relocationBatchError.cantMoveIntoVaultValue = moveIntoVaultError;
        return relocationBatchError;
    }

    private RelocationBatchError withTagAndCantMoveIntoFamily(Tag tag, MoveIntoFamilyError moveIntoFamilyError) {
        RelocationBatchError relocationBatchError = new RelocationBatchError();
        relocationBatchError._tag = tag;
        relocationBatchError.cantMoveIntoFamilyValue = moveIntoFamilyError;
        return relocationBatchError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isFromLookup() {
        return this._tag == Tag.FROM_LOOKUP;
    }

    public static RelocationBatchError fromLookup(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchError().withTagAndFromLookup(Tag.FROM_LOOKUP, lookupError);
    }

    public LookupError getFromLookupValue() {
        if (this._tag != Tag.FROM_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.FROM_LOOKUP, but was Tag." + this._tag.name());
        }
        return this.fromLookupValue;
    }

    public boolean isFromWrite() {
        return this._tag == Tag.FROM_WRITE;
    }

    public static RelocationBatchError fromWrite(WriteError writeError) {
        if (writeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchError().withTagAndFromWrite(Tag.FROM_WRITE, writeError);
    }

    public WriteError getFromWriteValue() {
        if (this._tag != Tag.FROM_WRITE) {
            throw new IllegalStateException("Invalid tag: required Tag.FROM_WRITE, but was Tag." + this._tag.name());
        }
        return this.fromWriteValue;
    }

    public boolean isTo() {
        return this._tag == Tag.TO;
    }

    /* JADX INFO: renamed from: to */
    public static RelocationBatchError m534to(WriteError writeError) {
        if (writeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchError().withTagAndTo(Tag.TO, writeError);
    }

    public WriteError getToValue() {
        if (this._tag != Tag.TO) {
            throw new IllegalStateException("Invalid tag: required Tag.TO, but was Tag." + this._tag.name());
        }
        return this.toValue;
    }

    public boolean isCantCopySharedFolder() {
        return this._tag == Tag.CANT_COPY_SHARED_FOLDER;
    }

    public boolean isCantNestSharedFolder() {
        return this._tag == Tag.CANT_NEST_SHARED_FOLDER;
    }

    public boolean isCantMoveFolderIntoItself() {
        return this._tag == Tag.CANT_MOVE_FOLDER_INTO_ITSELF;
    }

    public boolean isTooManyFiles() {
        return this._tag == Tag.TOO_MANY_FILES;
    }

    public boolean isDuplicatedOrNestedPaths() {
        return this._tag == Tag.DUPLICATED_OR_NESTED_PATHS;
    }

    public boolean isCantTransferOwnership() {
        return this._tag == Tag.CANT_TRANSFER_OWNERSHIP;
    }

    public boolean isInsufficientQuota() {
        return this._tag == Tag.INSUFFICIENT_QUOTA;
    }

    public boolean isInternalError() {
        return this._tag == Tag.INTERNAL_ERROR;
    }

    public boolean isCantMoveSharedFolder() {
        return this._tag == Tag.CANT_MOVE_SHARED_FOLDER;
    }

    public boolean isCantMoveIntoVault() {
        return this._tag == Tag.CANT_MOVE_INTO_VAULT;
    }

    public static RelocationBatchError cantMoveIntoVault(MoveIntoVaultError moveIntoVaultError) {
        if (moveIntoVaultError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchError().withTagAndCantMoveIntoVault(Tag.CANT_MOVE_INTO_VAULT, moveIntoVaultError);
    }

    public MoveIntoVaultError getCantMoveIntoVaultValue() {
        if (this._tag != Tag.CANT_MOVE_INTO_VAULT) {
            throw new IllegalStateException("Invalid tag: required Tag.CANT_MOVE_INTO_VAULT, but was Tag." + this._tag.name());
        }
        return this.cantMoveIntoVaultValue;
    }

    public boolean isCantMoveIntoFamily() {
        return this._tag == Tag.CANT_MOVE_INTO_FAMILY;
    }

    public static RelocationBatchError cantMoveIntoFamily(MoveIntoFamilyError moveIntoFamilyError) {
        if (moveIntoFamilyError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchError().withTagAndCantMoveIntoFamily(Tag.CANT_MOVE_INTO_FAMILY, moveIntoFamilyError);
    }

    public MoveIntoFamilyError getCantMoveIntoFamilyValue() {
        if (this._tag != Tag.CANT_MOVE_INTO_FAMILY) {
            throw new IllegalStateException("Invalid tag: required Tag.CANT_MOVE_INTO_FAMILY, but was Tag." + this._tag.name());
        }
        return this.cantMoveIntoFamilyValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public boolean isTooManyWriteOperations() {
        return this._tag == Tag.TOO_MANY_WRITE_OPERATIONS;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.fromLookupValue, this.fromWriteValue, this.toValue, this.cantMoveIntoVaultValue, this.cantMoveIntoFamilyValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RelocationBatchError)) {
            return false;
        }
        RelocationBatchError relocationBatchError = (RelocationBatchError) obj;
        if (this._tag != relocationBatchError._tag) {
            return false;
        }
        switch (C41841.$SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[this._tag.ordinal()]) {
            case 1:
                LookupError lookupError = this.fromLookupValue;
                LookupError lookupError2 = relocationBatchError.fromLookupValue;
                return lookupError == lookupError2 || lookupError.equals(lookupError2);
            case 2:
                WriteError writeError = this.fromWriteValue;
                WriteError writeError2 = relocationBatchError.fromWriteValue;
                return writeError == writeError2 || writeError.equals(writeError2);
            case 3:
                WriteError writeError3 = this.toValue;
                WriteError writeError4 = relocationBatchError.toValue;
                return writeError3 == writeError4 || writeError3.equals(writeError4);
            case 13:
                MoveIntoVaultError moveIntoVaultError = this.cantMoveIntoVaultValue;
                MoveIntoVaultError moveIntoVaultError2 = relocationBatchError.cantMoveIntoVaultValue;
                if (moveIntoVaultError != moveIntoVaultError2 && !moveIntoVaultError.equals(moveIntoVaultError2)) {
                    return false;
                }
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return true;
            case 14:
                MoveIntoFamilyError moveIntoFamilyError = this.cantMoveIntoFamilyValue;
                MoveIntoFamilyError moveIntoFamilyError2 = relocationBatchError.cantMoveIntoFamilyValue;
                return moveIntoFamilyError == moveIntoFamilyError2 || moveIntoFamilyError.equals(moveIntoFamilyError2);
            case 15:
            case 16:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.RelocationBatchError$1 */
    static /* synthetic */ class C41841 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag = iArr;
            try {
                iArr[Tag.FROM_LOOKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.FROM_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.TO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.CANT_COPY_SHARED_FOLDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.CANT_NEST_SHARED_FOLDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.CANT_MOVE_FOLDER_INTO_ITSELF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.TOO_MANY_FILES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.DUPLICATED_OR_NESTED_PATHS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.CANT_TRANSFER_OWNERSHIP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.INSUFFICIENT_QUOTA.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.INTERNAL_ERROR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.CANT_MOVE_SHARED_FOLDER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.CANT_MOVE_INTO_VAULT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.CANT_MOVE_INTO_FAMILY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.OTHER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[Tag.TOO_MANY_WRITE_OPERATIONS.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<RelocationBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RelocationBatchError relocationBatchError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41841.$SwitchMap$com$dropbox$core$v2$files$RelocationBatchError$Tag[relocationBatchError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("from_lookup", jsonGenerator);
                    jsonGenerator.writeFieldName("from_lookup");
                    LookupError.Serializer.INSTANCE.serialize(relocationBatchError.fromLookupValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("from_write", jsonGenerator);
                    jsonGenerator.writeFieldName("from_write");
                    WriteError.Serializer.INSTANCE.serialize(relocationBatchError.fromWriteValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag(TypedValues.TransitionType.S_TO, jsonGenerator);
                    jsonGenerator.writeFieldName(TypedValues.TransitionType.S_TO);
                    WriteError.Serializer.INSTANCE.serialize(relocationBatchError.toValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 4:
                    jsonGenerator.writeString("cant_copy_shared_folder");
                    return;
                case 5:
                    jsonGenerator.writeString("cant_nest_shared_folder");
                    return;
                case 6:
                    jsonGenerator.writeString("cant_move_folder_into_itself");
                    return;
                case 7:
                    jsonGenerator.writeString("too_many_files");
                    return;
                case 8:
                    jsonGenerator.writeString("duplicated_or_nested_paths");
                    return;
                case 9:
                    jsonGenerator.writeString("cant_transfer_ownership");
                    return;
                case 10:
                    jsonGenerator.writeString("insufficient_quota");
                    return;
                case 11:
                    jsonGenerator.writeString("internal_error");
                    return;
                case 12:
                    jsonGenerator.writeString("cant_move_shared_folder");
                    return;
                case 13:
                    jsonGenerator.writeStartObject();
                    writeTag("cant_move_into_vault", jsonGenerator);
                    jsonGenerator.writeFieldName("cant_move_into_vault");
                    MoveIntoVaultError.Serializer.INSTANCE.serialize(relocationBatchError.cantMoveIntoVaultValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 14:
                    jsonGenerator.writeStartObject();
                    writeTag("cant_move_into_family", jsonGenerator);
                    jsonGenerator.writeFieldName("cant_move_into_family");
                    MoveIntoFamilyError.Serializer.INSTANCE.serialize(relocationBatchError.cantMoveIntoFamilyValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 15:
                    jsonGenerator.writeString("other");
                    return;
                case 16:
                    jsonGenerator.writeString("too_many_write_operations");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + relocationBatchError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RelocationBatchError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RelocationBatchError relocationBatchErrorCantMoveIntoFamily;
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
            if ("from_lookup".equals(tag)) {
                expectField("from_lookup", jsonParser);
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.fromLookup(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("from_write".equals(tag)) {
                expectField("from_write", jsonParser);
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.fromWrite(WriteError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if (TypedValues.TransitionType.S_TO.equals(tag)) {
                expectField(TypedValues.TransitionType.S_TO, jsonParser);
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.m534to(WriteError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("cant_copy_shared_folder".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.CANT_COPY_SHARED_FOLDER;
            } else if ("cant_nest_shared_folder".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.CANT_NEST_SHARED_FOLDER;
            } else if ("cant_move_folder_into_itself".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.CANT_MOVE_FOLDER_INTO_ITSELF;
            } else if ("too_many_files".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.TOO_MANY_FILES;
            } else if ("duplicated_or_nested_paths".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.DUPLICATED_OR_NESTED_PATHS;
            } else if ("cant_transfer_ownership".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.CANT_TRANSFER_OWNERSHIP;
            } else if ("insufficient_quota".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.INSUFFICIENT_QUOTA;
            } else if ("internal_error".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.INTERNAL_ERROR;
            } else if ("cant_move_shared_folder".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.CANT_MOVE_SHARED_FOLDER;
            } else if ("cant_move_into_vault".equals(tag)) {
                expectField("cant_move_into_vault", jsonParser);
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.cantMoveIntoVault(MoveIntoVaultError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("cant_move_into_family".equals(tag)) {
                expectField("cant_move_into_family", jsonParser);
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.cantMoveIntoFamily(MoveIntoFamilyError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("other".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.OTHER;
            } else if ("too_many_write_operations".equals(tag)) {
                relocationBatchErrorCantMoveIntoFamily = RelocationBatchError.TOO_MANY_WRITE_OPERATIONS;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return relocationBatchErrorCantMoveIntoFamily;
        }
    }
}
