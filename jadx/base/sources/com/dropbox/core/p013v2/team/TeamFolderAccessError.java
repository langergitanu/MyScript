package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamFolderAccessError {
    INVALID_TEAM_FOLDER_ID,
    NO_ACCESS,
    OTHER;

    static class Serializer extends UnionSerializer<TeamFolderAccessError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderAccessError teamFolderAccessError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44001.$SwitchMap$com$dropbox$core$v2$team$TeamFolderAccessError[teamFolderAccessError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invalid_team_folder_id");
            } else if (i == 2) {
                jsonGenerator.writeString("no_access");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderAccessError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderAccessError teamFolderAccessError;
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
            if ("invalid_team_folder_id".equals(tag)) {
                teamFolderAccessError = TeamFolderAccessError.INVALID_TEAM_FOLDER_ID;
            } else if ("no_access".equals(tag)) {
                teamFolderAccessError = TeamFolderAccessError.NO_ACCESS;
            } else {
                teamFolderAccessError = TeamFolderAccessError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderAccessError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderAccessError$1 */
    static /* synthetic */ class C44001 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamFolderAccessError;

        static {
            int[] iArr = new int[TeamFolderAccessError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamFolderAccessError = iArr;
            try {
                iArr[TeamFolderAccessError.INVALID_TEAM_FOLDER_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderAccessError[TeamFolderAccessError.NO_ACCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
