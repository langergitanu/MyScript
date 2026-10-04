package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.sharing.AclUpdatePolicy;
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
public class SharedFolderChangeMembersManagementPolicyDetails {

    @Nonnull
    protected final AclUpdatePolicy newValue;

    @Nullable
    protected final AclUpdatePolicy previousValue;

    public SharedFolderChangeMembersManagementPolicyDetails(@Nonnull AclUpdatePolicy aclUpdatePolicy, @Nullable AclUpdatePolicy aclUpdatePolicy2) {
        if (aclUpdatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = aclUpdatePolicy;
        this.previousValue = aclUpdatePolicy2;
    }

    public SharedFolderChangeMembersManagementPolicyDetails(@Nonnull AclUpdatePolicy aclUpdatePolicy) {
        this(aclUpdatePolicy, null);
    }

    @Nonnull
    public AclUpdatePolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public AclUpdatePolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        AclUpdatePolicy aclUpdatePolicy;
        AclUpdatePolicy aclUpdatePolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedFolderChangeMembersManagementPolicyDetails sharedFolderChangeMembersManagementPolicyDetails = (SharedFolderChangeMembersManagementPolicyDetails) obj;
        AclUpdatePolicy aclUpdatePolicy3 = this.newValue;
        AclUpdatePolicy aclUpdatePolicy4 = sharedFolderChangeMembersManagementPolicyDetails.newValue;
        return (aclUpdatePolicy3 == aclUpdatePolicy4 || aclUpdatePolicy3.equals(aclUpdatePolicy4)) && ((aclUpdatePolicy = this.previousValue) == (aclUpdatePolicy2 = sharedFolderChangeMembersManagementPolicyDetails.previousValue) || (aclUpdatePolicy != null && aclUpdatePolicy.equals(aclUpdatePolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedFolderChangeMembersManagementPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFolderChangeMembersManagementPolicyDetails sharedFolderChangeMembersManagementPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            AclUpdatePolicy.Serializer.INSTANCE.serialize(sharedFolderChangeMembersManagementPolicyDetails.newValue, jsonGenerator);
            if (sharedFolderChangeMembersManagementPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).serialize(sharedFolderChangeMembersManagementPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFolderChangeMembersManagementPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AclUpdatePolicy aclUpdatePolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AclUpdatePolicy aclUpdatePolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        aclUpdatePolicyDeserialize = AclUpdatePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        aclUpdatePolicy = (AclUpdatePolicy) StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (aclUpdatePolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharedFolderChangeMembersManagementPolicyDetails sharedFolderChangeMembersManagementPolicyDetails = new SharedFolderChangeMembersManagementPolicyDetails(aclUpdatePolicyDeserialize, aclUpdatePolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFolderChangeMembersManagementPolicyDetails, sharedFolderChangeMembersManagementPolicyDetails.toStringMultiline());
                return sharedFolderChangeMembersManagementPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
