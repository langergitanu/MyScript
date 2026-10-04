package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.IntegrationPolicy;
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

/* JADX INFO: loaded from: classes5.dex */
public class IntegrationPolicyChangedDetails {

    @Nonnull
    protected final String integrationName;

    @Nonnull
    protected final IntegrationPolicy newValue;

    @Nonnull
    protected final IntegrationPolicy previousValue;

    public IntegrationPolicyChangedDetails(@Nonnull String str, @Nonnull IntegrationPolicy integrationPolicy, @Nonnull IntegrationPolicy integrationPolicy2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'integrationName' is null");
        }
        this.integrationName = str;
        if (integrationPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = integrationPolicy;
        if (integrationPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = integrationPolicy2;
    }

    @Nonnull
    public String getIntegrationName() {
        return this.integrationName;
    }

    @Nonnull
    public IntegrationPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public IntegrationPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.integrationName, this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        IntegrationPolicy integrationPolicy;
        IntegrationPolicy integrationPolicy2;
        IntegrationPolicy integrationPolicy3;
        IntegrationPolicy integrationPolicy4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        IntegrationPolicyChangedDetails integrationPolicyChangedDetails = (IntegrationPolicyChangedDetails) obj;
        String str = this.integrationName;
        String str2 = integrationPolicyChangedDetails.integrationName;
        return (str == str2 || str.equals(str2)) && ((integrationPolicy = this.newValue) == (integrationPolicy2 = integrationPolicyChangedDetails.newValue) || integrationPolicy.equals(integrationPolicy2)) && ((integrationPolicy3 = this.previousValue) == (integrationPolicy4 = integrationPolicyChangedDetails.previousValue) || integrationPolicy3.equals(integrationPolicy4));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<IntegrationPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(IntegrationPolicyChangedDetails integrationPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("integration_name");
            StoneSerializers.string().serialize(integrationPolicyChangedDetails.integrationName, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            IntegrationPolicy.Serializer.INSTANCE.serialize(integrationPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            IntegrationPolicy.Serializer.INSTANCE.serialize(integrationPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public IntegrationPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                IntegrationPolicy integrationPolicyDeserialize = null;
                IntegrationPolicy integrationPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("integration_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        integrationPolicyDeserialize = IntegrationPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        integrationPolicyDeserialize2 = IntegrationPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"integration_name\" missing.");
                }
                if (integrationPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (integrationPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                IntegrationPolicyChangedDetails integrationPolicyChangedDetails = new IntegrationPolicyChangedDetails(strDeserialize, integrationPolicyDeserialize, integrationPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(integrationPolicyChangedDetails, integrationPolicyChangedDetails.toStringMultiline());
                return integrationPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
