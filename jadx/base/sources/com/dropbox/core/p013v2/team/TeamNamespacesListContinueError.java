package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamNamespacesListContinueError {
    INVALID_ARG,
    OTHER,
    INVALID_CURSOR;

    static class Serializer extends UnionSerializer<TeamNamespacesListContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamNamespacesListContinueError teamNamespacesListContinueError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44161.f771xf6f1bd75[teamNamespacesListContinueError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invalid_arg");
            } else if (i == 2) {
                jsonGenerator.writeString("other");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("invalid_cursor");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + teamNamespacesListContinueError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamNamespacesListContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamNamespacesListContinueError teamNamespacesListContinueError;
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
            if ("invalid_arg".equals(tag)) {
                teamNamespacesListContinueError = TeamNamespacesListContinueError.INVALID_ARG;
            } else if ("other".equals(tag)) {
                teamNamespacesListContinueError = TeamNamespacesListContinueError.OTHER;
            } else if ("invalid_cursor".equals(tag)) {
                teamNamespacesListContinueError = TeamNamespacesListContinueError.INVALID_CURSOR;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamNamespacesListContinueError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamNamespacesListContinueError$1 */
    static /* synthetic */ class C44161 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$TeamNamespacesListContinueError */
        static final /* synthetic */ int[] f771xf6f1bd75;

        static {
            int[] iArr = new int[TeamNamespacesListContinueError.values().length];
            f771xf6f1bd75 = iArr;
            try {
                iArr[TeamNamespacesListContinueError.INVALID_ARG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f771xf6f1bd75[TeamNamespacesListContinueError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f771xf6f1bd75[TeamNamespacesListContinueError.INVALID_CURSOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
