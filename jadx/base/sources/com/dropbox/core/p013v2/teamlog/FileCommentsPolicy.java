package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum FileCommentsPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<FileCommentsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileCommentsPolicy fileCommentsPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44771.$SwitchMap$com$dropbox$core$v2$teamlog$FileCommentsPolicy[fileCommentsPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileCommentsPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileCommentsPolicy fileCommentsPolicy;
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
                fileCommentsPolicy = FileCommentsPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                fileCommentsPolicy = FileCommentsPolicy.ENABLED;
            } else {
                fileCommentsPolicy = FileCommentsPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileCommentsPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.FileCommentsPolicy$1 */
    static /* synthetic */ class C44771 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$FileCommentsPolicy;

        static {
            int[] iArr = new int[FileCommentsPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$FileCommentsPolicy = iArr;
            try {
                iArr[FileCommentsPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FileCommentsPolicy[FileCommentsPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
