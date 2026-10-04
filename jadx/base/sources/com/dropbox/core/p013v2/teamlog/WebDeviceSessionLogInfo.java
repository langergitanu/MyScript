package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.WebSessionLogInfo;
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
public class WebDeviceSessionLogInfo extends DeviceSessionLogInfo {

    @Nonnull
    protected final String browser;

    /* JADX INFO: renamed from: os */
    @Nonnull
    protected final String f801os;

    @Nullable
    protected final WebSessionLogInfo sessionInfo;

    @Nonnull
    protected final String userAgent;

    public WebDeviceSessionLogInfo(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nullable String str4, @Nullable Date date, @Nullable Date date2, @Nullable WebSessionLogInfo webSessionLogInfo) {
        super(str4, date, date2);
        this.sessionInfo = webSessionLogInfo;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'userAgent' is null");
        }
        this.userAgent = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'os' is null");
        }
        this.f801os = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'browser' is null");
        }
        this.browser = str3;
    }

    public WebDeviceSessionLogInfo(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        this(str, str2, str3, null, null, null, null);
    }

    @Nonnull
    public String getUserAgent() {
        return this.userAgent;
    }

    @Nonnull
    public String getOs() {
        return this.f801os;
    }

    @Nonnull
    public String getBrowser() {
        return this.browser;
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
    public WebSessionLogInfo getSessionInfo() {
        return this.sessionInfo;
    }

    public static Builder newBuilder(String str, String str2, String str3) {
        return new Builder(str, str2, str3);
    }

    public static class Builder extends DeviceSessionLogInfo.Builder {
        protected final String browser;

        /* JADX INFO: renamed from: os */
        protected final String f802os;
        protected WebSessionLogInfo sessionInfo;
        protected final String userAgent;

        protected Builder(String str, String str2, String str3) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'userAgent' is null");
            }
            this.userAgent = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'os' is null");
            }
            this.f802os = str2;
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'browser' is null");
            }
            this.browser = str3;
            this.sessionInfo = null;
        }

        public Builder withSessionInfo(WebSessionLogInfo webSessionLogInfo) {
            this.sessionInfo = webSessionLogInfo;
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
        public WebDeviceSessionLogInfo build() {
            return new WebDeviceSessionLogInfo(this.userAgent, this.f802os, this.browser, this.ipAddress, this.created, this.updated, this.sessionInfo);
        }
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.sessionInfo, this.userAgent, this.f801os, this.browser});
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        WebSessionLogInfo webSessionLogInfo;
        WebSessionLogInfo webSessionLogInfo2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        WebDeviceSessionLogInfo webDeviceSessionLogInfo = (WebDeviceSessionLogInfo) obj;
        String str5 = this.userAgent;
        String str6 = webDeviceSessionLogInfo.userAgent;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.f801os) == (str2 = webDeviceSessionLogInfo.f801os) || str.equals(str2)) && (((str3 = this.browser) == (str4 = webDeviceSessionLogInfo.browser) || str3.equals(str4)) && ((this.ipAddress == webDeviceSessionLogInfo.ipAddress || (this.ipAddress != null && this.ipAddress.equals(webDeviceSessionLogInfo.ipAddress))) && ((this.created == webDeviceSessionLogInfo.created || (this.created != null && this.created.equals(webDeviceSessionLogInfo.created))) && ((this.updated == webDeviceSessionLogInfo.updated || (this.updated != null && this.updated.equals(webDeviceSessionLogInfo.updated))) && ((webSessionLogInfo = this.sessionInfo) == (webSessionLogInfo2 = webDeviceSessionLogInfo.sessionInfo) || (webSessionLogInfo != null && webSessionLogInfo.equals(webSessionLogInfo2)))))));
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.DeviceSessionLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<WebDeviceSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(WebDeviceSessionLogInfo webDeviceSessionLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("web_device_session", jsonGenerator);
            jsonGenerator.writeFieldName("user_agent");
            StoneSerializers.string().serialize(webDeviceSessionLogInfo.userAgent, jsonGenerator);
            jsonGenerator.writeFieldName("os");
            StoneSerializers.string().serialize(webDeviceSessionLogInfo.f801os, jsonGenerator);
            jsonGenerator.writeFieldName("browser");
            StoneSerializers.string().serialize(webDeviceSessionLogInfo.browser, jsonGenerator);
            if (webDeviceSessionLogInfo.ipAddress != null) {
                jsonGenerator.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(webDeviceSessionLogInfo.ipAddress, jsonGenerator);
            }
            if (webDeviceSessionLogInfo.created != null) {
                jsonGenerator.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(webDeviceSessionLogInfo.created, jsonGenerator);
            }
            if (webDeviceSessionLogInfo.updated != null) {
                jsonGenerator.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(webDeviceSessionLogInfo.updated, jsonGenerator);
            }
            if (webDeviceSessionLogInfo.sessionInfo != null) {
                jsonGenerator.writeFieldName("session_info");
                StoneSerializers.nullableStruct(WebSessionLogInfo.Serializer.INSTANCE).serialize(webDeviceSessionLogInfo.sessionInfo, jsonGenerator);
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
        public WebDeviceSessionLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("web_device_session".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                String str = null;
                Date date = null;
                Date date2 = null;
                WebSessionLogInfo webSessionLogInfo = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("user_agent".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("os".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("browser".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("ip_address".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("updated".equals(currentName)) {
                        date2 = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("session_info".equals(currentName)) {
                        webSessionLogInfo = (WebSessionLogInfo) StoneSerializers.nullableStruct(WebSessionLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user_agent\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"os\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"browser\" missing.");
                }
                WebDeviceSessionLogInfo webDeviceSessionLogInfo = new WebDeviceSessionLogInfo(strDeserialize, strDeserialize2, strDeserialize3, str, date, date2, webSessionLogInfo);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(webDeviceSessionLogInfo, webDeviceSessionLogInfo.toStringMultiline());
                return webDeviceSessionLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
