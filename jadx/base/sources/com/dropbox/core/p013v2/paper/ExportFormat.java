package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ExportFormat {
    HTML,
    MARKDOWN,
    OTHER;

    static class Serializer extends UnionSerializer<ExportFormat> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ExportFormat exportFormat, JsonGenerator jsonGenerator) throws IOException {
            int i = C42281.$SwitchMap$com$dropbox$core$v2$paper$ExportFormat[exportFormat.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("html");
            } else if (i == 2) {
                jsonGenerator.writeString("markdown");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ExportFormat deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ExportFormat exportFormat;
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
                exportFormat = ExportFormat.HTML;
            } else if ("markdown".equals(tag)) {
                exportFormat = ExportFormat.MARKDOWN;
            } else {
                exportFormat = ExportFormat.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return exportFormat;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.ExportFormat$1 */
    static /* synthetic */ class C42281 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$ExportFormat;

        static {
            int[] iArr = new int[ExportFormat.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$ExportFormat = iArr;
            try {
                iArr[ExportFormat.HTML.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$ExportFormat[ExportFormat.MARKDOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
