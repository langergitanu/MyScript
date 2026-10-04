package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class RemovePropertiesArg {

    @Nonnull
    protected final String path;

    @Nonnull
    protected final List<String> propertyTemplateIds;

    public RemovePropertiesArg(@Nonnull String str, @Nonnull List<String> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'propertyTemplateIds' is null");
        }
        for (String str2 : list) {
            if (str2 == null) {
                throw new IllegalArgumentException("An item in list 'propertyTemplateIds' is null");
            }
            if (str2.length() < 1) {
                throw new IllegalArgumentException("Stringan item in list 'propertyTemplateIds' is shorter than 1");
            }
            if (!Pattern.matches("(/|ptid:).*", str2)) {
                throw new IllegalArgumentException("Stringan item in list 'propertyTemplateIds' does not match pattern");
            }
        }
        this.propertyTemplateIds = list;
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nonnull
    public List<String> getPropertyTemplateIds() {
        return this.propertyTemplateIds;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.propertyTemplateIds});
    }

    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        RemovePropertiesArg removePropertiesArg = (RemovePropertiesArg) obj;
        String str = this.path;
        String str2 = removePropertiesArg.path;
        return (str == str2 || str.equals(str2)) && ((list = this.propertyTemplateIds) == (list2 = removePropertiesArg.propertyTemplateIds) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<RemovePropertiesArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RemovePropertiesArg removePropertiesArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(removePropertiesArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("property_template_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(removePropertiesArg.propertyTemplateIds, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RemovePropertiesArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("property_template_ids".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"property_template_ids\" missing.");
                }
                RemovePropertiesArg removePropertiesArg = new RemovePropertiesArg(strDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(removePropertiesArg, removePropertiesArg.toStringMultiline());
                return removePropertiesArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
