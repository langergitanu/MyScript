package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.ExportMetadata;
import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class ExportResult {

    @Nonnull
    protected final ExportMetadata exportMetadata;

    @Nonnull
    protected final FileMetadata fileMetadata;

    public ExportResult(@Nonnull ExportMetadata exportMetadata, @Nonnull FileMetadata fileMetadata) {
        if (exportMetadata == null) {
            throw new IllegalArgumentException("Required value for 'exportMetadata' is null");
        }
        this.exportMetadata = exportMetadata;
        if (fileMetadata == null) {
            throw new IllegalArgumentException("Required value for 'fileMetadata' is null");
        }
        this.fileMetadata = fileMetadata;
    }

    @Nonnull
    public ExportMetadata getExportMetadata() {
        return this.exportMetadata;
    }

    @Nonnull
    public FileMetadata getFileMetadata() {
        return this.fileMetadata;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.exportMetadata, this.fileMetadata});
    }

    public boolean equals(Object obj) {
        FileMetadata fileMetadata;
        FileMetadata fileMetadata2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ExportResult exportResult = (ExportResult) obj;
        ExportMetadata exportMetadata = this.exportMetadata;
        ExportMetadata exportMetadata2 = exportResult.exportMetadata;
        return (exportMetadata == exportMetadata2 || exportMetadata.equals(exportMetadata2)) && ((fileMetadata = this.fileMetadata) == (fileMetadata2 = exportResult.fileMetadata) || fileMetadata.equals(fileMetadata2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<ExportResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExportResult exportResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("export_metadata");
            ExportMetadata.Serializer.INSTANCE.serialize(exportResult.exportMetadata, jsonGenerator);
            jsonGenerator.writeFieldName("file_metadata");
            FileMetadata.Serializer.INSTANCE.serialize(exportResult.fileMetadata, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExportResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ExportMetadata exportMetadataDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileMetadata fileMetadataDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("export_metadata".equals(currentName)) {
                        exportMetadataDeserialize = ExportMetadata.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("file_metadata".equals(currentName)) {
                        fileMetadataDeserialize = FileMetadata.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (exportMetadataDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"export_metadata\" missing.");
                }
                if (fileMetadataDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"file_metadata\" missing.");
                }
                ExportResult exportResult = new ExportResult(exportMetadataDeserialize, fileMetadataDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(exportResult, exportResult.toStringMultiline());
                return exportResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
