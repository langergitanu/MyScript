package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ContentPermanentDeletePolicy;
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
public class PermanentDeleteChangePolicyDetails {

    @Nonnull
    protected final ContentPermanentDeletePolicy newValue;

    @Nullable
    protected final ContentPermanentDeletePolicy previousValue;

    public PermanentDeleteChangePolicyDetails(@Nonnull ContentPermanentDeletePolicy contentPermanentDeletePolicy, @Nullable ContentPermanentDeletePolicy contentPermanentDeletePolicy2) {
        if (contentPermanentDeletePolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = contentPermanentDeletePolicy;
        this.previousValue = contentPermanentDeletePolicy2;
    }

    public PermanentDeleteChangePolicyDetails(@Nonnull ContentPermanentDeletePolicy contentPermanentDeletePolicy) {
        this(contentPermanentDeletePolicy, null);
    }

    @Nonnull
    public ContentPermanentDeletePolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public ContentPermanentDeletePolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ContentPermanentDeletePolicy contentPermanentDeletePolicy;
        ContentPermanentDeletePolicy contentPermanentDeletePolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PermanentDeleteChangePolicyDetails permanentDeleteChangePolicyDetails = (PermanentDeleteChangePolicyDetails) obj;
        ContentPermanentDeletePolicy contentPermanentDeletePolicy3 = this.newValue;
        ContentPermanentDeletePolicy contentPermanentDeletePolicy4 = permanentDeleteChangePolicyDetails.newValue;
        return (contentPermanentDeletePolicy3 == contentPermanentDeletePolicy4 || contentPermanentDeletePolicy3.equals(contentPermanentDeletePolicy4)) && ((contentPermanentDeletePolicy = this.previousValue) == (contentPermanentDeletePolicy2 = permanentDeleteChangePolicyDetails.previousValue) || (contentPermanentDeletePolicy != null && contentPermanentDeletePolicy.equals(contentPermanentDeletePolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PermanentDeleteChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PermanentDeleteChangePolicyDetails permanentDeleteChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ContentPermanentDeletePolicy.Serializer.INSTANCE.serialize(permanentDeleteChangePolicyDetails.newValue, jsonGenerator);
            if (permanentDeleteChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(ContentPermanentDeletePolicy.Serializer.INSTANCE).serialize(permanentDeleteChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PermanentDeleteChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ContentPermanentDeletePolicy contentPermanentDeletePolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ContentPermanentDeletePolicy contentPermanentDeletePolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        contentPermanentDeletePolicyDeserialize = ContentPermanentDeletePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        contentPermanentDeletePolicy = (ContentPermanentDeletePolicy) StoneSerializers.nullable(ContentPermanentDeletePolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (contentPermanentDeletePolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                PermanentDeleteChangePolicyDetails permanentDeleteChangePolicyDetails = new PermanentDeleteChangePolicyDetails(contentPermanentDeletePolicyDeserialize, contentPermanentDeletePolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(permanentDeleteChangePolicyDetails, permanentDeleteChangePolicyDetails.toStringMultiline());
                return permanentDeleteChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
