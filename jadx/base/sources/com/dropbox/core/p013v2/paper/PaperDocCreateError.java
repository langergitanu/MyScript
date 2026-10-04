package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PaperDocCreateError {
    INSUFFICIENT_PERMISSIONS,
    OTHER,
    CONTENT_MALFORMED,
    FOLDER_NOT_FOUND,
    DOC_LENGTH_EXCEEDED,
    IMAGE_SIZE_EXCEEDED;

    static class Serializer extends UnionSerializer<PaperDocCreateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperDocCreateError paperDocCreateError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42371.$SwitchMap$com$dropbox$core$v2$paper$PaperDocCreateError[paperDocCreateError.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("insufficient_permissions");
                    return;
                case 2:
                    jsonGenerator.writeString("other");
                    return;
                case 3:
                    jsonGenerator.writeString("content_malformed");
                    return;
                case 4:
                    jsonGenerator.writeString("folder_not_found");
                    return;
                case 5:
                    jsonGenerator.writeString("doc_length_exceeded");
                    return;
                case 6:
                    jsonGenerator.writeString("image_size_exceeded");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + paperDocCreateError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperDocCreateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperDocCreateError paperDocCreateError;
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
            if ("insufficient_permissions".equals(tag)) {
                paperDocCreateError = PaperDocCreateError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                paperDocCreateError = PaperDocCreateError.OTHER;
            } else if ("content_malformed".equals(tag)) {
                paperDocCreateError = PaperDocCreateError.CONTENT_MALFORMED;
            } else if ("folder_not_found".equals(tag)) {
                paperDocCreateError = PaperDocCreateError.FOLDER_NOT_FOUND;
            } else if ("doc_length_exceeded".equals(tag)) {
                paperDocCreateError = PaperDocCreateError.DOC_LENGTH_EXCEEDED;
            } else if ("image_size_exceeded".equals(tag)) {
                paperDocCreateError = PaperDocCreateError.IMAGE_SIZE_EXCEEDED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperDocCreateError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.PaperDocCreateError$1 */
    static /* synthetic */ class C42371 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$PaperDocCreateError;

        static {
            int[] iArr = new int[PaperDocCreateError.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$PaperDocCreateError = iArr;
            try {
                iArr[PaperDocCreateError.INSUFFICIENT_PERMISSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocCreateError[PaperDocCreateError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocCreateError[PaperDocCreateError.CONTENT_MALFORMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocCreateError[PaperDocCreateError.FOLDER_NOT_FOUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocCreateError[PaperDocCreateError.DOC_LENGTH_EXCEEDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocCreateError[PaperDocCreateError.IMAGE_SIZE_EXCEEDED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
