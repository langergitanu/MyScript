package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.FileLock;
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
public class LockConflictError {

    @Nonnull
    protected final FileLock lock;

    public LockConflictError(@Nonnull FileLock fileLock) {
        if (fileLock == null) {
            throw new IllegalArgumentException("Required value for 'lock' is null");
        }
        this.lock = fileLock;
    }

    @Nonnull
    public FileLock getLock() {
        return this.lock;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.lock});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileLock fileLock = this.lock;
        FileLock fileLock2 = ((LockConflictError) obj).lock;
        return fileLock == fileLock2 || fileLock.equals(fileLock2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LockConflictError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LockConflictError lockConflictError, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("lock");
            FileLock.Serializer.INSTANCE.serialize(lockConflictError.lock, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LockConflictError deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileLock fileLockDeserialize = null;
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
                    if ("lock".equals(currentName)) {
                        fileLockDeserialize = FileLock.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileLockDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"lock\" missing.");
                }
                LockConflictError lockConflictError = new LockConflictError(fileLockDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(lockConflictError, lockConflictError.toStringMultiline());
                return lockConflictError;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
