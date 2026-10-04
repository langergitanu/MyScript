package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupAccessType;
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
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
class GroupMembersSetAccessTypeArg extends GroupMemberSelector {

    @Nonnull
    protected final GroupAccessType accessType;
    protected final boolean returnMembers;

    public GroupMembersSetAccessTypeArg(@Nonnull GroupSelector groupSelector, @Nonnull UserSelectorArg userSelectorArg, @Nonnull GroupAccessType groupAccessType, boolean z) {
        super(groupSelector, userSelectorArg);
        if (groupAccessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = groupAccessType;
        this.returnMembers = z;
    }

    public GroupMembersSetAccessTypeArg(@Nonnull GroupSelector groupSelector, @Nonnull UserSelectorArg userSelectorArg, @Nonnull GroupAccessType groupAccessType) {
        this(groupSelector, userSelectorArg, groupAccessType, true);
    }

    @Override // com.dropbox.core.p013v2.team.GroupMemberSelector
    @Nonnull
    public GroupSelector getGroup() {
        return this.group;
    }

    @Override // com.dropbox.core.p013v2.team.GroupMemberSelector
    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Nonnull
    public GroupAccessType getAccessType() {
        return this.accessType;
    }

    public boolean getReturnMembers() {
        return this.returnMembers;
    }

    @Override // com.dropbox.core.p013v2.team.GroupMemberSelector
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.accessType, Boolean.valueOf(this.returnMembers)});
    }

    @Override // com.dropbox.core.p013v2.team.GroupMemberSelector
    public boolean equals(Object obj) {
        GroupAccessType groupAccessType;
        GroupAccessType groupAccessType2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            GroupMembersSetAccessTypeArg groupMembersSetAccessTypeArg = (GroupMembersSetAccessTypeArg) obj;
            if ((this.group == groupMembersSetAccessTypeArg.group || this.group.equals(groupMembersSetAccessTypeArg.group)) && ((this.user == groupMembersSetAccessTypeArg.user || this.user.equals(groupMembersSetAccessTypeArg.user)) && (((groupAccessType = this.accessType) == (groupAccessType2 = groupMembersSetAccessTypeArg.accessType) || groupAccessType.equals(groupAccessType2)) && this.returnMembers == groupMembersSetAccessTypeArg.returnMembers))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.team.GroupMemberSelector
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.GroupMemberSelector
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupMembersSetAccessTypeArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupMembersSetAccessTypeArg groupMembersSetAccessTypeArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(groupMembersSetAccessTypeArg.group, jsonGenerator);
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(groupMembersSetAccessTypeArg.user, jsonGenerator);
            jsonGenerator.writeFieldName("access_type");
            GroupAccessType.Serializer.INSTANCE.serialize(groupMembersSetAccessTypeArg.accessType, jsonGenerator);
            jsonGenerator.writeFieldName("return_members");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(groupMembersSetAccessTypeArg.returnMembers), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupMembersSetAccessTypeArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            GroupSelector groupSelectorDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                GroupAccessType groupAccessTypeDeserialize = null;
                Boolean boolDeserialize = true;
                UserSelectorArg userSelectorArgDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("group".equals(currentName)) {
                        groupSelectorDeserialize = GroupSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("access_type".equals(currentName)) {
                        groupAccessTypeDeserialize = GroupAccessType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("return_members".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (groupSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group\" missing.");
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                if (groupAccessTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_type\" missing.");
                }
                GroupMembersSetAccessTypeArg groupMembersSetAccessTypeArg = new GroupMembersSetAccessTypeArg(groupSelectorDeserialize, userSelectorArgDeserialize, groupAccessTypeDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupMembersSetAccessTypeArg, groupMembersSetAccessTypeArg.toStringMultiline());
                return groupMembersSetAccessTypeArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
