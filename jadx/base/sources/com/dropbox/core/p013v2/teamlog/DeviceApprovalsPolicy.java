package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum DeviceApprovalsPolicy {
    LIMITED,
    UNLIMITED,
    OTHER;

    static class Serializer extends UnionSerializer<DeviceApprovalsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeviceApprovalsPolicy deviceApprovalsPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44561.$SwitchMap$com$dropbox$core$v2$teamlog$DeviceApprovalsPolicy[deviceApprovalsPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("limited");
            } else if (i == 2) {
                jsonGenerator.writeString("unlimited");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeviceApprovalsPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeviceApprovalsPolicy deviceApprovalsPolicy;
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
            if ("limited".equals(tag)) {
                deviceApprovalsPolicy = DeviceApprovalsPolicy.LIMITED;
            } else if ("unlimited".equals(tag)) {
                deviceApprovalsPolicy = DeviceApprovalsPolicy.UNLIMITED;
            } else {
                deviceApprovalsPolicy = DeviceApprovalsPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deviceApprovalsPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.DeviceApprovalsPolicy$1 */
    static /* synthetic */ class C44561 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$DeviceApprovalsPolicy;

        static {
            int[] iArr = new int[DeviceApprovalsPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$DeviceApprovalsPolicy = iArr;
            try {
                iArr[DeviceApprovalsPolicy.LIMITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$DeviceApprovalsPolicy[DeviceApprovalsPolicy.UNLIMITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
