package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharingUserError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ListFilesContinueError {
    public static final ListFilesContinueError INVALID_CURSOR = new ListFilesContinueError().withTag(Tag.INVALID_CURSOR);
    public static final ListFilesContinueError OTHER = new ListFilesContinueError().withTag(Tag.OTHER);
    private Tag _tag;
    private SharingUserError userErrorValue;

    public enum Tag {
        USER_ERROR,
        INVALID_CURSOR,
        OTHER
    }

    private ListFilesContinueError() {
    }

    private ListFilesContinueError withTag(Tag tag) {
        ListFilesContinueError listFilesContinueError = new ListFilesContinueError();
        listFilesContinueError._tag = tag;
        return listFilesContinueError;
    }

    private ListFilesContinueError withTagAndUserError(Tag tag, SharingUserError sharingUserError) {
        ListFilesContinueError listFilesContinueError = new ListFilesContinueError();
        listFilesContinueError._tag = tag;
        listFilesContinueError.userErrorValue = sharingUserError;
        return listFilesContinueError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUserError() {
        return this._tag == Tag.USER_ERROR;
    }

    public static ListFilesContinueError userError(SharingUserError sharingUserError) {
        if (sharingUserError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFilesContinueError().withTagAndUserError(Tag.USER_ERROR, sharingUserError);
    }

    public SharingUserError getUserErrorValue() {
        if (this._tag != Tag.USER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ERROR, but was Tag." + this._tag.name());
        }
        return this.userErrorValue;
    }

    public boolean isInvalidCursor() {
        return this._tag == Tag.INVALID_CURSOR;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.userErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ListFilesContinueError)) {
            return false;
        }
        ListFilesContinueError listFilesContinueError = (ListFilesContinueError) obj;
        if (this._tag != listFilesContinueError._tag) {
            return false;
        }
        int i = C42761.f724x280f7154[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        SharingUserError sharingUserError = this.userErrorValue;
        SharingUserError sharingUserError2 = listFilesContinueError.userErrorValue;
        return sharingUserError == sharingUserError2 || sharingUserError.equals(sharingUserError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ListFilesContinueError$1 */
    static /* synthetic */ class C42761 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$ListFilesContinueError$Tag */
        static final /* synthetic */ int[] f724x280f7154;

        static {
            int[] iArr = new int[Tag.values().length];
            f724x280f7154 = iArr;
            try {
                iArr[Tag.USER_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f724x280f7154[Tag.INVALID_CURSOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f724x280f7154[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<ListFilesContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListFilesContinueError listFilesContinueError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42761.f724x280f7154[listFilesContinueError.tag().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    jsonGenerator.writeString("invalid_cursor");
                    return;
                } else {
                    jsonGenerator.writeString("other");
                    return;
                }
            }
            jsonGenerator.writeStartObject();
            writeTag("user_error", jsonGenerator);
            jsonGenerator.writeFieldName("user_error");
            SharingUserError.Serializer.INSTANCE.serialize(listFilesContinueError.userErrorValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListFilesContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListFilesContinueError listFilesContinueErrorUserError;
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
                listFilesContinueErrorUserError = ListFilesContinueError.userError(SharingUserError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("invalid_cursor".equals(tag)) {
                listFilesContinueErrorUserError = ListFilesContinueError.INVALID_CURSOR;
            } else {
                listFilesContinueErrorUserError = ListFilesContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listFilesContinueErrorUserError;
        }
    }
}
