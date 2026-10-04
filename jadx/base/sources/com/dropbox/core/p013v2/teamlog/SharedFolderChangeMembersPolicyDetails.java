package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.sharing.MemberPolicy;
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
public class SharedFolderChangeMembersPolicyDetails {

    @Nonnull
    protected final MemberPolicy newValue;

    @Nullable
    protected final MemberPolicy previousValue;

    public SharedFolderChangeMembersPolicyDetails(@Nonnull MemberPolicy memberPolicy, @Nullable MemberPolicy memberPolicy2) {
        if (memberPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = memberPolicy;
        this.previousValue = memberPolicy2;
    }

    public SharedFolderChangeMembersPolicyDetails(@Nonnull MemberPolicy memberPolicy) {
        this(memberPolicy, null);
    }

    @Nonnull
    public MemberPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public MemberPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        MemberPolicy memberPolicy;
        MemberPolicy memberPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedFolderChangeMembersPolicyDetails sharedFolderChangeMembersPolicyDetails = (SharedFolderChangeMembersPolicyDetails) obj;
        MemberPolicy memberPolicy3 = this.newValue;
        MemberPolicy memberPolicy4 = sharedFolderChangeMembersPolicyDetails.newValue;
        return (memberPolicy3 == memberPolicy4 || memberPolicy3.equals(memberPolicy4)) && ((memberPolicy = this.previousValue) == (memberPolicy2 = sharedFolderChangeMembersPolicyDetails.previousValue) || (memberPolicy != null && memberPolicy.equals(memberPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedFolderChangeMembersPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFolderChangeMembersPolicyDetails sharedFolderChangeMembersPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            MemberPolicy.Serializer.INSTANCE.serialize(sharedFolderChangeMembersPolicyDetails.newValue, jsonGenerator);
            if (sharedFolderChangeMembersPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).serialize(sharedFolderChangeMembersPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFolderChangeMembersPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MemberPolicy memberPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                MemberPolicy memberPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        memberPolicyDeserialize = MemberPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        memberPolicy = (MemberPolicy) StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (memberPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharedFolderChangeMembersPolicyDetails sharedFolderChangeMembersPolicyDetails = new SharedFolderChangeMembersPolicyDetails(memberPolicyDeserialize, memberPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFolderChangeMembersPolicyDetails, sharedFolderChangeMembersPolicyDetails.toStringMultiline());
                return sharedFolderChangeMembersPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
