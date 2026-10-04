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
public class GetTemporaryLinkResult {

    @Nonnull
    protected final String link;

    @Nonnull
    protected final FileMetadata metadata;

    public GetTemporaryLinkResult(@Nonnull FileMetadata fileMetadata, @Nonnull String str) {
        if (fileMetadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = fileMetadata;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'link' is null");
        }
        this.link = str;
    }

    @Nonnull
    public FileMetadata getMetadata() {
        return this.metadata;
    }

    @Nonnull
    public String getLink() {
        return this.link;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.metadata, this.link});
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
        GetTemporaryLinkResult getTemporaryLinkResult = (GetTemporaryLinkResult) obj;
        FileMetadata fileMetadata = this.metadata;
        FileMetadata fileMetadata2 = getTemporaryLinkResult.metadata;
        return (fileMetadata == fileMetadata2 || fileMetadata.equals(fileMetadata2)) && ((str = this.link) == (str2 = getTemporaryLinkResult.link) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetTemporaryLinkResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetTemporaryLinkResult getTemporaryLinkResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(TtmlNode.TAG_METADATA);
            FileMetadata.Serializer.INSTANCE.serialize(getTemporaryLinkResult.metadata, jsonGenerator);
            jsonGenerator.writeFieldName("link");
            StoneSerializers.string().serialize(getTemporaryLinkResult.link, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetTemporaryLinkResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("link".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileMetadataDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"metadata\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"link\" missing.");
                }
                GetTemporaryLinkResult getTemporaryLinkResult = new GetTemporaryLinkResult(fileMetadataDeserialize, strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getTemporaryLinkResult, getTemporaryLinkResult.toStringMultiline());
                return getTemporaryLinkResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
