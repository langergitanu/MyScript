package com.dropbox.core.p013v2.files;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.files.HighlightSpan;
import com.dropbox.core.p013v2.files.MetadataV2;
import com.dropbox.core.p013v2.files.SearchMatchTypeV2;
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
public class SearchMatchV2 {

    @Nullable
    protected final List<HighlightSpan> highlightSpans;

    @Nullable
    protected final SearchMatchTypeV2 matchType;

    @Nonnull
    protected final MetadataV2 metadata;

    public SearchMatchV2(@Nonnull MetadataV2 metadataV2, @Nullable SearchMatchTypeV2 searchMatchTypeV2, @Nullable List<HighlightSpan> list) {
        if (metadataV2 == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadataV2;
        this.matchType = searchMatchTypeV2;
        if (list != null) {
            Iterator<HighlightSpan> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'highlightSpans' is null");
                }
            }
        }
        this.highlightSpans = list;
    }

    public SearchMatchV2(@Nonnull MetadataV2 metadataV2) {
        this(metadataV2, null, null);
    }

    @Nonnull
    public MetadataV2 getMetadata() {
        return this.metadata;
    }

    @Nullable
    public SearchMatchTypeV2 getMatchType() {
        return this.matchType;
    }

    @Nullable
    public List<HighlightSpan> getHighlightSpans() {
        return this.highlightSpans;
    }

    public static Builder newBuilder(MetadataV2 metadataV2) {
        return new Builder(metadataV2);
    }

    public static class Builder {
        protected List<HighlightSpan> highlightSpans;
        protected SearchMatchTypeV2 matchType;
        protected final MetadataV2 metadata;

        protected Builder(MetadataV2 metadataV2) {
            if (metadataV2 == null) {
                throw new IllegalArgumentException("Required value for 'metadata' is null");
            }
            this.metadata = metadataV2;
            this.matchType = null;
            this.highlightSpans = null;
        }

        public Builder withMatchType(SearchMatchTypeV2 searchMatchTypeV2) {
            this.matchType = searchMatchTypeV2;
            return this;
        }

        public Builder withHighlightSpans(List<HighlightSpan> list) {
            if (list != null) {
                Iterator<HighlightSpan> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'highlightSpans' is null");
                    }
                }
            }
            this.highlightSpans = list;
            return this;
        }

        public SearchMatchV2 build() {
            return new SearchMatchV2(this.metadata, this.matchType, this.highlightSpans);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.metadata, this.matchType, this.highlightSpans});
    }

    public boolean equals(Object obj) {
        SearchMatchTypeV2 searchMatchTypeV2;
        SearchMatchTypeV2 searchMatchTypeV22;
        List<HighlightSpan> list;
        List<HighlightSpan> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SearchMatchV2 searchMatchV2 = (SearchMatchV2) obj;
        MetadataV2 metadataV2 = this.metadata;
        MetadataV2 metadataV22 = searchMatchV2.metadata;
        return (metadataV2 == metadataV22 || metadataV2.equals(metadataV22)) && ((searchMatchTypeV2 = this.matchType) == (searchMatchTypeV22 = searchMatchV2.matchType) || (searchMatchTypeV2 != null && searchMatchTypeV2.equals(searchMatchTypeV22))) && ((list = this.highlightSpans) == (list2 = searchMatchV2.highlightSpans) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SearchMatchV2> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SearchMatchV2 searchMatchV2, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(TtmlNode.TAG_METADATA);
            MetadataV2.Serializer.INSTANCE.serialize(searchMatchV2.metadata, jsonGenerator);
            if (searchMatchV2.matchType != null) {
                jsonGenerator.writeFieldName("match_type");
                StoneSerializers.nullable(SearchMatchTypeV2.Serializer.INSTANCE).serialize(searchMatchV2.matchType, jsonGenerator);
            }
            if (searchMatchV2.highlightSpans != null) {
                jsonGenerator.writeFieldName("highlight_spans");
                StoneSerializers.nullable(StoneSerializers.list(HighlightSpan.Serializer.INSTANCE)).serialize(searchMatchV2.highlightSpans, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SearchMatchV2 deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MetadataV2 metadataV2Deserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SearchMatchTypeV2 searchMatchTypeV2 = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (TtmlNode.TAG_METADATA.equals(currentName)) {
                        metadataV2Deserialize = MetadataV2.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("match_type".equals(currentName)) {
                        searchMatchTypeV2 = (SearchMatchTypeV2) StoneSerializers.nullable(SearchMatchTypeV2.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("highlight_spans".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(HighlightSpan.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (metadataV2Deserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"metadata\" missing.");
                }
                SearchMatchV2 searchMatchV2 = new SearchMatchV2(metadataV2Deserialize, searchMatchTypeV2, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(searchMatchV2, searchMatchV2.toStringMultiline());
                return searchMatchV2;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
