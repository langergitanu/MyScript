package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AccountCapturePolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class AccountCaptureChangePolicyDetails {

    @Nonnull
    protected final AccountCapturePolicy newValue;

    @Nullable
    protected final AccountCapturePolicy previousValue;

    public AccountCaptureChangePolicyDetails(@Nonnull AccountCapturePolicy accountCapturePolicy, @Nullable AccountCapturePolicy accountCapturePolicy2) {
        if (accountCapturePolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = accountCapturePolicy;
        this.previousValue = accountCapturePolicy2;
    }

    public AccountCaptureChangePolicyDetails(@Nonnull AccountCapturePolicy accountCapturePolicy) {
        this(accountCapturePolicy, null);
    }

    @Nonnull
    public AccountCapturePolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public AccountCapturePolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        AccountCapturePolicy accountCapturePolicy;
        AccountCapturePolicy accountCapturePolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AccountCaptureChangePolicyDetails accountCaptureChangePolicyDetails = (AccountCaptureChangePolicyDetails) obj;
        AccountCapturePolicy accountCapturePolicy3 = this.newValue;
        AccountCapturePolicy accountCapturePolicy4 = accountCaptureChangePolicyDetails.newValue;
        return (accountCapturePolicy3 == accountCapturePolicy4 || accountCapturePolicy3.equals(accountCapturePolicy4)) && ((accountCapturePolicy = this.previousValue) == (accountCapturePolicy2 = accountCaptureChangePolicyDetails.previousValue) || (accountCapturePolicy != null && accountCapturePolicy.equals(accountCapturePolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AccountCaptureChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AccountCaptureChangePolicyDetails accountCaptureChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            AccountCapturePolicy.Serializer.INSTANCE.serialize(accountCaptureChangePolicyDetails.newValue, jsonGenerator);
            if (accountCaptureChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(AccountCapturePolicy.Serializer.INSTANCE).serialize(accountCaptureChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AccountCaptureChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccountCapturePolicy accountCapturePolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AccountCapturePolicy accountCapturePolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        accountCapturePolicyDeserialize = AccountCapturePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        accountCapturePolicy = (AccountCapturePolicy) StoneSerializers.nullable(AccountCapturePolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accountCapturePolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                AccountCaptureChangePolicyDetails accountCaptureChangePolicyDetails = new AccountCaptureChangePolicyDetails(accountCapturePolicyDeserialize, accountCapturePolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(accountCaptureChangePolicyDetails, accountCaptureChangePolicyDetails.toStringMultiline());
                return accountCaptureChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
