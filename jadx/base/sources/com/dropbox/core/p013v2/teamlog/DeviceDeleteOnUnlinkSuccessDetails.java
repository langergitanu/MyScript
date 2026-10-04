package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SessionLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceDeleteOnUnlinkSuccessDetails {

    @Nullable
    protected final String displayName;

    @Nullable
    protected final SessionLogInfo sessionInfo;

    public DeviceDeleteOnUnlinkSuccessDetails(@Nullable SessionLogInfo sessionLogInfo, @Nullable String str) {
        this.sessionInfo = sessionLogInfo;
        this.displayName = str;
    }

    public DeviceDeleteOnUnlinkSuccessDetails() {
        this(null, null);
    }

    @Nullable
    public SessionLogInfo getSessionInfo() {
        return this.sessionInfo;
    }

    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected SessionLogInfo sessionInfo = null;
        protected String displayName = null;

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

        public DeviceDeleteOnUnlinkSuccessDetails build() {
            return new DeviceDeleteOnUnlinkSuccessDetails(this.sessionInfo, this.displayName);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sessionInfo, this.displayName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DeviceDeleteOnUnlinkSuccessDetails deviceDeleteOnUnlinkSuccessDetails = (DeviceDeleteOnUnlinkSuccessDetails) obj;
        SessionLogInfo sessionLogInfo = this.sessionInfo;
        SessionLogInfo sessionLogInfo2 = deviceDeleteOnUnlinkSuccessDetails.sessionInfo;
        return (sessionLogInfo == sessionLogInfo2 || (sessionLogInfo != null && sessionLogInfo.equals(sessionLogInfo2))) && ((str = this.displayName) == (str2 = deviceDeleteOnUnlinkSuccessDetails.displayName) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceDeleteOnUnlinkSuccessDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceDeleteOnUnlinkSuccessDetails deviceDeleteOnUnlinkSuccessDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (deviceDeleteOnUnlinkSuccessDetails.sessionInfo != null) {
                jsonGenerator.writeFieldName("session_info");
                StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).serialize(deviceDeleteOnUnlinkSuccessDetails.sessionInfo, jsonGenerator);
            }
            if (deviceDeleteOnUnlinkSuccessDetails.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deviceDeleteOnUnlinkSuccessDetails.displayName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceDeleteOnUnlinkSuccessDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SessionLogInfo sessionLogInfo = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("session_info".equals(currentName)) {
                        sessionLogInfo = (SessionLogInfo) StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                DeviceDeleteOnUnlinkSuccessDetails deviceDeleteOnUnlinkSuccessDetails = new DeviceDeleteOnUnlinkSuccessDetails(sessionLogInfo, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceDeleteOnUnlinkSuccessDetails, deviceDeleteOnUnlinkSuccessDetails.toStringMultiline());
                return deviceDeleteOnUnlinkSuccessDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
