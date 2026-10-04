package com.dropbox.core.p013v2.teamlog;

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
public class UserNameLogInfo {

    @Nonnull
    protected final String givenName;

    @Nullable
    protected final String locale;

    @Nonnull
    protected final String surname;

    public UserNameLogInfo(@Nonnull String str, @Nonnull String str2, @Nullable String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'givenName' is null");
        }
        this.givenName = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'surname' is null");
        }
        this.surname = str2;
        this.locale = str3;
    }

    public UserNameLogInfo(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, null);
    }

    @Nonnull
    public String getGivenName() {
        return this.givenName;
    }

    @Nonnull
    public String getSurname() {
        return this.surname;
    }

    @Nullable
    public String getLocale() {
        return this.locale;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.givenName, this.surname, this.locale});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserNameLogInfo userNameLogInfo = (UserNameLogInfo) obj;
        String str5 = this.givenName;
        String str6 = userNameLogInfo.givenName;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.surname) == (str2 = userNameLogInfo.surname) || str.equals(str2)) && ((str3 = this.locale) == (str4 = userNameLogInfo.locale) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserNameLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserNameLogInfo userNameLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("given_name");
            StoneSerializers.string().serialize(userNameLogInfo.givenName, jsonGenerator);
            jsonGenerator.writeFieldName("surname");
            StoneSerializers.string().serialize(userNameLogInfo.surname, jsonGenerator);
            if (userNameLogInfo.locale != null) {
                jsonGenerator.writeFieldName("locale");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userNameLogInfo.locale, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserNameLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("given_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("surname".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("locale".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"given_name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"surname\" missing.");
                }
                UserNameLogInfo userNameLogInfo = new UserNameLogInfo(strDeserialize, strDeserialize2, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userNameLogInfo, userNameLogInfo.toStringMultiline());
                return userNameLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
