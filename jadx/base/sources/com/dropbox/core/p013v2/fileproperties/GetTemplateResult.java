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
public class GetTemplateResult extends PropertyGroupTemplate {
    public GetTemplateResult(@Nonnull String str, @Nonnull String str2, @Nonnull List<PropertyFieldTemplate> list) {
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
        GetTemplateResult getTemplateResult = (GetTemplateResult) obj;
        return (this.name == getTemplateResult.name || this.name.equals(getTemplateResult.name)) && (this.description == getTemplateResult.description || this.description.equals(getTemplateResult.description)) && (this.fields == getTemplateResult.fields || this.fields.equals(getTemplateResult.fields));
    }

    @Override // com.dropbox.core.p013v2.fileproperties.PropertyGroupTemplate
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.fileproperties.PropertyGroupTemplate
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<GetTemplateResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetTemplateResult getTemplateResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(getTemplateResult.name, jsonGenerator);
            jsonGenerator.writeFieldName("description");
            StoneSerializers.string().serialize(getTemplateResult.description, jsonGenerator);
            jsonGenerator.writeFieldName("fields");
            StoneSerializers.list(PropertyFieldTemplate.Serializer.INSTANCE).serialize(getTemplateResult.fields, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetTemplateResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                GetTemplateResult getTemplateResult = new GetTemplateResult(strDeserialize, strDeserialize2, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getTemplateResult, getTemplateResult.toStringMultiline());
                return getTemplateResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
