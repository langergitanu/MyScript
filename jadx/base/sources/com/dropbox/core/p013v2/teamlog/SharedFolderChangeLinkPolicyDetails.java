package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.sharing.SharedLinkPolicy;
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
public class SharedFolderChangeLinkPolicyDetails {

    @Nonnull
    protected final SharedLinkPolicy newValue;

    @Nullable
    protected final SharedLinkPolicy previousValue;

    public SharedFolderChangeLinkPolicyDetails(@Nonnull SharedLinkPolicy sharedLinkPolicy, @Nullable SharedLinkPolicy sharedLinkPolicy2) {
        if (sharedLinkPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = sharedLinkPolicy;
        this.previousValue = sharedLinkPolicy2;
    }

    public SharedFolderChangeLinkPolicyDetails(@Nonnull SharedLinkPolicy sharedLinkPolicy) {
        this(sharedLinkPolicy, null);
    }

    @Nonnull
    public SharedLinkPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public SharedLinkPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        SharedLinkPolicy sharedLinkPolicy;
        SharedLinkPolicy sharedLinkPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedFolderChangeLinkPolicyDetails sharedFolderChangeLinkPolicyDetails = (SharedFolderChangeLinkPolicyDetails) obj;
        SharedLinkPolicy sharedLinkPolicy3 = this.newValue;
        SharedLinkPolicy sharedLinkPolicy4 = sharedFolderChangeLinkPolicyDetails.newValue;
        return (sharedLinkPolicy3 == sharedLinkPolicy4 || sharedLinkPolicy3.equals(sharedLinkPolicy4)) && ((sharedLinkPolicy = this.previousValue) == (sharedLinkPolicy2 = sharedFolderChangeLinkPolicyDetails.previousValue) || (sharedLinkPolicy != null && sharedLinkPolicy.equals(sharedLinkPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedFolderChangeLinkPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFolderChangeLinkPolicyDetails sharedFolderChangeLinkPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            SharedLinkPolicy.Serializer.INSTANCE.serialize(sharedFolderChangeLinkPolicyDetails.newValue, jsonGenerator);
            if (sharedFolderChangeLinkPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).serialize(sharedFolderChangeLinkPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFolderChangeLinkPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SharedLinkPolicy sharedLinkPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SharedLinkPolicy sharedLinkPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        sharedLinkPolicyDeserialize = SharedLinkPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        sharedLinkPolicy = (SharedLinkPolicy) StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (sharedLinkPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharedFolderChangeLinkPolicyDetails sharedFolderChangeLinkPolicyDetails = new SharedFolderChangeLinkPolicyDetails(sharedLinkPolicyDeserialize, sharedLinkPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFolderChangeLinkPolicyDetails, sharedFolderChangeLinkPolicyDetails.toStringMultiline());
                return sharedFolderChangeLinkPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
