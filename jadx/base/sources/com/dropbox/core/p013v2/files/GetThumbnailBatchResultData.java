package com.dropbox.core.p013v2.files;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.files.FileMetadata;
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

/* JADX INFO: loaded from: classes4.dex */
public class GetThumbnailBatchResultData {

    @Nonnull
    protected final FileMetadata metadata;

    @Nonnull
    protected final String thumbnail;

    public GetThumbnailBatchResultData(@Nonnull FileMetadata fileMetadata, @Nonnull String str) {
        if (fileMetadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = fileMetadata;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'thumbnail' is null");
        }
        this.thumbnail = str;
    }

    @Nonnull
    public FileMetadata getMetadata() {
        return this.metadata;
    }

    @Nonnull
    public String getThumbnail() {
        return this.thumbnail;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.metadata, this.thumbnail});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GetThumbnailBatchResultData getThumbnailBatchResultData = (GetThumbnailBatchResultData) obj;
        FileMetadata fileMetadata = this.metadata;
        FileMetadata fileMetadata2 = getThumbnailBatchResultData.metadata;
        return (fileMetadata == fileMetadata2 || fileMetadata.equals(fileMetadata2)) && ((str = this.thumbnail) == (str2 = getThumbnailBatchResultData.thumbnail) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetThumbnailBatchResultData> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetThumbnailBatchResultData getThumbnailBatchResultData, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(TtmlNode.TAG_METADATA);
            FileMetadata.Serializer.INSTANCE.serialize(getThumbnailBatchResultData.metadata, jsonGenerator);
            jsonGenerator.writeFieldName("thumbnail");
            StoneSerializers.string().serialize(getThumbnailBatchResultData.thumbnail, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetThumbnailBatchResultData deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileMetadata fileMetadataDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (TtmlNode.TAG_METADATA.equals(currentName)) {
                        fileMetadataDeserialize = FileMetadata.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("thumbnail".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileMetadataDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"metadata\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"thumbnail\" missing.");
                }
                GetThumbnailBatchResultData getThumbnailBatchResultData = new GetThumbnailBatchResultData(fileMetadataDeserialize, strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getThumbnailBatchResultData, getThumbnailBatchResultData.toStringMultiline());
                return getThumbnailBatchResultData;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
