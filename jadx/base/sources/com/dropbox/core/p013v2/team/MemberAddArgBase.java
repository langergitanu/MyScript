package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class MemberAddArgBase {

    @Nullable
    protected final Boolean isDirectoryRestricted;

    @Nonnull
    protected final String memberEmail;

    @Nullable
    protected final String memberExternalId;

    @Nullable
    protected final String memberGivenName;

    @Nullable
    protected final String memberPersistentId;

    @Nullable
    protected final String memberSurname;
    protected final boolean sendWelcomeEmail;

    public MemberAddArgBase(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z, @Nullable Boolean bool) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'memberEmail' is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String 'memberEmail' is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String 'memberEmail' does not match pattern");
        }
        this.memberEmail = str;
        if (str2 != null) {
            if (str2.length() > 100) {
                throw new IllegalArgumentException("String 'memberGivenName' is longer than 100");
            }
            if (!Pattern.matches("[^/:?*<>\"|]*", str2)) {
                throw new IllegalArgumentException("String 'memberGivenName' does not match pattern");
            }
        }
        this.memberGivenName = str2;
        if (str3 != null) {
            if (str3.length() > 100) {
                throw new IllegalArgumentException("String 'memberSurname' is longer than 100");
            }
            if (!Pattern.matches("[^/:?*<>\"|]*", str3)) {
                throw new IllegalArgumentException("String 'memberSurname' does not match pattern");
            }
        }
        this.memberSurname = str3;
        if (str4 != null && str4.length() > 64) {
            throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
        }
        this.memberExternalId = str4;
        this.memberPersistentId = str5;
        this.sendWelcomeEmail = z;
        this.isDirectoryRestricted = bool;
    }

    public MemberAddArgBase(@Nonnull String str) {
        this(str, null, null, null, null, true, null);
    }

    @Nonnull
    public String getMemberEmail() {
        return this.memberEmail;
    }

    @Nullable
    public String getMemberGivenName() {
        return this.memberGivenName;
    }

    @Nullable
    public String getMemberSurname() {
        return this.memberSurname;
    }

    @Nullable
    public String getMemberExternalId() {
        return this.memberExternalId;
    }

    @Nullable
    public String getMemberPersistentId() {
        return this.memberPersistentId;
    }

    public boolean getSendWelcomeEmail() {
        return this.sendWelcomeEmail;
    }

    @Nullable
    public Boolean getIsDirectoryRestricted() {
        return this.isDirectoryRestricted;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected Boolean isDirectoryRestricted;
        protected final String memberEmail;
        protected String memberExternalId;
        protected String memberGivenName;
        protected String memberPersistentId;
        protected String memberSurname;
        protected boolean sendWelcomeEmail;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'memberEmail' is null");
            }
            if (str.length() > 255) {
                throw new IllegalArgumentException("String 'memberEmail' is longer than 255");
            }
            if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
                throw new IllegalArgumentException("String 'memberEmail' does not match pattern");
            }
            this.memberEmail = str;
            this.memberGivenName = null;
            this.memberSurname = null;
            this.memberExternalId = null;
            this.memberPersistentId = null;
            this.sendWelcomeEmail = true;
            this.isDirectoryRestricted = null;
        }

        public Builder withMemberGivenName(String str) {
            if (str != null) {
                if (str.length() > 100) {
                    throw new IllegalArgumentException("String 'memberGivenName' is longer than 100");
                }
                if (!Pattern.matches("[^/:?*<>\"|]*", str)) {
                    throw new IllegalArgumentException("String 'memberGivenName' does not match pattern");
                }
            }
            this.memberGivenName = str;
            return this;
        }

        public Builder withMemberSurname(String str) {
            if (str != null) {
                if (str.length() > 100) {
                    throw new IllegalArgumentException("String 'memberSurname' is longer than 100");
                }
                if (!Pattern.matches("[^/:?*<>\"|]*", str)) {
                    throw new IllegalArgumentException("String 'memberSurname' does not match pattern");
                }
            }
            this.memberSurname = str;
            return this;
        }

        public Builder withMemberExternalId(String str) {
            if (str != null && str.length() > 64) {
                throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
            }
            this.memberExternalId = str;
            return this;
        }

        public Builder withMemberPersistentId(String str) {
            this.memberPersistentId = str;
            return this;
        }

        public Builder withSendWelcomeEmail(Boolean bool) {
            if (bool != null) {
                this.sendWelcomeEmail = bool.booleanValue();
                return this;
            }
            this.sendWelcomeEmail = true;
            return this;
        }

        public Builder withIsDirectoryRestricted(Boolean bool) {
            this.isDirectoryRestricted = bool;
            return this;
        }

        public MemberAddArgBase build() {
            return new MemberAddArgBase(this.memberEmail, this.memberGivenName, this.memberSurname, this.memberExternalId, this.memberPersistentId, this.sendWelcomeEmail, this.isDirectoryRestricted);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.memberEmail, this.memberGivenName, this.memberSurname, this.memberExternalId, this.memberPersistentId, Boolean.valueOf(this.sendWelcomeEmail), this.isDirectoryRestricted});
    }

    public boolean equals(Object obj) {
        MemberAddArgBase memberAddArgBase;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Boolean bool;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.memberEmail) == (str2 = (memberAddArgBase = (MemberAddArgBase) obj).memberEmail) || str.equals(str2)) && (((str3 = this.memberGivenName) == (str4 = memberAddArgBase.memberGivenName) || (str3 != null && str3.equals(str4))) && (((str5 = this.memberSurname) == (str6 = memberAddArgBase.memberSurname) || (str5 != null && str5.equals(str6))) && (((str7 = this.memberExternalId) == (str8 = memberAddArgBase.memberExternalId) || (str7 != null && str7.equals(str8))) && (((str9 = this.memberPersistentId) == (str10 = memberAddArgBase.memberPersistentId) || (str9 != null && str9.equals(str10))) && this.sendWelcomeEmail == memberAddArgBase.sendWelcomeEmail && ((bool = this.isDirectoryRestricted) == (bool2 = memberAddArgBase.isDirectoryRestricted) || (bool != null && bool.equals(bool2)))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    private static class Serializer extends StructSerializer<MemberAddArgBase> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberAddArgBase memberAddArgBase, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("member_email");
            StoneSerializers.string().serialize(memberAddArgBase.memberEmail, jsonGenerator);
            if (memberAddArgBase.memberGivenName != null) {
                jsonGenerator.writeFieldName("member_given_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddArgBase.memberGivenName, jsonGenerator);
            }
            if (memberAddArgBase.memberSurname != null) {
                jsonGenerator.writeFieldName("member_surname");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddArgBase.memberSurname, jsonGenerator);
            }
            if (memberAddArgBase.memberExternalId != null) {
                jsonGenerator.writeFieldName("member_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddArgBase.memberExternalId, jsonGenerator);
            }
            if (memberAddArgBase.memberPersistentId != null) {
                jsonGenerator.writeFieldName("member_persistent_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(memberAddArgBase.memberPersistentId, jsonGenerator);
            }
            jsonGenerator.writeFieldName("send_welcome_email");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(memberAddArgBase.sendWelcomeEmail), jsonGenerator);
            if (memberAddArgBase.isDirectoryRestricted != null) {
                jsonGenerator.writeFieldName("is_directory_restricted");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(memberAddArgBase.isDirectoryRestricted, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberAddArgBase deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member_email\" missing.");
                }
                MemberAddArgBase memberAddArgBase = new MemberAddArgBase(strDeserialize, str, str2, str3, str4, boolDeserialize.booleanValue(), bool);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberAddArgBase, memberAddArgBase.toStringMultiline());
                return memberAddArgBase;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
