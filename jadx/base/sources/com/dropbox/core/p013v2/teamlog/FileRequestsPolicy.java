package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum FileRequestsPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<FileRequestsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileRequestsPolicy fileRequestsPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44781.$SwitchMap$com$dropbox$core$v2$teamlog$FileRequestsPolicy[fileRequestsPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileRequestsPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileRequestsPolicy fileRequestsPolicy;
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
                fileRequestsPolicy = FileRequestsPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                fileRequestsPolicy = FileRequestsPolicy.ENABLED;
            } else {
                fileRequestsPolicy = FileRequestsPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileRequestsPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.FileRequestsPolicy$1 */
    static /* synthetic */ class C44781 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$FileRequestsPolicy;

        static {
            int[] iArr = new int[FileRequestsPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$FileRequestsPolicy = iArr;
            try {
                iArr[FileRequestsPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FileRequestsPolicy[FileRequestsPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
