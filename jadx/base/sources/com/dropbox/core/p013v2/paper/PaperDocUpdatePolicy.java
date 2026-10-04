package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PaperDocUpdatePolicy {
    APPEND,
    PREPEND,
    OVERWRITE_ALL,
    OTHER;

    static class Serializer extends UnionSerializer<PaperDocUpdatePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperDocUpdatePolicy paperDocUpdatePolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C42401.$SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdatePolicy[paperDocUpdatePolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("append");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("prepend");
            } else if (i == 3) {
                jsonGenerator.writeString("overwrite_all");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperDocUpdatePolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperDocUpdatePolicy paperDocUpdatePolicy;
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
            if ("append".equals(tag)) {
                paperDocUpdatePolicy = PaperDocUpdatePolicy.APPEND;
            } else if ("prepend".equals(tag)) {
                paperDocUpdatePolicy = PaperDocUpdatePolicy.PREPEND;
            } else if ("overwrite_all".equals(tag)) {
                paperDocUpdatePolicy = PaperDocUpdatePolicy.OVERWRITE_ALL;
            } else {
                paperDocUpdatePolicy = PaperDocUpdatePolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperDocUpdatePolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.PaperDocUpdatePolicy$1 */
    static /* synthetic */ class C42401 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdatePolicy;

        static {
            int[] iArr = new int[PaperDocUpdatePolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdatePolicy = iArr;
            try {
                iArr[PaperDocUpdatePolicy.APPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdatePolicy[PaperDocUpdatePolicy.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdatePolicy[PaperDocUpdatePolicy.OVERWRITE_ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
