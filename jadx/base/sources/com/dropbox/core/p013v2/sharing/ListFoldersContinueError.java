package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ListFoldersContinueError {
    INVALID_CURSOR,
    OTHER;

    static class Serializer extends UnionSerializer<ListFoldersContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListFoldersContinueError listFoldersContinueError, JsonGenerator jsonGenerator) throws IOException {
            if (C42781.$SwitchMap$com$dropbox$core$v2$sharing$ListFoldersContinueError[listFoldersContinueError.ordinal()] == 1) {
                jsonGenerator.writeString("invalid_cursor");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListFoldersContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListFoldersContinueError listFoldersContinueError;
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
            if ("invalid_cursor".equals(tag)) {
                listFoldersContinueError = ListFoldersContinueError.INVALID_CURSOR;
            } else {
                listFoldersContinueError = ListFoldersContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listFoldersContinueError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ListFoldersContinueError$1 */
    static /* synthetic */ class C42781 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$ListFoldersContinueError;

        static {
            int[] iArr = new int[ListFoldersContinueError.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$ListFoldersContinueError = iArr;
            try {
                iArr[ListFoldersContinueError.INVALID_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
