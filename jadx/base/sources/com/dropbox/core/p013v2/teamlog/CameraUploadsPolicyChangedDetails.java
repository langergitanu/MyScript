package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.CameraUploadsPolicy;
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
public class CameraUploadsPolicyChangedDetails {

    @Nonnull
    protected final CameraUploadsPolicy newValue;

    @Nonnull
    protected final CameraUploadsPolicy previousValue;

    public CameraUploadsPolicyChangedDetails(@Nonnull CameraUploadsPolicy cameraUploadsPolicy, @Nonnull CameraUploadsPolicy cameraUploadsPolicy2) {
        if (cameraUploadsPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = cameraUploadsPolicy;
        if (cameraUploadsPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = cameraUploadsPolicy2;
    }

    @Nonnull
    public CameraUploadsPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public CameraUploadsPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        CameraUploadsPolicy cameraUploadsPolicy;
        CameraUploadsPolicy cameraUploadsPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        CameraUploadsPolicyChangedDetails cameraUploadsPolicyChangedDetails = (CameraUploadsPolicyChangedDetails) obj;
        CameraUploadsPolicy cameraUploadsPolicy3 = this.newValue;
        CameraUploadsPolicy cameraUploadsPolicy4 = cameraUploadsPolicyChangedDetails.newValue;
        return (cameraUploadsPolicy3 == cameraUploadsPolicy4 || cameraUploadsPolicy3.equals(cameraUploadsPolicy4)) && ((cameraUploadsPolicy = this.previousValue) == (cameraUploadsPolicy2 = cameraUploadsPolicyChangedDetails.previousValue) || cameraUploadsPolicy.equals(cameraUploadsPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CameraUploadsPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CameraUploadsPolicyChangedDetails cameraUploadsPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            CameraUploadsPolicy.Serializer.INSTANCE.serialize(cameraUploadsPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            CameraUploadsPolicy.Serializer.INSTANCE.serialize(cameraUploadsPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public CameraUploadsPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            CameraUploadsPolicy cameraUploadsPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                CameraUploadsPolicy cameraUploadsPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        cameraUploadsPolicyDeserialize = CameraUploadsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        cameraUploadsPolicyDeserialize2 = CameraUploadsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (cameraUploadsPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (cameraUploadsPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                CameraUploadsPolicyChangedDetails cameraUploadsPolicyChangedDetails = new CameraUploadsPolicyChangedDetails(cameraUploadsPolicyDeserialize, cameraUploadsPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(cameraUploadsPolicyChangedDetails, cameraUploadsPolicyChangedDetails.toStringMultiline());
                return cameraUploadsPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
