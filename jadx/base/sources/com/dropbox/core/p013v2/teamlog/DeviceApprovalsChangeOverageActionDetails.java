package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.RolloutMethod;
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
public class DeviceApprovalsChangeOverageActionDetails {

    @Nullable
    protected final RolloutMethod newValue;

    @Nullable
    protected final RolloutMethod previousValue;

    public DeviceApprovalsChangeOverageActionDetails(@Nullable RolloutMethod rolloutMethod, @Nullable RolloutMethod rolloutMethod2) {
        this.newValue = rolloutMethod;
        this.previousValue = rolloutMethod2;
    }

    public DeviceApprovalsChangeOverageActionDetails() {
        this(null, null);
    }

    @Nullable
    public RolloutMethod getNewValue() {
        return this.newValue;
    }

    @Nullable
    public RolloutMethod getPreviousValue() {
        return this.previousValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected RolloutMethod newValue = null;
        protected RolloutMethod previousValue = null;

        protected Builder() {
        }

        public Builder withNewValue(RolloutMethod rolloutMethod) {
            this.newValue = rolloutMethod;
            return this;
        }

        public Builder withPreviousValue(RolloutMethod rolloutMethod) {
            this.previousValue = rolloutMethod;
            return this;
        }

        public DeviceApprovalsChangeOverageActionDetails build() {
            return new DeviceApprovalsChangeOverageActionDetails(this.newValue, this.previousValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        RolloutMethod rolloutMethod;
        RolloutMethod rolloutMethod2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DeviceApprovalsChangeOverageActionDetails deviceApprovalsChangeOverageActionDetails = (DeviceApprovalsChangeOverageActionDetails) obj;
        RolloutMethod rolloutMethod3 = this.newValue;
        RolloutMethod rolloutMethod4 = deviceApprovalsChangeOverageActionDetails.newValue;
        return (rolloutMethod3 == rolloutMethod4 || (rolloutMethod3 != null && rolloutMethod3.equals(rolloutMethod4))) && ((rolloutMethod = this.previousValue) == (rolloutMethod2 = deviceApprovalsChangeOverageActionDetails.previousValue) || (rolloutMethod != null && rolloutMethod.equals(rolloutMethod2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceApprovalsChangeOverageActionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceApprovalsChangeOverageActionDetails deviceApprovalsChangeOverageActionDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (deviceApprovalsChangeOverageActionDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(RolloutMethod.Serializer.INSTANCE).serialize(deviceApprovalsChangeOverageActionDetails.newValue, jsonGenerator);
            }
            if (deviceApprovalsChangeOverageActionDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(RolloutMethod.Serializer.INSTANCE).serialize(deviceApprovalsChangeOverageActionDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceApprovalsChangeOverageActionDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            RolloutMethod rolloutMethod = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                RolloutMethod rolloutMethod2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        rolloutMethod = (RolloutMethod) StoneSerializers.nullable(RolloutMethod.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        rolloutMethod2 = (RolloutMethod) StoneSerializers.nullable(RolloutMethod.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                DeviceApprovalsChangeOverageActionDetails deviceApprovalsChangeOverageActionDetails = new DeviceApprovalsChangeOverageActionDetails(rolloutMethod, rolloutMethod2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceApprovalsChangeOverageActionDetails, deviceApprovalsChangeOverageActionDetails.toStringMultiline());
                return deviceApprovalsChangeOverageActionDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
