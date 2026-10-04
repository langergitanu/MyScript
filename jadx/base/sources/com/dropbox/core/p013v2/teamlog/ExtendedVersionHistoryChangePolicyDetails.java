package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ExtendedVersionHistoryPolicy;
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
public class ExtendedVersionHistoryChangePolicyDetails {

    @Nonnull
    protected final ExtendedVersionHistoryPolicy newValue;

    @Nullable
    protected final ExtendedVersionHistoryPolicy previousValue;

    public ExtendedVersionHistoryChangePolicyDetails(@Nonnull ExtendedVersionHistoryPolicy extendedVersionHistoryPolicy, @Nullable ExtendedVersionHistoryPolicy extendedVersionHistoryPolicy2) {
        if (extendedVersionHistoryPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = extendedVersionHistoryPolicy;
        this.previousValue = extendedVersionHistoryPolicy2;
    }

    public ExtendedVersionHistoryChangePolicyDetails(@Nonnull ExtendedVersionHistoryPolicy extendedVersionHistoryPolicy) {
        this(extendedVersionHistoryPolicy, null);
    }

    @Nonnull
    public ExtendedVersionHistoryPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public ExtendedVersionHistoryPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ExtendedVersionHistoryPolicy extendedVersionHistoryPolicy;
        ExtendedVersionHistoryPolicy extendedVersionHistoryPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ExtendedVersionHistoryChangePolicyDetails extendedVersionHistoryChangePolicyDetails = (ExtendedVersionHistoryChangePolicyDetails) obj;
        ExtendedVersionHistoryPolicy extendedVersionHistoryPolicy3 = this.newValue;
        ExtendedVersionHistoryPolicy extendedVersionHistoryPolicy4 = extendedVersionHistoryChangePolicyDetails.newValue;
        return (extendedVersionHistoryPolicy3 == extendedVersionHistoryPolicy4 || extendedVersionHistoryPolicy3.equals(extendedVersionHistoryPolicy4)) && ((extendedVersionHistoryPolicy = this.previousValue) == (extendedVersionHistoryPolicy2 = extendedVersionHistoryChangePolicyDetails.previousValue) || (extendedVersionHistoryPolicy != null && extendedVersionHistoryPolicy.equals(extendedVersionHistoryPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ExtendedVersionHistoryChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExtendedVersionHistoryChangePolicyDetails extendedVersionHistoryChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ExtendedVersionHistoryPolicy.Serializer.INSTANCE.serialize(extendedVersionHistoryChangePolicyDetails.newValue, jsonGenerator);
            if (extendedVersionHistoryChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(ExtendedVersionHistoryPolicy.Serializer.INSTANCE).serialize(extendedVersionHistoryChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExtendedVersionHistoryChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ExtendedVersionHistoryPolicy extendedVersionHistoryPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ExtendedVersionHistoryPolicy extendedVersionHistoryPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        extendedVersionHistoryPolicyDeserialize = ExtendedVersionHistoryPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        extendedVersionHistoryPolicy = (ExtendedVersionHistoryPolicy) StoneSerializers.nullable(ExtendedVersionHistoryPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (extendedVersionHistoryPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                ExtendedVersionHistoryChangePolicyDetails extendedVersionHistoryChangePolicyDetails = new ExtendedVersionHistoryChangePolicyDetails(extendedVersionHistoryPolicyDeserialize, extendedVersionHistoryPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(extendedVersionHistoryChangePolicyDetails, extendedVersionHistoryChangePolicyDetails.toStringMultiline());
                return extendedVersionHistoryChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
