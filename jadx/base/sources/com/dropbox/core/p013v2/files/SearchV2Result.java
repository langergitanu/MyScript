package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.SearchMatchV2;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class SearchV2Result {

    @Nullable
    protected final String cursor;
    protected final boolean hasMore;

    @Nonnull
    protected final List<SearchMatchV2> matches;

    public SearchV2Result(@Nonnull List<SearchMatchV2> list, boolean z, @Nullable String str) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'matches' is null");
        }
        Iterator<SearchMatchV2> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'matches' is null");
            }
        }
        this.matches = list;
        this.hasMore = z;
        if (str != null && str.length() < 1) {
            throw new IllegalArgumentException("String 'cursor' is shorter than 1");
        }
        this.cursor = str;
    }

    public SearchV2Result(@Nonnull List<SearchMatchV2> list, boolean z) {
        this(list, z, null);
    }

    @Nonnull
    public List<SearchMatchV2> getMatches() {
        return this.matches;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    @Nullable
    public String getCursor() {
        return this.cursor;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.matches, Boolean.valueOf(this.hasMore), this.cursor});
    }

    public boolean equals(Object obj) {
        SearchV2Result searchV2Result;
        List<SearchMatchV2> list;
        List<SearchMatchV2> list2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.matches) == (list2 = (searchV2Result = (SearchV2Result) obj).matches) || list.equals(list2)) && this.hasMore == searchV2Result.hasMore && ((str = this.cursor) == (str2 = searchV2Result.cursor) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SearchV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SearchV2Result searchV2Result, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("matches");
            StoneSerializers.list(SearchMatchV2.Serializer.INSTANCE).serialize(searchV2Result.matches, jsonGenerator);
            jsonGenerator.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(searchV2Result.hasMore), jsonGenerator);
            if (searchV2Result.cursor != null) {
                jsonGenerator.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(searchV2Result.cursor, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SearchV2Result deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("matches".equals(currentName)) {
                        list = (List) StoneSerializers.list(SearchMatchV2.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("has_more".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"matches\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"has_more\" missing.");
                }
                SearchV2Result searchV2Result = new SearchV2Result(list, boolDeserialize.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(searchV2Result, searchV2Result.toStringMultiline());
                return searchV2Result;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
