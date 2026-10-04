package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum DeleteBatchError {
    TOO_MANY_WRITE_OPERATIONS,
    OTHER;

    static class Serializer extends UnionSerializer<DeleteBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeleteBatchError deleteBatchError, JsonGenerator jsonGenerator) throws IOException {
            if (C41501.$SwitchMap$com$dropbox$core$v2$files$DeleteBatchError[deleteBatchError.ordinal()] == 1) {
                jsonGenerator.writeString("too_many_write_operations");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeleteBatchError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeleteBatchError deleteBatchError;
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
            if ("too_many_write_operations".equals(tag)) {
                deleteBatchError = DeleteBatchError.TOO_MANY_WRITE_OPERATIONS;
            } else {
                deleteBatchError = DeleteBatchError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deleteBatchError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.DeleteBatchError$1 */
    static /* synthetic */ class C41501 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$DeleteBatchError;

        static {
            int[] iArr = new int[DeleteBatchError.values().length];
            $SwitchMap$com$dropbox$core$v2$files$DeleteBatchError = iArr;
            try {
                iArr[DeleteBatchError.TOO_MANY_WRITE_OPERATIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
