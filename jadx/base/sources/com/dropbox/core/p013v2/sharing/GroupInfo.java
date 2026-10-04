package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.teamcommon.GroupManagementType;
import com.dropbox.core.p013v2.teamcommon.GroupSummary;
import com.dropbox.core.p013v2.teamcommon.GroupType;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class GroupInfo extends GroupSummary {

    @Nonnull
    protected final GroupType groupType;
    protected final boolean isMember;
    protected final boolean isOwner;
    protected final boolean sameTeam;

    public GroupInfo(@Nonnull String str, @Nonnull String str2, @Nonnull GroupManagementType groupManagementType, @Nonnull GroupType groupType, boolean z, boolean z2, boolean z3, @Nullable String str3, @Nullable Long l) {
        super(str, str2, groupManagementType, str3, l);
        if (groupType == null) {
            throw new IllegalArgumentException("Required value for 'groupType' is null");
        }
        this.groupType = groupType;
        this.isMember = z;
        this.isOwner = z2;
        this.sameTeam = z3;
    }

    public GroupInfo(@Nonnull String str, @Nonnull String str2, @Nonnull GroupManagementType groupManagementType, @Nonnull GroupType groupType, boolean z, boolean z2, boolean z3) {
        this(str, str2, groupManagementType, groupType, z, z2, z3, null, null);
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    @Nonnull
    public String getGroupName() {
        return this.groupName;
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    @Nonnull
    public String getGroupId() {
        return this.groupId;
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    @Nonnull
    public GroupManagementType getGroupManagementType() {
        return this.groupManagementType;
    }

    @Nonnull
    public GroupType getGroupType() {
        return this.groupType;
    }

    public boolean getIsMember() {
        return this.isMember;
    }

    public boolean getIsOwner() {
        return this.isOwner;
    }

    public boolean getSameTeam() {
        return this.sameTeam;
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    @Nullable
    public String getGroupExternalId() {
        return this.groupExternalId;
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    @Nullable
    public Long getMemberCount() {
        return this.memberCount;
    }

    public static Builder newBuilder(String str, String str2, GroupManagementType groupManagementType, GroupType groupType, boolean z, boolean z2, boolean z3) {
        return new Builder(str, str2, groupManagementType, groupType, z, z2, z3);
    }

    public static class Builder extends GroupSummary.Builder {
        protected final GroupType groupType;
        protected final boolean isMember;
        protected final boolean isOwner;
        protected final boolean sameTeam;

        protected Builder(String str, String str2, GroupManagementType groupManagementType, GroupType groupType, boolean z, boolean z2, boolean z3) {
            super(str, str2, groupManagementType);
            if (groupType == null) {
                throw new IllegalArgumentException("Required value for 'groupType' is null");
            }
            this.groupType = groupType;
            this.isMember = z;
            this.isOwner = z2;
            this.sameTeam = z3;
        }

        @Override // com.dropbox.core.v2.teamcommon.GroupSummary.Builder
        public Builder withGroupExternalId(String str) {
            super.withGroupExternalId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.teamcommon.GroupSummary.Builder
        public Builder withMemberCount(Long l) {
            super.withMemberCount(l);
            return this;
        }

        @Override // com.dropbox.core.v2.teamcommon.GroupSummary.Builder
        public GroupInfo build() {
            return new GroupInfo(this.groupName, this.groupId, this.groupManagementType, this.groupType, this.isMember, this.isOwner, this.sameTeam, this.groupExternalId, this.memberCount);
        }
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.groupType, Boolean.valueOf(this.isMember), Boolean.valueOf(this.isOwner), Boolean.valueOf(this.sameTeam)});
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    public boolean equals(Object obj) {
        GroupType groupType;
        GroupType groupType2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            GroupInfo groupInfo = (GroupInfo) obj;
            if ((this.groupName == groupInfo.groupName || this.groupName.equals(groupInfo.groupName)) && ((this.groupId == groupInfo.groupId || this.groupId.equals(groupInfo.groupId)) && ((this.groupManagementType == groupInfo.groupManagementType || this.groupManagementType.equals(groupInfo.groupManagementType)) && (((groupType = this.groupType) == (groupType2 = groupInfo.groupType) || groupType.equals(groupType2)) && this.isMember == groupInfo.isMember && this.isOwner == groupInfo.isOwner && this.sameTeam == groupInfo.sameTeam && ((this.groupExternalId == groupInfo.groupExternalId || (this.groupExternalId != null && this.groupExternalId.equals(groupInfo.groupExternalId))) && (this.memberCount == groupInfo.memberCount || (this.memberCount != null && this.memberCount.equals(groupInfo.memberCount)))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupInfo groupInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group_name");
            StoneSerializers.string().serialize(groupInfo.groupName, jsonGenerator);
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.GROUP_ID);
            StoneSerializers.string().serialize(groupInfo.groupId, jsonGenerator);
            jsonGenerator.writeFieldName("group_management_type");
            GroupManagementType.Serializer.INSTANCE.serialize(groupInfo.groupManagementType, jsonGenerator);
            jsonGenerator.writeFieldName("group_type");
            GroupType.Serializer.INSTANCE.serialize(groupInfo.groupType, jsonGenerator);
            jsonGenerator.writeFieldName("is_member");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(groupInfo.isMember), jsonGenerator);
            jsonGenerator.writeFieldName("is_owner");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(groupInfo.isOwner), jsonGenerator);
            jsonGenerator.writeFieldName("same_team");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(groupInfo.sameTeam), jsonGenerator);
            if (groupInfo.groupExternalId != null) {
                jsonGenerator.writeFieldName("group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(groupInfo.groupExternalId, jsonGenerator);
            }
            if (groupInfo.memberCount != null) {
                jsonGenerator.writeFieldName("member_count");
                StoneSerializers.nullable(StoneSerializers.uInt32()).serialize(groupInfo.memberCount, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize2 = null;
                Boolean boolDeserialize3 = null;
                String strDeserialize = null;
                String strDeserialize2 = null;
                GroupManagementType groupManagementTypeDeserialize = null;
                GroupType groupTypeDeserialize = null;
                String str = null;
                Long l = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("group_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.GROUP_ID.equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("group_management_type".equals(currentName)) {
                        groupManagementTypeDeserialize = GroupManagementType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("group_type".equals(currentName)) {
                        groupTypeDeserialize = GroupType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("is_member".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("is_owner".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("same_team".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("group_external_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("member_count".equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.uInt32()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group_name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group_id\" missing.");
                }
                if (groupManagementTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group_management_type\" missing.");
                }
                if (groupTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group_type\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_member\" missing.");
                }
                if (boolDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_owner\" missing.");
                }
                if (boolDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"same_team\" missing.");
                }
                GroupInfo groupInfo = new GroupInfo(strDeserialize, strDeserialize2, groupManagementTypeDeserialize, groupTypeDeserialize, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), boolDeserialize3.booleanValue(), str, l);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupInfo, groupInfo.toStringMultiline());
                return groupInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
