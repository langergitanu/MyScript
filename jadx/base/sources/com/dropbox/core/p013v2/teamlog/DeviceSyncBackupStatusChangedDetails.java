package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.BackupStatus;
import com.dropbox.core.p013v2.teamlog.DesktopDeviceSessionLogInfo;
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
public class DeviceSyncBackupStatusChangedDetails {

    @Nonnull
    protected final DesktopDeviceSessionLogInfo desktopDeviceSessionInfo;

    @Nonnull
    protected final BackupStatus newValue;

    @Nonnull
    protected final BackupStatus previousValue;

    public DeviceSyncBackupStatusChangedDetails(@Nonnull DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo, @Nonnull BackupStatus backupStatus, @Nonnull BackupStatus backupStatus2) {
        if (desktopDeviceSessionLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'desktopDeviceSessionInfo' is null");
        }
        this.desktopDeviceSessionInfo = desktopDeviceSessionLogInfo;
        if (backupStatus == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = backupStatus;
        if (backupStatus2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = backupStatus2;
    }

    @Nonnull
    public DesktopDeviceSessionLogInfo getDesktopDeviceSessionInfo() {
        return this.desktopDeviceSessionInfo;
    }

    @Nonnull
    public BackupStatus getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public BackupStatus getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.desktopDeviceSessionInfo, this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        BackupStatus backupStatus;
        BackupStatus backupStatus2;
        BackupStatus backupStatus3;
        BackupStatus backupStatus4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DeviceSyncBackupStatusChangedDetails deviceSyncBackupStatusChangedDetails = (DeviceSyncBackupStatusChangedDetails) obj;
        DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo = this.desktopDeviceSessionInfo;
        DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo2 = deviceSyncBackupStatusChangedDetails.desktopDeviceSessionInfo;
        return (desktopDeviceSessionLogInfo == desktopDeviceSessionLogInfo2 || desktopDeviceSessionLogInfo.equals(desktopDeviceSessionLogInfo2)) && ((backupStatus = this.previousValue) == (backupStatus2 = deviceSyncBackupStatusChangedDetails.previousValue) || backupStatus.equals(backupStatus2)) && ((backupStatus3 = this.newValue) == (backupStatus4 = deviceSyncBackupStatusChangedDetails.newValue) || backupStatus3.equals(backupStatus4));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeviceSyncBackupStatusChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeviceSyncBackupStatusChangedDetails deviceSyncBackupStatusChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("desktop_device_session_info");
            DesktopDeviceSessionLogInfo.Serializer.INSTANCE.serialize(deviceSyncBackupStatusChangedDetails.desktopDeviceSessionInfo, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            BackupStatus.Serializer.INSTANCE.serialize(deviceSyncBackupStatusChangedDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            BackupStatus.Serializer.INSTANCE.serialize(deviceSyncBackupStatusChangedDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeviceSyncBackupStatusChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                BackupStatus backupStatusDeserialize = null;
                BackupStatus backupStatusDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("desktop_device_session_info".equals(currentName)) {
                        desktopDeviceSessionLogInfoDeserialize = DesktopDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        backupStatusDeserialize = BackupStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        backupStatusDeserialize2 = BackupStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (desktopDeviceSessionLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"desktop_device_session_info\" missing.");
                }
                if (backupStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (backupStatusDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                DeviceSyncBackupStatusChangedDetails deviceSyncBackupStatusChangedDetails = new DeviceSyncBackupStatusChangedDetails(desktopDeviceSessionLogInfoDeserialize, backupStatusDeserialize, backupStatusDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deviceSyncBackupStatusChangedDetails, deviceSyncBackupStatusChangedDetails.toStringMultiline());
                return deviceSyncBackupStatusChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
