package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo;
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
public class DeviceChangeIpDesktopDetails {

    @Nonnull
    protected final DeviceSessionLogInfo deviceSessionInfo;

    public DeviceChangeIpDesktopDetails(@Nonnull DeviceSessionLogInfo deviceSessionLogInfo) {
        if (deviceSessionLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'deviceSessionInfo' is null");
        }
        this.deviceSessionInfo = deviceSessionLogInfo;
    }

    @Nonnull
    public DeviceSessionLogInfo getDeviceSessionInfo() {
        return this.deviceSessionInfo;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.deviceSessionInfo});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DeviceSessionLogInfo deviceSessionLogInfo = this.deviceSessionInfo;
        DeviceSessionLogInfo deviceSessionLogInfo2 = ((DeviceChangeIpDesktopDetails) obj).deviceSessionInfo;
        return deviceSessionLogInfo == deviceSessionLogInfo2 || deviceSessionLogInfo.equals(deviceSessionLogInfo2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceChangeIpDesktopDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceChangeIpDesktopDetails deviceChangeIpDesktopDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("device_session_info");
            DeviceSessionLogInfo.Serializer.INSTANCE.serialize(deviceChangeIpDesktopDetails.deviceSessionInfo, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceChangeIpDesktopDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DeviceSessionLogInfo deviceSessionLogInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("device_session_info".equals(currentName)) {
                        deviceSessionLogInfoDeserialize = DeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (deviceSessionLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"device_session_info\" missing.");
                }
                DeviceChangeIpDesktopDetails deviceChangeIpDesktopDetails = new DeviceChangeIpDesktopDetails(deviceSessionLogInfoDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceChangeIpDesktopDetails, deviceChangeIpDesktopDetails.toStringMultiline());
                return deviceChangeIpDesktopDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
