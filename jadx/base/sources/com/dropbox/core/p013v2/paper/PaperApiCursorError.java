package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PaperApiCursorError {
    EXPIRED_CURSOR,
    INVALID_CURSOR,
    WRONG_USER_IN_CURSOR,
    RESET,
    OTHER;

    static class Serializer extends UnionSerializer<PaperApiCursorError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperApiCursorError paperApiCursorError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42361.$SwitchMap$com$dropbox$core$v2$paper$PaperApiCursorError[paperApiCursorError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("expired_cursor");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("invalid_cursor");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("wrong_user_in_cursor");
            } else if (i == 4) {
                jsonGenerator.writeString("reset");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperApiCursorError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperApiCursorError paperApiCursorError;
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
            if ("expired_cursor".equals(tag)) {
                paperApiCursorError = PaperApiCursorError.EXPIRED_CURSOR;
            } else if ("invalid_cursor".equals(tag)) {
                paperApiCursorError = PaperApiCursorError.INVALID_CURSOR;
            } else if ("wrong_user_in_cursor".equals(tag)) {
                paperApiCursorError = PaperApiCursorError.WRONG_USER_IN_CURSOR;
            } else if ("reset".equals(tag)) {
                paperApiCursorError = PaperApiCursorError.RESET;
            } else {
                paperApiCursorError = PaperApiCursorError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperApiCursorError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.PaperApiCursorError$1 */
    static /* synthetic */ class C42361 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$PaperApiCursorError;

        static {
            int[] iArr = new int[PaperApiCursorError.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$PaperApiCursorError = iArr;
            try {
                iArr[PaperApiCursorError.EXPIRED_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperApiCursorError[PaperApiCursorError.INVALID_CURSOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperApiCursorError[PaperApiCursorError.WRONG_USER_IN_CURSOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperApiCursorError[PaperApiCursorError.RESET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
