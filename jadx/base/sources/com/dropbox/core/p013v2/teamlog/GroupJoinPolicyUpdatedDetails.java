package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.GroupJoinPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class GroupJoinPolicyUpdatedDetails {

    @Nullable
    protected final Boolean isCompanyManaged;

    @Nullable
    protected final GroupJoinPolicy joinPolicy;

    public GroupJoinPolicyUpdatedDetails(@Nullable Boolean bool, @Nullable GroupJoinPolicy groupJoinPolicy) {
        this.isCompanyManaged = bool;
        this.joinPolicy = groupJoinPolicy;
    }

    public GroupJoinPolicyUpdatedDetails() {
        this(null, null);
    }

    @Nullable
    public Boolean getIsCompanyManaged() {
        return this.isCompanyManaged;
    }

    @Nullable
    public GroupJoinPolicy getJoinPolicy() {
        return this.joinPolicy;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected Boolean isCompanyManaged = null;
        protected GroupJoinPolicy joinPolicy = null;

        protected Builder() {
        }

        public Builder withIsCompanyManaged(Boolean bool) {
            this.isCompanyManaged = bool;
            return this;
        }

        public Builder withJoinPolicy(GroupJoinPolicy groupJoinPolicy) {
            this.joinPolicy = groupJoinPolicy;
            return this;
        }

        public GroupJoinPolicyUpdatedDetails build() {
            return new GroupJoinPolicyUpdatedDetails(this.isCompanyManaged, this.joinPolicy);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.isCompanyManaged, this.joinPolicy});
    }

    public boolean equals(Object obj) {
        GroupJoinPolicy groupJoinPolicy;
        GroupJoinPolicy groupJoinPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GroupJoinPolicyUpdatedDetails groupJoinPolicyUpdatedDetails = (GroupJoinPolicyUpdatedDetails) obj;
        Boolean bool = this.isCompanyManaged;
        Boolean bool2 = groupJoinPolicyUpdatedDetails.isCompanyManaged;
        return (bool == bool2 || (bool != null && bool.equals(bool2))) && ((groupJoinPolicy = this.joinPolicy) == (groupJoinPolicy2 = groupJoinPolicyUpdatedDetails.joinPolicy) || (groupJoinPolicy != null && groupJoinPolicy.equals(groupJoinPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupJoinPolicyUpdatedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupJoinPolicyUpdatedDetails groupJoinPolicyUpdatedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (groupJoinPolicyUpdatedDetails.isCompanyManaged != null) {
                jsonGenerator.writeFieldName("is_company_managed");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(groupJoinPolicyUpdatedDetails.isCompanyManaged, jsonGenerator);
            }
            if (groupJoinPolicyUpdatedDetails.joinPolicy != null) {
                jsonGenerator.writeFieldName("join_policy");
                StoneSerializers.nullable(GroupJoinPolicy.Serializer.INSTANCE).serialize(groupJoinPolicyUpdatedDetails.joinPolicy, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupJoinPolicyUpdatedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean bool = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                GroupJoinPolicy groupJoinPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("is_company_managed".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("join_policy".equals(currentName)) {
                        groupJoinPolicy = (GroupJoinPolicy) StoneSerializers.nullable(GroupJoinPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                GroupJoinPolicyUpdatedDetails groupJoinPolicyUpdatedDetails = new GroupJoinPolicyUpdatedDetails(bool, groupJoinPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupJoinPolicyUpdatedDetails, groupJoinPolicyUpdatedDetails.toStringMultiline());
                return groupJoinPolicyUpdatedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
