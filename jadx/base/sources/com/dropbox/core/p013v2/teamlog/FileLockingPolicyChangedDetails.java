package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.FileLockingPolicyState;
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
public class FileLockingPolicyChangedDetails {

    @Nonnull
    protected final FileLockingPolicyState newValue;

    @Nonnull
    protected final FileLockingPolicyState previousValue;

    public FileLockingPolicyChangedDetails(@Nonnull FileLockingPolicyState fileLockingPolicyState, @Nonnull FileLockingPolicyState fileLockingPolicyState2) {
        if (fileLockingPolicyState == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = fileLockingPolicyState;
        if (fileLockingPolicyState2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = fileLockingPolicyState2;
    }

    @Nonnull
    public FileLockingPolicyState getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public FileLockingPolicyState getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        FileLockingPolicyState fileLockingPolicyState;
        FileLockingPolicyState fileLockingPolicyState2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileLockingPolicyChangedDetails fileLockingPolicyChangedDetails = (FileLockingPolicyChangedDetails) obj;
        FileLockingPolicyState fileLockingPolicyState3 = this.newValue;
        FileLockingPolicyState fileLockingPolicyState4 = fileLockingPolicyChangedDetails.newValue;
        return (fileLockingPolicyState3 == fileLockingPolicyState4 || fileLockingPolicyState3.equals(fileLockingPolicyState4)) && ((fileLockingPolicyState = this.previousValue) == (fileLockingPolicyState2 = fileLockingPolicyChangedDetails.previousValue) || fileLockingPolicyState.equals(fileLockingPolicyState2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileLockingPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileLockingPolicyChangedDetails fileLockingPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            FileLockingPolicyState.Serializer.INSTANCE.serialize(fileLockingPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            FileLockingPolicyState.Serializer.INSTANCE.serialize(fileLockingPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileLockingPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileLockingPolicyState fileLockingPolicyStateDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileLockingPolicyState fileLockingPolicyStateDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        fileLockingPolicyStateDeserialize = FileLockingPolicyState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        fileLockingPolicyStateDeserialize2 = FileLockingPolicyState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileLockingPolicyStateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (fileLockingPolicyStateDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                FileLockingPolicyChangedDetails fileLockingPolicyChangedDetails = new FileLockingPolicyChangedDetails(fileLockingPolicyStateDeserialize, fileLockingPolicyStateDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileLockingPolicyChangedDetails, fileLockingPolicyChangedDetails.toStringMultiline());
                return fileLockingPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
