package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum MoveIntoVaultError {
    IS_SHARED_FOLDER,
    OTHER;

    static class Serializer extends UnionSerializer<MoveIntoVaultError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MoveIntoVaultError moveIntoVaultError, JsonGenerator jsonGenerator) throws IOException {
            if (C41781.$SwitchMap$com$dropbox$core$v2$files$MoveIntoVaultError[moveIntoVaultError.ordinal()] == 1) {
                jsonGenerator.writeString("is_shared_folder");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MoveIntoVaultError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MoveIntoVaultError moveIntoVaultError;
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
            if ("is_shared_folder".equals(tag)) {
                moveIntoVaultError = MoveIntoVaultError.IS_SHARED_FOLDER;
            } else {
                moveIntoVaultError = MoveIntoVaultError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return moveIntoVaultError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.MoveIntoVaultError$1 */
    static /* synthetic */ class C41781 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$MoveIntoVaultError;

        static {
            int[] iArr = new int[MoveIntoVaultError.values().length];
            $SwitchMap$com$dropbox$core$v2$files$MoveIntoVaultError = iArr;
            try {
                iArr[MoveIntoVaultError.IS_SHARED_FOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
