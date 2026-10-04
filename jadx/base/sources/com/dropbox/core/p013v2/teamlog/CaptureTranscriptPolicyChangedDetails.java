package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.CaptureTranscriptPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class CaptureTranscriptPolicyChangedDetails {

    @Nonnull
    protected final CaptureTranscriptPolicy newValue;

    @Nonnull
    protected final CaptureTranscriptPolicy previousValue;

    public CaptureTranscriptPolicyChangedDetails(@Nonnull CaptureTranscriptPolicy captureTranscriptPolicy, @Nonnull CaptureTranscriptPolicy captureTranscriptPolicy2) {
        if (captureTranscriptPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = captureTranscriptPolicy;
        if (captureTranscriptPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = captureTranscriptPolicy2;
    }

    @Nonnull
    public CaptureTranscriptPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public CaptureTranscriptPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        CaptureTranscriptPolicy captureTranscriptPolicy;
        CaptureTranscriptPolicy captureTranscriptPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        CaptureTranscriptPolicyChangedDetails captureTranscriptPolicyChangedDetails = (CaptureTranscriptPolicyChangedDetails) obj;
        CaptureTranscriptPolicy captureTranscriptPolicy3 = this.newValue;
        CaptureTranscriptPolicy captureTranscriptPolicy4 = captureTranscriptPolicyChangedDetails.newValue;
        return (captureTranscriptPolicy3 == captureTranscriptPolicy4 || captureTranscriptPolicy3.equals(captureTranscriptPolicy4)) && ((captureTranscriptPolicy = this.previousValue) == (captureTranscriptPolicy2 = captureTranscriptPolicyChangedDetails.previousValue) || captureTranscriptPolicy.equals(captureTranscriptPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CaptureTranscriptPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CaptureTranscriptPolicyChangedDetails captureTranscriptPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            CaptureTranscriptPolicy.Serializer.INSTANCE.serialize(captureTranscriptPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            CaptureTranscriptPolicy.Serializer.INSTANCE.serialize(captureTranscriptPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public CaptureTranscriptPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            CaptureTranscriptPolicy captureTranscriptPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                CaptureTranscriptPolicy captureTranscriptPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        captureTranscriptPolicyDeserialize = CaptureTranscriptPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        captureTranscriptPolicyDeserialize2 = CaptureTranscriptPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (captureTranscriptPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (captureTranscriptPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                CaptureTranscriptPolicyChangedDetails captureTranscriptPolicyChangedDetails = new CaptureTranscriptPolicyChangedDetails(captureTranscriptPolicyDeserialize, captureTranscriptPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(captureTranscriptPolicyChangedDetails, captureTranscriptPolicyChangedDetails.toStringMultiline());
                return captureTranscriptPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
