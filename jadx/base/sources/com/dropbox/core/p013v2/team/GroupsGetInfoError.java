package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupsGetInfoError {
    GROUP_NOT_ON_TEAM,
    OTHER;

    static class Serializer extends UnionSerializer<GroupsGetInfoError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupsGetInfoError groupsGetInfoError, JsonGenerator jsonGenerator) throws IOException {
            if (C43431.$SwitchMap$com$dropbox$core$v2$team$GroupsGetInfoError[groupsGetInfoError.ordinal()] == 1) {
                jsonGenerator.writeString("group_not_on_team");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupsGetInfoError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupsGetInfoError groupsGetInfoError;
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
            if ("group_not_on_team".equals(tag)) {
                groupsGetInfoError = GroupsGetInfoError.GROUP_NOT_ON_TEAM;
            } else {
                groupsGetInfoError = GroupsGetInfoError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupsGetInfoError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupsGetInfoError$1 */
    static /* synthetic */ class C43431 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupsGetInfoError;

        static {
            int[] iArr = new int[GroupsGetInfoError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupsGetInfoError = iArr;
            try {
                iArr[GroupsGetInfoError.GROUP_NOT_ON_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
