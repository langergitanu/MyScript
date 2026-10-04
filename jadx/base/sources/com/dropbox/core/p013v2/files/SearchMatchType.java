package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SearchMatchType {
    FILENAME,
    CONTENT,
    BOTH;

    static class Serializer extends UnionSerializer<SearchMatchType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SearchMatchType searchMatchType, JsonGenerator jsonGenerator) throws IOException {
            int i = C41991.$SwitchMap$com$dropbox$core$v2$files$SearchMatchType[searchMatchType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("filename");
            } else if (i == 2) {
                jsonGenerator.writeString(FirebaseAnalytics.Param.CONTENT);
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("both");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + searchMatchType);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SearchMatchType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SearchMatchType searchMatchType;
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
                searchMatchType = SearchMatchType.FILENAME;
            } else if (FirebaseAnalytics.Param.CONTENT.equals(tag)) {
                searchMatchType = SearchMatchType.CONTENT;
            } else if ("both".equals(tag)) {
                searchMatchType = SearchMatchType.BOTH;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return searchMatchType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SearchMatchType$1 */
    static /* synthetic */ class C41991 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SearchMatchType;

        static {
            int[] iArr = new int[SearchMatchType.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SearchMatchType = iArr;
            try {
                iArr[SearchMatchType.FILENAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchMatchType[SearchMatchType.CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SearchMatchType[SearchMatchType.BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
