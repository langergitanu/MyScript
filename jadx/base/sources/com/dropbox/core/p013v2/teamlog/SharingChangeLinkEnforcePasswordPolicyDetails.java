package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ChangeLinkExpirationPolicy;
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
public class SharingChangeLinkEnforcePasswordPolicyDetails {

    @Nonnull
    protected final ChangeLinkExpirationPolicy newValue;

    @Nullable
    protected final ChangeLinkExpirationPolicy previousValue;

    public SharingChangeLinkEnforcePasswordPolicyDetails(@Nonnull ChangeLinkExpirationPolicy changeLinkExpirationPolicy, @Nullable ChangeLinkExpirationPolicy changeLinkExpirationPolicy2) {
        if (changeLinkExpirationPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = changeLinkExpirationPolicy;
        this.previousValue = changeLinkExpirationPolicy2;
    }

    public SharingChangeLinkEnforcePasswordPolicyDetails(@Nonnull ChangeLinkExpirationPolicy changeLinkExpirationPolicy) {
        this(changeLinkExpirationPolicy, null);
    }

    @Nonnull
    public ChangeLinkExpirationPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public ChangeLinkExpirationPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ChangeLinkExpirationPolicy changeLinkExpirationPolicy;
        ChangeLinkExpirationPolicy changeLinkExpirationPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharingChangeLinkEnforcePasswordPolicyDetails sharingChangeLinkEnforcePasswordPolicyDetails = (SharingChangeLinkEnforcePasswordPolicyDetails) obj;
        ChangeLinkExpirationPolicy changeLinkExpirationPolicy3 = this.newValue;
        ChangeLinkExpirationPolicy changeLinkExpirationPolicy4 = sharingChangeLinkEnforcePasswordPolicyDetails.newValue;
        return (changeLinkExpirationPolicy3 == changeLinkExpirationPolicy4 || changeLinkExpirationPolicy3.equals(changeLinkExpirationPolicy4)) && ((changeLinkExpirationPolicy = this.previousValue) == (changeLinkExpirationPolicy2 = sharingChangeLinkEnforcePasswordPolicyDetails.previousValue) || (changeLinkExpirationPolicy != null && changeLinkExpirationPolicy.equals(changeLinkExpirationPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharingChangeLinkEnforcePasswordPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharingChangeLinkEnforcePasswordPolicyDetails sharingChangeLinkEnforcePasswordPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ChangeLinkExpirationPolicy.Serializer.INSTANCE.serialize(sharingChangeLinkEnforcePasswordPolicyDetails.newValue, jsonGenerator);
            if (sharingChangeLinkEnforcePasswordPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(ChangeLinkExpirationPolicy.Serializer.INSTANCE).serialize(sharingChangeLinkEnforcePasswordPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharingChangeLinkEnforcePasswordPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ChangeLinkExpirationPolicy changeLinkExpirationPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ChangeLinkExpirationPolicy changeLinkExpirationPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        changeLinkExpirationPolicyDeserialize = ChangeLinkExpirationPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        changeLinkExpirationPolicy = (ChangeLinkExpirationPolicy) StoneSerializers.nullable(ChangeLinkExpirationPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (changeLinkExpirationPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharingChangeLinkEnforcePasswordPolicyDetails sharingChangeLinkEnforcePasswordPolicyDetails = new SharingChangeLinkEnforcePasswordPolicyDetails(changeLinkExpirationPolicyDeserialize, changeLinkExpirationPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharingChangeLinkEnforcePasswordPolicyDetails, sharingChangeLinkEnforcePasswordPolicyDetails.toStringMultiline());
                return sharingChangeLinkEnforcePasswordPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
