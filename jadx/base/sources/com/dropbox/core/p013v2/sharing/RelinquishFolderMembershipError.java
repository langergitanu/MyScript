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
public final class RelinquishFolderMembershipError {
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    public static final RelinquishFolderMembershipError FOLDER_OWNER = new RelinquishFolderMembershipError().withTag(Tag.FOLDER_OWNER);
    public static final RelinquishFolderMembershipError MOUNTED = new RelinquishFolderMembershipError().withTag(Tag.MOUNTED);
    public static final RelinquishFolderMembershipError GROUP_ACCESS = new RelinquishFolderMembershipError().withTag(Tag.GROUP_ACCESS);
    public static final RelinquishFolderMembershipError TEAM_FOLDER = new RelinquishFolderMembershipError().withTag(Tag.TEAM_FOLDER);
    public static final RelinquishFolderMembershipError NO_PERMISSION = new RelinquishFolderMembershipError().withTag(Tag.NO_PERMISSION);
    public static final RelinquishFolderMembershipError NO_EXPLICIT_ACCESS = new RelinquishFolderMembershipError().withTag(Tag.NO_EXPLICIT_ACCESS);
    public static final RelinquishFolderMembershipError OTHER = new RelinquishFolderMembershipError().withTag(Tag.OTHER);

    public enum Tag {
        ACCESS_ERROR,
        FOLDER_OWNER,
        MOUNTED,
        GROUP_ACCESS,
        TEAM_FOLDER,
        NO_PERMISSION,
        NO_EXPLICIT_ACCESS,
        OTHER
    }

    private RelinquishFolderMembershipError() {
    }

    private RelinquishFolderMembershipError withTag(Tag tag) {
        RelinquishFolderMembershipError relinquishFolderMembershipError = new RelinquishFolderMembershipError();
        relinquishFolderMembershipError._tag = tag;
        return relinquishFolderMembershipError;
    }

    private RelinquishFolderMembershipError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        RelinquishFolderMembershipError relinquishFolderMembershipError = new RelinquishFolderMembershipError();
        relinquishFolderMembershipError._tag = tag;
        relinquishFolderMembershipError.accessErrorValue = sharedFolderAccessError;
        return relinquishFolderMembershipError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static RelinquishFolderMembershipError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelinquishFolderMembershipError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
    }

    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isFolderOwner() {
        return this._tag == Tag.FOLDER_OWNER;
    }

    public boolean isMounted() {
        return this._tag == Tag.MOUNTED;
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

    public boolean isNoExplicitAccess() {
        return this._tag == Tag.NO_EXPLICIT_ACCESS;
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
        if (obj == null || !(obj instanceof RelinquishFolderMembershipError)) {
            return false;
        }
        RelinquishFolderMembershipError relinquishFolderMembershipError = (RelinquishFolderMembershipError) obj;
        if (this._tag != relinquishFolderMembershipError._tag) {
            return false;
        }
        switch (C42881.f729xc8d85e88[this._tag.ordinal()]) {
            case 1:
                SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
                SharedFolderAccessError sharedFolderAccessError2 = relinquishFolderMembershipError.accessErrorValue;
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

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.RelinquishFolderMembershipError$1 */
    static /* synthetic */ class C42881 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$RelinquishFolderMembershipError$Tag */
        static final /* synthetic */ int[] f729xc8d85e88;

        static {
            int[] iArr = new int[Tag.values().length];
            f729xc8d85e88 = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f729xc8d85e88[Tag.FOLDER_OWNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f729xc8d85e88[Tag.MOUNTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f729xc8d85e88[Tag.GROUP_ACCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f729xc8d85e88[Tag.TEAM_FOLDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f729xc8d85e88[Tag.NO_PERMISSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f729xc8d85e88[Tag.NO_EXPLICIT_ACCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f729xc8d85e88[Tag.OTHER.ordinal()] = 8;
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

    static class Serializer extends UnionSerializer<RelinquishFolderMembershipError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RelinquishFolderMembershipError relinquishFolderMembershipError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42881.f729xc8d85e88[relinquishFolderMembershipError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("access_error", jsonGenerator);
                    jsonGenerator.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(relinquishFolderMembershipError.accessErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeString("folder_owner");
                    break;
                case 3:
                    jsonGenerator.writeString("mounted");
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
                    jsonGenerator.writeString("no_explicit_access");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RelinquishFolderMembershipError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RelinquishFolderMembershipError relinquishFolderMembershipErrorAccessError;
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
                relinquishFolderMembershipErrorAccessError = RelinquishFolderMembershipError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("folder_owner".equals(tag)) {
                relinquishFolderMembershipErrorAccessError = RelinquishFolderMembershipError.FOLDER_OWNER;
            } else if ("mounted".equals(tag)) {
                relinquishFolderMembershipErrorAccessError = RelinquishFolderMembershipError.MOUNTED;
            } else if ("group_access".equals(tag)) {
                relinquishFolderMembershipErrorAccessError = RelinquishFolderMembershipError.GROUP_ACCESS;
            } else if ("team_folder".equals(tag)) {
                relinquishFolderMembershipErrorAccessError = RelinquishFolderMembershipError.TEAM_FOLDER;
            } else if ("no_permission".equals(tag)) {
                relinquishFolderMembershipErrorAccessError = RelinquishFolderMembershipError.NO_PERMISSION;
            } else if ("no_explicit_access".equals(tag)) {
                relinquishFolderMembershipErrorAccessError = RelinquishFolderMembershipError.NO_EXPLICIT_ACCESS;
            } else {
                relinquishFolderMembershipErrorAccessError = RelinquishFolderMembershipError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return relinquishFolderMembershipErrorAccessError;
        }
    }
}
