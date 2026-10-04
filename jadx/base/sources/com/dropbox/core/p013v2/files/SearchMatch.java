package com.dropbox.core.p013v2.files;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.files.Metadata;
import com.dropbox.core.p013v2.files.SearchMatchType;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class SearchMatch {

    @Nonnull
    protected final SearchMatchType matchType;

    @Nonnull
    protected final Metadata metadata;

    public SearchMatch(@Nonnull SearchMatchType searchMatchType, @Nonnull Metadata metadata) {
        if (searchMatchType == null) {
            throw new IllegalArgumentException("Required value for 'matchType' is null");
        }
        this.matchType = searchMatchType;
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
    }

    @Nonnull
    public SearchMatchType getMatchType() {
        return this.matchType;
    }

    @Nonnull
    public Metadata getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.matchType, this.metadata});
    }

    public boolean equals(Object obj) {
        Metadata metadata;
        Metadata metadata2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SearchMatch searchMatch = (SearchMatch) obj;
        SearchMatchType searchMatchType = this.matchType;
        SearchMatchType searchMatchType2 = searchMatch.matchType;
        return (searchMatchType == searchMatchType2 || searchMatchType.equals(searchMatchType2)) && ((metadata = this.metadata) == (metadata2 = searchMatch.metadata) || metadata.equals(metadata2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SearchMatch> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SearchMatch searchMatch, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("match_type");
            SearchMatchType.Serializer.INSTANCE.serialize(searchMatch.matchType, jsonGenerator);
            jsonGenerator.writeFieldName(TtmlNode.TAG_METADATA);
            Metadata.Serializer.INSTANCE.serialize(searchMatch.metadata, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SearchMatch deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SearchMatchType searchMatchTypeDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Metadata metadataDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("match_type".equals(currentName)) {
                        searchMatchTypeDeserialize = SearchMatchType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (TtmlNode.TAG_METADATA.equals(currentName)) {
                        metadataDeserialize = Metadata.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (searchMatchTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"match_type\" missing.");
                }
                if (metadataDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"metadata\" missing.");
                }
                SearchMatch searchMatch = new SearchMatch(searchMatchTypeDeserialize, metadataDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(searchMatch, searchMatch.toStringMultiline());
                return searchMatch;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
