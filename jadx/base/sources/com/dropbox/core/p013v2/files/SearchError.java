package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class SearchError {
    public static final SearchError INTERNAL_ERROR = new SearchError().withTag(Tag.INTERNAL_ERROR);
    public static final SearchError OTHER = new SearchError().withTag(Tag.OTHER);
    private Tag _tag;
    private String invalidArgumentValue;
    private LookupError pathValue;

    public enum Tag {
        PATH,
        INVALID_ARGUMENT,
        INTERNAL_ERROR,
        OTHER
    }

    private SearchError() {
    }

    private SearchError withTag(Tag tag) {
        SearchError searchError = new SearchError();
        searchError._tag = tag;
        return searchError;
    }

    private SearchError withTagAndPath(Tag tag, LookupError lookupError) {
        SearchError searchError = new SearchError();
        searchError._tag = tag;
        searchError.pathValue = lookupError;
        return searchError;
    }

    private SearchError withTagAndInvalidArgument(Tag tag, String str) {
        SearchError searchError = new SearchError();
        searchError._tag = tag;
        searchError.invalidArgumentValue = str;
        return searchError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static SearchError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SearchError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isInvalidArgument() {
        return this._tag == Tag.INVALID_ARGUMENT;
    }

    public static SearchError invalidArgument(String str) {
        return new SearchError().withTagAndInvalidArgument(Tag.INVALID_ARGUMENT, str);
    }

    public static SearchError invalidArgument() {
        return invalidArgument(null);
    }

    public String getInvalidArgumentValue() {
        if (this._tag != Tag.INVALID_ARGUMENT) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_ARGUMENT, but was Tag." + this._tag.name());
        }
        return this.invalidArgumentValue;
    }

    public boolean isInternalError() {
        return this._tag == Tag.INTERNAL_ERROR;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue, this.invalidArgumentValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof SearchError)) {
            return false;
        }
        SearchError searchError = (SearchError) obj;
        if (this._tag != searchError._tag) {
            return false;
        }
        int i = C41981.$SwitchMap$com$dropbox$core$v2$files$SearchError$Tag[this._tag.ordinal()];
        if (i == 1) {
            LookupError lookupError = this.pathValue;
            LookupError lookupError2 = searchError.pathValue;
            return lookupError == lookupError2 || lookupError.equals(lookupError2);
        }
        if (i != 2) {
            return i == 3 || i == 4;
        }
        String str = this.invalidArgumentValue;
        String str2 = searchError.invalidArgumentValue;
        return str == str2 || (str != null && str.equals(str2));
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SearchError$1 */
    static /* synthetic */ class C41981 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SearchError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SearchError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchError$Tag[Tag.INVALID_ARGUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchError$Tag[Tag.INTERNAL_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchError$Tag[Tag.OTHER.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<SearchError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SearchError searchError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41981.$SwitchMap$com$dropbox$core$v2$files$SearchError$Tag[searchError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(searchError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    jsonGenerator.writeString("internal_error");
                    return;
                } else {
                    jsonGenerator.writeString("other");
                    return;
                }
            }
            jsonGenerator.writeStartObject();
            writeTag("invalid_argument", jsonGenerator);
            jsonGenerator.writeFieldName("invalid_argument");
            StoneSerializers.nullable(StoneSerializers.string()).serialize(searchError.invalidArgumentValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SearchError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SearchError searchErrorInvalidArgument;
            String str;
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
                searchErrorInvalidArgument = SearchError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("invalid_argument".equals(tag)) {
                if (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                    expectField("invalid_argument", jsonParser);
                    str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                } else {
                    str = null;
                }
                if (str == null) {
                    searchErrorInvalidArgument = SearchError.invalidArgument();
                } else {
                    searchErrorInvalidArgument = SearchError.invalidArgument(str);
                }
            } else if ("internal_error".equals(tag)) {
                searchErrorInvalidArgument = SearchError.INTERNAL_ERROR;
            } else {
                searchErrorInvalidArgument = SearchError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return searchErrorInvalidArgument;
        }
    }
}
