package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.PaperApiCursorError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ListUsersCursorError {
    private Tag _tag;
    private PaperApiCursorError cursorErrorValue;
    public static final ListUsersCursorError INSUFFICIENT_PERMISSIONS = new ListUsersCursorError().withTag(Tag.INSUFFICIENT_PERMISSIONS);
    public static final ListUsersCursorError OTHER = new ListUsersCursorError().withTag(Tag.OTHER);
    public static final ListUsersCursorError DOC_NOT_FOUND = new ListUsersCursorError().withTag(Tag.DOC_NOT_FOUND);

    public enum Tag {
        INSUFFICIENT_PERMISSIONS,
        OTHER,
        DOC_NOT_FOUND,
        CURSOR_ERROR
    }

    private ListUsersCursorError() {
    }

    private ListUsersCursorError withTag(Tag tag) {
        ListUsersCursorError listUsersCursorError = new ListUsersCursorError();
        listUsersCursorError._tag = tag;
        return listUsersCursorError;
    }

    private ListUsersCursorError withTagAndCursorError(Tag tag, PaperApiCursorError paperApiCursorError) {
        ListUsersCursorError listUsersCursorError = new ListUsersCursorError();
        listUsersCursorError._tag = tag;
        listUsersCursorError.cursorErrorValue = paperApiCursorError;
        return listUsersCursorError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInsufficientPermissions() {
        return this._tag == Tag.INSUFFICIENT_PERMISSIONS;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public boolean isDocNotFound() {
        return this._tag == Tag.DOC_NOT_FOUND;
    }

    public boolean isCursorError() {
        return this._tag == Tag.CURSOR_ERROR;
    }

    public static ListUsersCursorError cursorError(PaperApiCursorError paperApiCursorError) {
        if (paperApiCursorError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListUsersCursorError().withTagAndCursorError(Tag.CURSOR_ERROR, paperApiCursorError);
    }

    public PaperApiCursorError getCursorErrorValue() {
        if (this._tag != Tag.CURSOR_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.CURSOR_ERROR, but was Tag." + this._tag.name());
        }
        return this.cursorErrorValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.cursorErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUsersCursorError)) {
            return false;
        }
        ListUsersCursorError listUsersCursorError = (ListUsersCursorError) obj;
        if (this._tag != listUsersCursorError._tag) {
            return false;
        }
        int i = C42351.$SwitchMap$com$dropbox$core$v2$paper$ListUsersCursorError$Tag[this._tag.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                return false;
            }
            PaperApiCursorError paperApiCursorError = this.cursorErrorValue;
            PaperApiCursorError paperApiCursorError2 = listUsersCursorError.cursorErrorValue;
            if (paperApiCursorError != paperApiCursorError2 && !paperApiCursorError.equals(paperApiCursorError2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.ListUsersCursorError$1 */
    static /* synthetic */ class C42351 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$ListUsersCursorError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$ListUsersCursorError$Tag = iArr;
            try {
                iArr[Tag.INSUFFICIENT_PERMISSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ListUsersCursorError$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ListUsersCursorError$Tag[Tag.DOC_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ListUsersCursorError$Tag[Tag.CURSOR_ERROR.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<ListUsersCursorError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListUsersCursorError listUsersCursorError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42351.$SwitchMap$com$dropbox$core$v2$paper$ListUsersCursorError$Tag[listUsersCursorError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("insufficient_permissions");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("other");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("doc_not_found");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeStartObject();
                writeTag("cursor_error", jsonGenerator);
                jsonGenerator.writeFieldName("cursor_error");
                PaperApiCursorError.Serializer.INSTANCE.serialize(listUsersCursorError.cursorErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + listUsersCursorError.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListUsersCursorError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListUsersCursorError listUsersCursorErrorCursorError;
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
            if ("insufficient_permissions".equals(tag)) {
                listUsersCursorErrorCursorError = ListUsersCursorError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                listUsersCursorErrorCursorError = ListUsersCursorError.OTHER;
            } else if ("doc_not_found".equals(tag)) {
                listUsersCursorErrorCursorError = ListUsersCursorError.DOC_NOT_FOUND;
            } else if ("cursor_error".equals(tag)) {
                expectField("cursor_error", jsonParser);
                listUsersCursorErrorCursorError = ListUsersCursorError.cursorError(PaperApiCursorError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listUsersCursorErrorCursorError;
        }
    }
}
