package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.EnforceLinkPasswordPolicy;
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
public class SharingChangeLinkAllowChangeExpirationPolicyDetails {

    @Nonnull
    protected final EnforceLinkPasswordPolicy newValue;

    @Nullable
    protected final EnforceLinkPasswordPolicy previousValue;

    public SharingChangeLinkAllowChangeExpirationPolicyDetails(@Nonnull EnforceLinkPasswordPolicy enforceLinkPasswordPolicy, @Nullable EnforceLinkPasswordPolicy enforceLinkPasswordPolicy2) {
        if (enforceLinkPasswordPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = enforceLinkPasswordPolicy;
        this.previousValue = enforceLinkPasswordPolicy2;
    }

    public SharingChangeLinkAllowChangeExpirationPolicyDetails(@Nonnull EnforceLinkPasswordPolicy enforceLinkPasswordPolicy) {
        this(enforceLinkPasswordPolicy, null);
    }

    @Nonnull
    public EnforceLinkPasswordPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public EnforceLinkPasswordPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        EnforceLinkPasswordPolicy enforceLinkPasswordPolicy;
        EnforceLinkPasswordPolicy enforceLinkPasswordPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharingChangeLinkAllowChangeExpirationPolicyDetails sharingChangeLinkAllowChangeExpirationPolicyDetails = (SharingChangeLinkAllowChangeExpirationPolicyDetails) obj;
        EnforceLinkPasswordPolicy enforceLinkPasswordPolicy3 = this.newValue;
        EnforceLinkPasswordPolicy enforceLinkPasswordPolicy4 = sharingChangeLinkAllowChangeExpirationPolicyDetails.newValue;
        return (enforceLinkPasswordPolicy3 == enforceLinkPasswordPolicy4 || enforceLinkPasswordPolicy3.equals(enforceLinkPasswordPolicy4)) && ((enforceLinkPasswordPolicy = this.previousValue) == (enforceLinkPasswordPolicy2 = sharingChangeLinkAllowChangeExpirationPolicyDetails.previousValue) || (enforceLinkPasswordPolicy != null && enforceLinkPasswordPolicy.equals(enforceLinkPasswordPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharingChangeLinkAllowChangeExpirationPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharingChangeLinkAllowChangeExpirationPolicyDetails sharingChangeLinkAllowChangeExpirationPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            EnforceLinkPasswordPolicy.Serializer.INSTANCE.serialize(sharingChangeLinkAllowChangeExpirationPolicyDetails.newValue, jsonGenerator);
            if (sharingChangeLinkAllowChangeExpirationPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(EnforceLinkPasswordPolicy.Serializer.INSTANCE).serialize(sharingChangeLinkAllowChangeExpirationPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharingChangeLinkAllowChangeExpirationPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            EnforceLinkPasswordPolicy enforceLinkPasswordPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                EnforceLinkPasswordPolicy enforceLinkPasswordPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        enforceLinkPasswordPolicyDeserialize = EnforceLinkPasswordPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        enforceLinkPasswordPolicy = (EnforceLinkPasswordPolicy) StoneSerializers.nullable(EnforceLinkPasswordPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (enforceLinkPasswordPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharingChangeLinkAllowChangeExpirationPolicyDetails sharingChangeLinkAllowChangeExpirationPolicyDetails = new SharingChangeLinkAllowChangeExpirationPolicyDetails(enforceLinkPasswordPolicyDeserialize, enforceLinkPasswordPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharingChangeLinkAllowChangeExpirationPolicyDetails, sharingChangeLinkAllowChangeExpirationPolicyDetails.toStringMultiline());
                return sharingChangeLinkAllowChangeExpirationPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
