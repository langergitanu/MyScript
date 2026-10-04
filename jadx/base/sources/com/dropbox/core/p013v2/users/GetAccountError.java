package com.dropbox.core.p013v2.users;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GetAccountError {
    NO_ACCOUNT,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.users.GetAccountError$1 */
    static /* synthetic */ class C45631 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$users$GetAccountError;

        static {
            int[] iArr = new int[GetAccountError.values().length];
            $SwitchMap$com$dropbox$core$v2$users$GetAccountError = iArr;
            try {
                iArr[GetAccountError.NO_ACCOUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<GetAccountError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetAccountError getAccountError, JsonGenerator jsonGenerator) throws IOException {
            if (C45631.$SwitchMap$com$dropbox$core$v2$users$GetAccountError[getAccountError.ordinal()] == 1) {
                jsonGenerator.writeString("no_account");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetAccountError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetAccountError getAccountError;
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
            if ("no_account".equals(tag)) {
                getAccountError = GetAccountError.NO_ACCOUNT;
            } else {
                getAccountError = GetAccountError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getAccountError;
        }
    }
}
