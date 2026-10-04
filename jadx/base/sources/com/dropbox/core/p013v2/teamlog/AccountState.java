package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AccountState {
    LOCKED,
    UNLOCKED,
    OTHER;

    static class Serializer extends UnionSerializer<AccountState> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AccountState accountState, JsonGenerator jsonGenerator) throws IOException {
            int i = C44321.$SwitchMap$com$dropbox$core$v2$teamlog$AccountState[accountState.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("locked");
            } else if (i == 2) {
                jsonGenerator.writeString("unlocked");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AccountState deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AccountState accountState;
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
            if ("locked".equals(tag)) {
                accountState = AccountState.LOCKED;
            } else if ("unlocked".equals(tag)) {
                accountState = AccountState.UNLOCKED;
            } else {
                accountState = AccountState.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return accountState;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AccountState$1 */
    static /* synthetic */ class C44321 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$AccountState;

        static {
            int[] iArr = new int[AccountState.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$AccountState = iArr;
            try {
                iArr[AccountState.LOCKED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AccountState[AccountState.UNLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
