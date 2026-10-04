package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupAccessType {
    MEMBER,
    OWNER;

    static class Serializer extends UnionSerializer<GroupAccessType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupAccessType groupAccessType, JsonGenerator jsonGenerator) throws IOException {
            int i = C43341.$SwitchMap$com$dropbox$core$v2$team$GroupAccessType[groupAccessType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("member");
            } else {
                if (i == 2) {
                    jsonGenerator.writeString("owner");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + groupAccessType);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupAccessType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupAccessType groupAccessType;
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
            if ("member".equals(tag)) {
                groupAccessType = GroupAccessType.MEMBER;
            } else if ("owner".equals(tag)) {
                groupAccessType = GroupAccessType.OWNER;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupAccessType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupAccessType$1 */
    static /* synthetic */ class C43341 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupAccessType;

        static {
            int[] iArr = new int[GroupAccessType.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupAccessType = iArr;
            try {
                iArr[GroupAccessType.MEMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupAccessType[GroupAccessType.OWNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
