package com.dropbox.core.p013v2.users;

import com.dropbox.core.p013v2.common.RootInfo;
import com.dropbox.core.p013v2.users.FullTeam;
import com.dropbox.core.p013v2.users.Name;
import com.dropbox.core.p013v2.userscommon.AccountType;
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
public class FullAccount extends Account {

    @Nonnull
    protected final AccountType accountType;

    @Nullable
    protected final String country;
    protected final boolean isPaired;

    @Nonnull
    protected final String locale;

    @Nonnull
    protected final String referralLink;

    @Nonnull
    protected final RootInfo rootInfo;

    @Nullable
    protected final FullTeam team;

    @Nullable
    protected final String teamMemberId;

    public FullAccount(@Nonnull String str, @Nonnull Name name, @Nonnull String str2, boolean z, boolean z2, @Nonnull String str3, @Nonnull String str4, boolean z3, @Nonnull AccountType accountType, @Nonnull RootInfo rootInfo, @Nullable String str5, @Nullable String str6, @Nullable FullTeam fullTeam, @Nullable String str7) {
        super(str, name, str2, z, z2, str5);
        if (str6 != null) {
            if (str6.length() < 2) {
                throw new IllegalArgumentException("String 'country' is shorter than 2");
            }
            if (str6.length() > 2) {
                throw new IllegalArgumentException("String 'country' is longer than 2");
            }
        }
        this.country = str6;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'locale' is null");
        }
        if (str3.length() < 2) {
            throw new IllegalArgumentException("String 'locale' is shorter than 2");
        }
        this.locale = str3;
        if (str4 == null) {
            throw new IllegalArgumentException("Required value for 'referralLink' is null");
        }
        this.referralLink = str4;
        this.team = fullTeam;
        this.teamMemberId = str7;
        this.isPaired = z3;
        if (accountType == null) {
            throw new IllegalArgumentException("Required value for 'accountType' is null");
        }
        this.accountType = accountType;
        if (rootInfo == null) {
            throw new IllegalArgumentException("Required value for 'rootInfo' is null");
        }
        this.rootInfo = rootInfo;
    }

    public FullAccount(@Nonnull String str, @Nonnull Name name, @Nonnull String str2, boolean z, boolean z2, @Nonnull String str3, @Nonnull String str4, boolean z3, @Nonnull AccountType accountType, @Nonnull RootInfo rootInfo) {
        this(str, name, str2, z, z2, str3, str4, z3, accountType, rootInfo, null, null, null, null);
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

    @Nonnull
    public String getLocale() {
        return this.locale;
    }

    @Nonnull
    public String getReferralLink() {
        return this.referralLink;
    }

    public boolean getIsPaired() {
        return this.isPaired;
    }

    @Nonnull
    public AccountType getAccountType() {
        return this.accountType;
    }

    @Nonnull
    public RootInfo getRootInfo() {
        return this.rootInfo;
    }

    @Override // com.dropbox.core.p013v2.users.Account
    @Nullable
    public String getProfilePhotoUrl() {
        return this.profilePhotoUrl;
    }

    @Nullable
    public String getCountry() {
        return this.country;
    }

    @Nullable
    public FullTeam getTeam() {
        return this.team;
    }

    @Nullable
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    public static Builder newBuilder(String str, Name name, String str2, boolean z, boolean z2, String str3, String str4, boolean z3, AccountType accountType, RootInfo rootInfo) {
        return new Builder(str, name, str2, z, z2, str3, str4, z3, accountType, rootInfo);
    }

    public static class Builder {
        protected final String accountId;
        protected final AccountType accountType;
        protected String country;
        protected final boolean disabled;
        protected final String email;
        protected final boolean emailVerified;
        protected final boolean isPaired;
        protected final String locale;
        protected final Name name;
        protected String profilePhotoUrl;
        protected final String referralLink;
        protected final RootInfo rootInfo;
        protected FullTeam team;
        protected String teamMemberId;

        protected Builder(String str, Name name, String str2, boolean z, boolean z2, String str3, String str4, boolean z3, AccountType accountType, RootInfo rootInfo) {
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
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'locale' is null");
            }
            if (str3.length() < 2) {
                throw new IllegalArgumentException("String 'locale' is shorter than 2");
            }
            this.locale = str3;
            if (str4 == null) {
                throw new IllegalArgumentException("Required value for 'referralLink' is null");
            }
            this.referralLink = str4;
            this.isPaired = z3;
            if (accountType == null) {
                throw new IllegalArgumentException("Required value for 'accountType' is null");
            }
            this.accountType = accountType;
            if (rootInfo == null) {
                throw new IllegalArgumentException("Required value for 'rootInfo' is null");
            }
            this.rootInfo = rootInfo;
            this.profilePhotoUrl = null;
            this.country = null;
            this.team = null;
            this.teamMemberId = null;
        }

        public Builder withProfilePhotoUrl(String str) {
            this.profilePhotoUrl = str;
            return this;
        }

        public Builder withCountry(String str) {
            if (str != null) {
                if (str.length() < 2) {
                    throw new IllegalArgumentException("String 'country' is shorter than 2");
                }
                if (str.length() > 2) {
                    throw new IllegalArgumentException("String 'country' is longer than 2");
                }
            }
            this.country = str;
            return this;
        }

        public Builder withTeam(FullTeam fullTeam) {
            this.team = fullTeam;
            return this;
        }

        public Builder withTeamMemberId(String str) {
            this.teamMemberId = str;
            return this;
        }

        public FullAccount build() {
            return new FullAccount(this.accountId, this.name, this.email, this.emailVerified, this.disabled, this.locale, this.referralLink, this.isPaired, this.accountType, this.rootInfo, this.profilePhotoUrl, this.country, this.team, this.teamMemberId);
        }
    }

    @Override // com.dropbox.core.p013v2.users.Account
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.country, this.locale, this.referralLink, this.team, this.teamMemberId, Boolean.valueOf(this.isPaired), this.accountType, this.rootInfo});
    }

    @Override // com.dropbox.core.p013v2.users.Account
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        AccountType accountType;
        AccountType accountType2;
        RootInfo rootInfo;
        RootInfo rootInfo2;
        String str5;
        String str6;
        FullTeam fullTeam;
        FullTeam fullTeam2;
        String str7;
        String str8;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            FullAccount fullAccount = (FullAccount) obj;
            if ((this.accountId == fullAccount.accountId || this.accountId.equals(fullAccount.accountId)) && ((this.name == fullAccount.name || this.name.equals(fullAccount.name)) && ((this.email == fullAccount.email || this.email.equals(fullAccount.email)) && this.emailVerified == fullAccount.emailVerified && this.disabled == fullAccount.disabled && (((str = this.locale) == (str2 = fullAccount.locale) || str.equals(str2)) && (((str3 = this.referralLink) == (str4 = fullAccount.referralLink) || str3.equals(str4)) && this.isPaired == fullAccount.isPaired && (((accountType = this.accountType) == (accountType2 = fullAccount.accountType) || accountType.equals(accountType2)) && (((rootInfo = this.rootInfo) == (rootInfo2 = fullAccount.rootInfo) || rootInfo.equals(rootInfo2)) && ((this.profilePhotoUrl == fullAccount.profilePhotoUrl || (this.profilePhotoUrl != null && this.profilePhotoUrl.equals(fullAccount.profilePhotoUrl))) && (((str5 = this.country) == (str6 = fullAccount.country) || (str5 != null && str5.equals(str6))) && (((fullTeam = this.team) == (fullTeam2 = fullAccount.team) || (fullTeam != null && fullTeam.equals(fullTeam2))) && ((str7 = this.teamMemberId) == (str8 = fullAccount.teamMemberId) || (str7 != null && str7.equals(str8))))))))))))) {
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

    static class Serializer extends StructSerializer<FullAccount> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FullAccount fullAccount, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("account_id");
            StoneSerializers.string().serialize(fullAccount.accountId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            Name.Serializer.INSTANCE.serialize(fullAccount.name, jsonGenerator);
            jsonGenerator.writeFieldName("email");
            StoneSerializers.string().serialize(fullAccount.email, jsonGenerator);
            jsonGenerator.writeFieldName("email_verified");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(fullAccount.emailVerified), jsonGenerator);
            jsonGenerator.writeFieldName("disabled");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(fullAccount.disabled), jsonGenerator);
            jsonGenerator.writeFieldName("locale");
            StoneSerializers.string().serialize(fullAccount.locale, jsonGenerator);
            jsonGenerator.writeFieldName("referral_link");
            StoneSerializers.string().serialize(fullAccount.referralLink, jsonGenerator);
            jsonGenerator.writeFieldName("is_paired");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(fullAccount.isPaired), jsonGenerator);
            jsonGenerator.writeFieldName("account_type");
            AccountType.Serializer.INSTANCE.serialize(fullAccount.accountType, jsonGenerator);
            jsonGenerator.writeFieldName("root_info");
            RootInfo.Serializer.INSTANCE.serialize(fullAccount.rootInfo, jsonGenerator);
            if (fullAccount.profilePhotoUrl != null) {
                jsonGenerator.writeFieldName("profile_photo_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fullAccount.profilePhotoUrl, jsonGenerator);
            }
            if (fullAccount.country != null) {
                jsonGenerator.writeFieldName("country");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fullAccount.country, jsonGenerator);
            }
            if (fullAccount.team != null) {
                jsonGenerator.writeFieldName("team");
                StoneSerializers.nullableStruct(FullTeam.Serializer.INSTANCE).serialize(fullAccount.team, jsonGenerator);
            }
            if (fullAccount.teamMemberId != null) {
                jsonGenerator.writeFieldName("team_member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fullAccount.teamMemberId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FullAccount deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String strDeserialize3 = null;
                String strDeserialize4 = null;
                AccountType accountTypeDeserialize = null;
                RootInfo rootInfoDeserialize = null;
                String str = null;
                String str2 = null;
                FullTeam fullTeam = null;
                String str3 = null;
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
                    } else if ("locale".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("referral_link".equals(currentName)) {
                        strDeserialize4 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("is_paired".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("account_type".equals(currentName)) {
                        accountTypeDeserialize = AccountType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("root_info".equals(currentName)) {
                        rootInfoDeserialize = RootInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("profile_photo_url".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("country".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("team".equals(currentName)) {
                        fullTeam = (FullTeam) StoneSerializers.nullableStruct(FullTeam.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("team_member_id".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
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
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"locale\" missing.");
                }
                if (strDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"referral_link\" missing.");
                }
                if (boolDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_paired\" missing.");
                }
                if (accountTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"account_type\" missing.");
                }
                if (rootInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"root_info\" missing.");
                }
                FullAccount fullAccount = new FullAccount(strDeserialize, nameDeserialize, strDeserialize2, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), strDeserialize3, strDeserialize4, boolDeserialize3.booleanValue(), accountTypeDeserialize, rootInfoDeserialize, str, str2, fullTeam, str3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fullAccount, fullAccount.toStringMultiline());
                return fullAccount;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
