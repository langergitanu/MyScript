package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ChangeLinkExpirationPolicy {
    ALLOWED,
    NOT_ALLOWED,
    OTHER;

    static class Serializer extends UnionSerializer<ChangeLinkExpirationPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ChangeLinkExpirationPolicy changeLinkExpirationPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44491.f783x2f27e5b6[changeLinkExpirationPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("allowed");
            } else if (i == 2) {
                jsonGenerator.writeString("not_allowed");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ChangeLinkExpirationPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ChangeLinkExpirationPolicy changeLinkExpirationPolicy;
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
            if ("allowed".equals(tag)) {
                changeLinkExpirationPolicy = ChangeLinkExpirationPolicy.ALLOWED;
            } else if ("not_allowed".equals(tag)) {
                changeLinkExpirationPolicy = ChangeLinkExpirationPolicy.NOT_ALLOWED;
            } else {
                changeLinkExpirationPolicy = ChangeLinkExpirationPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return changeLinkExpirationPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ChangeLinkExpirationPolicy$1 */
    static /* synthetic */ class C44491 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$ChangeLinkExpirationPolicy */
        static final /* synthetic */ int[] f783x2f27e5b6;

        static {
            int[] iArr = new int[ChangeLinkExpirationPolicy.values().length];
            f783x2f27e5b6 = iArr;
            try {
                iArr[ChangeLinkExpirationPolicy.ALLOWED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f783x2f27e5b6[ChangeLinkExpirationPolicy.NOT_ALLOWED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
