package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.AdminTier;
import com.dropbox.core.p013v2.team.MemberAddArgBase;
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
public class MemberAddArg extends MemberAddArgBase {

    @Nonnull
    protected final AdminTier role;

    public MemberAddArg(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z, @Nullable Boolean bool, @Nonnull AdminTier adminTier) {
        super(str, str2, str3, str4, str5, z, bool);
        if (adminTier == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = adminTier;
    }

    public MemberAddArg(@Nonnull String str) {
        this(str, null, null, null, null, true, null, AdminTier.MEMBER_ONLY);
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    @Nonnull
    public String getMemberEmail() {
        return this.memberEmail;
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    @Nullable
    public String getMemberGivenName() {
        return this.memberGivenName;
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    @Nullable
    public String getMemberSurname() {
        return this.memberSurname;
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    @Nullable
    public String getMemberExternalId() {
        return this.memberExternalId;
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    @Nullable
    public String getMemberPersistentId() {
        return this.memberPersistentId;
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    public boolean getSendWelcomeEmail() {
        return this.sendWelcomeEmail;
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    @Nullable
    public Boolean getIsDirectoryRestricted() {
        return this.isDirectoryRestricted;
    }

    @Nonnull
    public AdminTier getRole() {
        return this.role;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder extends MemberAddArgBase.Builder {
        protected AdminTier role;

        protected Builder(String str) {
            super(str);
            this.role = AdminTier.MEMBER_ONLY;
        }

        public Builder withRole(AdminTier adminTier) {
            if (adminTier != null) {
                this.role = adminTier;
                return this;
            }
            this.role = AdminTier.MEMBER_ONLY;
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberAddArgBase.Builder
        public Builder withMemberGivenName(String str) {
            super.withMemberGivenName(str);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberAddArgBase.Builder
        public Builder withMemberSurname(String str) {
            super.withMemberSurname(str);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberAddArgBase.Builder
        public Builder withMemberExternalId(String str) {
            super.withMemberExternalId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberAddArgBase.Builder
        public Builder withMemberPersistentId(String str) {
            super.withMemberPersistentId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberAddArgBase.Builder
        public Builder withSendWelcomeEmail(Boolean bool) {
            super.withSendWelcomeEmail(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberAddArgBase.Builder
        public Builder withIsDirectoryRestricted(Boolean bool) {
            super.withIsDirectoryRestricted(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.team.MemberAddArgBase.Builder
        public MemberAddArg build() {
            return new MemberAddArg(this.memberEmail, this.memberGivenName, this.memberSurname, this.memberExternalId, this.memberPersistentId, this.sendWelcomeEmail, this.isDirectoryRestricted, this.role);
        }
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.role});
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    public boolean equals(Object obj) {
        AdminTier adminTier;
        AdminTier adminTier2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            MemberAddArg memberAddArg = (MemberAddArg) obj;
            if ((this.memberEmail == memberAddArg.memberEmail || this.memberEmail.equals(memberAddArg.memberEmail)) && ((this.memberGivenName == memberAddArg.memberGivenName || (this.memberGivenName != null && this.memberGivenName.equals(memberAddArg.memberGivenName))) && ((this.memberSurname == memberAddArg.memberSurname || (this.memberSurname != null && this.memberSurname.equals(memberAddArg.memberSurname))) && ((this.memberExternalId == memberAddArg.memberExternalId || (this.memberExternalId != null && this.memberExternalId.equals(memberAddArg.memberExternalId))) && ((this.memberPersistentId == memberAddArg.memberPersistentId || (this.memberPersistentId != null && this.memberPersistentId.equals(memberAddArg.memberPersistentId))) && this.sendWelcomeEmail == memberAddArg.sendWelcomeEmail && ((this.isDirectoryRestricted == memberAddArg.isDirectoryRestricted || (this.isDirectoryRestricted != null && this.isDirectoryRestricted.equals(memberAddArg.isDirectoryRestricted))) && ((adminTier = this.role) == (adminTier2 = memberAddArg.role) || adminTier.equals(adminTier2)))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberAddArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberAddArg memberAddArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("member_email");
            StoneSerializers.string().serialize(memberAddArg.memberEmail, jsonGenerator);
            if (memberAddArg.memberGivenName != null) {
                jsonGenerator.writeFieldName("member_given_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddArg.memberGivenName, jsonGenerator);
            }
            if (memberAddArg.memberSurname != null) {
                jsonGenerator.writeFieldName("member_surname");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddArg.memberSurname, jsonGenerator);
            }
            if (memberAddArg.memberExternalId != null) {
                jsonGenerator.writeFieldName("member_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddArg.memberExternalId, jsonGenerator);
            }
            if (memberAddArg.memberPersistentId != null) {
                jsonGenerator.writeFieldName("member_persistent_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddArg.memberPersistentId, jsonGenerator);
            }
            jsonGenerator.writeFieldName("send_welcome_email");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(memberAddArg.sendWelcomeEmail), jsonGenerator);
            if (memberAddArg.isDirectoryRestricted != null) {
                jsonGenerator.writeFieldName("is_directory_restricted");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(memberAddArg.isDirectoryRestricted, jsonGenerator);
            }
            jsonGenerator.writeFieldName("role");
            AdminTier.Serializer.INSTANCE.serialize(memberAddArg.role, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberAddArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = true;
                String strDeserialize = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                Boolean bool = null;
                AdminTier adminTierDeserialize = AdminTier.MEMBER_ONLY;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("member_email".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("member_given_name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("member_surname".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("member_external_id".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("member_persistent_id".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("send_welcome_email".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("is_directory_restricted".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("role".equals(currentName)) {
                        adminTierDeserialize = AdminTier.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member_email\" missing.");
                }
                MemberAddArg memberAddArg = new MemberAddArg(strDeserialize, str, str2, str3, str4, boolDeserialize.booleanValue(), bool, adminTierDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberAddArg, memberAddArg.toStringMultiline());
                return memberAddArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
