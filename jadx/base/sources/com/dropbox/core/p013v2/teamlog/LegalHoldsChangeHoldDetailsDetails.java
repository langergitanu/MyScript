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
public class LegalHoldsChangeHoldDetailsDetails {

    @Nonnull
    protected final String legalHoldId;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final String newValue;

    @Nonnull
    protected final String previousValue;

    public LegalHoldsChangeHoldDetailsDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
        }
        this.legalHoldId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = str3;
        if (str4 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = str4;
    }

    @Nonnull
    public String getLegalHoldId() {
        return this.legalHoldId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public String getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.legalHoldId, this.name, this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LegalHoldsChangeHoldDetailsDetails legalHoldsChangeHoldDetailsDetails = (LegalHoldsChangeHoldDetailsDetails) obj;
        String str7 = this.legalHoldId;
        String str8 = legalHoldsChangeHoldDetailsDetails.legalHoldId;
        return (str7 == str8 || str7.equals(str8)) && ((str = this.name) == (str2 = legalHoldsChangeHoldDetailsDetails.name) || str.equals(str2)) && (((str3 = this.previousValue) == (str4 = legalHoldsChangeHoldDetailsDetails.previousValue) || str3.equals(str4)) && ((str5 = this.newValue) == (str6 = legalHoldsChangeHoldDetailsDetails.newValue) || str5.equals(str6)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsChangeHoldDetailsDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsChangeHoldDetailsDetails legalHoldsChangeHoldDetailsDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(legalHoldsChangeHoldDetailsDetails.legalHoldId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(legalHoldsChangeHoldDetailsDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            StoneSerializers.string().serialize(legalHoldsChangeHoldDetailsDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            StoneSerializers.string().serialize(legalHoldsChangeHoldDetailsDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsChangeHoldDetailsDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String strDeserialize3 = null;
                String strDeserialize4 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("legal_hold_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        strDeserialize4 = StoneSerializers.string().deserialize(jsonParser);
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
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (strDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                LegalHoldsChangeHoldDetailsDetails legalHoldsChangeHoldDetailsDetails = new LegalHoldsChangeHoldDetailsDetails(strDeserialize, strDeserialize2, strDeserialize3, strDeserialize4);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsChangeHoldDetailsDetails, legalHoldsChangeHoldDetailsDetails.toStringMultiline());
                return legalHoldsChangeHoldDetailsDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
