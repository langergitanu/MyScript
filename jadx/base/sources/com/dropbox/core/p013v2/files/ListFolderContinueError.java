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
public final class ListFolderContinueError {
    private Tag _tag;
    private LookupError pathValue;
    public static final ListFolderContinueError RESET = new ListFolderContinueError().withTag(Tag.RESET);
    public static final ListFolderContinueError OTHER = new ListFolderContinueError().withTag(Tag.OTHER);

    public enum Tag {
        PATH,
        RESET,
        OTHER
    }

    private ListFolderContinueError() {
    }

    private ListFolderContinueError withTag(Tag tag) {
        ListFolderContinueError listFolderContinueError = new ListFolderContinueError();
        listFolderContinueError._tag = tag;
        return listFolderContinueError;
    }

    private ListFolderContinueError withTagAndPath(Tag tag, LookupError lookupError) {
        ListFolderContinueError listFolderContinueError = new ListFolderContinueError();
        listFolderContinueError._tag = tag;
        listFolderContinueError.pathValue = lookupError;
        return listFolderContinueError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static ListFolderContinueError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFolderContinueError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isReset() {
        return this._tag == Tag.RESET;
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
        if (obj == null || !(obj instanceof ListFolderContinueError)) {
            return false;
        }
        ListFolderContinueError listFolderContinueError = (ListFolderContinueError) obj;
        if (this._tag != listFolderContinueError._tag) {
            return false;
        }
        int i = C41671.$SwitchMap$com$dropbox$core$v2$files$ListFolderContinueError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = listFolderContinueError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ListFolderContinueError$1 */
    static /* synthetic */ class C41671 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ListFolderContinueError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ListFolderContinueError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ListFolderContinueError$Tag[Tag.RESET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$ListFolderContinueError$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<ListFolderContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListFolderContinueError listFolderContinueError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41671.$SwitchMap$com$dropbox$core$v2$files$ListFolderContinueError$Tag[listFolderContinueError.tag().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    jsonGenerator.writeString("reset");
                    return;
                } else {
                    jsonGenerator.writeString("other");
                    return;
                }
            }
            jsonGenerator.writeStartObject();
            writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            LookupError.Serializer.INSTANCE.serialize(listFolderContinueError.pathValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListFolderContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListFolderContinueError listFolderContinueErrorPath;
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
                listFolderContinueErrorPath = ListFolderContinueError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("reset".equals(tag)) {
                listFolderContinueErrorPath = ListFolderContinueError.RESET;
            } else {
                listFolderContinueErrorPath = ListFolderContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listFolderContinueErrorPath;
        }
    }
}
