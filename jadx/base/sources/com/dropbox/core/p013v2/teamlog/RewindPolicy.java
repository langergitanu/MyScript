package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum RewindPolicy {
    ADMINS_ONLY,
    EVERYONE,
    OTHER;

    static class Serializer extends UnionSerializer<RewindPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RewindPolicy rewindPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45111.$SwitchMap$com$dropbox$core$v2$teamlog$RewindPolicy[rewindPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("admins_only");
            } else if (i == 2) {
                jsonGenerator.writeString("everyone");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RewindPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RewindPolicy rewindPolicy;
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
            if ("admins_only".equals(tag)) {
                rewindPolicy = RewindPolicy.ADMINS_ONLY;
            } else if ("everyone".equals(tag)) {
                rewindPolicy = RewindPolicy.EVERYONE;
            } else {
                rewindPolicy = RewindPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return rewindPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.RewindPolicy$1 */
    static /* synthetic */ class C45111 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$RewindPolicy;

        static {
            int[] iArr = new int[RewindPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$RewindPolicy = iArr;
            try {
                iArr[RewindPolicy.ADMINS_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$RewindPolicy[RewindPolicy.EVERYONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
