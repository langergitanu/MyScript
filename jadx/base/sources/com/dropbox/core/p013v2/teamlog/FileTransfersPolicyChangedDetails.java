package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FileTransfersPolicy;
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
public class FileTransfersPolicyChangedDetails {

    @Nonnull
    protected final FileTransfersPolicy newValue;

    @Nonnull
    protected final FileTransfersPolicy previousValue;

    public FileTransfersPolicyChangedDetails(@Nonnull FileTransfersPolicy fileTransfersPolicy, @Nonnull FileTransfersPolicy fileTransfersPolicy2) {
        if (fileTransfersPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = fileTransfersPolicy;
        if (fileTransfersPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = fileTransfersPolicy2;
    }

    @Nonnull
    public FileTransfersPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public FileTransfersPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        FileTransfersPolicy fileTransfersPolicy;
        FileTransfersPolicy fileTransfersPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileTransfersPolicyChangedDetails fileTransfersPolicyChangedDetails = (FileTransfersPolicyChangedDetails) obj;
        FileTransfersPolicy fileTransfersPolicy3 = this.newValue;
        FileTransfersPolicy fileTransfersPolicy4 = fileTransfersPolicyChangedDetails.newValue;
        return (fileTransfersPolicy3 == fileTransfersPolicy4 || fileTransfersPolicy3.equals(fileTransfersPolicy4)) && ((fileTransfersPolicy = this.previousValue) == (fileTransfersPolicy2 = fileTransfersPolicyChangedDetails.previousValue) || fileTransfersPolicy.equals(fileTransfersPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileTransfersPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileTransfersPolicyChangedDetails fileTransfersPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            FileTransfersPolicy.Serializer.INSTANCE.serialize(fileTransfersPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            FileTransfersPolicy.Serializer.INSTANCE.serialize(fileTransfersPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileTransfersPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileTransfersPolicy fileTransfersPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileTransfersPolicy fileTransfersPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        fileTransfersPolicyDeserialize = FileTransfersPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        fileTransfersPolicyDeserialize2 = FileTransfersPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileTransfersPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (fileTransfersPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                FileTransfersPolicyChangedDetails fileTransfersPolicyChangedDetails = new FileTransfersPolicyChangedDetails(fileTransfersPolicyDeserialize, fileTransfersPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileTransfersPolicyChangedDetails, fileTransfersPolicyChangedDetails.toStringMultiline());
                return fileTransfersPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
