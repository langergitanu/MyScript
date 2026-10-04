package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SharingLinkPolicy;
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
public class SharingChangeLinkPolicyDetails {

    @Nonnull
    protected final SharingLinkPolicy newValue;

    @Nullable
    protected final SharingLinkPolicy previousValue;

    public SharingChangeLinkPolicyDetails(@Nonnull SharingLinkPolicy sharingLinkPolicy, @Nullable SharingLinkPolicy sharingLinkPolicy2) {
        if (sharingLinkPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = sharingLinkPolicy;
        this.previousValue = sharingLinkPolicy2;
    }

    public SharingChangeLinkPolicyDetails(@Nonnull SharingLinkPolicy sharingLinkPolicy) {
        this(sharingLinkPolicy, null);
    }

    @Nonnull
    public SharingLinkPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public SharingLinkPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        SharingLinkPolicy sharingLinkPolicy;
        SharingLinkPolicy sharingLinkPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharingChangeLinkPolicyDetails sharingChangeLinkPolicyDetails = (SharingChangeLinkPolicyDetails) obj;
        SharingLinkPolicy sharingLinkPolicy3 = this.newValue;
        SharingLinkPolicy sharingLinkPolicy4 = sharingChangeLinkPolicyDetails.newValue;
        return (sharingLinkPolicy3 == sharingLinkPolicy4 || sharingLinkPolicy3.equals(sharingLinkPolicy4)) && ((sharingLinkPolicy = this.previousValue) == (sharingLinkPolicy2 = sharingChangeLinkPolicyDetails.previousValue) || (sharingLinkPolicy != null && sharingLinkPolicy.equals(sharingLinkPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharingChangeLinkPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharingChangeLinkPolicyDetails sharingChangeLinkPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            SharingLinkPolicy.Serializer.INSTANCE.serialize(sharingChangeLinkPolicyDetails.newValue, jsonGenerator);
            if (sharingChangeLinkPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(SharingLinkPolicy.Serializer.INSTANCE).serialize(sharingChangeLinkPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharingChangeLinkPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SharingLinkPolicy sharingLinkPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SharingLinkPolicy sharingLinkPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        sharingLinkPolicyDeserialize = SharingLinkPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        sharingLinkPolicy = (SharingLinkPolicy) StoneSerializers.nullable(SharingLinkPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (sharingLinkPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharingChangeLinkPolicyDetails sharingChangeLinkPolicyDetails = new SharingChangeLinkPolicyDetails(sharingLinkPolicyDeserialize, sharingLinkPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharingChangeLinkPolicyDetails, sharingChangeLinkPolicyDetails.toStringMultiline());
                return sharingChangeLinkPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
