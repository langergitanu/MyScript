package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.SearchMatchFieldOptions;
import com.dropbox.core.p013v2.files.SearchOptions;
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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class SearchV2Arg {

    @Nullable
    protected final Boolean includeHighlights;

    @Nullable
    protected final SearchMatchFieldOptions matchFieldOptions;

    @Nullable
    protected final SearchOptions options;

    @Nonnull
    protected final String query;

    public SearchV2Arg(@Nonnull String str, @Nullable SearchOptions searchOptions, @Nullable SearchMatchFieldOptions searchMatchFieldOptions, @Nullable Boolean bool) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        if (str.length() > 1000) {
            throw new IllegalArgumentException("String 'query' is longer than 1000");
        }
        this.query = str;
        this.options = searchOptions;
        this.matchFieldOptions = searchMatchFieldOptions;
        this.includeHighlights = bool;
    }

    public SearchV2Arg(@Nonnull String str) {
        this(str, null, null, null);
    }

    @Nonnull
    public String getQuery() {
        return this.query;
    }

    @Nullable
    public SearchOptions getOptions() {
        return this.options;
    }

    @Nullable
    public SearchMatchFieldOptions getMatchFieldOptions() {
        return this.matchFieldOptions;
    }

    @Nullable
    public Boolean getIncludeHighlights() {
        return this.includeHighlights;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected Boolean includeHighlights;
        protected SearchMatchFieldOptions matchFieldOptions;
        protected SearchOptions options;
        protected final String query;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'query' is null");
            }
            if (str.length() > 1000) {
                throw new IllegalArgumentException("String 'query' is longer than 1000");
            }
            this.query = str;
            this.options = null;
            this.matchFieldOptions = null;
            this.includeHighlights = null;
        }

        public Builder withOptions(SearchOptions searchOptions) {
            this.options = searchOptions;
            return this;
        }

        public Builder withMatchFieldOptions(SearchMatchFieldOptions searchMatchFieldOptions) {
            this.matchFieldOptions = searchMatchFieldOptions;
            return this;
        }

        public Builder withIncludeHighlights(Boolean bool) {
            this.includeHighlights = bool;
            return this;
        }

        public SearchV2Arg build() {
            return new SearchV2Arg(this.query, this.options, this.matchFieldOptions, this.includeHighlights);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.query, this.options, this.matchFieldOptions, this.includeHighlights});
    }

    public boolean equals(Object obj) {
        SearchOptions searchOptions;
        SearchOptions searchOptions2;
        SearchMatchFieldOptions searchMatchFieldOptions;
        SearchMatchFieldOptions searchMatchFieldOptions2;
        Boolean bool;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SearchV2Arg searchV2Arg = (SearchV2Arg) obj;
        String str = this.query;
        String str2 = searchV2Arg.query;
        return (str == str2 || str.equals(str2)) && ((searchOptions = this.options) == (searchOptions2 = searchV2Arg.options) || (searchOptions != null && searchOptions.equals(searchOptions2))) && (((searchMatchFieldOptions = this.matchFieldOptions) == (searchMatchFieldOptions2 = searchV2Arg.matchFieldOptions) || (searchMatchFieldOptions != null && searchMatchFieldOptions.equals(searchMatchFieldOptions2))) && ((bool = this.includeHighlights) == (bool2 = searchV2Arg.includeHighlights) || (bool != null && bool.equals(bool2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SearchV2Arg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SearchV2Arg searchV2Arg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(SearchIntents.EXTRA_QUERY);
            StoneSerializers.string().serialize(searchV2Arg.query, jsonGenerator);
            if (searchV2Arg.options != null) {
                jsonGenerator.writeFieldName("options");
                StoneSerializers.nullableStruct(SearchOptions.Serializer.INSTANCE).serialize(searchV2Arg.options, jsonGenerator);
            }
            if (searchV2Arg.matchFieldOptions != null) {
                jsonGenerator.writeFieldName("match_field_options");
                StoneSerializers.nullableStruct(SearchMatchFieldOptions.Serializer.INSTANCE).serialize(searchV2Arg.matchFieldOptions, jsonGenerator);
            }
            if (searchV2Arg.includeHighlights != null) {
                jsonGenerator.writeFieldName("include_highlights");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(searchV2Arg.includeHighlights, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SearchV2Arg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SearchOptions searchOptions = null;
                SearchMatchFieldOptions searchMatchFieldOptions = null;
                Boolean bool = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (SearchIntents.EXTRA_QUERY.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("options".equals(currentName)) {
                        searchOptions = (SearchOptions) StoneSerializers.nullableStruct(SearchOptions.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("match_field_options".equals(currentName)) {
                        searchMatchFieldOptions = (SearchMatchFieldOptions) StoneSerializers.nullableStruct(SearchMatchFieldOptions.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("include_highlights".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"query\" missing.");
                }
                SearchV2Arg searchV2Arg = new SearchV2Arg(strDeserialize, searchOptions, searchMatchFieldOptions, bool);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(searchV2Arg, searchV2Arg.toStringMultiline());
                return searchV2Arg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
