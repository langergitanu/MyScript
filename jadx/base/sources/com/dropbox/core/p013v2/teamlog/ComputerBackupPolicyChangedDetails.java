package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ComputerBackupPolicy;
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
public class ComputerBackupPolicyChangedDetails {

    @Nonnull
    protected final ComputerBackupPolicy newValue;

    @Nonnull
    protected final ComputerBackupPolicy previousValue;

    public ComputerBackupPolicyChangedDetails(@Nonnull ComputerBackupPolicy computerBackupPolicy, @Nonnull ComputerBackupPolicy computerBackupPolicy2) {
        if (computerBackupPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = computerBackupPolicy;
        if (computerBackupPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = computerBackupPolicy2;
    }

    @Nonnull
    public ComputerBackupPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public ComputerBackupPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        ComputerBackupPolicy computerBackupPolicy;
        ComputerBackupPolicy computerBackupPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ComputerBackupPolicyChangedDetails computerBackupPolicyChangedDetails = (ComputerBackupPolicyChangedDetails) obj;
        ComputerBackupPolicy computerBackupPolicy3 = this.newValue;
        ComputerBackupPolicy computerBackupPolicy4 = computerBackupPolicyChangedDetails.newValue;
        return (computerBackupPolicy3 == computerBackupPolicy4 || computerBackupPolicy3.equals(computerBackupPolicy4)) && ((computerBackupPolicy = this.previousValue) == (computerBackupPolicy2 = computerBackupPolicyChangedDetails.previousValue) || computerBackupPolicy.equals(computerBackupPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ComputerBackupPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ComputerBackupPolicyChangedDetails computerBackupPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            ComputerBackupPolicy.Serializer.INSTANCE.serialize(computerBackupPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            ComputerBackupPolicy.Serializer.INSTANCE.serialize(computerBackupPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ComputerBackupPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ComputerBackupPolicy computerBackupPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ComputerBackupPolicy computerBackupPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        computerBackupPolicyDeserialize = ComputerBackupPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        computerBackupPolicyDeserialize2 = ComputerBackupPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (computerBackupPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (computerBackupPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                ComputerBackupPolicyChangedDetails computerBackupPolicyChangedDetails = new ComputerBackupPolicyChangedDetails(computerBackupPolicyDeserialize, computerBackupPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(computerBackupPolicyChangedDetails, computerBackupPolicyChangedDetails.toStringMultiline());
                return computerBackupPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
