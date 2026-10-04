package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum DocLookupError {
    INSUFFICIENT_PERMISSIONS,
    OTHER,
    DOC_NOT_FOUND;

    static class Serializer extends UnionSerializer<DocLookupError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DocLookupError docLookupError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42271.$SwitchMap$com$dropbox$core$v2$paper$DocLookupError[docLookupError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("insufficient_permissions");
            } else if (i == 2) {
                jsonGenerator.writeString("other");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("doc_not_found");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + docLookupError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DocLookupError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DocLookupError docLookupError;
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
                docLookupError = DocLookupError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                docLookupError = DocLookupError.OTHER;
            } else if ("doc_not_found".equals(tag)) {
                docLookupError = DocLookupError.DOC_NOT_FOUND;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return docLookupError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.DocLookupError$1 */
    static /* synthetic */ class C42271 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$DocLookupError;

        static {
            int[] iArr = new int[DocLookupError.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$DocLookupError = iArr;
            try {
                iArr[DocLookupError.INSUFFICIENT_PERMISSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$DocLookupError[DocLookupError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$DocLookupError[DocLookupError.DOC_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
