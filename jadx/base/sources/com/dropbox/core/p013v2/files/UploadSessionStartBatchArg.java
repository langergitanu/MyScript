package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.UploadSessionType;
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
class UploadSessionStartBatchArg {
    protected final long numSessions;

    @Nullable
    protected final UploadSessionType sessionType;

    public UploadSessionStartBatchArg(long j, @Nullable UploadSessionType uploadSessionType) {
        this.sessionType = uploadSessionType;
        if (j < 1) {
            throw new IllegalArgumentException("Number 'numSessions' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'numSessions' is larger than 1000L");
        }
        this.numSessions = j;
    }

    public UploadSessionStartBatchArg(long j) {
        this(j, null);
    }

    public long getNumSessions() {
        return this.numSessions;
    }

    @Nullable
    public UploadSessionType getSessionType() {
        return this.sessionType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sessionType, Long.valueOf(this.numSessions)});
    }

    public boolean equals(Object obj) {
        UploadSessionType uploadSessionType;
        UploadSessionType uploadSessionType2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            UploadSessionStartBatchArg uploadSessionStartBatchArg = (UploadSessionStartBatchArg) obj;
            if (this.numSessions == uploadSessionStartBatchArg.numSessions && ((uploadSessionType = this.sessionType) == (uploadSessionType2 = uploadSessionStartBatchArg.sessionType) || (uploadSessionType != null && uploadSessionType.equals(uploadSessionType2)))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UploadSessionStartBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UploadSessionStartBatchArg uploadSessionStartBatchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("num_sessions");
            StoneSerializers.uInt64().serialize(Long.valueOf(uploadSessionStartBatchArg.numSessions), jsonGenerator);
            if (uploadSessionStartBatchArg.sessionType != null) {
                jsonGenerator.writeFieldName("session_type");
                StoneSerializers.nullable(UploadSessionType.Serializer.INSTANCE).serialize(uploadSessionStartBatchArg.sessionType, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UploadSessionStartBatchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                UploadSessionType uploadSessionType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("num_sessions".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("session_type".equals(currentName)) {
                        uploadSessionType = (UploadSessionType) StoneSerializers.nullable(UploadSessionType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"num_sessions\" missing.");
                }
                UploadSessionStartBatchArg uploadSessionStartBatchArg = new UploadSessionStartBatchArg(lDeserialize.longValue(), uploadSessionType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(uploadSessionStartBatchArg, uploadSessionStartBatchArg.toStringMultiline());
                return uploadSessionStartBatchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
