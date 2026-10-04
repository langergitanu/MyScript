package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum FileTransfersPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<FileTransfersPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileTransfersPolicy fileTransfersPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44791.$SwitchMap$com$dropbox$core$v2$teamlog$FileTransfersPolicy[fileTransfersPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileTransfersPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileTransfersPolicy fileTransfersPolicy;
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
                fileTransfersPolicy = FileTransfersPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                fileTransfersPolicy = FileTransfersPolicy.ENABLED;
            } else {
                fileTransfersPolicy = FileTransfersPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileTransfersPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.FileTransfersPolicy$1 */
    static /* synthetic */ class C44791 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$FileTransfersPolicy;

        static {
            int[] iArr = new int[FileTransfersPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$FileTransfersPolicy = iArr;
            try {
                iArr[FileTransfersPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FileTransfersPolicy[FileTransfersPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
