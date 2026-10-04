package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SmartSyncPolicy {
    LOCAL,
    ON_DEMAND,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.SmartSyncPolicy$1 */
    static /* synthetic */ class C45561 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teampolicies$SmartSyncPolicy;

        static {
            int[] iArr = new int[SmartSyncPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teampolicies$SmartSyncPolicy = iArr;
            try {
                iArr[SmartSyncPolicy.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teampolicies$SmartSyncPolicy[SmartSyncPolicy.ON_DEMAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<SmartSyncPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SmartSyncPolicy smartSyncPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45561.$SwitchMap$com$dropbox$core$v2$teampolicies$SmartSyncPolicy[smartSyncPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString(ImagesContract.LOCAL);
            } else if (i == 2) {
                jsonGenerator.writeString("on_demand");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SmartSyncPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SmartSyncPolicy smartSyncPolicy;
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
            if (ImagesContract.LOCAL.equals(tag)) {
                smartSyncPolicy = SmartSyncPolicy.LOCAL;
            } else if ("on_demand".equals(tag)) {
                smartSyncPolicy = SmartSyncPolicy.ON_DEMAND;
            } else {
                smartSyncPolicy = SmartSyncPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return smartSyncPolicy;
        }
    }
}
