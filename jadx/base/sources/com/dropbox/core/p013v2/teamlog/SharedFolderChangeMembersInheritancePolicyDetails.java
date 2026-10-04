package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SharedFolderMembersInheritancePolicy;
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
public class SharedFolderChangeMembersInheritancePolicyDetails {

    @Nonnull
    protected final SharedFolderMembersInheritancePolicy newValue;

    @Nullable
    protected final SharedFolderMembersInheritancePolicy previousValue;

    public SharedFolderChangeMembersInheritancePolicyDetails(@Nonnull SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicy, @Nullable SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicy2) {
        if (sharedFolderMembersInheritancePolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = sharedFolderMembersInheritancePolicy;
        this.previousValue = sharedFolderMembersInheritancePolicy2;
    }

    public SharedFolderChangeMembersInheritancePolicyDetails(@Nonnull SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicy) {
        this(sharedFolderMembersInheritancePolicy, null);
    }

    @Nonnull
    public SharedFolderMembersInheritancePolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public SharedFolderMembersInheritancePolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicy;
        SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedFolderChangeMembersInheritancePolicyDetails sharedFolderChangeMembersInheritancePolicyDetails = (SharedFolderChangeMembersInheritancePolicyDetails) obj;
        SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicy3 = this.newValue;
        SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicy4 = sharedFolderChangeMembersInheritancePolicyDetails.newValue;
        return (sharedFolderMembersInheritancePolicy3 == sharedFolderMembersInheritancePolicy4 || sharedFolderMembersInheritancePolicy3.equals(sharedFolderMembersInheritancePolicy4)) && ((sharedFolderMembersInheritancePolicy = this.previousValue) == (sharedFolderMembersInheritancePolicy2 = sharedFolderChangeMembersInheritancePolicyDetails.previousValue) || (sharedFolderMembersInheritancePolicy != null && sharedFolderMembersInheritancePolicy.equals(sharedFolderMembersInheritancePolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedFolderChangeMembersInheritancePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFolderChangeMembersInheritancePolicyDetails sharedFolderChangeMembersInheritancePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            SharedFolderMembersInheritancePolicy.Serializer.INSTANCE.serialize(sharedFolderChangeMembersInheritancePolicyDetails.newValue, jsonGenerator);
            if (sharedFolderChangeMembersInheritancePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(SharedFolderMembersInheritancePolicy.Serializer.INSTANCE).serialize(sharedFolderChangeMembersInheritancePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFolderChangeMembersInheritancePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        sharedFolderMembersInheritancePolicyDeserialize = SharedFolderMembersInheritancePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        sharedFolderMembersInheritancePolicy = (SharedFolderMembersInheritancePolicy) StoneSerializers.nullable(SharedFolderMembersInheritancePolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (sharedFolderMembersInheritancePolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharedFolderChangeMembersInheritancePolicyDetails sharedFolderChangeMembersInheritancePolicyDetails = new SharedFolderChangeMembersInheritancePolicyDetails(sharedFolderMembersInheritancePolicyDeserialize, sharedFolderMembersInheritancePolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFolderChangeMembersInheritancePolicyDetails, sharedFolderChangeMembersInheritancePolicyDetails.toStringMultiline());
                return sharedFolderChangeMembersInheritancePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
