package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FileRequestsPolicy;
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
public class FileRequestsChangePolicyDetails {

    @Nonnull
    protected final FileRequestsPolicy newValue;

    @Nullable
    protected final FileRequestsPolicy previousValue;

    public FileRequestsChangePolicyDetails(@Nonnull FileRequestsPolicy fileRequestsPolicy, @Nullable FileRequestsPolicy fileRequestsPolicy2) {
        if (fileRequestsPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = fileRequestsPolicy;
        this.previousValue = fileRequestsPolicy2;
    }

    public FileRequestsChangePolicyDetails(@Nonnull FileRequestsPolicy fileRequestsPolicy) {
        this(fileRequestsPolicy, null);
    }

    @Nonnull
    public FileRequestsPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public FileRequestsPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        FileRequestsPolicy fileRequestsPolicy;
        FileRequestsPolicy fileRequestsPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileRequestsChangePolicyDetails fileRequestsChangePolicyDetails = (FileRequestsChangePolicyDetails) obj;
        FileRequestsPolicy fileRequestsPolicy3 = this.newValue;
        FileRequestsPolicy fileRequestsPolicy4 = fileRequestsChangePolicyDetails.newValue;
        return (fileRequestsPolicy3 == fileRequestsPolicy4 || fileRequestsPolicy3.equals(fileRequestsPolicy4)) && ((fileRequestsPolicy = this.previousValue) == (fileRequestsPolicy2 = fileRequestsChangePolicyDetails.previousValue) || (fileRequestsPolicy != null && fileRequestsPolicy.equals(fileRequestsPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileRequestsChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileRequestsChangePolicyDetails fileRequestsChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            FileRequestsPolicy.Serializer.INSTANCE.serialize(fileRequestsChangePolicyDetails.newValue, jsonGenerator);
            if (fileRequestsChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(FileRequestsPolicy.Serializer.INSTANCE).serialize(fileRequestsChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileRequestsChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileRequestsPolicy fileRequestsPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileRequestsPolicy fileRequestsPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        fileRequestsPolicyDeserialize = FileRequestsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        fileRequestsPolicy = (FileRequestsPolicy) StoneSerializers.nullable(FileRequestsPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileRequestsPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                FileRequestsChangePolicyDetails fileRequestsChangePolicyDetails = new FileRequestsChangePolicyDetails(fileRequestsPolicyDeserialize, fileRequestsPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileRequestsChangePolicyDetails, fileRequestsChangePolicyDetails.toStringMultiline());
                return fileRequestsChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
