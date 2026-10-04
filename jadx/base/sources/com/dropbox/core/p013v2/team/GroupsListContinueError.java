package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupsListContinueError {
    INVALID_CURSOR,
    OTHER;

    static class Serializer extends UnionSerializer<GroupsListContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupsListContinueError groupsListContinueError, JsonGenerator jsonGenerator) throws IOException {
            if (C43451.$SwitchMap$com$dropbox$core$v2$team$GroupsListContinueError[groupsListContinueError.ordinal()] == 1) {
                jsonGenerator.writeString("invalid_cursor");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupsListContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupsListContinueError groupsListContinueError;
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
                groupsListContinueError = GroupsListContinueError.INVALID_CURSOR;
            } else {
                groupsListContinueError = GroupsListContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupsListContinueError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupsListContinueError$1 */
    static /* synthetic */ class C43451 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupsListContinueError;

        static {
            int[] iArr = new int[GroupsListContinueError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupsListContinueError = iArr;
            try {
                iArr[GroupsListContinueError.INVALID_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
