package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupsMembersListContinueError {
    INVALID_CURSOR,
    OTHER;

    static class Serializer extends UnionSerializer<GroupsMembersListContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupsMembersListContinueError groupsMembersListContinueError, JsonGenerator jsonGenerator) throws IOException {
            if (C43461.f747x9a23a97[groupsMembersListContinueError.ordinal()] == 1) {
                jsonGenerator.writeString("invalid_cursor");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupsMembersListContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupsMembersListContinueError groupsMembersListContinueError;
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
                groupsMembersListContinueError = GroupsMembersListContinueError.INVALID_CURSOR;
            } else {
                groupsMembersListContinueError = GroupsMembersListContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupsMembersListContinueError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupsMembersListContinueError$1 */
    static /* synthetic */ class C43461 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$GroupsMembersListContinueError */
        static final /* synthetic */ int[] f747x9a23a97;

        static {
            int[] iArr = new int[GroupsMembersListContinueError.values().length];
            f747x9a23a97 = iArr;
            try {
                iArr[GroupsMembersListContinueError.INVALID_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
