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
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class AddTemplateArg extends PropertyGroupTemplate {
    public AddTemplateArg(@Nonnull String str, @Nonnull String str2, @Nonnull List<PropertyFieldTemplate> list) {
        super(str, str2, list);
    }

    @Override // com.dropbox.core.p013v2.fileproperties.PropertyGroupTemplate
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override // com.dropbox.core.p013v2.fileproperties.PropertyGroupTemplate
    @Nonnull
    public String getDescription() {
        return this.description;
    }

    @Override // com.dropbox.core.p013v2.fileproperties.PropertyGroupTemplate
    @Nonnull
    public List<PropertyFieldTemplate> getFields() {
        return this.fields;
    }

    @Override // com.dropbox.core.p013v2.fileproperties.PropertyGroupTemplate
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.fileproperties.PropertyGroupTemplate
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AddTemplateArg addTemplateArg = (AddTemplateArg) obj;
        return (this.name == addTemplateArg.name || this.name.equals(addTemplateArg.name)) && (this.description == addTemplateArg.description || this.description.equals(addTemplateArg.description)) && (this.fields == addTemplateArg.fields || this.fields.equals(addTemplateArg.fields));
    }

    @Override // com.dropbox.core.p013v2.fileproperties.PropertyGroupTemplate
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.fileproperties.PropertyGroupTemplate
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<AddTemplateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AddTemplateArg addTemplateArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(addTemplateArg.name, jsonGenerator);
            jsonGenerator.writeFieldName("description");
            StoneSerializers.string().serialize(addTemplateArg.description, jsonGenerator);
            jsonGenerator.writeFieldName("fields");
            StoneSerializers.list(PropertyFieldTemplate.Serializer.INSTANCE).serialize(addTemplateArg.fields, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AddTemplateArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                AddTemplateArg addTemplateArg = new AddTemplateArg(strDeserialize, strDeserialize2, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(addTemplateArg, addTemplateArg.toStringMultiline());
                return addTemplateArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
