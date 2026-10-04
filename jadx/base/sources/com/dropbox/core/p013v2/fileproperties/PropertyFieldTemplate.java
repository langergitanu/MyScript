package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.p013v2.fileproperties.PropertyType;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class PropertyFieldTemplate {

    @Nonnull
    protected final String description;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final PropertyType type;

    public PropertyFieldTemplate(@Nonnull String str, @Nonnull String str2, @Nonnull PropertyType propertyType) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'description' is null");
        }
        this.description = str2;
        if (propertyType == null) {
            throw new IllegalArgumentException("Required value for 'type' is null");
        }
        this.type = propertyType;
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
    public PropertyType getType() {
        return this.type;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, this.description, this.type});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        PropertyType propertyType;
        PropertyType propertyType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PropertyFieldTemplate propertyFieldTemplate = (PropertyFieldTemplate) obj;
        String str3 = this.name;
        String str4 = propertyFieldTemplate.name;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.description) == (str2 = propertyFieldTemplate.description) || str.equals(str2)) && ((propertyType = this.type) == (propertyType2 = propertyFieldTemplate.type) || propertyType.equals(propertyType2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PropertyFieldTemplate> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PropertyFieldTemplate propertyFieldTemplate, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(propertyFieldTemplate.name, jsonGenerator);
            jsonGenerator.writeFieldName("description");
            StoneSerializers.string().serialize(propertyFieldTemplate.description, jsonGenerator);
            jsonGenerator.writeFieldName("type");
            PropertyType.Serializer.INSTANCE.serialize(propertyFieldTemplate.type, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PropertyFieldTemplate deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                PropertyType propertyTypeDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("description".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("type".equals(currentName)) {
                        propertyTypeDeserialize = PropertyType.Serializer.INSTANCE.deserialize(jsonParser);
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
                if (propertyTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"type\" missing.");
                }
                PropertyFieldTemplate propertyFieldTemplate = new PropertyFieldTemplate(strDeserialize, strDeserialize2, propertyTypeDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(propertyFieldTemplate, propertyFieldTemplate.toStringMultiline());
                return propertyFieldTemplate;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
