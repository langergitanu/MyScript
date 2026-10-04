package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SmartSyncOptOutPolicy;
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
public class SmartSyncNotOptOutDetails {

    @Nonnull
    protected final SmartSyncOptOutPolicy newValue;

    @Nonnull
    protected final SmartSyncOptOutPolicy previousValue;

    public SmartSyncNotOptOutDetails(@Nonnull SmartSyncOptOutPolicy smartSyncOptOutPolicy, @Nonnull SmartSyncOptOutPolicy smartSyncOptOutPolicy2) {
        if (smartSyncOptOutPolicy == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = smartSyncOptOutPolicy;
        if (smartSyncOptOutPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = smartSyncOptOutPolicy2;
    }

    @Nonnull
    public SmartSyncOptOutPolicy getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public SmartSyncOptOutPolicy getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        SmartSyncOptOutPolicy smartSyncOptOutPolicy;
        SmartSyncOptOutPolicy smartSyncOptOutPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SmartSyncNotOptOutDetails smartSyncNotOptOutDetails = (SmartSyncNotOptOutDetails) obj;
        SmartSyncOptOutPolicy smartSyncOptOutPolicy3 = this.previousValue;
        SmartSyncOptOutPolicy smartSyncOptOutPolicy4 = smartSyncNotOptOutDetails.previousValue;
        return (smartSyncOptOutPolicy3 == smartSyncOptOutPolicy4 || smartSyncOptOutPolicy3.equals(smartSyncOptOutPolicy4)) && ((smartSyncOptOutPolicy = this.newValue) == (smartSyncOptOutPolicy2 = smartSyncNotOptOutDetails.newValue) || smartSyncOptOutPolicy.equals(smartSyncOptOutPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SmartSyncNotOptOutDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SmartSyncNotOptOutDetails smartSyncNotOptOutDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            SmartSyncOptOutPolicy.Serializer.INSTANCE.serialize(smartSyncNotOptOutDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            SmartSyncOptOutPolicy.Serializer.INSTANCE.serialize(smartSyncNotOptOutDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SmartSyncNotOptOutDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SmartSyncOptOutPolicy smartSyncOptOutPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SmartSyncOptOutPolicy smartSyncOptOutPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        smartSyncOptOutPolicyDeserialize = SmartSyncOptOutPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        smartSyncOptOutPolicyDeserialize2 = SmartSyncOptOutPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (smartSyncOptOutPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (smartSyncOptOutPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SmartSyncNotOptOutDetails smartSyncNotOptOutDetails = new SmartSyncNotOptOutDetails(smartSyncOptOutPolicyDeserialize, smartSyncOptOutPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(smartSyncNotOptOutDetails, smartSyncNotOptOutDetails.toStringMultiline());
                return smartSyncNotOptOutDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
