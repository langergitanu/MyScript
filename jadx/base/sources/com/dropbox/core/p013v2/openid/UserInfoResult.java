package com.dropbox.core.p013v2.openid;

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

/* JADX INFO: loaded from: classes4.dex */
public class UserInfoResult {

    @Nullable
    protected final String email;

    @Nullable
    protected final Boolean emailVerified;

    @Nullable
    protected final String familyName;

    @Nullable
    protected final String givenName;

    @Nonnull
    protected final String iss;

    @Nonnull
    protected final String sub;

    public UserInfoResult(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nonnull String str4, @Nonnull String str5) {
        this.familyName = str;
        this.givenName = str2;
        this.email = str3;
        this.emailVerified = bool;
        if (str4 == null) {
            throw new IllegalArgumentException("Required value for 'iss' is null");
        }
        this.iss = str4;
        if (str5 == null) {
            throw new IllegalArgumentException("Required value for 'sub' is null");
        }
        this.sub = str5;
    }

    public UserInfoResult() {
        this(null, null, null, null, "", "");
    }

    @Nullable
    public String getFamilyName() {
        return this.familyName;
    }

    @Nullable
    public String getGivenName() {
        return this.givenName;
    }

    @Nullable
    public String getEmail() {
        return this.email;
    }

    @Nullable
    public Boolean getEmailVerified() {
        return this.emailVerified;
    }

    @Nonnull
    public String getIss() {
        return this.iss;
    }

    @Nonnull
    public String getSub() {
        return this.sub;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String familyName = null;
        protected String givenName = null;
        protected String email = null;
        protected Boolean emailVerified = null;
        protected String iss = "";
        protected String sub = "";

        protected Builder() {
        }

        public Builder withFamilyName(String str) {
            this.familyName = str;
            return this;
        }

        public Builder withGivenName(String str) {
            this.givenName = str;
            return this;
        }

        public Builder withEmail(String str) {
            this.email = str;
            return this;
        }

        public Builder withEmailVerified(Boolean bool) {
            this.emailVerified = bool;
            return this;
        }

        public Builder withIss(String str) {
            if (str != null) {
                this.iss = str;
                return this;
            }
            this.iss = "";
            return this;
        }

        public Builder withSub(String str) {
            if (str != null) {
                this.sub = str;
                return this;
            }
            this.sub = "";
            return this;
        }

        public UserInfoResult build() {
            return new UserInfoResult(this.familyName, this.givenName, this.email, this.emailVerified, this.iss, this.sub);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.familyName, this.givenName, this.email, this.emailVerified, this.iss, this.sub});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Boolean bool;
        Boolean bool2;
        String str5;
        String str6;
        String str7;
        String str8;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserInfoResult userInfoResult = (UserInfoResult) obj;
        String str9 = this.familyName;
        String str10 = userInfoResult.familyName;
        return (str9 == str10 || (str9 != null && str9.equals(str10))) && ((str = this.givenName) == (str2 = userInfoResult.givenName) || (str != null && str.equals(str2))) && (((str3 = this.email) == (str4 = userInfoResult.email) || (str3 != null && str3.equals(str4))) && (((bool = this.emailVerified) == (bool2 = userInfoResult.emailVerified) || (bool != null && bool.equals(bool2))) && (((str5 = this.iss) == (str6 = userInfoResult.iss) || str5.equals(str6)) && ((str7 = this.sub) == (str8 = userInfoResult.sub) || str7.equals(str8)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserInfoResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserInfoResult userInfoResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (userInfoResult.familyName != null) {
                jsonGenerator.writeFieldName("family_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userInfoResult.familyName, jsonGenerator);
            }
            if (userInfoResult.givenName != null) {
                jsonGenerator.writeFieldName("given_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userInfoResult.givenName, jsonGenerator);
            }
            if (userInfoResult.email != null) {
                jsonGenerator.writeFieldName("email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userInfoResult.email, jsonGenerator);
            }
            if (userInfoResult.emailVerified != null) {
                jsonGenerator.writeFieldName("email_verified");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(userInfoResult.emailVerified, jsonGenerator);
            }
            jsonGenerator.writeFieldName("iss");
            StoneSerializers.string().serialize(userInfoResult.iss, jsonGenerator);
            jsonGenerator.writeFieldName("sub");
            StoneSerializers.string().serialize(userInfoResult.sub, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserInfoResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                String str2 = null;
                String str3 = null;
                Boolean bool = null;
                String strDeserialize = "";
                String strDeserialize2 = strDeserialize;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("family_name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("given_name".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("email".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("email_verified".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("iss".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("sub".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                UserInfoResult userInfoResult = new UserInfoResult(str, str2, str3, bool, strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userInfoResult, userInfoResult.toStringMultiline());
                return userInfoResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
