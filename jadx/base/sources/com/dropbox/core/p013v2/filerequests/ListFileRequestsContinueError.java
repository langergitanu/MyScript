package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ListFileRequestsContinueError {
    DISABLED_FOR_TEAM,
    OTHER,
    INVALID_CURSOR;

    static class Serializer extends UnionSerializer<ListFileRequestsContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListFileRequestsContinueError listFileRequestsContinueError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41371.f685x79cbec8d[listFileRequestsContinueError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled_for_team");
            } else if (i == 2) {
                jsonGenerator.writeString("other");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("invalid_cursor");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + listFileRequestsContinueError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListFileRequestsContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListFileRequestsContinueError listFileRequestsContinueError;
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
            if ("disabled_for_team".equals(tag)) {
                listFileRequestsContinueError = ListFileRequestsContinueError.DISABLED_FOR_TEAM;
            } else if ("other".equals(tag)) {
                listFileRequestsContinueError = ListFileRequestsContinueError.OTHER;
            } else if ("invalid_cursor".equals(tag)) {
                listFileRequestsContinueError = ListFileRequestsContinueError.INVALID_CURSOR;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listFileRequestsContinueError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.filerequests.ListFileRequestsContinueError$1 */
    static /* synthetic */ class C41371 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$filerequests$ListFileRequestsContinueError */
        static final /* synthetic */ int[] f685x79cbec8d;

        static {
            int[] iArr = new int[ListFileRequestsContinueError.values().length];
            f685x79cbec8d = iArr;
            try {
                iArr[ListFileRequestsContinueError.DISABLED_FOR_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f685x79cbec8d[ListFileRequestsContinueError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f685x79cbec8d[ListFileRequestsContinueError.INVALID_CURSOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
