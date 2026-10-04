package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ComputerBackupPolicy {
    DEFAULT,
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<ComputerBackupPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ComputerBackupPolicy computerBackupPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44521.$SwitchMap$com$dropbox$core$v2$teamlog$ComputerBackupPolicy[computerBackupPolicy.ordinal()];
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
        public ComputerBackupPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ComputerBackupPolicy computerBackupPolicy;
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
                computerBackupPolicy = ComputerBackupPolicy.DEFAULT;
            } else if ("disabled".equals(tag)) {
                computerBackupPolicy = ComputerBackupPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                computerBackupPolicy = ComputerBackupPolicy.ENABLED;
            } else {
                computerBackupPolicy = ComputerBackupPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return computerBackupPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ComputerBackupPolicy$1 */
    static /* synthetic */ class C44521 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ComputerBackupPolicy;

        static {
            int[] iArr = new int[ComputerBackupPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ComputerBackupPolicy = iArr;
            try {
                iArr[ComputerBackupPolicy.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ComputerBackupPolicy[ComputerBackupPolicy.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ComputerBackupPolicy[ComputerBackupPolicy.ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
