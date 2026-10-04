package com.dropbox.core.p013v2.files;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.files.FolderMetadata;
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
public class CreateFolderResult extends FileOpsResult {

    @Nonnull
    protected final FolderMetadata metadata;

    public CreateFolderResult(@Nonnull FolderMetadata folderMetadata) {
        if (folderMetadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = folderMetadata;
    }

    @Nonnull
    public FolderMetadata getMetadata() {
        return this.metadata;
    }

    @Override // com.dropbox.core.p013v2.files.FileOpsResult
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.metadata});
    }

    @Override // com.dropbox.core.p013v2.files.FileOpsResult
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FolderMetadata folderMetadata = this.metadata;
        FolderMetadata folderMetadata2 = ((CreateFolderResult) obj).metadata;
        return folderMetadata == folderMetadata2 || folderMetadata.equals(folderMetadata2);
    }

    @Override // com.dropbox.core.p013v2.files.FileOpsResult
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.FileOpsResult
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CreateFolderResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CreateFolderResult createFolderResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(TtmlNode.TAG_METADATA);
            FolderMetadata.Serializer.INSTANCE.serialize(createFolderResult.metadata, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public CreateFolderResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FolderMetadata folderMetadataDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (TtmlNode.TAG_METADATA.equals(currentName)) {
                        folderMetadataDeserialize = FolderMetadata.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (folderMetadataDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"metadata\" missing.");
                }
                CreateFolderResult createFolderResult = new CreateFolderResult(folderMetadataDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(createFolderResult, createFolderResult.toStringMultiline());
                return createFolderResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
