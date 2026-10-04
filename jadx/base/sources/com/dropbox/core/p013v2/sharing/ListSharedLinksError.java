package com.dropbox.core.p013v2.sharing;

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
public final class ListSharedLinksError {
    private Tag _tag;
    private LookupError pathValue;
    public static final ListSharedLinksError RESET = new ListSharedLinksError().withTag(Tag.RESET);
    public static final ListSharedLinksError OTHER = new ListSharedLinksError().withTag(Tag.OTHER);

    public enum Tag {
        PATH,
        RESET,
        OTHER
    }

    private ListSharedLinksError() {
    }

    private ListSharedLinksError withTag(Tag tag) {
        ListSharedLinksError listSharedLinksError = new ListSharedLinksError();
        listSharedLinksError._tag = tag;
        return listSharedLinksError;
    }

    private ListSharedLinksError withTagAndPath(Tag tag, LookupError lookupError) {
        ListSharedLinksError listSharedLinksError = new ListSharedLinksError();
        listSharedLinksError._tag = tag;
        listSharedLinksError.pathValue = lookupError;
        return listSharedLinksError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static ListSharedLinksError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListSharedLinksError().withTagAndPath(Tag.PATH, lookupError);
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
        if (obj == null || !(obj instanceof ListSharedLinksError)) {
            return false;
        }
        ListSharedLinksError listSharedLinksError = (ListSharedLinksError) obj;
        if (this._tag != listSharedLinksError._tag) {
            return false;
        }
        int i = C42791.$SwitchMap$com$dropbox$core$v2$sharing$ListSharedLinksError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = listSharedLinksError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ListSharedLinksError$1 */
    static /* synthetic */ class C42791 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$ListSharedLinksError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$ListSharedLinksError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ListSharedLinksError$Tag[Tag.RESET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ListSharedLinksError$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<ListSharedLinksError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListSharedLinksError listSharedLinksError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42791.$SwitchMap$com$dropbox$core$v2$sharing$ListSharedLinksError$Tag[listSharedLinksError.tag().ordinal()];
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
            LookupError.Serializer.INSTANCE.serialize(listSharedLinksError.pathValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListSharedLinksError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListSharedLinksError listSharedLinksErrorPath;
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
                listSharedLinksErrorPath = ListSharedLinksError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("reset".equals(tag)) {
                listSharedLinksErrorPath = ListSharedLinksError.RESET;
            } else {
                listSharedLinksErrorPath = ListSharedLinksError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listSharedLinksErrorPath;
        }
    }
}
