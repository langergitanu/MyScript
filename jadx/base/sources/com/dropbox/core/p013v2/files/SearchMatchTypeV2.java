package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SearchMatchTypeV2 {
    FILENAME,
    FILE_CONTENT,
    FILENAME_AND_CONTENT,
    IMAGE_CONTENT,
    OTHER;

    static class Serializer extends UnionSerializer<SearchMatchTypeV2> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SearchMatchTypeV2 searchMatchTypeV2, JsonGenerator jsonGenerator) throws IOException {
            int i = C42001.$SwitchMap$com$dropbox$core$v2$files$SearchMatchTypeV2[searchMatchTypeV2.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("filename");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("file_content");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("filename_and_content");
            } else if (i == 4) {
                jsonGenerator.writeString("image_content");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SearchMatchTypeV2 deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SearchMatchTypeV2 searchMatchTypeV2;
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
                searchMatchTypeV2 = SearchMatchTypeV2.FILENAME;
            } else if ("file_content".equals(tag)) {
                searchMatchTypeV2 = SearchMatchTypeV2.FILE_CONTENT;
            } else if ("filename_and_content".equals(tag)) {
                searchMatchTypeV2 = SearchMatchTypeV2.FILENAME_AND_CONTENT;
            } else if ("image_content".equals(tag)) {
                searchMatchTypeV2 = SearchMatchTypeV2.IMAGE_CONTENT;
            } else {
                searchMatchTypeV2 = SearchMatchTypeV2.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return searchMatchTypeV2;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SearchMatchTypeV2$1 */
    static /* synthetic */ class C42001 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SearchMatchTypeV2;

        static {
            int[] iArr = new int[SearchMatchTypeV2.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SearchMatchTypeV2 = iArr;
            try {
                iArr[SearchMatchTypeV2.FILENAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchMatchTypeV2[SearchMatchTypeV2.FILE_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchMatchTypeV2[SearchMatchTypeV2.FILENAME_AND_CONTENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchMatchTypeV2[SearchMatchTypeV2.IMAGE_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
