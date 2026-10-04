package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ExternalDriveBackupStatus {
    BROKEN,
    CREATED,
    CREATED_OR_BROKEN,
    DELETED,
    EMPTY,
    UNKNOWN,
    OTHER;

    static class Serializer extends UnionSerializer<ExternalDriveBackupStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ExternalDriveBackupStatus externalDriveBackupStatus, JsonGenerator jsonGenerator) throws IOException {
            switch (C44711.$SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupStatus[externalDriveBackupStatus.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("broken");
                    break;
                case 2:
                    jsonGenerator.writeString("created");
                    break;
                case 3:
                    jsonGenerator.writeString("created_or_broken");
                    break;
                case 4:
                    jsonGenerator.writeString("deleted");
                    break;
                case 5:
                    jsonGenerator.writeString("empty");
                    break;
                case 6:
                    jsonGenerator.writeString("unknown");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ExternalDriveBackupStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ExternalDriveBackupStatus externalDriveBackupStatus;
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
            if ("broken".equals(tag)) {
                externalDriveBackupStatus = ExternalDriveBackupStatus.BROKEN;
            } else if ("created".equals(tag)) {
                externalDriveBackupStatus = ExternalDriveBackupStatus.CREATED;
            } else if ("created_or_broken".equals(tag)) {
                externalDriveBackupStatus = ExternalDriveBackupStatus.CREATED_OR_BROKEN;
            } else if ("deleted".equals(tag)) {
                externalDriveBackupStatus = ExternalDriveBackupStatus.DELETED;
            } else if ("empty".equals(tag)) {
                externalDriveBackupStatus = ExternalDriveBackupStatus.EMPTY;
            } else if ("unknown".equals(tag)) {
                externalDriveBackupStatus = ExternalDriveBackupStatus.UNKNOWN;
            } else {
                externalDriveBackupStatus = ExternalDriveBackupStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return externalDriveBackupStatus;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ExternalDriveBackupStatus$1 */
    static /* synthetic */ class C44711 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupStatus;

        static {
            int[] iArr = new int[ExternalDriveBackupStatus.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupStatus = iArr;
            try {
                iArr[ExternalDriveBackupStatus.BROKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupStatus[ExternalDriveBackupStatus.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupStatus[ExternalDriveBackupStatus.CREATED_OR_BROKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupStatus[ExternalDriveBackupStatus.DELETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupStatus[ExternalDriveBackupStatus.EMPTY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupStatus[ExternalDriveBackupStatus.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
