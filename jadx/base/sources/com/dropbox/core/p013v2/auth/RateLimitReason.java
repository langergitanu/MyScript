package com.dropbox.core.p013v2.auth;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum RateLimitReason {
    TOO_MANY_REQUESTS,
    TOO_MANY_WRITE_OPERATIONS,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.auth.RateLimitReason$1 */
    static /* synthetic */ class C41111 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$auth$RateLimitReason;

        static {
            int[] iArr = new int[RateLimitReason.values().length];
            $SwitchMap$com$dropbox$core$v2$auth$RateLimitReason = iArr;
            try {
                iArr[RateLimitReason.TOO_MANY_REQUESTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$RateLimitReason[RateLimitReason.TOO_MANY_WRITE_OPERATIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<RateLimitReason> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RateLimitReason rateLimitReason, JsonGenerator jsonGenerator) throws IOException {
            int i = C41111.$SwitchMap$com$dropbox$core$v2$auth$RateLimitReason[rateLimitReason.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("too_many_requests");
            } else if (i == 2) {
                jsonGenerator.writeString("too_many_write_operations");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RateLimitReason deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RateLimitReason rateLimitReason;
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
            if ("too_many_requests".equals(tag)) {
                rateLimitReason = RateLimitReason.TOO_MANY_REQUESTS;
            } else if ("too_many_write_operations".equals(tag)) {
                rateLimitReason = RateLimitReason.TOO_MANY_WRITE_OPERATIONS;
            } else {
                rateLimitReason = RateLimitReason.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return rateLimitReason;
        }
    }
}
