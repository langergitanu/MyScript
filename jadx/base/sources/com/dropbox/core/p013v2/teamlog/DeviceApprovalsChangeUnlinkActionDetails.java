package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DeviceUnlinkPolicy;
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
public class DeviceApprovalsChangeUnlinkActionDetails {

    @Nullable
    protected final DeviceUnlinkPolicy newValue;

    @Nullable
    protected final DeviceUnlinkPolicy previousValue;

    public DeviceApprovalsChangeUnlinkActionDetails(@Nullable DeviceUnlinkPolicy deviceUnlinkPolicy, @Nullable DeviceUnlinkPolicy deviceUnlinkPolicy2) {
        this.newValue = deviceUnlinkPolicy;
        this.previousValue = deviceUnlinkPolicy2;
    }

    public DeviceApprovalsChangeUnlinkActionDetails() {
        this(null, null);
    }

    @Nullable
    public DeviceUnlinkPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public DeviceUnlinkPolicy getPreviousValue() {
        return this.previousValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected DeviceUnlinkPolicy newValue = null;
        protected DeviceUnlinkPolicy previousValue = null;

        protected Builder() {
        }

        public Builder withNewValue(DeviceUnlinkPolicy deviceUnlinkPolicy) {
            this.newValue = deviceUnlinkPolicy;
            return this;
        }

        public Builder withPreviousValue(DeviceUnlinkPolicy deviceUnlinkPolicy) {
            this.previousValue = deviceUnlinkPolicy;
            return this;
        }

        public DeviceApprovalsChangeUnlinkActionDetails build() {
            return new DeviceApprovalsChangeUnlinkActionDetails(this.newValue, this.previousValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        DeviceUnlinkPolicy deviceUnlinkPolicy;
        DeviceUnlinkPolicy deviceUnlinkPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DeviceApprovalsChangeUnlinkActionDetails deviceApprovalsChangeUnlinkActionDetails = (DeviceApprovalsChangeUnlinkActionDetails) obj;
        DeviceUnlinkPolicy deviceUnlinkPolicy3 = this.newValue;
        DeviceUnlinkPolicy deviceUnlinkPolicy4 = deviceApprovalsChangeUnlinkActionDetails.newValue;
        return (deviceUnlinkPolicy3 == deviceUnlinkPolicy4 || (deviceUnlinkPolicy3 != null && deviceUnlinkPolicy3.equals(deviceUnlinkPolicy4))) && ((deviceUnlinkPolicy = this.previousValue) == (deviceUnlinkPolicy2 = deviceApprovalsChangeUnlinkActionDetails.previousValue) || (deviceUnlinkPolicy != null && deviceUnlinkPolicy.equals(deviceUnlinkPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceApprovalsChangeUnlinkActionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceApprovalsChangeUnlinkActionDetails deviceApprovalsChangeUnlinkActionDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (deviceApprovalsChangeUnlinkActionDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(DeviceUnlinkPolicy.Serializer.INSTANCE).serialize(deviceApprovalsChangeUnlinkActionDetails.newValue, jsonGenerator);
            }
            if (deviceApprovalsChangeUnlinkActionDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(DeviceUnlinkPolicy.Serializer.INSTANCE).serialize(deviceApprovalsChangeUnlinkActionDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceApprovalsChangeUnlinkActionDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DeviceUnlinkPolicy deviceUnlinkPolicy = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                DeviceUnlinkPolicy deviceUnlinkPolicy2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        deviceUnlinkPolicy = (DeviceUnlinkPolicy) StoneSerializers.nullable(DeviceUnlinkPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        deviceUnlinkPolicy2 = (DeviceUnlinkPolicy) StoneSerializers.nullable(DeviceUnlinkPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                DeviceApprovalsChangeUnlinkActionDetails deviceApprovalsChangeUnlinkActionDetails = new DeviceApprovalsChangeUnlinkActionDetails(deviceUnlinkPolicy, deviceUnlinkPolicy2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceApprovalsChangeUnlinkActionDetails, deviceApprovalsChangeUnlinkActionDetails.toStringMultiline());
                return deviceApprovalsChangeUnlinkActionDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
