package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SendForSignaturePolicy;
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
public class SendForSignaturePolicyChangedDetails {

    @Nonnull
    protected final SendForSignaturePolicy newValue;

    @Nonnull
    protected final SendForSignaturePolicy previousValue;

    public SendForSignaturePolicyChangedDetails(@Nonnull SendForSignaturePolicy sendForSignaturePolicy, @Nonnull SendForSignaturePolicy sendForSignaturePolicy2) {
        if (sendForSignaturePolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = sendForSignaturePolicy;
        if (sendForSignaturePolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = sendForSignaturePolicy2;
    }

    @Nonnull
    public SendForSignaturePolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public SendForSignaturePolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        SendForSignaturePolicy sendForSignaturePolicy;
        SendForSignaturePolicy sendForSignaturePolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SendForSignaturePolicyChangedDetails sendForSignaturePolicyChangedDetails = (SendForSignaturePolicyChangedDetails) obj;
        SendForSignaturePolicy sendForSignaturePolicy3 = this.newValue;
        SendForSignaturePolicy sendForSignaturePolicy4 = sendForSignaturePolicyChangedDetails.newValue;
        return (sendForSignaturePolicy3 == sendForSignaturePolicy4 || sendForSignaturePolicy3.equals(sendForSignaturePolicy4)) && ((sendForSignaturePolicy = this.previousValue) == (sendForSignaturePolicy2 = sendForSignaturePolicyChangedDetails.previousValue) || sendForSignaturePolicy.equals(sendForSignaturePolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SendForSignaturePolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SendForSignaturePolicyChangedDetails sendForSignaturePolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            SendForSignaturePolicy.Serializer.INSTANCE.serialize(sendForSignaturePolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            SendForSignaturePolicy.Serializer.INSTANCE.serialize(sendForSignaturePolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SendForSignaturePolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SendForSignaturePolicy sendForSignaturePolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SendForSignaturePolicy sendForSignaturePolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        sendForSignaturePolicyDeserialize = SendForSignaturePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        sendForSignaturePolicyDeserialize2 = SendForSignaturePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (sendForSignaturePolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (sendForSignaturePolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                SendForSignaturePolicyChangedDetails sendForSignaturePolicyChangedDetails = new SendForSignaturePolicyChangedDetails(sendForSignaturePolicyDeserialize, sendForSignaturePolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sendForSignaturePolicyChangedDetails, sendForSignaturePolicyChangedDetails.toStringMultiline());
                return sendForSignaturePolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
