package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DeviceApprovalsPolicy;
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
public class DeviceApprovalsChangeDesktopPolicyDetails {

    @Nullable
    protected final DeviceApprovalsPolicy newValue;

    @Nullable
    protected final DeviceApprovalsPolicy previousValue;

    public DeviceApprovalsChangeDesktopPolicyDetails(@Nullable DeviceApprovalsPolicy deviceApprovalsPolicy, @Nullable DeviceApprovalsPolicy deviceApprovalsPolicy2) {
        this.newValue = deviceApprovalsPolicy;
        this.previousValue = deviceApprovalsPolicy2;
    }

    public DeviceApprovalsChangeDesktopPolicyDetails() {
        this(null, null);
    }

    @Nullable
    public DeviceApprovalsPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public DeviceApprovalsPolicy getPreviousValue() {
        return this.previousValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected DeviceApprovalsPolicy newValue = null;
        protected DeviceApprovalsPolicy previousValue = null;

        protected Builder() {
        }

        public Builder withNewValue(DeviceApprovalsPolicy deviceApprovalsPolicy) {
            this.newValue = deviceApprovalsPolicy;
            return this;
        }

        public Builder withPreviousValue(DeviceApprovalsPolicy deviceApprovalsPolicy) {
            this.previousValue = deviceApprovalsPolicy;
            return this;
        }

        public DeviceApprovalsChangeDesktopPolicyDetails build() {
            return new DeviceApprovalsChangeDesktopPolicyDetails(this.newValue, this.previousValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        DeviceApprovalsPolicy deviceApprovalsPolicy;
        DeviceApprovalsPolicy deviceApprovalsPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DeviceApprovalsChangeDesktopPolicyDetails deviceApprovalsChangeDesktopPolicyDetails = (DeviceApprovalsChangeDesktopPolicyDetails) obj;
        DeviceApprovalsPolicy deviceApprovalsPolicy3 = this.newValue;
        DeviceApprovalsPolicy deviceApprovalsPolicy4 = deviceApprovalsChangeDesktopPolicyDetails.newValue;
        return (deviceApprovalsPolicy3 == deviceApprovalsPolicy4 || (deviceApprovalsPolicy3 != null && deviceApprovalsPolicy3.equals(deviceApprovalsPolicy4))) && ((deviceApprovalsPolicy = this.previousValue) == (deviceApprovalsPolicy2 = deviceApprovalsChangeDesktopPolicyDetails.previousValue) || (deviceApprovalsPolicy != null && deviceApprovalsPolicy.equals(deviceApprovalsPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceApprovalsChangeDesktopPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        /* JADX WARN: Failed to analyze thrown exceptions
        java.util.ConcurrentModificationException
        	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1605)
        	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1628)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.mergeExceptions(MethodThrowsVisitor.java:99)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:86)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
         */
        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceApprovalsChangeDesktopPolicyDetails deviceApprovalsChangeDesktopPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (deviceApprovalsChangeDesktopPolicyDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(DeviceApprovalsPolicy.Serializer.INSTANCE).serialize(deviceApprovalsChangeDesktopPolicyDetails.newValue, jsonGenerator);
            }
            if (deviceApprovalsChangeDesktopPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(DeviceApprovalsPolicy.Serializer.INSTANCE).serialize(deviceApprovalsChangeDesktopPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceApprovalsChangeDesktopPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DeviceApprovalsPolicy deviceApprovalsPolicy = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                DeviceApprovalsPolicy deviceApprovalsPolicy2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        deviceApprovalsPolicy = (DeviceApprovalsPolicy) StoneSerializers.nullable(DeviceApprovalsPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        deviceApprovalsPolicy2 = (DeviceApprovalsPolicy) StoneSerializers.nullable(DeviceApprovalsPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                DeviceApprovalsChangeDesktopPolicyDetails deviceApprovalsChangeDesktopPolicyDetails = new DeviceApprovalsChangeDesktopPolicyDetails(deviceApprovalsPolicy, deviceApprovalsPolicy2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceApprovalsChangeDesktopPolicyDetails, deviceApprovalsChangeDesktopPolicyDetails.toStringMultiline());
                return deviceApprovalsChangeDesktopPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
