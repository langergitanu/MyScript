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
import javax.annotation.Nonnull;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class PropertiesSearchMatch {

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f673id;
    protected final boolean isDeleted;

    @Nonnull
    protected final String path;

    @Nonnull
    protected final List<PropertyGroup> propertyGroups;

    public PropertiesSearchMatch(@Nonnull String str, @Nonnull String str2, boolean z, @Nonnull List<PropertyGroup> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        this.f673id = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        this.path = str2;
        this.isDeleted = z;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'propertyGroups' is null");
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
    public String getId() {
        return this.f673id;
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    @Nonnull
    public List<PropertyGroup> getPropertyGroups() {
        return this.propertyGroups;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f673id, this.path, Boolean.valueOf(this.isDeleted), this.propertyGroups});
    }

    public boolean equals(Object obj) {
        PropertiesSearchMatch propertiesSearchMatch;
        String str;
        String str2;
        String str3;
        String str4;
        List<PropertyGroup> list;
        List<PropertyGroup> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.f673id) == (str2 = (propertiesSearchMatch = (PropertiesSearchMatch) obj).f673id) || str.equals(str2)) && (((str3 = this.path) == (str4 = propertiesSearchMatch.path) || str3.equals(str4)) && this.isDeleted == propertiesSearchMatch.isDeleted && ((list = this.propertyGroups) == (list2 = propertiesSearchMatch.propertyGroups) || list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PropertiesSearchMatch> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PropertiesSearchMatch propertiesSearchMatch, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(propertiesSearchMatch.f673id, jsonGenerator);
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(propertiesSearchMatch.path, jsonGenerator);
            jsonGenerator.writeFieldName("is_deleted");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(propertiesSearchMatch.isDeleted), jsonGenerator);
            jsonGenerator.writeFieldName("property_groups");
            StoneSerializers.list(PropertyGroup.Serializer.INSTANCE).serialize(propertiesSearchMatch.propertyGroups, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PropertiesSearchMatch deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                Boolean boolDeserialize = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("is_deleted".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("property_groups".equals(currentName)) {
                        list = (List) StoneSerializers.list(PropertyGroup.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_deleted\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"property_groups\" missing.");
                }
                PropertiesSearchMatch propertiesSearchMatch = new PropertiesSearchMatch(strDeserialize, strDeserialize2, boolDeserialize.booleanValue(), list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(propertiesSearchMatch, propertiesSearchMatch.toStringMultiline());
                return propertiesSearchMatch;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
