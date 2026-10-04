package com.dropbox.core.p013v2.files;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.files.SearchMode;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.actions.SearchIntents;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class SearchArg {
    protected final long maxResults;

    @Nonnull
    protected final SearchMode mode;

    @Nonnull
    protected final String path;

    @Nonnull
    protected final String query;
    protected final long start;

    public SearchArg(@Nonnull String str, @Nonnull String str2, long j, long j2, @Nonnull SearchMode searchMode) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        if (str2.length() > 1000) {
            throw new IllegalArgumentException("String 'query' is longer than 1000");
        }
        this.query = str2;
        if (j > 9999) {
            throw new IllegalArgumentException("Number 'start' is larger than 9999L");
        }
        this.start = j;
        if (j2 < 1) {
            throw new IllegalArgumentException("Number 'maxResults' is smaller than 1L");
        }
        if (j2 > 1000) {
            throw new IllegalArgumentException("Number 'maxResults' is larger than 1000L");
        }
        this.maxResults = j2;
        if (searchMode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = searchMode;
    }

    public SearchArg(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, 0L, 100L, SearchMode.FILENAME);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nonnull
    public String getQuery() {
        return this.query;
    }

    public long getStart() {
        return this.start;
    }

    public long getMaxResults() {
        return this.maxResults;
    }

    @Nonnull
    public SearchMode getMode() {
        return this.mode;
    }

    public static Builder newBuilder(String str, String str2) {
        return new Builder(str, str2);
    }

    public static class Builder {
        protected long maxResults;
        protected SearchMode mode;
        protected final String path;
        protected final String query;
        protected long start;

        protected Builder(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", str)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'query' is null");
            }
            if (str2.length() > 1000) {
                throw new IllegalArgumentException("String 'query' is longer than 1000");
            }
            this.query = str2;
            this.start = 0L;
            this.maxResults = 100L;
            this.mode = SearchMode.FILENAME;
        }

        public Builder withStart(Long l) {
            if (l.longValue() > 9999) {
                throw new IllegalArgumentException("Number 'start' is larger than 9999L");
            }
            if (l != null) {
                this.start = l.longValue();
                return this;
            }
            this.start = 0L;
            return this;
        }

        public Builder withMaxResults(Long l) {
            if (l.longValue() < 1) {
                throw new IllegalArgumentException("Number 'maxResults' is smaller than 1L");
            }
            if (l.longValue() > 1000) {
                throw new IllegalArgumentException("Number 'maxResults' is larger than 1000L");
            }
            if (l != null) {
                this.maxResults = l.longValue();
                return this;
            }
            this.maxResults = 100L;
            return this;
        }

        public Builder withMode(SearchMode searchMode) {
            if (searchMode != null) {
                this.mode = searchMode;
                return this;
            }
            this.mode = SearchMode.FILENAME;
            return this;
        }

        public SearchArg build() {
            return new SearchArg(this.path, this.query, this.start, this.maxResults, this.mode);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.query, Long.valueOf(this.start), Long.valueOf(this.maxResults), this.mode});
    }

    public boolean equals(Object obj) {
        SearchArg searchArg;
        String str;
        String str2;
        String str3;
        String str4;
        SearchMode searchMode;
        SearchMode searchMode2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.path) == (str2 = (searchArg = (SearchArg) obj).path) || str.equals(str2)) && (((str3 = this.query) == (str4 = searchArg.query) || str3.equals(str4)) && this.start == searchArg.start && this.maxResults == searchArg.maxResults && ((searchMode = this.mode) == (searchMode2 = searchArg.mode) || searchMode.equals(searchMode2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SearchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SearchArg searchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(searchArg.path, jsonGenerator);
            jsonGenerator.writeFieldName(SearchIntents.EXTRA_QUERY);
            StoneSerializers.string().serialize(searchArg.query, jsonGenerator);
            jsonGenerator.writeFieldName(TtmlNode.START);
            StoneSerializers.uInt64().serialize(Long.valueOf(searchArg.start), jsonGenerator);
            jsonGenerator.writeFieldName("max_results");
            StoneSerializers.uInt64().serialize(Long.valueOf(searchArg.maxResults), jsonGenerator);
            jsonGenerator.writeFieldName("mode");
            SearchMode.Serializer.INSTANCE.serialize(searchArg.mode, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SearchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = 0L;
                Long lDeserialize2 = 100L;
                String strDeserialize = null;
                String strDeserialize2 = null;
                SearchMode searchModeDeserialize = SearchMode.FILENAME;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (SearchIntents.EXTRA_QUERY.equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if (TtmlNode.START.equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("max_results".equals(currentName)) {
                        lDeserialize2 = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("mode".equals(currentName)) {
                        searchModeDeserialize = SearchMode.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"query\" missing.");
                }
                SearchArg searchArg = new SearchArg(strDeserialize, strDeserialize2, lDeserialize.longValue(), lDeserialize2.longValue(), searchModeDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(searchArg, searchArg.toStringMultiline());
                return searchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
