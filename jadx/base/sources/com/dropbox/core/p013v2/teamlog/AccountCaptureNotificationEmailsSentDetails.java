package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AccountCaptureNotificationType;
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
public class AccountCaptureNotificationEmailsSentDetails {

    @Nonnull
    protected final String domainName;

    @Nullable
    protected final AccountCaptureNotificationType notificationType;

    public AccountCaptureNotificationEmailsSentDetails(@Nonnull String str, @Nullable AccountCaptureNotificationType accountCaptureNotificationType) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'domainName' is null");
        }
        this.domainName = str;
        this.notificationType = accountCaptureNotificationType;
    }

    public AccountCaptureNotificationEmailsSentDetails(@Nonnull String str) {
        this(str, null);
    }

    @Nonnull
    public String getDomainName() {
        return this.domainName;
    }

    @Nullable
    public AccountCaptureNotificationType getNotificationType() {
        return this.notificationType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.domainName, this.notificationType});
    }

    public boolean equals(Object obj) {
        AccountCaptureNotificationType accountCaptureNotificationType;
        AccountCaptureNotificationType accountCaptureNotificationType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AccountCaptureNotificationEmailsSentDetails accountCaptureNotificationEmailsSentDetails = (AccountCaptureNotificationEmailsSentDetails) obj;
        String str = this.domainName;
        String str2 = accountCaptureNotificationEmailsSentDetails.domainName;
        return (str == str2 || str.equals(str2)) && ((accountCaptureNotificationType = this.notificationType) == (accountCaptureNotificationType2 = accountCaptureNotificationEmailsSentDetails.notificationType) || (accountCaptureNotificationType != null && accountCaptureNotificationType.equals(accountCaptureNotificationType2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AccountCaptureNotificationEmailsSentDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AccountCaptureNotificationEmailsSentDetails accountCaptureNotificationEmailsSentDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("domain_name");
            StoneSerializers.string().serialize(accountCaptureNotificationEmailsSentDetails.domainName, jsonGenerator);
            if (accountCaptureNotificationEmailsSentDetails.notificationType != null) {
                jsonGenerator.writeFieldName("notification_type");
                StoneSerializers.nullable(AccountCaptureNotificationType.Serializer.INSTANCE).serialize(accountCaptureNotificationEmailsSentDetails.notificationType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AccountCaptureNotificationEmailsSentDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AccountCaptureNotificationType accountCaptureNotificationType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("domain_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("notification_type".equals(currentName)) {
                        accountCaptureNotificationType = (AccountCaptureNotificationType) StoneSerializers.nullable(AccountCaptureNotificationType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"domain_name\" missing.");
                }
                AccountCaptureNotificationEmailsSentDetails accountCaptureNotificationEmailsSentDetails = new AccountCaptureNotificationEmailsSentDetails(strDeserialize, accountCaptureNotificationType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(accountCaptureNotificationEmailsSentDetails, accountCaptureNotificationEmailsSentDetails.toStringMultiline());
                return accountCaptureNotificationEmailsSentDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
