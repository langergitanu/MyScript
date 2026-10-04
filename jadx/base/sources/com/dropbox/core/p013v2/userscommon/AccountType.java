package com.dropbox.core.p013v2.userscommon;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AccountType {
    BASIC,
    PRO,
    BUSINESS;

    /* JADX INFO: renamed from: com.dropbox.core.v2.userscommon.AccountType$1 */
    static /* synthetic */ class C45691 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$userscommon$AccountType;

        static {
            int[] iArr = new int[AccountType.values().length];
            $SwitchMap$com$dropbox$core$v2$userscommon$AccountType = iArr;
            try {
                iArr[AccountType.BASIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$userscommon$AccountType[AccountType.PRO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$userscommon$AccountType[AccountType.BUSINESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<AccountType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AccountType accountType, JsonGenerator jsonGenerator) throws IOException {
            int i = C45691.$SwitchMap$com$dropbox$core$v2$userscommon$AccountType[accountType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("basic");
            } else if (i == 2) {
                jsonGenerator.writeString("pro");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("business");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + accountType);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AccountType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AccountType accountType;
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
            if ("basic".equals(tag)) {
                accountType = AccountType.BASIC;
            } else if ("pro".equals(tag)) {
                accountType = AccountType.PRO;
            } else if ("business".equals(tag)) {
                accountType = AccountType.BUSINESS;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return accountType;
        }
    }
}
