package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.MicrosoftOfficeAddinPolicy;
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
public class MicrosoftOfficeAddinChangePolicyDetails {

    @Nonnull
    protected final MicrosoftOfficeAddinPolicy newValue;

    @Nullable
    protected final MicrosoftOfficeAddinPolicy previousValue;

    public MicrosoftOfficeAddinChangePolicyDetails(@Nonnull MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicy, @Nullable MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicy2) {
        if (microsoftOfficeAddinPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = microsoftOfficeAddinPolicy;
        this.previousValue = microsoftOfficeAddinPolicy2;
    }

    public MicrosoftOfficeAddinChangePolicyDetails(@Nonnull MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicy) {
        this(microsoftOfficeAddinPolicy, null);
    }

    @Nonnull
    public MicrosoftOfficeAddinPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public MicrosoftOfficeAddinPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicy;
        MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MicrosoftOfficeAddinChangePolicyDetails microsoftOfficeAddinChangePolicyDetails = (MicrosoftOfficeAddinChangePolicyDetails) obj;
        MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicy3 = this.newValue;
        MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicy4 = microsoftOfficeAddinChangePolicyDetails.newValue;
        return (microsoftOfficeAddinPolicy3 == microsoftOfficeAddinPolicy4 || microsoftOfficeAddinPolicy3.equals(microsoftOfficeAddinPolicy4)) && ((microsoftOfficeAddinPolicy = this.previousValue) == (microsoftOfficeAddinPolicy2 = microsoftOfficeAddinChangePolicyDetails.previousValue) || (microsoftOfficeAddinPolicy != null && microsoftOfficeAddinPolicy.equals(microsoftOfficeAddinPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MicrosoftOfficeAddinChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MicrosoftOfficeAddinChangePolicyDetails microsoftOfficeAddinChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            MicrosoftOfficeAddinPolicy.Serializer.INSTANCE.serialize(microsoftOfficeAddinChangePolicyDetails.newValue, jsonGenerator);
            if (microsoftOfficeAddinChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(MicrosoftOfficeAddinPolicy.Serializer.INSTANCE).serialize(microsoftOfficeAddinChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MicrosoftOfficeAddinChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                MicrosoftOfficeAddinPolicy microsoftOfficeAddinPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        microsoftOfficeAddinPolicyDeserialize = MicrosoftOfficeAddinPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        microsoftOfficeAddinPolicy = (MicrosoftOfficeAddinPolicy) StoneSerializers.nullable(MicrosoftOfficeAddinPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (microsoftOfficeAddinPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                MicrosoftOfficeAddinChangePolicyDetails microsoftOfficeAddinChangePolicyDetails = new MicrosoftOfficeAddinChangePolicyDetails(microsoftOfficeAddinPolicyDeserialize, microsoftOfficeAddinPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(microsoftOfficeAddinChangePolicyDetails, microsoftOfficeAddinChangePolicyDetails.toStringMultiline());
                return microsoftOfficeAddinChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
