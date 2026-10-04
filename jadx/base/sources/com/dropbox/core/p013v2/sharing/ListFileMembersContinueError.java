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
public final class ListFileMembersContinueError {
    public static final ListFileMembersContinueError INVALID_CURSOR = new ListFileMembersContinueError().withTag(Tag.INVALID_CURSOR);
    public static final ListFileMembersContinueError OTHER = new ListFileMembersContinueError().withTag(Tag.OTHER);
    private Tag _tag;
    private SharingFileAccessError accessErrorValue;
    private SharingUserError userErrorValue;

    public enum Tag {
        USER_ERROR,
        ACCESS_ERROR,
        INVALID_CURSOR,
        OTHER
    }

    private ListFileMembersContinueError() {
    }

    private ListFileMembersContinueError withTag(Tag tag) {
        ListFileMembersContinueError listFileMembersContinueError = new ListFileMembersContinueError();
        listFileMembersContinueError._tag = tag;
        return listFileMembersContinueError;
    }

    private ListFileMembersContinueError withTagAndUserError(Tag tag, SharingUserError sharingUserError) {
        ListFileMembersContinueError listFileMembersContinueError = new ListFileMembersContinueError();
        listFileMembersContinueError._tag = tag;
        listFileMembersContinueError.userErrorValue = sharingUserError;
        return listFileMembersContinueError;
    }

    private ListFileMembersContinueError withTagAndAccessError(Tag tag, SharingFileAccessError sharingFileAccessError) {
        ListFileMembersContinueError listFileMembersContinueError = new ListFileMembersContinueError();
        listFileMembersContinueError._tag = tag;
        listFileMembersContinueError.accessErrorValue = sharingFileAccessError;
        return listFileMembersContinueError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUserError() {
        return this._tag == Tag.USER_ERROR;
    }

    public static ListFileMembersContinueError userError(SharingUserError sharingUserError) {
        if (sharingUserError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFileMembersContinueError().withTagAndUserError(Tag.USER_ERROR, sharingUserError);
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

    public static ListFileMembersContinueError accessError(SharingFileAccessError sharingFileAccessError) {
        if (sharingFileAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFileMembersContinueError().withTagAndAccessError(Tag.ACCESS_ERROR, sharingFileAccessError);
    }

    public SharingFileAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isInvalidCursor() {
        return this._tag == Tag.INVALID_CURSOR;
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
        if (obj == null || !(obj instanceof ListFileMembersContinueError)) {
            return false;
        }
        ListFileMembersContinueError listFileMembersContinueError = (ListFileMembersContinueError) obj;
        if (this._tag != listFileMembersContinueError._tag) {
            return false;
        }
        int i = C42731.f722xbb05818e[this._tag.ordinal()];
        if (i == 1) {
            SharingUserError sharingUserError = this.userErrorValue;
            SharingUserError sharingUserError2 = listFileMembersContinueError.userErrorValue;
            return sharingUserError == sharingUserError2 || sharingUserError.equals(sharingUserError2);
        }
        if (i != 2) {
            return i == 3 || i == 4;
        }
        SharingFileAccessError sharingFileAccessError = this.accessErrorValue;
        SharingFileAccessError sharingFileAccessError2 = listFileMembersContinueError.accessErrorValue;
        return sharingFileAccessError == sharingFileAccessError2 || sharingFileAccessError.equals(sharingFileAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ListFileMembersContinueError$1 */
    static /* synthetic */ class C42731 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$ListFileMembersContinueError$Tag */
        static final /* synthetic */ int[] f722xbb05818e;

        static {
            int[] iArr = new int[Tag.values().length];
            f722xbb05818e = iArr;
            try {
                iArr[Tag.USER_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f722xbb05818e[Tag.ACCESS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f722xbb05818e[Tag.INVALID_CURSOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f722xbb05818e[Tag.OTHER.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<ListFileMembersContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListFileMembersContinueError listFileMembersContinueError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42731.f722xbb05818e[listFileMembersContinueError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("user_error", jsonGenerator);
                jsonGenerator.writeFieldName("user_error");
                SharingUserError.Serializer.INSTANCE.serialize(listFileMembersContinueError.userErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    jsonGenerator.writeString("invalid_cursor");
                    return;
                } else {
                    jsonGenerator.writeString("other");
                    return;
                }
            }
            jsonGenerator.writeStartObject();
            writeTag("access_error", jsonGenerator);
            jsonGenerator.writeFieldName("access_error");
            SharingFileAccessError.Serializer.INSTANCE.serialize(listFileMembersContinueError.accessErrorValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListFileMembersContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListFileMembersContinueError listFileMembersContinueErrorAccessError;
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
                listFileMembersContinueErrorAccessError = ListFileMembersContinueError.userError(SharingUserError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                listFileMembersContinueErrorAccessError = ListFileMembersContinueError.accessError(SharingFileAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("invalid_cursor".equals(tag)) {
                listFileMembersContinueErrorAccessError = ListFileMembersContinueError.INVALID_CURSOR;
            } else {
                listFileMembersContinueErrorAccessError = ListFileMembersContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listFileMembersContinueErrorAccessError;
        }
    }
}
