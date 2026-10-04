package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.p013v2.files.MinimalFileLinkMetadata;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class PreviewResult {

    @Nullable
    protected final FileMetadata fileMetadata;

    @Nullable
    protected final MinimalFileLinkMetadata linkMetadata;

    public PreviewResult(@Nullable FileMetadata fileMetadata, @Nullable MinimalFileLinkMetadata minimalFileLinkMetadata) {
        this.fileMetadata = fileMetadata;
        this.linkMetadata = minimalFileLinkMetadata;
    }

    public PreviewResult() {
        this(null, null);
    }

    @Nullable
    public FileMetadata getFileMetadata() {
        return this.fileMetadata;
    }

    @Nullable
    public MinimalFileLinkMetadata getLinkMetadata() {
        return this.linkMetadata;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected FileMetadata fileMetadata = null;
        protected MinimalFileLinkMetadata linkMetadata = null;

        protected Builder() {
        }

        public Builder withFileMetadata(FileMetadata fileMetadata) {
            this.fileMetadata = fileMetadata;
            return this;
        }

        public Builder withLinkMetadata(MinimalFileLinkMetadata minimalFileLinkMetadata) {
            this.linkMetadata = minimalFileLinkMetadata;
            return this;
        }

        public PreviewResult build() {
            return new PreviewResult(this.fileMetadata, this.linkMetadata);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.fileMetadata, this.linkMetadata});
    }

    public boolean equals(Object obj) {
        MinimalFileLinkMetadata minimalFileLinkMetadata;
        MinimalFileLinkMetadata minimalFileLinkMetadata2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PreviewResult previewResult = (PreviewResult) obj;
        FileMetadata fileMetadata = this.fileMetadata;
        FileMetadata fileMetadata2 = previewResult.fileMetadata;
        return (fileMetadata == fileMetadata2 || (fileMetadata != null && fileMetadata.equals(fileMetadata2))) && ((minimalFileLinkMetadata = this.linkMetadata) == (minimalFileLinkMetadata2 = previewResult.linkMetadata) || (minimalFileLinkMetadata != null && minimalFileLinkMetadata.equals(minimalFileLinkMetadata2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PreviewResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PreviewResult previewResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (previewResult.fileMetadata != null) {
                jsonGenerator.writeFieldName("file_metadata");
                StoneSerializers.nullableStruct(FileMetadata.Serializer.INSTANCE).serialize(previewResult.fileMetadata, jsonGenerator);
            }
            if (previewResult.linkMetadata != null) {
                jsonGenerator.writeFieldName("link_metadata");
                StoneSerializers.nullableStruct(MinimalFileLinkMetadata.Serializer.INSTANCE).serialize(previewResult.linkMetadata, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PreviewResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileMetadata fileMetadata = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                MinimalFileLinkMetadata minimalFileLinkMetadata = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("file_metadata".equals(currentName)) {
                        fileMetadata = (FileMetadata) StoneSerializers.nullableStruct(FileMetadata.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("link_metadata".equals(currentName)) {
                        minimalFileLinkMetadata = (MinimalFileLinkMetadata) StoneSerializers.nullableStruct(MinimalFileLinkMetadata.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                PreviewResult previewResult = new PreviewResult(fileMetadata, minimalFileLinkMetadata);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(previewResult, previewResult.toStringMultiline());
                return previewResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
