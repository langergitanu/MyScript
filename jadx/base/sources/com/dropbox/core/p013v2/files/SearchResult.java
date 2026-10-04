package com.dropbox.core.p013v2.files;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.files.SearchMatch;
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
public class SearchResult {

    @Nonnull
    protected final List<SearchMatch> matches;
    protected final boolean more;
    protected final long start;

    public SearchResult(@Nonnull List<SearchMatch> list, boolean z, long j) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'matches' is null");
        }
        Iterator<SearchMatch> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'matches' is null");
            }
        }
        this.matches = list;
        this.more = z;
        this.start = j;
    }

    @Nonnull
    public List<SearchMatch> getMatches() {
        return this.matches;
    }

    public boolean getMore() {
        return this.more;
    }

    public long getStart() {
        return this.start;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.matches, Boolean.valueOf(this.more), Long.valueOf(this.start)});
    }

    public boolean equals(Object obj) {
        SearchResult searchResult;
        List<SearchMatch> list;
        List<SearchMatch> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.matches) == (list2 = (searchResult = (SearchResult) obj).matches) || list.equals(list2)) && this.more == searchResult.more && this.start == searchResult.start;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SearchResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SearchResult searchResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("matches");
            StoneSerializers.list(SearchMatch.Serializer.INSTANCE).serialize(searchResult.matches, jsonGenerator);
            jsonGenerator.writeFieldName("more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(searchResult.more), jsonGenerator);
            jsonGenerator.writeFieldName(TtmlNode.START);
            StoneSerializers.uInt64().serialize(Long.valueOf(searchResult.start), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SearchResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                Long lDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("matches".equals(currentName)) {
                        list = (List) StoneSerializers.list(SearchMatch.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("more".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if (TtmlNode.START.equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"matches\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"more\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"start\" missing.");
                }
                SearchResult searchResult = new SearchResult(list, boolDeserialize.booleanValue(), lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(searchResult, searchResult.toStringMultiline());
                return searchResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
