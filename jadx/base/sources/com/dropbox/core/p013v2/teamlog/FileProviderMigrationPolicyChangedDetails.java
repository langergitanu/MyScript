package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.FileProviderMigrationPolicyState;
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
public class FileProviderMigrationPolicyChangedDetails {

    @Nonnull
    protected final FileProviderMigrationPolicyState newValue;

    @Nonnull
    protected final FileProviderMigrationPolicyState previousValue;

    public FileProviderMigrationPolicyChangedDetails(@Nonnull FileProviderMigrationPolicyState fileProviderMigrationPolicyState, @Nonnull FileProviderMigrationPolicyState fileProviderMigrationPolicyState2) {
        if (fileProviderMigrationPolicyState == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = fileProviderMigrationPolicyState;
        if (fileProviderMigrationPolicyState2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = fileProviderMigrationPolicyState2;
    }

    @Nonnull
    public FileProviderMigrationPolicyState getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public FileProviderMigrationPolicyState getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        FileProviderMigrationPolicyState fileProviderMigrationPolicyState;
        FileProviderMigrationPolicyState fileProviderMigrationPolicyState2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileProviderMigrationPolicyChangedDetails fileProviderMigrationPolicyChangedDetails = (FileProviderMigrationPolicyChangedDetails) obj;
        FileProviderMigrationPolicyState fileProviderMigrationPolicyState3 = this.newValue;
        FileProviderMigrationPolicyState fileProviderMigrationPolicyState4 = fileProviderMigrationPolicyChangedDetails.newValue;
        return (fileProviderMigrationPolicyState3 == fileProviderMigrationPolicyState4 || fileProviderMigrationPolicyState3.equals(fileProviderMigrationPolicyState4)) && ((fileProviderMigrationPolicyState = this.previousValue) == (fileProviderMigrationPolicyState2 = fileProviderMigrationPolicyChangedDetails.previousValue) || fileProviderMigrationPolicyState.equals(fileProviderMigrationPolicyState2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileProviderMigrationPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileProviderMigrationPolicyChangedDetails fileProviderMigrationPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            FileProviderMigrationPolicyState.Serializer.INSTANCE.serialize(fileProviderMigrationPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            FileProviderMigrationPolicyState.Serializer.INSTANCE.serialize(fileProviderMigrationPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileProviderMigrationPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileProviderMigrationPolicyState fileProviderMigrationPolicyStateDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileProviderMigrationPolicyState fileProviderMigrationPolicyStateDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        fileProviderMigrationPolicyStateDeserialize = FileProviderMigrationPolicyState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        fileProviderMigrationPolicyStateDeserialize2 = FileProviderMigrationPolicyState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileProviderMigrationPolicyStateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (fileProviderMigrationPolicyStateDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                FileProviderMigrationPolicyChangedDetails fileProviderMigrationPolicyChangedDetails = new FileProviderMigrationPolicyChangedDetails(fileProviderMigrationPolicyStateDeserialize, fileProviderMigrationPolicyStateDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileProviderMigrationPolicyChangedDetails, fileProviderMigrationPolicyChangedDetails.toStringMultiline());
                return fileProviderMigrationPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
