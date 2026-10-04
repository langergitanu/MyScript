package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ExternalDriveBackupPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class ExternalDriveBackupPolicyChangedDetails {

    @Nonnull
    protected final ExternalDriveBackupPolicy newValue;

    @Nonnull
    protected final ExternalDriveBackupPolicy previousValue;

    public ExternalDriveBackupPolicyChangedDetails(@Nonnull ExternalDriveBackupPolicy externalDriveBackupPolicy, @Nonnull ExternalDriveBackupPolicy externalDriveBackupPolicy2) {
        if (externalDriveBackupPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = externalDriveBackupPolicy;
        if (externalDriveBackupPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = externalDriveBackupPolicy2;
    }

    @Nonnull
    public ExternalDriveBackupPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public ExternalDriveBackupPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ExternalDriveBackupPolicy externalDriveBackupPolicy;
        ExternalDriveBackupPolicy externalDriveBackupPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ExternalDriveBackupPolicyChangedDetails externalDriveBackupPolicyChangedDetails = (ExternalDriveBackupPolicyChangedDetails) obj;
        ExternalDriveBackupPolicy externalDriveBackupPolicy3 = this.newValue;
        ExternalDriveBackupPolicy externalDriveBackupPolicy4 = externalDriveBackupPolicyChangedDetails.newValue;
        return (externalDriveBackupPolicy3 == externalDriveBackupPolicy4 || externalDriveBackupPolicy3.equals(externalDriveBackupPolicy4)) && ((externalDriveBackupPolicy = this.previousValue) == (externalDriveBackupPolicy2 = externalDriveBackupPolicyChangedDetails.previousValue) || externalDriveBackupPolicy.equals(externalDriveBackupPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ExternalDriveBackupPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExternalDriveBackupPolicyChangedDetails externalDriveBackupPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ExternalDriveBackupPolicy.Serializer.INSTANCE.serialize(externalDriveBackupPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            ExternalDriveBackupPolicy.Serializer.INSTANCE.serialize(externalDriveBackupPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExternalDriveBackupPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ExternalDriveBackupPolicy externalDriveBackupPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ExternalDriveBackupPolicy externalDriveBackupPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        externalDriveBackupPolicyDeserialize = ExternalDriveBackupPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        externalDriveBackupPolicyDeserialize2 = ExternalDriveBackupPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (externalDriveBackupPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (externalDriveBackupPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                ExternalDriveBackupPolicyChangedDetails externalDriveBackupPolicyChangedDetails = new ExternalDriveBackupPolicyChangedDetails(externalDriveBackupPolicyDeserialize, externalDriveBackupPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(externalDriveBackupPolicyChangedDetails, externalDriveBackupPolicyChangedDetails.toStringMultiline());
                return externalDriveBackupPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
