package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.ThumbnailFormat;
import com.dropbox.core.p013v2.files.ThumbnailMode;
import com.dropbox.core.p013v2.files.ThumbnailSize;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class ThumbnailArg {

    @Nonnull
    protected final ThumbnailFormat format;

    @Nonnull
    protected final ThumbnailMode mode;

    @Nonnull
    protected final String path;

    @Nonnull
    protected final ThumbnailSize size;

    public ThumbnailArg(@Nonnull String str, @Nonnull ThumbnailFormat thumbnailFormat, @Nonnull ThumbnailSize thumbnailSize, @Nonnull ThumbnailMode thumbnailMode) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (thumbnailFormat == null) {
            throw new IllegalArgumentException("Required value for 'format' is null");
        }
        this.format = thumbnailFormat;
        if (thumbnailSize == null) {
            throw new IllegalArgumentException("Required value for 'size' is null");
        }
        this.size = thumbnailSize;
        if (thumbnailMode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = thumbnailMode;
    }

    public ThumbnailArg(@Nonnull String str) {
        this(str, ThumbnailFormat.JPEG, ThumbnailSize.W64H64, ThumbnailMode.STRICT);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nonnull
    public ThumbnailFormat getFormat() {
        return this.format;
    }

    @Nonnull
    public ThumbnailSize getSize() {
        return this.size;
    }

    @Nonnull
    public ThumbnailMode getMode() {
        return this.mode;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected ThumbnailFormat format;
        protected ThumbnailMode mode;
        protected final String path;
        protected ThumbnailSize size;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", str)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = str;
            this.format = ThumbnailFormat.JPEG;
            this.size = ThumbnailSize.W64H64;
            this.mode = ThumbnailMode.STRICT;
        }

        public Builder withFormat(ThumbnailFormat thumbnailFormat) {
            if (thumbnailFormat != null) {
                this.format = thumbnailFormat;
                return this;
            }
            this.format = ThumbnailFormat.JPEG;
            return this;
        }

        public Builder withSize(ThumbnailSize thumbnailSize) {
            if (thumbnailSize != null) {
                this.size = thumbnailSize;
                return this;
            }
            this.size = ThumbnailSize.W64H64;
            return this;
        }

        public Builder withMode(ThumbnailMode thumbnailMode) {
            if (thumbnailMode != null) {
                this.mode = thumbnailMode;
                return this;
            }
            this.mode = ThumbnailMode.STRICT;
            return this;
        }

        public ThumbnailArg build() {
            return new ThumbnailArg(this.path, this.format, this.size, this.mode);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.format, this.size, this.mode});
    }

    public boolean equals(Object obj) {
        ThumbnailFormat thumbnailFormat;
        ThumbnailFormat thumbnailFormat2;
        ThumbnailSize thumbnailSize;
        ThumbnailSize thumbnailSize2;
        ThumbnailMode thumbnailMode;
        ThumbnailMode thumbnailMode2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ThumbnailArg thumbnailArg = (ThumbnailArg) obj;
        String str = this.path;
        String str2 = thumbnailArg.path;
        return (str == str2 || str.equals(str2)) && ((thumbnailFormat = this.format) == (thumbnailFormat2 = thumbnailArg.format) || thumbnailFormat.equals(thumbnailFormat2)) && (((thumbnailSize = this.size) == (thumbnailSize2 = thumbnailArg.size) || thumbnailSize.equals(thumbnailSize2)) && ((thumbnailMode = this.mode) == (thumbnailMode2 = thumbnailArg.mode) || thumbnailMode.equals(thumbnailMode2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ThumbnailArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ThumbnailArg thumbnailArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(thumbnailArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("format");
            ThumbnailFormat.Serializer.INSTANCE.serialize(thumbnailArg.format, jsonGenerator);
            jsonGenerator.writeFieldName("size");
            ThumbnailSize.Serializer.INSTANCE.serialize(thumbnailArg.size, jsonGenerator);
            jsonGenerator.writeFieldName("mode");
            ThumbnailMode.Serializer.INSTANCE.serialize(thumbnailArg.mode, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ThumbnailArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ThumbnailFormat thumbnailFormatDeserialize = ThumbnailFormat.JPEG;
                ThumbnailSize thumbnailSizeDeserialize = ThumbnailSize.W64H64;
                ThumbnailMode thumbnailModeDeserialize = ThumbnailMode.STRICT;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("format".equals(currentName)) {
                        thumbnailFormatDeserialize = ThumbnailFormat.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("size".equals(currentName)) {
                        thumbnailSizeDeserialize = ThumbnailSize.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("mode".equals(currentName)) {
                        thumbnailModeDeserialize = ThumbnailMode.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                ThumbnailArg thumbnailArg = new ThumbnailArg(strDeserialize, thumbnailFormatDeserialize, thumbnailSizeDeserialize, thumbnailModeDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(thumbnailArg, thumbnailArg.toStringMultiline());
                return thumbnailArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
