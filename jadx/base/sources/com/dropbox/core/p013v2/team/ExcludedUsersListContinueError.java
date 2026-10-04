package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ExcludedUsersListContinueError {
    INVALID_CURSOR,
    OTHER;

    static class Serializer extends UnionSerializer<ExcludedUsersListContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ExcludedUsersListContinueError excludedUsersListContinueError, JsonGenerator jsonGenerator) throws IOException {
            if (C43271.f745x8c7f05fe[excludedUsersListContinueError.ordinal()] == 1) {
                jsonGenerator.writeString("invalid_cursor");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ExcludedUsersListContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ExcludedUsersListContinueError excludedUsersListContinueError;
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
                excludedUsersListContinueError = ExcludedUsersListContinueError.INVALID_CURSOR;
            } else {
                excludedUsersListContinueError = ExcludedUsersListContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return excludedUsersListContinueError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ExcludedUsersListContinueError$1 */
    static /* synthetic */ class C43271 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$ExcludedUsersListContinueError */
        static final /* synthetic */ int[] f745x8c7f05fe;

        static {
            int[] iArr = new int[ExcludedUsersListContinueError.values().length];
            f745x8c7f05fe = iArr;
            try {
                iArr[ExcludedUsersListContinueError.INVALID_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
