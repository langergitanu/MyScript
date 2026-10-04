package com.dropbox.core.p013v2.users;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class GetAccountBatchError {
    public static final GetAccountBatchError OTHER = new GetAccountBatchError().withTag(Tag.OTHER);
    private Tag _tag;
    private String noAccountValue;

    public enum Tag {
        NO_ACCOUNT,
        OTHER
    }

    private GetAccountBatchError() {
    }

    private GetAccountBatchError withTag(Tag tag) {
        GetAccountBatchError getAccountBatchError = new GetAccountBatchError();
        getAccountBatchError._tag = tag;
        return getAccountBatchError;
    }

    private GetAccountBatchError withTagAndNoAccount(Tag tag, String str) {
        GetAccountBatchError getAccountBatchError = new GetAccountBatchError();
        getAccountBatchError._tag = tag;
        getAccountBatchError.noAccountValue = str;
        return getAccountBatchError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isNoAccount() {
        return this._tag == Tag.NO_ACCOUNT;
    }

    public static GetAccountBatchError noAccount(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 40) {
            throw new IllegalArgumentException("String is shorter than 40");
        }
        if (str.length() > 40) {
            throw new IllegalArgumentException("String is longer than 40");
        }
        return new GetAccountBatchError().withTagAndNoAccount(Tag.NO_ACCOUNT, str);
    }

    public String getNoAccountValue() {
        if (this._tag != Tag.NO_ACCOUNT) {
            throw new IllegalStateException("Invalid tag: required Tag.NO_ACCOUNT, but was Tag." + this._tag.name());
        }
        return this.noAccountValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.noAccountValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GetAccountBatchError)) {
            return false;
        }
        GetAccountBatchError getAccountBatchError = (GetAccountBatchError) obj;
        if (this._tag != getAccountBatchError._tag) {
            return false;
        }
        int i = C45621.$SwitchMap$com$dropbox$core$v2$users$GetAccountBatchError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        String str = this.noAccountValue;
        String str2 = getAccountBatchError.noAccountValue;
        return str == str2 || str.equals(str2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.users.GetAccountBatchError$1 */
    static /* synthetic */ class C45621 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$users$GetAccountBatchError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$users$GetAccountBatchError$Tag = iArr;
            try {
                iArr[Tag.NO_ACCOUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$users$GetAccountBatchError$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<GetAccountBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetAccountBatchError getAccountBatchError, JsonGenerator jsonGenerator) throws IOException {
            if (C45621.$SwitchMap$com$dropbox$core$v2$users$GetAccountBatchError$Tag[getAccountBatchError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("no_account", jsonGenerator);
                jsonGenerator.writeFieldName("no_account");
                StoneSerializers.string().serialize(getAccountBatchError.noAccountValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetAccountBatchError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetAccountBatchError getAccountBatchErrorNoAccount;
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
                expectField("no_account", jsonParser);
                getAccountBatchErrorNoAccount = GetAccountBatchError.noAccount(StoneSerializers.string().deserialize(jsonParser));
            } else {
                getAccountBatchErrorNoAccount = GetAccountBatchError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getAccountBatchErrorNoAccount;
        }
    }
}
