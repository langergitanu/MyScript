package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.WriteError;
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
public class UploadWriteFailed {

    @Nonnull
    protected final WriteError reason;

    @Nonnull
    protected final String uploadSessionId;

    public UploadWriteFailed(@Nonnull WriteError writeError, @Nonnull String str) {
        if (writeError == null) {
            throw new IllegalArgumentException("Required value for 'reason' is null");
        }
        this.reason = writeError;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'uploadSessionId' is null");
        }
        this.uploadSessionId = str;
    }

    @Nonnull
    public WriteError getReason() {
        return this.reason;
    }

    @Nonnull
    public String getUploadSessionId() {
        return this.uploadSessionId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.reason, this.uploadSessionId});
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
        UploadWriteFailed uploadWriteFailed = (UploadWriteFailed) obj;
        WriteError writeError = this.reason;
        WriteError writeError2 = uploadWriteFailed.reason;
        return (writeError == writeError2 || writeError.equals(writeError2)) && ((str = this.uploadSessionId) == (str2 = uploadWriteFailed.uploadSessionId) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UploadWriteFailed> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UploadWriteFailed uploadWriteFailed, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("reason");
            WriteError.Serializer.INSTANCE.serialize(uploadWriteFailed.reason, jsonGenerator);
            jsonGenerator.writeFieldName("upload_session_id");
            StoneSerializers.string().serialize(uploadWriteFailed.uploadSessionId, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UploadWriteFailed deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            WriteError writeErrorDeserialize = null;
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
                    if ("reason".equals(currentName)) {
                        writeErrorDeserialize = WriteError.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("upload_session_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (writeErrorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"reason\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"upload_session_id\" missing.");
                }
                UploadWriteFailed uploadWriteFailed = new UploadWriteFailed(writeErrorDeserialize, strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(uploadWriteFailed, uploadWriteFailed.toStringMultiline());
                return uploadWriteFailed;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
