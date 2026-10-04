package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GoogleSsoPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<GoogleSsoPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GoogleSsoPolicy googleSsoPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44831.$SwitchMap$com$dropbox$core$v2$teamlog$GoogleSsoPolicy[googleSsoPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GoogleSsoPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GoogleSsoPolicy googleSsoPolicy;
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
                googleSsoPolicy = GoogleSsoPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                googleSsoPolicy = GoogleSsoPolicy.ENABLED;
            } else {
                googleSsoPolicy = GoogleSsoPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return googleSsoPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.GoogleSsoPolicy$1 */
    static /* synthetic */ class C44831 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$GoogleSsoPolicy;

        static {
            int[] iArr = new int[GoogleSsoPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$GoogleSsoPolicy = iArr;
            try {
                iArr[GoogleSsoPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$GoogleSsoPolicy[GoogleSsoPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
