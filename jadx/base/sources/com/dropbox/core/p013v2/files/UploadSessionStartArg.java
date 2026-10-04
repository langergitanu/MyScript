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
class UploadSessionStartArg {
    protected final boolean close;

    @Nullable
    protected final String contentHash;

    @Nullable
    protected final UploadSessionType sessionType;

    public UploadSessionStartArg(boolean z, @Nullable UploadSessionType uploadSessionType, @Nullable String str) {
        this.close = z;
        this.sessionType = uploadSessionType;
        if (str != null) {
            if (str.length() < 64) {
                throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
            }
            if (str.length() > 64) {
                throw new IllegalArgumentException("String 'contentHash' is longer than 64");
            }
        }
        this.contentHash = str;
    }

    public UploadSessionStartArg() {
        this(false, null, null);
    }

    public boolean getClose() {
        return this.close;
    }

    @Nullable
    public UploadSessionType getSessionType() {
        return this.sessionType;
    }

    @Nullable
    public String getContentHash() {
        return this.contentHash;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected boolean close = false;
        protected UploadSessionType sessionType = null;
        protected String contentHash = null;

        protected Builder() {
        }

        public Builder withClose(Boolean bool) {
            if (bool != null) {
                this.close = bool.booleanValue();
                return this;
            }
            this.close = false;
            return this;
        }

        public Builder withSessionType(UploadSessionType uploadSessionType) {
            this.sessionType = uploadSessionType;
            return this;
        }

        public Builder withContentHash(String str) {
            if (str != null) {
                if (str.length() < 64) {
                    throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
                }
                if (str.length() > 64) {
                    throw new IllegalArgumentException("String 'contentHash' is longer than 64");
                }
            }
            this.contentHash = str;
            return this;
        }

        public UploadSessionStartArg build() {
            return new UploadSessionStartArg(this.close, this.sessionType, this.contentHash);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.close), this.sessionType, this.contentHash});
    }

    public boolean equals(Object obj) {
        UploadSessionType uploadSessionType;
        UploadSessionType uploadSessionType2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            UploadSessionStartArg uploadSessionStartArg = (UploadSessionStartArg) obj;
            if (this.close == uploadSessionStartArg.close && (((uploadSessionType = this.sessionType) == (uploadSessionType2 = uploadSessionStartArg.sessionType) || (uploadSessionType != null && uploadSessionType.equals(uploadSessionType2))) && ((str = this.contentHash) == (str2 = uploadSessionStartArg.contentHash) || (str != null && str.equals(str2))))) {
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

    static class Serializer extends StructSerializer<UploadSessionStartArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UploadSessionStartArg uploadSessionStartArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("close");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(uploadSessionStartArg.close), jsonGenerator);
            if (uploadSessionStartArg.sessionType != null) {
                jsonGenerator.writeFieldName("session_type");
                StoneSerializers.nullable(UploadSessionType.Serializer.INSTANCE).serialize(uploadSessionStartArg.sessionType, jsonGenerator);
            }
            if (uploadSessionStartArg.contentHash != null) {
                jsonGenerator.writeFieldName("content_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(uploadSessionStartArg.contentHash, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UploadSessionStartArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UploadSessionType uploadSessionType = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("close".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("session_type".equals(currentName)) {
                        uploadSessionType = (UploadSessionType) StoneSerializers.nullable(UploadSessionType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("content_hash".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                UploadSessionStartArg uploadSessionStartArg = new UploadSessionStartArg(boolDeserialize.booleanValue(), uploadSessionType, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(uploadSessionStartArg, uploadSessionStartArg.toStringMultiline());
                return uploadSessionStartArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
