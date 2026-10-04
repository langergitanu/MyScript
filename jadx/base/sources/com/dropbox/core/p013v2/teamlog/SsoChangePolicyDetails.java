package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.SsoPolicy;
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
public class SsoChangePolicyDetails {

    @Nonnull
    protected final SsoPolicy newValue;

    @Nullable
    protected final SsoPolicy previousValue;

    public SsoChangePolicyDetails(@Nonnull SsoPolicy ssoPolicy, @Nullable SsoPolicy ssoPolicy2) {
        if (ssoPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = ssoPolicy;
        this.previousValue = ssoPolicy2;
    }

    public SsoChangePolicyDetails(@Nonnull SsoPolicy ssoPolicy) {
        this(ssoPolicy, null);
    }

    @Nonnull
    public SsoPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public SsoPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        SsoPolicy ssoPolicy;
        SsoPolicy ssoPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SsoChangePolicyDetails ssoChangePolicyDetails = (SsoChangePolicyDetails) obj;
        SsoPolicy ssoPolicy3 = this.newValue;
        SsoPolicy ssoPolicy4 = ssoChangePolicyDetails.newValue;
        return (ssoPolicy3 == ssoPolicy4 || ssoPolicy3.equals(ssoPolicy4)) && ((ssoPolicy = this.previousValue) == (ssoPolicy2 = ssoChangePolicyDetails.previousValue) || (ssoPolicy != null && ssoPolicy.equals(ssoPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SsoChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SsoChangePolicyDetails ssoChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            SsoPolicy.Serializer.INSTANCE.serialize(ssoChangePolicyDetails.newValue, jsonGenerator);
            if (ssoChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(SsoPolicy.Serializer.INSTANCE).serialize(ssoChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SsoChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SsoPolicy ssoPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SsoPolicy ssoPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        ssoPolicyDeserialize = SsoPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        ssoPolicy = (SsoPolicy) StoneSerializers.nullable(SsoPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (ssoPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SsoChangePolicyDetails ssoChangePolicyDetails = new SsoChangePolicyDetails(ssoPolicyDeserialize, ssoPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(ssoChangePolicyDetails, ssoChangePolicyDetails.toStringMultiline());
                return ssoChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
