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
public final class SetAccessInheritanceError {
    public static final SetAccessInheritanceError NO_PERMISSION = new SetAccessInheritanceError().withTag(Tag.NO_PERMISSION);
    public static final SetAccessInheritanceError OTHER = new SetAccessInheritanceError().withTag(Tag.OTHER);
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;

    public enum Tag {
        ACCESS_ERROR,
        NO_PERMISSION,
        OTHER
    }

    private SetAccessInheritanceError() {
    }

    private SetAccessInheritanceError withTag(Tag tag) {
        SetAccessInheritanceError setAccessInheritanceError = new SetAccessInheritanceError();
        setAccessInheritanceError._tag = tag;
        return setAccessInheritanceError;
    }

    private SetAccessInheritanceError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        SetAccessInheritanceError setAccessInheritanceError = new SetAccessInheritanceError();
        setAccessInheritanceError._tag = tag;
        setAccessInheritanceError.accessErrorValue = sharedFolderAccessError;
        return setAccessInheritanceError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static SetAccessInheritanceError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SetAccessInheritanceError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
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
        if (obj == null || !(obj instanceof SetAccessInheritanceError)) {
            return false;
        }
        SetAccessInheritanceError setAccessInheritanceError = (SetAccessInheritanceError) obj;
        if (this._tag != setAccessInheritanceError._tag) {
            return false;
        }
        int i = C42961.f731x6b3ca824[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
        SharedFolderAccessError sharedFolderAccessError2 = setAccessInheritanceError.accessErrorValue;
        return sharedFolderAccessError == sharedFolderAccessError2 || sharedFolderAccessError.equals(sharedFolderAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SetAccessInheritanceError$1 */
    static /* synthetic */ class C42961 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$SetAccessInheritanceError$Tag */
        static final /* synthetic */ int[] f731x6b3ca824;

        static {
            int[] iArr = new int[Tag.values().length];
            f731x6b3ca824 = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f731x6b3ca824[Tag.NO_PERMISSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f731x6b3ca824[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<SetAccessInheritanceError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SetAccessInheritanceError setAccessInheritanceError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42961.f731x6b3ca824[setAccessInheritanceError.tag().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    jsonGenerator.writeString("no_permission");
                    return;
                } else {
                    jsonGenerator.writeString("other");
                    return;
                }
            }
            jsonGenerator.writeStartObject();
            writeTag("access_error", jsonGenerator);
            jsonGenerator.writeFieldName("access_error");
            SharedFolderAccessError.Serializer.INSTANCE.serialize(setAccessInheritanceError.accessErrorValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SetAccessInheritanceError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SetAccessInheritanceError setAccessInheritanceErrorAccessError;
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
                setAccessInheritanceErrorAccessError = SetAccessInheritanceError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("no_permission".equals(tag)) {
                setAccessInheritanceErrorAccessError = SetAccessInheritanceError.NO_PERMISSION;
            } else {
                setAccessInheritanceErrorAccessError = SetAccessInheritanceError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return setAccessInheritanceErrorAccessError;
        }
    }
}
