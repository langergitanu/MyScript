package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ListPaperDocsFilterBy {
    DOCS_ACCESSED,
    DOCS_CREATED,
    OTHER;

    static class Serializer extends UnionSerializer<ListPaperDocsFilterBy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListPaperDocsFilterBy listPaperDocsFilterBy, JsonGenerator jsonGenerator) throws IOException {
            int i = C42321.$SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsFilterBy[listPaperDocsFilterBy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("docs_accessed");
            } else if (i == 2) {
                jsonGenerator.writeString("docs_created");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListPaperDocsFilterBy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListPaperDocsFilterBy listPaperDocsFilterBy;
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
            if ("docs_accessed".equals(tag)) {
                listPaperDocsFilterBy = ListPaperDocsFilterBy.DOCS_ACCESSED;
            } else if ("docs_created".equals(tag)) {
                listPaperDocsFilterBy = ListPaperDocsFilterBy.DOCS_CREATED;
            } else {
                listPaperDocsFilterBy = ListPaperDocsFilterBy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listPaperDocsFilterBy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.ListPaperDocsFilterBy$1 */
    static /* synthetic */ class C42321 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsFilterBy;

        static {
            int[] iArr = new int[ListPaperDocsFilterBy.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsFilterBy = iArr;
            try {
                iArr[ListPaperDocsFilterBy.DOCS_ACCESSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsFilterBy[ListPaperDocsFilterBy.DOCS_CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
