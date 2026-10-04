package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum WriteConflictError {
    FILE,
    FOLDER,
    FILE_ANCESTOR,
    OTHER;

    static class Serializer extends UnionSerializer<WriteConflictError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(WriteConflictError writeConflictError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42211.$SwitchMap$com$dropbox$core$v2$files$WriteConflictError[writeConflictError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("file");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("folder");
            } else if (i == 3) {
                jsonGenerator.writeString("file_ancestor");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public WriteConflictError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            WriteConflictError writeConflictError;
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
            if ("file".equals(tag)) {
                writeConflictError = WriteConflictError.FILE;
            } else if ("folder".equals(tag)) {
                writeConflictError = WriteConflictError.FOLDER;
            } else if ("file_ancestor".equals(tag)) {
                writeConflictError = WriteConflictError.FILE_ANCESTOR;
            } else {
                writeConflictError = WriteConflictError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return writeConflictError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.WriteConflictError$1 */
    static /* synthetic */ class C42211 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$WriteConflictError;

        static {
            int[] iArr = new int[WriteConflictError.values().length];
            $SwitchMap$com$dropbox$core$v2$files$WriteConflictError = iArr;
            try {
                iArr[WriteConflictError.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteConflictError[WriteConflictError.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteConflictError[WriteConflictError.FILE_ANCESTOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
