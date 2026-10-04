package com.dropbox.core.p013v2.files;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.files.MediaMetadata;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class MediaInfo {
    public static final MediaInfo PENDING = new MediaInfo().withTag(Tag.PENDING);
    private Tag _tag;
    private MediaMetadata metadataValue;

    public enum Tag {
        PENDING,
        METADATA
    }

    private MediaInfo() {
    }

    private MediaInfo withTag(Tag tag) {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo._tag = tag;
        return mediaInfo;
    }

    private MediaInfo withTagAndMetadata(Tag tag, MediaMetadata mediaMetadata) {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo._tag = tag;
        mediaInfo.metadataValue = mediaMetadata;
        return mediaInfo;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPending() {
        return this._tag == Tag.PENDING;
    }

    public boolean isMetadata() {
        return this._tag == Tag.METADATA;
    }

    public static MediaInfo metadata(MediaMetadata mediaMetadata) {
        if (mediaMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MediaInfo().withTagAndMetadata(Tag.METADATA, mediaMetadata);
    }

    public MediaMetadata getMetadataValue() {
        if (this._tag != Tag.METADATA) {
            throw new IllegalStateException("Invalid tag: required Tag.METADATA, but was Tag." + this._tag.name());
        }
        return this.metadataValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.metadataValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        if (this._tag != mediaInfo._tag) {
            return false;
        }
        int i = C41751.$SwitchMap$com$dropbox$core$v2$files$MediaInfo$Tag[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            MediaMetadata mediaMetadata = this.metadataValue;
            MediaMetadata mediaMetadata2 = mediaInfo.metadataValue;
            if (mediaMetadata != mediaMetadata2 && !mediaMetadata.equals(mediaMetadata2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.MediaInfo$1 */
    static /* synthetic */ class C41751 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$MediaInfo$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$MediaInfo$Tag = iArr;
            try {
                iArr[Tag.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$MediaInfo$Tag[Tag.METADATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<MediaInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MediaInfo mediaInfo, JsonGenerator jsonGenerator) throws IOException {
            int i = C41751.$SwitchMap$com$dropbox$core$v2$files$MediaInfo$Tag[mediaInfo.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("pending");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag(TtmlNode.TAG_METADATA, jsonGenerator);
                jsonGenerator.writeFieldName(TtmlNode.TAG_METADATA);
                MediaMetadata.Serializer.INSTANCE.serialize(mediaInfo.metadataValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + mediaInfo.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MediaInfo deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MediaInfo mediaInfoMetadata;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("pending".equals(tag)) {
                mediaInfoMetadata = MediaInfo.PENDING;
            } else if (TtmlNode.TAG_METADATA.equals(tag)) {
                expectField(TtmlNode.TAG_METADATA, jsonParser);
                mediaInfoMetadata = MediaInfo.metadata(MediaMetadata.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return mediaInfoMetadata;
        }
    }
}
