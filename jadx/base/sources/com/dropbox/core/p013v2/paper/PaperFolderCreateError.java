package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PaperFolderCreateError {
    INSUFFICIENT_PERMISSIONS,
    OTHER,
    FOLDER_NOT_FOUND,
    INVALID_FOLDER_ID;

    static class Serializer extends UnionSerializer<PaperFolderCreateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperFolderCreateError paperFolderCreateError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42411.$SwitchMap$com$dropbox$core$v2$paper$PaperFolderCreateError[paperFolderCreateError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("insufficient_permissions");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("other");
            } else if (i == 3) {
                jsonGenerator.writeString("folder_not_found");
            } else {
                if (i == 4) {
                    jsonGenerator.writeString("invalid_folder_id");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + paperFolderCreateError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperFolderCreateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperFolderCreateError paperFolderCreateError;
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
                paperFolderCreateError = PaperFolderCreateError.INSUFFICIENT_PERMISSIONS;
            } else if ("other".equals(tag)) {
                paperFolderCreateError = PaperFolderCreateError.OTHER;
            } else if ("folder_not_found".equals(tag)) {
                paperFolderCreateError = PaperFolderCreateError.FOLDER_NOT_FOUND;
            } else if ("invalid_folder_id".equals(tag)) {
                paperFolderCreateError = PaperFolderCreateError.INVALID_FOLDER_ID;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperFolderCreateError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.PaperFolderCreateError$1 */
    static /* synthetic */ class C42411 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$PaperFolderCreateError;

        static {
            int[] iArr = new int[PaperFolderCreateError.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$PaperFolderCreateError = iArr;
            try {
                iArr[PaperFolderCreateError.INSUFFICIENT_PERMISSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperFolderCreateError[PaperFolderCreateError.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperFolderCreateError[PaperFolderCreateError.FOLDER_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$PaperFolderCreateError[PaperFolderCreateError.INVALID_FOLDER_ID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
