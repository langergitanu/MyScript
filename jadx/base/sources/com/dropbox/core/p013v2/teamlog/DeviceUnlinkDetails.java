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
public class DeviceUnlinkDetails {
    protected final boolean deleteData;

    @Nullable
    protected final String displayName;

    @Nullable
    protected final SessionLogInfo sessionInfo;

    public DeviceUnlinkDetails(boolean z, @Nullable SessionLogInfo sessionLogInfo, @Nullable String str) {
        this.sessionInfo = sessionLogInfo;
        this.displayName = str;
        this.deleteData = z;
    }

    public DeviceUnlinkDetails(boolean z) {
        this(z, null, null);
    }

    public boolean getDeleteData() {
        return this.deleteData;
    }

    @Nullable
    public SessionLogInfo getSessionInfo() {
        return this.sessionInfo;
    }

    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    public static Builder newBuilder(boolean z) {
        return new Builder(z);
    }

    public static class Builder {
        protected final boolean deleteData;
        protected SessionLogInfo sessionInfo = null;
        protected String displayName = null;

        protected Builder(boolean z) {
            this.deleteData = z;
        }

        public Builder withSessionInfo(SessionLogInfo sessionLogInfo) {
            this.sessionInfo = sessionLogInfo;
            return this;
        }

        public Builder withDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public DeviceUnlinkDetails build() {
            return new DeviceUnlinkDetails(this.deleteData, this.sessionInfo, this.displayName);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sessionInfo, this.displayName, Boolean.valueOf(this.deleteData)});
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
            DeviceUnlinkDetails deviceUnlinkDetails = (DeviceUnlinkDetails) obj;
            if (this.deleteData == deviceUnlinkDetails.deleteData && (((sessionLogInfo = this.sessionInfo) == (sessionLogInfo2 = deviceUnlinkDetails.sessionInfo) || (sessionLogInfo != null && sessionLogInfo.equals(sessionLogInfo2))) && ((str = this.displayName) == (str2 = deviceUnlinkDetails.displayName) || (str != null && str.equals(str2))))) {
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

    static class Serializer extends StructSerializer<DeviceUnlinkDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceUnlinkDetails deviceUnlinkDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("delete_data");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(deviceUnlinkDetails.deleteData), jsonGenerator);
            if (deviceUnlinkDetails.sessionInfo != null) {
                jsonGenerator.writeFieldName("session_info");
                StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).serialize(deviceUnlinkDetails.sessionInfo, jsonGenerator);
            }
            if (deviceUnlinkDetails.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deviceUnlinkDetails.displayName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceUnlinkDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
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
                    if ("delete_data".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("session_info".equals(currentName)) {
                        sessionLogInfo = (SessionLogInfo) StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"delete_data\" missing.");
                }
                DeviceUnlinkDetails deviceUnlinkDetails = new DeviceUnlinkDetails(boolDeserialize.booleanValue(), sessionLogInfo, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceUnlinkDetails, deviceUnlinkDetails.toStringMultiline());
                return deviceUnlinkDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
