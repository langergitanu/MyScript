package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PaperDocUpdatePolicy {
    UPDATE,
    OVERWRITE,
    PREPEND,
    APPEND,
    OTHER;

    static class Serializer extends UnionSerializer<PaperDocUpdatePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperDocUpdatePolicy paperDocUpdatePolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C41801.$SwitchMap$com$dropbox$core$v2$files$PaperDocUpdatePolicy[paperDocUpdatePolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("update");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("overwrite");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("prepend");
            } else if (i == 4) {
                jsonGenerator.writeString("append");
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
            if ("update".equals(tag)) {
                paperDocUpdatePolicy = PaperDocUpdatePolicy.UPDATE;
            } else if ("overwrite".equals(tag)) {
                paperDocUpdatePolicy = PaperDocUpdatePolicy.OVERWRITE;
            } else if ("prepend".equals(tag)) {
                paperDocUpdatePolicy = PaperDocUpdatePolicy.PREPEND;
            } else if ("append".equals(tag)) {
                paperDocUpdatePolicy = PaperDocUpdatePolicy.APPEND;
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

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.PaperDocUpdatePolicy$1 */
    static /* synthetic */ class C41801 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$PaperDocUpdatePolicy;

        static {
            int[] iArr = new int[PaperDocUpdatePolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$files$PaperDocUpdatePolicy = iArr;
            try {
                iArr[PaperDocUpdatePolicy.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperDocUpdatePolicy[PaperDocUpdatePolicy.OVERWRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperDocUpdatePolicy[PaperDocUpdatePolicy.PREPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$PaperDocUpdatePolicy[PaperDocUpdatePolicy.APPEND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
