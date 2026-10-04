package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum UploadSessionType {
    SEQUENTIAL,
    CONCURRENT,
    OTHER;

    static class Serializer extends UnionSerializer<UploadSessionType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UploadSessionType uploadSessionType, JsonGenerator jsonGenerator) throws IOException {
            int i = C42201.$SwitchMap$com$dropbox$core$v2$files$UploadSessionType[uploadSessionType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("sequential");
            } else if (i == 2) {
                jsonGenerator.writeString("concurrent");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UploadSessionType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UploadSessionType uploadSessionType;
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
            if ("sequential".equals(tag)) {
                uploadSessionType = UploadSessionType.SEQUENTIAL;
            } else if ("concurrent".equals(tag)) {
                uploadSessionType = UploadSessionType.CONCURRENT;
            } else {
                uploadSessionType = UploadSessionType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return uploadSessionType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.UploadSessionType$1 */
    static /* synthetic */ class C42201 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$UploadSessionType;

        static {
            int[] iArr = new int[UploadSessionType.values().length];
            $SwitchMap$com$dropbox$core$v2$files$UploadSessionType = iArr;
            try {
                iArr[UploadSessionType.SEQUENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$UploadSessionType[UploadSessionType.CONCURRENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
