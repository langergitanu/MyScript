package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupDeleteError {
    GROUP_NOT_FOUND,
    OTHER,
    SYSTEM_MANAGED_GROUP_DISALLOWED,
    GROUP_ALREADY_DELETED;

    static class Serializer extends UnionSerializer<GroupDeleteError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupDeleteError groupDeleteError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43361.$SwitchMap$com$dropbox$core$v2$team$GroupDeleteError[groupDeleteError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("group_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("other");
            } else if (i == 3) {
                jsonGenerator.writeString("system_managed_group_disallowed");
            } else {
                if (i == 4) {
                    jsonGenerator.writeString("group_already_deleted");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + groupDeleteError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupDeleteError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupDeleteError groupDeleteError;
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
                groupDeleteError = GroupDeleteError.GROUP_NOT_FOUND;
            } else if ("other".equals(tag)) {
                groupDeleteError = GroupDeleteError.OTHER;
            } else if ("system_managed_group_disallowed".equals(tag)) {
                groupDeleteError = GroupDeleteError.SYSTEM_MANAGED_GROUP_DISALLOWED;
            } else if ("group_already_deleted".equals(tag)) {
                groupDeleteError = GroupDeleteError.GROUP_ALREADY_DELETED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupDeleteError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupDeleteError$1 */
    static /* synthetic */ class C43361 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupDeleteError;

        static {
            int[] iArr = new int[GroupDeleteError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupDeleteError = iArr;
            try {
                iArr[GroupDeleteError.GROUP_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupDeleteError[GroupDeleteError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupDeleteError[GroupDeleteError.SYSTEM_MANAGED_GROUP_DISALLOWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupDeleteError[GroupDeleteError.GROUP_ALREADY_DELETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
