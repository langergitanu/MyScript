package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.WatermarkingPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class WatermarkingPolicyChangedDetails {

    @Nonnull
    protected final WatermarkingPolicy newValue;

    @Nonnull
    protected final WatermarkingPolicy previousValue;

    public WatermarkingPolicyChangedDetails(@Nonnull WatermarkingPolicy watermarkingPolicy, @Nonnull WatermarkingPolicy watermarkingPolicy2) {
        if (watermarkingPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = watermarkingPolicy;
        if (watermarkingPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = watermarkingPolicy2;
    }

    @Nonnull
    public WatermarkingPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public WatermarkingPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        WatermarkingPolicy watermarkingPolicy;
        WatermarkingPolicy watermarkingPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        WatermarkingPolicyChangedDetails watermarkingPolicyChangedDetails = (WatermarkingPolicyChangedDetails) obj;
        WatermarkingPolicy watermarkingPolicy3 = this.newValue;
        WatermarkingPolicy watermarkingPolicy4 = watermarkingPolicyChangedDetails.newValue;
        return (watermarkingPolicy3 == watermarkingPolicy4 || watermarkingPolicy3.equals(watermarkingPolicy4)) && ((watermarkingPolicy = this.previousValue) == (watermarkingPolicy2 = watermarkingPolicyChangedDetails.previousValue) || watermarkingPolicy.equals(watermarkingPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<WatermarkingPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(WatermarkingPolicyChangedDetails watermarkingPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            WatermarkingPolicy.Serializer.INSTANCE.serialize(watermarkingPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            WatermarkingPolicy.Serializer.INSTANCE.serialize(watermarkingPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public WatermarkingPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            WatermarkingPolicy watermarkingPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                WatermarkingPolicy watermarkingPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        watermarkingPolicyDeserialize = WatermarkingPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        watermarkingPolicyDeserialize2 = WatermarkingPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (watermarkingPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (watermarkingPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                WatermarkingPolicyChangedDetails watermarkingPolicyChangedDetails = new WatermarkingPolicyChangedDetails(watermarkingPolicyDeserialize, watermarkingPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(watermarkingPolicyChangedDetails, watermarkingPolicyChangedDetails.toStringMultiline());
                return watermarkingPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
