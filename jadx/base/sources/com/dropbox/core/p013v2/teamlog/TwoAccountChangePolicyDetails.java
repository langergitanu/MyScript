package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TwoAccountPolicy;
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
public class TwoAccountChangePolicyDetails {

    @Nonnull
    protected final TwoAccountPolicy newValue;

    @Nullable
    protected final TwoAccountPolicy previousValue;

    public TwoAccountChangePolicyDetails(@Nonnull TwoAccountPolicy twoAccountPolicy, @Nullable TwoAccountPolicy twoAccountPolicy2) {
        if (twoAccountPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = twoAccountPolicy;
        this.previousValue = twoAccountPolicy2;
    }

    public TwoAccountChangePolicyDetails(@Nonnull TwoAccountPolicy twoAccountPolicy) {
        this(twoAccountPolicy, null);
    }

    @Nonnull
    public TwoAccountPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public TwoAccountPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        TwoAccountPolicy twoAccountPolicy;
        TwoAccountPolicy twoAccountPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TwoAccountChangePolicyDetails twoAccountChangePolicyDetails = (TwoAccountChangePolicyDetails) obj;
        TwoAccountPolicy twoAccountPolicy3 = this.newValue;
        TwoAccountPolicy twoAccountPolicy4 = twoAccountChangePolicyDetails.newValue;
        return (twoAccountPolicy3 == twoAccountPolicy4 || twoAccountPolicy3.equals(twoAccountPolicy4)) && ((twoAccountPolicy = this.previousValue) == (twoAccountPolicy2 = twoAccountChangePolicyDetails.previousValue) || (twoAccountPolicy != null && twoAccountPolicy.equals(twoAccountPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TwoAccountChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TwoAccountChangePolicyDetails twoAccountChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            TwoAccountPolicy.Serializer.INSTANCE.serialize(twoAccountChangePolicyDetails.newValue, jsonGenerator);
            if (twoAccountChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(TwoAccountPolicy.Serializer.INSTANCE).serialize(twoAccountChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TwoAccountChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TwoAccountPolicy twoAccountPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TwoAccountPolicy twoAccountPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        twoAccountPolicyDeserialize = TwoAccountPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        twoAccountPolicy = (TwoAccountPolicy) StoneSerializers.nullable(TwoAccountPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (twoAccountPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                TwoAccountChangePolicyDetails twoAccountChangePolicyDetails = new TwoAccountChangePolicyDetails(twoAccountPolicyDeserialize, twoAccountPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(twoAccountChangePolicyDetails, twoAccountChangePolicyDetails.toStringMultiline());
                return twoAccountChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
