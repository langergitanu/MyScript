package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ListPaperDocsSortBy {
    ACCESSED,
    MODIFIED,
    CREATED,
    OTHER;

    static class Serializer extends UnionSerializer<ListPaperDocsSortBy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListPaperDocsSortBy listPaperDocsSortBy, JsonGenerator jsonGenerator) throws IOException {
            int i = C42331.$SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsSortBy[listPaperDocsSortBy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("accessed");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("modified");
            } else if (i == 3) {
                jsonGenerator.writeString("created");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListPaperDocsSortBy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListPaperDocsSortBy listPaperDocsSortBy;
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
            if ("accessed".equals(tag)) {
                listPaperDocsSortBy = ListPaperDocsSortBy.ACCESSED;
            } else if ("modified".equals(tag)) {
                listPaperDocsSortBy = ListPaperDocsSortBy.MODIFIED;
            } else if ("created".equals(tag)) {
                listPaperDocsSortBy = ListPaperDocsSortBy.CREATED;
            } else {
                listPaperDocsSortBy = ListPaperDocsSortBy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listPaperDocsSortBy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.ListPaperDocsSortBy$1 */
    static /* synthetic */ class C42331 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsSortBy;

        static {
            int[] iArr = new int[ListPaperDocsSortBy.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsSortBy = iArr;
            try {
                iArr[ListPaperDocsSortBy.ACCESSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsSortBy[ListPaperDocsSortBy.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ListPaperDocsSortBy[ListPaperDocsSortBy.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
