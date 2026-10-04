package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ExternalDriveBackupPolicy {
    DEFAULT,
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<ExternalDriveBackupPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ExternalDriveBackupPolicy externalDriveBackupPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44701.$SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupPolicy[externalDriveBackupPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("default");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("disabled");
            } else if (i == 3) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ExternalDriveBackupPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ExternalDriveBackupPolicy externalDriveBackupPolicy;
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
            if ("default".equals(tag)) {
                externalDriveBackupPolicy = ExternalDriveBackupPolicy.DEFAULT;
            } else if ("disabled".equals(tag)) {
                externalDriveBackupPolicy = ExternalDriveBackupPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                externalDriveBackupPolicy = ExternalDriveBackupPolicy.ENABLED;
            } else {
                externalDriveBackupPolicy = ExternalDriveBackupPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return externalDriveBackupPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ExternalDriveBackupPolicy$1 */
    static /* synthetic */ class C44701 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupPolicy;

        static {
            int[] iArr = new int[ExternalDriveBackupPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupPolicy = iArr;
            try {
                iArr[ExternalDriveBackupPolicy.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupPolicy[ExternalDriveBackupPolicy.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ExternalDriveBackupPolicy[ExternalDriveBackupPolicy.ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
