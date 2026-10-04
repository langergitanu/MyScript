package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SharingMemberPolicy;
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
public class SharingChangeMemberPolicyDetails {

    @Nonnull
    protected final SharingMemberPolicy newValue;

    @Nullable
    protected final SharingMemberPolicy previousValue;

    public SharingChangeMemberPolicyDetails(@Nonnull SharingMemberPolicy sharingMemberPolicy, @Nullable SharingMemberPolicy sharingMemberPolicy2) {
        if (sharingMemberPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = sharingMemberPolicy;
        this.previousValue = sharingMemberPolicy2;
    }

    public SharingChangeMemberPolicyDetails(@Nonnull SharingMemberPolicy sharingMemberPolicy) {
        this(sharingMemberPolicy, null);
    }

    @Nonnull
    public SharingMemberPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public SharingMemberPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        SharingMemberPolicy sharingMemberPolicy;
        SharingMemberPolicy sharingMemberPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharingChangeMemberPolicyDetails sharingChangeMemberPolicyDetails = (SharingChangeMemberPolicyDetails) obj;
        SharingMemberPolicy sharingMemberPolicy3 = this.newValue;
        SharingMemberPolicy sharingMemberPolicy4 = sharingChangeMemberPolicyDetails.newValue;
        return (sharingMemberPolicy3 == sharingMemberPolicy4 || sharingMemberPolicy3.equals(sharingMemberPolicy4)) && ((sharingMemberPolicy = this.previousValue) == (sharingMemberPolicy2 = sharingChangeMemberPolicyDetails.previousValue) || (sharingMemberPolicy != null && sharingMemberPolicy.equals(sharingMemberPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharingChangeMemberPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharingChangeMemberPolicyDetails sharingChangeMemberPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            SharingMemberPolicy.Serializer.INSTANCE.serialize(sharingChangeMemberPolicyDetails.newValue, jsonGenerator);
            if (sharingChangeMemberPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(SharingMemberPolicy.Serializer.INSTANCE).serialize(sharingChangeMemberPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharingChangeMemberPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SharingMemberPolicy sharingMemberPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SharingMemberPolicy sharingMemberPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        sharingMemberPolicyDeserialize = SharingMemberPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        sharingMemberPolicy = (SharingMemberPolicy) StoneSerializers.nullable(SharingMemberPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (sharingMemberPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharingChangeMemberPolicyDetails sharingChangeMemberPolicyDetails = new SharingChangeMemberPolicyDetails(sharingMemberPolicyDeserialize, sharingMemberPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharingChangeMemberPolicyDetails, sharingChangeMemberPolicyDetails.toStringMultiline());
                return sharingChangeMemberPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
