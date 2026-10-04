package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ResellerSupportPolicy;
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
public class ResellerSupportChangePolicyDetails {

    @Nonnull
    protected final ResellerSupportPolicy newValue;

    @Nonnull
    protected final ResellerSupportPolicy previousValue;

    public ResellerSupportChangePolicyDetails(@Nonnull ResellerSupportPolicy resellerSupportPolicy, @Nonnull ResellerSupportPolicy resellerSupportPolicy2) {
        if (resellerSupportPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = resellerSupportPolicy;
        if (resellerSupportPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = resellerSupportPolicy2;
    }

    @Nonnull
    public ResellerSupportPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public ResellerSupportPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ResellerSupportPolicy resellerSupportPolicy;
        ResellerSupportPolicy resellerSupportPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ResellerSupportChangePolicyDetails resellerSupportChangePolicyDetails = (ResellerSupportChangePolicyDetails) obj;
        ResellerSupportPolicy resellerSupportPolicy3 = this.newValue;
        ResellerSupportPolicy resellerSupportPolicy4 = resellerSupportChangePolicyDetails.newValue;
        return (resellerSupportPolicy3 == resellerSupportPolicy4 || resellerSupportPolicy3.equals(resellerSupportPolicy4)) && ((resellerSupportPolicy = this.previousValue) == (resellerSupportPolicy2 = resellerSupportChangePolicyDetails.previousValue) || resellerSupportPolicy.equals(resellerSupportPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ResellerSupportChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ResellerSupportChangePolicyDetails resellerSupportChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ResellerSupportPolicy.Serializer.INSTANCE.serialize(resellerSupportChangePolicyDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            ResellerSupportPolicy.Serializer.INSTANCE.serialize(resellerSupportChangePolicyDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ResellerSupportChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ResellerSupportPolicy resellerSupportPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ResellerSupportPolicy resellerSupportPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        resellerSupportPolicyDeserialize = ResellerSupportPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        resellerSupportPolicyDeserialize2 = ResellerSupportPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (resellerSupportPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (resellerSupportPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                ResellerSupportChangePolicyDetails resellerSupportChangePolicyDetails = new ResellerSupportChangePolicyDetails(resellerSupportPolicyDeserialize, resellerSupportPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(resellerSupportChangePolicyDetails, resellerSupportChangePolicyDetails.toStringMultiline());
                return resellerSupportChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
