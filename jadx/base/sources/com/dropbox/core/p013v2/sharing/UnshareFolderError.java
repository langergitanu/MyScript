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
public final class UnshareFolderError {
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    public static final UnshareFolderError TEAM_FOLDER = new UnshareFolderError().withTag(Tag.TEAM_FOLDER);
    public static final UnshareFolderError NO_PERMISSION = new UnshareFolderError().withTag(Tag.NO_PERMISSION);
    public static final UnshareFolderError TOO_MANY_FILES = new UnshareFolderError().withTag(Tag.TOO_MANY_FILES);
    public static final UnshareFolderError OTHER = new UnshareFolderError().withTag(Tag.OTHER);

    public enum Tag {
        ACCESS_ERROR,
        TEAM_FOLDER,
        NO_PERMISSION,
        TOO_MANY_FILES,
        OTHER
    }

    private UnshareFolderError() {
    }

    private UnshareFolderError withTag(Tag tag) {
        UnshareFolderError unshareFolderError = new UnshareFolderError();
        unshareFolderError._tag = tag;
        return unshareFolderError;
    }

    private UnshareFolderError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        UnshareFolderError unshareFolderError = new UnshareFolderError();
        unshareFolderError._tag = tag;
        unshareFolderError.accessErrorValue = sharedFolderAccessError;
        return unshareFolderError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static UnshareFolderError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UnshareFolderError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
    }

    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
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
        return Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UnshareFolderError)) {
            return false;
        }
        UnshareFolderError unshareFolderError = (UnshareFolderError) obj;
        if (this._tag != unshareFolderError._tag) {
            return false;
        }
        int i = C43131.$SwitchMap$com$dropbox$core$v2$sharing$UnshareFolderError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4 || i == 5;
        }
        SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
        SharedFolderAccessError sharedFolderAccessError2 = unshareFolderError.accessErrorValue;
        return sharedFolderAccessError == sharedFolderAccessError2 || sharedFolderAccessError.equals(sharedFolderAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.UnshareFolderError$1 */
    static /* synthetic */ class C43131 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$UnshareFolderError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$UnshareFolderError$Tag = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$UnshareFolderError$Tag[Tag.TEAM_FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$UnshareFolderError$Tag[Tag.NO_PERMISSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$UnshareFolderError$Tag[Tag.TOO_MANY_FILES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$UnshareFolderError$Tag[Tag.OTHER.ordinal()] = 5;
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

    static class Serializer extends UnionSerializer<UnshareFolderError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UnshareFolderError unshareFolderError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43131.$SwitchMap$com$dropbox$core$v2$sharing$UnshareFolderError$Tag[unshareFolderError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                SharedFolderAccessError.Serializer.INSTANCE.serialize(unshareFolderError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("team_folder");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("no_permission");
            } else if (i == 4) {
                jsonGenerator.writeString("too_many_files");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UnshareFolderError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UnshareFolderError unshareFolderErrorAccessError;
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
                unshareFolderErrorAccessError = UnshareFolderError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("team_folder".equals(tag)) {
                unshareFolderErrorAccessError = UnshareFolderError.TEAM_FOLDER;
            } else if ("no_permission".equals(tag)) {
                unshareFolderErrorAccessError = UnshareFolderError.NO_PERMISSION;
            } else if ("too_many_files".equals(tag)) {
                unshareFolderErrorAccessError = UnshareFolderError.TOO_MANY_FILES;
            } else {
                unshareFolderErrorAccessError = UnshareFolderError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return unshareFolderErrorAccessError;
        }
    }
}
