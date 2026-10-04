package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SearchOrderBy {
    RELEVANCE,
    LAST_MODIFIED_TIME,
    OTHER;

    static class Serializer extends UnionSerializer<SearchOrderBy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SearchOrderBy searchOrderBy, JsonGenerator jsonGenerator) throws IOException {
            int i = C42021.$SwitchMap$com$dropbox$core$v2$files$SearchOrderBy[searchOrderBy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("relevance");
            } else if (i == 2) {
                jsonGenerator.writeString("last_modified_time");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SearchOrderBy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SearchOrderBy searchOrderBy;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("relevance".equals(tag)) {
                searchOrderBy = SearchOrderBy.RELEVANCE;
            } else if ("last_modified_time".equals(tag)) {
                searchOrderBy = SearchOrderBy.LAST_MODIFIED_TIME;
            } else {
                searchOrderBy = SearchOrderBy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return searchOrderBy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SearchOrderBy$1 */
    static /* synthetic */ class C42021 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SearchOrderBy;

        static {
            int[] iArr = new int[SearchOrderBy.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SearchOrderBy = iArr;
            try {
                iArr[SearchOrderBy.RELEVANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchOrderBy[SearchOrderBy.LAST_MODIFIED_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
