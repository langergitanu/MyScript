package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedFolderAccessError;
import com.dropbox.core.p013v2.sharing.SharedFolderMemberError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoveFolderMemberError {
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    private SharedFolderMemberError memberErrorValue;
    public static final RemoveFolderMemberError FOLDER_OWNER = new RemoveFolderMemberError().withTag(Tag.FOLDER_OWNER);
    public static final RemoveFolderMemberError GROUP_ACCESS = new RemoveFolderMemberError().withTag(Tag.GROUP_ACCESS);
    public static final RemoveFolderMemberError TEAM_FOLDER = new RemoveFolderMemberError().withTag(Tag.TEAM_FOLDER);
    public static final RemoveFolderMemberError NO_PERMISSION = new RemoveFolderMemberError().withTag(Tag.NO_PERMISSION);
    public static final RemoveFolderMemberError TOO_MANY_FILES = new RemoveFolderMemberError().withTag(Tag.TOO_MANY_FILES);
    public static final RemoveFolderMemberError OTHER = new RemoveFolderMemberError().withTag(Tag.OTHER);

    public enum Tag {
        ACCESS_ERROR,
        MEMBER_ERROR,
        FOLDER_OWNER,
        GROUP_ACCESS,
        TEAM_FOLDER,
        NO_PERMISSION,
        TOO_MANY_FILES,
        OTHER
    }

    private RemoveFolderMemberError() {
    }

    private RemoveFolderMemberError withTag(Tag tag) {
        RemoveFolderMemberError removeFolderMemberError = new RemoveFolderMemberError();
        removeFolderMemberError._tag = tag;
        return removeFolderMemberError;
    }

    private RemoveFolderMemberError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        RemoveFolderMemberError removeFolderMemberError = new RemoveFolderMemberError();
        removeFolderMemberError._tag = tag;
        removeFolderMemberError.accessErrorValue = sharedFolderAccessError;
        return removeFolderMemberError;
    }

    private RemoveFolderMemberError withTagAndMemberError(Tag tag, SharedFolderMemberError sharedFolderMemberError) {
        RemoveFolderMemberError removeFolderMemberError = new RemoveFolderMemberError();
        removeFolderMemberError._tag = tag;
        removeFolderMemberError.memberErrorValue = sharedFolderMemberError;
        return removeFolderMemberError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static RemoveFolderMemberError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveFolderMemberError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
    }

    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isMemberError() {
        return this._tag == Tag.MEMBER_ERROR;
    }

    public static RemoveFolderMemberError memberError(SharedFolderMemberError sharedFolderMemberError) {
        if (sharedFolderMemberError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveFolderMemberError().withTagAndMemberError(Tag.MEMBER_ERROR, sharedFolderMemberError);
    }

    public SharedFolderMemberError getMemberErrorValue() {
        if (this._tag != Tag.MEMBER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_ERROR, but was Tag." + this._tag.name());
        }
        return this.memberErrorValue;
    }

    public boolean isFolderOwner() {
        return this._tag == Tag.FOLDER_OWNER;
    }

    public boolean isGroupAccess() {
        return this._tag == Tag.GROUP_ACCESS;
    }

    public boolean isTeamFolder() {
        return this._tag == Tag.TEAM_FOLDER;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isTooManyFiles() {
        return this._tag == Tag.TOO_MANY_FILES;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue, this.memberErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RemoveFolderMemberError)) {
            return false;
        }
        RemoveFolderMemberError removeFolderMemberError = (RemoveFolderMemberError) obj;
        if (this._tag != removeFolderMemberError._tag) {
            return false;
        }
        switch (C42901.f730xfee848dc[this._tag.ordinal()]) {
            case 1:
                SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
                SharedFolderAccessError sharedFolderAccessError2 = removeFolderMemberError.accessErrorValue;
                return sharedFolderAccessError == sharedFolderAccessError2 || sharedFolderAccessError.equals(sharedFolderAccessError2);
            case 2:
                SharedFolderMemberError sharedFolderMemberError = this.memberErrorValue;
                SharedFolderMemberError sharedFolderMemberError2 = removeFolderMemberError.memberErrorValue;
                return sharedFolderMemberError == sharedFolderMemberError2 || sharedFolderMemberError.equals(sharedFolderMemberError2);
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

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.RemoveFolderMemberError$1 */
    static /* synthetic */ class C42901 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$RemoveFolderMemberError$Tag */
        static final /* synthetic */ int[] f730xfee848dc;

        static {
            int[] iArr = new int[Tag.values().length];
            f730xfee848dc = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f730xfee848dc[Tag.MEMBER_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f730xfee848dc[Tag.FOLDER_OWNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f730xfee848dc[Tag.GROUP_ACCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f730xfee848dc[Tag.TEAM_FOLDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f730xfee848dc[Tag.NO_PERMISSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f730xfee848dc[Tag.TOO_MANY_FILES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f730xfee848dc[Tag.OTHER.ordinal()] = 8;
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

    static class Serializer extends UnionSerializer<RemoveFolderMemberError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RemoveFolderMemberError removeFolderMemberError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42901.f730xfee848dc[removeFolderMemberError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("access_error", jsonGenerator);
                    jsonGenerator.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(removeFolderMemberError.accessErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("member_error", jsonGenerator);
                    jsonGenerator.writeFieldName("member_error");
                    SharedFolderMemberError.Serializer.INSTANCE.serialize(removeFolderMemberError.memberErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 3:
                    jsonGenerator.writeString("folder_owner");
                    break;
                case 4:
                    jsonGenerator.writeString("group_access");
                    break;
                case 5:
                    jsonGenerator.writeString("team_folder");
                    break;
                case 6:
                    jsonGenerator.writeString("no_permission");
                    break;
                case 7:
                    jsonGenerator.writeString("too_many_files");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RemoveFolderMemberError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RemoveFolderMemberError removeFolderMemberErrorMemberError;
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
                removeFolderMemberErrorMemberError = RemoveFolderMemberError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("member_error".equals(tag)) {
                expectField("member_error", jsonParser);
                removeFolderMemberErrorMemberError = RemoveFolderMemberError.memberError(SharedFolderMemberError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("folder_owner".equals(tag)) {
                removeFolderMemberErrorMemberError = RemoveFolderMemberError.FOLDER_OWNER;
            } else if ("group_access".equals(tag)) {
                removeFolderMemberErrorMemberError = RemoveFolderMemberError.GROUP_ACCESS;
            } else if ("team_folder".equals(tag)) {
                removeFolderMemberErrorMemberError = RemoveFolderMemberError.TEAM_FOLDER;
            } else if ("no_permission".equals(tag)) {
                removeFolderMemberErrorMemberError = RemoveFolderMemberError.NO_PERMISSION;
            } else if ("too_many_files".equals(tag)) {
                removeFolderMemberErrorMemberError = RemoveFolderMemberError.TOO_MANY_FILES;
            } else {
                removeFolderMemberErrorMemberError = RemoveFolderMemberError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return removeFolderMemberErrorMemberError;
        }
    }
}
