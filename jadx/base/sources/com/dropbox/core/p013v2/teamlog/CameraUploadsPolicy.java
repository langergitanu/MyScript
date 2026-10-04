package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum CameraUploadsPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<CameraUploadsPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CameraUploadsPolicy cameraUploadsPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44471.$SwitchMap$com$dropbox$core$v2$teamlog$CameraUploadsPolicy[cameraUploadsPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CameraUploadsPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CameraUploadsPolicy cameraUploadsPolicy;
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
                cameraUploadsPolicy = CameraUploadsPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                cameraUploadsPolicy = CameraUploadsPolicy.ENABLED;
            } else {
                cameraUploadsPolicy = CameraUploadsPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return cameraUploadsPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.CameraUploadsPolicy$1 */
    static /* synthetic */ class C44471 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$CameraUploadsPolicy;

        static {
            int[] iArr = new int[CameraUploadsPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$CameraUploadsPolicy = iArr;
            try {
                iArr[CameraUploadsPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$CameraUploadsPolicy[CameraUploadsPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
