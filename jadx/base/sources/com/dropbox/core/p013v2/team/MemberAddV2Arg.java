package com.dropbox.core.p013v2.team;

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
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class MemberAddV2Arg extends MemberAddArgBase {

    @Nullable
    protected final List<String> roleIds;

    public MemberAddV2Arg(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z, @Nullable Boolean bool, @Nullable List<String> list) {
        super(str, str2, str3, str4, str5, z, bool);
        if (list != null) {
            if (list.size() > 1) {
                throw new IllegalArgumentException("List 'roleIds' has more than 1 items");
            }
            for (String str6 : list) {
                if (str6 == null) {
                    throw new IllegalArgumentException("An item in list 'roleIds' is null");
                }
                if (str6.length() > 128) {
                    throw new IllegalArgumentException("Stringan item in list 'roleIds' is longer than 128");
                }
                if (!Pattern.matches("pid_dbtmr:.*", str6)) {
                    throw new IllegalArgumentException("Stringan item in list 'roleIds' does not match pattern");
                }
            }
        }
        this.roleIds = list;
    }

    public MemberAddV2Arg(@Nonnull String str) {
        this(str, null, null, null, null, true, null, null);
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

    @Nullable
    public List<String> getRoleIds() {
        return this.roleIds;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder extends MemberAddArgBase.Builder {
        protected List<String> roleIds;

        protected Builder(String str) {
            super(str);
            this.roleIds = null;
        }

        public Builder withRoleIds(List<String> list) {
            if (list != null) {
                if (list.size() > 1) {
                    throw new IllegalArgumentException("List 'roleIds' has more than 1 items");
                }
                for (String str : list) {
                    if (str == null) {
                        throw new IllegalArgumentException("An item in list 'roleIds' is null");
                    }
                    if (str.length() > 128) {
                        throw new IllegalArgumentException("Stringan item in list 'roleIds' is longer than 128");
                    }
                    if (!Pattern.matches("pid_dbtmr:.*", str)) {
                        throw new IllegalArgumentException("Stringan item in list 'roleIds' does not match pattern");
                    }
                }
            }
            this.roleIds = list;
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
        public MemberAddV2Arg build() {
            return new MemberAddV2Arg(this.memberEmail, this.memberGivenName, this.memberSurname, this.memberExternalId, this.memberPersistentId, this.sendWelcomeEmail, this.isDirectoryRestricted, this.roleIds);
        }
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.roleIds});
    }

    @Override // com.dropbox.core.p013v2.team.MemberAddArgBase
    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            MemberAddV2Arg memberAddV2Arg = (MemberAddV2Arg) obj;
            if ((this.memberEmail == memberAddV2Arg.memberEmail || this.memberEmail.equals(memberAddV2Arg.memberEmail)) && ((this.memberGivenName == memberAddV2Arg.memberGivenName || (this.memberGivenName != null && this.memberGivenName.equals(memberAddV2Arg.memberGivenName))) && ((this.memberSurname == memberAddV2Arg.memberSurname || (this.memberSurname != null && this.memberSurname.equals(memberAddV2Arg.memberSurname))) && ((this.memberExternalId == memberAddV2Arg.memberExternalId || (this.memberExternalId != null && this.memberExternalId.equals(memberAddV2Arg.memberExternalId))) && ((this.memberPersistentId == memberAddV2Arg.memberPersistentId || (this.memberPersistentId != null && this.memberPersistentId.equals(memberAddV2Arg.memberPersistentId))) && this.sendWelcomeEmail == memberAddV2Arg.sendWelcomeEmail && ((this.isDirectoryRestricted == memberAddV2Arg.isDirectoryRestricted || (this.isDirectoryRestricted != null && this.isDirectoryRestricted.equals(memberAddV2Arg.isDirectoryRestricted))) && ((list = this.roleIds) == (list2 = memberAddV2Arg.roleIds) || (list != null && list.equals(list2))))))))) {
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

    static class Serializer extends StructSerializer<MemberAddV2Arg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberAddV2Arg memberAddV2Arg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("member_email");
            StoneSerializers.string().serialize(memberAddV2Arg.memberEmail, jsonGenerator);
            if (memberAddV2Arg.memberGivenName != null) {
                jsonGenerator.writeFieldName("member_given_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddV2Arg.memberGivenName, jsonGenerator);
            }
            if (memberAddV2Arg.memberSurname != null) {
                jsonGenerator.writeFieldName("member_surname");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddV2Arg.memberSurname, jsonGenerator);
            }
            if (memberAddV2Arg.memberExternalId != null) {
                jsonGenerator.writeFieldName("member_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddV2Arg.memberExternalId, jsonGenerator);
            }
            if (memberAddV2Arg.memberPersistentId != null) {
                jsonGenerator.writeFieldName("member_persistent_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddV2Arg.memberPersistentId, jsonGenerator);
            }
            jsonGenerator.writeFieldName("send_welcome_email");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(memberAddV2Arg.sendWelcomeEmail), jsonGenerator);
            if (memberAddV2Arg.isDirectoryRestricted != null) {
                jsonGenerator.writeFieldName("is_directory_restricted");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(memberAddV2Arg.isDirectoryRestricted, jsonGenerator);
            }
            if (memberAddV2Arg.roleIds != null) {
                jsonGenerator.writeFieldName("role_ids");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(memberAddV2Arg.roleIds, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberAddV2Arg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                List list = null;
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
                    } else if ("role_ids".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member_email\" missing.");
                }
                MemberAddV2Arg memberAddV2Arg = new MemberAddV2Arg(strDeserialize, str, str2, str3, str4, boolDeserialize.booleanValue(), bool, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberAddV2Arg, memberAddV2Arg.toStringMultiline());
                return memberAddV2Arg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
