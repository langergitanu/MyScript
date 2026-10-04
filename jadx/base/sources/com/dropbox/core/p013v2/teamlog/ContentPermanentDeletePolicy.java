package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ContentPermanentDeletePolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<ContentPermanentDeletePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ContentPermanentDeletePolicy contentPermanentDeletePolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44531.f785xac2071dd[contentPermanentDeletePolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ContentPermanentDeletePolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ContentPermanentDeletePolicy contentPermanentDeletePolicy;
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
                contentPermanentDeletePolicy = ContentPermanentDeletePolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                contentPermanentDeletePolicy = ContentPermanentDeletePolicy.ENABLED;
            } else {
                contentPermanentDeletePolicy = ContentPermanentDeletePolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return contentPermanentDeletePolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ContentPermanentDeletePolicy$1 */
    static /* synthetic */ class C44531 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$ContentPermanentDeletePolicy */
        static final /* synthetic */ int[] f785xac2071dd;

        static {
            int[] iArr = new int[ContentPermanentDeletePolicy.values().length];
            f785xac2071dd = iArr;
            try {
                iArr[ContentPermanentDeletePolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f785xac2071dd[ContentPermanentDeletePolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
