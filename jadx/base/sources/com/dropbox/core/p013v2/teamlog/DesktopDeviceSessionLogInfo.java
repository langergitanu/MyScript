package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.team.DesktopPlatform;
import com.dropbox.core.p013v2.teamlog.DesktopSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class DesktopDeviceSessionLogInfo extends DeviceSessionLogInfo {

    @Nonnull
    protected final DesktopPlatform clientType;

    @Nullable
    protected final String clientVersion;

    @Nonnull
    protected final String hostName;
    protected final boolean isDeleteOnUnlinkSupported;

    @Nonnull
    protected final String platform;

    @Nullable
    protected final DesktopSessionLogInfo sessionInfo;

    public DesktopDeviceSessionLogInfo(@Nonnull String str, @Nonnull DesktopPlatform desktopPlatform, @Nonnull String str2, boolean z, @Nullable String str3, @Nullable Date date, @Nullable Date date2, @Nullable DesktopSessionLogInfo desktopSessionLogInfo, @Nullable String str4) {
        super(str3, date, date2);
        this.sessionInfo = desktopSessionLogInfo;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'hostName' is null");
        }
        this.hostName = str;
        if (desktopPlatform == null) {
            throw new IllegalArgumentException("Required value for 'clientType' is null");
        }
        this.clientType = desktopPlatform;
        this.clientVersion = str4;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'platform' is null");
        }
        this.platform = str2;
        this.isDeleteOnUnlinkSupported = z;
    }

    public DesktopDeviceSessionLogInfo(@Nonnull String str, @Nonnull DesktopPlatform desktopPlatform, @Nonnull String str2, boolean z) {
        this(str, desktopPlatform, str2, z, null, null, null, null, null);
    }

    @Nonnull
    public String getHostName() {
        return this.hostName;
    }

    @Nonnull
    public DesktopPlatform getClientType() {
        return this.clientType;
    }

    @Nonnull
    public String getPlatform() {
        return this.platform;
    }

    public boolean getIsDeleteOnUnlinkSupported() {
        return this.isDeleteOnUnlinkSupported;
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
    public DesktopSessionLogInfo getSessionInfo() {
        return this.sessionInfo;
    }

    @Nullable
    public String getClientVersion() {
        return this.clientVersion;
    }

    public static Builder newBuilder(String str, DesktopPlatform desktopPlatform, String str2, boolean z) {
        return new Builder(str, desktopPlatform, str2, z);
    }

    public static class Builder extends DeviceSessionLogInfo.Builder {
        protected final DesktopPlatform clientType;
        protected String clientVersion;
        protected final String hostName;
        protected final boolean isDeleteOnUnlinkSupported;
        protected final String platform;
        protected DesktopSessionLogInfo sessionInfo;

        protected Builder(String str, DesktopPlatform desktopPlatform, String str2, boolean z) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'hostName' is null");
            }
            this.hostName = str;
            if (desktopPlatform == null) {
                throw new IllegalArgumentException("Required value for 'clientType' is null");
            }
            this.clientType = desktopPlatform;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'platform' is null");
            }
            this.platform = str2;
            this.isDeleteOnUnlinkSupported = z;
            this.sessionInfo = null;
            this.clientVersion = null;
        }

        public Builder withSessionInfo(DesktopSessionLogInfo desktopSessionLogInfo) {
            this.sessionInfo = desktopSessionLogInfo;
            return this;
        }

        public Builder withClientVersion(String str) {
            this.clientVersion = str;
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
        public DesktopDeviceSessionLogInfo build() {
            return new DesktopDeviceSessionLogInfo(this.hostName, this.clientType, this.platform, this.isDeleteOnUnlinkSupported, this.ipAddress, this.created, this.updated, this.sessionInfo, this.clientVersion);
        }
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.sessionInfo, this.hostName, this.clientType, this.clientVersion, this.platform, Boolean.valueOf(this.isDeleteOnUnlinkSupported)});
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public boolean equals(Object obj) {
        DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo;
        String str;
        String str2;
        DesktopPlatform desktopPlatform;
        DesktopPlatform desktopPlatform2;
        String str3;
        String str4;
        DesktopSessionLogInfo desktopSessionLogInfo;
        DesktopSessionLogInfo desktopSessionLogInfo2;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.hostName) == (str2 = (desktopDeviceSessionLogInfo = (DesktopDeviceSessionLogInfo) obj).hostName) || str.equals(str2)) && (((desktopPlatform = this.clientType) == (desktopPlatform2 = desktopDeviceSessionLogInfo.clientType) || desktopPlatform.equals(desktopPlatform2)) && (((str3 = this.platform) == (str4 = desktopDeviceSessionLogInfo.platform) || str3.equals(str4)) && this.isDeleteOnUnlinkSupported == desktopDeviceSessionLogInfo.isDeleteOnUnlinkSupported && ((this.ipAddress == desktopDeviceSessionLogInfo.ipAddress || (this.ipAddress != null && this.ipAddress.equals(desktopDeviceSessionLogInfo.ipAddress))) && ((this.created == desktopDeviceSessionLogInfo.created || (this.created != null && this.created.equals(desktopDeviceSessionLogInfo.created))) && ((this.updated == desktopDeviceSessionLogInfo.updated || (this.updated != null && this.updated.equals(desktopDeviceSessionLogInfo.updated))) && (((desktopSessionLogInfo = this.sessionInfo) == (desktopSessionLogInfo2 = desktopDeviceSessionLogInfo.sessionInfo) || (desktopSessionLogInfo != null && desktopSessionLogInfo.equals(desktopSessionLogInfo2))) && ((str5 = this.clientVersion) == (str6 = desktopDeviceSessionLogInfo.clientVersion) || (str5 != null && str5.equals(str6)))))))));
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DesktopDeviceSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("desktop_device_session", jsonGenerator);
            jsonGenerator.writeFieldName("host_name");
            StoneSerializers.string().serialize(desktopDeviceSessionLogInfo.hostName, jsonGenerator);
            jsonGenerator.writeFieldName("client_type");
            DesktopPlatform.Serializer.INSTANCE.serialize(desktopDeviceSessionLogInfo.clientType, jsonGenerator);
            jsonGenerator.writeFieldName(DeviceDimensionProvider.KEY_PLATFORM);
            StoneSerializers.string().serialize(desktopDeviceSessionLogInfo.platform, jsonGenerator);
            jsonGenerator.writeFieldName("is_delete_on_unlink_supported");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(desktopDeviceSessionLogInfo.isDeleteOnUnlinkSupported), jsonGenerator);
            if (desktopDeviceSessionLogInfo.ipAddress != null) {
                jsonGenerator.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(desktopDeviceSessionLogInfo.ipAddress, jsonGenerator);
            }
            if (desktopDeviceSessionLogInfo.created != null) {
                jsonGenerator.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(desktopDeviceSessionLogInfo.created, jsonGenerator);
            }
            if (desktopDeviceSessionLogInfo.updated != null) {
                jsonGenerator.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(desktopDeviceSessionLogInfo.updated, jsonGenerator);
            }
            if (desktopDeviceSessionLogInfo.sessionInfo != null) {
                jsonGenerator.writeFieldName("session_info");
                StoneSerializers.nullableStruct(DesktopSessionLogInfo.Serializer.INSTANCE).serialize(desktopDeviceSessionLogInfo.sessionInfo, jsonGenerator);
            }
            if (desktopDeviceSessionLogInfo.clientVersion != null) {
                jsonGenerator.writeFieldName("client_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(desktopDeviceSessionLogInfo.clientVersion, jsonGenerator);
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
        public DesktopDeviceSessionLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("desktop_device_session".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String strDeserialize = null;
                DesktopPlatform desktopPlatformDeserialize = null;
                String strDeserialize2 = null;
                String str = null;
                Date date = null;
                Date date2 = null;
                DesktopSessionLogInfo desktopSessionLogInfo = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("host_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("client_type".equals(currentName)) {
                        desktopPlatformDeserialize = DesktopPlatform.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (DeviceDimensionProvider.KEY_PLATFORM.equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("is_delete_on_unlink_supported".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("ip_address".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("updated".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("session_info".equals(currentName)) {
                        desktopSessionLogInfo = (DesktopSessionLogInfo) StoneSerializers.nullableStruct(DesktopSessionLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("client_version".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"host_name\" missing.");
                }
                if (desktopPlatformDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"client_type\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"platform\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_delete_on_unlink_supported\" missing.");
                }
                DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo = new DesktopDeviceSessionLogInfo(strDeserialize, desktopPlatformDeserialize, strDeserialize2, boolDeserialize.booleanValue(), str, date, date2, desktopSessionLogInfo, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(desktopDeviceSessionLogInfo, desktopDeviceSessionLogInfo.toStringMultiline());
                return desktopDeviceSessionLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
