package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.EmailIngestPolicy;
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
public class EmailIngestPolicyChangedDetails {

    @Nonnull
    protected final EmailIngestPolicy newValue;

    @Nonnull
    protected final EmailIngestPolicy previousValue;

    public EmailIngestPolicyChangedDetails(@Nonnull EmailIngestPolicy emailIngestPolicy, @Nonnull EmailIngestPolicy emailIngestPolicy2) {
        if (emailIngestPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = emailIngestPolicy;
        if (emailIngestPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = emailIngestPolicy2;
    }

    @Nonnull
    public EmailIngestPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public EmailIngestPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        EmailIngestPolicy emailIngestPolicy;
        EmailIngestPolicy emailIngestPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        EmailIngestPolicyChangedDetails emailIngestPolicyChangedDetails = (EmailIngestPolicyChangedDetails) obj;
        EmailIngestPolicy emailIngestPolicy3 = this.newValue;
        EmailIngestPolicy emailIngestPolicy4 = emailIngestPolicyChangedDetails.newValue;
        return (emailIngestPolicy3 == emailIngestPolicy4 || emailIngestPolicy3.equals(emailIngestPolicy4)) && ((emailIngestPolicy = this.previousValue) == (emailIngestPolicy2 = emailIngestPolicyChangedDetails.previousValue) || emailIngestPolicy.equals(emailIngestPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<EmailIngestPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(EmailIngestPolicyChangedDetails emailIngestPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            EmailIngestPolicy.Serializer.INSTANCE.serialize(emailIngestPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            EmailIngestPolicy.Serializer.INSTANCE.serialize(emailIngestPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public EmailIngestPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            EmailIngestPolicy emailIngestPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                EmailIngestPolicy emailIngestPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        emailIngestPolicyDeserialize = EmailIngestPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        emailIngestPolicyDeserialize2 = EmailIngestPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (emailIngestPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (emailIngestPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                EmailIngestPolicyChangedDetails emailIngestPolicyChangedDetails = new EmailIngestPolicyChangedDetails(emailIngestPolicyDeserialize, emailIngestPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(emailIngestPolicyChangedDetails, emailIngestPolicyChangedDetails.toStringMultiline());
                return emailIngestPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
