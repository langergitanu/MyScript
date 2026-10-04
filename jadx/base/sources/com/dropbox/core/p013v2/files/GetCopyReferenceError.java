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
public final class GetCopyReferenceError {
    public static final GetCopyReferenceError OTHER = new GetCopyReferenceError().withTag(Tag.OTHER);
    private Tag _tag;
    private LookupError pathValue;

    public enum Tag {
        PATH,
        OTHER
    }

    private GetCopyReferenceError() {
    }

    private GetCopyReferenceError withTag(Tag tag) {
        GetCopyReferenceError getCopyReferenceError = new GetCopyReferenceError();
        getCopyReferenceError._tag = tag;
        return getCopyReferenceError;
    }

    private GetCopyReferenceError withTagAndPath(Tag tag, LookupError lookupError) {
        GetCopyReferenceError getCopyReferenceError = new GetCopyReferenceError();
        getCopyReferenceError._tag = tag;
        getCopyReferenceError.pathValue = lookupError;
        return getCopyReferenceError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static GetCopyReferenceError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetCopyReferenceError().withTagAndPath(Tag.PATH, lookupError);
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
        if (obj == null || !(obj instanceof GetCopyReferenceError)) {
            return false;
        }
        GetCopyReferenceError getCopyReferenceError = (GetCopyReferenceError) obj;
        if (this._tag != getCopyReferenceError._tag) {
            return false;
        }
        int i = C41611.$SwitchMap$com$dropbox$core$v2$files$GetCopyReferenceError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = getCopyReferenceError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.GetCopyReferenceError$1 */
    static /* synthetic */ class C41611 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$GetCopyReferenceError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$GetCopyReferenceError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$GetCopyReferenceError$Tag[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<GetCopyReferenceError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetCopyReferenceError getCopyReferenceError, JsonGenerator jsonGenerator) throws IOException {
            if (C41611.$SwitchMap$com$dropbox$core$v2$files$GetCopyReferenceError$Tag[getCopyReferenceError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(getCopyReferenceError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetCopyReferenceError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetCopyReferenceError getCopyReferenceErrorPath;
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
                getCopyReferenceErrorPath = GetCopyReferenceError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                getCopyReferenceErrorPath = GetCopyReferenceError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getCopyReferenceErrorPath;
        }
    }
}
