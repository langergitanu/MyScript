package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.sharing.ViewerInfoPolicy;
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
public class SharedContentChangeViewerInfoPolicyDetails {

    @Nonnull
    protected final ViewerInfoPolicy newValue;

    @Nullable
    protected final ViewerInfoPolicy previousValue;

    public SharedContentChangeViewerInfoPolicyDetails(@Nonnull ViewerInfoPolicy viewerInfoPolicy, @Nullable ViewerInfoPolicy viewerInfoPolicy2) {
        if (viewerInfoPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = viewerInfoPolicy;
        this.previousValue = viewerInfoPolicy2;
    }

    public SharedContentChangeViewerInfoPolicyDetails(@Nonnull ViewerInfoPolicy viewerInfoPolicy) {
        this(viewerInfoPolicy, null);
    }

    @Nonnull
    public ViewerInfoPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public ViewerInfoPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ViewerInfoPolicy viewerInfoPolicy;
        ViewerInfoPolicy viewerInfoPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedContentChangeViewerInfoPolicyDetails sharedContentChangeViewerInfoPolicyDetails = (SharedContentChangeViewerInfoPolicyDetails) obj;
        ViewerInfoPolicy viewerInfoPolicy3 = this.newValue;
        ViewerInfoPolicy viewerInfoPolicy4 = sharedContentChangeViewerInfoPolicyDetails.newValue;
        return (viewerInfoPolicy3 == viewerInfoPolicy4 || viewerInfoPolicy3.equals(viewerInfoPolicy4)) && ((viewerInfoPolicy = this.previousValue) == (viewerInfoPolicy2 = sharedContentChangeViewerInfoPolicyDetails.previousValue) || (viewerInfoPolicy != null && viewerInfoPolicy.equals(viewerInfoPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentChangeViewerInfoPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentChangeViewerInfoPolicyDetails sharedContentChangeViewerInfoPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ViewerInfoPolicy.Serializer.INSTANCE.serialize(sharedContentChangeViewerInfoPolicyDetails.newValue, jsonGenerator);
            if (sharedContentChangeViewerInfoPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).serialize(sharedContentChangeViewerInfoPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentChangeViewerInfoPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ViewerInfoPolicy viewerInfoPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ViewerInfoPolicy viewerInfoPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        viewerInfoPolicyDeserialize = ViewerInfoPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        viewerInfoPolicy = (ViewerInfoPolicy) StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (viewerInfoPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharedContentChangeViewerInfoPolicyDetails sharedContentChangeViewerInfoPolicyDetails = new SharedContentChangeViewerInfoPolicyDetails(viewerInfoPolicyDeserialize, viewerInfoPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentChangeViewerInfoPolicyDetails, sharedContentChangeViewerInfoPolicyDetails.toStringMultiline());
                return sharedContentChangeViewerInfoPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
