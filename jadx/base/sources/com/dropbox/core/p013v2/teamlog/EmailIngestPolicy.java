package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum EmailIngestPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<EmailIngestPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(EmailIngestPolicy emailIngestPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44621.$SwitchMap$com$dropbox$core$v2$teamlog$EmailIngestPolicy[emailIngestPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public EmailIngestPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            EmailIngestPolicy emailIngestPolicy;
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
                emailIngestPolicy = EmailIngestPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                emailIngestPolicy = EmailIngestPolicy.ENABLED;
            } else {
                emailIngestPolicy = EmailIngestPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return emailIngestPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.EmailIngestPolicy$1 */
    static /* synthetic */ class C44621 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$EmailIngestPolicy;

        static {
            int[] iArr = new int[EmailIngestPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$EmailIngestPolicy = iArr;
            try {
                iArr[EmailIngestPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EmailIngestPolicy[EmailIngestPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
