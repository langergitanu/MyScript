package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamFolderListContinueError {
    INVALID_CURSOR,
    OTHER;

    static class Serializer extends UnionSerializer<TeamFolderListContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderListContinueError teamFolderListContinueError, JsonGenerator jsonGenerator) throws IOException {
            if (C44081.$SwitchMap$com$dropbox$core$v2$team$TeamFolderListContinueError[teamFolderListContinueError.ordinal()] == 1) {
                jsonGenerator.writeString("invalid_cursor");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderListContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderListContinueError teamFolderListContinueError;
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
                teamFolderListContinueError = TeamFolderListContinueError.INVALID_CURSOR;
            } else {
                teamFolderListContinueError = TeamFolderListContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderListContinueError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderListContinueError$1 */
    static /* synthetic */ class C44081 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamFolderListContinueError;

        static {
            int[] iArr = new int[TeamFolderListContinueError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamFolderListContinueError = iArr;
            try {
                iArr[TeamFolderListContinueError.INVALID_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
