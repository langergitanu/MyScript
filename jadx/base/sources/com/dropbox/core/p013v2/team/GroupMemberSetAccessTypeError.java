package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupMemberSetAccessTypeError {
    GROUP_NOT_FOUND,
    OTHER,
    SYSTEM_MANAGED_GROUP_DISALLOWED,
    MEMBER_NOT_IN_GROUP,
    USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP;

    static class Serializer extends UnionSerializer<GroupMemberSetAccessTypeError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupMemberSetAccessTypeError groupMemberSetAccessTypeError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43371.f746xb84b30c8[groupMemberSetAccessTypeError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("group_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("other");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("system_managed_group_disallowed");
            } else if (i == 4) {
                jsonGenerator.writeString("member_not_in_group");
            } else {
                if (i == 5) {
                    jsonGenerator.writeString("user_cannot_be_manager_of_company_managed_group");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + groupMemberSetAccessTypeError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupMemberSetAccessTypeError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupMemberSetAccessTypeError groupMemberSetAccessTypeError;
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
                groupMemberSetAccessTypeError = GroupMemberSetAccessTypeError.GROUP_NOT_FOUND;
            } else if ("other".equals(tag)) {
                groupMemberSetAccessTypeError = GroupMemberSetAccessTypeError.OTHER;
            } else if ("system_managed_group_disallowed".equals(tag)) {
                groupMemberSetAccessTypeError = GroupMemberSetAccessTypeError.SYSTEM_MANAGED_GROUP_DISALLOWED;
            } else if ("member_not_in_group".equals(tag)) {
                groupMemberSetAccessTypeError = GroupMemberSetAccessTypeError.MEMBER_NOT_IN_GROUP;
            } else if ("user_cannot_be_manager_of_company_managed_group".equals(tag)) {
                groupMemberSetAccessTypeError = GroupMemberSetAccessTypeError.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupMemberSetAccessTypeError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupMemberSetAccessTypeError$1 */
    static /* synthetic */ class C43371 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$GroupMemberSetAccessTypeError */
        static final /* synthetic */ int[] f746xb84b30c8;

        static {
            int[] iArr = new int[GroupMemberSetAccessTypeError.values().length];
            f746xb84b30c8 = iArr;
            try {
                iArr[GroupMemberSetAccessTypeError.GROUP_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f746xb84b30c8[GroupMemberSetAccessTypeError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f746xb84b30c8[GroupMemberSetAccessTypeError.SYSTEM_MANAGED_GROUP_DISALLOWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f746xb84b30c8[GroupMemberSetAccessTypeError.MEMBER_NOT_IN_GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f746xb84b30c8[GroupMemberSetAccessTypeError.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
