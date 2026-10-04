package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.GroupInfo;
import com.dropbox.core.p013v2.sharing.MemberPermission;
import com.dropbox.core.p013v2.sharing.MembershipInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class GroupMembershipInfo extends MembershipInfo {

    @Nonnull
    protected final GroupInfo group;

    public GroupMembershipInfo(@Nonnull AccessLevel accessLevel, @Nonnull GroupInfo groupInfo, @Nullable List<MemberPermission> list, @Nullable String str, boolean z) {
        super(accessLevel, list, str, z);
        if (groupInfo == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = groupInfo;
    }

    public GroupMembershipInfo(@Nonnull AccessLevel accessLevel, @Nonnull GroupInfo groupInfo) {
        this(accessLevel, groupInfo, null, null, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    @Nonnull
    public AccessLevel getAccessType() {
        return this.accessType;
    }

    @Nonnull
    public GroupInfo getGroup() {
        return this.group;
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    @Nullable
    public List<MemberPermission> getPermissions() {
        return this.permissions;
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    @Nullable
    public String getInitials() {
        return this.initials;
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public boolean getIsInherited() {
        return this.isInherited;
    }

    public static Builder newBuilder(AccessLevel accessLevel, GroupInfo groupInfo) {
        return new Builder(accessLevel, groupInfo);
    }

    public static class Builder extends MembershipInfo.Builder {
        protected final GroupInfo group;

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public /* bridge */ /* synthetic */ MembershipInfo.Builder withPermissions(List list) {
            return withPermissions((List<MemberPermission>) list);
        }

        protected Builder(AccessLevel accessLevel, GroupInfo groupInfo) {
            super(accessLevel);
            if (groupInfo == null) {
                throw new IllegalArgumentException("Required value for 'group' is null");
            }
            this.group = groupInfo;
        }

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public Builder withPermissions(List<MemberPermission> list) {
            super.withPermissions(list);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public Builder withInitials(String str) {
            super.withInitials(str);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public Builder withIsInherited(Boolean bool) {
            super.withIsInherited(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public GroupMembershipInfo build() {
            return new GroupMembershipInfo(this.accessType, this.group, this.permissions, this.initials, this.isInherited);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.group});
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public boolean equals(Object obj) {
        GroupInfo groupInfo;
        GroupInfo groupInfo2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            GroupMembershipInfo groupMembershipInfo = (GroupMembershipInfo) obj;
            if ((this.accessType == groupMembershipInfo.accessType || this.accessType.equals(groupMembershipInfo.accessType)) && (((groupInfo = this.group) == (groupInfo2 = groupMembershipInfo.group) || groupInfo.equals(groupInfo2)) && ((this.permissions == groupMembershipInfo.permissions || (this.permissions != null && this.permissions.equals(groupMembershipInfo.permissions))) && ((this.initials == groupMembershipInfo.initials || (this.initials != null && this.initials.equals(groupMembershipInfo.initials))) && this.isInherited == groupMembershipInfo.isInherited)))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupMembershipInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupMembershipInfo groupMembershipInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(groupMembershipInfo.accessType, jsonGenerator);
            jsonGenerator.writeFieldName("group");
            GroupInfo.Serializer.INSTANCE.serialize(groupMembershipInfo.group, jsonGenerator);
            if (groupMembershipInfo.permissions != null) {
                jsonGenerator.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).serialize(groupMembershipInfo.permissions, jsonGenerator);
            }
            if (groupMembershipInfo.initials != null) {
                jsonGenerator.writeFieldName("initials");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(groupMembershipInfo.initials, jsonGenerator);
            }
            jsonGenerator.writeFieldName("is_inherited");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(groupMembershipInfo.isInherited), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupMembershipInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                AccessLevel accessLevelDeserialize = null;
                GroupInfo groupInfoDeserialize = null;
                List list = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("access_type".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("group".equals(currentName)) {
                        groupInfoDeserialize = GroupInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("permissions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("initials".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("is_inherited".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_type\" missing.");
                }
                if (groupInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group\" missing.");
                }
                GroupMembershipInfo groupMembershipInfo = new GroupMembershipInfo(accessLevelDeserialize, groupInfoDeserialize, list, str, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupMembershipInfo, groupMembershipInfo.toStringMultiline());
                return groupMembershipInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
