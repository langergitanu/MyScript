package com.dropbox.core.p013v2.team;

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
class GroupCreateArg {
    protected final boolean addCreatorAsOwner;

    @Nullable
    protected final String groupExternalId;

    @Nullable
    protected final GroupManagementType groupManagementType;

    @Nonnull
    protected final String groupName;

    public GroupCreateArg(@Nonnull String str, boolean z, @Nullable String str2, @Nullable GroupManagementType groupManagementType) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'groupName' is null");
        }
        this.groupName = str;
        this.addCreatorAsOwner = z;
        this.groupExternalId = str2;
        this.groupManagementType = groupManagementType;
    }

    public GroupCreateArg(@Nonnull String str) {
        this(str, false, null, null);
    }

    @Nonnull
    public String getGroupName() {
        return this.groupName;
    }

    public boolean getAddCreatorAsOwner() {
        return this.addCreatorAsOwner;
    }

    @Nullable
    public String getGroupExternalId() {
        return this.groupExternalId;
    }

    @Nullable
    public GroupManagementType getGroupManagementType() {
        return this.groupManagementType;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected boolean addCreatorAsOwner;
        protected String groupExternalId;
        protected GroupManagementType groupManagementType;
        protected final String groupName;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'groupName' is null");
            }
            this.groupName = str;
            this.addCreatorAsOwner = false;
            this.groupExternalId = null;
            this.groupManagementType = null;
        }

        public Builder withAddCreatorAsOwner(Boolean bool) {
            if (bool != null) {
                this.addCreatorAsOwner = bool.booleanValue();
                return this;
            }
            this.addCreatorAsOwner = false;
            return this;
        }

        public Builder withGroupExternalId(String str) {
            this.groupExternalId = str;
            return this;
        }

        public Builder withGroupManagementType(GroupManagementType groupManagementType) {
            this.groupManagementType = groupManagementType;
            return this;
        }

        public GroupCreateArg build() {
            return new GroupCreateArg(this.groupName, this.addCreatorAsOwner, this.groupExternalId, this.groupManagementType);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.groupName, Boolean.valueOf(this.addCreatorAsOwner), this.groupExternalId, this.groupManagementType});
    }

    public boolean equals(Object obj) {
        GroupCreateArg groupCreateArg;
        String str;
        String str2;
        String str3;
        String str4;
        GroupManagementType groupManagementType;
        GroupManagementType groupManagementType2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.groupName) == (str2 = (groupCreateArg = (GroupCreateArg) obj).groupName) || str.equals(str2)) && this.addCreatorAsOwner == groupCreateArg.addCreatorAsOwner && (((str3 = this.groupExternalId) == (str4 = groupCreateArg.groupExternalId) || (str3 != null && str3.equals(str4))) && ((groupManagementType = this.groupManagementType) == (groupManagementType2 = groupCreateArg.groupManagementType) || (groupManagementType != null && groupManagementType.equals(groupManagementType2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupCreateArg groupCreateArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group_name");
            StoneSerializers.string().serialize(groupCreateArg.groupName, jsonGenerator);
            jsonGenerator.writeFieldName("add_creator_as_owner");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(groupCreateArg.addCreatorAsOwner), jsonGenerator);
            if (groupCreateArg.groupExternalId != null) {
                jsonGenerator.writeFieldName("group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(groupCreateArg.groupExternalId, jsonGenerator);
            }
            if (groupCreateArg.groupManagementType != null) {
                jsonGenerator.writeFieldName("group_management_type");
                StoneSerializers.nullable(GroupManagementType.Serializer.INSTANCE).serialize(groupCreateArg.groupManagementType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupCreateArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                GroupManagementType groupManagementType = null;
                Boolean boolDeserialize = false;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("group_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("add_creator_as_owner".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("group_external_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("group_management_type".equals(currentName)) {
                        groupManagementType = (GroupManagementType) StoneSerializers.nullable(GroupManagementType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group_name\" missing.");
                }
                GroupCreateArg groupCreateArg = new GroupCreateArg(strDeserialize, boolDeserialize.booleanValue(), str, groupManagementType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupCreateArg, groupCreateArg.toStringMultiline());
                return groupCreateArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
