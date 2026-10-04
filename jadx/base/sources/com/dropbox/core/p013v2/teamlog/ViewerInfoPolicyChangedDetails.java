package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PassPolicy;
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
public class ViewerInfoPolicyChangedDetails {

    @Nonnull
    protected final PassPolicy newValue;

    @Nonnull
    protected final PassPolicy previousValue;

    public ViewerInfoPolicyChangedDetails(@Nonnull PassPolicy passPolicy, @Nonnull PassPolicy passPolicy2) {
        if (passPolicy == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = passPolicy;
        if (passPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = passPolicy2;
    }

    @Nonnull
    public PassPolicy getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public PassPolicy getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        PassPolicy passPolicy;
        PassPolicy passPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ViewerInfoPolicyChangedDetails viewerInfoPolicyChangedDetails = (ViewerInfoPolicyChangedDetails) obj;
        PassPolicy passPolicy3 = this.previousValue;
        PassPolicy passPolicy4 = viewerInfoPolicyChangedDetails.previousValue;
        return (passPolicy3 == passPolicy4 || passPolicy3.equals(passPolicy4)) && ((passPolicy = this.newValue) == (passPolicy2 = viewerInfoPolicyChangedDetails.newValue) || passPolicy.equals(passPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ViewerInfoPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ViewerInfoPolicyChangedDetails viewerInfoPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            PassPolicy.Serializer.INSTANCE.serialize(viewerInfoPolicyChangedDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            PassPolicy.Serializer.INSTANCE.serialize(viewerInfoPolicyChangedDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ViewerInfoPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PassPolicy passPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PassPolicy passPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        passPolicyDeserialize = PassPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        passPolicyDeserialize2 = PassPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (passPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (passPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                ViewerInfoPolicyChangedDetails viewerInfoPolicyChangedDetails = new ViewerInfoPolicyChangedDetails(passPolicyDeserialize, passPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(viewerInfoPolicyChangedDetails, viewerInfoPolicyChangedDetails.toStringMultiline());
                return viewerInfoPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
