package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SecondaryMailsPolicy;
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
public class SecondaryMailsPolicyChangedDetails {

    @Nonnull
    protected final SecondaryMailsPolicy newValue;

    @Nonnull
    protected final SecondaryMailsPolicy previousValue;

    public SecondaryMailsPolicyChangedDetails(@Nonnull SecondaryMailsPolicy secondaryMailsPolicy, @Nonnull SecondaryMailsPolicy secondaryMailsPolicy2) {
        if (secondaryMailsPolicy == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = secondaryMailsPolicy;
        if (secondaryMailsPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = secondaryMailsPolicy2;
    }

    @Nonnull
    public SecondaryMailsPolicy getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public SecondaryMailsPolicy getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        SecondaryMailsPolicy secondaryMailsPolicy;
        SecondaryMailsPolicy secondaryMailsPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SecondaryMailsPolicyChangedDetails secondaryMailsPolicyChangedDetails = (SecondaryMailsPolicyChangedDetails) obj;
        SecondaryMailsPolicy secondaryMailsPolicy3 = this.previousValue;
        SecondaryMailsPolicy secondaryMailsPolicy4 = secondaryMailsPolicyChangedDetails.previousValue;
        return (secondaryMailsPolicy3 == secondaryMailsPolicy4 || secondaryMailsPolicy3.equals(secondaryMailsPolicy4)) && ((secondaryMailsPolicy = this.newValue) == (secondaryMailsPolicy2 = secondaryMailsPolicyChangedDetails.newValue) || secondaryMailsPolicy.equals(secondaryMailsPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SecondaryMailsPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SecondaryMailsPolicyChangedDetails secondaryMailsPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            SecondaryMailsPolicy.Serializer.INSTANCE.serialize(secondaryMailsPolicyChangedDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            SecondaryMailsPolicy.Serializer.INSTANCE.serialize(secondaryMailsPolicyChangedDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SecondaryMailsPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SecondaryMailsPolicy secondaryMailsPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SecondaryMailsPolicy secondaryMailsPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        secondaryMailsPolicyDeserialize = SecondaryMailsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        secondaryMailsPolicyDeserialize2 = SecondaryMailsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (secondaryMailsPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (secondaryMailsPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SecondaryMailsPolicyChangedDetails secondaryMailsPolicyChangedDetails = new SecondaryMailsPolicyChangedDetails(secondaryMailsPolicyDeserialize, secondaryMailsPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(secondaryMailsPolicyChangedDetails, secondaryMailsPolicyChangedDetails.toStringMultiline());
                return secondaryMailsPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
