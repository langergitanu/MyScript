package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.FileLockContent;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class FileLock {

    @Nonnull
    protected final FileLockContent content;

    public FileLock(@Nonnull FileLockContent fileLockContent) {
        if (fileLockContent == null) {
            throw new IllegalArgumentException("Required value for 'content' is null");
        }
        this.content = fileLockContent;
    }

    @Nonnull
    public FileLockContent getContent() {
        return this.content;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.content});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileLockContent fileLockContent = this.content;
        FileLockContent fileLockContent2 = ((FileLock) obj).content;
        return fileLockContent == fileLockContent2 || fileLockContent.equals(fileLockContent2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileLock> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileLock fileLock, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.CONTENT);
            FileLockContent.Serializer.INSTANCE.serialize(fileLock.content, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileLock deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileLockContent fileLockContentDeserialize = null;
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
                    if (FirebaseAnalytics.Param.CONTENT.equals(currentName)) {
                        fileLockContentDeserialize = FileLockContent.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileLockContentDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"content\" missing.");
                }
                FileLock fileLock = new FileLock(fileLockContentDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileLock, fileLock.toStringMultiline());
                return fileLock;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
