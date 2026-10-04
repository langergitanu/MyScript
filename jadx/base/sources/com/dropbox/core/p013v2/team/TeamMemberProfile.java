package com.dropbox.core.p013v2.team;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.runtime.auth.credentials.profile.ProfileChainKt;
import com.dropbox.core.p013v2.secondaryemails.SecondaryEmail;
import com.dropbox.core.p013v2.team.MemberProfile;
import com.dropbox.core.p013v2.team.TeamMemberStatus;
import com.dropbox.core.p013v2.team.TeamMembershipType;
import com.dropbox.core.p013v2.users.Name;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class TeamMemberProfile extends MemberProfile {

    @Nonnull
    protected final List<String> groups;

    @Nonnull
    protected final String memberFolderId;

    public TeamMemberProfile(@Nonnull String str, @Nonnull String str2, boolean z, @Nonnull TeamMemberStatus teamMemberStatus, @Nonnull Name name, @Nonnull TeamMembershipType teamMembershipType, @Nonnull List<String> list, @Nonnull String str3, @Nullable String str4, @Nullable String str5, @Nullable List<SecondaryEmail> list2, @Nullable Date date, @Nullable Date date2, @Nullable Date date3, @Nullable String str6, @Nullable Boolean bool, @Nullable String str7) {
        super(str, str2, z, teamMemberStatus, name, teamMembershipType, str4, str5, list2, date, date2, date3, str6, bool, str7);
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'groups' is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'groups' is null");
            }
        }
        this.groups = list;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'memberFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str3)) {
            throw new IllegalArgumentException("String 'memberFolderId' does not match pattern");
        }
        this.memberFolderId = str3;
    }

    public TeamMemberProfile(@Nonnull String str, @Nonnull String str2, boolean z, @Nonnull TeamMemberStatus teamMemberStatus, @Nonnull Name name, @Nonnull TeamMembershipType teamMembershipType, @Nonnull List<String> list, @Nonnull String str3) {
        this(str, str2, z, teamMemberStatus, name, teamMembershipType, list, str3, null, null, null, null, null, null, null, null, null);
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nonnull
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nonnull
    public String getEmail() {
        return this.email;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    public boolean getEmailVerified() {
        return this.emailVerified;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nonnull
    public TeamMemberStatus getStatus() {
        return this.status;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nonnull
    public Name getName() {
        return this.name;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nonnull
    public TeamMembershipType getMembershipType() {
        return this.membershipType;
    }

    @Nonnull
    public List<String> getGroups() {
        return this.groups;
    }

    @Nonnull
    public String getMemberFolderId() {
        return this.memberFolderId;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nullable
    public String getExternalId() {
        return this.externalId;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nullable
    public String getAccountId() {
        return this.accountId;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nullable
    public List<SecondaryEmail> getSecondaryEmails() {
        return this.secondaryEmails;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nullable
    public Date getInvitedOn() {
        return this.invitedOn;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nullable
    public Date getJoinedOn() {
        return this.joinedOn;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nullable
    public Date getSuspendedOn() {
        return this.suspendedOn;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nullable
    public String getPersistentId() {
        return this.persistentId;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nullable
    public Boolean getIsDirectoryRestricted() {
        return this.isDirectoryRestricted;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    @Nullable
    public String getProfilePhotoUrl() {
        return this.profilePhotoUrl;
    }

    public static Builder newBuilder(String str, String str2, boolean z, TeamMemberStatus teamMemberStatus, Name name, TeamMembershipType teamMembershipType, List<String> list, String str3) {
        return new Builder(str, str2, z, teamMemberStatus, name, teamMembershipType, list, str3);
    }

    public static class Builder extends MemberProfile.Builder {
        protected final List<String> groups;
        protected final String memberFolderId;

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public /* bridge */ /* synthetic */ MemberProfile.Builder withSecondaryEmails(List list) {
            return withSecondaryEmails((List<SecondaryEmail>) list);
        }

        protected Builder(String str, String str2, boolean z, TeamMemberStatus teamMemberStatus, Name name, TeamMembershipType teamMembershipType, List<String> list, String str3) {
            super(str, str2, z, teamMemberStatus, name, teamMembershipType);
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'groups' is null");
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'groups' is null");
                }
            }
            this.groups = list;
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'memberFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", str3)) {
                throw new IllegalArgumentException("String 'memberFolderId' does not match pattern");
            }
            this.memberFolderId = str3;
        }

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public Builder withExternalId(String str) {
            super.withExternalId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public Builder withAccountId(String str) {
            super.withAccountId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public Builder withSecondaryEmails(List<SecondaryEmail> list) {
            super.withSecondaryEmails(list);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public Builder withInvitedOn(Date date) {
            super.withInvitedOn(date);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public Builder withJoinedOn(Date date) {
            super.withJoinedOn(date);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public Builder withSuspendedOn(Date date) {
            super.withSuspendedOn(date);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public Builder withPersistentId(String str) {
            super.withPersistentId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public Builder withIsDirectoryRestricted(Boolean bool) {
            super.withIsDirectoryRestricted(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public Builder withProfilePhotoUrl(String str) {
            super.withProfilePhotoUrl(str);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberProfile.Builder
        public TeamMemberProfile build() {
            return new TeamMemberProfile(this.teamMemberId, this.email, this.emailVerified, this.status, this.name, this.membershipType, this.groups, this.memberFolderId, this.externalId, this.accountId, this.secondaryEmails, this.invitedOn, this.joinedOn, this.suspendedOn, this.persistentId, this.isDirectoryRestricted, this.profilePhotoUrl);
        }
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.groups, this.memberFolderId});
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            TeamMemberProfile teamMemberProfile = (TeamMemberProfile) obj;
            if ((this.teamMemberId == teamMemberProfile.teamMemberId || this.teamMemberId.equals(teamMemberProfile.teamMemberId)) && ((this.email == teamMemberProfile.email || this.email.equals(teamMemberProfile.email)) && this.emailVerified == teamMemberProfile.emailVerified && ((this.status == teamMemberProfile.status || this.status.equals(teamMemberProfile.status)) && ((this.name == teamMemberProfile.name || this.name.equals(teamMemberProfile.name)) && ((this.membershipType == teamMemberProfile.membershipType || this.membershipType.equals(teamMemberProfile.membershipType)) && (((list = this.groups) == (list2 = teamMemberProfile.groups) || list.equals(list2)) && (((str = this.memberFolderId) == (str2 = teamMemberProfile.memberFolderId) || str.equals(str2)) && ((this.externalId == teamMemberProfile.externalId || (this.externalId != null && this.externalId.equals(teamMemberProfile.externalId))) && ((this.accountId == teamMemberProfile.accountId || (this.accountId != null && this.accountId.equals(teamMemberProfile.accountId))) && ((this.secondaryEmails == teamMemberProfile.secondaryEmails || (this.secondaryEmails != null && this.secondaryEmails.equals(teamMemberProfile.secondaryEmails))) && ((this.invitedOn == teamMemberProfile.invitedOn || (this.invitedOn != null && this.invitedOn.equals(teamMemberProfile.invitedOn))) && ((this.joinedOn == teamMemberProfile.joinedOn || (this.joinedOn != null && this.joinedOn.equals(teamMemberProfile.joinedOn))) && ((this.suspendedOn == teamMemberProfile.suspendedOn || (this.suspendedOn != null && this.suspendedOn.equals(teamMemberProfile.suspendedOn))) && ((this.persistentId == teamMemberProfile.persistentId || (this.persistentId != null && this.persistentId.equals(teamMemberProfile.persistentId))) && ((this.isDirectoryRestricted == teamMemberProfile.isDirectoryRestricted || (this.isDirectoryRestricted != null && this.isDirectoryRestricted.equals(teamMemberProfile.isDirectoryRestricted))) && (this.profilePhotoUrl == teamMemberProfile.profilePhotoUrl || (this.profilePhotoUrl != null && this.profilePhotoUrl.equals(teamMemberProfile.profilePhotoUrl)))))))))))))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.MemberProfile
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMemberProfile> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMemberProfile teamMemberProfile, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(teamMemberProfile.teamMemberId, jsonGenerator);
            jsonGenerator.writeFieldName("email");
            StoneSerializers.string().serialize(teamMemberProfile.email, jsonGenerator);
            jsonGenerator.writeFieldName("email_verified");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(teamMemberProfile.emailVerified), jsonGenerator);
            jsonGenerator.writeFieldName(NotificationCompat.CATEGORY_STATUS);
            TeamMemberStatus.Serializer.INSTANCE.serialize(teamMemberProfile.status, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            Name.Serializer.INSTANCE.serialize(teamMemberProfile.name, jsonGenerator);
            jsonGenerator.writeFieldName("membership_type");
            TeamMembershipType.Serializer.INSTANCE.serialize(teamMemberProfile.membershipType, jsonGenerator);
            jsonGenerator.writeFieldName("groups");
            StoneSerializers.list(StoneSerializers.string()).serialize(teamMemberProfile.groups, jsonGenerator);
            jsonGenerator.writeFieldName("member_folder_id");
            StoneSerializers.string().serialize(teamMemberProfile.memberFolderId, jsonGenerator);
            if (teamMemberProfile.externalId != null) {
                jsonGenerator.writeFieldName(ProfileChainKt.EXTERNAL_ID);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(teamMemberProfile.externalId, jsonGenerator);
            }
            if (teamMemberProfile.accountId != null) {
                jsonGenerator.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(teamMemberProfile.accountId, jsonGenerator);
            }
            if (teamMemberProfile.secondaryEmails != null) {
                jsonGenerator.writeFieldName("secondary_emails");
                StoneSerializers.nullable(StoneSerializers.list(SecondaryEmail.Serializer.INSTANCE)).serialize(teamMemberProfile.secondaryEmails, jsonGenerator);
            }
            if (teamMemberProfile.invitedOn != null) {
                jsonGenerator.writeFieldName("invited_on");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(teamMemberProfile.invitedOn, jsonGenerator);
            }
            if (teamMemberProfile.joinedOn != null) {
                jsonGenerator.writeFieldName("joined_on");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(teamMemberProfile.joinedOn, jsonGenerator);
            }
            if (teamMemberProfile.suspendedOn != null) {
                jsonGenerator.writeFieldName("suspended_on");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(teamMemberProfile.suspendedOn, jsonGenerator);
            }
            if (teamMemberProfile.persistentId != null) {
                jsonGenerator.writeFieldName("persistent_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(teamMemberProfile.persistentId, jsonGenerator);
            }
            if (teamMemberProfile.isDirectoryRestricted != null) {
                jsonGenerator.writeFieldName("is_directory_restricted");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(teamMemberProfile.isDirectoryRestricted, jsonGenerator);
            }
            if (teamMemberProfile.profilePhotoUrl != null) {
                jsonGenerator.writeFieldName("profile_photo_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(teamMemberProfile.profilePhotoUrl, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMemberProfile deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                TeamMemberStatus teamMemberStatusDeserialize = null;
                Name nameDeserialize = null;
                TeamMembershipType teamMembershipTypeDeserialize = null;
                List list = null;
                String strDeserialize3 = null;
                String str = null;
                String str2 = null;
                List list2 = null;
                Date date = null;
                Date date2 = null;
                Date date3 = null;
                String str3 = null;
                Boolean bool = null;
                String str4 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_member_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("email".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("email_verified".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if (NotificationCompat.CATEGORY_STATUS.equals(currentName)) {
                        teamMemberStatusDeserialize = TeamMemberStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        nameDeserialize = Name.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("membership_type".equals(currentName)) {
                        teamMembershipTypeDeserialize = TeamMembershipType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("groups".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("member_folder_id".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if (ProfileChainKt.EXTERNAL_ID.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("account_id".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("secondary_emails".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(SecondaryEmail.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("invited_on".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("joined_on".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("suspended_on".equals(currentName)) {
                        date3 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("persistent_id".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("is_directory_restricted".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("profile_photo_url".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_member_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"email\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"email_verified\" missing.");
                }
                if (teamMemberStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"status\" missing.");
                }
                if (nameDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (teamMembershipTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"membership_type\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"groups\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member_folder_id\" missing.");
                }
                TeamMemberProfile teamMemberProfile = new TeamMemberProfile(strDeserialize, strDeserialize2, boolDeserialize.booleanValue(), teamMemberStatusDeserialize, nameDeserialize, teamMembershipTypeDeserialize, list, strDeserialize3, str, str2, list2, date, date2, date3, str3, bool, str4);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMemberProfile, teamMemberProfile.toStringMultiline());
                return teamMemberProfile;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
