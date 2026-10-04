package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.DesktopPlatform;
import com.dropbox.core.p013v2.team.DeviceSession;
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
public class DesktopClientSession extends DeviceSession {

    @Nonnull
    protected final DesktopPlatform clientType;

    @Nonnull
    protected final String clientVersion;

    @Nonnull
    protected final String hostName;
    protected final boolean isDeleteOnUnlinkSupported;

    @Nonnull
    protected final String platform;

    public DesktopClientSession(@Nonnull String str, @Nonnull String str2, @Nonnull DesktopPlatform desktopPlatform, @Nonnull String str3, @Nonnull String str4, boolean z, @Nullable String str5, @Nullable String str6, @Nullable Date date, @Nullable Date date2) {
        super(str, str5, str6, date, date2);
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'hostName' is null");
        }
        this.hostName = str2;
        if (desktopPlatform == null) {
            throw new IllegalArgumentException("Required value for 'clientType' is null");
        }
        this.clientType = desktopPlatform;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'clientVersion' is null");
        }
        this.clientVersion = str3;
        if (str4 == null) {
            throw new IllegalArgumentException("Required value for 'platform' is null");
        }
        this.platform = str4;
        this.isDeleteOnUnlinkSupported = z;
    }

    public DesktopClientSession(@Nonnull String str, @Nonnull String str2, @Nonnull DesktopPlatform desktopPlatform, @Nonnull String str3, @Nonnull String str4, boolean z) {
        this(str, str2, desktopPlatform, str3, str4, z, null, null, null, null);
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    @Nonnull
    public String getSessionId() {
        return this.sessionId;
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
    public String getClientVersion() {
        return this.clientVersion;
    }

    @Nonnull
    public String getPlatform() {
        return this.platform;
    }

    public boolean getIsDeleteOnUnlinkSupported() {
        return this.isDeleteOnUnlinkSupported;
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    @Nullable
    public String getIpAddress() {
        return this.ipAddress;
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    @Nullable
    public String getCountry() {
        return this.country;
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    @Nullable
    public Date getCreated() {
        return this.created;
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    @Nullable
    public Date getUpdated() {
        return this.updated;
    }

    public static Builder newBuilder(String str, String str2, DesktopPlatform desktopPlatform, String str3, String str4, boolean z) {
        return new Builder(str, str2, desktopPlatform, str3, str4, z);
    }

    public static class Builder extends DeviceSession.Builder {
        protected final DesktopPlatform clientType;
        protected final String clientVersion;
        protected final String hostName;
        protected final boolean isDeleteOnUnlinkSupported;
        protected final String platform;

        protected Builder(String str, String str2, DesktopPlatform desktopPlatform, String str3, String str4, boolean z) {
            super(str);
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'hostName' is null");
            }
            this.hostName = str2;
            if (desktopPlatform == null) {
                throw new IllegalArgumentException("Required value for 'clientType' is null");
            }
            this.clientType = desktopPlatform;
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'clientVersion' is null");
            }
            this.clientVersion = str3;
            if (str4 == null) {
                throw new IllegalArgumentException("Required value for 'platform' is null");
            }
            this.platform = str4;
            this.isDeleteOnUnlinkSupported = z;
        }

        @Override // com.dropbox.core.v2.team.DeviceSession.Builder
        public Builder withIpAddress(String str) {
            super.withIpAddress(str);
            return this;
        }

        @Override // com.dropbox.core.v2.team.DeviceSession.Builder
        public Builder withCountry(String str) {
            super.withCountry(str);
            return this;
        }

        @Override // com.dropbox.core.v2.team.DeviceSession.Builder
        public Builder withCreated(Date date) {
            super.withCreated(date);
            return this;
        }

        @Override // com.dropbox.core.v2.team.DeviceSession.Builder
        public Builder withUpdated(Date date) {
            super.withUpdated(date);
            return this;
        }

        @Override // com.dropbox.core.v2.team.DeviceSession.Builder
        public DesktopClientSession build() {
            return new DesktopClientSession(this.sessionId, this.hostName, this.clientType, this.clientVersion, this.platform, this.isDeleteOnUnlinkSupported, this.ipAddress, this.country, this.created, this.updated);
        }
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.hostName, this.clientType, this.clientVersion, this.platform, Boolean.valueOf(this.isDeleteOnUnlinkSupported)});
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public boolean equals(Object obj) {
        String str;
        String str2;
        DesktopPlatform desktopPlatform;
        DesktopPlatform desktopPlatform2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            DesktopClientSession desktopClientSession = (DesktopClientSession) obj;
            if ((this.sessionId == desktopClientSession.sessionId || this.sessionId.equals(desktopClientSession.sessionId)) && (((str = this.hostName) == (str2 = desktopClientSession.hostName) || str.equals(str2)) && (((desktopPlatform = this.clientType) == (desktopPlatform2 = desktopClientSession.clientType) || desktopPlatform.equals(desktopPlatform2)) && (((str3 = this.clientVersion) == (str4 = desktopClientSession.clientVersion) || str3.equals(str4)) && (((str5 = this.platform) == (str6 = desktopClientSession.platform) || str5.equals(str6)) && this.isDeleteOnUnlinkSupported == desktopClientSession.isDeleteOnUnlinkSupported && ((this.ipAddress == desktopClientSession.ipAddress || (this.ipAddress != null && this.ipAddress.equals(desktopClientSession.ipAddress))) && ((this.country == desktopClientSession.country || (this.country != null && this.country.equals(desktopClientSession.country))) && ((this.created == desktopClientSession.created || (this.created != null && this.created.equals(desktopClientSession.created))) && (this.updated == desktopClientSession.updated || (this.updated != null && this.updated.equals(desktopClientSession.updated))))))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DesktopClientSession> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DesktopClientSession desktopClientSession, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("session_id");
            StoneSerializers.string().serialize(desktopClientSession.sessionId, jsonGenerator);
            jsonGenerator.writeFieldName("host_name");
            StoneSerializers.string().serialize(desktopClientSession.hostName, jsonGenerator);
            jsonGenerator.writeFieldName("client_type");
            DesktopPlatform.Serializer.INSTANCE.serialize(desktopClientSession.clientType, jsonGenerator);
            jsonGenerator.writeFieldName("client_version");
            StoneSerializers.string().serialize(desktopClientSession.clientVersion, jsonGenerator);
            jsonGenerator.writeFieldName(DeviceDimensionProvider.KEY_PLATFORM);
            StoneSerializers.string().serialize(desktopClientSession.platform, jsonGenerator);
            jsonGenerator.writeFieldName("is_delete_on_unlink_supported");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(desktopClientSession.isDeleteOnUnlinkSupported), jsonGenerator);
            if (desktopClientSession.ipAddress != null) {
                jsonGenerator.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(desktopClientSession.ipAddress, jsonGenerator);
            }
            if (desktopClientSession.country != null) {
                jsonGenerator.writeFieldName("country");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(desktopClientSession.country, jsonGenerator);
            }
            if (desktopClientSession.created != null) {
                jsonGenerator.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(desktopClientSession.created, jsonGenerator);
            }
            if (desktopClientSession.updated != null) {
                jsonGenerator.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(desktopClientSession.updated, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DesktopClientSession deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                DesktopPlatform desktopPlatformDeserialize = null;
                String strDeserialize3 = null;
                String strDeserialize4 = null;
                String str = null;
                String str2 = null;
                Date date = null;
                Date date2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("session_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("host_name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("client_type".equals(currentName)) {
                        desktopPlatformDeserialize = DesktopPlatform.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("client_version".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if (DeviceDimensionProvider.KEY_PLATFORM.equals(currentName)) {
                        strDeserialize4 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("is_delete_on_unlink_supported".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("ip_address".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("country".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("updated".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"session_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"host_name\" missing.");
                }
                if (desktopPlatformDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"client_type\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"client_version\" missing.");
                }
                if (strDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"platform\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_delete_on_unlink_supported\" missing.");
                }
                DesktopClientSession desktopClientSession = new DesktopClientSession(strDeserialize, strDeserialize2, desktopPlatformDeserialize, strDeserialize3, strDeserialize4, boolDeserialize.booleanValue(), str, str2, date, date2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(desktopClientSession, desktopClientSession.toStringMultiline());
                return desktopClientSession;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
