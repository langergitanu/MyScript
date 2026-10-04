package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SmartSyncOptOutPolicy {
    DEFAULT,
    OPTED_OUT,
    OTHER;

    static class Serializer extends UnionSerializer<SmartSyncOptOutPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SmartSyncOptOutPolicy smartSyncOptOutPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45231.$SwitchMap$com$dropbox$core$v2$teamlog$SmartSyncOptOutPolicy[smartSyncOptOutPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("default");
            } else if (i == 2) {
                jsonGenerator.writeString("opted_out");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SmartSyncOptOutPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SmartSyncOptOutPolicy smartSyncOptOutPolicy;
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
            if ("default".equals(tag)) {
                smartSyncOptOutPolicy = SmartSyncOptOutPolicy.DEFAULT;
            } else if ("opted_out".equals(tag)) {
                smartSyncOptOutPolicy = SmartSyncOptOutPolicy.OPTED_OUT;
            } else {
                smartSyncOptOutPolicy = SmartSyncOptOutPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return smartSyncOptOutPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SmartSyncOptOutPolicy$1 */
    static /* synthetic */ class C45231 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$SmartSyncOptOutPolicy;

        static {
            int[] iArr = new int[SmartSyncOptOutPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$SmartSyncOptOutPolicy = iArr;
            try {
                iArr[SmartSyncOptOutPolicy.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SmartSyncOptOutPolicy[SmartSyncOptOutPolicy.OPTED_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
