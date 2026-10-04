package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AccountState;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class AccountLockOrUnlockedDetails {

    @Nonnull
    protected final AccountState newValue;

    @Nonnull
    protected final AccountState previousValue;

    public AccountLockOrUnlockedDetails(@Nonnull AccountState accountState, @Nonnull AccountState accountState2) {
        if (accountState == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = accountState;
        if (accountState2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = accountState2;
    }

    @Nonnull
    public AccountState getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public AccountState getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        AccountState accountState;
        AccountState accountState2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AccountLockOrUnlockedDetails accountLockOrUnlockedDetails = (AccountLockOrUnlockedDetails) obj;
        AccountState accountState3 = this.previousValue;
        AccountState accountState4 = accountLockOrUnlockedDetails.previousValue;
        return (accountState3 == accountState4 || accountState3.equals(accountState4)) && ((accountState = this.newValue) == (accountState2 = accountLockOrUnlockedDetails.newValue) || accountState.equals(accountState2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AccountLockOrUnlockedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AccountLockOrUnlockedDetails accountLockOrUnlockedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            AccountState.Serializer.INSTANCE.serialize(accountLockOrUnlockedDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            AccountState.Serializer.INSTANCE.serialize(accountLockOrUnlockedDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AccountLockOrUnlockedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccountState accountStateDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AccountState accountStateDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        accountStateDeserialize = AccountState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        accountStateDeserialize2 = AccountState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accountStateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (accountStateDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                AccountLockOrUnlockedDetails accountLockOrUnlockedDetails = new AccountLockOrUnlockedDetails(accountStateDeserialize, accountStateDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(accountLockOrUnlockedDetails, accountLockOrUnlockedDetails.toStringMultiline());
                return accountLockOrUnlockedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
