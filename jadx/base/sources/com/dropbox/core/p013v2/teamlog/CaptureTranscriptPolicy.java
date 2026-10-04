package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum CaptureTranscriptPolicy {
    DEFAULT,
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<CaptureTranscriptPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CaptureTranscriptPolicy captureTranscriptPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44481.$SwitchMap$com$dropbox$core$v2$teamlog$CaptureTranscriptPolicy[captureTranscriptPolicy.ordinal()];
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
        public CaptureTranscriptPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CaptureTranscriptPolicy captureTranscriptPolicy;
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
                captureTranscriptPolicy = CaptureTranscriptPolicy.DEFAULT;
            } else if ("disabled".equals(tag)) {
                captureTranscriptPolicy = CaptureTranscriptPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                captureTranscriptPolicy = CaptureTranscriptPolicy.ENABLED;
            } else {
                captureTranscriptPolicy = CaptureTranscriptPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return captureTranscriptPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.CaptureTranscriptPolicy$1 */
    static /* synthetic */ class C44481 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$CaptureTranscriptPolicy;

        static {
            int[] iArr = new int[CaptureTranscriptPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$CaptureTranscriptPolicy = iArr;
            try {
                iArr[CaptureTranscriptPolicy.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$CaptureTranscriptPolicy[CaptureTranscriptPolicy.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$CaptureTranscriptPolicy[CaptureTranscriptPolicy.ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
