package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum LockStatus {
    LOCKED,
    UNLOCKED,
    OTHER;

    static class Serializer extends UnionSerializer<LockStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LockStatus lockStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C44911.$SwitchMap$com$dropbox$core$v2$teamlog$LockStatus[lockStatus.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("locked");
            } else if (i == 2) {
                jsonGenerator.writeString("unlocked");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LockStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LockStatus lockStatus;
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
            if ("locked".equals(tag)) {
                lockStatus = LockStatus.LOCKED;
            } else if ("unlocked".equals(tag)) {
                lockStatus = LockStatus.UNLOCKED;
            } else {
                lockStatus = LockStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return lockStatus;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.LockStatus$1 */
    static /* synthetic */ class C44911 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$LockStatus;

        static {
            int[] iArr = new int[LockStatus.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$LockStatus = iArr;
            try {
                iArr[LockStatus.LOCKED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LockStatus[LockStatus.UNLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
