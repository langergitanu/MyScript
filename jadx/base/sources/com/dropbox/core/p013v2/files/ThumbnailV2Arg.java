package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.PathOrLink;
import com.dropbox.core.p013v2.files.ThumbnailFormat;
import com.dropbox.core.p013v2.files.ThumbnailMode;
import com.dropbox.core.p013v2.files.ThumbnailSize;
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
class ThumbnailV2Arg {

    @Nonnull
    protected final ThumbnailFormat format;

    @Nonnull
    protected final ThumbnailMode mode;

    @Nonnull
    protected final PathOrLink resource;

    @Nonnull
    protected final ThumbnailSize size;

    public ThumbnailV2Arg(@Nonnull PathOrLink pathOrLink, @Nonnull ThumbnailFormat thumbnailFormat, @Nonnull ThumbnailSize thumbnailSize, @Nonnull ThumbnailMode thumbnailMode) {
        if (pathOrLink == null) {
            throw new IllegalArgumentException("Required value for 'resource' is null");
        }
        this.resource = pathOrLink;
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

    public ThumbnailV2Arg(@Nonnull PathOrLink pathOrLink) {
        this(pathOrLink, ThumbnailFormat.JPEG, ThumbnailSize.W64H64, ThumbnailMode.STRICT);
    }

    @Nonnull
    public PathOrLink getResource() {
        return this.resource;
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

    public static Builder newBuilder(PathOrLink pathOrLink) {
        return new Builder(pathOrLink);
    }

    public static class Builder {
        protected ThumbnailFormat format;
        protected ThumbnailMode mode;
        protected final PathOrLink resource;
        protected ThumbnailSize size;

        protected Builder(PathOrLink pathOrLink) {
            if (pathOrLink == null) {
                throw new IllegalArgumentException("Required value for 'resource' is null");
            }
            this.resource = pathOrLink;
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

        public ThumbnailV2Arg build() {
            return new ThumbnailV2Arg(this.resource, this.format, this.size, this.mode);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.resource, this.format, this.size, this.mode});
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
        ThumbnailV2Arg thumbnailV2Arg = (ThumbnailV2Arg) obj;
        PathOrLink pathOrLink = this.resource;
        PathOrLink pathOrLink2 = thumbnailV2Arg.resource;
        return (pathOrLink == pathOrLink2 || pathOrLink.equals(pathOrLink2)) && ((thumbnailFormat = this.format) == (thumbnailFormat2 = thumbnailV2Arg.format) || thumbnailFormat.equals(thumbnailFormat2)) && (((thumbnailSize = this.size) == (thumbnailSize2 = thumbnailV2Arg.size) || thumbnailSize.equals(thumbnailSize2)) && ((thumbnailMode = this.mode) == (thumbnailMode2 = thumbnailV2Arg.mode) || thumbnailMode.equals(thumbnailMode2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ThumbnailV2Arg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ThumbnailV2Arg thumbnailV2Arg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("resource");
            PathOrLink.Serializer.INSTANCE.serialize(thumbnailV2Arg.resource, jsonGenerator);
            jsonGenerator.writeFieldName("format");
            ThumbnailFormat.Serializer.INSTANCE.serialize(thumbnailV2Arg.format, jsonGenerator);
            jsonGenerator.writeFieldName("size");
            ThumbnailSize.Serializer.INSTANCE.serialize(thumbnailV2Arg.size, jsonGenerator);
            jsonGenerator.writeFieldName("mode");
            ThumbnailMode.Serializer.INSTANCE.serialize(thumbnailV2Arg.mode, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ThumbnailV2Arg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PathOrLink pathOrLinkDeserialize = null;
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
                    if ("resource".equals(currentName)) {
                        pathOrLinkDeserialize = PathOrLink.Serializer.INSTANCE.deserialize(jsonParser);
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
                if (pathOrLinkDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"resource\" missing.");
                }
                ThumbnailV2Arg thumbnailV2Arg = new ThumbnailV2Arg(pathOrLinkDeserialize, thumbnailFormatDeserialize, thumbnailSizeDeserialize, thumbnailModeDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(thumbnailV2Arg, thumbnailV2Arg.toStringMultiline());
                return thumbnailV2Arg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
