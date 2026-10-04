package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AccountCaptureAvailability;
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
public class AccountCaptureChangeAvailabilityDetails {

    @Nonnull
    protected final AccountCaptureAvailability newValue;

    @Nullable
    protected final AccountCaptureAvailability previousValue;

    public AccountCaptureChangeAvailabilityDetails(@Nonnull AccountCaptureAvailability accountCaptureAvailability, @Nullable AccountCaptureAvailability accountCaptureAvailability2) {
        if (accountCaptureAvailability == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = accountCaptureAvailability;
        this.previousValue = accountCaptureAvailability2;
    }

    public AccountCaptureChangeAvailabilityDetails(@Nonnull AccountCaptureAvailability accountCaptureAvailability) {
        this(accountCaptureAvailability, null);
    }

    @Nonnull
    public AccountCaptureAvailability getNewValue() {
        return this.newValue;
    }

    @Nullable
    public AccountCaptureAvailability getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        AccountCaptureAvailability accountCaptureAvailability;
        AccountCaptureAvailability accountCaptureAvailability2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AccountCaptureChangeAvailabilityDetails accountCaptureChangeAvailabilityDetails = (AccountCaptureChangeAvailabilityDetails) obj;
        AccountCaptureAvailability accountCaptureAvailability3 = this.newValue;
        AccountCaptureAvailability accountCaptureAvailability4 = accountCaptureChangeAvailabilityDetails.newValue;
        return (accountCaptureAvailability3 == accountCaptureAvailability4 || accountCaptureAvailability3.equals(accountCaptureAvailability4)) && ((accountCaptureAvailability = this.previousValue) == (accountCaptureAvailability2 = accountCaptureChangeAvailabilityDetails.previousValue) || (accountCaptureAvailability != null && accountCaptureAvailability.equals(accountCaptureAvailability2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AccountCaptureChangeAvailabilityDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AccountCaptureChangeAvailabilityDetails accountCaptureChangeAvailabilityDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            AccountCaptureAvailability.Serializer.INSTANCE.serialize(accountCaptureChangeAvailabilityDetails.newValue, jsonGenerator);
            if (accountCaptureChangeAvailabilityDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(AccountCaptureAvailability.Serializer.INSTANCE).serialize(accountCaptureChangeAvailabilityDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AccountCaptureChangeAvailabilityDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccountCaptureAvailability accountCaptureAvailabilityDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AccountCaptureAvailability accountCaptureAvailability = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        accountCaptureAvailabilityDeserialize = AccountCaptureAvailability.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        accountCaptureAvailability = (AccountCaptureAvailability) StoneSerializers.nullable(AccountCaptureAvailability.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accountCaptureAvailabilityDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                AccountCaptureChangeAvailabilityDetails accountCaptureChangeAvailabilityDetails = new AccountCaptureChangeAvailabilityDetails(accountCaptureAvailabilityDeserialize, accountCaptureAvailability);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(accountCaptureChangeAvailabilityDetails, accountCaptureChangeAvailabilityDetails.toStringMultiline());
                return accountCaptureChangeAvailabilityDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
