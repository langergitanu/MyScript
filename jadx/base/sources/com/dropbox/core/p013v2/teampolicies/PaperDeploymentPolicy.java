package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum PaperDeploymentPolicy {
    FULL,
    PARTIAL,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.PaperDeploymentPolicy$1 */
    static /* synthetic */ class C45481 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teampolicies$PaperDeploymentPolicy */
        static final /* synthetic */ int[] f807x1c84151a;

        static {
            int[] iArr = new int[PaperDeploymentPolicy.values().length];
            f807x1c84151a = iArr;
            try {
                iArr[PaperDeploymentPolicy.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f807x1c84151a[PaperDeploymentPolicy.PARTIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<PaperDeploymentPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperDeploymentPolicy paperDeploymentPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45481.f807x1c84151a[paperDeploymentPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("full");
            } else if (i == 2) {
                jsonGenerator.writeString("partial");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperDeploymentPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperDeploymentPolicy paperDeploymentPolicy;
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
            if ("full".equals(tag)) {
                paperDeploymentPolicy = PaperDeploymentPolicy.FULL;
            } else if ("partial".equals(tag)) {
                paperDeploymentPolicy = PaperDeploymentPolicy.PARTIAL;
            } else {
                paperDeploymentPolicy = PaperDeploymentPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperDeploymentPolicy;
        }
    }
}
