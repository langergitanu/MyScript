package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamFolderTeamSharedDropboxError {
    DISALLOWED,
    OTHER;

    static class Serializer extends UnionSerializer<TeamFolderTeamSharedDropboxError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError, JsonGenerator jsonGenerator) throws IOException {
            if (C44121.f769x1a89d12[teamFolderTeamSharedDropboxError.ordinal()] == 1) {
                jsonGenerator.writeString("disallowed");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderTeamSharedDropboxError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderTeamSharedDropboxError teamFolderTeamSharedDropboxError;
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
            if ("disallowed".equals(tag)) {
                teamFolderTeamSharedDropboxError = TeamFolderTeamSharedDropboxError.DISALLOWED;
            } else {
                teamFolderTeamSharedDropboxError = TeamFolderTeamSharedDropboxError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderTeamSharedDropboxError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderTeamSharedDropboxError$1 */
    static /* synthetic */ class C44121 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$TeamFolderTeamSharedDropboxError */
        static final /* synthetic */ int[] f769x1a89d12;

        static {
            int[] iArr = new int[TeamFolderTeamSharedDropboxError.values().length];
            f769x1a89d12 = iArr;
            try {
                iArr[TeamFolderTeamSharedDropboxError.DISALLOWED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
