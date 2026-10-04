package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.NetworkControlPolicy;
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
public class NetworkControlChangePolicyDetails {

    @Nonnull
    protected final NetworkControlPolicy newValue;

    @Nullable
    protected final NetworkControlPolicy previousValue;

    public NetworkControlChangePolicyDetails(@Nonnull NetworkControlPolicy networkControlPolicy, @Nullable NetworkControlPolicy networkControlPolicy2) {
        if (networkControlPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = networkControlPolicy;
        this.previousValue = networkControlPolicy2;
    }

    public NetworkControlChangePolicyDetails(@Nonnull NetworkControlPolicy networkControlPolicy) {
        this(networkControlPolicy, null);
    }

    @Nonnull
    public NetworkControlPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public NetworkControlPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        NetworkControlPolicy networkControlPolicy;
        NetworkControlPolicy networkControlPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        NetworkControlChangePolicyDetails networkControlChangePolicyDetails = (NetworkControlChangePolicyDetails) obj;
        NetworkControlPolicy networkControlPolicy3 = this.newValue;
        NetworkControlPolicy networkControlPolicy4 = networkControlChangePolicyDetails.newValue;
        return (networkControlPolicy3 == networkControlPolicy4 || networkControlPolicy3.equals(networkControlPolicy4)) && ((networkControlPolicy = this.previousValue) == (networkControlPolicy2 = networkControlChangePolicyDetails.previousValue) || (networkControlPolicy != null && networkControlPolicy.equals(networkControlPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<NetworkControlChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(NetworkControlChangePolicyDetails networkControlChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            NetworkControlPolicy.Serializer.INSTANCE.serialize(networkControlChangePolicyDetails.newValue, jsonGenerator);
            if (networkControlChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(NetworkControlPolicy.Serializer.INSTANCE).serialize(networkControlChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public NetworkControlChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            NetworkControlPolicy networkControlPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                NetworkControlPolicy networkControlPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        networkControlPolicyDeserialize = NetworkControlPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        networkControlPolicy = (NetworkControlPolicy) StoneSerializers.nullable(NetworkControlPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (networkControlPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                NetworkControlChangePolicyDetails networkControlChangePolicyDetails = new NetworkControlChangePolicyDetails(networkControlPolicyDeserialize, networkControlPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(networkControlChangePolicyDetails, networkControlChangePolicyDetails.toStringMultiline());
                return networkControlChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
