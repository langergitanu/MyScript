package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DeviceType;
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

/* JADX INFO: loaded from: classes5.dex */
public class DeviceLinkFailDetails {

    @Nonnull
    protected final DeviceType deviceType;

    @Nullable
    protected final String ipAddress;

    public DeviceLinkFailDetails(@Nonnull DeviceType deviceType, @Nullable String str) {
        this.ipAddress = str;
        if (deviceType == null) {
            throw new IllegalArgumentException("Required value for 'deviceType' is null");
        }
        this.deviceType = deviceType;
    }

    public DeviceLinkFailDetails(@Nonnull DeviceType deviceType) {
        this(deviceType, null);
    }

    @Nonnull
    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    public String getIpAddress() {
        return this.ipAddress;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.ipAddress, this.deviceType});
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
        DeviceLinkFailDetails deviceLinkFailDetails = (DeviceLinkFailDetails) obj;
        DeviceType deviceType = this.deviceType;
        DeviceType deviceType2 = deviceLinkFailDetails.deviceType;
        return (deviceType == deviceType2 || deviceType.equals(deviceType2)) && ((str = this.ipAddress) == (str2 = deviceLinkFailDetails.ipAddress) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceLinkFailDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceLinkFailDetails deviceLinkFailDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("device_type");
            DeviceType.Serializer.INSTANCE.serialize(deviceLinkFailDetails.deviceType, jsonGenerator);
            if (deviceLinkFailDetails.ipAddress != null) {
                jsonGenerator.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deviceLinkFailDetails.ipAddress, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceLinkFailDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DeviceType deviceTypeDeserialize = null;
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
                    if ("device_type".equals(currentName)) {
                        deviceTypeDeserialize = DeviceType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("ip_address".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (deviceTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"device_type\" missing.");
                }
                DeviceLinkFailDetails deviceLinkFailDetails = new DeviceLinkFailDetails(deviceTypeDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceLinkFailDetails, deviceLinkFailDetails.toStringMultiline());
                return deviceLinkFailDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
