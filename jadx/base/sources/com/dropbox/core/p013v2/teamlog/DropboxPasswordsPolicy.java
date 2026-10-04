package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum DropboxPasswordsPolicy {
    DEFAULT,
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<DropboxPasswordsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DropboxPasswordsPolicy dropboxPasswordsPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44611.$SwitchMap$com$dropbox$core$v2$teamlog$DropboxPasswordsPolicy[dropboxPasswordsPolicy.ordinal()];
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
        public DropboxPasswordsPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DropboxPasswordsPolicy dropboxPasswordsPolicy;
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
                dropboxPasswordsPolicy = DropboxPasswordsPolicy.DEFAULT;
            } else if ("disabled".equals(tag)) {
                dropboxPasswordsPolicy = DropboxPasswordsPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                dropboxPasswordsPolicy = DropboxPasswordsPolicy.ENABLED;
            } else {
                dropboxPasswordsPolicy = DropboxPasswordsPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return dropboxPasswordsPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.DropboxPasswordsPolicy$1 */
    static /* synthetic */ class C44611 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$DropboxPasswordsPolicy;

        static {
            int[] iArr = new int[DropboxPasswordsPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$DropboxPasswordsPolicy = iArr;
            try {
                iArr[DropboxPasswordsPolicy.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$DropboxPasswordsPolicy[DropboxPasswordsPolicy.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$DropboxPasswordsPolicy[DropboxPasswordsPolicy.ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
