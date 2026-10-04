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
public class DeviceDeleteOnUnlinkFailDetails {

    @Nullable
    protected final String displayName;
    protected final long numFailures;

    @Nullable
    protected final SessionLogInfo sessionInfo;

    public DeviceDeleteOnUnlinkFailDetails(long j, @Nullable SessionLogInfo sessionLogInfo, @Nullable String str) {
        this.sessionInfo = sessionLogInfo;
        this.displayName = str;
        this.numFailures = j;
    }

    public DeviceDeleteOnUnlinkFailDetails(long j) {
        this(j, null, null);
    }

    public long getNumFailures() {
        return this.numFailures;
    }

    @Nullable
    public SessionLogInfo getSessionInfo() {
        return this.sessionInfo;
    }

    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    public static Builder newBuilder(long j) {
        return new Builder(j);
    }

    public static class Builder {
        protected final long numFailures;
        protected SessionLogInfo sessionInfo = null;
        protected String displayName = null;

        protected Builder(long j) {
            this.numFailures = j;
        }

        public Builder withSessionInfo(SessionLogInfo sessionLogInfo) {
            this.sessionInfo = sessionLogInfo;
            return this;
        }

        public Builder withDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public DeviceDeleteOnUnlinkFailDetails build() {
            return new DeviceDeleteOnUnlinkFailDetails(this.numFailures, this.sessionInfo, this.displayName);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sessionInfo, this.displayName, Long.valueOf(this.numFailures)});
    }

    public boolean equals(Object obj) {
        SessionLogInfo sessionLogInfo;
        SessionLogInfo sessionLogInfo2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            DeviceDeleteOnUnlinkFailDetails deviceDeleteOnUnlinkFailDetails = (DeviceDeleteOnUnlinkFailDetails) obj;
            if (this.numFailures == deviceDeleteOnUnlinkFailDetails.numFailures && (((sessionLogInfo = this.sessionInfo) == (sessionLogInfo2 = deviceDeleteOnUnlinkFailDetails.sessionInfo) || (sessionLogInfo != null && sessionLogInfo.equals(sessionLogInfo2))) && ((str = this.displayName) == (str2 = deviceDeleteOnUnlinkFailDetails.displayName) || (str != null && str.equals(str2))))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceDeleteOnUnlinkFailDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceDeleteOnUnlinkFailDetails deviceDeleteOnUnlinkFailDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("num_failures");
            StoneSerializers.int64().serialize(Long.valueOf(deviceDeleteOnUnlinkFailDetails.numFailures), jsonGenerator);
            if (deviceDeleteOnUnlinkFailDetails.sessionInfo != null) {
                jsonGenerator.writeFieldName("session_info");
                StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).serialize(deviceDeleteOnUnlinkFailDetails.sessionInfo, jsonGenerator);
            }
            if (deviceDeleteOnUnlinkFailDetails.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deviceDeleteOnUnlinkFailDetails.displayName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceDeleteOnUnlinkFailDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SessionLogInfo sessionLogInfo = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("num_failures".equals(currentName)) {
                        lDeserialize = StoneSerializers.int64().deserialize(jsonParser);
                    } else if ("session_info".equals(currentName)) {
                        sessionLogInfo = (SessionLogInfo) StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"num_failures\" missing.");
                }
                DeviceDeleteOnUnlinkFailDetails deviceDeleteOnUnlinkFailDetails = new DeviceDeleteOnUnlinkFailDetails(lDeserialize.longValue(), sessionLogInfo, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceDeleteOnUnlinkFailDetails, deviceDeleteOnUnlinkFailDetails.toStringMultiline());
                return deviceDeleteOnUnlinkFailDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
