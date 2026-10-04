package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AccountCaptureAvailability {
    AVAILABLE,
    UNAVAILABLE,
    OTHER;

    static class Serializer extends UnionSerializer<AccountCaptureAvailability> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AccountCaptureAvailability accountCaptureAvailability, JsonGenerator jsonGenerator) throws IOException {
            int i = C44291.f773x2092dd5f[accountCaptureAvailability.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("available");
            } else if (i == 2) {
                jsonGenerator.writeString("unavailable");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AccountCaptureAvailability deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AccountCaptureAvailability accountCaptureAvailability;
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
            if ("available".equals(tag)) {
                accountCaptureAvailability = AccountCaptureAvailability.AVAILABLE;
            } else if ("unavailable".equals(tag)) {
                accountCaptureAvailability = AccountCaptureAvailability.UNAVAILABLE;
            } else {
                accountCaptureAvailability = AccountCaptureAvailability.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return accountCaptureAvailability;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AccountCaptureAvailability$1 */
    static /* synthetic */ class C44291 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$AccountCaptureAvailability */
        static final /* synthetic */ int[] f773x2092dd5f;

        static {
            int[] iArr = new int[AccountCaptureAvailability.values().length];
            f773x2092dd5f = iArr;
            try {
                iArr[AccountCaptureAvailability.AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f773x2092dd5f[AccountCaptureAvailability.UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
