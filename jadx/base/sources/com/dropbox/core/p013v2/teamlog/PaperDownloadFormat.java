package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum PaperDownloadFormat {
    DOCX,
    HTML,
    MARKDOWN,
    PDF,
    OTHER;

    static class Serializer extends UnionSerializer<PaperDownloadFormat> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperDownloadFormat paperDownloadFormat, JsonGenerator jsonGenerator) throws IOException {
            int i = C45031.$SwitchMap$com$dropbox$core$v2$teamlog$PaperDownloadFormat[paperDownloadFormat.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("docx");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("html");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("markdown");
            } else if (i == 4) {
                jsonGenerator.writeString(AIQuizConstants.PDF);
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperDownloadFormat deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperDownloadFormat paperDownloadFormat;
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
            if ("docx".equals(tag)) {
                paperDownloadFormat = PaperDownloadFormat.DOCX;
            } else if ("html".equals(tag)) {
                paperDownloadFormat = PaperDownloadFormat.HTML;
            } else if ("markdown".equals(tag)) {
                paperDownloadFormat = PaperDownloadFormat.MARKDOWN;
            } else if (AIQuizConstants.PDF.equals(tag)) {
                paperDownloadFormat = PaperDownloadFormat.PDF;
            } else {
                paperDownloadFormat = PaperDownloadFormat.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperDownloadFormat;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.PaperDownloadFormat$1 */
    static /* synthetic */ class C45031 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$PaperDownloadFormat;

        static {
            int[] iArr = new int[PaperDownloadFormat.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$PaperDownloadFormat = iArr;
            try {
                iArr[PaperDownloadFormat.DOCX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PaperDownloadFormat[PaperDownloadFormat.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PaperDownloadFormat[PaperDownloadFormat.MARKDOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PaperDownloadFormat[PaperDownloadFormat.PDF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
