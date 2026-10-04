package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ImportFormat {
    HTML,
    MARKDOWN,
    PLAIN_TEXT,
    OTHER;

    static class Serializer extends UnionSerializer<ImportFormat> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ImportFormat importFormat, JsonGenerator jsonGenerator) throws IOException {
            int i = C42301.$SwitchMap$com$dropbox$core$v2$paper$ImportFormat[importFormat.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("html");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("markdown");
            } else if (i == 3) {
                jsonGenerator.writeString("plain_text");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ImportFormat deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ImportFormat importFormat;
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
            if ("html".equals(tag)) {
                importFormat = ImportFormat.HTML;
            } else if ("markdown".equals(tag)) {
                importFormat = ImportFormat.MARKDOWN;
            } else if ("plain_text".equals(tag)) {
                importFormat = ImportFormat.PLAIN_TEXT;
            } else {
                importFormat = ImportFormat.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return importFormat;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.ImportFormat$1 */
    static /* synthetic */ class C42301 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$ImportFormat;

        static {
            int[] iArr = new int[ImportFormat.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$ImportFormat = iArr;
            try {
                iArr[ImportFormat.HTML.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ImportFormat[ImportFormat.MARKDOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ImportFormat[ImportFormat.PLAIN_TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
