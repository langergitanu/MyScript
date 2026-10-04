package com.dropbox.core.p013v2.files;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.files.FileLock;
import com.dropbox.core.p013v2.files.Metadata;
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
public class LockFileResult {

    @Nonnull
    protected final FileLock lock;

    @Nonnull
    protected final Metadata metadata;

    public LockFileResult(@Nonnull Metadata metadata, @Nonnull FileLock fileLock) {
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
        if (fileLock == null) {
            throw new IllegalArgumentException("Required value for 'lock' is null");
        }
        this.lock = fileLock;
    }

    @Nonnull
    public Metadata getMetadata() {
        return this.metadata;
    }

    @Nonnull
    public FileLock getLock() {
        return this.lock;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.metadata, this.lock});
    }

    public boolean equals(Object obj) {
        FileLock fileLock;
        FileLock fileLock2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LockFileResult lockFileResult = (LockFileResult) obj;
        Metadata metadata = this.metadata;
        Metadata metadata2 = lockFileResult.metadata;
        return (metadata == metadata2 || metadata.equals(metadata2)) && ((fileLock = this.lock) == (fileLock2 = lockFileResult.lock) || fileLock.equals(fileLock2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LockFileResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LockFileResult lockFileResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(TtmlNode.TAG_METADATA);
            Metadata.Serializer.INSTANCE.serialize(lockFileResult.metadata, jsonGenerator);
            jsonGenerator.writeFieldName("lock");
            FileLock.Serializer.INSTANCE.serialize(lockFileResult.lock, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LockFileResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Metadata metadataDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileLock fileLockDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (TtmlNode.TAG_METADATA.equals(currentName)) {
                        metadataDeserialize = Metadata.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("lock".equals(currentName)) {
                        fileLockDeserialize = FileLock.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (metadataDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"metadata\" missing.");
                }
                if (fileLockDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"lock\" missing.");
                }
                LockFileResult lockFileResult = new LockFileResult(metadataDeserialize, fileLockDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(lockFileResult, lockFileResult.toStringMultiline());
                return lockFileResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
