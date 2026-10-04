package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupSelector;
import com.dropbox.core.p013v2.teamcommon.GroupManagementType;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class GroupUpdateArgs extends IncludeMembersArg {

    @Nonnull
    protected final GroupSelector group;

    @Nullable
    protected final String newGroupExternalId;

    @Nullable
    protected final GroupManagementType newGroupManagementType;

    @Nullable
    protected final String newGroupName;

    public GroupUpdateArgs(@Nonnull GroupSelector groupSelector, boolean z, @Nullable String str, @Nullable String str2, @Nullable GroupManagementType groupManagementType) {
        super(z);
        if (groupSelector == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = groupSelector;
        this.newGroupName = str;
        this.newGroupExternalId = str2;
        this.newGroupManagementType = groupManagementType;
    }

    public GroupUpdateArgs(@Nonnull GroupSelector groupSelector) {
        this(groupSelector, true, null, null, null);
    }

    @Nonnull
    public GroupSelector getGroup() {
        return this.group;
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public boolean getReturnMembers() {
        return this.returnMembers;
    }

    @Nullable
    public String getNewGroupName() {
        return this.newGroupName;
    }

    @Nullable
    public String getNewGroupExternalId() {
        return this.newGroupExternalId;
    }

    @Nullable
    public GroupManagementType getNewGroupManagementType() {
        return this.newGroupManagementType;
    }

    public static Builder newBuilder(GroupSelector groupSelector) {
        return new Builder(groupSelector);
    }

    public static class Builder {
        protected final GroupSelector group;
        protected String newGroupExternalId;
        protected GroupManagementType newGroupManagementType;
        protected String newGroupName;
        protected boolean returnMembers;

        protected Builder(GroupSelector groupSelector) {
            if (groupSelector == null) {
                throw new IllegalArgumentException("Required value for 'group' is null");
            }
            this.group = groupSelector;
            this.returnMembers = true;
            this.newGroupName = null;
            this.newGroupExternalId = null;
            this.newGroupManagementType = null;
        }

        public Builder withReturnMembers(Boolean bool) {
            if (bool != null) {
                this.returnMembers = bool.booleanValue();
                return this;
            }
            this.returnMembers = true;
            return this;
        }

        public Builder withNewGroupName(String str) {
            this.newGroupName = str;
            return this;
        }

        public Builder withNewGroupExternalId(String str) {
            this.newGroupExternalId = str;
            return this;
        }

        public Builder withNewGroupManagementType(GroupManagementType groupManagementType) {
            this.newGroupManagementType = groupManagementType;
            return this;
        }

        public GroupUpdateArgs build() {
            return new GroupUpdateArgs(this.group, this.returnMembers, this.newGroupName, this.newGroupExternalId, this.newGroupManagementType);
        }
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.group, this.newGroupName, this.newGroupExternalId, this.newGroupManagementType});
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public boolean equals(Object obj) {
        GroupUpdateArgs groupUpdateArgs;
        GroupSelector groupSelector;
        GroupSelector groupSelector2;
        String str;
        String str2;
        String str3;
        String str4;
        GroupManagementType groupManagementType;
        GroupManagementType groupManagementType2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((groupSelector = this.group) == (groupSelector2 = (groupUpdateArgs = (GroupUpdateArgs) obj).group) || groupSelector.equals(groupSelector2)) && this.returnMembers == groupUpdateArgs.returnMembers && (((str = this.newGroupName) == (str2 = groupUpdateArgs.newGroupName) || (str != null && str.equals(str2))) && (((str3 = this.newGroupExternalId) == (str4 = groupUpdateArgs.newGroupExternalId) || (str3 != null && str3.equals(str4))) && ((groupManagementType = this.newGroupManagementType) == (groupManagementType2 = groupUpdateArgs.newGroupManagementType) || (groupManagementType != null && groupManagementType.equals(groupManagementType2)))));
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.IncludeMembersArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupUpdateArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupUpdateArgs groupUpdateArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(groupUpdateArgs.group, jsonGenerator);
            jsonGenerator.writeFieldName("return_members");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(groupUpdateArgs.returnMembers), jsonGenerator);
            if (groupUpdateArgs.newGroupName != null) {
                jsonGenerator.writeFieldName("new_group_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(groupUpdateArgs.newGroupName, jsonGenerator);
            }
            if (groupUpdateArgs.newGroupExternalId != null) {
                jsonGenerator.writeFieldName("new_group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(groupUpdateArgs.newGroupExternalId, jsonGenerator);
            }
            if (groupUpdateArgs.newGroupManagementType != null) {
                jsonGenerator.writeFieldName("new_group_management_type");
                StoneSerializers.nullable(GroupManagementType.Serializer.INSTANCE).serialize(groupUpdateArgs.newGroupManagementType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupUpdateArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = true;
                GroupSelector groupSelectorDeserialize = null;
                String str = null;
                String str2 = null;
                GroupManagementType groupManagementType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("group".equals(currentName)) {
                        groupSelectorDeserialize = GroupSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("return_members".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("new_group_name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_group_external_id".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_group_management_type".equals(currentName)) {
                        groupManagementType = (GroupManagementType) StoneSerializers.nullable(GroupManagementType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (groupSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group\" missing.");
                }
                GroupUpdateArgs groupUpdateArgs = new GroupUpdateArgs(groupSelectorDeserialize, boolDeserialize.booleanValue(), str, str2, groupManagementType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupUpdateArgs, groupUpdateArgs.toStringMultiline());
                return groupUpdateArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
