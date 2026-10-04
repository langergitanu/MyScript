package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum CreateFolderBatchError {
    TOO_MANY_FILES,
    OTHER;

    static class Serializer extends UnionSerializer<CreateFolderBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CreateFolderBatchError createFolderBatchError, JsonGenerator jsonGenerator) throws IOException {
            if (C41441.$SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchError[createFolderBatchError.ordinal()] == 1) {
                jsonGenerator.writeString("too_many_files");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CreateFolderBatchError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CreateFolderBatchError createFolderBatchError;
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
            if ("too_many_files".equals(tag)) {
                createFolderBatchError = CreateFolderBatchError.TOO_MANY_FILES;
            } else {
                createFolderBatchError = CreateFolderBatchError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return createFolderBatchError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.CreateFolderBatchError$1 */
    static /* synthetic */ class C41441 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchError;

        static {
            int[] iArr = new int[CreateFolderBatchError.values().length];
            $SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchError = iArr;
            try {
                iArr[CreateFolderBatchError.TOO_MANY_FILES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
