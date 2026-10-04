package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ListPaperDocsSortOrder {
    ASCENDING,
    DESCENDING,
    OTHER;

    static class Serializer extends UnionSerializer<ListPaperDocsSortOrder> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListPaperDocsSortOrder listPaperDocsSortOrder, JsonGenerator jsonGenerator) throws IOException {
            int i = C42341.$SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsSortOrder[listPaperDocsSortOrder.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("ascending");
            } else if (i == 2) {
                jsonGenerator.writeString("descending");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListPaperDocsSortOrder deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListPaperDocsSortOrder listPaperDocsSortOrder;
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
            if ("ascending".equals(tag)) {
                listPaperDocsSortOrder = ListPaperDocsSortOrder.ASCENDING;
            } else if ("descending".equals(tag)) {
                listPaperDocsSortOrder = ListPaperDocsSortOrder.DESCENDING;
            } else {
                listPaperDocsSortOrder = ListPaperDocsSortOrder.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listPaperDocsSortOrder;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.ListPaperDocsSortOrder$1 */
    static /* synthetic */ class C42341 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsSortOrder;

        static {
            int[] iArr = new int[ListPaperDocsSortOrder.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsSortOrder = iArr;
            try {
                iArr[ListPaperDocsSortOrder.ASCENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsSortOrder[ListPaperDocsSortOrder.DESCENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
