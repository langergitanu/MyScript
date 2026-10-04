package com.dropbox.core.p013v2.files;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
public class UploadSessionCursor {
    protected final long offset;

    @Nonnull
    protected final String sessionId;

    public UploadSessionCursor(@Nonnull String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = str;
        this.offset = j;
    }

    @Nonnull
    public String getSessionId() {
        return this.sessionId;
    }

    public long getOffset() {
        return this.offset;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sessionId, Long.valueOf(this.offset)});
    }

    public boolean equals(Object obj) {
        UploadSessionCursor uploadSessionCursor;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.sessionId) == (str2 = (uploadSessionCursor = (UploadSessionCursor) obj).sessionId) || str.equals(str2)) && this.offset == uploadSessionCursor.offset;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UploadSessionCursor> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UploadSessionCursor uploadSessionCursor, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("session_id");
            StoneSerializers.string().serialize(uploadSessionCursor.sessionId, jsonGenerator);
            jsonGenerator.writeFieldName(TypedValues.CycleType.S_WAVE_OFFSET);
            StoneSerializers.uInt64().serialize(Long.valueOf(uploadSessionCursor.offset), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UploadSessionCursor deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("session_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (TypedValues.CycleType.S_WAVE_OFFSET.equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"session_id\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"offset\" missing.");
                }
                UploadSessionCursor uploadSessionCursor = new UploadSessionCursor(strDeserialize, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(uploadSessionCursor, uploadSessionCursor.toStringMultiline());
                return uploadSessionCursor;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
