package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.InsufficientQuotaAmounts;
import com.dropbox.core.p013v2.sharing.SharedFolderAccessError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class MountFolderError {
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    private InsufficientQuotaAmounts insufficientQuotaValue;
    public static final MountFolderError INSIDE_SHARED_FOLDER = new MountFolderError().withTag(Tag.INSIDE_SHARED_FOLDER);
    public static final MountFolderError ALREADY_MOUNTED = new MountFolderError().withTag(Tag.ALREADY_MOUNTED);
    public static final MountFolderError NO_PERMISSION = new MountFolderError().withTag(Tag.NO_PERMISSION);
    public static final MountFolderError NOT_MOUNTABLE = new MountFolderError().withTag(Tag.NOT_MOUNTABLE);
    public static final MountFolderError OTHER = new MountFolderError().withTag(Tag.OTHER);

    public enum Tag {
        ACCESS_ERROR,
        INSIDE_SHARED_FOLDER,
        INSUFFICIENT_QUOTA,
        ALREADY_MOUNTED,
        NO_PERMISSION,
        NOT_MOUNTABLE,
        OTHER
    }

    private MountFolderError() {
    }

    private MountFolderError withTag(Tag tag) {
        MountFolderError mountFolderError = new MountFolderError();
        mountFolderError._tag = tag;
        return mountFolderError;
    }

    private MountFolderError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        MountFolderError mountFolderError = new MountFolderError();
        mountFolderError._tag = tag;
        mountFolderError.accessErrorValue = sharedFolderAccessError;
        return mountFolderError;
    }

    private MountFolderError withTagAndInsufficientQuota(Tag tag, InsufficientQuotaAmounts insufficientQuotaAmounts) {
        MountFolderError mountFolderError = new MountFolderError();
        mountFolderError._tag = tag;
        mountFolderError.insufficientQuotaValue = insufficientQuotaAmounts;
        return mountFolderError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static MountFolderError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MountFolderError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
    }

    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isInsideSharedFolder() {
        return this._tag == Tag.INSIDE_SHARED_FOLDER;
    }

    public boolean isInsufficientQuota() {
        return this._tag == Tag.INSUFFICIENT_QUOTA;
    }

    public static MountFolderError insufficientQuota(InsufficientQuotaAmounts insufficientQuotaAmounts) {
        if (insufficientQuotaAmounts == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MountFolderError().withTagAndInsufficientQuota(Tag.INSUFFICIENT_QUOTA, insufficientQuotaAmounts);
    }

    public InsufficientQuotaAmounts getInsufficientQuotaValue() {
        if (this._tag != Tag.INSUFFICIENT_QUOTA) {
            throw new IllegalStateException("Invalid tag: required Tag.INSUFFICIENT_QUOTA, but was Tag." + this._tag.name());
        }
        return this.insufficientQuotaValue;
    }

    public boolean isAlreadyMounted() {
        return this._tag == Tag.ALREADY_MOUNTED;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isNotMountable() {
        return this._tag == Tag.NOT_MOUNTABLE;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue, this.insufficientQuotaValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MountFolderError)) {
            return false;
        }
        MountFolderError mountFolderError = (MountFolderError) obj;
        if (this._tag != mountFolderError._tag) {
            return false;
        }
        switch (C42841.$SwitchMap$com$dropbox$core$v2$sharing$MountFolderError$Tag[this._tag.ordinal()]) {
            case 1:
                SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
                SharedFolderAccessError sharedFolderAccessError2 = mountFolderError.accessErrorValue;
                return sharedFolderAccessError == sharedFolderAccessError2 || sharedFolderAccessError.equals(sharedFolderAccessError2);
            case 3:
                InsufficientQuotaAmounts insufficientQuotaAmounts = this.insufficientQuotaValue;
                InsufficientQuotaAmounts insufficientQuotaAmounts2 = mountFolderError.insufficientQuotaValue;
                if (insufficientQuotaAmounts != insufficientQuotaAmounts2 && !insufficientQuotaAmounts.equals(insufficientQuotaAmounts2)) {
                    return false;
                }
            case 2:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.MountFolderError$1 */
    static /* synthetic */ class C42841 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$MountFolderError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$MountFolderError$Tag = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MountFolderError$Tag[Tag.INSIDE_SHARED_FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MountFolderError$Tag[Tag.INSUFFICIENT_QUOTA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MountFolderError$Tag[Tag.ALREADY_MOUNTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MountFolderError$Tag[Tag.NO_PERMISSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MountFolderError$Tag[Tag.NOT_MOUNTABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MountFolderError$Tag[Tag.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<MountFolderError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MountFolderError mountFolderError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42841.$SwitchMap$com$dropbox$core$v2$sharing$MountFolderError$Tag[mountFolderError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("access_error", jsonGenerator);
                    jsonGenerator.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(mountFolderError.accessErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeString("inside_shared_folder");
                    break;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag("insufficient_quota", jsonGenerator);
                    InsufficientQuotaAmounts.Serializer.INSTANCE.serialize(mountFolderError.insufficientQuotaValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 4:
                    jsonGenerator.writeString("already_mounted");
                    break;
                case 5:
                    jsonGenerator.writeString("no_permission");
                    break;
                case 6:
                    jsonGenerator.writeString("not_mountable");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MountFolderError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MountFolderError mountFolderErrorInsufficientQuota;
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
                mountFolderErrorInsufficientQuota = MountFolderError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("inside_shared_folder".equals(tag)) {
                mountFolderErrorInsufficientQuota = MountFolderError.INSIDE_SHARED_FOLDER;
            } else if ("insufficient_quota".equals(tag)) {
                mountFolderErrorInsufficientQuota = MountFolderError.insufficientQuota(InsufficientQuotaAmounts.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("already_mounted".equals(tag)) {
                mountFolderErrorInsufficientQuota = MountFolderError.ALREADY_MOUNTED;
            } else if ("no_permission".equals(tag)) {
                mountFolderErrorInsufficientQuota = MountFolderError.NO_PERMISSION;
            } else if ("not_mountable".equals(tag)) {
                mountFolderErrorInsufficientQuota = MountFolderError.NOT_MOUNTABLE;
            } else {
                mountFolderErrorInsufficientQuota = MountFolderError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return mountFolderErrorInsufficientQuota;
        }
    }
}
