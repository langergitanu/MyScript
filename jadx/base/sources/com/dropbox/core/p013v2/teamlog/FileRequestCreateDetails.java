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
public class FileRequestCreateDetails {

    @Nullable
    protected final String fileRequestId;

    @Nullable
    protected final FileRequestDetails requestDetails;

    public FileRequestCreateDetails(@Nullable String str, @Nullable FileRequestDetails fileRequestDetails) {
        if (str != null) {
            if (str.length() < 1) {
                throw new IllegalArgumentException("String 'fileRequestId' is shorter than 1");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z]+", str)) {
                throw new IllegalArgumentException("String 'fileRequestId' does not match pattern");
            }
        }
        this.fileRequestId = str;
        this.requestDetails = fileRequestDetails;
    }

    public FileRequestCreateDetails() {
        this(null, null);
    }

    @Nullable
    public String getFileRequestId() {
        return this.fileRequestId;
    }

    @Nullable
    public FileRequestDetails getRequestDetails() {
        return this.requestDetails;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String fileRequestId = null;
        protected FileRequestDetails requestDetails = null;

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

        public Builder withRequestDetails(FileRequestDetails fileRequestDetails) {
            this.requestDetails = fileRequestDetails;
            return this;
        }

        public FileRequestCreateDetails build() {
            return new FileRequestCreateDetails(this.fileRequestId, this.requestDetails);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.fileRequestId, this.requestDetails});
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
        FileRequestCreateDetails fileRequestCreateDetails = (FileRequestCreateDetails) obj;
        String str = this.fileRequestId;
        String str2 = fileRequestCreateDetails.fileRequestId;
        return (str == str2 || (str != null && str.equals(str2))) && ((fileRequestDetails = this.requestDetails) == (fileRequestDetails2 = fileRequestCreateDetails.requestDetails) || (fileRequestDetails != null && fileRequestDetails.equals(fileRequestDetails2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileRequestCreateDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileRequestCreateDetails fileRequestCreateDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (fileRequestCreateDetails.fileRequestId != null) {
                jsonGenerator.writeFieldName("file_request_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileRequestCreateDetails.fileRequestId, jsonGenerator);
            }
            if (fileRequestCreateDetails.requestDetails != null) {
                jsonGenerator.writeFieldName("request_details");
                StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).serialize(fileRequestCreateDetails.requestDetails, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileRequestCreateDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("request_details".equals(currentName)) {
                        fileRequestDetails = (FileRequestDetails) StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                FileRequestCreateDetails fileRequestCreateDetails = new FileRequestCreateDetails(str, fileRequestDetails);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileRequestCreateDetails, fileRequestCreateDetails.toStringMultiline());
                return fileRequestCreateDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
