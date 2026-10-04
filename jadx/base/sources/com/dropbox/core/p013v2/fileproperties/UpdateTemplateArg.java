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
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateTemplateArg {

    @Nullable
    protected final List<PropertyFieldTemplate> addFields;

    @Nullable
    protected final String description;

    @Nullable
    protected final String name;

    @Nonnull
    protected final String templateId;

    public UpdateTemplateArg(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nullable List<PropertyFieldTemplate> list) {
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
        this.name = str2;
        this.description = str3;
        if (list != null) {
            Iterator<PropertyFieldTemplate> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'addFields' is null");
                }
            }
        }
        this.addFields = list;
    }

    public UpdateTemplateArg(@Nonnull String str) {
        this(str, null, null, null);
    }

    @Nonnull
    public String getTemplateId() {
        return this.templateId;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @Nullable
    public List<PropertyFieldTemplate> getAddFields() {
        return this.addFields;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected List<PropertyFieldTemplate> addFields;
        protected String description;
        protected String name;
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
            this.name = null;
            this.description = null;
            this.addFields = null;
        }

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withDescription(String str) {
            this.description = str;
            return this;
        }

        public Builder withAddFields(List<PropertyFieldTemplate> list) {
            if (list != null) {
                Iterator<PropertyFieldTemplate> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'addFields' is null");
                    }
                }
            }
            this.addFields = list;
            return this;
        }

        public UpdateTemplateArg build() {
            return new UpdateTemplateArg(this.templateId, this.name, this.description, this.addFields);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.templateId, this.name, this.description, this.addFields});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        List<PropertyFieldTemplate> list;
        List<PropertyFieldTemplate> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UpdateTemplateArg updateTemplateArg = (UpdateTemplateArg) obj;
        String str5 = this.templateId;
        String str6 = updateTemplateArg.templateId;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.name) == (str2 = updateTemplateArg.name) || (str != null && str.equals(str2))) && (((str3 = this.description) == (str4 = updateTemplateArg.description) || (str3 != null && str3.equals(str4))) && ((list = this.addFields) == (list2 = updateTemplateArg.addFields) || (list != null && list.equals(list2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<UpdateTemplateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UpdateTemplateArg updateTemplateArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("template_id");
            StoneSerializers.string().serialize(updateTemplateArg.templateId, jsonGenerator);
            if (updateTemplateArg.name != null) {
                jsonGenerator.writeFieldName("name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(updateTemplateArg.name, jsonGenerator);
            }
            if (updateTemplateArg.description != null) {
                jsonGenerator.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(updateTemplateArg.description, jsonGenerator);
            }
            if (updateTemplateArg.addFields != null) {
                jsonGenerator.writeFieldName("add_fields");
                StoneSerializers.nullable(StoneSerializers.list(PropertyFieldTemplate.Serializer.INSTANCE)).serialize(updateTemplateArg.addFields, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UpdateTemplateArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                String str2 = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("template_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("description".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("add_fields".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(PropertyFieldTemplate.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"template_id\" missing.");
                }
                UpdateTemplateArg updateTemplateArg = new UpdateTemplateArg(strDeserialize, str, str2, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(updateTemplateArg, updateTemplateArg.toStringMultiline());
                return updateTemplateArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
