package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.team.MobileClientPlatform;
import com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.MobileSessionLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class MobileDeviceSessionLogInfo extends DeviceSessionLogInfo {

    @Nonnull
    protected final MobileClientPlatform clientType;

    @Nullable
    protected final String clientVersion;

    @Nonnull
    protected final String deviceName;

    @Nullable
    protected final String lastCarrier;

    @Nullable
    protected final String osVersion;

    @Nullable
    protected final MobileSessionLogInfo sessionInfo;

    public MobileDeviceSessionLogInfo(@Nonnull String str, @Nonnull MobileClientPlatform mobileClientPlatform, @Nullable String str2, @Nullable Date date, @Nullable Date date2, @Nullable MobileSessionLogInfo mobileSessionLogInfo, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        super(str2, date, date2);
        this.sessionInfo = mobileSessionLogInfo;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'deviceName' is null");
        }
        this.deviceName = str;
        if (mobileClientPlatform == null) {
            throw new IllegalArgumentException("Required value for 'clientType' is null");
        }
        this.clientType = mobileClientPlatform;
        this.clientVersion = str3;
        this.osVersion = str4;
        this.lastCarrier = str5;
    }

    public MobileDeviceSessionLogInfo(@Nonnull String str, @Nonnull MobileClientPlatform mobileClientPlatform) {
        this(str, mobileClientPlatform, null, null, null, null, null, null, null);
    }

    @Nonnull
    public String getDeviceName() {
        return this.deviceName;
    }

    @Nonnull
    public MobileClientPlatform getClientType() {
        return this.clientType;
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    @Nullable
    public String getIpAddress() {
        return this.ipAddress;
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    @Nullable
    public Date getCreated() {
        return this.created;
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    @Nullable
    public Date getUpdated() {
        return this.updated;
    }

    @Nullable
    public MobileSessionLogInfo getSessionInfo() {
        return this.sessionInfo;
    }

    @Nullable
    public String getClientVersion() {
        return this.clientVersion;
    }

    @Nullable
    public String getOsVersion() {
        return this.osVersion;
    }

    @Nullable
    public String getLastCarrier() {
        return this.lastCarrier;
    }

    public static Builder newBuilder(String str, MobileClientPlatform mobileClientPlatform) {
        return new Builder(str, mobileClientPlatform);
    }

    public static class Builder extends DeviceSessionLogInfo.Builder {
        protected final MobileClientPlatform clientType;
        protected String clientVersion;
        protected final String deviceName;
        protected String lastCarrier;
        protected String osVersion;
        protected MobileSessionLogInfo sessionInfo;

        protected Builder(String str, MobileClientPlatform mobileClientPlatform) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'deviceName' is null");
            }
            this.deviceName = str;
            if (mobileClientPlatform == null) {
                throw new IllegalArgumentException("Required value for 'clientType' is null");
            }
            this.clientType = mobileClientPlatform;
            this.sessionInfo = null;
            this.clientVersion = null;
            this.osVersion = null;
            this.lastCarrier = null;
        }

        public Builder withSessionInfo(MobileSessionLogInfo mobileSessionLogInfo) {
            this.sessionInfo = mobileSessionLogInfo;
            return this;
        }

        public Builder withClientVersion(String str) {
            this.clientVersion = str;
            return this;
        }

        public Builder withOsVersion(String str) {
            this.osVersion = str;
            return this;
        }

        public Builder withLastCarrier(String str) {
            this.lastCarrier = str;
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.DeviceSessionLogInfo.Builder
        public Builder withIpAddress(String str) {
            super.withIpAddress(str);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.DeviceSessionLogInfo.Builder
        public Builder withCreated(Date date) {
            super.withCreated(date);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.DeviceSessionLogInfo.Builder
        public Builder withUpdated(Date date) {
            super.withUpdated(date);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.DeviceSessionLogInfo.Builder
        public MobileDeviceSessionLogInfo build() {
            return new MobileDeviceSessionLogInfo(this.deviceName, this.clientType, this.ipAddress, this.created, this.updated, this.sessionInfo, this.clientVersion, this.osVersion, this.lastCarrier);
        }
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.sessionInfo, this.deviceName, this.clientType, this.clientVersion, this.osVersion, this.lastCarrier});
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public boolean equals(Object obj) {
        MobileClientPlatform mobileClientPlatform;
        MobileClientPlatform mobileClientPlatform2;
        MobileSessionLogInfo mobileSessionLogInfo;
        MobileSessionLogInfo mobileSessionLogInfo2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MobileDeviceSessionLogInfo mobileDeviceSessionLogInfo = (MobileDeviceSessionLogInfo) obj;
        String str7 = this.deviceName;
        String str8 = mobileDeviceSessionLogInfo.deviceName;
        return (str7 == str8 || str7.equals(str8)) && ((mobileClientPlatform = this.clientType) == (mobileClientPlatform2 = mobileDeviceSessionLogInfo.clientType) || mobileClientPlatform.equals(mobileClientPlatform2)) && ((this.ipAddress == mobileDeviceSessionLogInfo.ipAddress || (this.ipAddress != null && this.ipAddress.equals(mobileDeviceSessionLogInfo.ipAddress))) && ((this.created == mobileDeviceSessionLogInfo.created || (this.created != null && this.created.equals(mobileDeviceSessionLogInfo.created))) && ((this.updated == mobileDeviceSessionLogInfo.updated || (this.updated != null && this.updated.equals(mobileDeviceSessionLogInfo.updated))) && (((mobileSessionLogInfo = this.sessionInfo) == (mobileSessionLogInfo2 = mobileDeviceSessionLogInfo.sessionInfo) || (mobileSessionLogInfo != null && mobileSessionLogInfo.equals(mobileSessionLogInfo2))) && (((str = this.clientVersion) == (str2 = mobileDeviceSessionLogInfo.clientVersion) || (str != null && str.equals(str2))) && (((str3 = this.osVersion) == (str4 = mobileDeviceSessionLogInfo.osVersion) || (str3 != null && str3.equals(str4))) && ((str5 = this.lastCarrier) == (str6 = mobileDeviceSessionLogInfo.lastCarrier) || (str5 != null && str5.equals(str6)))))))));
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MobileDeviceSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MobileDeviceSessionLogInfo mobileDeviceSessionLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("mobile_device_session", jsonGenerator);
            jsonGenerator.writeFieldName("device_name");
            StoneSerializers.string().serialize(mobileDeviceSessionLogInfo.deviceName, jsonGenerator);
            jsonGenerator.writeFieldName("client_type");
            MobileClientPlatform.Serializer.INSTANCE.serialize(mobileDeviceSessionLogInfo.clientType, jsonGenerator);
            if (mobileDeviceSessionLogInfo.ipAddress != null) {
                jsonGenerator.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(mobileDeviceSessionLogInfo.ipAddress, jsonGenerator);
            }
            if (mobileDeviceSessionLogInfo.created != null) {
                jsonGenerator.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(mobileDeviceSessionLogInfo.created, jsonGenerator);
            }
            if (mobileDeviceSessionLogInfo.updated != null) {
                jsonGenerator.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(mobileDeviceSessionLogInfo.updated, jsonGenerator);
            }
            if (mobileDeviceSessionLogInfo.sessionInfo != null) {
                jsonGenerator.writeFieldName("session_info");
                StoneSerializers.nullableStruct(MobileSessionLogInfo.Serializer.INSTANCE).serialize(mobileDeviceSessionLogInfo.sessionInfo, jsonGenerator);
            }
            if (mobileDeviceSessionLogInfo.clientVersion != null) {
                jsonGenerator.writeFieldName("client_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(mobileDeviceSessionLogInfo.clientVersion, jsonGenerator);
            }
            if (mobileDeviceSessionLogInfo.osVersion != null) {
                jsonGenerator.writeFieldName("os_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(mobileDeviceSessionLogInfo.osVersion, jsonGenerator);
            }
            if (mobileDeviceSessionLogInfo.lastCarrier != null) {
                jsonGenerator.writeFieldName("last_carrier");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(mobileDeviceSessionLogInfo.lastCarrier, jsonGenerator);
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
        public MobileDeviceSessionLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("mobile_device_session".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String strDeserialize = null;
                MobileClientPlatform mobileClientPlatformDeserialize = null;
                String str = null;
                Date date = null;
                Date date2 = null;
                MobileSessionLogInfo mobileSessionLogInfo = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("device_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("client_type".equals(currentName)) {
                        mobileClientPlatformDeserialize = MobileClientPlatform.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("ip_address".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("updated".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("session_info".equals(currentName)) {
                        mobileSessionLogInfo = (MobileSessionLogInfo) StoneSerializers.nullableStruct(MobileSessionLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("client_version".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("os_version".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("last_carrier".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"device_name\" missing.");
                }
                if (mobileClientPlatformDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"client_type\" missing.");
                }
                MobileDeviceSessionLogInfo mobileDeviceSessionLogInfo = new MobileDeviceSessionLogInfo(strDeserialize, mobileClientPlatformDeserialize, str, date, date2, mobileSessionLogInfo, str2, str3, str4);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(mobileDeviceSessionLogInfo, mobileDeviceSessionLogInfo.toStringMultiline());
                return mobileDeviceSessionLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
