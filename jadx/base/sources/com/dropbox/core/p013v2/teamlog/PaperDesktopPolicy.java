package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum PaperDesktopPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<PaperDesktopPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperDesktopPolicy paperDesktopPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45021.$SwitchMap$com$dropbox$core$v2$teamlog$PaperDesktopPolicy[paperDesktopPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperDesktopPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperDesktopPolicy paperDesktopPolicy;
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
                paperDesktopPolicy = PaperDesktopPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                paperDesktopPolicy = PaperDesktopPolicy.ENABLED;
            } else {
                paperDesktopPolicy = PaperDesktopPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperDesktopPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.PaperDesktopPolicy$1 */
    static /* synthetic */ class C45021 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$PaperDesktopPolicy;

        static {
            int[] iArr = new int[PaperDesktopPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$PaperDesktopPolicy = iArr;
            try {
                iArr[PaperDesktopPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PaperDesktopPolicy[PaperDesktopPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
