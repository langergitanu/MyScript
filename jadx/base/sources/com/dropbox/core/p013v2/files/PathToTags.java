package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.TagObject;
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
public class PathToTags {

    @Nonnull
    protected final String path;

    @Nonnull
    protected final List<TagObject> tags;

    public PathToTags(@Nonnull String str, @Nonnull List<TagObject> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'tags' is null");
        }
        Iterator<TagObject> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'tags' is null");
            }
        }
        this.tags = list;
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nonnull
    public List<TagObject> getTags() {
        return this.tags;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.tags});
    }

    public boolean equals(Object obj) {
        List<TagObject> list;
        List<TagObject> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PathToTags pathToTags = (PathToTags) obj;
        String str = this.path;
        String str2 = pathToTags.path;
        return (str == str2 || str.equals(str2)) && ((list = this.tags) == (list2 = pathToTags.tags) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PathToTags> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PathToTags pathToTags, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(pathToTags.path, jsonGenerator);
            jsonGenerator.writeFieldName("tags");
            StoneSerializers.list(TagObject.Serializer.INSTANCE).serialize(pathToTags.tags, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PathToTags deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("tags".equals(currentName)) {
                        list = (List) StoneSerializers.list(TagObject.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"tags\" missing.");
                }
                PathToTags pathToTags = new PathToTags(strDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(pathToTags, pathToTags.toStringMultiline());
                return pathToTags;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
