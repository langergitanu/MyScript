package com.dropbox.core.p013v2.teamlog;

import androidx.core.app.NotificationCompat;
import com.dropbox.core.p013v2.teamlog.DesktopDeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.ExternalDriveBackupEligibilityStatus;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class ExternalDriveBackupEligibilityStatusCheckedDetails {

    @Nonnull
    protected final DesktopDeviceSessionLogInfo desktopDeviceSessionInfo;
    protected final long numberOfExternalDriveBackup;

    @Nonnull
    protected final ExternalDriveBackupEligibilityStatus status;

    public ExternalDriveBackupEligibilityStatusCheckedDetails(@Nonnull DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo, @Nonnull ExternalDriveBackupEligibilityStatus externalDriveBackupEligibilityStatus, long j) {
        if (desktopDeviceSessionLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'desktopDeviceSessionInfo' is null");
        }
        this.desktopDeviceSessionInfo = desktopDeviceSessionLogInfo;
        if (externalDriveBackupEligibilityStatus == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = externalDriveBackupEligibilityStatus;
        this.numberOfExternalDriveBackup = j;
    }

    @Nonnull
    public DesktopDeviceSessionLogInfo getDesktopDeviceSessionInfo() {
        return this.desktopDeviceSessionInfo;
    }

    @Nonnull
    public ExternalDriveBackupEligibilityStatus getStatus() {
        return this.status;
    }

    public long getNumberOfExternalDriveBackup() {
        return this.numberOfExternalDriveBackup;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.desktopDeviceSessionInfo, this.status, Long.valueOf(this.numberOfExternalDriveBackup)});
    }

    public boolean equals(Object obj) {
        ExternalDriveBackupEligibilityStatusCheckedDetails externalDriveBackupEligibilityStatusCheckedDetails;
        DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo;
        DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo2;
        ExternalDriveBackupEligibilityStatus externalDriveBackupEligibilityStatus;
        ExternalDriveBackupEligibilityStatus externalDriveBackupEligibilityStatus2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((desktopDeviceSessionLogInfo = this.desktopDeviceSessionInfo) == (desktopDeviceSessionLogInfo2 = (externalDriveBackupEligibilityStatusCheckedDetails = (ExternalDriveBackupEligibilityStatusCheckedDetails) obj).desktopDeviceSessionInfo) || desktopDeviceSessionLogInfo.equals(desktopDeviceSessionLogInfo2)) && (((externalDriveBackupEligibilityStatus = this.status) == (externalDriveBackupEligibilityStatus2 = externalDriveBackupEligibilityStatusCheckedDetails.status) || externalDriveBackupEligibilityStatus.equals(externalDriveBackupEligibilityStatus2)) && this.numberOfExternalDriveBackup == externalDriveBackupEligibilityStatusCheckedDetails.numberOfExternalDriveBackup);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ExternalDriveBackupEligibilityStatusCheckedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExternalDriveBackupEligibilityStatusCheckedDetails externalDriveBackupEligibilityStatusCheckedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("desktop_device_session_info");
            DesktopDeviceSessionLogInfo.Serializer.INSTANCE.serialize(externalDriveBackupEligibilityStatusCheckedDetails.desktopDeviceSessionInfo, jsonGenerator);
            jsonGenerator.writeFieldName(NotificationCompat.CATEGORY_STATUS);
            ExternalDriveBackupEligibilityStatus.Serializer.INSTANCE.serialize(externalDriveBackupEligibilityStatusCheckedDetails.status, jsonGenerator);
            jsonGenerator.writeFieldName("number_of_external_drive_backup");
            StoneSerializers.uInt64().serialize(Long.valueOf(externalDriveBackupEligibilityStatusCheckedDetails.numberOfExternalDriveBackup), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExternalDriveBackupEligibilityStatusCheckedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ExternalDriveBackupEligibilityStatus externalDriveBackupEligibilityStatusDeserialize = null;
                Long lDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("desktop_device_session_info".equals(currentName)) {
                        desktopDeviceSessionLogInfoDeserialize = DesktopDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (NotificationCompat.CATEGORY_STATUS.equals(currentName)) {
                        externalDriveBackupEligibilityStatusDeserialize = ExternalDriveBackupEligibilityStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("number_of_external_drive_backup".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (desktopDeviceSessionLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"desktop_device_session_info\" missing.");
                }
                if (externalDriveBackupEligibilityStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"status\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"number_of_external_drive_backup\" missing.");
                }
                ExternalDriveBackupEligibilityStatusCheckedDetails externalDriveBackupEligibilityStatusCheckedDetails = new ExternalDriveBackupEligibilityStatusCheckedDetails(desktopDeviceSessionLogInfoDeserialize, externalDriveBackupEligibilityStatusDeserialize, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(externalDriveBackupEligibilityStatusCheckedDetails, externalDriveBackupEligibilityStatusCheckedDetails.toStringMultiline());
                return externalDriveBackupEligibilityStatusCheckedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
