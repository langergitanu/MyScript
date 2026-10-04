package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupUpdateError {
    GROUP_NOT_FOUND,
    OTHER,
    SYSTEM_MANAGED_GROUP_DISALLOWED,
    GROUP_NAME_ALREADY_USED,
    GROUP_NAME_INVALID,
    EXTERNAL_ID_ALREADY_IN_USE;

    static class Serializer extends UnionSerializer<GroupUpdateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupUpdateError groupUpdateError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43421.$SwitchMap$com$dropbox$core$v2$team$GroupUpdateError[groupUpdateError.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("group_not_found");
                    return;
                case 2:
                    jsonGenerator.writeString("other");
                    return;
                case 3:
                    jsonGenerator.writeString("system_managed_group_disallowed");
                    return;
                case 4:
                    jsonGenerator.writeString("group_name_already_used");
                    return;
                case 5:
                    jsonGenerator.writeString("group_name_invalid");
                    return;
                case 6:
                    jsonGenerator.writeString("external_id_already_in_use");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + groupUpdateError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupUpdateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupUpdateError groupUpdateError;
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
                groupUpdateError = GroupUpdateError.GROUP_NOT_FOUND;
            } else if ("other".equals(tag)) {
                groupUpdateError = GroupUpdateError.OTHER;
            } else if ("system_managed_group_disallowed".equals(tag)) {
                groupUpdateError = GroupUpdateError.SYSTEM_MANAGED_GROUP_DISALLOWED;
            } else if ("group_name_already_used".equals(tag)) {
                groupUpdateError = GroupUpdateError.GROUP_NAME_ALREADY_USED;
            } else if ("group_name_invalid".equals(tag)) {
                groupUpdateError = GroupUpdateError.GROUP_NAME_INVALID;
            } else if ("external_id_already_in_use".equals(tag)) {
                groupUpdateError = GroupUpdateError.EXTERNAL_ID_ALREADY_IN_USE;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupUpdateError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupUpdateError$1 */
    static /* synthetic */ class C43421 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupUpdateError;

        static {
            int[] iArr = new int[GroupUpdateError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupUpdateError = iArr;
            try {
                iArr[GroupUpdateError.GROUP_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupUpdateError[GroupUpdateError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupUpdateError[GroupUpdateError.SYSTEM_MANAGED_GROUP_DISALLOWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupUpdateError[GroupUpdateError.GROUP_NAME_ALREADY_USED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupUpdateError[GroupUpdateError.GROUP_NAME_INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupUpdateError[GroupUpdateError.EXTERNAL_ID_ALREADY_IN_USE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
