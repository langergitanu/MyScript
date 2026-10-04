package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedFolderAccessError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class TransferFolderError {
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    public static final TransferFolderError INVALID_DROPBOX_ID = new TransferFolderError().withTag(Tag.INVALID_DROPBOX_ID);
    public static final TransferFolderError NEW_OWNER_NOT_A_MEMBER = new TransferFolderError().withTag(Tag.NEW_OWNER_NOT_A_MEMBER);
    public static final TransferFolderError NEW_OWNER_UNMOUNTED = new TransferFolderError().withTag(Tag.NEW_OWNER_UNMOUNTED);
    public static final TransferFolderError NEW_OWNER_EMAIL_UNVERIFIED = new TransferFolderError().withTag(Tag.NEW_OWNER_EMAIL_UNVERIFIED);
    public static final TransferFolderError TEAM_FOLDER = new TransferFolderError().withTag(Tag.TEAM_FOLDER);
    public static final TransferFolderError NO_PERMISSION = new TransferFolderError().withTag(Tag.NO_PERMISSION);
    public static final TransferFolderError OTHER = new TransferFolderError().withTag(Tag.OTHER);

    public enum Tag {
        ACCESS_ERROR,
        INVALID_DROPBOX_ID,
        NEW_OWNER_NOT_A_MEMBER,
        NEW_OWNER_UNMOUNTED,
        NEW_OWNER_EMAIL_UNVERIFIED,
        TEAM_FOLDER,
        NO_PERMISSION,
        OTHER
    }

    private TransferFolderError() {
    }

    private TransferFolderError withTag(Tag tag) {
        TransferFolderError transferFolderError = new TransferFolderError();
        transferFolderError._tag = tag;
        return transferFolderError;
    }

    private TransferFolderError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        TransferFolderError transferFolderError = new TransferFolderError();
        transferFolderError._tag = tag;
        transferFolderError.accessErrorValue = sharedFolderAccessError;
        return transferFolderError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static TransferFolderError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TransferFolderError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
    }

    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isInvalidDropboxId() {
        return this._tag == Tag.INVALID_DROPBOX_ID;
    }

    public boolean isNewOwnerNotAMember() {
        return this._tag == Tag.NEW_OWNER_NOT_A_MEMBER;
    }

    public boolean isNewOwnerUnmounted() {
        return this._tag == Tag.NEW_OWNER_UNMOUNTED;
    }

    public boolean isNewOwnerEmailUnverified() {
        return this._tag == Tag.NEW_OWNER_EMAIL_UNVERIFIED;
    }

    public boolean isTeamFolder() {
        return this._tag == Tag.TEAM_FOLDER;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TransferFolderError)) {
            return false;
        }
        TransferFolderError transferFolderError = (TransferFolderError) obj;
        if (this._tag != transferFolderError._tag) {
            return false;
        }
        switch (C43101.$SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag[this._tag.ordinal()]) {
            case 1:
                SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
                SharedFolderAccessError sharedFolderAccessError2 = transferFolderError.accessErrorValue;
                return sharedFolderAccessError == sharedFolderAccessError2 || sharedFolderAccessError.equals(sharedFolderAccessError2);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.TransferFolderError$1 */
    static /* synthetic */ class C43101 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag[Tag.INVALID_DROPBOX_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag[Tag.NEW_OWNER_NOT_A_MEMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag[Tag.NEW_OWNER_UNMOUNTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag[Tag.NEW_OWNER_EMAIL_UNVERIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag[Tag.TEAM_FOLDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag[Tag.NO_PERMISSION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag[Tag.OTHER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<TransferFolderError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TransferFolderError transferFolderError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43101.$SwitchMap$com$dropbox$core$v2$sharing$TransferFolderError$Tag[transferFolderError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("access_error", jsonGenerator);
                    jsonGenerator.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(transferFolderError.accessErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeString("invalid_dropbox_id");
                    break;
                case 3:
                    jsonGenerator.writeString("new_owner_not_a_member");
                    break;
                case 4:
                    jsonGenerator.writeString("new_owner_unmounted");
                    break;
                case 5:
                    jsonGenerator.writeString("new_owner_email_unverified");
                    break;
                case 6:
                    jsonGenerator.writeString("team_folder");
                    break;
                case 7:
                    jsonGenerator.writeString("no_permission");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TransferFolderError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TransferFolderError transferFolderErrorAccessError;
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
            if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                transferFolderErrorAccessError = TransferFolderError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("invalid_dropbox_id".equals(tag)) {
                transferFolderErrorAccessError = TransferFolderError.INVALID_DROPBOX_ID;
            } else if ("new_owner_not_a_member".equals(tag)) {
                transferFolderErrorAccessError = TransferFolderError.NEW_OWNER_NOT_A_MEMBER;
            } else if ("new_owner_unmounted".equals(tag)) {
                transferFolderErrorAccessError = TransferFolderError.NEW_OWNER_UNMOUNTED;
            } else if ("new_owner_email_unverified".equals(tag)) {
                transferFolderErrorAccessError = TransferFolderError.NEW_OWNER_EMAIL_UNVERIFIED;
            } else if ("team_folder".equals(tag)) {
                transferFolderErrorAccessError = TransferFolderError.TEAM_FOLDER;
            } else if ("no_permission".equals(tag)) {
                transferFolderErrorAccessError = TransferFolderError.NO_PERMISSION;
            } else {
                transferFolderErrorAccessError = TransferFolderError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return transferFolderErrorAccessError;
        }
    }
}
