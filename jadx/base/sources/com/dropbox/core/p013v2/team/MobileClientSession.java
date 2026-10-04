package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.DeviceSession;
import com.dropbox.core.p013v2.team.MobileClientPlatform;
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
public class MobileClientSession extends DeviceSession {

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

    public MobileClientSession(@Nonnull String str, @Nonnull String str2, @Nonnull MobileClientPlatform mobileClientPlatform, @Nullable String str3, @Nullable String str4, @Nullable Date date, @Nullable Date date2, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        super(str, str3, str4, date, date2);
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'deviceName' is null");
        }
        this.deviceName = str2;
        if (mobileClientPlatform == null) {
            throw new IllegalArgumentException("Required value for 'clientType' is null");
        }
        this.clientType = mobileClientPlatform;
        this.clientVersion = str5;
        this.osVersion = str6;
        this.lastCarrier = str7;
    }

    public MobileClientSession(@Nonnull String str, @Nonnull String str2, @Nonnull MobileClientPlatform mobileClientPlatform) {
        this(str, str2, mobileClientPlatform, null, null, null, null, null, null, null);
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    @Nonnull
    public String getSessionId() {
        return this.sessionId;
    }

    @Nonnull
    public String getDeviceName() {
        return this.deviceName;
    }

    @Nonnull
    public MobileClientPlatform getClientType() {
        return this.clientType;
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

    public static Builder newBuilder(String str, String str2, MobileClientPlatform mobileClientPlatform) {
        return new Builder(str, str2, mobileClientPlatform);
    }

    public static class Builder extends DeviceSession.Builder {
        protected final MobileClientPlatform clientType;
        protected String clientVersion;
        protected final String deviceName;
        protected String lastCarrier;
        protected String osVersion;

        protected Builder(String str, String str2, MobileClientPlatform mobileClientPlatform) {
            super(str);
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'deviceName' is null");
            }
            this.deviceName = str2;
            if (mobileClientPlatform == null) {
                throw new IllegalArgumentException("Required value for 'clientType' is null");
            }
            this.clientType = mobileClientPlatform;
            this.clientVersion = null;
            this.osVersion = null;
            this.lastCarrier = null;
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
        public MobileClientSession build() {
            return new MobileClientSession(this.sessionId, this.deviceName, this.clientType, this.ipAddress, this.country, this.created, this.updated, this.clientVersion, this.osVersion, this.lastCarrier);
        }
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.deviceName, this.clientType, this.clientVersion, this.osVersion, this.lastCarrier});
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public boolean equals(Object obj) {
        String str;
        String str2;
        MobileClientPlatform mobileClientPlatform;
        MobileClientPlatform mobileClientPlatform2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MobileClientSession mobileClientSession = (MobileClientSession) obj;
        return (this.sessionId == mobileClientSession.sessionId || this.sessionId.equals(mobileClientSession.sessionId)) && ((str = this.deviceName) == (str2 = mobileClientSession.deviceName) || str.equals(str2)) && (((mobileClientPlatform = this.clientType) == (mobileClientPlatform2 = mobileClientSession.clientType) || mobileClientPlatform.equals(mobileClientPlatform2)) && ((this.ipAddress == mobileClientSession.ipAddress || (this.ipAddress != null && this.ipAddress.equals(mobileClientSession.ipAddress))) && ((this.country == mobileClientSession.country || (this.country != null && this.country.equals(mobileClientSession.country))) && ((this.created == mobileClientSession.created || (this.created != null && this.created.equals(mobileClientSession.created))) && ((this.updated == mobileClientSession.updated || (this.updated != null && this.updated.equals(mobileClientSession.updated))) && (((str3 = this.clientVersion) == (str4 = mobileClientSession.clientVersion) || (str3 != null && str3.equals(str4))) && (((str5 = this.osVersion) == (str6 = mobileClientSession.osVersion) || (str5 != null && str5.equals(str6))) && ((str7 = this.lastCarrier) == (str8 = mobileClientSession.lastCarrier) || (str7 != null && str7.equals(str8))))))))));
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MobileClientSession> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MobileClientSession mobileClientSession, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("session_id");
            StoneSerializers.string().serialize(mobileClientSession.sessionId, jsonGenerator);
            jsonGenerator.writeFieldName("device_name");
            StoneSerializers.string().serialize(mobileClientSession.deviceName, jsonGenerator);
            jsonGenerator.writeFieldName("client_type");
            MobileClientPlatform.Serializer.INSTANCE.serialize(mobileClientSession.clientType, jsonGenerator);
            if (mobileClientSession.ipAddress != null) {
                jsonGenerator.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(mobileClientSession.ipAddress, jsonGenerator);
            }
            if (mobileClientSession.country != null) {
                jsonGenerator.writeFieldName("country");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(mobileClientSession.country, jsonGenerator);
            }
            if (mobileClientSession.created != null) {
                jsonGenerator.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(mobileClientSession.created, jsonGenerator);
            }
            if (mobileClientSession.updated != null) {
                jsonGenerator.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(mobileClientSession.updated, jsonGenerator);
            }
            if (mobileClientSession.clientVersion != null) {
                jsonGenerator.writeFieldName("client_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(mobileClientSession.clientVersion, jsonGenerator);
            }
            if (mobileClientSession.osVersion != null) {
                jsonGenerator.writeFieldName("os_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(mobileClientSession.osVersion, jsonGenerator);
            }
            if (mobileClientSession.lastCarrier != null) {
                jsonGenerator.writeFieldName("last_carrier");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(mobileClientSession.lastCarrier, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MobileClientSession deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                MobileClientPlatform mobileClientPlatformDeserialize = null;
                String str = null;
                String str2 = null;
                Date date = null;
                Date date2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("session_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("device_name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("client_type".equals(currentName)) {
                        mobileClientPlatformDeserialize = MobileClientPlatform.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("ip_address".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("country".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("updated".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("client_version".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("os_version".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("last_carrier".equals(currentName)) {
                        str5 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"session_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"device_name\" missing.");
                }
                if (mobileClientPlatformDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"client_type\" missing.");
                }
                MobileClientSession mobileClientSession = new MobileClientSession(strDeserialize, strDeserialize2, mobileClientPlatformDeserialize, str, str2, date, date2, str3, str4, str5);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(mobileClientSession, mobileClientSession.toStringMultiline());
                return mobileClientSession;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
