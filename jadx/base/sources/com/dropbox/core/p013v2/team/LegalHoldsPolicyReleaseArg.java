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

/* JADX INFO: loaded from: classes5.dex */
class LegalHoldsPolicyReleaseArg {

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f756id;

    public LegalHoldsPolicyReleaseArg(@Nonnull String str) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (!Pattern.matches("^pid_dbhid:.+", str)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.f756id = str;
    }

    @Nonnull
    public String getId() {
        return this.f756id;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f756id});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        String str = this.f756id;
        String str2 = ((LegalHoldsPolicyReleaseArg) obj).f756id;
        return str == str2 || str.equals(str2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsPolicyReleaseArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsPolicyReleaseArg legalHoldsPolicyReleaseArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(legalHoldsPolicyReleaseArg.f756id, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsPolicyReleaseArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                LegalHoldsPolicyReleaseArg legalHoldsPolicyReleaseArg = new LegalHoldsPolicyReleaseArg(strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsPolicyReleaseArg, legalHoldsPolicyReleaseArg.toStringMultiline());
                return legalHoldsPolicyReleaseArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
