package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.MemberRequestsPolicy;
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
public class MemberRequestsChangePolicyDetails {

    @Nonnull
    protected final MemberRequestsPolicy newValue;

    @Nullable
    protected final MemberRequestsPolicy previousValue;

    public MemberRequestsChangePolicyDetails(@Nonnull MemberRequestsPolicy memberRequestsPolicy, @Nullable MemberRequestsPolicy memberRequestsPolicy2) {
        if (memberRequestsPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = memberRequestsPolicy;
        this.previousValue = memberRequestsPolicy2;
    }

    public MemberRequestsChangePolicyDetails(@Nonnull MemberRequestsPolicy memberRequestsPolicy) {
        this(memberRequestsPolicy, null);
    }

    @Nonnull
    public MemberRequestsPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public MemberRequestsPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        MemberRequestsPolicy memberRequestsPolicy;
        MemberRequestsPolicy memberRequestsPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MemberRequestsChangePolicyDetails memberRequestsChangePolicyDetails = (MemberRequestsChangePolicyDetails) obj;
        MemberRequestsPolicy memberRequestsPolicy3 = this.newValue;
        MemberRequestsPolicy memberRequestsPolicy4 = memberRequestsChangePolicyDetails.newValue;
        return (memberRequestsPolicy3 == memberRequestsPolicy4 || memberRequestsPolicy3.equals(memberRequestsPolicy4)) && ((memberRequestsPolicy = this.previousValue) == (memberRequestsPolicy2 = memberRequestsChangePolicyDetails.previousValue) || (memberRequestsPolicy != null && memberRequestsPolicy.equals(memberRequestsPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberRequestsChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberRequestsChangePolicyDetails memberRequestsChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            MemberRequestsPolicy.Serializer.INSTANCE.serialize(memberRequestsChangePolicyDetails.newValue, jsonGenerator);
            if (memberRequestsChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(MemberRequestsPolicy.Serializer.INSTANCE).serialize(memberRequestsChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberRequestsChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MemberRequestsPolicy memberRequestsPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                MemberRequestsPolicy memberRequestsPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        memberRequestsPolicyDeserialize = MemberRequestsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        memberRequestsPolicy = (MemberRequestsPolicy) StoneSerializers.nullable(MemberRequestsPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (memberRequestsPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                MemberRequestsChangePolicyDetails memberRequestsChangePolicyDetails = new MemberRequestsChangePolicyDetails(memberRequestsPolicyDeserialize, memberRequestsPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberRequestsChangePolicyDetails, memberRequestsChangePolicyDetails.toStringMultiline());
                return memberRequestsChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
