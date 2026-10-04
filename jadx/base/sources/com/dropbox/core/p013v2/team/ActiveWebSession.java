package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.DeviceSession;
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
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes5.dex */
public class ActiveWebSession extends DeviceSession {

    @Nonnull
    protected final String browser;

    @Nullable
    protected final Date expires;

    /* JADX INFO: renamed from: os */
    @Nonnull
    protected final String f742os;

    @Nonnull
    protected final String userAgent;

    public ActiveWebSession(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4, @Nullable String str5, @Nullable String str6, @Nullable Date date, @Nullable Date date2, @Nullable Date date3) {
        super(str, str5, str6, date, date2);
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'userAgent' is null");
        }
        this.userAgent = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'os' is null");
        }
        this.f742os = str3;
        if (str4 == null) {
            throw new IllegalArgumentException("Required value for 'browser' is null");
        }
        this.browser = str4;
        this.expires = LangUtil.truncateMillis(date3);
    }

    public ActiveWebSession(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4) {
        this(str, str2, str3, str4, null, null, null, null, null);
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    @Nonnull
    public String getSessionId() {
        return this.sessionId;
    }

    @Nonnull
    public String getUserAgent() {
        return this.userAgent;
    }

    @Nonnull
    public String getOs() {
        return this.f742os;
    }

    @Nonnull
    public String getBrowser() {
        return this.browser;
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
    public Date getExpires() {
        return this.expires;
    }

    public static Builder newBuilder(String str, String str2, String str3, String str4) {
        return new Builder(str, str2, str3, str4);
    }

    public static class Builder extends DeviceSession.Builder {
        protected final String browser;
        protected Date expires;

        /* JADX INFO: renamed from: os */
        protected final String f743os;
        protected final String userAgent;

        protected Builder(String str, String str2, String str3, String str4) {
            super(str);
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'userAgent' is null");
            }
            this.userAgent = str2;
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'os' is null");
            }
            this.f743os = str3;
            if (str4 == null) {
                throw new IllegalArgumentException("Required value for 'browser' is null");
            }
            this.browser = str4;
            this.expires = null;
        }

        public Builder withExpires(Date date) {
            this.expires = LangUtil.truncateMillis(date);
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
        public ActiveWebSession build() {
            return new ActiveWebSession(this.sessionId, this.userAgent, this.f743os, this.browser, this.ipAddress, this.country, this.created, this.updated, this.expires);
        }
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.userAgent, this.f742os, this.browser, this.expires});
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ActiveWebSession activeWebSession = (ActiveWebSession) obj;
        return (this.sessionId == activeWebSession.sessionId || this.sessionId.equals(activeWebSession.sessionId)) && ((str = this.userAgent) == (str2 = activeWebSession.userAgent) || str.equals(str2)) && (((str3 = this.f742os) == (str4 = activeWebSession.f742os) || str3.equals(str4)) && (((str5 = this.browser) == (str6 = activeWebSession.browser) || str5.equals(str6)) && ((this.ipAddress == activeWebSession.ipAddress || (this.ipAddress != null && this.ipAddress.equals(activeWebSession.ipAddress))) && ((this.country == activeWebSession.country || (this.country != null && this.country.equals(activeWebSession.country))) && ((this.created == activeWebSession.created || (this.created != null && this.created.equals(activeWebSession.created))) && ((this.updated == activeWebSession.updated || (this.updated != null && this.updated.equals(activeWebSession.updated))) && ((date = this.expires) == (date2 = activeWebSession.expires) || (date != null && date.equals(date2)))))))));
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.DeviceSession
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ActiveWebSession> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ActiveWebSession activeWebSession, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("session_id");
            StoneSerializers.string().serialize(activeWebSession.sessionId, jsonGenerator);
            jsonGenerator.writeFieldName("user_agent");
            StoneSerializers.string().serialize(activeWebSession.userAgent, jsonGenerator);
            jsonGenerator.writeFieldName("os");
            StoneSerializers.string().serialize(activeWebSession.f742os, jsonGenerator);
            jsonGenerator.writeFieldName("browser");
            StoneSerializers.string().serialize(activeWebSession.browser, jsonGenerator);
            if (activeWebSession.ipAddress != null) {
                jsonGenerator.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(activeWebSession.ipAddress, jsonGenerator);
            }
            if (activeWebSession.country != null) {
                jsonGenerator.writeFieldName("country");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(activeWebSession.country, jsonGenerator);
            }
            if (activeWebSession.created != null) {
                jsonGenerator.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(activeWebSession.created, jsonGenerator);
            }
            if (activeWebSession.updated != null) {
                jsonGenerator.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(activeWebSession.updated, jsonGenerator);
            }
            if (activeWebSession.expires != null) {
                jsonGenerator.writeFieldName(ClientCookie.EXPIRES_ATTR);
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(activeWebSession.expires, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ActiveWebSession deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String strDeserialize3 = null;
                String strDeserialize4 = null;
                String str = null;
                String str2 = null;
                Date date = null;
                Date date2 = null;
                Date date3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("session_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("user_agent".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("os".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("browser".equals(currentName)) {
                        strDeserialize4 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("ip_address".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("country".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("updated".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if (ClientCookie.EXPIRES_ATTR.equals(currentName)) {
                        date3 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"session_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user_agent\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"os\" missing.");
                }
                if (strDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"browser\" missing.");
                }
                ActiveWebSession activeWebSession = new ActiveWebSession(strDeserialize, strDeserialize2, strDeserialize3, strDeserialize4, str, str2, date, date2, date3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(activeWebSession, activeWebSession.toStringMultiline());
                return activeWebSession;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
