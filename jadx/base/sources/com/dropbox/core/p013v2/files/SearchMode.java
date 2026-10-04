package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SearchMode {
    FILENAME,
    FILENAME_AND_CONTENT,
    DELETED_FILENAME;

    static class Serializer extends UnionSerializer<SearchMode> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SearchMode searchMode, JsonGenerator jsonGenerator) throws IOException {
            int i = C42011.$SwitchMap$com$dropbox$core$v2$files$SearchMode[searchMode.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("filename");
            } else if (i == 2) {
                jsonGenerator.writeString("filename_and_content");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("deleted_filename");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + searchMode);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SearchMode deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SearchMode searchMode;
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
            if ("filename".equals(tag)) {
                searchMode = SearchMode.FILENAME;
            } else if ("filename_and_content".equals(tag)) {
                searchMode = SearchMode.FILENAME_AND_CONTENT;
            } else if ("deleted_filename".equals(tag)) {
                searchMode = SearchMode.DELETED_FILENAME;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return searchMode;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SearchMode$1 */
    static /* synthetic */ class C42011 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SearchMode;

        static {
            int[] iArr = new int[SearchMode.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SearchMode = iArr;
            try {
                iArr[SearchMode.FILENAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchMode[SearchMode.FILENAME_AND_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchMode[SearchMode.DELETED_FILENAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
