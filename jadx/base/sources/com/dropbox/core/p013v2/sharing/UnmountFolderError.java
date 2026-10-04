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
public final class UnmountFolderError {
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    public static final UnmountFolderError NO_PERMISSION = new UnmountFolderError().withTag(Tag.NO_PERMISSION);
    public static final UnmountFolderError NOT_UNMOUNTABLE = new UnmountFolderError().withTag(Tag.NOT_UNMOUNTABLE);
    public static final UnmountFolderError OTHER = new UnmountFolderError().withTag(Tag.OTHER);

    public enum Tag {
        ACCESS_ERROR,
        NO_PERMISSION,
        NOT_UNMOUNTABLE,
        OTHER
    }

    private UnmountFolderError() {
    }

    private UnmountFolderError withTag(Tag tag) {
        UnmountFolderError unmountFolderError = new UnmountFolderError();
        unmountFolderError._tag = tag;
        return unmountFolderError;
    }

    private UnmountFolderError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        UnmountFolderError unmountFolderError = new UnmountFolderError();
        unmountFolderError._tag = tag;
        unmountFolderError.accessErrorValue = sharedFolderAccessError;
        return unmountFolderError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static UnmountFolderError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UnmountFolderError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
    }

    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isNotUnmountable() {
        return this._tag == Tag.NOT_UNMOUNTABLE;
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
        if (obj == null || !(obj instanceof UnmountFolderError)) {
            return false;
        }
        UnmountFolderError unmountFolderError = (UnmountFolderError) obj;
        if (this._tag != unmountFolderError._tag) {
            return false;
        }
        int i = C43111.$SwitchMap$com$dropbox$core$v2$sharing$UnmountFolderError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4;
        }
        SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
        SharedFolderAccessError sharedFolderAccessError2 = unmountFolderError.accessErrorValue;
        return sharedFolderAccessError == sharedFolderAccessError2 || sharedFolderAccessError.equals(sharedFolderAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.UnmountFolderError$1 */
    static /* synthetic */ class C43111 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$UnmountFolderError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$UnmountFolderError$Tag = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$UnmountFolderError$Tag[Tag.NO_PERMISSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$UnmountFolderError$Tag[Tag.NOT_UNMOUNTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$UnmountFolderError$Tag[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<UnmountFolderError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UnmountFolderError unmountFolderError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43111.$SwitchMap$com$dropbox$core$v2$sharing$UnmountFolderError$Tag[unmountFolderError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                SharedFolderAccessError.Serializer.INSTANCE.serialize(unmountFolderError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("no_permission");
            } else if (i == 3) {
                jsonGenerator.writeString("not_unmountable");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UnmountFolderError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UnmountFolderError unmountFolderErrorAccessError;
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
                unmountFolderErrorAccessError = UnmountFolderError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("no_permission".equals(tag)) {
                unmountFolderErrorAccessError = UnmountFolderError.NO_PERMISSION;
            } else if ("not_unmountable".equals(tag)) {
                unmountFolderErrorAccessError = UnmountFolderError.NOT_UNMOUNTABLE;
            } else {
                unmountFolderErrorAccessError = UnmountFolderError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return unmountFolderErrorAccessError;
        }
    }
}
