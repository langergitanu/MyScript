package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.p013v2.fileproperties.PropertyGroupUpdate;
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
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class UpdatePropertiesArg {

    @Nonnull
    protected final String path;

    @Nonnull
    protected final List<PropertyGroupUpdate> updatePropertyGroups;

    public UpdatePropertiesArg(@Nonnull String str, @Nonnull List<PropertyGroupUpdate> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'updatePropertyGroups' is null");
        }
        Iterator<PropertyGroupUpdate> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'updatePropertyGroups' is null");
            }
        }
        this.updatePropertyGroups = list;
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nonnull
    public List<PropertyGroupUpdate> getUpdatePropertyGroups() {
        return this.updatePropertyGroups;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.updatePropertyGroups});
    }

    public boolean equals(Object obj) {
        List<PropertyGroupUpdate> list;
        List<PropertyGroupUpdate> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UpdatePropertiesArg updatePropertiesArg = (UpdatePropertiesArg) obj;
        String str = this.path;
        String str2 = updatePropertiesArg.path;
        return (str == str2 || str.equals(str2)) && ((list = this.updatePropertyGroups) == (list2 = updatePropertiesArg.updatePropertyGroups) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<UpdatePropertiesArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UpdatePropertiesArg updatePropertiesArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(updatePropertiesArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("update_property_groups");
            StoneSerializers.list(PropertyGroupUpdate.Serializer.INSTANCE).serialize(updatePropertiesArg.updatePropertyGroups, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UpdatePropertiesArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("update_property_groups".equals(currentName)) {
                        list = (List) StoneSerializers.list(PropertyGroupUpdate.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"update_property_groups\" missing.");
                }
                UpdatePropertiesArg updatePropertiesArg = new UpdatePropertiesArg(strDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(updatePropertiesArg, updatePropertiesArg.toStringMultiline());
                return updatePropertiesArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
