package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.PasswordStrengthPolicy;
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
public class PasswordStrengthRequirementsChangePolicyDetails {

    @Nonnull
    protected final PasswordStrengthPolicy newValue;

    @Nonnull
    protected final PasswordStrengthPolicy previousValue;

    public PasswordStrengthRequirementsChangePolicyDetails(@Nonnull PasswordStrengthPolicy passwordStrengthPolicy, @Nonnull PasswordStrengthPolicy passwordStrengthPolicy2) {
        if (passwordStrengthPolicy == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = passwordStrengthPolicy;
        if (passwordStrengthPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = passwordStrengthPolicy2;
    }

    @Nonnull
    public PasswordStrengthPolicy getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public PasswordStrengthPolicy getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        PasswordStrengthPolicy passwordStrengthPolicy;
        PasswordStrengthPolicy passwordStrengthPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PasswordStrengthRequirementsChangePolicyDetails passwordStrengthRequirementsChangePolicyDetails = (PasswordStrengthRequirementsChangePolicyDetails) obj;
        PasswordStrengthPolicy passwordStrengthPolicy3 = this.previousValue;
        PasswordStrengthPolicy passwordStrengthPolicy4 = passwordStrengthRequirementsChangePolicyDetails.previousValue;
        return (passwordStrengthPolicy3 == passwordStrengthPolicy4 || passwordStrengthPolicy3.equals(passwordStrengthPolicy4)) && ((passwordStrengthPolicy = this.newValue) == (passwordStrengthPolicy2 = passwordStrengthRequirementsChangePolicyDetails.newValue) || passwordStrengthPolicy.equals(passwordStrengthPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PasswordStrengthRequirementsChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PasswordStrengthRequirementsChangePolicyDetails passwordStrengthRequirementsChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            PasswordStrengthPolicy.Serializer.INSTANCE.serialize(passwordStrengthRequirementsChangePolicyDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            PasswordStrengthPolicy.Serializer.INSTANCE.serialize(passwordStrengthRequirementsChangePolicyDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PasswordStrengthRequirementsChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PasswordStrengthPolicy passwordStrengthPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PasswordStrengthPolicy passwordStrengthPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        passwordStrengthPolicyDeserialize = PasswordStrengthPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        passwordStrengthPolicyDeserialize2 = PasswordStrengthPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (passwordStrengthPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (passwordStrengthPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                PasswordStrengthRequirementsChangePolicyDetails passwordStrengthRequirementsChangePolicyDetails = new PasswordStrengthRequirementsChangePolicyDetails(passwordStrengthPolicyDeserialize, passwordStrengthPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(passwordStrengthRequirementsChangePolicyDetails, passwordStrengthRequirementsChangePolicyDetails.toStringMultiline());
                return passwordStrengthRequirementsChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
