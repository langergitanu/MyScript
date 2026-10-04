package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.InviteeInfo;
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
public class InviteeMembershipInfo extends MembershipInfo {

    @Nonnull
    protected final InviteeInfo invitee;

    @Nullable
    protected final UserInfo user;

    public InviteeMembershipInfo(@Nonnull AccessLevel accessLevel, @Nonnull InviteeInfo inviteeInfo, @Nullable List<MemberPermission> list, @Nullable String str, boolean z, @Nullable UserInfo userInfo) {
        super(accessLevel, list, str, z);
        if (inviteeInfo == null) {
            throw new IllegalArgumentException("Required value for 'invitee' is null");
        }
        this.invitee = inviteeInfo;
        this.user = userInfo;
    }

    public InviteeMembershipInfo(@Nonnull AccessLevel accessLevel, @Nonnull InviteeInfo inviteeInfo) {
        this(accessLevel, inviteeInfo, null, null, false, null);
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    @Nonnull
    public AccessLevel getAccessType() {
        return this.accessType;
    }

    @Nonnull
    public InviteeInfo getInvitee() {
        return this.invitee;
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

    @Nullable
    public UserInfo getUser() {
        return this.user;
    }

    public static Builder newBuilder(AccessLevel accessLevel, InviteeInfo inviteeInfo) {
        return new Builder(accessLevel, inviteeInfo);
    }

    public static class Builder extends MembershipInfo.Builder {
        protected final InviteeInfo invitee;
        protected UserInfo user;

        @Override // com.dropbox.core.v2.sharing.MembershipInfo.Builder
        public /* bridge */ /* synthetic */ MembershipInfo.Builder withPermissions(List list) {
            return withPermissions((List<MemberPermission>) list);
        }

        protected Builder(AccessLevel accessLevel, InviteeInfo inviteeInfo) {
            super(accessLevel);
            if (inviteeInfo == null) {
                throw new IllegalArgumentException("Required value for 'invitee' is null");
            }
            this.invitee = inviteeInfo;
            this.user = null;
        }

        public Builder withUser(UserInfo userInfo) {
            this.user = userInfo;
            return this;
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
        public InviteeMembershipInfo build() {
            return new InviteeMembershipInfo(this.accessType, this.invitee, this.permissions, this.initials, this.isInherited, this.user);
        }
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.invitee, this.user});
    }

    @Override // com.dropbox.core.p013v2.sharing.MembershipInfo
    public boolean equals(Object obj) {
        InviteeInfo inviteeInfo;
        InviteeInfo inviteeInfo2;
        UserInfo userInfo;
        UserInfo userInfo2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            InviteeMembershipInfo inviteeMembershipInfo = (InviteeMembershipInfo) obj;
            if ((this.accessType == inviteeMembershipInfo.accessType || this.accessType.equals(inviteeMembershipInfo.accessType)) && (((inviteeInfo = this.invitee) == (inviteeInfo2 = inviteeMembershipInfo.invitee) || inviteeInfo.equals(inviteeInfo2)) && ((this.permissions == inviteeMembershipInfo.permissions || (this.permissions != null && this.permissions.equals(inviteeMembershipInfo.permissions))) && ((this.initials == inviteeMembershipInfo.initials || (this.initials != null && this.initials.equals(inviteeMembershipInfo.initials))) && this.isInherited == inviteeMembershipInfo.isInherited && ((userInfo = this.user) == (userInfo2 = inviteeMembershipInfo.user) || (userInfo != null && userInfo.equals(userInfo2))))))) {
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

    static class Serializer extends StructSerializer<InviteeMembershipInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(InviteeMembershipInfo inviteeMembershipInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(inviteeMembershipInfo.accessType, jsonGenerator);
            jsonGenerator.writeFieldName("invitee");
            InviteeInfo.Serializer.INSTANCE.serialize(inviteeMembershipInfo.invitee, jsonGenerator);
            if (inviteeMembershipInfo.permissions != null) {
                jsonGenerator.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).serialize(inviteeMembershipInfo.permissions, jsonGenerator);
            }
            if (inviteeMembershipInfo.initials != null) {
                jsonGenerator.writeFieldName("initials");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(inviteeMembershipInfo.initials, jsonGenerator);
            }
            jsonGenerator.writeFieldName("is_inherited");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(inviteeMembershipInfo.isInherited), jsonGenerator);
            if (inviteeMembershipInfo.user != null) {
                jsonGenerator.writeFieldName("user");
                StoneSerializers.nullableStruct(UserInfo.Serializer.INSTANCE).serialize(inviteeMembershipInfo.user, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public InviteeMembershipInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                InviteeInfo inviteeInfoDeserialize = null;
                List list = null;
                String str = null;
                UserInfo userInfo = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("access_type".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("invitee".equals(currentName)) {
                        inviteeInfoDeserialize = InviteeInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("permissions".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("initials".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("is_inherited".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("user".equals(currentName)) {
                        userInfo = (UserInfo) StoneSerializers.nullableStruct(UserInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_type\" missing.");
                }
                if (inviteeInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"invitee\" missing.");
                }
                InviteeMembershipInfo inviteeMembershipInfo = new InviteeMembershipInfo(accessLevelDeserialize, inviteeInfoDeserialize, list, str, boolDeserialize.booleanValue(), userInfo);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(inviteeMembershipInfo, inviteeMembershipInfo.toStringMultiline());
                return inviteeMembershipInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
