package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ExternalDriveBackupEligibilityStatus {
    EXCEED_LICENSE_CAP,
    SUCCESS,
    OTHER;

    static class Serializer extends UnionSerializer<ExternalDriveBackupEligibilityStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ExternalDriveBackupEligibilityStatus externalDriveBackupEligibilityStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C44691.f788xae1ebc09[externalDriveBackupEligibilityStatus.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("exceed_license_cap");
            } else if (i == 2) {
                jsonGenerator.writeString(FirebaseAnalytics.Param.SUCCESS);
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ExternalDriveBackupEligibilityStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ExternalDriveBackupEligibilityStatus externalDriveBackupEligibilityStatus;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("exceed_license_cap".equals(tag)) {
                externalDriveBackupEligibilityStatus = ExternalDriveBackupEligibilityStatus.EXCEED_LICENSE_CAP;
            } else if (FirebaseAnalytics.Param.SUCCESS.equals(tag)) {
                externalDriveBackupEligibilityStatus = ExternalDriveBackupEligibilityStatus.SUCCESS;
            } else {
                externalDriveBackupEligibilityStatus = ExternalDriveBackupEligibilityStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return externalDriveBackupEligibilityStatus;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ExternalDriveBackupEligibilityStatus$1 */
    static /* synthetic */ class C44691 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupEligibilityStatus */
        static final /* synthetic */ int[] f788xae1ebc09;

        static {
            int[] iArr = new int[ExternalDriveBackupEligibilityStatus.values().length];
            f788xae1ebc09 = iArr;
            try {
                iArr[ExternalDriveBackupEligibilityStatus.EXCEED_LICENSE_CAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f788xae1ebc09[ExternalDriveBackupEligibilityStatus.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
