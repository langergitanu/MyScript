package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupSelectorError {
    GROUP_NOT_FOUND,
    OTHER;

    static class Serializer extends UnionSerializer<GroupSelectorError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupSelectorError groupSelectorError, JsonGenerator jsonGenerator) throws IOException {
            if (C43411.$SwitchMap$com$dropbox$core$v2$team$GroupSelectorError[groupSelectorError.ordinal()] == 1) {
                jsonGenerator.writeString("group_not_found");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupSelectorError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupSelectorError groupSelectorError;
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
            if ("group_not_found".equals(tag)) {
                groupSelectorError = GroupSelectorError.GROUP_NOT_FOUND;
            } else {
                groupSelectorError = GroupSelectorError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupSelectorError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupSelectorError$1 */
    static /* synthetic */ class C43411 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupSelectorError;

        static {
            int[] iArr = new int[GroupSelectorError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupSelectorError = iArr;
            try {
                iArr[GroupSelectorError.GROUP_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
