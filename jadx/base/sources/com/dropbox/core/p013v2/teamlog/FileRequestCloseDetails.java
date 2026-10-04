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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class FileRequestCloseDetails {

    @Nullable
    protected final String fileRequestId;

    @Nullable
    protected final FileRequestDetails previousDetails;

    public FileRequestCloseDetails(@Nullable String str, @Nullable FileRequestDetails fileRequestDetails) {
        if (str != null) {
            if (str.length() < 1) {
                throw new IllegalArgumentException("String 'fileRequestId' is shorter than 1");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z]+", str)) {
                throw new IllegalArgumentException("String 'fileRequestId' does not match pattern");
            }
        }
        this.fileRequestId = str;
        this.previousDetails = fileRequestDetails;
    }

    public FileRequestCloseDetails() {
        this(null, null);
    }

    @Nullable
    public String getFileRequestId() {
        return this.fileRequestId;
    }

    @Nullable
    public FileRequestDetails getPreviousDetails() {
        return this.previousDetails;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String fileRequestId = null;
        protected FileRequestDetails previousDetails = null;

        protected Builder() {
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

        public FileRequestCloseDetails build() {
            return new FileRequestCloseDetails(this.fileRequestId, this.previousDetails);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.fileRequestId, this.previousDetails});
    }

    public boolean equals(Object obj) {
        FileRequestDetails fileRequestDetails;
        FileRequestDetails fileRequestDetails2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileRequestCloseDetails fileRequestCloseDetails = (FileRequestCloseDetails) obj;
        String str = this.fileRequestId;
        String str2 = fileRequestCloseDetails.fileRequestId;
        return (str == str2 || (str != null && str.equals(str2))) && ((fileRequestDetails = this.previousDetails) == (fileRequestDetails2 = fileRequestCloseDetails.previousDetails) || (fileRequestDetails != null && fileRequestDetails.equals(fileRequestDetails2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileRequestCloseDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileRequestCloseDetails fileRequestCloseDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (fileRequestCloseDetails.fileRequestId != null) {
                jsonGenerator.writeFieldName("file_request_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileRequestCloseDetails.fileRequestId, jsonGenerator);
            }
            if (fileRequestCloseDetails.previousDetails != null) {
                jsonGenerator.writeFieldName("previous_details");
                StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).serialize(fileRequestCloseDetails.previousDetails, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileRequestCloseDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileRequestDetails fileRequestDetails = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("file_request_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("previous_details".equals(currentName)) {
                        fileRequestDetails = (FileRequestDetails) StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                FileRequestCloseDetails fileRequestCloseDetails = new FileRequestCloseDetails(str, fileRequestDetails);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileRequestCloseDetails, fileRequestCloseDetails.toStringMultiline());
                return fileRequestCloseDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
