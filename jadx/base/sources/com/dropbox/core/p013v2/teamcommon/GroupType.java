package com.dropbox.core.p013v2.teamcommon;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupType {
    TEAM,
    USER_MANAGED,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamcommon.GroupType$1 */
    static /* synthetic */ class C44261 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamcommon$GroupType;

        static {
            int[] iArr = new int[GroupType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamcommon$GroupType = iArr;
            try {
                iArr[GroupType.TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamcommon$GroupType[GroupType.USER_MANAGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<GroupType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupType groupType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44261.$SwitchMap$com$dropbox$core$v2$teamcommon$GroupType[groupType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("team");
            } else if (i == 2) {
                jsonGenerator.writeString("user_managed");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupType groupType;
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
            if ("team".equals(tag)) {
                groupType = GroupType.TEAM;
            } else if ("user_managed".equals(tag)) {
                groupType = GroupType.USER_MANAGED;
            } else {
                groupType = GroupType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupType;
        }
    }
}
