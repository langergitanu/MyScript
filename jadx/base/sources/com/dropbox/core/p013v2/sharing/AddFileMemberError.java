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
public final class AddFileMemberError {
    private Tag _tag;
    private SharingFileAccessError accessErrorValue;
    private SharingUserError userErrorValue;
    public static final AddFileMemberError RATE_LIMIT = new AddFileMemberError().withTag(Tag.RATE_LIMIT);
    public static final AddFileMemberError INVALID_COMMENT = new AddFileMemberError().withTag(Tag.INVALID_COMMENT);
    public static final AddFileMemberError OTHER = new AddFileMemberError().withTag(Tag.OTHER);

    public enum Tag {
        USER_ERROR,
        ACCESS_ERROR,
        RATE_LIMIT,
        INVALID_COMMENT,
        OTHER
    }

    private AddFileMemberError() {
    }

    private AddFileMemberError withTag(Tag tag) {
        AddFileMemberError addFileMemberError = new AddFileMemberError();
        addFileMemberError._tag = tag;
        return addFileMemberError;
    }

    private AddFileMemberError withTagAndUserError(Tag tag, SharingUserError sharingUserError) {
        AddFileMemberError addFileMemberError = new AddFileMemberError();
        addFileMemberError._tag = tag;
        addFileMemberError.userErrorValue = sharingUserError;
        return addFileMemberError;
    }

    private AddFileMemberError withTagAndAccessError(Tag tag, SharingFileAccessError sharingFileAccessError) {
        AddFileMemberError addFileMemberError = new AddFileMemberError();
        addFileMemberError._tag = tag;
        addFileMemberError.accessErrorValue = sharingFileAccessError;
        return addFileMemberError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUserError() {
        return this._tag == Tag.USER_ERROR;
    }

    public static AddFileMemberError userError(SharingUserError sharingUserError) {
        if (sharingUserError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AddFileMemberError().withTagAndUserError(Tag.USER_ERROR, sharingUserError);
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

    public static AddFileMemberError accessError(SharingFileAccessError sharingFileAccessError) {
        if (sharingFileAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AddFileMemberError().withTagAndAccessError(Tag.ACCESS_ERROR, sharingFileAccessError);
    }

    public SharingFileAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isRateLimit() {
        return this._tag == Tag.RATE_LIMIT;
    }

    public boolean isInvalidComment() {
        return this._tag == Tag.INVALID_COMMENT;
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
        if (obj == null || !(obj instanceof AddFileMemberError)) {
            return false;
        }
        AddFileMemberError addFileMemberError = (AddFileMemberError) obj;
        if (this._tag != addFileMemberError._tag) {
            return false;
        }
        int i = C42491.$SwitchMap$com$dropbox$core$v2$sharing$AddFileMemberError$Tag[this._tag.ordinal()];
        if (i == 1) {
            SharingUserError sharingUserError = this.userErrorValue;
            SharingUserError sharingUserError2 = addFileMemberError.userErrorValue;
            return sharingUserError == sharingUserError2 || sharingUserError.equals(sharingUserError2);
        }
        if (i != 2) {
            return i == 3 || i == 4 || i == 5;
        }
        SharingFileAccessError sharingFileAccessError = this.accessErrorValue;
        SharingFileAccessError sharingFileAccessError2 = addFileMemberError.accessErrorValue;
        return sharingFileAccessError == sharingFileAccessError2 || sharingFileAccessError.equals(sharingFileAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.AddFileMemberError$1 */
    static /* synthetic */ class C42491 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$AddFileMemberError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$AddFileMemberError$Tag = iArr;
            try {
                iArr[Tag.USER_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFileMemberError$Tag[Tag.ACCESS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFileMemberError$Tag[Tag.RATE_LIMIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFileMemberError$Tag[Tag.INVALID_COMMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFileMemberError$Tag[Tag.OTHER.ordinal()] = 5;
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

    static class Serializer extends UnionSerializer<AddFileMemberError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AddFileMemberError addFileMemberError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42491.$SwitchMap$com$dropbox$core$v2$sharing$AddFileMemberError$Tag[addFileMemberError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("user_error", jsonGenerator);
                jsonGenerator.writeFieldName("user_error");
                SharingUserError.Serializer.INSTANCE.serialize(addFileMemberError.userErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                SharingFileAccessError.Serializer.INSTANCE.serialize(addFileMemberError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("rate_limit");
            } else if (i == 4) {
                jsonGenerator.writeString("invalid_comment");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AddFileMemberError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AddFileMemberError addFileMemberErrorAccessError;
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
                addFileMemberErrorAccessError = AddFileMemberError.userError(SharingUserError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                addFileMemberErrorAccessError = AddFileMemberError.accessError(SharingFileAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("rate_limit".equals(tag)) {
                addFileMemberErrorAccessError = AddFileMemberError.RATE_LIMIT;
            } else if ("invalid_comment".equals(tag)) {
                addFileMemberErrorAccessError = AddFileMemberError.INVALID_COMMENT;
            } else {
                addFileMemberErrorAccessError = AddFileMemberError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return addFileMemberErrorAccessError;
        }
    }
}
