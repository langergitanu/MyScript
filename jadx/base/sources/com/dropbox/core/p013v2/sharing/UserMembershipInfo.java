package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.MemberPermission;
import com.dropbox.core.p013v2.sharing.MembershipInfo;
import com.dropbox.core.p013v2.sharing.UserInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class UserMembershipInfo extends MembershipInfo {

    @Nonnull
    protected final UserInfo user;

    public UserMembershipInfo(@Nonnull AccessLevel accessLevel, @Nonnull UserInfo userInfo, @Nullable List<MemberPermission> list, @Nullable String str, boolean z) {
        super(accessLevel, list, str, z);
        if (userInfo == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userInfo;
    }

    public UserMembershipInfo(@Nonnull AccessLevel accessLevel, @Nonnull UserInfo userInfo) {
        this(accessLevel, userInfo, null, null, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    @Nonnull
    public AccessLevel getAccessType() {
        return this.accessType;
    }

    @Nonnull
    public UserInfo getUser() {
        return this.user;
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    @Nullable
    public List<MemberPermission> getPermissions() {
        return this.permissions;
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    @Nullable
    public String getInitials() {
        return this.initials;
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public boolean getIsInherited() {
        return this.isInherited;
    }

    public static Builder newBuilder(AccessLevel accessLevel, UserInfo userInfo) {
        return new Builder(accessLevel, userInfo);
    }

    public static class Builder extends MembershipInfo.Builder {
        protected final UserInfo user;

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public /* bridge */ /* synthetic */ MembershipInfo.Builder withPermissions(List list) {
            return withPermissions((List<MemberPermission>) list);
        }

        protected Builder(AccessLevel accessLevel, UserInfo userInfo) {
            super(accessLevel);
            if (userInfo == null) {
                throw new IllegalArgumentException("Required value for 'user' is null");
            }
            this.user = userInfo;
        }

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public Builder withPermissions(List<MemberPermission> list) {
            super.withPermissions(list);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public Builder withInitials(String str) {
            super.withInitials(str);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public Builder withIsInherited(Boolean bool) {
            super.withIsInherited(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public UserMembershipInfo build() {
            return new UserMembershipInfo(this.accessType, this.user, this.permissions, this.initials, this.isInherited);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.user});
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public boolean equals(Object obj) {
        UserInfo userInfo;
        UserInfo userInfo2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            UserMembershipInfo userMembershipInfo = (UserMembershipInfo) obj;
            if ((this.accessType == userMembershipInfo.accessType || this.accessType.equals(userMembershipInfo.accessType)) && (((userInfo = this.user) == (userInfo2 = userMembershipInfo.user) || userInfo.equals(userInfo2)) && ((this.permissions == userMembershipInfo.permissions || (this.permissions != null && this.permissions.equals(userMembershipInfo.permissions))) && ((this.initials == userMembershipInfo.initials || (this.initials != null && this.initials.equals(userMembershipInfo.initials))) && this.isInherited == userMembershipInfo.isInherited)))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserMembershipInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserMembershipInfo userMembershipInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(userMembershipInfo.accessType, jsonGenerator);
            jsonGenerator.writeFieldName("user");
            UserInfo.Serializer.INSTANCE.serialize(userMembershipInfo.user, jsonGenerator);
            if (userMembershipInfo.permissions != null) {
                jsonGenerator.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).serialize(userMembershipInfo.permissions, jsonGenerator);
            }
            if (userMembershipInfo.initials != null) {
                jsonGenerator.writeFieldName("initials");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userMembershipInfo.initials, jsonGenerator);
            }
            jsonGenerator.writeFieldName("is_inherited");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(userMembershipInfo.isInherited), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserMembershipInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                UserMembershipInfo userMembershipInfo = new UserMembershipInfo(accessLevelDeserialize, userInfoDeserialize, list, str, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userMembershipInfo, userMembershipInfo.toStringMultiline());
                return userMembershipInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
