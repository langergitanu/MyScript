package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum MoveIntoFamilyError {
    IS_SHARED_FOLDER,
    OTHER;

    static class Serializer extends UnionSerializer<MoveIntoFamilyError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MoveIntoFamilyError moveIntoFamilyError, JsonGenerator jsonGenerator) throws IOException {
            if (C41771.$SwitchMap$com$dropbox$core$v2$files$MoveIntoFamilyError[moveIntoFamilyError.ordinal()] == 1) {
                jsonGenerator.writeString("is_shared_folder");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MoveIntoFamilyError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MoveIntoFamilyError moveIntoFamilyError;
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
                moveIntoFamilyError = MoveIntoFamilyError.IS_SHARED_FOLDER;
            } else {
                moveIntoFamilyError = MoveIntoFamilyError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return moveIntoFamilyError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.MoveIntoFamilyError$1 */
    static /* synthetic */ class C41771 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$MoveIntoFamilyError;

        static {
            int[] iArr = new int[MoveIntoFamilyError.values().length];
            $SwitchMap$com$dropbox$core$v2$files$MoveIntoFamilyError = iArr;
            try {
                iArr[MoveIntoFamilyError.IS_SHARED_FOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
