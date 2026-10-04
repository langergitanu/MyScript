package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SharingFolderJoinPolicy;
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
public class SharingChangeFolderJoinPolicyDetails {

    @Nonnull
    protected final SharingFolderJoinPolicy newValue;

    @Nullable
    protected final SharingFolderJoinPolicy previousValue;

    public SharingChangeFolderJoinPolicyDetails(@Nonnull SharingFolderJoinPolicy sharingFolderJoinPolicy, @Nullable SharingFolderJoinPolicy sharingFolderJoinPolicy2) {
        if (sharingFolderJoinPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = sharingFolderJoinPolicy;
        this.previousValue = sharingFolderJoinPolicy2;
    }

    public SharingChangeFolderJoinPolicyDetails(@Nonnull SharingFolderJoinPolicy sharingFolderJoinPolicy) {
        this(sharingFolderJoinPolicy, null);
    }

    @Nonnull
    public SharingFolderJoinPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public SharingFolderJoinPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        SharingFolderJoinPolicy sharingFolderJoinPolicy;
        SharingFolderJoinPolicy sharingFolderJoinPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharingChangeFolderJoinPolicyDetails sharingChangeFolderJoinPolicyDetails = (SharingChangeFolderJoinPolicyDetails) obj;
        SharingFolderJoinPolicy sharingFolderJoinPolicy3 = this.newValue;
        SharingFolderJoinPolicy sharingFolderJoinPolicy4 = sharingChangeFolderJoinPolicyDetails.newValue;
        return (sharingFolderJoinPolicy3 == sharingFolderJoinPolicy4 || sharingFolderJoinPolicy3.equals(sharingFolderJoinPolicy4)) && ((sharingFolderJoinPolicy = this.previousValue) == (sharingFolderJoinPolicy2 = sharingChangeFolderJoinPolicyDetails.previousValue) || (sharingFolderJoinPolicy != null && sharingFolderJoinPolicy.equals(sharingFolderJoinPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharingChangeFolderJoinPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharingChangeFolderJoinPolicyDetails sharingChangeFolderJoinPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            SharingFolderJoinPolicy.Serializer.INSTANCE.serialize(sharingChangeFolderJoinPolicyDetails.newValue, jsonGenerator);
            if (sharingChangeFolderJoinPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(SharingFolderJoinPolicy.Serializer.INSTANCE).serialize(sharingChangeFolderJoinPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharingChangeFolderJoinPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SharingFolderJoinPolicy sharingFolderJoinPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SharingFolderJoinPolicy sharingFolderJoinPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        sharingFolderJoinPolicyDeserialize = SharingFolderJoinPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        sharingFolderJoinPolicy = (SharingFolderJoinPolicy) StoneSerializers.nullable(SharingFolderJoinPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (sharingFolderJoinPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharingChangeFolderJoinPolicyDetails sharingChangeFolderJoinPolicyDetails = new SharingChangeFolderJoinPolicyDetails(sharingFolderJoinPolicyDeserialize, sharingFolderJoinPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharingChangeFolderJoinPolicyDetails, sharingChangeFolderJoinPolicyDetails.toStringMultiline());
                return sharingChangeFolderJoinPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
