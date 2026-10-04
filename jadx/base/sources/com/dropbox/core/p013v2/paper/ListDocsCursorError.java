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
public final class ListDocsCursorError {
    public static final ListDocsCursorError OTHER = new ListDocsCursorError().withTag(Tag.OTHER);
    private Tag _tag;
    private PaperApiCursorError cursorErrorValue;

    public enum Tag {
        CURSOR_ERROR,
        OTHER
    }

    private ListDocsCursorError() {
    }

    private ListDocsCursorError withTag(Tag tag) {
        ListDocsCursorError listDocsCursorError = new ListDocsCursorError();
        listDocsCursorError._tag = tag;
        return listDocsCursorError;
    }

    private ListDocsCursorError withTagAndCursorError(Tag tag, PaperApiCursorError paperApiCursorError) {
        ListDocsCursorError listDocsCursorError = new ListDocsCursorError();
        listDocsCursorError._tag = tag;
        listDocsCursorError.cursorErrorValue = paperApiCursorError;
        return listDocsCursorError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isCursorError() {
        return this._tag == Tag.CURSOR_ERROR;
    }

    public static ListDocsCursorError cursorError(PaperApiCursorError paperApiCursorError) {
        if (paperApiCursorError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListDocsCursorError().withTagAndCursorError(Tag.CURSOR_ERROR, paperApiCursorError);
    }

    public PaperApiCursorError getCursorErrorValue() {
        if (this._tag != Tag.CURSOR_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.CURSOR_ERROR, but was Tag." + this._tag.name());
        }
        return this.cursorErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.cursorErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ListDocsCursorError)) {
            return false;
        }
        ListDocsCursorError listDocsCursorError = (ListDocsCursorError) obj;
        if (this._tag != listDocsCursorError._tag) {
            return false;
        }
        int i = C42311.$SwitchMap$com$dropbox$core$v2$paper$ListDocsCursorError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        PaperApiCursorError paperApiCursorError = this.cursorErrorValue;
        PaperApiCursorError paperApiCursorError2 = listDocsCursorError.cursorErrorValue;
        return paperApiCursorError == paperApiCursorError2 || paperApiCursorError.equals(paperApiCursorError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.ListDocsCursorError$1 */
    static /* synthetic */ class C42311 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$ListDocsCursorError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$ListDocsCursorError$Tag = iArr;
            try {
                iArr[Tag.CURSOR_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ListDocsCursorError$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<ListDocsCursorError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListDocsCursorError listDocsCursorError, JsonGenerator jsonGenerator) throws IOException {
            if (C42311.$SwitchMap$com$dropbox$core$v2$paper$ListDocsCursorError$Tag[listDocsCursorError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("cursor_error", jsonGenerator);
                jsonGenerator.writeFieldName("cursor_error");
                PaperApiCursorError.Serializer.INSTANCE.serialize(listDocsCursorError.cursorErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListDocsCursorError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListDocsCursorError listDocsCursorErrorCursorError;
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
            if ("cursor_error".equals(tag)) {
                expectField("cursor_error", jsonParser);
                listDocsCursorErrorCursorError = ListDocsCursorError.cursorError(PaperApiCursorError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                listDocsCursorErrorCursorError = ListDocsCursorError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listDocsCursorErrorCursorError;
        }
    }
}
