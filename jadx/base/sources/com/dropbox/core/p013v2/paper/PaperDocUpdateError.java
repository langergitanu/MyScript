package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PaperDocUpdateError {
    INSUFFICIENT_PERMISSIONS,
    OTHER,
    DOC_NOT_FOUND,
    CONTENT_MALFORMED,
    REVISION_MISMATCH,
    DOC_LENGTH_EXCEEDED,
    IMAGE_SIZE_EXCEEDED,
    DOC_ARCHIVED,
    DOC_DELETED;

    static class Serializer extends UnionSerializer<PaperDocUpdateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperDocUpdateError paperDocUpdateError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42391.$SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError[paperDocUpdateError.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("insufficient_permissions");
                    return;
                case 2:
                    jsonGenerator.writeString("other");
                    return;
                case 3:
                    jsonGenerator.writeString("doc_not_found");
                    return;
                case 4:
                    jsonGenerator.writeString("content_malformed");
                    return;
                case 5:
                    jsonGenerator.writeString("revision_mismatch");
                    return;
                case 6:
                    jsonGenerator.writeString("doc_length_exceeded");
                    return;
                case 7:
                    jsonGenerator.writeString("image_size_exceeded");
                    return;
                case 8:
                    jsonGenerator.writeString("doc_archived");
                    return;
                case 9:
                    jsonGenerator.writeString("doc_deleted");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + paperDocUpdateError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperDocUpdateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperDocUpdateError paperDocUpdateError;
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
                paperDocUpdateError = PaperDocUpdateError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                paperDocUpdateError = PaperDocUpdateError.OTHER;
            } else if ("doc_not_found".equals(tag)) {
                paperDocUpdateError = PaperDocUpdateError.DOC_NOT_FOUND;
            } else if ("content_malformed".equals(tag)) {
                paperDocUpdateError = PaperDocUpdateError.CONTENT_MALFORMED;
            } else if ("revision_mismatch".equals(tag)) {
                paperDocUpdateError = PaperDocUpdateError.REVISION_MISMATCH;
            } else if ("doc_length_exceeded".equals(tag)) {
                paperDocUpdateError = PaperDocUpdateError.DOC_LENGTH_EXCEEDED;
            } else if ("image_size_exceeded".equals(tag)) {
                paperDocUpdateError = PaperDocUpdateError.IMAGE_SIZE_EXCEEDED;
            } else if ("doc_archived".equals(tag)) {
                paperDocUpdateError = PaperDocUpdateError.DOC_ARCHIVED;
            } else if ("doc_deleted".equals(tag)) {
                paperDocUpdateError = PaperDocUpdateError.DOC_DELETED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperDocUpdateError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.PaperDocUpdateError$1 */
    static /* synthetic */ class C42391 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError;

        static {
            int[] iArr = new int[PaperDocUpdateError.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError = iArr;
            try {
                iArr[PaperDocUpdateError.INSUFFICIENT_PERMISSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError[PaperDocUpdateError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError[PaperDocUpdateError.DOC_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError[PaperDocUpdateError.CONTENT_MALFORMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError[PaperDocUpdateError.REVISION_MISMATCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError[PaperDocUpdateError.DOC_LENGTH_EXCEEDED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError[PaperDocUpdateError.IMAGE_SIZE_EXCEEDED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError[PaperDocUpdateError.DOC_ARCHIVED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperDocUpdateError[PaperDocUpdateError.DOC_DELETED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
