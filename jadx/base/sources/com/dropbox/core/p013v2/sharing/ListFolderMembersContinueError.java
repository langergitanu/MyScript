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
public final class ListFolderMembersContinueError {
    public static final ListFolderMembersContinueError INVALID_CURSOR = new ListFolderMembersContinueError().withTag(Tag.INVALID_CURSOR);
    public static final ListFolderMembersContinueError OTHER = new ListFolderMembersContinueError().withTag(Tag.OTHER);
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;

    public enum Tag {
        ACCESS_ERROR,
        INVALID_CURSOR,
        OTHER
    }

    private ListFolderMembersContinueError() {
    }

    private ListFolderMembersContinueError withTag(Tag tag) {
        ListFolderMembersContinueError listFolderMembersContinueError = new ListFolderMembersContinueError();
        listFolderMembersContinueError._tag = tag;
        return listFolderMembersContinueError;
    }

    private ListFolderMembersContinueError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        ListFolderMembersContinueError listFolderMembersContinueError = new ListFolderMembersContinueError();
        listFolderMembersContinueError._tag = tag;
        listFolderMembersContinueError.accessErrorValue = sharedFolderAccessError;
        return listFolderMembersContinueError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static ListFolderMembersContinueError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFolderMembersContinueError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
    }

    public SharedFolderAccessError getAccessErrorValue() {
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
        return Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ListFolderMembersContinueError)) {
            return false;
        }
        ListFolderMembersContinueError listFolderMembersContinueError = (ListFolderMembersContinueError) obj;
        if (this._tag != listFolderMembersContinueError._tag) {
            return false;
        }
        int i = C42771.f725xff423d80[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
        SharedFolderAccessError sharedFolderAccessError2 = listFolderMembersContinueError.accessErrorValue;
        return sharedFolderAccessError == sharedFolderAccessError2 || sharedFolderAccessError.equals(sharedFolderAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ListFolderMembersContinueError$1 */
    static /* synthetic */ class C42771 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$ListFolderMembersContinueError$Tag */
        static final /* synthetic */ int[] f725xff423d80;

        static {
            int[] iArr = new int[Tag.values().length];
            f725xff423d80 = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f725xff423d80[Tag.INVALID_CURSOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f725xff423d80[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<ListFolderMembersContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListFolderMembersContinueError listFolderMembersContinueError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42771.f725xff423d80[listFolderMembersContinueError.tag().ordinal()];
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
            writeTag("access_error", jsonGenerator);
            jsonGenerator.writeFieldName("access_error");
            SharedFolderAccessError.Serializer.INSTANCE.serialize(listFolderMembersContinueError.accessErrorValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListFolderMembersContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListFolderMembersContinueError listFolderMembersContinueErrorAccessError;
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
                listFolderMembersContinueErrorAccessError = ListFolderMembersContinueError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("invalid_cursor".equals(tag)) {
                listFolderMembersContinueErrorAccessError = ListFolderMembersContinueError.INVALID_CURSOR;
            } else {
                listFolderMembersContinueErrorAccessError = ListFolderMembersContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listFolderMembersContinueErrorAccessError;
        }
    }
}
