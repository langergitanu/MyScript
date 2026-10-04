package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.PathToTags;
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
public class GetTagsResult {

    @Nonnull
    protected final List<PathToTags> pathsToTags;

    public GetTagsResult(@Nonnull List<PathToTags> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'pathsToTags' is null");
        }
        Iterator<PathToTags> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'pathsToTags' is null");
            }
        }
        this.pathsToTags = list;
    }

    @Nonnull
    public List<PathToTags> getPathsToTags() {
        return this.pathsToTags;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.pathsToTags});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<PathToTags> list = this.pathsToTags;
        List<PathToTags> list2 = ((GetTagsResult) obj).pathsToTags;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetTagsResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetTagsResult getTagsResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("paths_to_tags");
            StoneSerializers.list(PathToTags.Serializer.INSTANCE).serialize(getTagsResult.pathsToTags, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetTagsResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("paths_to_tags".equals(currentName)) {
                        list = (List) StoneSerializers.list(PathToTags.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"paths_to_tags\" missing.");
                }
                GetTagsResult getTagsResult = new GetTagsResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getTagsResult, getTagsResult.toStringMultiline());
                return getTagsResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
