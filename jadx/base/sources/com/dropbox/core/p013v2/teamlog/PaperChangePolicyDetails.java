package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.PaperEnabledPolicy;
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
public class PaperChangePolicyDetails {

    @Nonnull
    protected final PaperEnabledPolicy newValue;

    @Nullable
    protected final PaperEnabledPolicy previousValue;

    public PaperChangePolicyDetails(@Nonnull PaperEnabledPolicy paperEnabledPolicy, @Nullable PaperEnabledPolicy paperEnabledPolicy2) {
        if (paperEnabledPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = paperEnabledPolicy;
        this.previousValue = paperEnabledPolicy2;
    }

    public PaperChangePolicyDetails(@Nonnull PaperEnabledPolicy paperEnabledPolicy) {
        this(paperEnabledPolicy, null);
    }

    @Nonnull
    public PaperEnabledPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public PaperEnabledPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        PaperEnabledPolicy paperEnabledPolicy;
        PaperEnabledPolicy paperEnabledPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperChangePolicyDetails paperChangePolicyDetails = (PaperChangePolicyDetails) obj;
        PaperEnabledPolicy paperEnabledPolicy3 = this.newValue;
        PaperEnabledPolicy paperEnabledPolicy4 = paperChangePolicyDetails.newValue;
        return (paperEnabledPolicy3 == paperEnabledPolicy4 || paperEnabledPolicy3.equals(paperEnabledPolicy4)) && ((paperEnabledPolicy = this.previousValue) == (paperEnabledPolicy2 = paperChangePolicyDetails.previousValue) || (paperEnabledPolicy != null && paperEnabledPolicy.equals(paperEnabledPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperChangePolicyDetails paperChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            PaperEnabledPolicy.Serializer.INSTANCE.serialize(paperChangePolicyDetails.newValue, jsonGenerator);
            if (paperChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(PaperEnabledPolicy.Serializer.INSTANCE).serialize(paperChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PaperEnabledPolicy paperEnabledPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PaperEnabledPolicy paperEnabledPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        paperEnabledPolicyDeserialize = PaperEnabledPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        paperEnabledPolicy = (PaperEnabledPolicy) StoneSerializers.nullable(PaperEnabledPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (paperEnabledPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                PaperChangePolicyDetails paperChangePolicyDetails = new PaperChangePolicyDetails(paperEnabledPolicyDeserialize, paperEnabledPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperChangePolicyDetails, paperChangePolicyDetails.toStringMultiline());
                return paperChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
