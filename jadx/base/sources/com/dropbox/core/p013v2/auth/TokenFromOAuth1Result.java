package com.dropbox.core.p013v2.auth;

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

/* JADX INFO: loaded from: classes4.dex */
public class TokenFromOAuth1Result {

    @Nonnull
    protected final String oauth2Token;

    public TokenFromOAuth1Result(@Nonnull String str) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'oauth2Token' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'oauth2Token' is shorter than 1");
        }
        this.oauth2Token = str;
    }

    @Nonnull
    public String getOauth2Token() {
        return this.oauth2Token;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.oauth2Token});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        String str = this.oauth2Token;
        String str2 = ((TokenFromOAuth1Result) obj).oauth2Token;
        return str == str2 || str.equals(str2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TokenFromOAuth1Result> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TokenFromOAuth1Result tokenFromOAuth1Result, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("oauth2_token");
            StoneSerializers.string().serialize(tokenFromOAuth1Result.oauth2Token, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TokenFromOAuth1Result deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("oauth2_token".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"oauth2_token\" missing.");
                }
                TokenFromOAuth1Result tokenFromOAuth1Result = new TokenFromOAuth1Result(strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(tokenFromOAuth1Result, tokenFromOAuth1Result.toStringMultiline());
                return tokenFromOAuth1Result;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
