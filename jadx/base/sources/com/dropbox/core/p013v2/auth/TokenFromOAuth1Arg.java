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
class TokenFromOAuth1Arg {

    @Nonnull
    protected final String oauth1Token;

    @Nonnull
    protected final String oauth1TokenSecret;

    public TokenFromOAuth1Arg(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'oauth1Token' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'oauth1Token' is shorter than 1");
        }
        this.oauth1Token = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'oauth1TokenSecret' is null");
        }
        if (str2.length() < 1) {
            throw new IllegalArgumentException("String 'oauth1TokenSecret' is shorter than 1");
        }
        this.oauth1TokenSecret = str2;
    }

    @Nonnull
    public String getOauth1Token() {
        return this.oauth1Token;
    }

    @Nonnull
    public String getOauth1TokenSecret() {
        return this.oauth1TokenSecret;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.oauth1Token, this.oauth1TokenSecret});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TokenFromOAuth1Arg tokenFromOAuth1Arg = (TokenFromOAuth1Arg) obj;
        String str3 = this.oauth1Token;
        String str4 = tokenFromOAuth1Arg.oauth1Token;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.oauth1TokenSecret) == (str2 = tokenFromOAuth1Arg.oauth1TokenSecret) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TokenFromOAuth1Arg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TokenFromOAuth1Arg tokenFromOAuth1Arg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("oauth1_token");
            StoneSerializers.string().serialize(tokenFromOAuth1Arg.oauth1Token, jsonGenerator);
            jsonGenerator.writeFieldName("oauth1_token_secret");
            StoneSerializers.string().serialize(tokenFromOAuth1Arg.oauth1TokenSecret, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TokenFromOAuth1Arg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("oauth1_token".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("oauth1_token_secret".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"oauth1_token\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"oauth1_token_secret\" missing.");
                }
                TokenFromOAuth1Arg tokenFromOAuth1Arg = new TokenFromOAuth1Arg(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(tokenFromOAuth1Arg, tokenFromOAuth1Arg.toStringMultiline());
                return tokenFromOAuth1Arg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
