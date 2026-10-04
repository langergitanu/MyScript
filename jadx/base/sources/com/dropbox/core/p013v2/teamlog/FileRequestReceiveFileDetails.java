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
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class FileRequestReceiveFileDetails {

    @Nullable
    protected final FileRequestDetails fileRequestDetails;

    @Nullable
    protected final String fileRequestId;

    @Nonnull
    protected final List<String> submittedFileNames;

    @Nullable
    protected final String submitterEmail;

    @Nullable
    protected final String submitterName;

    public FileRequestReceiveFileDetails(@Nonnull List<String> list, @Nullable String str, @Nullable FileRequestDetails fileRequestDetails, @Nullable String str2, @Nullable String str3) {
        if (str != null) {
            if (str.length() < 1) {
                throw new IllegalArgumentException("String 'fileRequestId' is shorter than 1");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z]+", str)) {
                throw new IllegalArgumentException("String 'fileRequestId' does not match pattern");
            }
        }
        this.fileRequestId = str;
        this.fileRequestDetails = fileRequestDetails;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'submittedFileNames' is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'submittedFileNames' is null");
            }
        }
        this.submittedFileNames = list;
        this.submitterName = str2;
        if (str3 != null && str3.length() > 255) {
            throw new IllegalArgumentException("String 'submitterEmail' is longer than 255");
        }
        this.submitterEmail = str3;
    }

    public FileRequestReceiveFileDetails(@Nonnull List<String> list) {
        this(list, null, null, null, null);
    }

    @Nonnull
    public List<String> getSubmittedFileNames() {
        return this.submittedFileNames;
    }

    @Nullable
    public String getFileRequestId() {
        return this.fileRequestId;
    }

    @Nullable
    public FileRequestDetails getFileRequestDetails() {
        return this.fileRequestDetails;
    }

    @Nullable
    public String getSubmitterName() {
        return this.submitterName;
    }

    @Nullable
    public String getSubmitterEmail() {
        return this.submitterEmail;
    }

    public static Builder newBuilder(List<String> list) {
        return new Builder(list);
    }

    public static class Builder {
        protected FileRequestDetails fileRequestDetails;
        protected String fileRequestId;
        protected final List<String> submittedFileNames;
        protected String submitterEmail;
        protected String submitterName;

        protected Builder(List<String> list) {
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'submittedFileNames' is null");
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'submittedFileNames' is null");
                }
            }
            this.submittedFileNames = list;
            this.fileRequestId = null;
            this.fileRequestDetails = null;
            this.submitterName = null;
            this.submitterEmail = null;
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

        public Builder withFileRequestDetails(FileRequestDetails fileRequestDetails) {
            this.fileRequestDetails = fileRequestDetails;
            return this;
        }

        public Builder withSubmitterName(String str) {
            this.submitterName = str;
            return this;
        }

        public Builder withSubmitterEmail(String str) {
            if (str != null && str.length() > 255) {
                throw new IllegalArgumentException("String 'submitterEmail' is longer than 255");
            }
            this.submitterEmail = str;
            return this;
        }

        public FileRequestReceiveFileDetails build() {
            return new FileRequestReceiveFileDetails(this.submittedFileNames, this.fileRequestId, this.fileRequestDetails, this.submitterName, this.submitterEmail);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.fileRequestId, this.fileRequestDetails, this.submittedFileNames, this.submitterName, this.submitterEmail});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        FileRequestDetails fileRequestDetails;
        FileRequestDetails fileRequestDetails2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileRequestReceiveFileDetails fileRequestReceiveFileDetails = (FileRequestReceiveFileDetails) obj;
        List<String> list = this.submittedFileNames;
        List<String> list2 = fileRequestReceiveFileDetails.submittedFileNames;
        return (list == list2 || list.equals(list2)) && ((str = this.fileRequestId) == (str2 = fileRequestReceiveFileDetails.fileRequestId) || (str != null && str.equals(str2))) && (((fileRequestDetails = this.fileRequestDetails) == (fileRequestDetails2 = fileRequestReceiveFileDetails.fileRequestDetails) || (fileRequestDetails != null && fileRequestDetails.equals(fileRequestDetails2))) && (((str3 = this.submitterName) == (str4 = fileRequestReceiveFileDetails.submitterName) || (str3 != null && str3.equals(str4))) && ((str5 = this.submitterEmail) == (str6 = fileRequestReceiveFileDetails.submitterEmail) || (str5 != null && str5.equals(str6)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileRequestReceiveFileDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileRequestReceiveFileDetails fileRequestReceiveFileDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("submitted_file_names");
            StoneSerializers.list(StoneSerializers.string()).serialize(fileRequestReceiveFileDetails.submittedFileNames, jsonGenerator);
            if (fileRequestReceiveFileDetails.fileRequestId != null) {
                jsonGenerator.writeFieldName("file_request_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileRequestReceiveFileDetails.fileRequestId, jsonGenerator);
            }
            if (fileRequestReceiveFileDetails.fileRequestDetails != null) {
                jsonGenerator.writeFieldName("file_request_details");
                StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).serialize(fileRequestReceiveFileDetails.fileRequestDetails, jsonGenerator);
            }
            if (fileRequestReceiveFileDetails.submitterName != null) {
                jsonGenerator.writeFieldName("submitter_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileRequestReceiveFileDetails.submitterName, jsonGenerator);
            }
            if (fileRequestReceiveFileDetails.submitterEmail != null) {
                jsonGenerator.writeFieldName("submitter_email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileRequestReceiveFileDetails.submitterEmail, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileRequestReceiveFileDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                String str = null;
                FileRequestDetails fileRequestDetails = null;
                String str2 = null;
                String str3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("submitted_file_names".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("file_request_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("file_request_details".equals(currentName)) {
                        fileRequestDetails = (FileRequestDetails) StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("submitter_name".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("submitter_email".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"submitted_file_names\" missing.");
                }
                FileRequestReceiveFileDetails fileRequestReceiveFileDetails = new FileRequestReceiveFileDetails(list, str, fileRequestDetails, str2, str3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileRequestReceiveFileDetails, fileRequestReceiveFileDetails.toStringMultiline());
                return fileRequestReceiveFileDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
