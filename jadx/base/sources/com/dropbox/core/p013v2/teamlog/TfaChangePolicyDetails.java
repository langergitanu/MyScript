package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.TwoStepVerificationPolicy;
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
public class TfaChangePolicyDetails {

    @Nonnull
    protected final TwoStepVerificationPolicy newValue;

    @Nullable
    protected final TwoStepVerificationPolicy previousValue;

    public TfaChangePolicyDetails(@Nonnull TwoStepVerificationPolicy twoStepVerificationPolicy, @Nullable TwoStepVerificationPolicy twoStepVerificationPolicy2) {
        if (twoStepVerificationPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = twoStepVerificationPolicy;
        this.previousValue = twoStepVerificationPolicy2;
    }

    public TfaChangePolicyDetails(@Nonnull TwoStepVerificationPolicy twoStepVerificationPolicy) {
        this(twoStepVerificationPolicy, null);
    }

    @Nonnull
    public TwoStepVerificationPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public TwoStepVerificationPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        TwoStepVerificationPolicy twoStepVerificationPolicy;
        TwoStepVerificationPolicy twoStepVerificationPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TfaChangePolicyDetails tfaChangePolicyDetails = (TfaChangePolicyDetails) obj;
        TwoStepVerificationPolicy twoStepVerificationPolicy3 = this.newValue;
        TwoStepVerificationPolicy twoStepVerificationPolicy4 = tfaChangePolicyDetails.newValue;
        return (twoStepVerificationPolicy3 == twoStepVerificationPolicy4 || twoStepVerificationPolicy3.equals(twoStepVerificationPolicy4)) && ((twoStepVerificationPolicy = this.previousValue) == (twoStepVerificationPolicy2 = tfaChangePolicyDetails.previousValue) || (twoStepVerificationPolicy != null && twoStepVerificationPolicy.equals(twoStepVerificationPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TfaChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TfaChangePolicyDetails tfaChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            TwoStepVerificationPolicy.Serializer.INSTANCE.serialize(tfaChangePolicyDetails.newValue, jsonGenerator);
            if (tfaChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(TwoStepVerificationPolicy.Serializer.INSTANCE).serialize(tfaChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TfaChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TwoStepVerificationPolicy twoStepVerificationPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TwoStepVerificationPolicy twoStepVerificationPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        twoStepVerificationPolicyDeserialize = TwoStepVerificationPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        twoStepVerificationPolicy = (TwoStepVerificationPolicy) StoneSerializers.nullable(TwoStepVerificationPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (twoStepVerificationPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                TfaChangePolicyDetails tfaChangePolicyDetails = new TfaChangePolicyDetails(twoStepVerificationPolicyDeserialize, twoStepVerificationPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(tfaChangePolicyDetails, tfaChangePolicyDetails.toStringMultiline());
                return tfaChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
