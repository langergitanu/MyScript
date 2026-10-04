package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DesktopDeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.LegacyDeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.MobileDeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.WebDeviceSessionLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceSessionLogInfo {

    @Nullable
    protected final Date created;

    @Nullable
    protected final String ipAddress;

    @Nullable
    protected final Date updated;

    public DeviceSessionLogInfo(@Nullable String str, @Nullable Date date, @Nullable Date date2) {
        this.ipAddress = str;
        this.created = LangUtil.truncateMillis(date);
        this.updated = LangUtil.truncateMillis(date2);
    }

    public DeviceSessionLogInfo() {
        this(null, null, null);
    }

    @Nullable
    public String getIpAddress() {
        return this.ipAddress;
    }

    @Nullable
    public Date getCreated() {
        return this.created;
    }

    @Nullable
    public Date getUpdated() {
        return this.updated;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String ipAddress = null;
        protected Date created = null;
        protected Date updated = null;

        protected Builder() {
        }

        public Builder withIpAddress(String str) {
            this.ipAddress = str;
            return this;
        }

        public Builder withCreated(Date date) {
            this.created = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withUpdated(Date date) {
            this.updated = LangUtil.truncateMillis(date);
            return this;
        }

        public DeviceSessionLogInfo build() {
            return new DeviceSessionLogInfo(this.ipAddress, this.created, this.updated);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.ipAddress, this.created, this.updated});
    }

    public boolean equals(Object obj) {
        Date date;
        Date date2;
        Date date3;
        Date date4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DeviceSessionLogInfo deviceSessionLogInfo = (DeviceSessionLogInfo) obj;
        String str = this.ipAddress;
        String str2 = deviceSessionLogInfo.ipAddress;
        return (str == str2 || (str != null && str.equals(str2))) && ((date = this.created) == (date2 = deviceSessionLogInfo.created) || (date != null && date.equals(date2))) && ((date3 = this.updated) == (date4 = deviceSessionLogInfo.updated) || (date3 != null && date3.equals(date4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceSessionLogInfo deviceSessionLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (deviceSessionLogInfo instanceof DesktopDeviceSessionLogInfo) {
                DesktopDeviceSessionLogInfo.Serializer.INSTANCE.serialize((DesktopDeviceSessionLogInfo) deviceSessionLogInfo, jsonGenerator, z);
                return;
            }
            if (deviceSessionLogInfo instanceof MobileDeviceSessionLogInfo) {
                MobileDeviceSessionLogInfo.Serializer.INSTANCE.serialize((MobileDeviceSessionLogInfo) deviceSessionLogInfo, jsonGenerator, z);
                return;
            }
            if (deviceSessionLogInfo instanceof WebDeviceSessionLogInfo) {
                WebDeviceSessionLogInfo.Serializer.INSTANCE.serialize((WebDeviceSessionLogInfo) deviceSessionLogInfo, jsonGenerator, z);
                return;
            }
            if (deviceSessionLogInfo instanceof LegacyDeviceSessionLogInfo) {
                LegacyDeviceSessionLogInfo.Serializer.INSTANCE.serialize((LegacyDeviceSessionLogInfo) deviceSessionLogInfo, jsonGenerator, z);
                return;
            }
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (deviceSessionLogInfo.ipAddress != null) {
                jsonGenerator.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deviceSessionLogInfo.ipAddress, jsonGenerator);
            }
            if (deviceSessionLogInfo.created != null) {
                jsonGenerator.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(deviceSessionLogInfo.created, jsonGenerator);
            }
            if (deviceSessionLogInfo.updated != null) {
                jsonGenerator.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(deviceSessionLogInfo.updated, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0012  */
        @Override // com.dropbox.core.stone.StructSerializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DeviceSessionLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DeviceSessionLogInfo deviceSessionLogInfoDeserialize;
            String str = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                Date date = null;
                Date date2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("ip_address".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("updated".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                deviceSessionLogInfoDeserialize = new DeviceSessionLogInfo(str, date, date2);
            } else if ("".equals(tag)) {
                deviceSessionLogInfoDeserialize = INSTANCE.deserialize(jsonParser, true);
            } else if ("desktop_device_session".equals(tag)) {
                deviceSessionLogInfoDeserialize = DesktopDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("mobile_device_session".equals(tag)) {
                deviceSessionLogInfoDeserialize = MobileDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("web_device_session".equals(tag)) {
                deviceSessionLogInfoDeserialize = WebDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("legacy_device_session".equals(tag)) {
                deviceSessionLogInfoDeserialize = LegacyDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else {
                throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!z) {
                expectEndObject(jsonParser);
            }
            StoneDeserializerLogger.log(deviceSessionLogInfoDeserialize, deviceSessionLogInfoDeserialize.toStringMultiline());
            return deviceSessionLogInfoDeserialize;
        }
    }
}
