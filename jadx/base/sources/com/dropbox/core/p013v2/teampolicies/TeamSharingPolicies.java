package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.p013v2.teampolicies.GroupCreation;
import com.dropbox.core.p013v2.teampolicies.SharedFolderBlanketLinkRestrictionPolicy;
import com.dropbox.core.p013v2.teampolicies.SharedFolderJoinPolicy;
import com.dropbox.core.p013v2.teampolicies.SharedFolderMemberPolicy;
import com.dropbox.core.p013v2.teampolicies.SharedLinkCreatePolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class TeamSharingPolicies {

    @Nonnull
    protected final GroupCreation groupCreationPolicy;

    @Nonnull
    protected final SharedFolderJoinPolicy sharedFolderJoinPolicy;

    @Nonnull
    protected final SharedFolderBlanketLinkRestrictionPolicy sharedFolderLinkRestrictionPolicy;

    @Nonnull
    protected final SharedFolderMemberPolicy sharedFolderMemberPolicy;

    @Nonnull
    protected final SharedLinkCreatePolicy sharedLinkCreatePolicy;

    public TeamSharingPolicies(@Nonnull SharedFolderMemberPolicy sharedFolderMemberPolicy, @Nonnull SharedFolderJoinPolicy sharedFolderJoinPolicy, @Nonnull SharedLinkCreatePolicy sharedLinkCreatePolicy, @Nonnull GroupCreation groupCreation, @Nonnull SharedFolderBlanketLinkRestrictionPolicy sharedFolderBlanketLinkRestrictionPolicy) {
        if (sharedFolderMemberPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderMemberPolicy' is null");
        }
        this.sharedFolderMemberPolicy = sharedFolderMemberPolicy;
        if (sharedFolderJoinPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderJoinPolicy' is null");
        }
        this.sharedFolderJoinPolicy = sharedFolderJoinPolicy;
        if (sharedLinkCreatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinkCreatePolicy' is null");
        }
        this.sharedLinkCreatePolicy = sharedLinkCreatePolicy;
        if (groupCreation == null) {
            throw new IllegalArgumentException("Required value for 'groupCreationPolicy' is null");
        }
        this.groupCreationPolicy = groupCreation;
        if (sharedFolderBlanketLinkRestrictionPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderLinkRestrictionPolicy' is null");
        }
        this.sharedFolderLinkRestrictionPolicy = sharedFolderBlanketLinkRestrictionPolicy;
    }

    @Nonnull
    public SharedFolderMemberPolicy getSharedFolderMemberPolicy() {
        return this.sharedFolderMemberPolicy;
    }

    @Nonnull
    public SharedFolderJoinPolicy getSharedFolderJoinPolicy() {
        return this.sharedFolderJoinPolicy;
    }

    @Nonnull
    public SharedLinkCreatePolicy getSharedLinkCreatePolicy() {
        return this.sharedLinkCreatePolicy;
    }

    @Nonnull
    public GroupCreation getGroupCreationPolicy() {
        return this.groupCreationPolicy;
    }

    @Nonnull
    public SharedFolderBlanketLinkRestrictionPolicy getSharedFolderLinkRestrictionPolicy() {
        return this.sharedFolderLinkRestrictionPolicy;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedFolderMemberPolicy, this.sharedFolderJoinPolicy, this.sharedLinkCreatePolicy, this.groupCreationPolicy, this.sharedFolderLinkRestrictionPolicy});
    }

    public boolean equals(Object obj) {
        SharedFolderJoinPolicy sharedFolderJoinPolicy;
        SharedFolderJoinPolicy sharedFolderJoinPolicy2;
        SharedLinkCreatePolicy sharedLinkCreatePolicy;
        SharedLinkCreatePolicy sharedLinkCreatePolicy2;
        GroupCreation groupCreation;
        GroupCreation groupCreation2;
        SharedFolderBlanketLinkRestrictionPolicy sharedFolderBlanketLinkRestrictionPolicy;
        SharedFolderBlanketLinkRestrictionPolicy sharedFolderBlanketLinkRestrictionPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamSharingPolicies teamSharingPolicies = (TeamSharingPolicies) obj;
        SharedFolderMemberPolicy sharedFolderMemberPolicy = this.sharedFolderMemberPolicy;
        SharedFolderMemberPolicy sharedFolderMemberPolicy2 = teamSharingPolicies.sharedFolderMemberPolicy;
        return (sharedFolderMemberPolicy == sharedFolderMemberPolicy2 || sharedFolderMemberPolicy.equals(sharedFolderMemberPolicy2)) && ((sharedFolderJoinPolicy = this.sharedFolderJoinPolicy) == (sharedFolderJoinPolicy2 = teamSharingPolicies.sharedFolderJoinPolicy) || sharedFolderJoinPolicy.equals(sharedFolderJoinPolicy2)) && (((sharedLinkCreatePolicy = this.sharedLinkCreatePolicy) == (sharedLinkCreatePolicy2 = teamSharingPolicies.sharedLinkCreatePolicy) || sharedLinkCreatePolicy.equals(sharedLinkCreatePolicy2)) && (((groupCreation = this.groupCreationPolicy) == (groupCreation2 = teamSharingPolicies.groupCreationPolicy) || groupCreation.equals(groupCreation2)) && ((sharedFolderBlanketLinkRestrictionPolicy = this.sharedFolderLinkRestrictionPolicy) == (sharedFolderBlanketLinkRestrictionPolicy2 = teamSharingPolicies.sharedFolderLinkRestrictionPolicy) || sharedFolderBlanketLinkRestrictionPolicy.equals(sharedFolderBlanketLinkRestrictionPolicy2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<TeamSharingPolicies> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamSharingPolicies teamSharingPolicies, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_folder_member_policy");
            SharedFolderMemberPolicy.Serializer.INSTANCE.serialize(teamSharingPolicies.sharedFolderMemberPolicy, jsonGenerator);
            jsonGenerator.writeFieldName("shared_folder_join_policy");
            SharedFolderJoinPolicy.Serializer.INSTANCE.serialize(teamSharingPolicies.sharedFolderJoinPolicy, jsonGenerator);
            jsonGenerator.writeFieldName("shared_link_create_policy");
            SharedLinkCreatePolicy.Serializer.INSTANCE.serialize(teamSharingPolicies.sharedLinkCreatePolicy, jsonGenerator);
            jsonGenerator.writeFieldName("group_creation_policy");
            GroupCreation.Serializer.INSTANCE.serialize(teamSharingPolicies.groupCreationPolicy, jsonGenerator);
            jsonGenerator.writeFieldName("shared_folder_link_restriction_policy");
            SharedFolderBlanketLinkRestrictionPolicy.Serializer.INSTANCE.serialize(teamSharingPolicies.sharedFolderLinkRestrictionPolicy, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamSharingPolicies deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SharedFolderMemberPolicy sharedFolderMemberPolicyDeserialize = null;
                SharedFolderJoinPolicy sharedFolderJoinPolicyDeserialize = null;
                SharedLinkCreatePolicy sharedLinkCreatePolicyDeserialize = null;
                GroupCreation groupCreationDeserialize = null;
                SharedFolderBlanketLinkRestrictionPolicy sharedFolderBlanketLinkRestrictionPolicyDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_folder_member_policy".equals(currentName)) {
                        sharedFolderMemberPolicyDeserialize = SharedFolderMemberPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("shared_folder_join_policy".equals(currentName)) {
                        sharedFolderJoinPolicyDeserialize = SharedFolderJoinPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("shared_link_create_policy".equals(currentName)) {
                        sharedLinkCreatePolicyDeserialize = SharedLinkCreatePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("group_creation_policy".equals(currentName)) {
                        groupCreationDeserialize = GroupCreation.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("shared_folder_link_restriction_policy".equals(currentName)) {
                        sharedFolderBlanketLinkRestrictionPolicyDeserialize = SharedFolderBlanketLinkRestrictionPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (sharedFolderMemberPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_member_policy\" missing.");
                }
                if (sharedFolderJoinPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_join_policy\" missing.");
                }
                if (sharedLinkCreatePolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_link_create_policy\" missing.");
                }
                if (groupCreationDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group_creation_policy\" missing.");
                }
                if (sharedFolderBlanketLinkRestrictionPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_link_restriction_policy\" missing.");
                }
                TeamSharingPolicies teamSharingPolicies = new TeamSharingPolicies(sharedFolderMemberPolicyDeserialize, sharedFolderJoinPolicyDeserialize, sharedLinkCreatePolicyDeserialize, groupCreationDeserialize, sharedFolderBlanketLinkRestrictionPolicyDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamSharingPolicies, teamSharingPolicies.toStringMultiline());
                return teamSharingPolicies;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
