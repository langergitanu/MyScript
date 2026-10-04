package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.p013v2.fileproperties.PropertyField;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class PropertyGroupUpdate {

    @Nullable
    protected final List<PropertyField> addOrUpdateFields;

    @Nullable
    protected final List<String> removeFields;

    @Nonnull
    protected final String templateId;

    public PropertyGroupUpdate(@Nonnull String str, @Nullable List<PropertyField> list, @Nullable List<String> list2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'templateId' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'templateId' is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", str)) {
            throw new IllegalArgumentException("String 'templateId' does not match pattern");
        }
        this.templateId = str;
        if (list != null) {
            Iterator<PropertyField> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'addOrUpdateFields' is null");
                }
            }
        }
        this.addOrUpdateFields = list;
        if (list2 != null) {
            Iterator<String> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'removeFields' is null");
                }
            }
        }
        this.removeFields = list2;
    }

    public PropertyGroupUpdate(@Nonnull String str) {
        this(str, null, null);
    }

    @Nonnull
    public String getTemplateId() {
        return this.templateId;
    }

    @Nullable
    public List<PropertyField> getAddOrUpdateFields() {
        return this.addOrUpdateFields;
    }

    @Nullable
    public List<String> getRemoveFields() {
        return this.removeFields;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected List<PropertyField> addOrUpdateFields;
        protected List<String> removeFields;
        protected final String templateId;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'templateId' is null");
            }
            if (str.length() < 1) {
                throw new IllegalArgumentException("String 'templateId' is shorter than 1");
            }
            if (!Pattern.matches("(/|ptid:).*", str)) {
                throw new IllegalArgumentException("String 'templateId' does not match pattern");
            }
            this.templateId = str;
            this.addOrUpdateFields = null;
            this.removeFields = null;
        }

        public Builder withAddOrUpdateFields(List<PropertyField> list) {
            if (list != null) {
                Iterator<PropertyField> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'addOrUpdateFields' is null");
                    }
                }
            }
            this.addOrUpdateFields = list;
            return this;
        }

        public Builder withRemoveFields(List<String> list) {
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'removeFields' is null");
                    }
                }
            }
            this.removeFields = list;
            return this;
        }

        public PropertyGroupUpdate build() {
            return new PropertyGroupUpdate(this.templateId, this.addOrUpdateFields, this.removeFields);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.templateId, this.addOrUpdateFields, this.removeFields});
    }

    public boolean equals(Object obj) {
        List<PropertyField> list;
        List<PropertyField> list2;
        List<String> list3;
        List<String> list4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PropertyGroupUpdate propertyGroupUpdate = (PropertyGroupUpdate) obj;
        String str = this.templateId;
        String str2 = propertyGroupUpdate.templateId;
        return (str == str2 || str.equals(str2)) && ((list = this.addOrUpdateFields) == (list2 = propertyGroupUpdate.addOrUpdateFields) || (list != null && list.equals(list2))) && ((list3 = this.removeFields) == (list4 = propertyGroupUpdate.removeFields) || (list3 != null && list3.equals(list4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PropertyGroupUpdate> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PropertyGroupUpdate propertyGroupUpdate, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("template_id");
            StoneSerializers.string().serialize(propertyGroupUpdate.templateId, jsonGenerator);
            if (propertyGroupUpdate.addOrUpdateFields != null) {
                jsonGenerator.writeFieldName("add_or_update_fields");
                StoneSerializers.nullable(StoneSerializers.list(PropertyField.Serializer.INSTANCE)).serialize(propertyGroupUpdate.addOrUpdateFields, jsonGenerator);
            }
            if (propertyGroupUpdate.removeFields != null) {
                jsonGenerator.writeFieldName("remove_fields");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(propertyGroupUpdate.removeFields, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PropertyGroupUpdate deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                List list2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("template_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("add_or_update_fields".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(PropertyField.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("remove_fields".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"template_id\" missing.");
                }
                PropertyGroupUpdate propertyGroupUpdate = new PropertyGroupUpdate(strDeserialize, list, list2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(propertyGroupUpdate, propertyGroupUpdate.toStringMultiline());
                return propertyGroupUpdate;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
