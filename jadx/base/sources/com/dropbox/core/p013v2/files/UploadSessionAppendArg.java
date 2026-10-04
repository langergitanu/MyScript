package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.UploadSessionCursor;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class UploadSessionAppendArg {
    protected final boolean close;

    @Nullable
    protected final String contentHash;

    @Nonnull
    protected final UploadSessionCursor cursor;

    public UploadSessionAppendArg(@Nonnull UploadSessionCursor uploadSessionCursor, boolean z, @Nullable String str) {
        if (uploadSessionCursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = uploadSessionCursor;
        this.close = z;
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

    public UploadSessionAppendArg(@Nonnull UploadSessionCursor uploadSessionCursor) {
        this(uploadSessionCursor, false, null);
    }

    @Nonnull
    public UploadSessionCursor getCursor() {
        return this.cursor;
    }

    public boolean getClose() {
        return this.close;
    }

    @Nullable
    public String getContentHash() {
        return this.contentHash;
    }

    public static Builder newBuilder(UploadSessionCursor uploadSessionCursor) {
        return new Builder(uploadSessionCursor);
    }

    public static class Builder {
        protected boolean close;
        protected String contentHash;
        protected final UploadSessionCursor cursor;

        protected Builder(UploadSessionCursor uploadSessionCursor) {
            if (uploadSessionCursor == null) {
                throw new IllegalArgumentException("Required value for 'cursor' is null");
            }
            this.cursor = uploadSessionCursor;
            this.close = false;
            this.contentHash = null;
        }

        public Builder withClose(Boolean bool) {
            if (bool != null) {
                this.close = bool.booleanValue();
                return this;
            }
            this.close = false;
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

        public UploadSessionAppendArg build() {
            return new UploadSessionAppendArg(this.cursor, this.close, this.contentHash);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.cursor, Boolean.valueOf(this.close), this.contentHash});
    }

    public boolean equals(Object obj) {
        UploadSessionAppendArg uploadSessionAppendArg;
        UploadSessionCursor uploadSessionCursor;
        UploadSessionCursor uploadSessionCursor2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((uploadSessionCursor = this.cursor) == (uploadSessionCursor2 = (uploadSessionAppendArg = (UploadSessionAppendArg) obj).cursor) || uploadSessionCursor.equals(uploadSessionCursor2)) && this.close == uploadSessionAppendArg.close && ((str = this.contentHash) == (str2 = uploadSessionAppendArg.contentHash) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UploadSessionAppendArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UploadSessionAppendArg uploadSessionAppendArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("cursor");
            UploadSessionCursor.Serializer.INSTANCE.serialize(uploadSessionAppendArg.cursor, jsonGenerator);
            jsonGenerator.writeFieldName("close");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(uploadSessionAppendArg.close), jsonGenerator);
            if (uploadSessionAppendArg.contentHash != null) {
                jsonGenerator.writeFieldName("content_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(uploadSessionAppendArg.contentHash, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UploadSessionAppendArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UploadSessionCursor uploadSessionCursorDeserialize = null;
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
                    if ("cursor".equals(currentName)) {
                        uploadSessionCursorDeserialize = UploadSessionCursor.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("close".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("content_hash".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (uploadSessionCursorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"cursor\" missing.");
                }
                UploadSessionAppendArg uploadSessionAppendArg = new UploadSessionAppendArg(uploadSessionCursorDeserialize, boolDeserialize.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(uploadSessionAppendArg, uploadSessionAppendArg.toStringMultiline());
                return uploadSessionAppendArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
