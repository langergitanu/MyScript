package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedFolderMetadata;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class SharePathError {
    private Tag _tag;
    private SharedFolderMetadata alreadySharedValue;
    public static final SharePathError IS_FILE = new SharePathError().withTag(Tag.IS_FILE);
    public static final SharePathError INSIDE_SHARED_FOLDER = new SharePathError().withTag(Tag.INSIDE_SHARED_FOLDER);
    public static final SharePathError CONTAINS_SHARED_FOLDER = new SharePathError().withTag(Tag.CONTAINS_SHARED_FOLDER);
    public static final SharePathError CONTAINS_APP_FOLDER = new SharePathError().withTag(Tag.CONTAINS_APP_FOLDER);
    public static final SharePathError CONTAINS_TEAM_FOLDER = new SharePathError().withTag(Tag.CONTAINS_TEAM_FOLDER);
    public static final SharePathError IS_APP_FOLDER = new SharePathError().withTag(Tag.IS_APP_FOLDER);
    public static final SharePathError INSIDE_APP_FOLDER = new SharePathError().withTag(Tag.INSIDE_APP_FOLDER);
    public static final SharePathError IS_PUBLIC_FOLDER = new SharePathError().withTag(Tag.IS_PUBLIC_FOLDER);
    public static final SharePathError INSIDE_PUBLIC_FOLDER = new SharePathError().withTag(Tag.INSIDE_PUBLIC_FOLDER);
    public static final SharePathError INVALID_PATH = new SharePathError().withTag(Tag.INVALID_PATH);
    public static final SharePathError IS_OSX_PACKAGE = new SharePathError().withTag(Tag.IS_OSX_PACKAGE);
    public static final SharePathError INSIDE_OSX_PACKAGE = new SharePathError().withTag(Tag.INSIDE_OSX_PACKAGE);
    public static final SharePathError IS_VAULT = new SharePathError().withTag(Tag.IS_VAULT);
    public static final SharePathError IS_VAULT_LOCKED = new SharePathError().withTag(Tag.IS_VAULT_LOCKED);
    public static final SharePathError IS_FAMILY = new SharePathError().withTag(Tag.IS_FAMILY);
    public static final SharePathError OTHER = new SharePathError().withTag(Tag.OTHER);

    public enum Tag {
        IS_FILE,
        INSIDE_SHARED_FOLDER,
        CONTAINS_SHARED_FOLDER,
        CONTAINS_APP_FOLDER,
        CONTAINS_TEAM_FOLDER,
        IS_APP_FOLDER,
        INSIDE_APP_FOLDER,
        IS_PUBLIC_FOLDER,
        INSIDE_PUBLIC_FOLDER,
        ALREADY_SHARED,
        INVALID_PATH,
        IS_OSX_PACKAGE,
        INSIDE_OSX_PACKAGE,
        IS_VAULT,
        IS_VAULT_LOCKED,
        IS_FAMILY,
        OTHER
    }

    private SharePathError() {
    }

    private SharePathError withTag(Tag tag) {
        SharePathError sharePathError = new SharePathError();
        sharePathError._tag = tag;
        return sharePathError;
    }

    private SharePathError withTagAndAlreadyShared(Tag tag, SharedFolderMetadata sharedFolderMetadata) {
        SharePathError sharePathError = new SharePathError();
        sharePathError._tag = tag;
        sharePathError.alreadySharedValue = sharedFolderMetadata;
        return sharePathError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isIsFile() {
        return this._tag == Tag.IS_FILE;
    }

    public boolean isInsideSharedFolder() {
        return this._tag == Tag.INSIDE_SHARED_FOLDER;
    }

    public boolean isContainsSharedFolder() {
        return this._tag == Tag.CONTAINS_SHARED_FOLDER;
    }

    public boolean isContainsAppFolder() {
        return this._tag == Tag.CONTAINS_APP_FOLDER;
    }

    public boolean isContainsTeamFolder() {
        return this._tag == Tag.CONTAINS_TEAM_FOLDER;
    }

    public boolean isIsAppFolder() {
        return this._tag == Tag.IS_APP_FOLDER;
    }

    public boolean isInsideAppFolder() {
        return this._tag == Tag.INSIDE_APP_FOLDER;
    }

    public boolean isIsPublicFolder() {
        return this._tag == Tag.IS_PUBLIC_FOLDER;
    }

    public boolean isInsidePublicFolder() {
        return this._tag == Tag.INSIDE_PUBLIC_FOLDER;
    }

    public boolean isAlreadyShared() {
        return this._tag == Tag.ALREADY_SHARED;
    }

    public static SharePathError alreadyShared(SharedFolderMetadata sharedFolderMetadata) {
        if (sharedFolderMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharePathError().withTagAndAlreadyShared(Tag.ALREADY_SHARED, sharedFolderMetadata);
    }

    public SharedFolderMetadata getAlreadySharedValue() {
        if (this._tag != Tag.ALREADY_SHARED) {
            throw new IllegalStateException("Invalid tag: required Tag.ALREADY_SHARED, but was Tag." + this._tag.name());
        }
        return this.alreadySharedValue;
    }

    public boolean isInvalidPath() {
        return this._tag == Tag.INVALID_PATH;
    }

    public boolean isIsOsxPackage() {
        return this._tag == Tag.IS_OSX_PACKAGE;
    }

    public boolean isInsideOsxPackage() {
        return this._tag == Tag.INSIDE_OSX_PACKAGE;
    }

    public boolean isIsVault() {
        return this._tag == Tag.IS_VAULT;
    }

    public boolean isIsVaultLocked() {
        return this._tag == Tag.IS_VAULT_LOCKED;
    }

    public boolean isIsFamily() {
        return this._tag == Tag.IS_FAMILY;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.alreadySharedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof SharePathError)) {
            return false;
        }
        SharePathError sharePathError = (SharePathError) obj;
        if (this._tag != sharePathError._tag) {
            return false;
        }
        switch (C43001.$SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[this._tag.ordinal()]) {
            case 10:
                SharedFolderMetadata sharedFolderMetadata = this.alreadySharedValue;
                SharedFolderMetadata sharedFolderMetadata2 = sharePathError.alreadySharedValue;
                if (sharedFolderMetadata != sharedFolderMetadata2 && !sharedFolderMetadata.equals(sharedFolderMetadata2)) {
                    return false;
                }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SharePathError$1 */
    static /* synthetic */ class C43001 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag = iArr;
            try {
                iArr[Tag.IS_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.INSIDE_SHARED_FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.CONTAINS_SHARED_FOLDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.CONTAINS_APP_FOLDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.CONTAINS_TEAM_FOLDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.IS_APP_FOLDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.INSIDE_APP_FOLDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.IS_PUBLIC_FOLDER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.INSIDE_PUBLIC_FOLDER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.ALREADY_SHARED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.INVALID_PATH.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.IS_OSX_PACKAGE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.INSIDE_OSX_PACKAGE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.IS_VAULT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.IS_VAULT_LOCKED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.IS_FAMILY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[Tag.OTHER.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<SharePathError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharePathError sharePathError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43001.$SwitchMap$com$dropbox$core$v2$sharing$SharePathError$Tag[sharePathError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeString("is_file");
                    break;
                case 2:
                    jsonGenerator.writeString("inside_shared_folder");
                    break;
                case 3:
                    jsonGenerator.writeString("contains_shared_folder");
                    break;
                case 4:
                    jsonGenerator.writeString("contains_app_folder");
                    break;
                case 5:
                    jsonGenerator.writeString("contains_team_folder");
                    break;
                case 6:
                    jsonGenerator.writeString("is_app_folder");
                    break;
                case 7:
                    jsonGenerator.writeString("inside_app_folder");
                    break;
                case 8:
                    jsonGenerator.writeString("is_public_folder");
                    break;
                case 9:
                    jsonGenerator.writeString("inside_public_folder");
                    break;
                case 10:
                    jsonGenerator.writeStartObject();
                    writeTag("already_shared", jsonGenerator);
                    SharedFolderMetadata.Serializer.INSTANCE.serialize(sharePathError.alreadySharedValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 11:
                    jsonGenerator.writeString("invalid_path");
                    break;
                case 12:
                    jsonGenerator.writeString("is_osx_package");
                    break;
                case 13:
                    jsonGenerator.writeString("inside_osx_package");
                    break;
                case 14:
                    jsonGenerator.writeString("is_vault");
                    break;
                case 15:
                    jsonGenerator.writeString("is_vault_locked");
                    break;
                case 16:
                    jsonGenerator.writeString("is_family");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharePathError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharePathError sharePathErrorAlreadyShared;
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
            if ("is_file".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.IS_FILE;
            } else if ("inside_shared_folder".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.INSIDE_SHARED_FOLDER;
            } else if ("contains_shared_folder".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.CONTAINS_SHARED_FOLDER;
            } else if ("contains_app_folder".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.CONTAINS_APP_FOLDER;
            } else if ("contains_team_folder".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.CONTAINS_TEAM_FOLDER;
            } else if ("is_app_folder".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.IS_APP_FOLDER;
            } else if ("inside_app_folder".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.INSIDE_APP_FOLDER;
            } else if ("is_public_folder".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.IS_PUBLIC_FOLDER;
            } else if ("inside_public_folder".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.INSIDE_PUBLIC_FOLDER;
            } else if ("already_shared".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.alreadyShared(SharedFolderMetadata.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("invalid_path".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.INVALID_PATH;
            } else if ("is_osx_package".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.IS_OSX_PACKAGE;
            } else if ("inside_osx_package".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.INSIDE_OSX_PACKAGE;
            } else if ("is_vault".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.IS_VAULT;
            } else if ("is_vault_locked".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.IS_VAULT_LOCKED;
            } else if ("is_family".equals(tag)) {
                sharePathErrorAlreadyShared = SharePathError.IS_FAMILY;
            } else {
                sharePathErrorAlreadyShared = SharePathError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharePathErrorAlreadyShared;
        }
    }
}
