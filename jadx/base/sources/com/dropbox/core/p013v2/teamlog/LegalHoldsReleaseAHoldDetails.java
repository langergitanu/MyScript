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

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldsReleaseAHoldDetails {

    @Nonnull
    protected final String legalHoldId;

    @Nonnull
    protected final String name;

    public LegalHoldsReleaseAHoldDetails(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
        }
        this.legalHoldId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
    }

    @Nonnull
    public String getLegalHoldId() {
        return this.legalHoldId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.legalHoldId, this.name});
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
        LegalHoldsReleaseAHoldDetails legalHoldsReleaseAHoldDetails = (LegalHoldsReleaseAHoldDetails) obj;
        String str3 = this.legalHoldId;
        String str4 = legalHoldsReleaseAHoldDetails.legalHoldId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.name) == (str2 = legalHoldsReleaseAHoldDetails.name) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsReleaseAHoldDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsReleaseAHoldDetails legalHoldsReleaseAHoldDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(legalHoldsReleaseAHoldDetails.legalHoldId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(legalHoldsReleaseAHoldDetails.name, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsReleaseAHoldDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("legal_hold_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"legal_hold_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                LegalHoldsReleaseAHoldDetails legalHoldsReleaseAHoldDetails = new LegalHoldsReleaseAHoldDetails(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsReleaseAHoldDetails, legalHoldsReleaseAHoldDetails.toStringMultiline());
                return legalHoldsReleaseAHoldDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
