package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PendingUploadMode {
    FILE,
    FOLDER;

    static class Serializer extends UnionSerializer<PendingUploadMode> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PendingUploadMode pendingUploadMode, JsonGenerator jsonGenerator) throws IOException {
            int i = C42851.$SwitchMap$com$dropbox$core$v2$sharing$PendingUploadMode[pendingUploadMode.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("file");
            } else {
                if (i == 2) {
                    jsonGenerator.writeString("folder");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + pendingUploadMode);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PendingUploadMode deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PendingUploadMode pendingUploadMode;
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
                pendingUploadMode = PendingUploadMode.FILE;
            } else if ("folder".equals(tag)) {
                pendingUploadMode = PendingUploadMode.FOLDER;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return pendingUploadMode;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.PendingUploadMode$1 */
    static /* synthetic */ class C42851 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$PendingUploadMode;

        static {
            int[] iArr = new int[PendingUploadMode.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$PendingUploadMode = iArr;
            try {
                iArr[PendingUploadMode.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$PendingUploadMode[PendingUploadMode.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
