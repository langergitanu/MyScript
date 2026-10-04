package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupMemberInfo;
import com.dropbox.core.p013v2.teamcommon.GroupManagementType;
import com.dropbox.core.p013v2.teamcommon.GroupSummary;
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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class GroupFullInfo extends GroupSummary {
    protected final long created;

    @Nullable
    protected final List<GroupMemberInfo> members;

    public GroupFullInfo(@Nonnull String str, @Nonnull String str2, @Nonnull GroupManagementType groupManagementType, long j, @Nullable String str3, @Nullable Long l, @Nullable List<GroupMemberInfo> list) {
        super(str, str2, groupManagementType, str3, l);
        if (list != null) {
            Iterator<GroupMemberInfo> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
        }
        this.members = list;
        this.created = j;
    }

    public GroupFullInfo(@Nonnull String str, @Nonnull String str2, @Nonnull GroupManagementType groupManagementType, long j) {
        this(str, str2, groupManagementType, j, null, null, null);
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

    public long getCreated() {
        return this.created;
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

    @Nullable
    public List<GroupMemberInfo> getMembers() {
        return this.members;
    }

    public static Builder newBuilder(String str, String str2, GroupManagementType groupManagementType, long j) {
        return new Builder(str, str2, groupManagementType, j);
    }

    public static class Builder extends GroupSummary.Builder {
        protected final long created;
        protected List<GroupMemberInfo> members;

        protected Builder(String str, String str2, GroupManagementType groupManagementType, long j) {
            super(str, str2, groupManagementType);
            this.created = j;
            this.members = null;
        }

        public Builder withMembers(List<GroupMemberInfo> list) {
            if (list != null) {
                Iterator<GroupMemberInfo> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'members' is null");
                    }
                }
            }
            this.members = list;
            return this;
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
        public GroupFullInfo build() {
            return new GroupFullInfo(this.groupName, this.groupId, this.groupManagementType, this.created, this.groupExternalId, this.memberCount, this.members);
        }
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.members, Long.valueOf(this.created)});
    }

    @Override // com.dropbox.core.p013v2.teamcommon.GroupSummary
    public boolean equals(Object obj) {
        List<GroupMemberInfo> list;
        List<GroupMemberInfo> list2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            GroupFullInfo groupFullInfo = (GroupFullInfo) obj;
            if ((this.groupName == groupFullInfo.groupName || this.groupName.equals(groupFullInfo.groupName)) && ((this.groupId == groupFullInfo.groupId || this.groupId.equals(groupFullInfo.groupId)) && ((this.groupManagementType == groupFullInfo.groupManagementType || this.groupManagementType.equals(groupFullInfo.groupManagementType)) && this.created == groupFullInfo.created && ((this.groupExternalId == groupFullInfo.groupExternalId || (this.groupExternalId != null && this.groupExternalId.equals(groupFullInfo.groupExternalId))) && ((this.memberCount == groupFullInfo.memberCount || (this.memberCount != null && this.memberCount.equals(groupFullInfo.memberCount))) && ((list = this.members) == (list2 = groupFullInfo.members) || (list != null && list.equals(list2)))))))) {
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

    static class Serializer extends StructSerializer<GroupFullInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupFullInfo groupFullInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group_name");
            StoneSerializers.string().serialize(groupFullInfo.groupName, jsonGenerator);
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.GROUP_ID);
            StoneSerializers.string().serialize(groupFullInfo.groupId, jsonGenerator);
            jsonGenerator.writeFieldName("group_management_type");
            GroupManagementType.Serializer.INSTANCE.serialize(groupFullInfo.groupManagementType, jsonGenerator);
            jsonGenerator.writeFieldName("created");
            StoneSerializers.uInt64().serialize(Long.valueOf(groupFullInfo.created), jsonGenerator);
            if (groupFullInfo.groupExternalId != null) {
                jsonGenerator.writeFieldName("group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(groupFullInfo.groupExternalId, jsonGenerator);
            }
            if (groupFullInfo.memberCount != null) {
                jsonGenerator.writeFieldName("member_count");
                StoneSerializers.nullable(StoneSerializers.uInt32()).serialize(groupFullInfo.memberCount, jsonGenerator);
            }
            if (groupFullInfo.members != null) {
                jsonGenerator.writeFieldName("members");
                StoneSerializers.nullable(StoneSerializers.list(GroupMemberInfo.Serializer.INSTANCE)).serialize(groupFullInfo.members, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupFullInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                GroupManagementType groupManagementTypeDeserialize = null;
                String str = null;
                Long l = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("group_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.GROUP_ID.equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("group_management_type".equals(currentName)) {
                        groupManagementTypeDeserialize = GroupManagementType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("group_external_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("member_count".equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.uInt32()).deserialize(jsonParser);
                    } else if ("members".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(GroupMemberInfo.Serializer.INSTANCE)).deserialize(jsonParser);
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
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"created\" missing.");
                }
                GroupFullInfo groupFullInfo = new GroupFullInfo(strDeserialize, strDeserialize2, groupManagementTypeDeserialize, lDeserialize.longValue(), str, l, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupFullInfo, groupFullInfo.toStringMultiline());
                return groupFullInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
