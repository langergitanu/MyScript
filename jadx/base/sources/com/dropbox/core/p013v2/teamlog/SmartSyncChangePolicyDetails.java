package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.SmartSyncPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SmartSyncChangePolicyDetails {

    @Nullable
    protected final SmartSyncPolicy newValue;

    @Nullable
    protected final SmartSyncPolicy previousValue;

    public SmartSyncChangePolicyDetails(@Nullable SmartSyncPolicy smartSyncPolicy, @Nullable SmartSyncPolicy smartSyncPolicy2) {
        this.newValue = smartSyncPolicy;
        this.previousValue = smartSyncPolicy2;
    }

    public SmartSyncChangePolicyDetails() {
        this(null, null);
    }

    @Nullable
    public SmartSyncPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public SmartSyncPolicy getPreviousValue() {
        return this.previousValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected SmartSyncPolicy newValue = null;
        protected SmartSyncPolicy previousValue = null;

        protected Builder() {
        }

        public Builder withNewValue(SmartSyncPolicy smartSyncPolicy) {
            this.newValue = smartSyncPolicy;
            return this;
        }

        public Builder withPreviousValue(SmartSyncPolicy smartSyncPolicy) {
            this.previousValue = smartSyncPolicy;
            return this;
        }

        public SmartSyncChangePolicyDetails build() {
            return new SmartSyncChangePolicyDetails(this.newValue, this.previousValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        SmartSyncPolicy smartSyncPolicy;
        SmartSyncPolicy smartSyncPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SmartSyncChangePolicyDetails smartSyncChangePolicyDetails = (SmartSyncChangePolicyDetails) obj;
        SmartSyncPolicy smartSyncPolicy3 = this.newValue;
        SmartSyncPolicy smartSyncPolicy4 = smartSyncChangePolicyDetails.newValue;
        return (smartSyncPolicy3 == smartSyncPolicy4 || (smartSyncPolicy3 != null && smartSyncPolicy3.equals(smartSyncPolicy4))) && ((smartSyncPolicy = this.previousValue) == (smartSyncPolicy2 = smartSyncChangePolicyDetails.previousValue) || (smartSyncPolicy != null && smartSyncPolicy.equals(smartSyncPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SmartSyncChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SmartSyncChangePolicyDetails smartSyncChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (smartSyncChangePolicyDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(SmartSyncPolicy.Serializer.INSTANCE).serialize(smartSyncChangePolicyDetails.newValue, jsonGenerator);
            }
            if (smartSyncChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(SmartSyncPolicy.Serializer.INSTANCE).serialize(smartSyncChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SmartSyncChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SmartSyncPolicy smartSyncPolicy = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SmartSyncPolicy smartSyncPolicy2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        smartSyncPolicy = (SmartSyncPolicy) StoneSerializers.nullable(SmartSyncPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        smartSyncPolicy2 = (SmartSyncPolicy) StoneSerializers.nullable(SmartSyncPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SmartSyncChangePolicyDetails smartSyncChangePolicyDetails = new SmartSyncChangePolicyDetails(smartSyncPolicy, smartSyncPolicy2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(smartSyncChangePolicyDetails, smartSyncChangePolicyDetails.toStringMultiline());
                return smartSyncChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
