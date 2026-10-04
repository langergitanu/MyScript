package com.dropbox.core.p013v2.sharing;

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
public class InsufficientPlan {

    @Nonnull
    protected final String message;

    @Nullable
    protected final String upsellUrl;

    public InsufficientPlan(@Nonnull String str, @Nullable String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'message' is null");
        }
        this.message = str;
        this.upsellUrl = str2;
    }

    public InsufficientPlan(@Nonnull String str) {
        this(str, null);
    }

    @Nonnull
    public String getMessage() {
        return this.message;
    }

    @Nullable
    public String getUpsellUrl() {
        return this.upsellUrl;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.message, this.upsellUrl});
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
        InsufficientPlan insufficientPlan = (InsufficientPlan) obj;
        String str3 = this.message;
        String str4 = insufficientPlan.message;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.upsellUrl) == (str2 = insufficientPlan.upsellUrl) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<InsufficientPlan> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(InsufficientPlan insufficientPlan, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("message");
            StoneSerializers.string().serialize(insufficientPlan.message, jsonGenerator);
            if (insufficientPlan.upsellUrl != null) {
                jsonGenerator.writeFieldName("upsell_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(insufficientPlan.upsellUrl, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public InsufficientPlan deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("message".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("upsell_url".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"message\" missing.");
                }
                InsufficientPlan insufficientPlan = new InsufficientPlan(strDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(insufficientPlan, insufficientPlan.toStringMultiline());
                return insufficientPlan;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
