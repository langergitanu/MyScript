package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.LoginMethod;
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
public class LoginSuccessDetails {

    @Nullable
    protected final Boolean isEmmManaged;

    @Nonnull
    protected final LoginMethod loginMethod;

    public LoginSuccessDetails(@Nonnull LoginMethod loginMethod, @Nullable Boolean bool) {
        this.isEmmManaged = bool;
        if (loginMethod == null) {
            throw new IllegalArgumentException("Required value for 'loginMethod' is null");
        }
        this.loginMethod = loginMethod;
    }

    public LoginSuccessDetails(@Nonnull LoginMethod loginMethod) {
        this(loginMethod, null);
    }

    @Nonnull
    public LoginMethod getLoginMethod() {
        return this.loginMethod;
    }

    @Nullable
    public Boolean getIsEmmManaged() {
        return this.isEmmManaged;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.isEmmManaged, this.loginMethod});
    }

    public boolean equals(Object obj) {
        Boolean bool;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LoginSuccessDetails loginSuccessDetails = (LoginSuccessDetails) obj;
        LoginMethod loginMethod = this.loginMethod;
        LoginMethod loginMethod2 = loginSuccessDetails.loginMethod;
        return (loginMethod == loginMethod2 || loginMethod.equals(loginMethod2)) && ((bool = this.isEmmManaged) == (bool2 = loginSuccessDetails.isEmmManaged) || (bool != null && bool.equals(bool2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LoginSuccessDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LoginSuccessDetails loginSuccessDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("login_method");
            LoginMethod.Serializer.INSTANCE.serialize(loginSuccessDetails.loginMethod, jsonGenerator);
            if (loginSuccessDetails.isEmmManaged != null) {
                jsonGenerator.writeFieldName("is_emm_managed");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(loginSuccessDetails.isEmmManaged, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LoginSuccessDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            LoginMethod loginMethodDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean bool = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("login_method".equals(currentName)) {
                        loginMethodDeserialize = LoginMethod.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("is_emm_managed".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (loginMethodDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"login_method\" missing.");
                }
                LoginSuccessDetails loginSuccessDetails = new LoginSuccessDetails(loginMethodDeserialize, bool);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(loginSuccessDetails, loginSuccessDetails.toStringMultiline());
                return loginSuccessDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
