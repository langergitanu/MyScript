package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupSelector;
import com.dropbox.core.p013v2.team.MemberAccess;
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
class GroupMembersAddArg extends IncludeMembersArg {

    @Nonnull
    protected final GroupSelector group;

    @Nonnull
    protected final List<MemberAccess> members;

    public GroupMembersAddArg(@Nonnull GroupSelector groupSelector, @Nonnull List<MemberAccess> list, boolean z) {
        super(z);
        if (groupSelector == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = groupSelector;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        Iterator<MemberAccess> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = list;
    }

    public GroupMembersAddArg(@Nonnull GroupSelector groupSelector, @Nonnull List<MemberAccess> list) {
        this(groupSelector, list, true);
    }

    @Nonnull
    public GroupSelector getGroup() {
        return this.group;
    }

    @Nonnull
    public List<MemberAccess> getMembers() {
        return this.members;
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public boolean getReturnMembers() {
        return this.returnMembers;
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.group, this.members});
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public boolean equals(Object obj) {
        GroupMembersAddArg groupMembersAddArg;
        GroupSelector groupSelector;
        GroupSelector groupSelector2;
        List<MemberAccess> list;
        List<MemberAccess> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((groupSelector = this.group) == (groupSelector2 = (groupMembersAddArg = (GroupMembersAddArg) obj).group) || groupSelector.equals(groupSelector2)) && (((list = this.members) == (list2 = groupMembersAddArg.members) || list.equals(list2)) && this.returnMembers == groupMembersAddArg.returnMembers);
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupMembersAddArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupMembersAddArg groupMembersAddArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(groupMembersAddArg.group, jsonGenerator);
            jsonGenerator.writeFieldName("members");
            StoneSerializers.list(MemberAccess.Serializer.INSTANCE).serialize(groupMembersAddArg.members, jsonGenerator);
            jsonGenerator.writeFieldName("return_members");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(groupMembersAddArg.returnMembers), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupMembersAddArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("members".equals(currentName)) {
                        list = (List) StoneSerializers.list(MemberAccess.Serializer.INSTANCE).deserialize(jsonParser);
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
                    throw new JsonParseException(jsonParser, "Required field \"members\" missing.");
                }
                GroupMembersAddArg groupMembersAddArg = new GroupMembersAddArg(groupSelectorDeserialize, list, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupMembersAddArg, groupMembersAddArg.toStringMultiline());
                return groupMembersAddArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
