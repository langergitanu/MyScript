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
public class Account {

    @Nonnull
    protected final String accountId;
    protected final boolean disabled;

    @Nonnull
    protected final String email;
    protected final boolean emailVerified;

    @Nonnull
    protected final Name name;

    @Nullable
    protected final String profilePhotoUrl;

    public Account(@Nonnull String str, @Nonnull Name name, @Nonnull String str2, boolean z, boolean z2, @Nullable String str3) {
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
        this.profilePhotoUrl = str3;
        this.disabled = z2;
    }

    public Account(@Nonnull String str, @Nonnull Name name, @Nonnull String str2, boolean z, boolean z2) {
        this(str, name, str2, z, z2, null);
    }

    @Nonnull
    public String getAccountId() {
        return this.accountId;
    }

    @Nonnull
    public Name getName() {
        return this.name;
    }

    @Nonnull
    public String getEmail() {
        return this.email;
    }

    public boolean getEmailVerified() {
        return this.emailVerified;
    }

    public boolean getDisabled() {
        return this.disabled;
    }

    @Nullable
    public String getProfilePhotoUrl() {
        return this.profilePhotoUrl;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accountId, this.name, this.email, Boolean.valueOf(this.emailVerified), this.profilePhotoUrl, Boolean.valueOf(this.disabled)});
    }

    public boolean equals(Object obj) {
        Account account;
        String str;
        String str2;
        Name name;
        Name name2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.accountId) == (str2 = (account = (Account) obj).accountId) || str.equals(str2)) && (((name = this.name) == (name2 = account.name) || name.equals(name2)) && (((str3 = this.email) == (str4 = account.email) || str3.equals(str4)) && this.emailVerified == account.emailVerified && this.disabled == account.disabled && ((str5 = this.profilePhotoUrl) == (str6 = account.profilePhotoUrl) || (str5 != null && str5.equals(str6)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    private static class Serializer extends StructSerializer<Account> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(Account account, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("account_id");
            StoneSerializers.string().serialize(account.accountId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            Name.Serializer.INSTANCE.serialize(account.name, jsonGenerator);
            jsonGenerator.writeFieldName("email");
            StoneSerializers.string().serialize(account.email, jsonGenerator);
            jsonGenerator.writeFieldName("email_verified");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(account.emailVerified), jsonGenerator);
            jsonGenerator.writeFieldName("disabled");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(account.disabled), jsonGenerator);
            if (account.profilePhotoUrl != null) {
                jsonGenerator.writeFieldName("profile_photo_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(account.profilePhotoUrl, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public Account deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String strDeserialize = null;
                Name nameDeserialize = null;
                String strDeserialize2 = null;
                String str = null;
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
                    } else if ("profile_photo_url".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
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
                Account account = new Account(strDeserialize, nameDeserialize, strDeserialize2, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(account, account.toStringMultiline());
                return account;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
