package com.dropbox.core.p013v2.team;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.runtime.auth.credentials.profile.ProfileChainKt;
import com.dropbox.core.p013v2.secondaryemails.SecondaryEmail;
import com.dropbox.core.p013v2.team.TeamMemberStatus;
import com.dropbox.core.p013v2.team.TeamMembershipType;
import com.dropbox.core.p013v2.users.Name;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class MemberProfile {

    @Nullable
    protected final String accountId;

    @Nonnull
    protected final String email;
    protected final boolean emailVerified;

    @Nullable
    protected final String externalId;

    @Nullable
    protected final Date invitedOn;

    @Nullable
    protected final Boolean isDirectoryRestricted;

    @Nullable
    protected final Date joinedOn;

    @Nonnull
    protected final TeamMembershipType membershipType;

    @Nonnull
    protected final Name name;

    @Nullable
    protected final String persistentId;

    @Nullable
    protected final String profilePhotoUrl;

    @Nullable
    protected final List<SecondaryEmail> secondaryEmails;

    @Nonnull
    protected final TeamMemberStatus status;

    @Nullable
    protected final Date suspendedOn;

    @Nonnull
    protected final String teamMemberId;

    public MemberProfile(@Nonnull String str, @Nonnull String str2, boolean z, @Nonnull TeamMemberStatus teamMemberStatus, @Nonnull Name name, @Nonnull TeamMembershipType teamMembershipType, @Nullable String str3, @Nullable String str4, @Nullable List<SecondaryEmail> list, @Nullable Date date, @Nullable Date date2, @Nullable Date date3, @Nullable String str5, @Nullable Boolean bool, @Nullable String str6) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = str;
        this.externalId = str3;
        if (str4 != null) {
            if (str4.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (str4.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
            }
        }
        this.accountId = str4;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'email' is null");
        }
        this.email = str2;
        this.emailVerified = z;
        if (list != null) {
            Iterator<SecondaryEmail> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'secondaryEmails' is null");
                }
            }
        }
        this.secondaryEmails = list;
        if (teamMemberStatus == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = teamMemberStatus;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (teamMembershipType == null) {
            throw new IllegalArgumentException("Required value for 'membershipType' is null");
        }
        this.membershipType = teamMembershipType;
        this.invitedOn = LangUtil.truncateMillis(date);
        this.joinedOn = LangUtil.truncateMillis(date2);
        this.suspendedOn = LangUtil.truncateMillis(date3);
        this.persistentId = str5;
        this.isDirectoryRestricted = bool;
        this.profilePhotoUrl = str6;
    }

    public MemberProfile(@Nonnull String str, @Nonnull String str2, boolean z, @Nonnull TeamMemberStatus teamMemberStatus, @Nonnull Name name, @Nonnull TeamMembershipType teamMembershipType) {
        this(str, str2, z, teamMemberStatus, name, teamMembershipType, null, null, null, null, null, null, null, null, null);
    }

    @Nonnull
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    @Nonnull
    public String getEmail() {
        return this.email;
    }

    public boolean getEmailVerified() {
        return this.emailVerified;
    }

    @Nonnull
    public TeamMemberStatus getStatus() {
        return this.status;
    }

    @Nonnull
    public Name getName() {
        return this.name;
    }

    @Nonnull
    public TeamMembershipType getMembershipType() {
        return this.membershipType;
    }

    @Nullable
    public String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public String getAccountId() {
        return this.accountId;
    }

    @Nullable
    public List<SecondaryEmail> getSecondaryEmails() {
        return this.secondaryEmails;
    }

    @Nullable
    public Date getInvitedOn() {
        return this.invitedOn;
    }

    @Nullable
    public Date getJoinedOn() {
        return this.joinedOn;
    }

    @Nullable
    public Date getSuspendedOn() {
        return this.suspendedOn;
    }

    @Nullable
    public String getPersistentId() {
        return this.persistentId;
    }

    @Nullable
    public Boolean getIsDirectoryRestricted() {
        return this.isDirectoryRestricted;
    }

    @Nullable
    public String getProfilePhotoUrl() {
        return this.profilePhotoUrl;
    }

    public static Builder newBuilder(String str, String str2, boolean z, TeamMemberStatus teamMemberStatus, Name name, TeamMembershipType teamMembershipType) {
        return new Builder(str, str2, z, teamMemberStatus, name, teamMembershipType);
    }

    public static class Builder {
        protected String accountId;
        protected final String email;
        protected final boolean emailVerified;
        protected String externalId;
        protected Date invitedOn;
        protected Boolean isDirectoryRestricted;
        protected Date joinedOn;
        protected final TeamMembershipType membershipType;
        protected final Name name;
        protected String persistentId;
        protected String profilePhotoUrl;
        protected List<SecondaryEmail> secondaryEmails;
        protected final TeamMemberStatus status;
        protected Date suspendedOn;
        protected final String teamMemberId;

        protected Builder(String str, String str2, boolean z, TeamMemberStatus teamMemberStatus, Name name, TeamMembershipType teamMembershipType) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
            }
            this.teamMemberId = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'email' is null");
            }
            this.email = str2;
            this.emailVerified = z;
            if (teamMemberStatus == null) {
                throw new IllegalArgumentException("Required value for 'status' is null");
            }
            this.status = teamMemberStatus;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (teamMembershipType == null) {
                throw new IllegalArgumentException("Required value for 'membershipType' is null");
            }
            this.membershipType = teamMembershipType;
            this.externalId = null;
            this.accountId = null;
            this.secondaryEmails = null;
            this.invitedOn = null;
            this.joinedOn = null;
            this.suspendedOn = null;
            this.persistentId = null;
            this.isDirectoryRestricted = null;
            this.profilePhotoUrl = null;
        }

        public Builder withExternalId(String str) {
            this.externalId = str;
            return this;
        }

        public Builder withAccountId(String str) {
            if (str != null) {
                if (str.length() < 40) {
                    throw new IllegalArgumentException("String 'accountId' is shorter than 40");
                }
                if (str.length() > 40) {
                    throw new IllegalArgumentException("String 'accountId' is longer than 40");
                }
            }
            this.accountId = str;
            return this;
        }

        public Builder withSecondaryEmails(List<SecondaryEmail> list) {
            if (list != null) {
                Iterator<SecondaryEmail> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'secondaryEmails' is null");
                    }
                }
            }
            this.secondaryEmails = list;
            return this;
        }

        public Builder withInvitedOn(Date date) {
            this.invitedOn = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withJoinedOn(Date date) {
            this.joinedOn = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withSuspendedOn(Date date) {
            this.suspendedOn = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withPersistentId(String str) {
            this.persistentId = str;
            return this;
        }

        public Builder withIsDirectoryRestricted(Boolean bool) {
            this.isDirectoryRestricted = bool;
            return this;
        }

        public Builder withProfilePhotoUrl(String str) {
            this.profilePhotoUrl = str;
            return this;
        }

        public MemberProfile build() {
            return new MemberProfile(this.teamMemberId, this.email, this.emailVerified, this.status, this.name, this.membershipType, this.externalId, this.accountId, this.secondaryEmails, this.invitedOn, this.joinedOn, this.suspendedOn, this.persistentId, this.isDirectoryRestricted, this.profilePhotoUrl);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamMemberId, this.externalId, this.accountId, this.email, Boolean.valueOf(this.emailVerified), this.secondaryEmails, this.status, this.name, this.membershipType, this.invitedOn, this.joinedOn, this.suspendedOn, this.persistentId, this.isDirectoryRestricted, this.profilePhotoUrl});
    }

    public boolean equals(Object obj) {
        MemberProfile memberProfile;
        String str;
        String str2;
        String str3;
        String str4;
        TeamMemberStatus teamMemberStatus;
        TeamMemberStatus teamMemberStatus2;
        Name name;
        Name name2;
        TeamMembershipType teamMembershipType;
        TeamMembershipType teamMembershipType2;
        String str5;
        String str6;
        String str7;
        String str8;
        List<SecondaryEmail> list;
        List<SecondaryEmail> list2;
        Date date;
        Date date2;
        Date date3;
        Date date4;
        Date date5;
        Date date6;
        String str9;
        String str10;
        Boolean bool;
        Boolean bool2;
        String str11;
        String str12;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.teamMemberId) == (str2 = (memberProfile = (MemberProfile) obj).teamMemberId) || str.equals(str2)) && (((str3 = this.email) == (str4 = memberProfile.email) || str3.equals(str4)) && this.emailVerified == memberProfile.emailVerified && (((teamMemberStatus = this.status) == (teamMemberStatus2 = memberProfile.status) || teamMemberStatus.equals(teamMemberStatus2)) && (((name = this.name) == (name2 = memberProfile.name) || name.equals(name2)) && (((teamMembershipType = this.membershipType) == (teamMembershipType2 = memberProfile.membershipType) || teamMembershipType.equals(teamMembershipType2)) && (((str5 = this.externalId) == (str6 = memberProfile.externalId) || (str5 != null && str5.equals(str6))) && (((str7 = this.accountId) == (str8 = memberProfile.accountId) || (str7 != null && str7.equals(str8))) && (((list = this.secondaryEmails) == (list2 = memberProfile.secondaryEmails) || (list != null && list.equals(list2))) && (((date = this.invitedOn) == (date2 = memberProfile.invitedOn) || (date != null && date.equals(date2))) && (((date3 = this.joinedOn) == (date4 = memberProfile.joinedOn) || (date3 != null && date3.equals(date4))) && (((date5 = this.suspendedOn) == (date6 = memberProfile.suspendedOn) || (date5 != null && date5.equals(date6))) && (((str9 = this.persistentId) == (str10 = memberProfile.persistentId) || (str9 != null && str9.equals(str10))) && (((bool = this.isDirectoryRestricted) == (bool2 = memberProfile.isDirectoryRestricted) || (bool != null && bool.equals(bool2))) && ((str11 = this.profilePhotoUrl) == (str12 = memberProfile.profilePhotoUrl) || (str11 != null && str11.equals(str12)))))))))))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberProfile> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberProfile memberProfile, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(memberProfile.teamMemberId, jsonGenerator);
            jsonGenerator.writeFieldName("email");
            StoneSerializers.string().serialize(memberProfile.email, jsonGenerator);
            jsonGenerator.writeFieldName("email_verified");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(memberProfile.emailVerified), jsonGenerator);
            jsonGenerator.writeFieldName(NotificationCompat.CATEGORY_STATUS);
            TeamMemberStatus.Serializer.INSTANCE.serialize(memberProfile.status, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            Name.Serializer.INSTANCE.serialize(memberProfile.name, jsonGenerator);
            jsonGenerator.writeFieldName("membership_type");
            TeamMembershipType.Serializer.INSTANCE.serialize(memberProfile.membershipType, jsonGenerator);
            if (memberProfile.externalId != null) {
                jsonGenerator.writeFieldName(ProfileChainKt.EXTERNAL_ID);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberProfile.externalId, jsonGenerator);
            }
            if (memberProfile.accountId != null) {
                jsonGenerator.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberProfile.accountId, jsonGenerator);
            }
            if (memberProfile.secondaryEmails != null) {
                jsonGenerator.writeFieldName("secondary_emails");
                StoneSerializers.nullable(StoneSerializers.list(SecondaryEmail.Serializer.INSTANCE)).serialize(memberProfile.secondaryEmails, jsonGenerator);
            }
            if (memberProfile.invitedOn != null) {
                jsonGenerator.writeFieldName("invited_on");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(memberProfile.invitedOn, jsonGenerator);
            }
            if (memberProfile.joinedOn != null) {
                jsonGenerator.writeFieldName("joined_on");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(memberProfile.joinedOn, jsonGenerator);
            }
            if (memberProfile.suspendedOn != null) {
                jsonGenerator.writeFieldName("suspended_on");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(memberProfile.suspendedOn, jsonGenerator);
            }
            if (memberProfile.persistentId != null) {
                jsonGenerator.writeFieldName("persistent_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberProfile.persistentId, jsonGenerator);
            }
            if (memberProfile.isDirectoryRestricted != null) {
                jsonGenerator.writeFieldName("is_directory_restricted");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(memberProfile.isDirectoryRestricted, jsonGenerator);
            }
            if (memberProfile.profilePhotoUrl != null) {
                jsonGenerator.writeFieldName("profile_photo_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberProfile.profilePhotoUrl, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberProfile deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String str = null;
                String str2 = null;
                List list = null;
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
                    } else if (ProfileChainKt.EXTERNAL_ID.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("account_id".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("secondary_emails".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(SecondaryEmail.Serializer.INSTANCE)).deserialize(jsonParser);
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
                MemberProfile memberProfile = new MemberProfile(strDeserialize, strDeserialize2, boolDeserialize.booleanValue(), teamMemberStatusDeserialize, nameDeserialize, teamMembershipTypeDeserialize, str, str2, list, date, date2, date3, str3, bool, str4);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberProfile, memberProfile.toStringMultiline());
                return memberProfile;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
