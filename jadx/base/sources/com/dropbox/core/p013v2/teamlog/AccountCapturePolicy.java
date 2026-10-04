package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AccountCapturePolicy {
    ALL_USERS,
    DISABLED,
    INVITED_USERS,
    PREVENT_PERSONAL_CREATION,
    OTHER;

    static class Serializer extends UnionSerializer<AccountCapturePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AccountCapturePolicy accountCapturePolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44311.$SwitchMap$com$dropbox$core$v2$teamlog$AccountCapturePolicy[accountCapturePolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("all_users");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("disabled");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("invited_users");
            } else if (i == 4) {
                jsonGenerator.writeString("prevent_personal_creation");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AccountCapturePolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AccountCapturePolicy accountCapturePolicy;
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
            if ("all_users".equals(tag)) {
                accountCapturePolicy = AccountCapturePolicy.ALL_USERS;
            } else if ("disabled".equals(tag)) {
                accountCapturePolicy = AccountCapturePolicy.DISABLED;
            } else if ("invited_users".equals(tag)) {
                accountCapturePolicy = AccountCapturePolicy.INVITED_USERS;
            } else if ("prevent_personal_creation".equals(tag)) {
                accountCapturePolicy = AccountCapturePolicy.PREVENT_PERSONAL_CREATION;
            } else {
                accountCapturePolicy = AccountCapturePolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return accountCapturePolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AccountCapturePolicy$1 */
    static /* synthetic */ class C44311 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$AccountCapturePolicy;

        static {
            int[] iArr = new int[AccountCapturePolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$AccountCapturePolicy = iArr;
            try {
                iArr[AccountCapturePolicy.ALL_USERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AccountCapturePolicy[AccountCapturePolicy.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AccountCapturePolicy[AccountCapturePolicy.INVITED_USERS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AccountCapturePolicy[AccountCapturePolicy.PREVENT_PERSONAL_CREATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
