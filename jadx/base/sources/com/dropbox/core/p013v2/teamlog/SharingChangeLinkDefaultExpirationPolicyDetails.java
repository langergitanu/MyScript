package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DefaultLinkExpirationDaysPolicy;
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
public class SharingChangeLinkDefaultExpirationPolicyDetails {

    @Nonnull
    protected final DefaultLinkExpirationDaysPolicy newValue;

    @Nullable
    protected final DefaultLinkExpirationDaysPolicy previousValue;

    public SharingChangeLinkDefaultExpirationPolicyDetails(@Nonnull DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicy, @Nullable DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicy2) {
        if (defaultLinkExpirationDaysPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = defaultLinkExpirationDaysPolicy;
        this.previousValue = defaultLinkExpirationDaysPolicy2;
    }

    public SharingChangeLinkDefaultExpirationPolicyDetails(@Nonnull DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicy) {
        this(defaultLinkExpirationDaysPolicy, null);
    }

    @Nonnull
    public DefaultLinkExpirationDaysPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public DefaultLinkExpirationDaysPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicy;
        DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharingChangeLinkDefaultExpirationPolicyDetails sharingChangeLinkDefaultExpirationPolicyDetails = (SharingChangeLinkDefaultExpirationPolicyDetails) obj;
        DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicy3 = this.newValue;
        DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicy4 = sharingChangeLinkDefaultExpirationPolicyDetails.newValue;
        return (defaultLinkExpirationDaysPolicy3 == defaultLinkExpirationDaysPolicy4 || defaultLinkExpirationDaysPolicy3.equals(defaultLinkExpirationDaysPolicy4)) && ((defaultLinkExpirationDaysPolicy = this.previousValue) == (defaultLinkExpirationDaysPolicy2 = sharingChangeLinkDefaultExpirationPolicyDetails.previousValue) || (defaultLinkExpirationDaysPolicy != null && defaultLinkExpirationDaysPolicy.equals(defaultLinkExpirationDaysPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharingChangeLinkDefaultExpirationPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharingChangeLinkDefaultExpirationPolicyDetails sharingChangeLinkDefaultExpirationPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            DefaultLinkExpirationDaysPolicy.Serializer.INSTANCE.serialize(sharingChangeLinkDefaultExpirationPolicyDetails.newValue, jsonGenerator);
            if (sharingChangeLinkDefaultExpirationPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(DefaultLinkExpirationDaysPolicy.Serializer.INSTANCE).serialize(sharingChangeLinkDefaultExpirationPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharingChangeLinkDefaultExpirationPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        defaultLinkExpirationDaysPolicyDeserialize = DefaultLinkExpirationDaysPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        defaultLinkExpirationDaysPolicy = (DefaultLinkExpirationDaysPolicy) StoneSerializers.nullable(DefaultLinkExpirationDaysPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (defaultLinkExpirationDaysPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharingChangeLinkDefaultExpirationPolicyDetails sharingChangeLinkDefaultExpirationPolicyDetails = new SharingChangeLinkDefaultExpirationPolicyDetails(defaultLinkExpirationDaysPolicyDeserialize, defaultLinkExpirationDaysPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharingChangeLinkDefaultExpirationPolicyDetails, sharingChangeLinkDefaultExpirationPolicyDetails.toStringMultiline());
                return sharingChangeLinkDefaultExpirationPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
