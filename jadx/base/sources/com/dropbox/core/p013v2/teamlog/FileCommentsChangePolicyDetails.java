package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FileCommentsPolicy;
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
public class FileCommentsChangePolicyDetails {

    @Nonnull
    protected final FileCommentsPolicy newValue;

    @Nullable
    protected final FileCommentsPolicy previousValue;

    public FileCommentsChangePolicyDetails(@Nonnull FileCommentsPolicy fileCommentsPolicy, @Nullable FileCommentsPolicy fileCommentsPolicy2) {
        if (fileCommentsPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = fileCommentsPolicy;
        this.previousValue = fileCommentsPolicy2;
    }

    public FileCommentsChangePolicyDetails(@Nonnull FileCommentsPolicy fileCommentsPolicy) {
        this(fileCommentsPolicy, null);
    }

    @Nonnull
    public FileCommentsPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public FileCommentsPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        FileCommentsPolicy fileCommentsPolicy;
        FileCommentsPolicy fileCommentsPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileCommentsChangePolicyDetails fileCommentsChangePolicyDetails = (FileCommentsChangePolicyDetails) obj;
        FileCommentsPolicy fileCommentsPolicy3 = this.newValue;
        FileCommentsPolicy fileCommentsPolicy4 = fileCommentsChangePolicyDetails.newValue;
        return (fileCommentsPolicy3 == fileCommentsPolicy4 || fileCommentsPolicy3.equals(fileCommentsPolicy4)) && ((fileCommentsPolicy = this.previousValue) == (fileCommentsPolicy2 = fileCommentsChangePolicyDetails.previousValue) || (fileCommentsPolicy != null && fileCommentsPolicy.equals(fileCommentsPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileCommentsChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileCommentsChangePolicyDetails fileCommentsChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            FileCommentsPolicy.Serializer.INSTANCE.serialize(fileCommentsChangePolicyDetails.newValue, jsonGenerator);
            if (fileCommentsChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(FileCommentsPolicy.Serializer.INSTANCE).serialize(fileCommentsChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileCommentsChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileCommentsPolicy fileCommentsPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileCommentsPolicy fileCommentsPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        fileCommentsPolicyDeserialize = FileCommentsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        fileCommentsPolicy = (FileCommentsPolicy) StoneSerializers.nullable(FileCommentsPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileCommentsPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                FileCommentsChangePolicyDetails fileCommentsChangePolicyDetails = new FileCommentsChangePolicyDetails(fileCommentsPolicyDeserialize, fileCommentsPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileCommentsChangePolicyDetails, fileCommentsChangePolicyDetails.toStringMultiline());
                return fileCommentsChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
