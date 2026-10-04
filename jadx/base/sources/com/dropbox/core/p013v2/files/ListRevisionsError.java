package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class ListRevisionsError {
    public static final ListRevisionsError OTHER = new ListRevisionsError().withTag(Tag.OTHER);
    private Tag _tag;
    private LookupError pathValue;

    public enum Tag {
        PATH,
        OTHER
    }

    private ListRevisionsError() {
    }

    private ListRevisionsError withTag(Tag tag) {
        ListRevisionsError listRevisionsError = new ListRevisionsError();
        listRevisionsError._tag = tag;
        return listRevisionsError;
    }

    private ListRevisionsError withTagAndPath(Tag tag, LookupError lookupError) {
        ListRevisionsError listRevisionsError = new ListRevisionsError();
        listRevisionsError._tag = tag;
        listRevisionsError.pathValue = lookupError;
        return listRevisionsError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static ListRevisionsError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListRevisionsError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ListRevisionsError)) {
            return false;
        }
        ListRevisionsError listRevisionsError = (ListRevisionsError) obj;
        if (this._tag != listRevisionsError._tag) {
            return false;
        }
        int i = C41701.$SwitchMap$com$dropbox$core$v2$files$ListRevisionsError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = listRevisionsError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ListRevisionsError$1 */
    static /* synthetic */ class C41701 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ListRevisionsError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ListRevisionsError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ListRevisionsError$Tag[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<ListRevisionsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListRevisionsError listRevisionsError, JsonGenerator jsonGenerator) throws IOException {
            if (C41701.$SwitchMap$com$dropbox$core$v2$files$ListRevisionsError$Tag[listRevisionsError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(listRevisionsError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListRevisionsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListRevisionsError listRevisionsErrorPath;
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
            if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                listRevisionsErrorPath = ListRevisionsError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                listRevisionsErrorPath = ListRevisionsError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listRevisionsErrorPath;
        }
    }
}
