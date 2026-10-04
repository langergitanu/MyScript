package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SmarterSmartSyncPolicyState {
    DISABLED,
    ENABLED,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.SmarterSmartSyncPolicyState$1 */
    static /* synthetic */ class C45571 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teampolicies$SmarterSmartSyncPolicyState */
        static final /* synthetic */ int[] f813xb82c1b08;

        static {
            int[] iArr = new int[SmarterSmartSyncPolicyState.values().length];
            f813xb82c1b08 = iArr;
            try {
                iArr[SmarterSmartSyncPolicyState.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f813xb82c1b08[SmarterSmartSyncPolicyState.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<SmarterSmartSyncPolicyState> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SmarterSmartSyncPolicyState smarterSmartSyncPolicyState, JsonGenerator jsonGenerator) throws IOException {
            int i = C45571.f813xb82c1b08[smarterSmartSyncPolicyState.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SmarterSmartSyncPolicyState deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SmarterSmartSyncPolicyState smarterSmartSyncPolicyState;
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
                smarterSmartSyncPolicyState = SmarterSmartSyncPolicyState.DISABLED;
            } else if ("enabled".equals(tag)) {
                smarterSmartSyncPolicyState = SmarterSmartSyncPolicyState.ENABLED;
            } else {
                smarterSmartSyncPolicyState = SmarterSmartSyncPolicyState.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return smarterSmartSyncPolicyState;
        }
    }
}
