package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.SessionLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class LegacyDeviceSessionLogInfo extends DeviceSessionLogInfo {

    @Nullable
    protected final String clientVersion;

    @Nullable
    protected final String deviceType;

    @Nullable
    protected final String displayName;

    @Nullable
    protected final Boolean isEmmManaged;

    @Nullable
    protected final String legacyUniqId;

    @Nullable
    protected final String macAddress;

    @Nullable
    protected final String osVersion;

    @Nullable
    protected final String platform;

    @Nullable
    protected final SessionLogInfo sessionInfo;

    public LegacyDeviceSessionLogInfo(@Nullable String str, @Nullable Date date, @Nullable Date date2, @Nullable SessionLogInfo sessionLogInfo, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        super(str, date, date2);
        this.sessionInfo = sessionLogInfo;
        this.displayName = str2;
        this.isEmmManaged = bool;
        this.platform = str3;
        this.macAddress = str4;
        this.osVersion = str5;
        this.deviceType = str6;
        this.clientVersion = str7;
        this.legacyUniqId = str8;
    }

    public LegacyDeviceSessionLogInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null);
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
    public SessionLogInfo getSessionInfo() {
        return this.sessionInfo;
    }

    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public Boolean getIsEmmManaged() {
        return this.isEmmManaged;
    }

    @Nullable
    public String getPlatform() {
        return this.platform;
    }

    @Nullable
    public String getMacAddress() {
        return this.macAddress;
    }

    @Nullable
    public String getOsVersion() {
        return this.osVersion;
    }

    @Nullable
    public String getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    public String getClientVersion() {
        return this.clientVersion;
    }

    @Nullable
    public String getLegacyUniqId() {
        return this.legacyUniqId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder extends DeviceSessionLogInfo.Builder {
        protected SessionLogInfo sessionInfo = null;
        protected String displayName = null;
        protected Boolean isEmmManaged = null;
        protected String platform = null;
        protected String macAddress = null;
        protected String osVersion = null;
        protected String deviceType = null;
        protected String clientVersion = null;
        protected String legacyUniqId = null;

        protected Builder() {
        }

        public Builder withSessionInfo(SessionLogInfo sessionLogInfo) {
            this.sessionInfo = sessionLogInfo;
            return this;
        }

        public Builder withDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public Builder withIsEmmManaged(Boolean bool) {
            this.isEmmManaged = bool;
            return this;
        }

        public Builder withPlatform(String str) {
            this.platform = str;
            return this;
        }

        public Builder withMacAddress(String str) {
            this.macAddress = str;
            return this;
        }

        public Builder withOsVersion(String str) {
            this.osVersion = str;
            return this;
        }

        public Builder withDeviceType(String str) {
            this.deviceType = str;
            return this;
        }

        public Builder withClientVersion(String str) {
            this.clientVersion = str;
            return this;
        }

        public Builder withLegacyUniqId(String str) {
            this.legacyUniqId = str;
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
        public LegacyDeviceSessionLogInfo build() {
            return new LegacyDeviceSessionLogInfo(this.ipAddress, this.created, this.updated, this.sessionInfo, this.displayName, this.isEmmManaged, this.platform, this.macAddress, this.osVersion, this.deviceType, this.clientVersion, this.legacyUniqId);
        }
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.sessionInfo, this.displayName, this.isEmmManaged, this.platform, this.macAddress, this.osVersion, this.deviceType, this.clientVersion, this.legacyUniqId});
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public boolean equals(Object obj) {
        SessionLogInfo sessionLogInfo;
        SessionLogInfo sessionLogInfo2;
        String str;
        String str2;
        Boolean bool;
        Boolean bool2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LegacyDeviceSessionLogInfo legacyDeviceSessionLogInfo = (LegacyDeviceSessionLogInfo) obj;
        return (this.ipAddress == legacyDeviceSessionLogInfo.ipAddress || (this.ipAddress != null && this.ipAddress.equals(legacyDeviceSessionLogInfo.ipAddress))) && (this.created == legacyDeviceSessionLogInfo.created || (this.created != null && this.created.equals(legacyDeviceSessionLogInfo.created))) && ((this.updated == legacyDeviceSessionLogInfo.updated || (this.updated != null && this.updated.equals(legacyDeviceSessionLogInfo.updated))) && (((sessionLogInfo = this.sessionInfo) == (sessionLogInfo2 = legacyDeviceSessionLogInfo.sessionInfo) || (sessionLogInfo != null && sessionLogInfo.equals(sessionLogInfo2))) && (((str = this.displayName) == (str2 = legacyDeviceSessionLogInfo.displayName) || (str != null && str.equals(str2))) && (((bool = this.isEmmManaged) == (bool2 = legacyDeviceSessionLogInfo.isEmmManaged) || (bool != null && bool.equals(bool2))) && (((str3 = this.platform) == (str4 = legacyDeviceSessionLogInfo.platform) || (str3 != null && str3.equals(str4))) && (((str5 = this.macAddress) == (str6 = legacyDeviceSessionLogInfo.macAddress) || (str5 != null && str5.equals(str6))) && (((str7 = this.osVersion) == (str8 = legacyDeviceSessionLogInfo.osVersion) || (str7 != null && str7.equals(str8))) && (((str9 = this.deviceType) == (str10 = legacyDeviceSessionLogInfo.deviceType) || (str9 != null && str9.equals(str10))) && (((str11 = this.clientVersion) == (str12 = legacyDeviceSessionLogInfo.clientVersion) || (str11 != null && str11.equals(str12))) && ((str13 = this.legacyUniqId) == (str14 = legacyDeviceSessionLogInfo.legacyUniqId) || (str13 != null && str13.equals(str14))))))))))));
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegacyDeviceSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegacyDeviceSessionLogInfo legacyDeviceSessionLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("legacy_device_session", jsonGenerator);
            if (legacyDeviceSessionLogInfo.ipAddress != null) {
                jsonGenerator.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legacyDeviceSessionLogInfo.ipAddress, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.created != null) {
                jsonGenerator.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(legacyDeviceSessionLogInfo.created, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.updated != null) {
                jsonGenerator.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(legacyDeviceSessionLogInfo.updated, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.sessionInfo != null) {
                jsonGenerator.writeFieldName("session_info");
                StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).serialize(legacyDeviceSessionLogInfo.sessionInfo, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legacyDeviceSessionLogInfo.displayName, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.isEmmManaged != null) {
                jsonGenerator.writeFieldName("is_emm_managed");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(legacyDeviceSessionLogInfo.isEmmManaged, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.platform != null) {
                jsonGenerator.writeFieldName(DeviceDimensionProvider.KEY_PLATFORM);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legacyDeviceSessionLogInfo.platform, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.macAddress != null) {
                jsonGenerator.writeFieldName("mac_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legacyDeviceSessionLogInfo.macAddress, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.osVersion != null) {
                jsonGenerator.writeFieldName("os_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legacyDeviceSessionLogInfo.osVersion, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.deviceType != null) {
                jsonGenerator.writeFieldName("device_type");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legacyDeviceSessionLogInfo.deviceType, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.clientVersion != null) {
                jsonGenerator.writeFieldName("client_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legacyDeviceSessionLogInfo.clientVersion, jsonGenerator);
            }
            if (legacyDeviceSessionLogInfo.legacyUniqId != null) {
                jsonGenerator.writeFieldName("legacy_uniq_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legacyDeviceSessionLogInfo.legacyUniqId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
        @Override // com.dropbox.core.stone.StructSerializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public LegacyDeviceSessionLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("legacy_device_session".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String str = null;
                Date date = null;
                Date date2 = null;
                SessionLogInfo sessionLogInfo = null;
                String str2 = null;
                Boolean bool = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                String str7 = null;
                String str8 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("ip_address".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("updated".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("session_info".equals(currentName)) {
                        sessionLogInfo = (SessionLogInfo) StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("is_emm_managed".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if (DeviceDimensionProvider.KEY_PLATFORM.equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("mac_address".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("os_version".equals(currentName)) {
                        str5 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("device_type".equals(currentName)) {
                        str6 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("client_version".equals(currentName)) {
                        str7 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("legacy_uniq_id".equals(currentName)) {
                        str8 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                LegacyDeviceSessionLogInfo legacyDeviceSessionLogInfo = new LegacyDeviceSessionLogInfo(str, date, date2, sessionLogInfo, str2, bool, str3, str4, str5, str6, str7, str8);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legacyDeviceSessionLogInfo, legacyDeviceSessionLogInfo.toStringMultiline());
                return legacyDeviceSessionLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
