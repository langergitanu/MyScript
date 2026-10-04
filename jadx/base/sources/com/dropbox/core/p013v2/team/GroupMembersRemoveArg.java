package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupSelector;
import com.dropbox.core.p013v2.team.UserSelectorArg;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
class GroupMembersRemoveArg extends IncludeMembersArg {

    @Nonnull
    protected final GroupSelector group;

    @Nonnull
    protected final List<UserSelectorArg> users;

    public GroupMembersRemoveArg(@Nonnull GroupSelector groupSelector, @Nonnull List<UserSelectorArg> list, boolean z) {
        super(z);
        if (groupSelector == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = groupSelector;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        Iterator<UserSelectorArg> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = list;
    }

    public GroupMembersRemoveArg(@Nonnull GroupSelector groupSelector, @Nonnull List<UserSelectorArg> list) {
        this(groupSelector, list, true);
    }

    @Nonnull
    public GroupSelector getGroup() {
        return this.group;
    }

    @Nonnull
    public List<UserSelectorArg> getUsers() {
        return this.users;
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public boolean getReturnMembers() {
        return this.returnMembers;
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.group, this.users});
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public boolean equals(Object obj) {
        GroupMembersRemoveArg groupMembersRemoveArg;
        GroupSelector groupSelector;
        GroupSelector groupSelector2;
        List<UserSelectorArg> list;
        List<UserSelectorArg> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((groupSelector = this.group) == (groupSelector2 = (groupMembersRemoveArg = (GroupMembersRemoveArg) obj).group) || groupSelector.equals(groupSelector2)) && (((list = this.users) == (list2 = groupMembersRemoveArg.users) || list.equals(list2)) && this.returnMembers == groupMembersRemoveArg.returnMembers);
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupMembersRemoveArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupMembersRemoveArg groupMembersRemoveArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(groupMembersRemoveArg.group, jsonGenerator);
            jsonGenerator.writeFieldName("users");
            StoneSerializers.list(UserSelectorArg.Serializer.INSTANCE).serialize(groupMembersRemoveArg.users, jsonGenerator);
            jsonGenerator.writeFieldName("return_members");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(groupMembersRemoveArg.returnMembers), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupMembersRemoveArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            GroupSelector groupSelectorDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = true;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("group".equals(currentName)) {
                        groupSelectorDeserialize = GroupSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("users".equals(currentName)) {
                        list = (List) StoneSerializers.list(UserSelectorArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("return_members".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (groupSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"users\" missing.");
                }
                GroupMembersRemoveArg groupMembersRemoveArg = new GroupMembersRemoveArg(groupSelectorDeserialize, list, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupMembersRemoveArg, groupMembersRemoveArg.toStringMultiline());
                return groupMembersRemoveArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
