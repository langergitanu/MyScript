package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DesktopDeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.ExternalDriveBackupStatus;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class ExternalDriveBackupStatusChangedDetails {

    @Nonnull
    protected final DesktopDeviceSessionLogInfo desktopDeviceSessionInfo;

    @Nonnull
    protected final ExternalDriveBackupStatus newValue;

    @Nonnull
    protected final ExternalDriveBackupStatus previousValue;

    public ExternalDriveBackupStatusChangedDetails(@Nonnull DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo, @Nonnull ExternalDriveBackupStatus externalDriveBackupStatus, @Nonnull ExternalDriveBackupStatus externalDriveBackupStatus2) {
        if (desktopDeviceSessionLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'desktopDeviceSessionInfo' is null");
        }
        this.desktopDeviceSessionInfo = desktopDeviceSessionLogInfo;
        if (externalDriveBackupStatus == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = externalDriveBackupStatus;
        if (externalDriveBackupStatus2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = externalDriveBackupStatus2;
    }

    @Nonnull
    public DesktopDeviceSessionLogInfo getDesktopDeviceSessionInfo() {
        return this.desktopDeviceSessionInfo;
    }

    @Nonnull
    public ExternalDriveBackupStatus getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public ExternalDriveBackupStatus getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.desktopDeviceSessionInfo, this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        ExternalDriveBackupStatus externalDriveBackupStatus;
        ExternalDriveBackupStatus externalDriveBackupStatus2;
        ExternalDriveBackupStatus externalDriveBackupStatus3;
        ExternalDriveBackupStatus externalDriveBackupStatus4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ExternalDriveBackupStatusChangedDetails externalDriveBackupStatusChangedDetails = (ExternalDriveBackupStatusChangedDetails) obj;
        DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo = this.desktopDeviceSessionInfo;
        DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo2 = externalDriveBackupStatusChangedDetails.desktopDeviceSessionInfo;
        return (desktopDeviceSessionLogInfo == desktopDeviceSessionLogInfo2 || desktopDeviceSessionLogInfo.equals(desktopDeviceSessionLogInfo2)) && ((externalDriveBackupStatus = this.previousValue) == (externalDriveBackupStatus2 = externalDriveBackupStatusChangedDetails.previousValue) || externalDriveBackupStatus.equals(externalDriveBackupStatus2)) && ((externalDriveBackupStatus3 = this.newValue) == (externalDriveBackupStatus4 = externalDriveBackupStatusChangedDetails.newValue) || externalDriveBackupStatus3.equals(externalDriveBackupStatus4));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ExternalDriveBackupStatusChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExternalDriveBackupStatusChangedDetails externalDriveBackupStatusChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("desktop_device_session_info");
            DesktopDeviceSessionLogInfo.Serializer.INSTANCE.serialize(externalDriveBackupStatusChangedDetails.desktopDeviceSessionInfo, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            ExternalDriveBackupStatus.Serializer.INSTANCE.serialize(externalDriveBackupStatusChangedDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            ExternalDriveBackupStatus.Serializer.INSTANCE.serialize(externalDriveBackupStatusChangedDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExternalDriveBackupStatusChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ExternalDriveBackupStatus externalDriveBackupStatusDeserialize = null;
                ExternalDriveBackupStatus externalDriveBackupStatusDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("desktop_device_session_info".equals(currentName)) {
                        desktopDeviceSessionLogInfoDeserialize = DesktopDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        externalDriveBackupStatusDeserialize = ExternalDriveBackupStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        externalDriveBackupStatusDeserialize2 = ExternalDriveBackupStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (desktopDeviceSessionLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"desktop_device_session_info\" missing.");
                }
                if (externalDriveBackupStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (externalDriveBackupStatusDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                ExternalDriveBackupStatusChangedDetails externalDriveBackupStatusChangedDetails = new ExternalDriveBackupStatusChangedDetails(desktopDeviceSessionLogInfoDeserialize, externalDriveBackupStatusDeserialize, externalDriveBackupStatusDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(externalDriveBackupStatusChangedDetails, externalDriveBackupStatusChangedDetails.toStringMultiline());
                return externalDriveBackupStatusChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
