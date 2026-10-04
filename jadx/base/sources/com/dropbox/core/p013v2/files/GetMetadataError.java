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
public final class GetMetadataError {
    private Tag _tag;
    private LookupError pathValue;

    public enum Tag {
        PATH
    }

    private GetMetadataError() {
    }

    private GetMetadataError withTag(Tag tag) {
        GetMetadataError getMetadataError = new GetMetadataError();
        getMetadataError._tag = tag;
        return getMetadataError;
    }

    private GetMetadataError withTagAndPath(Tag tag, LookupError lookupError) {
        GetMetadataError getMetadataError = new GetMetadataError();
        getMetadataError._tag = tag;
        getMetadataError.pathValue = lookupError;
        return getMetadataError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static GetMetadataError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetMetadataError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GetMetadataError)) {
            return false;
        }
        GetMetadataError getMetadataError = (GetMetadataError) obj;
        if (this._tag != getMetadataError._tag || C41621.$SwitchMap$com$dropbox$core$v2$files$GetMetadataError$Tag[this._tag.ordinal()] != 1) {
            return false;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = getMetadataError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.GetMetadataError$1 */
    static /* synthetic */ class C41621 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$GetMetadataError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$GetMetadataError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<GetMetadataError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetMetadataError getMetadataError, JsonGenerator jsonGenerator) throws IOException {
            if (C41621.$SwitchMap$com$dropbox$core$v2$files$GetMetadataError$Tag[getMetadataError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(getMetadataError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + getMetadataError.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetMetadataError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
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
                GetMetadataError getMetadataErrorPath = GetMetadataError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
                if (!z) {
                    skipFields(jsonParser);
                    expectEndObject(jsonParser);
                }
                return getMetadataErrorPath;
            }
            throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
        }
    }
}
