package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.LookUpPropertiesError;
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
public final class AlphaGetMetadataError {
    private Tag _tag;
    private LookupError pathValue;
    private LookUpPropertiesError propertiesErrorValue;

    public enum Tag {
        PATH,
        PROPERTIES_ERROR
    }

    private AlphaGetMetadataError() {
    }

    private AlphaGetMetadataError withTag(Tag tag) {
        AlphaGetMetadataError alphaGetMetadataError = new AlphaGetMetadataError();
        alphaGetMetadataError._tag = tag;
        return alphaGetMetadataError;
    }

    private AlphaGetMetadataError withTagAndPath(Tag tag, LookupError lookupError) {
        AlphaGetMetadataError alphaGetMetadataError = new AlphaGetMetadataError();
        alphaGetMetadataError._tag = tag;
        alphaGetMetadataError.pathValue = lookupError;
        return alphaGetMetadataError;
    }

    private AlphaGetMetadataError withTagAndPropertiesError(Tag tag, LookUpPropertiesError lookUpPropertiesError) {
        AlphaGetMetadataError alphaGetMetadataError = new AlphaGetMetadataError();
        alphaGetMetadataError._tag = tag;
        alphaGetMetadataError.propertiesErrorValue = lookUpPropertiesError;
        return alphaGetMetadataError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static AlphaGetMetadataError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AlphaGetMetadataError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isPropertiesError() {
        return this._tag == Tag.PROPERTIES_ERROR;
    }

    public static AlphaGetMetadataError propertiesError(LookUpPropertiesError lookUpPropertiesError) {
        if (lookUpPropertiesError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AlphaGetMetadataError().withTagAndPropertiesError(Tag.PROPERTIES_ERROR, lookUpPropertiesError);
    }

    public LookUpPropertiesError getPropertiesErrorValue() {
        if (this._tag != Tag.PROPERTIES_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.PROPERTIES_ERROR, but was Tag." + this._tag.name());
        }
        return this.propertiesErrorValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.pathValue, this.propertiesErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AlphaGetMetadataError)) {
            return false;
        }
        AlphaGetMetadataError alphaGetMetadataError = (AlphaGetMetadataError) obj;
        if (this._tag != alphaGetMetadataError._tag) {
            return false;
        }
        int i = C41421.$SwitchMap$com$dropbox$core$v2$files$AlphaGetMetadataError$Tag[this._tag.ordinal()];
        if (i == 1) {
            LookupError lookupError = this.pathValue;
            LookupError lookupError2 = alphaGetMetadataError.pathValue;
            return lookupError == lookupError2 || lookupError.equals(lookupError2);
        }
        if (i != 2) {
            return false;
        }
        LookUpPropertiesError lookUpPropertiesError = this.propertiesErrorValue;
        LookUpPropertiesError lookUpPropertiesError2 = alphaGetMetadataError.propertiesErrorValue;
        return lookUpPropertiesError == lookUpPropertiesError2 || lookUpPropertiesError.equals(lookUpPropertiesError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.AlphaGetMetadataError$1 */
    static /* synthetic */ class C41421 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$AlphaGetMetadataError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$AlphaGetMetadataError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$AlphaGetMetadataError$Tag[Tag.PROPERTIES_ERROR.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<AlphaGetMetadataError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AlphaGetMetadataError alphaGetMetadataError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41421.$SwitchMap$com$dropbox$core$v2$files$AlphaGetMetadataError$Tag[alphaGetMetadataError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(alphaGetMetadataError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("properties_error", jsonGenerator);
                jsonGenerator.writeFieldName("properties_error");
                LookUpPropertiesError.Serializer.INSTANCE.serialize(alphaGetMetadataError.propertiesErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + alphaGetMetadataError.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AlphaGetMetadataError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AlphaGetMetadataError alphaGetMetadataErrorPropertiesError;
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
                alphaGetMetadataErrorPropertiesError = AlphaGetMetadataError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("properties_error".equals(tag)) {
                expectField("properties_error", jsonParser);
                alphaGetMetadataErrorPropertiesError = AlphaGetMetadataError.propertiesError(LookUpPropertiesError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return alphaGetMetadataErrorPropertiesError;
        }
    }
}
