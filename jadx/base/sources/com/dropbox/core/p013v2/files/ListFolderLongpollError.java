package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ListFolderLongpollError {
    RESET,
    OTHER;

    static class Serializer extends UnionSerializer<ListFolderLongpollError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListFolderLongpollError listFolderLongpollError, JsonGenerator jsonGenerator) throws IOException {
            if (C41691.$SwitchMap$com$dropbox$core$v2$files$ListFolderLongpollError[listFolderLongpollError.ordinal()] == 1) {
                jsonGenerator.writeString("reset");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListFolderLongpollError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListFolderLongpollError listFolderLongpollError;
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
            if ("reset".equals(tag)) {
                listFolderLongpollError = ListFolderLongpollError.RESET;
            } else {
                listFolderLongpollError = ListFolderLongpollError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listFolderLongpollError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.ListFolderLongpollError$1 */
    static /* synthetic */ class C41691 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$ListFolderLongpollError;

        static {
            int[] iArr = new int[ListFolderLongpollError.values().length];
            $SwitchMap$com$dropbox$core$v2$files$ListFolderLongpollError = iArr;
            try {
                iArr[ListFolderLongpollError.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
