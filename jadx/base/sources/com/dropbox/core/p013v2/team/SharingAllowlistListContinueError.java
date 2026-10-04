package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharingAllowlistListContinueError {
    INVALID_CURSOR,
    OTHER;

    static class Serializer extends UnionSerializer<SharingAllowlistListContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharingAllowlistListContinueError sharingAllowlistListContinueError, JsonGenerator jsonGenerator) throws IOException {
            if (C43981.f765x6b4da13f[sharingAllowlistListContinueError.ordinal()] == 1) {
                jsonGenerator.writeString("invalid_cursor");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharingAllowlistListContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharingAllowlistListContinueError sharingAllowlistListContinueError;
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
                sharingAllowlistListContinueError = SharingAllowlistListContinueError.INVALID_CURSOR;
            } else {
                sharingAllowlistListContinueError = SharingAllowlistListContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharingAllowlistListContinueError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.SharingAllowlistListContinueError$1 */
    static /* synthetic */ class C43981 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$SharingAllowlistListContinueError */
        static final /* synthetic */ int[] f765x6b4da13f;

        static {
            int[] iArr = new int[SharingAllowlistListContinueError.values().length];
            f765x6b4da13f = iArr;
            try {
                iArr[SharingAllowlistListContinueError.INVALID_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
