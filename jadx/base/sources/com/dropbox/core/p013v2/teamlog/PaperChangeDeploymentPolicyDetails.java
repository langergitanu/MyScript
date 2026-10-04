package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.PaperDeploymentPolicy;
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
public class PaperChangeDeploymentPolicyDetails {

    @Nonnull
    protected final PaperDeploymentPolicy newValue;

    @Nullable
    protected final PaperDeploymentPolicy previousValue;

    public PaperChangeDeploymentPolicyDetails(@Nonnull PaperDeploymentPolicy paperDeploymentPolicy, @Nullable PaperDeploymentPolicy paperDeploymentPolicy2) {
        if (paperDeploymentPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = paperDeploymentPolicy;
        this.previousValue = paperDeploymentPolicy2;
    }

    public PaperChangeDeploymentPolicyDetails(@Nonnull PaperDeploymentPolicy paperDeploymentPolicy) {
        this(paperDeploymentPolicy, null);
    }

    @Nonnull
    public PaperDeploymentPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public PaperDeploymentPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        PaperDeploymentPolicy paperDeploymentPolicy;
        PaperDeploymentPolicy paperDeploymentPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperChangeDeploymentPolicyDetails paperChangeDeploymentPolicyDetails = (PaperChangeDeploymentPolicyDetails) obj;
        PaperDeploymentPolicy paperDeploymentPolicy3 = this.newValue;
        PaperDeploymentPolicy paperDeploymentPolicy4 = paperChangeDeploymentPolicyDetails.newValue;
        return (paperDeploymentPolicy3 == paperDeploymentPolicy4 || paperDeploymentPolicy3.equals(paperDeploymentPolicy4)) && ((paperDeploymentPolicy = this.previousValue) == (paperDeploymentPolicy2 = paperChangeDeploymentPolicyDetails.previousValue) || (paperDeploymentPolicy != null && paperDeploymentPolicy.equals(paperDeploymentPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperChangeDeploymentPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperChangeDeploymentPolicyDetails paperChangeDeploymentPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            PaperDeploymentPolicy.Serializer.INSTANCE.serialize(paperChangeDeploymentPolicyDetails.newValue, jsonGenerator);
            if (paperChangeDeploymentPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(PaperDeploymentPolicy.Serializer.INSTANCE).serialize(paperChangeDeploymentPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperChangeDeploymentPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PaperDeploymentPolicy paperDeploymentPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PaperDeploymentPolicy paperDeploymentPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        paperDeploymentPolicyDeserialize = PaperDeploymentPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        paperDeploymentPolicy = (PaperDeploymentPolicy) StoneSerializers.nullable(PaperDeploymentPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (paperDeploymentPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                PaperChangeDeploymentPolicyDetails paperChangeDeploymentPolicyDetails = new PaperChangeDeploymentPolicyDetails(paperDeploymentPolicyDeserialize, paperDeploymentPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperChangeDeploymentPolicyDetails, paperChangeDeploymentPolicyDetails.toStringMultiline());
                return paperChangeDeploymentPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
