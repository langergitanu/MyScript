package com.dropbox.core.p013v2.teamcommon;

import com.dropbox.core.p013v2.teamcommon.GroupManagementType;
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

/* JADX INFO: loaded from: classes5.dex */
public class GroupSummary {

    @Nullable
    protected final String groupExternalId;

    @Nonnull
    protected final String groupId;

    @Nonnull
    protected final GroupManagementType groupManagementType;

    @Nonnull
    protected final String groupName;

    @Nullable
    protected final Long memberCount;

    public GroupSummary(@Nonnull String str, @Nonnull String str2, @Nonnull GroupManagementType groupManagementType, @Nullable String str3, @Nullable Long l) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'groupName' is null");
        }
        this.groupName = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'groupId' is null");
        }
        this.groupId = str2;
        this.groupExternalId = str3;
        this.memberCount = l;
        if (groupManagementType == null) {
            throw new IllegalArgumentException("Required value for 'groupManagementType' is null");
        }
        this.groupManagementType = groupManagementType;
    }

    public GroupSummary(@Nonnull String str, @Nonnull String str2, @Nonnull GroupManagementType groupManagementType) {
        this(str, str2, groupManagementType, null, null);
    }

    @Nonnull
    public String getGroupName() {
        return this.groupName;
    }

    @Nonnull
    public String getGroupId() {
        return this.groupId;
    }

    @Nonnull
    public GroupManagementType getGroupManagementType() {
        return this.groupManagementType;
    }

    @Nullable
    public String getGroupExternalId() {
        return this.groupExternalId;
    }

    @Nullable
    public Long getMemberCount() {
        return this.memberCount;
    }

    public static Builder newBuilder(String str, String str2, GroupManagementType groupManagementType) {
        return new Builder(str, str2, groupManagementType);
    }

    public static class Builder {
        protected String groupExternalId;
        protected final String groupId;
        protected final GroupManagementType groupManagementType;
        protected final String groupName;
        protected Long memberCount;

        protected Builder(String str, String str2, GroupManagementType groupManagementType) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'groupName' is null");
            }
            this.groupName = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'groupId' is null");
            }
            this.groupId = str2;
            if (groupManagementType == null) {
                throw new IllegalArgumentException("Required value for 'groupManagementType' is null");
            }
            this.groupManagementType = groupManagementType;
            this.groupExternalId = null;
            this.memberCount = null;
        }

        public Builder withGroupExternalId(String str) {
            this.groupExternalId = str;
            return this;
        }

        public Builder withMemberCount(Long l) {
            this.memberCount = l;
            return this;
        }

        public GroupSummary build() {
            return new GroupSummary(this.groupName, this.groupId, this.groupManagementType, this.groupExternalId, this.memberCount);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.groupName, this.groupId, this.groupExternalId, this.memberCount, this.groupManagementType});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        GroupManagementType groupManagementType;
        GroupManagementType groupManagementType2;
        String str3;
        String str4;
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GroupSummary groupSummary = (GroupSummary) obj;
        String str5 = this.groupName;
        String str6 = groupSummary.groupName;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.groupId) == (str2 = groupSummary.groupId) || str.equals(str2)) && (((groupManagementType = this.groupManagementType) == (groupManagementType2 = groupSummary.groupManagementType) || groupManagementType.equals(groupManagementType2)) && (((str3 = this.groupExternalId) == (str4 = groupSummary.groupExternalId) || (str3 != null && str3.equals(str4))) && ((l = this.memberCount) == (l2 = groupSummary.memberCount) || (l != null && l.equals(l2)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<GroupSummary> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupSummary groupSummary, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group_name");
            StoneSerializers.string().serialize(groupSummary.groupName, jsonGenerator);
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.GROUP_ID);
            StoneSerializers.string().serialize(groupSummary.groupId, jsonGenerator);
            jsonGenerator.writeFieldName("group_management_type");
            GroupManagementType.Serializer.INSTANCE.serialize(groupSummary.groupManagementType, jsonGenerator);
            if (groupSummary.groupExternalId != null) {
                jsonGenerator.writeFieldName("group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(groupSummary.groupExternalId, jsonGenerator);
            }
            if (groupSummary.memberCount != null) {
                jsonGenerator.writeFieldName("member_count");
                StoneSerializers.nullable(StoneSerializers.uInt32()).serialize(groupSummary.memberCount, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupSummary deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
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
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("group_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.GROUP_ID.equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("group_management_type".equals(currentName)) {
                        groupManagementTypeDeserialize = GroupManagementType.Serializer.INSTANCE.deserialize(jsonParser);
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
                GroupSummary groupSummary = new GroupSummary(strDeserialize, strDeserialize2, groupManagementTypeDeserialize, str, l);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupSummary, groupSummary.toStringMultiline());
                return groupSummary;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
