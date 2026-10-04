package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserSelectorArg;
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
class MembersSetProfileArg {

    @Nullable
    protected final String newEmail;

    @Nullable
    protected final String newExternalId;

    @Nullable
    protected final String newGivenName;

    @Nullable
    protected final Boolean newIsDirectoryRestricted;

    @Nullable
    protected final String newPersistentId;

    @Nullable
    protected final String newSurname;

    @Nonnull
    protected final UserSelectorArg user;

    public MembersSetProfileArg(@Nonnull UserSelectorArg userSelectorArg, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
        if (str != null) {
            if (str.length() > 255) {
                throw new IllegalArgumentException("String 'newEmail' is longer than 255");
            }
            if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
                throw new IllegalArgumentException("String 'newEmail' does not match pattern");
            }
        }
        this.newEmail = str;
        if (str2 != null && str2.length() > 64) {
            throw new IllegalArgumentException("String 'newExternalId' is longer than 64");
        }
        this.newExternalId = str2;
        if (str3 != null) {
            if (str3.length() > 100) {
                throw new IllegalArgumentException("String 'newGivenName' is longer than 100");
            }
            if (!Pattern.matches("[^/:?*<>\"|]*", str3)) {
                throw new IllegalArgumentException("String 'newGivenName' does not match pattern");
            }
        }
        this.newGivenName = str3;
        if (str4 != null) {
            if (str4.length() > 100) {
                throw new IllegalArgumentException("String 'newSurname' is longer than 100");
            }
            if (!Pattern.matches("[^/:?*<>\"|]*", str4)) {
                throw new IllegalArgumentException("String 'newSurname' does not match pattern");
            }
        }
        this.newSurname = str4;
        this.newPersistentId = str5;
        this.newIsDirectoryRestricted = bool;
    }

    public MembersSetProfileArg(@Nonnull UserSelectorArg userSelectorArg) {
        this(userSelectorArg, null, null, null, null, null, null);
    }

    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Nullable
    public String getNewEmail() {
        return this.newEmail;
    }

    @Nullable
    public String getNewExternalId() {
        return this.newExternalId;
    }

    @Nullable
    public String getNewGivenName() {
        return this.newGivenName;
    }

    @Nullable
    public String getNewSurname() {
        return this.newSurname;
    }

    @Nullable
    public String getNewPersistentId() {
        return this.newPersistentId;
    }

    @Nullable
    public Boolean getNewIsDirectoryRestricted() {
        return this.newIsDirectoryRestricted;
    }

    public static Builder newBuilder(UserSelectorArg userSelectorArg) {
        return new Builder(userSelectorArg);
    }

    public static class Builder {
        protected String newEmail;
        protected String newExternalId;
        protected String newGivenName;
        protected Boolean newIsDirectoryRestricted;
        protected String newPersistentId;
        protected String newSurname;
        protected final UserSelectorArg user;

        protected Builder(UserSelectorArg userSelectorArg) {
            if (userSelectorArg == null) {
                throw new IllegalArgumentException("Required value for 'user' is null");
            }
            this.user = userSelectorArg;
            this.newEmail = null;
            this.newExternalId = null;
            this.newGivenName = null;
            this.newSurname = null;
            this.newPersistentId = null;
            this.newIsDirectoryRestricted = null;
        }

        public Builder withNewEmail(String str) {
            if (str != null) {
                if (str.length() > 255) {
                    throw new IllegalArgumentException("String 'newEmail' is longer than 255");
                }
                if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
                    throw new IllegalArgumentException("String 'newEmail' does not match pattern");
                }
            }
            this.newEmail = str;
            return this;
        }

        public Builder withNewExternalId(String str) {
            if (str != null && str.length() > 64) {
                throw new IllegalArgumentException("String 'newExternalId' is longer than 64");
            }
            this.newExternalId = str;
            return this;
        }

        public Builder withNewGivenName(String str) {
            if (str != null) {
                if (str.length() > 100) {
                    throw new IllegalArgumentException("String 'newGivenName' is longer than 100");
                }
                if (!Pattern.matches("[^/:?*<>\"|]*", str)) {
                    throw new IllegalArgumentException("String 'newGivenName' does not match pattern");
                }
            }
            this.newGivenName = str;
            return this;
        }

        public Builder withNewSurname(String str) {
            if (str != null) {
                if (str.length() > 100) {
                    throw new IllegalArgumentException("String 'newSurname' is longer than 100");
                }
                if (!Pattern.matches("[^/:?*<>\"|]*", str)) {
                    throw new IllegalArgumentException("String 'newSurname' does not match pattern");
                }
            }
            this.newSurname = str;
            return this;
        }

        public Builder withNewPersistentId(String str) {
            this.newPersistentId = str;
            return this;
        }

        public Builder withNewIsDirectoryRestricted(Boolean bool) {
            this.newIsDirectoryRestricted = bool;
            return this;
        }

        public MembersSetProfileArg build() {
            return new MembersSetProfileArg(this.user, this.newEmail, this.newExternalId, this.newGivenName, this.newSurname, this.newPersistentId, this.newIsDirectoryRestricted);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, this.newEmail, this.newExternalId, this.newGivenName, this.newSurname, this.newPersistentId, this.newIsDirectoryRestricted});
    }

    public boolean equals(Object obj) {
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
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MembersSetProfileArg membersSetProfileArg = (MembersSetProfileArg) obj;
        UserSelectorArg userSelectorArg = this.user;
        UserSelectorArg userSelectorArg2 = membersSetProfileArg.user;
        return (userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2)) && ((str = this.newEmail) == (str2 = membersSetProfileArg.newEmail) || (str != null && str.equals(str2))) && (((str3 = this.newExternalId) == (str4 = membersSetProfileArg.newExternalId) || (str3 != null && str3.equals(str4))) && (((str5 = this.newGivenName) == (str6 = membersSetProfileArg.newGivenName) || (str5 != null && str5.equals(str6))) && (((str7 = this.newSurname) == (str8 = membersSetProfileArg.newSurname) || (str7 != null && str7.equals(str8))) && (((str9 = this.newPersistentId) == (str10 = membersSetProfileArg.newPersistentId) || (str9 != null && str9.equals(str10))) && ((bool = this.newIsDirectoryRestricted) == (bool2 = membersSetProfileArg.newIsDirectoryRestricted) || (bool != null && bool.equals(bool2)))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersSetProfileArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersSetProfileArg membersSetProfileArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(membersSetProfileArg.user, jsonGenerator);
            if (membersSetProfileArg.newEmail != null) {
                jsonGenerator.writeFieldName("new_email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(membersSetProfileArg.newEmail, jsonGenerator);
            }
            if (membersSetProfileArg.newExternalId != null) {
                jsonGenerator.writeFieldName("new_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(membersSetProfileArg.newExternalId, jsonGenerator);
            }
            if (membersSetProfileArg.newGivenName != null) {
                jsonGenerator.writeFieldName("new_given_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(membersSetProfileArg.newGivenName, jsonGenerator);
            }
            if (membersSetProfileArg.newSurname != null) {
                jsonGenerator.writeFieldName("new_surname");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(membersSetProfileArg.newSurname, jsonGenerator);
            }
            if (membersSetProfileArg.newPersistentId != null) {
                jsonGenerator.writeFieldName("new_persistent_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(membersSetProfileArg.newPersistentId, jsonGenerator);
            }
            if (membersSetProfileArg.newIsDirectoryRestricted != null) {
                jsonGenerator.writeFieldName("new_is_directory_restricted");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(membersSetProfileArg.newIsDirectoryRestricted, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersSetProfileArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                UserSelectorArg userSelectorArgDeserialize = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                Boolean bool = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_email".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_external_id".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_given_name".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_surname".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_persistent_id".equals(currentName)) {
                        str5 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_is_directory_restricted".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                MembersSetProfileArg membersSetProfileArg = new MembersSetProfileArg(userSelectorArgDeserialize, str, str2, str3, str4, str5, bool);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersSetProfileArg, membersSetProfileArg.toStringMultiline());
                return membersSetProfileArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
