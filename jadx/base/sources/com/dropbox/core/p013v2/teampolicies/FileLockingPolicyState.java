package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum FileLockingPolicyState {
    DISABLED,
    ENABLED,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.FileLockingPolicyState$1 */
    static /* synthetic */ class C45441 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teampolicies$FileLockingPolicyState */
        static final /* synthetic */ int[] f805xbf6b658d;

        static {
            int[] iArr = new int[FileLockingPolicyState.values().length];
            f805xbf6b658d = iArr;
            try {
                iArr[FileLockingPolicyState.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f805xbf6b658d[FileLockingPolicyState.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<FileLockingPolicyState> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileLockingPolicyState fileLockingPolicyState, JsonGenerator jsonGenerator) throws IOException {
            int i = C45441.f805xbf6b658d[fileLockingPolicyState.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileLockingPolicyState deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileLockingPolicyState fileLockingPolicyState;
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
            if ("disabled".equals(tag)) {
                fileLockingPolicyState = FileLockingPolicyState.DISABLED;
            } else if ("enabled".equals(tag)) {
                fileLockingPolicyState = FileLockingPolicyState.ENABLED;
            } else {
                fileLockingPolicyState = FileLockingPolicyState.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileLockingPolicyState;
        }
    }
}
