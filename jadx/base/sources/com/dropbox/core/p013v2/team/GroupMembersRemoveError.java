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
public final class GroupMembersRemoveError {
    private Tag _tag;
    private List<String> membersNotInTeamValue;
    private List<String> usersNotFoundValue;
    public static final GroupMembersRemoveError GROUP_NOT_FOUND = new GroupMembersRemoveError().withTag(Tag.GROUP_NOT_FOUND);
    public static final GroupMembersRemoveError OTHER = new GroupMembersRemoveError().withTag(Tag.OTHER);
    public static final GroupMembersRemoveError SYSTEM_MANAGED_GROUP_DISALLOWED = new GroupMembersRemoveError().withTag(Tag.SYSTEM_MANAGED_GROUP_DISALLOWED);
    public static final GroupMembersRemoveError MEMBER_NOT_IN_GROUP = new GroupMembersRemoveError().withTag(Tag.MEMBER_NOT_IN_GROUP);
    public static final GroupMembersRemoveError GROUP_NOT_IN_TEAM = new GroupMembersRemoveError().withTag(Tag.GROUP_NOT_IN_TEAM);

    public enum Tag {
        GROUP_NOT_FOUND,
        OTHER,
        SYSTEM_MANAGED_GROUP_DISALLOWED,
        MEMBER_NOT_IN_GROUP,
        GROUP_NOT_IN_TEAM,
        MEMBERS_NOT_IN_TEAM,
        USERS_NOT_FOUND
    }

    private GroupMembersRemoveError() {
    }

    private GroupMembersRemoveError withTag(Tag tag) {
        GroupMembersRemoveError groupMembersRemoveError = new GroupMembersRemoveError();
        groupMembersRemoveError._tag = tag;
        return groupMembersRemoveError;
    }

    private GroupMembersRemoveError withTagAndMembersNotInTeam(Tag tag, List<String> list) {
        GroupMembersRemoveError groupMembersRemoveError = new GroupMembersRemoveError();
        groupMembersRemoveError._tag = tag;
        groupMembersRemoveError.membersNotInTeamValue = list;
        return groupMembersRemoveError;
    }

    private GroupMembersRemoveError withTagAndUsersNotFound(Tag tag, List<String> list) {
        GroupMembersRemoveError groupMembersRemoveError = new GroupMembersRemoveError();
        groupMembersRemoveError._tag = tag;
        groupMembersRemoveError.usersNotFoundValue = list;
        return groupMembersRemoveError;
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

    public boolean isMemberNotInGroup() {
        return this._tag == Tag.MEMBER_NOT_IN_GROUP;
    }

    public boolean isGroupNotInTeam() {
        return this._tag == Tag.GROUP_NOT_IN_TEAM;
    }

    public boolean isMembersNotInTeam() {
        return this._tag == Tag.MEMBERS_NOT_IN_TEAM;
    }

    public static GroupMembersRemoveError membersNotInTeam(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupMembersRemoveError().withTagAndMembersNotInTeam(Tag.MEMBERS_NOT_IN_TEAM, list);
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

    public static GroupMembersRemoveError usersNotFound(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupMembersRemoveError().withTagAndUsersNotFound(Tag.USERS_NOT_FOUND, list);
    }

    public List<String> getUsersNotFoundValue() {
        if (this._tag != Tag.USERS_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.USERS_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return this.usersNotFoundValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.membersNotInTeamValue, this.usersNotFoundValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GroupMembersRemoveError)) {
            return false;
        }
        GroupMembersRemoveError groupMembersRemoveError = (GroupMembersRemoveError) obj;
        if (this._tag != groupMembersRemoveError._tag) {
            return false;
        }
        switch (C43391.$SwitchMap$com$dropbox$core$v2$team$GroupMembersRemoveError$Tag[this._tag.ordinal()]) {
            case 6:
                List<String> list = this.membersNotInTeamValue;
                List<String> list2 = groupMembersRemoveError.membersNotInTeamValue;
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
                List<String> list4 = groupMembersRemoveError.usersNotFoundValue;
                return list3 == list4 || list3.equals(list4);
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupMembersRemoveError$1 */
    static /* synthetic */ class C43391 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupMembersRemoveError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupMembersRemoveError$Tag = iArr;
            try {
                iArr[Tag.GROUP_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersRemoveError$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersRemoveError$Tag[Tag.SYSTEM_MANAGED_GROUP_DISALLOWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersRemoveError$Tag[Tag.MEMBER_NOT_IN_GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersRemoveError$Tag[Tag.GROUP_NOT_IN_TEAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersRemoveError$Tag[Tag.MEMBERS_NOT_IN_TEAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupMembersRemoveError$Tag[Tag.USERS_NOT_FOUND.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<GroupMembersRemoveError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupMembersRemoveError groupMembersRemoveError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43391.$SwitchMap$com$dropbox$core$v2$team$GroupMembersRemoveError$Tag[groupMembersRemoveError.tag().ordinal()]) {
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
                    jsonGenerator.writeString("member_not_in_group");
                    return;
                case 5:
                    jsonGenerator.writeString("group_not_in_team");
                    return;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("members_not_in_team", jsonGenerator);
                    jsonGenerator.writeFieldName("members_not_in_team");
                    StoneSerializers.list(StoneSerializers.string()).serialize(groupMembersRemoveError.membersNotInTeamValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 7:
                    jsonGenerator.writeStartObject();
                    writeTag("users_not_found", jsonGenerator);
                    jsonGenerator.writeFieldName("users_not_found");
                    StoneSerializers.list(StoneSerializers.string()).serialize(groupMembersRemoveError.usersNotFoundValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + groupMembersRemoveError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupMembersRemoveError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupMembersRemoveError groupMembersRemoveErrorUsersNotFound;
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
                groupMembersRemoveErrorUsersNotFound = GroupMembersRemoveError.GROUP_NOT_FOUND;
            } else if ("other".equals(tag)) {
                groupMembersRemoveErrorUsersNotFound = GroupMembersRemoveError.OTHER;
            } else if ("system_managed_group_disallowed".equals(tag)) {
                groupMembersRemoveErrorUsersNotFound = GroupMembersRemoveError.SYSTEM_MANAGED_GROUP_DISALLOWED;
            } else if ("member_not_in_group".equals(tag)) {
                groupMembersRemoveErrorUsersNotFound = GroupMembersRemoveError.MEMBER_NOT_IN_GROUP;
            } else if ("group_not_in_team".equals(tag)) {
                groupMembersRemoveErrorUsersNotFound = GroupMembersRemoveError.GROUP_NOT_IN_TEAM;
            } else if ("members_not_in_team".equals(tag)) {
                expectField("members_not_in_team", jsonParser);
                groupMembersRemoveErrorUsersNotFound = GroupMembersRemoveError.membersNotInTeam((List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser));
            } else if ("users_not_found".equals(tag)) {
                expectField("users_not_found", jsonParser);
                groupMembersRemoveErrorUsersNotFound = GroupMembersRemoveError.usersNotFound((List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupMembersRemoveErrorUsersNotFound;
        }
    }
}
