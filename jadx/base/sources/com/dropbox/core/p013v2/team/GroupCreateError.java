package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupCreateError {
    GROUP_NAME_ALREADY_USED,
    GROUP_NAME_INVALID,
    EXTERNAL_ID_ALREADY_IN_USE,
    SYSTEM_MANAGED_GROUP_DISALLOWED,
    OTHER;

    static class Serializer extends UnionSerializer<GroupCreateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupCreateError groupCreateError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43351.$SwitchMap$com$dropbox$core$v2$team$GroupCreateError[groupCreateError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("group_name_already_used");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("group_name_invalid");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("external_id_already_in_use");
            } else if (i == 4) {
                jsonGenerator.writeString("system_managed_group_disallowed");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupCreateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupCreateError groupCreateError;
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
            if ("group_name_already_used".equals(tag)) {
                groupCreateError = GroupCreateError.GROUP_NAME_ALREADY_USED;
            } else if ("group_name_invalid".equals(tag)) {
                groupCreateError = GroupCreateError.GROUP_NAME_INVALID;
            } else if ("external_id_already_in_use".equals(tag)) {
                groupCreateError = GroupCreateError.EXTERNAL_ID_ALREADY_IN_USE;
            } else if ("system_managed_group_disallowed".equals(tag)) {
                groupCreateError = GroupCreateError.SYSTEM_MANAGED_GROUP_DISALLOWED;
            } else {
                groupCreateError = GroupCreateError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupCreateError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupCreateError$1 */
    static /* synthetic */ class C43351 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupCreateError;

        static {
            int[] iArr = new int[GroupCreateError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupCreateError = iArr;
            try {
                iArr[GroupCreateError.GROUP_NAME_ALREADY_USED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupCreateError[GroupCreateError.GROUP_NAME_INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupCreateError[GroupCreateError.EXTERNAL_ID_ALREADY_IN_USE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupCreateError[GroupCreateError.SYSTEM_MANAGED_GROUP_DISALLOWED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
