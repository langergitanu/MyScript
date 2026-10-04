package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.seenstate.PlatformType;
import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.MemberPermission;
import com.dropbox.core.p013v2.sharing.MembershipInfo;
import com.dropbox.core.p013v2.sharing.UserInfo;
import com.dropbox.core.p013v2.sharing.UserMembershipInfo;
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
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class UserFileMembershipInfo extends UserMembershipInfo {

    @Nullable
    protected final PlatformType platformType;

    @Nullable
    protected final Date timeLastSeen;

    public UserFileMembershipInfo(@Nonnull AccessLevel accessLevel, @Nonnull UserInfo userInfo, @Nullable List<MemberPermission> list, @Nullable String str, boolean z, @Nullable Date date, @Nullable PlatformType platformType) {
        super(accessLevel, userInfo, list, str, z);
        this.timeLastSeen = LangUtil.truncateMillis(date);
        this.platformType = platformType;
    }

    public UserFileMembershipInfo(@Nonnull AccessLevel accessLevel, @Nonnull UserInfo userInfo) {
        this(accessLevel, userInfo, null, null, false, null, null);
    }

    @Override // com.dropbox.core.p013v2.sharing.UserMembershipInfo, com.dropbox.core.p013v2.sharing.MembershipInfo
    @Nonnull
    public AccessLevel getAccessType() {
        return this.accessType;
    }

    @Override // com.dropbox.core.p013v2.sharing.UserMembershipInfo
    @Nonnull
    public UserInfo getUser() {
        return this.user;
    }

    @Override // com.dropbox.core.p013v2.sharing.UserMembershipInfo, com.dropbox.core.p013v2.sharing.MembershipInfo
    @Nullable
    public List<MemberPermission> getPermissions() {
        return this.permissions;
    }

    @Override // com.dropbox.core.p013v2.sharing.UserMembershipInfo, com.dropbox.core.p013v2.sharing.MembershipInfo
    @Nullable
    public String getInitials() {
        return this.initials;
    }

    @Override // com.dropbox.core.p013v2.sharing.UserMembershipInfo, com.dropbox.core.p013v2.sharing.MembershipInfo
    public boolean getIsInherited() {
        return this.isInherited;
    }

    @Nullable
    public Date getTimeLastSeen() {
        return this.timeLastSeen;
    }

    @Nullable
    public PlatformType getPlatformType() {
        return this.platformType;
    }

    public static Builder newBuilder(AccessLevel accessLevel, UserInfo userInfo) {
        return new Builder(accessLevel, userInfo);
    }

    public static class Builder extends UserMembershipInfo.Builder {
        protected PlatformType platformType;
        protected Date timeLastSeen;

        @Override // com.dropbox.core.v2.sharing.UserMembershipInfo.Builder, com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public /* bridge */ /* synthetic */ MembershipInfo.Builder withPermissions(List list) {
            return withPermissions((List<MemberPermission>) list);
        }

        @Override // com.dropbox.core.v2.sharing.UserMembershipInfo.Builder, com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public /* bridge */ /* synthetic */ UserMembershipInfo.Builder withPermissions(List list) {
            return withPermissions((List<MemberPermission>) list);
        }

        protected Builder(AccessLevel accessLevel, UserInfo userInfo) {
            super(accessLevel, userInfo);
            this.timeLastSeen = null;
            this.platformType = null;
        }

        public Builder withTimeLastSeen(Date date) {
            this.timeLastSeen = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withPlatformType(PlatformType platformType) {
            this.platformType = platformType;
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.UserMembershipInfo.Builder, com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public Builder withPermissions(List<MemberPermission> list) {
            super.withPermissions(list);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.UserMembershipInfo.Builder, com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public Builder withInitials(String str) {
            super.withInitials(str);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.UserMembershipInfo.Builder, com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public Builder withIsInherited(Boolean bool) {
            super.withIsInherited(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.UserMembershipInfo.Builder, com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public UserFileMembershipInfo build() {
            return new UserFileMembershipInfo(this.accessType, this.user, this.permissions, this.initials, this.isInherited, this.timeLastSeen, this.platformType);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.UserMembershipInfo, com.dropbox.core.p013v2.sharing.MembershipInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.timeLastSeen, this.platformType});
    }

    @Override // com.dropbox.core.p013v2.sharing.UserMembershipInfo, com.dropbox.core.p013v2.sharing.MembershipInfo
    public boolean equals(Object obj) {
        Date date;
        Date date2;
        PlatformType platformType;
        PlatformType platformType2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            UserFileMembershipInfo userFileMembershipInfo = (UserFileMembershipInfo) obj;
            if ((this.accessType == userFileMembershipInfo.accessType || this.accessType.equals(userFileMembershipInfo.accessType)) && ((this.user == userFileMembershipInfo.user || this.user.equals(userFileMembershipInfo.user)) && ((this.permissions == userFileMembershipInfo.permissions || (this.permissions != null && this.permissions.equals(userFileMembershipInfo.permissions))) && ((this.initials == userFileMembershipInfo.initials || (this.initials != null && this.initials.equals(userFileMembershipInfo.initials))) && this.isInherited == userFileMembershipInfo.isInherited && (((date = this.timeLastSeen) == (date2 = userFileMembershipInfo.timeLastSeen) || (date != null && date.equals(date2))) && ((platformType = this.platformType) == (platformType2 = userFileMembershipInfo.platformType) || (platformType != null && platformType.equals(platformType2)))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.sharing.UserMembershipInfo, com.dropbox.core.p013v2.sharing.MembershipInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.UserMembershipInfo, com.dropbox.core.p013v2.sharing.MembershipInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserFileMembershipInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserFileMembershipInfo userFileMembershipInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(userFileMembershipInfo.accessType, jsonGenerator);
            jsonGenerator.writeFieldName("user");
            UserInfo.Serializer.INSTANCE.serialize(userFileMembershipInfo.user, jsonGenerator);
            if (userFileMembershipInfo.permissions != null) {
                jsonGenerator.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).serialize(userFileMembershipInfo.permissions, jsonGenerator);
            }
            if (userFileMembershipInfo.initials != null) {
                jsonGenerator.writeFieldName("initials");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userFileMembershipInfo.initials, jsonGenerator);
            }
            jsonGenerator.writeFieldName("is_inherited");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(userFileMembershipInfo.isInherited), jsonGenerator);
            if (userFileMembershipInfo.timeLastSeen != null) {
                jsonGenerator.writeFieldName("time_last_seen");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(userFileMembershipInfo.timeLastSeen, jsonGenerator);
            }
            if (userFileMembershipInfo.platformType != null) {
                jsonGenerator.writeFieldName("platform_type");
                StoneSerializers.nullable(PlatformType.Serializer.INSTANCE).serialize(userFileMembershipInfo.platformType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserFileMembershipInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                UserInfo userInfoDeserialize = null;
                List list = null;
                String str = null;
                Date date = null;
                PlatformType platformType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("access_type".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("user".equals(currentName)) {
                        userInfoDeserialize = UserInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("permissions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("initials".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("is_inherited".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("time_last_seen".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("platform_type".equals(currentName)) {
                        platformType = (PlatformType) StoneSerializers.nullable(PlatformType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_type\" missing.");
                }
                if (userInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                UserFileMembershipInfo userFileMembershipInfo = new UserFileMembershipInfo(accessLevelDeserialize, userInfoDeserialize, list, str, boolDeserialize.booleanValue(), date, platformType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userFileMembershipInfo, userFileMembershipInfo.toStringMultiline());
                return userFileMembershipInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
