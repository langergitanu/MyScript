package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersListContinueError {
    INVALID_CURSOR,
    OTHER;

    static class Serializer extends UnionSerializer<MembersListContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersListContinueError membersListContinueError, JsonGenerator jsonGenerator) throws IOException {
            if (C43751.$SwitchMap$com$dropbox$core$v2$team$MembersListContinueError[membersListContinueError.ordinal()] == 1) {
                jsonGenerator.writeString("invalid_cursor");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersListContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersListContinueError membersListContinueError;
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
                membersListContinueError = MembersListContinueError.INVALID_CURSOR;
            } else {
                membersListContinueError = MembersListContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersListContinueError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersListContinueError$1 */
    static /* synthetic */ class C43751 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersListContinueError;

        static {
            int[] iArr = new int[MembersListContinueError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersListContinueError = iArr;
            try {
                iArr[MembersListContinueError.INVALID_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
