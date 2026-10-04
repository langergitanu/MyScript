package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FileCommentNotificationPolicy;
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
public class FileChangeCommentSubscriptionDetails {

    @Nonnull
    protected final FileCommentNotificationPolicy newValue;

    @Nullable
    protected final FileCommentNotificationPolicy previousValue;

    public FileChangeCommentSubscriptionDetails(@Nonnull FileCommentNotificationPolicy fileCommentNotificationPolicy, @Nullable FileCommentNotificationPolicy fileCommentNotificationPolicy2) {
        if (fileCommentNotificationPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = fileCommentNotificationPolicy;
        this.previousValue = fileCommentNotificationPolicy2;
    }

    public FileChangeCommentSubscriptionDetails(@Nonnull FileCommentNotificationPolicy fileCommentNotificationPolicy) {
        this(fileCommentNotificationPolicy, null);
    }

    @Nonnull
    public FileCommentNotificationPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public FileCommentNotificationPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        FileCommentNotificationPolicy fileCommentNotificationPolicy;
        FileCommentNotificationPolicy fileCommentNotificationPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileChangeCommentSubscriptionDetails fileChangeCommentSubscriptionDetails = (FileChangeCommentSubscriptionDetails) obj;
        FileCommentNotificationPolicy fileCommentNotificationPolicy3 = this.newValue;
        FileCommentNotificationPolicy fileCommentNotificationPolicy4 = fileChangeCommentSubscriptionDetails.newValue;
        return (fileCommentNotificationPolicy3 == fileCommentNotificationPolicy4 || fileCommentNotificationPolicy3.equals(fileCommentNotificationPolicy4)) && ((fileCommentNotificationPolicy = this.previousValue) == (fileCommentNotificationPolicy2 = fileChangeCommentSubscriptionDetails.previousValue) || (fileCommentNotificationPolicy != null && fileCommentNotificationPolicy.equals(fileCommentNotificationPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileChangeCommentSubscriptionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileChangeCommentSubscriptionDetails fileChangeCommentSubscriptionDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            FileCommentNotificationPolicy.Serializer.INSTANCE.serialize(fileChangeCommentSubscriptionDetails.newValue, jsonGenerator);
            if (fileChangeCommentSubscriptionDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(FileCommentNotificationPolicy.Serializer.INSTANCE).serialize(fileChangeCommentSubscriptionDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileChangeCommentSubscriptionDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileCommentNotificationPolicy fileCommentNotificationPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileCommentNotificationPolicy fileCommentNotificationPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        fileCommentNotificationPolicyDeserialize = FileCommentNotificationPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        fileCommentNotificationPolicy = (FileCommentNotificationPolicy) StoneSerializers.nullable(FileCommentNotificationPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileCommentNotificationPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                FileChangeCommentSubscriptionDetails fileChangeCommentSubscriptionDetails = new FileChangeCommentSubscriptionDetails(fileCommentNotificationPolicyDeserialize, fileCommentNotificationPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileChangeCommentSubscriptionDetails, fileChangeCommentSubscriptionDetails.toStringMultiline());
                return fileChangeCommentSubscriptionDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
