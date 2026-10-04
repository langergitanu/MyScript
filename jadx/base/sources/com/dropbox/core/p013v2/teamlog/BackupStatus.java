package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum BackupStatus {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<BackupStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(BackupStatus backupStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C44461.$SwitchMap$com$dropbox$core$v2$teamlog$BackupStatus[backupStatus.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public BackupStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            BackupStatus backupStatus;
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
            if ("disabled".equals(tag)) {
                backupStatus = BackupStatus.DISABLED;
            } else if ("enabled".equals(tag)) {
                backupStatus = BackupStatus.ENABLED;
            } else {
                backupStatus = BackupStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return backupStatus;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.BackupStatus$1 */
    static /* synthetic */ class C44461 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$BackupStatus;

        static {
            int[] iArr = new int[BackupStatus.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$BackupStatus = iArr;
            try {
                iArr[BackupStatus.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$BackupStatus[BackupStatus.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
