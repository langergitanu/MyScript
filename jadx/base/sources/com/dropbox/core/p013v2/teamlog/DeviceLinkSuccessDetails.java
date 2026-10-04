package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo;
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
public class DeviceLinkSuccessDetails {

    @Nullable
    protected final DeviceSessionLogInfo deviceSessionInfo;

    public DeviceLinkSuccessDetails(@Nullable DeviceSessionLogInfo deviceSessionLogInfo) {
        this.deviceSessionInfo = deviceSessionLogInfo;
    }

    public DeviceLinkSuccessDetails() {
        this(null);
    }

    @Nullable
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
        DeviceSessionLogInfo deviceSessionLogInfo2 = ((DeviceLinkSuccessDetails) obj).deviceSessionInfo;
        return deviceSessionLogInfo == deviceSessionLogInfo2 || (deviceSessionLogInfo != null && deviceSessionLogInfo.equals(deviceSessionLogInfo2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceLinkSuccessDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceLinkSuccessDetails deviceLinkSuccessDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (deviceLinkSuccessDetails.deviceSessionInfo != null) {
                jsonGenerator.writeFieldName("device_session_info");
                StoneSerializers.nullableStruct(DeviceSessionLogInfo.Serializer.INSTANCE).serialize(deviceLinkSuccessDetails.deviceSessionInfo, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceLinkSuccessDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DeviceSessionLogInfo deviceSessionLogInfo = null;
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
                        deviceSessionLogInfo = (DeviceSessionLogInfo) StoneSerializers.nullableStruct(DeviceSessionLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                DeviceLinkSuccessDetails deviceLinkSuccessDetails = new DeviceLinkSuccessDetails(deviceSessionLogInfo);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceLinkSuccessDetails, deviceLinkSuccessDetails.toStringMultiline());
                return deviceLinkSuccessDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
