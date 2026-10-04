package com.dropbox.core.p013v2.files;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.files.Metadata;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class MetadataV2 {
    public static final MetadataV2 OTHER = new MetadataV2().withTag(Tag.OTHER);
    private Tag _tag;
    private Metadata metadataValue;

    public enum Tag {
        METADATA,
        OTHER
    }

    private MetadataV2() {
    }

    private MetadataV2 withTag(Tag tag) {
        MetadataV2 metadataV2 = new MetadataV2();
        metadataV2._tag = tag;
        return metadataV2;
    }

    private MetadataV2 withTagAndMetadata(Tag tag, Metadata metadata) {
        MetadataV2 metadataV2 = new MetadataV2();
        metadataV2._tag = tag;
        metadataV2.metadataValue = metadata;
        return metadataV2;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isMetadata() {
        return this._tag == Tag.METADATA;
    }

    public static MetadataV2 metadata(Metadata metadata) {
        if (metadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MetadataV2().withTagAndMetadata(Tag.METADATA, metadata);
    }

    public Metadata getMetadataValue() {
        if (this._tag != Tag.METADATA) {
            throw new IllegalStateException("Invalid tag: required Tag.METADATA, but was Tag." + this._tag.name());
        }
        return this.metadataValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.metadataValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MetadataV2)) {
            return false;
        }
        MetadataV2 metadataV2 = (MetadataV2) obj;
        if (this._tag != metadataV2._tag) {
            return false;
        }
        int i = C41761.$SwitchMap$com$dropbox$core$v2$files$MetadataV2$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        Metadata metadata = this.metadataValue;
        Metadata metadata2 = metadataV2.metadataValue;
        return metadata == metadata2 || metadata.equals(metadata2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.MetadataV2$1 */
    static /* synthetic */ class C41761 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$MetadataV2$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$MetadataV2$Tag = iArr;
            try {
                iArr[Tag.METADATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$MetadataV2$Tag[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<MetadataV2> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MetadataV2 metadataV2, JsonGenerator jsonGenerator) throws IOException {
            if (C41761.$SwitchMap$com$dropbox$core$v2$files$MetadataV2$Tag[metadataV2.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag(TtmlNode.TAG_METADATA, jsonGenerator);
                jsonGenerator.writeFieldName(TtmlNode.TAG_METADATA);
                Metadata.Serializer.INSTANCE.serialize(metadataV2.metadataValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MetadataV2 deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MetadataV2 metadataV2Metadata;
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
            if (TtmlNode.TAG_METADATA.equals(tag)) {
                expectField(TtmlNode.TAG_METADATA, jsonParser);
                metadataV2Metadata = MetadataV2.metadata(Metadata.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                metadataV2Metadata = MetadataV2.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return metadataV2Metadata;
        }
    }
}
