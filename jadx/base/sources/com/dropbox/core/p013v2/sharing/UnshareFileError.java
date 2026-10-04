package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharingFileAccessError;
import com.dropbox.core.p013v2.sharing.SharingUserError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class UnshareFileError {
    public static final UnshareFileError OTHER = new UnshareFileError().withTag(Tag.OTHER);
    private Tag _tag;
    private SharingFileAccessError accessErrorValue;
    private SharingUserError userErrorValue;

    public enum Tag {
        USER_ERROR,
        ACCESS_ERROR,
        OTHER
    }

    private UnshareFileError() {
    }

    private UnshareFileError withTag(Tag tag) {
        UnshareFileError unshareFileError = new UnshareFileError();
        unshareFileError._tag = tag;
        return unshareFileError;
    }

    private UnshareFileError withTagAndUserError(Tag tag, SharingUserError sharingUserError) {
        UnshareFileError unshareFileError = new UnshareFileError();
        unshareFileError._tag = tag;
        unshareFileError.userErrorValue = sharingUserError;
        return unshareFileError;
    }

    private UnshareFileError withTagAndAccessError(Tag tag, SharingFileAccessError sharingFileAccessError) {
        UnshareFileError unshareFileError = new UnshareFileError();
        unshareFileError._tag = tag;
        unshareFileError.accessErrorValue = sharingFileAccessError;
        return unshareFileError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUserError() {
        return this._tag == Tag.USER_ERROR;
    }

    public static UnshareFileError userError(SharingUserError sharingUserError) {
        if (sharingUserError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UnshareFileError().withTagAndUserError(Tag.USER_ERROR, sharingUserError);
    }

    public SharingUserError getUserErrorValue() {
        if (this._tag != Tag.USER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ERROR, but was Tag." + this._tag.name());
        }
        return this.userErrorValue;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static UnshareFileError accessError(SharingFileAccessError sharingFileAccessError) {
        if (sharingFileAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UnshareFileError().withTagAndAccessError(Tag.ACCESS_ERROR, sharingFileAccessError);
    }

    public SharingFileAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.userErrorValue, this.accessErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UnshareFileError)) {
            return false;
        }
        UnshareFileError unshareFileError = (UnshareFileError) obj;
        if (this._tag != unshareFileError._tag) {
            return false;
        }
        int i = C43121.$SwitchMap$com$dropbox$core$v2$sharing$UnshareFileError$Tag[this._tag.ordinal()];
        if (i == 1) {
            SharingUserError sharingUserError = this.userErrorValue;
            SharingUserError sharingUserError2 = unshareFileError.userErrorValue;
            return sharingUserError == sharingUserError2 || sharingUserError.equals(sharingUserError2);
        }
        if (i != 2) {
            return i == 3;
        }
        SharingFileAccessError sharingFileAccessError = this.accessErrorValue;
        SharingFileAccessError sharingFileAccessError2 = unshareFileError.accessErrorValue;
        return sharingFileAccessError == sharingFileAccessError2 || sharingFileAccessError.equals(sharingFileAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.UnshareFileError$1 */
    static /* synthetic */ class C43121 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$UnshareFileError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$UnshareFileError$Tag = iArr;
            try {
                iArr[Tag.USER_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$UnshareFileError$Tag[Tag.ACCESS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$UnshareFileError$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<UnshareFileError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UnshareFileError unshareFileError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43121.$SwitchMap$com$dropbox$core$v2$sharing$UnshareFileError$Tag[unshareFileError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("user_error", jsonGenerator);
                jsonGenerator.writeFieldName("user_error");
                SharingUserError.Serializer.INSTANCE.serialize(unshareFileError.userErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                SharingFileAccessError.Serializer.INSTANCE.serialize(unshareFileError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UnshareFileError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UnshareFileError unshareFileErrorAccessError;
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
            if ("user_error".equals(tag)) {
                expectField("user_error", jsonParser);
                unshareFileErrorAccessError = UnshareFileError.userError(SharingUserError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                unshareFileErrorAccessError = UnshareFileError.accessError(SharingFileAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                unshareFileErrorAccessError = UnshareFileError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return unshareFileErrorAccessError;
        }
    }
}
