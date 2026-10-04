package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.GoogleSsoPolicy;
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
public class GoogleSsoChangePolicyDetails {

    @Nonnull
    protected final GoogleSsoPolicy newValue;

    @Nullable
    protected final GoogleSsoPolicy previousValue;

    public GoogleSsoChangePolicyDetails(@Nonnull GoogleSsoPolicy googleSsoPolicy, @Nullable GoogleSsoPolicy googleSsoPolicy2) {
        if (googleSsoPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = googleSsoPolicy;
        this.previousValue = googleSsoPolicy2;
    }

    public GoogleSsoChangePolicyDetails(@Nonnull GoogleSsoPolicy googleSsoPolicy) {
        this(googleSsoPolicy, null);
    }

    @Nonnull
    public GoogleSsoPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public GoogleSsoPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        GoogleSsoPolicy googleSsoPolicy;
        GoogleSsoPolicy googleSsoPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GoogleSsoChangePolicyDetails googleSsoChangePolicyDetails = (GoogleSsoChangePolicyDetails) obj;
        GoogleSsoPolicy googleSsoPolicy3 = this.newValue;
        GoogleSsoPolicy googleSsoPolicy4 = googleSsoChangePolicyDetails.newValue;
        return (googleSsoPolicy3 == googleSsoPolicy4 || googleSsoPolicy3.equals(googleSsoPolicy4)) && ((googleSsoPolicy = this.previousValue) == (googleSsoPolicy2 = googleSsoChangePolicyDetails.previousValue) || (googleSsoPolicy != null && googleSsoPolicy.equals(googleSsoPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GoogleSsoChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GoogleSsoChangePolicyDetails googleSsoChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            GoogleSsoPolicy.Serializer.INSTANCE.serialize(googleSsoChangePolicyDetails.newValue, jsonGenerator);
            if (googleSsoChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(GoogleSsoPolicy.Serializer.INSTANCE).serialize(googleSsoChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GoogleSsoChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            GoogleSsoPolicy googleSsoPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                GoogleSsoPolicy googleSsoPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        googleSsoPolicyDeserialize = GoogleSsoPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        googleSsoPolicy = (GoogleSsoPolicy) StoneSerializers.nullable(GoogleSsoPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (googleSsoPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                GoogleSsoChangePolicyDetails googleSsoChangePolicyDetails = new GoogleSsoChangePolicyDetails(googleSsoPolicyDeserialize, googleSsoPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(googleSsoChangePolicyDetails, googleSsoChangePolicyDetails.toStringMultiline());
                return googleSsoChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
