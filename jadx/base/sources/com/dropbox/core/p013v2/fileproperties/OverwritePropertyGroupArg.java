package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.p013v2.fileproperties.PropertyGroup;
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
public class OverwritePropertyGroupArg {

    @Nonnull
    protected final String path;

    @Nonnull
    protected final List<PropertyGroup> propertyGroups;

    public OverwritePropertyGroupArg(@Nonnull String str, @Nonnull List<PropertyGroup> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'propertyGroups' is null");
        }
        if (list.size() < 1) {
            throw new IllegalArgumentException("List 'propertyGroups' has fewer than 1 items");
        }
        Iterator<PropertyGroup> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
            }
        }
        this.propertyGroups = list;
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nonnull
    public List<PropertyGroup> getPropertyGroups() {
        return this.propertyGroups;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.propertyGroups});
    }

    public boolean equals(Object obj) {
        List<PropertyGroup> list;
        List<PropertyGroup> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        OverwritePropertyGroupArg overwritePropertyGroupArg = (OverwritePropertyGroupArg) obj;
        String str = this.path;
        String str2 = overwritePropertyGroupArg.path;
        return (str == str2 || str.equals(str2)) && ((list = this.propertyGroups) == (list2 = overwritePropertyGroupArg.propertyGroups) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<OverwritePropertyGroupArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(OverwritePropertyGroupArg overwritePropertyGroupArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(overwritePropertyGroupArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("property_groups");
            StoneSerializers.list(PropertyGroup.Serializer.INSTANCE).serialize(overwritePropertyGroupArg.propertyGroups, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public OverwritePropertyGroupArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("property_groups".equals(currentName)) {
                        list = (List) StoneSerializers.list(PropertyGroup.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"property_groups\" missing.");
                }
                OverwritePropertyGroupArg overwritePropertyGroupArg = new OverwritePropertyGroupArg(strDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(overwritePropertyGroupArg, overwritePropertyGroupArg.toStringMultiline());
                return overwritePropertyGroupArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
