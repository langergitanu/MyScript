package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FileRequestDetails;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class FileRequestChangeDetails {

    @Nullable
    protected final String fileRequestId;

    @Nonnull
    protected final FileRequestDetails newDetails;

    @Nullable
    protected final FileRequestDetails previousDetails;

    public FileRequestChangeDetails(@Nonnull FileRequestDetails fileRequestDetails, @Nullable String str, @Nullable FileRequestDetails fileRequestDetails2) {
        if (str != null) {
            if (str.length() < 1) {
                throw new IllegalArgumentException("String 'fileRequestId' is shorter than 1");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z]+", str)) {
                throw new IllegalArgumentException("String 'fileRequestId' does not match pattern");
            }
        }
        this.fileRequestId = str;
        this.previousDetails = fileRequestDetails2;
        if (fileRequestDetails == null) {
            throw new IllegalArgumentException("Required value for 'newDetails' is null");
        }
        this.newDetails = fileRequestDetails;
    }

    public FileRequestChangeDetails(@Nonnull FileRequestDetails fileRequestDetails) {
        this(fileRequestDetails, null, null);
    }

    @Nonnull
    public FileRequestDetails getNewDetails() {
        return this.newDetails;
    }

    @Nullable
    public String getFileRequestId() {
        return this.fileRequestId;
    }

    @Nullable
    public FileRequestDetails getPreviousDetails() {
        return this.previousDetails;
    }

    public static Builder newBuilder(FileRequestDetails fileRequestDetails) {
        return new Builder(fileRequestDetails);
    }

    public static class Builder {
        protected String fileRequestId;
        protected final FileRequestDetails newDetails;
        protected FileRequestDetails previousDetails;

        protected Builder(FileRequestDetails fileRequestDetails) {
            if (fileRequestDetails == null) {
                throw new IllegalArgumentException("Required value for 'newDetails' is null");
            }
            this.newDetails = fileRequestDetails;
            this.fileRequestId = null;
            this.previousDetails = null;
        }

        public Builder withFileRequestId(String str) {
            if (str != null) {
                if (str.length() < 1) {
                    throw new IllegalArgumentException("String 'fileRequestId' is shorter than 1");
                }
                if (!Pattern.matches("[-_0-9a-zA-Z]+", str)) {
                    throw new IllegalArgumentException("String 'fileRequestId' does not match pattern");
                }
            }
            this.fileRequestId = str;
            return this;
        }

        public Builder withPreviousDetails(FileRequestDetails fileRequestDetails) {
            this.previousDetails = fileRequestDetails;
            return this;
        }

        public FileRequestChangeDetails build() {
            return new FileRequestChangeDetails(this.newDetails, this.fileRequestId, this.previousDetails);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.fileRequestId, this.previousDetails, this.newDetails});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        FileRequestDetails fileRequestDetails;
        FileRequestDetails fileRequestDetails2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileRequestChangeDetails fileRequestChangeDetails = (FileRequestChangeDetails) obj;
        FileRequestDetails fileRequestDetails3 = this.newDetails;
        FileRequestDetails fileRequestDetails4 = fileRequestChangeDetails.newDetails;
        return (fileRequestDetails3 == fileRequestDetails4 || fileRequestDetails3.equals(fileRequestDetails4)) && ((str = this.fileRequestId) == (str2 = fileRequestChangeDetails.fileRequestId) || (str != null && str.equals(str2))) && ((fileRequestDetails = this.previousDetails) == (fileRequestDetails2 = fileRequestChangeDetails.previousDetails) || (fileRequestDetails != null && fileRequestDetails.equals(fileRequestDetails2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileRequestChangeDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileRequestChangeDetails fileRequestChangeDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_details");
            FileRequestDetails.Serializer.INSTANCE.serialize(fileRequestChangeDetails.newDetails, jsonGenerator);
            if (fileRequestChangeDetails.fileRequestId != null) {
                jsonGenerator.writeFieldName("file_request_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileRequestChangeDetails.fileRequestId, jsonGenerator);
            }
            if (fileRequestChangeDetails.previousDetails != null) {
                jsonGenerator.writeFieldName("previous_details");
                StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).serialize(fileRequestChangeDetails.previousDetails, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileRequestChangeDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileRequestDetails fileRequestDetailsDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                FileRequestDetails fileRequestDetails = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_details".equals(currentName)) {
                        fileRequestDetailsDeserialize = FileRequestDetails.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("file_request_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("previous_details".equals(currentName)) {
                        fileRequestDetails = (FileRequestDetails) StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileRequestDetailsDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_details\" missing.");
                }
                FileRequestChangeDetails fileRequestChangeDetails = new FileRequestChangeDetails(fileRequestDetailsDeserialize, str, fileRequestDetails);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileRequestChangeDetails, fileRequestChangeDetails.toStringMultiline());
                return fileRequestChangeDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
