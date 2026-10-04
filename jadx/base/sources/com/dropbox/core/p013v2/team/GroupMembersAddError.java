package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class GroupMembersAddError {
    private Tag _tag;
    private List<String> membersNotInTeamValue;
    private List<String> userCannotBeManagerOfCompanyManagedGroupValue;
    private List<String> usersNotFoundValue;
    public static final GroupMembersAddError GROUP_NOT_FOUND = new GroupMembersAddError().withTag(Tag.GROUP_NOT_FOUND);
    public static final GroupMembersAddError OTHER = new GroupMembersAddError().withTag(Tag.OTHER);
    public static final GroupMembersAddError SYSTEM_MANAGED_GROUP_DISALLOWED = new GroupMembersAddError().withTag(Tag.SYSTEM_MANAGED_GROUP_DISALLOWED);
    public static final GroupMembersAddError DUPLICATE_USER = new GroupMembersAddError().withTag(Tag.DUPLICATE_USER);
    public static final GroupMembersAddError GROUP_NOT_IN_TEAM = new GroupMembersAddError().withTag(Tag.GROUP_NOT_IN_TEAM);
    public static final GroupMembersAddError USER_MUST_BE_ACTIVE_TO_BE_OWNER = new GroupMembersAddError().withTag(Tag.USER_MUST_BE_ACTIVE_TO_BE_OWNER);

    public enum Tag {
        GROUP_NOT_FOUND,
        OTHER,
        SYSTEM_MANAGED_GROUP_DISALLOWED,
        DUPLICATE_USER,
        GROUP_NOT_IN_TEAM,
        MEMBERS_NOT_IN_TEAM,
        USERS_NOT_FOUND,
        USER_MUST_BE_ACTIVE_TO_BE_OWNER,
        USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP
    }

    private GroupMembersAddError() {
    }

    private GroupMembersAddError withTag(Tag tag) {
        GroupMembersAddError groupMembersAddError = new GroupMembersAddError();
        groupMembersAddError._tag = tag;
        return groupMembersAddError;
    }

    private GroupMembersAddError withTagAndMembersNotInTeam(Tag tag, List<String> list) {
        GroupMembersAddError groupMembersAddError = new GroupMembersAddError();
        groupMembersAddError._tag = tag;
        groupMembersAddError.membersNotInTeamValue = list;
        return groupMembersAddError;
    }

    private GroupMembersAddError withTagAndUsersNotFound(Tag tag, List<String> list) {
        GroupMembersAddError groupMembersAddError = new GroupMembersAddError();
        groupMembersAddError._tag = tag;
        groupMembersAddError.usersNotFoundValue = list;
        return groupMembersAddError;
    }

    private GroupMembersAddError withTagAndUserCannotBeManagerOfCompanyManagedGroup(Tag tag, List<String> list) {
        GroupMembersAddError groupMembersAddError = new GroupMembersAddError();
        groupMembersAddError._tag = tag;
        groupMembersAddError.userCannotBeManagerOfCompanyManagedGroupValue = list;
        return groupMembersAddError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isGroupNotFound() {
        return this._tag == Tag.GROUP_NOT_FOUND;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public boolean isSystemManagedGroupDisallowed() {
        return this._tag == Tag.SYSTEM_MANAGED_GROUP_DISALLOWED;
    }

    public boolean isDuplicateUser() {
        return this._tag == Tag.DUPLICATE_USER;
    }

    public boolean isGroupNotInTeam() {
        return this._tag == Tag.GROUP_NOT_IN_TEAM;
    }

    public boolean isMembersNotInTeam() {
        return this._tag == Tag.MEMBERS_NOT_IN_TEAM;
    }

    public static GroupMembersAddError membersNotInTeam(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupMembersAddError().withTagAndMembersNotInTeam(Tag.MEMBERS_NOT_IN_TEAM, list);
    }

    public List<String> getMembersNotInTeamValue() {
        if (this._tag != Tag.MEMBERS_NOT_IN_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBERS_NOT_IN_TEAM, but was Tag." + this._tag.name());
        }
        return this.membersNotInTeamValue;
    }

    public boolean isUsersNotFound() {
        return this._tag == Tag.USERS_NOT_FOUND;
    }

    public static GroupMembersAddError usersNotFound(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupMembersAddError().withTagAndUsersNotFound(Tag.USERS_NOT_FOUND, list);
    }

    public List<String> getUsersNotFoundValue() {
        if (this._tag != Tag.USERS_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.USERS_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return this.usersNotFoundValue;
    }

    public boolean isUserMustBeActiveToBeOwner() {
        return this._tag == Tag.USER_MUST_BE_ACTIVE_TO_BE_OWNER;
    }

    public boolean isUserCannotBeManagerOfCompanyManagedGroup() {
        return this._tag == Tag.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP;
    }

    public static GroupMembersAddError userCannotBeManagerOfCompanyManagedGroup(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupMembersAddError().withTagAndUserCannotBeManagerOfCompanyManagedGroup(Tag.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP, list);
    }

    public List<String> getUserCannotBeManagerOfCompanyManagedGroupValue() {
        if (this._tag != Tag.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP, but was Tag." + this._tag.name());
        }
        return this.userCannotBeManagerOfCompanyManagedGroupValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.membersNotInTeamValue, this.usersNotFoundValue, this.userCannotBeManagerOfCompanyManagedGroupValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GroupMembersAddError)) {
            return false;
        }
        GroupMembersAddError groupMembersAddError = (GroupMembersAddError) obj;
        if (this._tag != groupMembersAddError._tag) {
            return false;
        }
        switch (C43381.$SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag[this._tag.ordinal()]) {
            case 6:
                List<String> list = this.membersNotInTeamValue;
                List<String> list2 = groupMembersAddError.membersNotInTeamValue;
                if (list != list2 && !list.equals(list2)) {
                    return false;
                }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            case 7:
                List<String> list3 = this.usersNotFoundValue;
                List<String> list4 = groupMembersAddError.usersNotFoundValue;
                return list3 == list4 || list3.equals(list4);
            case 9:
                List<String> list5 = this.userCannotBeManagerOfCompanyManagedGroupValue;
                List<String> list6 = groupMembersAddError.userCannotBeManagerOfCompanyManagedGroupValue;
                if (list5 != list6 && !list5.equals(list6)) {
                    return false;
                }
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupMembersAddError$1 */
    static /* synthetic */ class C43381 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag = iArr;
            try {
                iArr[Tag.GROUP_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag[Tag.SYSTEM_MANAGED_GROUP_DISALLOWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag[Tag.DUPLICATE_USER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag[Tag.GROUP_NOT_IN_TEAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag[Tag.MEMBERS_NOT_IN_TEAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag[Tag.USERS_NOT_FOUND.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag[Tag.USER_MUST_BE_ACTIVE_TO_BE_OWNER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag[Tag.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<GroupMembersAddError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupMembersAddError groupMembersAddError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43381.$SwitchMap$com$dropbox$core$v2$team$GroupMembersAddError$Tag[groupMembersAddError.tag().ordinal()]) {
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
                    jsonGenerator.writeString("duplicate_user");
                    return;
                case 5:
                    jsonGenerator.writeString("group_not_in_team");
                    return;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("members_not_in_team", jsonGenerator);
                    jsonGenerator.writeFieldName("members_not_in_team");
                    StoneSerializers.list(StoneSerializers.string()).serialize(groupMembersAddError.membersNotInTeamValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 7:
                    jsonGenerator.writeStartObject();
                    writeTag("users_not_found", jsonGenerator);
                    jsonGenerator.writeFieldName("users_not_found");
                    StoneSerializers.list(StoneSerializers.string()).serialize(groupMembersAddError.usersNotFoundValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 8:
                    jsonGenerator.writeString("user_must_be_active_to_be_owner");
                    return;
                case 9:
                    jsonGenerator.writeStartObject();
                    writeTag("user_cannot_be_manager_of_company_managed_group", jsonGenerator);
                    jsonGenerator.writeFieldName("user_cannot_be_manager_of_company_managed_group");
                    StoneSerializers.list(StoneSerializers.string()).serialize(groupMembersAddError.userCannotBeManagerOfCompanyManagedGroupValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + groupMembersAddError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupMembersAddError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupMembersAddError groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup;
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
                groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup = GroupMembersAddError.GROUP_NOT_FOUND;
            } else if ("other".equals(tag)) {
                groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup = GroupMembersAddError.OTHER;
            } else if ("system_managed_group_disallowed".equals(tag)) {
                groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup = GroupMembersAddError.SYSTEM_MANAGED_GROUP_DISALLOWED;
            } else if ("duplicate_user".equals(tag)) {
                groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup = GroupMembersAddError.DUPLICATE_USER;
            } else if ("group_not_in_team".equals(tag)) {
                groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup = GroupMembersAddError.GROUP_NOT_IN_TEAM;
            } else if ("members_not_in_team".equals(tag)) {
                expectField("members_not_in_team", jsonParser);
                groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup = GroupMembersAddError.membersNotInTeam((List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser));
            } else if ("users_not_found".equals(tag)) {
                expectField("users_not_found", jsonParser);
                groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup = GroupMembersAddError.usersNotFound((List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser));
            } else if ("user_must_be_active_to_be_owner".equals(tag)) {
                groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup = GroupMembersAddError.USER_MUST_BE_ACTIVE_TO_BE_OWNER;
            } else if ("user_cannot_be_manager_of_company_managed_group".equals(tag)) {
                expectField("user_cannot_be_manager_of_company_managed_group", jsonParser);
                groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup = GroupMembersAddError.userCannotBeManagerOfCompanyManagedGroup((List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupMembersAddErrorUserCannotBeManagerOfCompanyManagedGroup;
        }
    }
}
