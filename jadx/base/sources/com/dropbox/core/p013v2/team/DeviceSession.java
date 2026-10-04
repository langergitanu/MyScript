package com.dropbox.core.p013v2.team;

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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceSession {

    @Nullable
    protected final String country;

    @Nullable
    protected final Date created;

    @Nullable
    protected final String ipAddress;

    @Nonnull
    protected final String sessionId;

    @Nullable
    protected final Date updated;

    public DeviceSession(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nullable Date date, @Nullable Date date2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = str;
        this.ipAddress = str2;
        this.country = str3;
        this.created = LangUtil.truncateMillis(date);
        this.updated = LangUtil.truncateMillis(date2);
    }

    public DeviceSession(@Nonnull String str) {
        this(str, null, null, null, null);
    }

    @Nonnull
    public String getSessionId() {
        return this.sessionId;
    }

    @Nullable
    public String getIpAddress() {
        return this.ipAddress;
    }

    @Nullable
    public String getCountry() {
        return this.country;
    }

    @Nullable
    public Date getCreated() {
        return this.created;
    }

    @Nullable
    public Date getUpdated() {
        return this.updated;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected String country;
        protected Date created;
        protected String ipAddress;
        protected final String sessionId;
        protected Date updated;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'sessionId' is null");
            }
            this.sessionId = str;
            this.ipAddress = null;
            this.country = null;
            this.created = null;
            this.updated = null;
        }

        public Builder withIpAddress(String str) {
            this.ipAddress = str;
            return this;
        }

        public Builder withCountry(String str) {
            this.country = str;
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

        public DeviceSession build() {
            return new DeviceSession(this.sessionId, this.ipAddress, this.country, this.created, this.updated);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sessionId, this.ipAddress, this.country, this.created, this.updated});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
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
        DeviceSession deviceSession = (DeviceSession) obj;
        String str5 = this.sessionId;
        String str6 = deviceSession.sessionId;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.ipAddress) == (str2 = deviceSession.ipAddress) || (str != null && str.equals(str2))) && (((str3 = this.country) == (str4 = deviceSession.country) || (str3 != null && str3.equals(str4))) && (((date = this.created) == (date2 = deviceSession.created) || (date != null && date.equals(date2))) && ((date3 = this.updated) == (date4 = deviceSession.updated) || (date3 != null && date3.equals(date4)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    private static class Serializer extends StructSerializer<DeviceSession> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceSession deviceSession, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("session_id");
            StoneSerializers.string().serialize(deviceSession.sessionId, jsonGenerator);
            if (deviceSession.ipAddress != null) {
                jsonGenerator.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deviceSession.ipAddress, jsonGenerator);
            }
            if (deviceSession.country != null) {
                jsonGenerator.writeFieldName("country");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deviceSession.country, jsonGenerator);
            }
            if (deviceSession.created != null) {
                jsonGenerator.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(deviceSession.created, jsonGenerator);
            }
            if (deviceSession.updated != null) {
                jsonGenerator.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(deviceSession.updated, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceSession deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String str = null;
                String str2 = null;
                Date date = null;
                Date date2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("session_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
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
                DeviceSession deviceSession = new DeviceSession(strDeserialize, str, str2, date, date2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceSession, deviceSession.toStringMultiline());
                return deviceSession;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
