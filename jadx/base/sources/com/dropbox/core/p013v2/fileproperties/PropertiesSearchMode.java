package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class PropertiesSearchMode {
    public static final PropertiesSearchMode OTHER = new PropertiesSearchMode().withTag(Tag.OTHER);
    private Tag _tag;
    private String fieldNameValue;

    public enum Tag {
        FIELD_NAME,
        OTHER
    }

    private PropertiesSearchMode() {
    }

    private PropertiesSearchMode withTag(Tag tag) {
        PropertiesSearchMode propertiesSearchMode = new PropertiesSearchMode();
        propertiesSearchMode._tag = tag;
        return propertiesSearchMode;
    }

    private PropertiesSearchMode withTagAndFieldName(Tag tag, String str) {
        PropertiesSearchMode propertiesSearchMode = new PropertiesSearchMode();
        propertiesSearchMode._tag = tag;
        propertiesSearchMode.fieldNameValue = str;
        return propertiesSearchMode;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isFieldName() {
        return this._tag == Tag.FIELD_NAME;
    }

    public static PropertiesSearchMode fieldName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PropertiesSearchMode().withTagAndFieldName(Tag.FIELD_NAME, str);
    }

    public String getFieldNameValue() {
        if (this._tag != Tag.FIELD_NAME) {
            throw new IllegalStateException("Invalid tag: required Tag.FIELD_NAME, but was Tag." + this._tag.name());
        }
        return this.fieldNameValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.fieldNameValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof PropertiesSearchMode)) {
            return false;
        }
        PropertiesSearchMode propertiesSearchMode = (PropertiesSearchMode) obj;
        if (this._tag != propertiesSearchMode._tag) {
            return false;
        }
        int i = C41241.f674xa024451b[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        String str = this.fieldNameValue;
        String str2 = propertiesSearchMode.fieldNameValue;
        return str == str2 || str.equals(str2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.PropertiesSearchMode$1 */
    static /* synthetic */ class C41241 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$fileproperties$PropertiesSearchMode$Tag */
        static final /* synthetic */ int[] f674xa024451b;

        static {
            int[] iArr = new int[Tag.values().length];
            f674xa024451b = iArr;
            try {
                iArr[Tag.FIELD_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f674xa024451b[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<PropertiesSearchMode> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PropertiesSearchMode propertiesSearchMode, JsonGenerator jsonGenerator) throws IOException {
            if (C41241.f674xa024451b[propertiesSearchMode.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("field_name", jsonGenerator);
                jsonGenerator.writeFieldName("field_name");
                StoneSerializers.string().serialize(propertiesSearchMode.fieldNameValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PropertiesSearchMode deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PropertiesSearchMode propertiesSearchModeFieldName;
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
            if ("field_name".equals(tag)) {
                expectField("field_name", jsonParser);
                propertiesSearchModeFieldName = PropertiesSearchMode.fieldName(StoneSerializers.string().deserialize(jsonParser));
            } else {
                propertiesSearchModeFieldName = PropertiesSearchMode.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return propertiesSearchModeFieldName;
        }
    }
}
