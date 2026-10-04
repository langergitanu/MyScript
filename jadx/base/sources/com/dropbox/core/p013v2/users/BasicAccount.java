package com.dropbox.core.p013v2.users;

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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class BasicAccount extends Account {
    protected final boolean isTeammate;

    @Nullable
    protected final String teamMemberId;

    public BasicAccount(@Nonnull String str, @Nonnull Name name, @Nonnull String str2, boolean z, boolean z2, boolean z3, @Nullable String str3, @Nullable String str4) {
        super(str, name, str2, z, z2, str3);
        this.isTeammate = z3;
        this.teamMemberId = str4;
    }

    public BasicAccount(@Nonnull String str, @Nonnull Name name, @Nonnull String str2, boolean z, boolean z2, boolean z3) {
        this(str, name, str2, z, z2, z3, null, null);
    }

    @Override // com.dropbox.core.p013v2.users.Account
    @Nonnull
    public String getAccountId() {
        return this.accountId;
    }

    @Override // com.dropbox.core.p013v2.users.Account
    @Nonnull
    public Name getName() {
        return this.name;
    }

    @Override // com.dropbox.core.p013v2.users.Account
    @Nonnull
    public String getEmail() {
        return this.email;
    }

    @Override // com.dropbox.core.p013v2.users.Account
    public boolean getEmailVerified() {
        return this.emailVerified;
    }

    @Override // com.dropbox.core.p013v2.users.Account
    public boolean getDisabled() {
        return this.disabled;
    }

    public boolean getIsTeammate() {
        return this.isTeammate;
    }

    @Override // com.dropbox.core.p013v2.users.Account
    @Nullable
    public String getProfilePhotoUrl() {
        return this.profilePhotoUrl;
    }

    @Nullable
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    public static Builder newBuilder(String str, Name name, String str2, boolean z, boolean z2, boolean z3) {
        return new Builder(str, name, str2, z, z2, z3);
    }

    public static class Builder {
        protected final String accountId;
        protected final boolean disabled;
        protected final String email;
        protected final boolean emailVerified;
        protected final boolean isTeammate;
        protected final Name name;
        protected String profilePhotoUrl;
        protected String teamMemberId;

        protected Builder(String str, Name name, String str2, boolean z, boolean z2, boolean z3) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'accountId' is null");
            }
            if (str.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (str.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
            }
            this.accountId = str;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'email' is null");
            }
            this.email = str2;
            this.emailVerified = z;
            this.disabled = z2;
            this.isTeammate = z3;
            this.profilePhotoUrl = null;
            this.teamMemberId = null;
        }

        public Builder withProfilePhotoUrl(String str) {
            this.profilePhotoUrl = str;
            return this;
        }

        public Builder withTeamMemberId(String str) {
            this.teamMemberId = str;
            return this;
        }

        public BasicAccount build() {
            return new BasicAccount(this.accountId, this.name, this.email, this.emailVerified, this.disabled, this.isTeammate, this.profilePhotoUrl, this.teamMemberId);
        }
    }

    @Override // com.dropbox.core.p013v2.users.Account
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{Boolean.valueOf(this.isTeammate), this.teamMemberId});
    }

    @Override // com.dropbox.core.p013v2.users.Account
    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            BasicAccount basicAccount = (BasicAccount) obj;
            if ((this.accountId == basicAccount.accountId || this.accountId.equals(basicAccount.accountId)) && ((this.name == basicAccount.name || this.name.equals(basicAccount.name)) && ((this.email == basicAccount.email || this.email.equals(basicAccount.email)) && this.emailVerified == basicAccount.emailVerified && this.disabled == basicAccount.disabled && this.isTeammate == basicAccount.isTeammate && ((this.profilePhotoUrl == basicAccount.profilePhotoUrl || (this.profilePhotoUrl != null && this.profilePhotoUrl.equals(basicAccount.profilePhotoUrl))) && ((str = this.teamMemberId) == (str2 = basicAccount.teamMemberId) || (str != null && str.equals(str2))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.users.Account
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.users.Account
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<BasicAccount> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(BasicAccount basicAccount, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("account_id");
            StoneSerializers.string().serialize(basicAccount.accountId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            Name.Serializer.INSTANCE.serialize(basicAccount.name, jsonGenerator);
            jsonGenerator.writeFieldName("email");
            StoneSerializers.string().serialize(basicAccount.email, jsonGenerator);
            jsonGenerator.writeFieldName("email_verified");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(basicAccount.emailVerified), jsonGenerator);
            jsonGenerator.writeFieldName("disabled");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(basicAccount.disabled), jsonGenerator);
            jsonGenerator.writeFieldName("is_teammate");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(basicAccount.isTeammate), jsonGenerator);
            if (basicAccount.profilePhotoUrl != null) {
                jsonGenerator.writeFieldName("profile_photo_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(basicAccount.profilePhotoUrl, jsonGenerator);
            }
            if (basicAccount.teamMemberId != null) {
                jsonGenerator.writeFieldName("team_member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(basicAccount.teamMemberId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public BasicAccount deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize2 = null;
                Boolean boolDeserialize3 = null;
                String strDeserialize = null;
                Name nameDeserialize = null;
                String strDeserialize2 = null;
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("account_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        nameDeserialize = Name.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("email".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("email_verified".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("disabled".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("is_teammate".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("profile_photo_url".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("team_member_id".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"account_id\" missing.");
                }
                if (nameDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"email\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"email_verified\" missing.");
                }
                if (boolDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"disabled\" missing.");
                }
                if (boolDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_teammate\" missing.");
                }
                BasicAccount basicAccount = new BasicAccount(strDeserialize, nameDeserialize, strDeserialize2, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), boolDeserialize3.booleanValue(), str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(basicAccount, basicAccount.toStringMultiline());
                return basicAccount;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
