package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.p013v2.fileproperties.PropertyFieldTemplate;
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
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class PropertyGroupTemplate {

    @Nonnull
    protected final String description;

    @Nonnull
    protected final List<PropertyFieldTemplate> fields;

    @Nonnull
    protected final String name;

    public PropertyGroupTemplate(@Nonnull String str, @Nonnull String str2, @Nonnull List<PropertyFieldTemplate> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'description' is null");
        }
        this.description = str2;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'fields' is null");
        }
        Iterator<PropertyFieldTemplate> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'fields' is null");
            }
        }
        this.fields = list;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getDescription() {
        return this.description;
    }

    @Nonnull
    public List<PropertyFieldTemplate> getFields() {
        return this.fields;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, this.description, this.fields});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        List<PropertyFieldTemplate> list;
        List<PropertyFieldTemplate> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PropertyGroupTemplate propertyGroupTemplate = (PropertyGroupTemplate) obj;
        String str3 = this.name;
        String str4 = propertyGroupTemplate.name;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.description) == (str2 = propertyGroupTemplate.description) || str.equals(str2)) && ((list = this.fields) == (list2 = propertyGroupTemplate.fields) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PropertyGroupTemplate> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PropertyGroupTemplate propertyGroupTemplate, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(propertyGroupTemplate.name, jsonGenerator);
            jsonGenerator.writeFieldName("description");
            StoneSerializers.string().serialize(propertyGroupTemplate.description, jsonGenerator);
            jsonGenerator.writeFieldName("fields");
            StoneSerializers.list(PropertyFieldTemplate.Serializer.INSTANCE).serialize(propertyGroupTemplate.fields, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PropertyGroupTemplate deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("description".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("fields".equals(currentName)) {
                        list = (List) StoneSerializers.list(PropertyFieldTemplate.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"description\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"fields\" missing.");
                }
                PropertyGroupTemplate propertyGroupTemplate = new PropertyGroupTemplate(strDeserialize, strDeserialize2, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(propertyGroupTemplate, propertyGroupTemplate.toStringMultiline());
                return propertyGroupTemplate;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
