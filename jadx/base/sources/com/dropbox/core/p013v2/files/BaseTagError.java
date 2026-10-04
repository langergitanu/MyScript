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
public final class BaseTagError {
    public static final BaseTagError OTHER = new BaseTagError().withTag(Tag.OTHER);
    private Tag _tag;
    private LookupError pathValue;

    public enum Tag {
        PATH,
        OTHER
    }

    private BaseTagError() {
    }

    private BaseTagError withTag(Tag tag) {
        BaseTagError baseTagError = new BaseTagError();
        baseTagError._tag = tag;
        return baseTagError;
    }

    private BaseTagError withTagAndPath(Tag tag, LookupError lookupError) {
        BaseTagError baseTagError = new BaseTagError();
        baseTagError._tag = tag;
        baseTagError.pathValue = lookupError;
        return baseTagError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static BaseTagError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new BaseTagError().withTagAndPath(Tag.PATH, lookupError);
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
        if (obj == null || !(obj instanceof BaseTagError)) {
            return false;
        }
        BaseTagError baseTagError = (BaseTagError) obj;
        if (this._tag != baseTagError._tag) {
            return false;
        }
        int i = C41431.$SwitchMap$com$dropbox$core$v2$files$BaseTagError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = baseTagError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.BaseTagError$1 */
    static /* synthetic */ class C41431 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$BaseTagError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$BaseTagError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$BaseTagError$Tag[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<BaseTagError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(BaseTagError baseTagError, JsonGenerator jsonGenerator) throws IOException {
            if (C41431.$SwitchMap$com$dropbox$core$v2$files$BaseTagError$Tag[baseTagError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(baseTagError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public BaseTagError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            BaseTagError baseTagErrorPath;
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
                baseTagErrorPath = BaseTagError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                baseTagErrorPath = BaseTagError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return baseTagErrorPath;
        }
    }
}
