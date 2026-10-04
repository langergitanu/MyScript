package com.dropbox.core.p013v2.teamcommon;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupManagementType {
    USER_MANAGED,
    COMPANY_MANAGED,
    SYSTEM_MANAGED,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamcommon.GroupManagementType$1 */
    static /* synthetic */ class C44251 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamcommon$GroupManagementType;

        static {
            int[] iArr = new int[GroupManagementType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamcommon$GroupManagementType = iArr;
            try {
                iArr[GroupManagementType.USER_MANAGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamcommon$GroupManagementType[GroupManagementType.COMPANY_MANAGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamcommon$GroupManagementType[GroupManagementType.SYSTEM_MANAGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<GroupManagementType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupManagementType groupManagementType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44251.$SwitchMap$com$dropbox$core$v2$teamcommon$GroupManagementType[groupManagementType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("user_managed");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("company_managed");
            } else if (i == 3) {
                jsonGenerator.writeString("system_managed");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupManagementType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupManagementType groupManagementType;
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
            if ("user_managed".equals(tag)) {
                groupManagementType = GroupManagementType.USER_MANAGED;
            } else if ("company_managed".equals(tag)) {
                groupManagementType = GroupManagementType.COMPANY_MANAGED;
            } else if ("system_managed".equals(tag)) {
                groupManagementType = GroupManagementType.SYSTEM_MANAGED;
            } else {
                groupManagementType = GroupManagementType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupManagementType;
        }
    }
}
