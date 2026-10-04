package com.dropbox.core.p013v2.sharing;

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
public final class GetSharedLinksError {
    public static final GetSharedLinksError OTHER = new GetSharedLinksError().withTag(Tag.OTHER);
    private Tag _tag;
    private String pathValue;

    public enum Tag {
        PATH,
        OTHER
    }

    private GetSharedLinksError() {
    }

    private GetSharedLinksError withTag(Tag tag) {
        GetSharedLinksError getSharedLinksError = new GetSharedLinksError();
        getSharedLinksError._tag = tag;
        return getSharedLinksError;
    }

    private GetSharedLinksError withTagAndPath(Tag tag, String str) {
        GetSharedLinksError getSharedLinksError = new GetSharedLinksError();
        getSharedLinksError._tag = tag;
        getSharedLinksError.pathValue = str;
        return getSharedLinksError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static GetSharedLinksError path(String str) {
        return new GetSharedLinksError().withTagAndPath(Tag.PATH, str);
    }

    public static GetSharedLinksError path() {
        return path(null);
    }

    public String getPathValue() {
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
        if (obj == null || !(obj instanceof GetSharedLinksError)) {
            return false;
        }
        GetSharedLinksError getSharedLinksError = (GetSharedLinksError) obj;
        if (this._tag != getSharedLinksError._tag) {
            return false;
        }
        int i = C42631.$SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinksError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        String str = this.pathValue;
        String str2 = getSharedLinksError.pathValue;
        return str == str2 || (str != null && str.equals(str2));
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.GetSharedLinksError$1 */
    static /* synthetic */ class C42631 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinksError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinksError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinksError$Tag[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<GetSharedLinksError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetSharedLinksError getSharedLinksError, JsonGenerator jsonGenerator) throws IOException {
            if (C42631.$SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinksError$Tag[getSharedLinksError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(getSharedLinksError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetSharedLinksError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetSharedLinksError getSharedLinksErrorPath;
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
                if (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                    expectField(ClientCookie.PATH_ATTR, jsonParser);
                    str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                } else {
                    str = null;
                }
                if (str == null) {
                    getSharedLinksErrorPath = GetSharedLinksError.path();
                } else {
                    getSharedLinksErrorPath = GetSharedLinksError.path(str);
                }
            } else {
                getSharedLinksErrorPath = GetSharedLinksError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getSharedLinksErrorPath;
        }
    }
}
