package com.dropbox.core.p013v2.secondaryemails;

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

/* JADX INFO: loaded from: classes4.dex */
public class SecondaryEmail {

    @Nonnull
    protected final String email;
    protected final boolean isVerified;

    public SecondaryEmail(@Nonnull String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'email' is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String 'email' is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String 'email' does not match pattern");
        }
        this.email = str;
        this.isVerified = z;
    }

    @Nonnull
    public String getEmail() {
        return this.email;
    }

    public boolean getIsVerified() {
        return this.isVerified;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.email, Boolean.valueOf(this.isVerified)});
    }

    public boolean equals(Object obj) {
        SecondaryEmail secondaryEmail;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.email) == (str2 = (secondaryEmail = (SecondaryEmail) obj).email) || str.equals(str2)) && this.isVerified == secondaryEmail.isVerified;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<SecondaryEmail> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SecondaryEmail secondaryEmail, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("email");
            StoneSerializers.string().serialize(secondaryEmail.email, jsonGenerator);
            jsonGenerator.writeFieldName("is_verified");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(secondaryEmail.isVerified), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SecondaryEmail deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("email".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("is_verified".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"email\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_verified\" missing.");
                }
                SecondaryEmail secondaryEmail = new SecondaryEmail(strDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(secondaryEmail, secondaryEmail.toStringMultiline());
                return secondaryEmail;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
