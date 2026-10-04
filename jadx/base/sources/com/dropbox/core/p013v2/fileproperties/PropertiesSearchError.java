package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.p013v2.fileproperties.LookUpPropertiesError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class PropertiesSearchError {
    public static final PropertiesSearchError OTHER = new PropertiesSearchError().withTag(Tag.OTHER);
    private Tag _tag;
    private LookUpPropertiesError propertyGroupLookupValue;

    public enum Tag {
        PROPERTY_GROUP_LOOKUP,
        OTHER
    }

    private PropertiesSearchError() {
    }

    private PropertiesSearchError withTag(Tag tag) {
        PropertiesSearchError propertiesSearchError = new PropertiesSearchError();
        propertiesSearchError._tag = tag;
        return propertiesSearchError;
    }

    private PropertiesSearchError withTagAndPropertyGroupLookup(Tag tag, LookUpPropertiesError lookUpPropertiesError) {
        PropertiesSearchError propertiesSearchError = new PropertiesSearchError();
        propertiesSearchError._tag = tag;
        propertiesSearchError.propertyGroupLookupValue = lookUpPropertiesError;
        return propertiesSearchError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPropertyGroupLookup() {
        return this._tag == Tag.PROPERTY_GROUP_LOOKUP;
    }

    public static PropertiesSearchError propertyGroupLookup(LookUpPropertiesError lookUpPropertiesError) {
        if (lookUpPropertiesError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PropertiesSearchError().withTagAndPropertyGroupLookup(Tag.PROPERTY_GROUP_LOOKUP, lookUpPropertiesError);
    }

    public LookUpPropertiesError getPropertyGroupLookupValue() {
        if (this._tag != Tag.PROPERTY_GROUP_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PROPERTY_GROUP_LOOKUP, but was Tag." + this._tag.name());
        }
        return this.propertyGroupLookupValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.propertyGroupLookupValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof PropertiesSearchError)) {
            return false;
        }
        PropertiesSearchError propertiesSearchError = (PropertiesSearchError) obj;
        if (this._tag != propertiesSearchError._tag) {
            return false;
        }
        int i = C41231.f672xf3c146fc[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        LookUpPropertiesError lookUpPropertiesError = this.propertyGroupLookupValue;
        LookUpPropertiesError lookUpPropertiesError2 = propertiesSearchError.propertyGroupLookupValue;
        return lookUpPropertiesError == lookUpPropertiesError2 || lookUpPropertiesError.equals(lookUpPropertiesError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.PropertiesSearchError$1 */
    static /* synthetic */ class C41231 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$fileproperties$PropertiesSearchError$Tag */
        static final /* synthetic */ int[] f672xf3c146fc;

        static {
            int[] iArr = new int[Tag.values().length];
            f672xf3c146fc = iArr;
            try {
                iArr[Tag.PROPERTY_GROUP_LOOKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f672xf3c146fc[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<PropertiesSearchError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PropertiesSearchError propertiesSearchError, JsonGenerator jsonGenerator) throws IOException {
            if (C41231.f672xf3c146fc[propertiesSearchError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("property_group_lookup", jsonGenerator);
                jsonGenerator.writeFieldName("property_group_lookup");
                LookUpPropertiesError.Serializer.INSTANCE.serialize(propertiesSearchError.propertyGroupLookupValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PropertiesSearchError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PropertiesSearchError propertiesSearchErrorPropertyGroupLookup;
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
            if ("property_group_lookup".equals(tag)) {
                expectField("property_group_lookup", jsonParser);
                propertiesSearchErrorPropertyGroupLookup = PropertiesSearchError.propertyGroupLookup(LookUpPropertiesError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                propertiesSearchErrorPropertyGroupLookup = PropertiesSearchError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return propertiesSearchErrorPropertyGroupLookup;
        }
    }
}
