package com.dropbox.core.p013v2.sharing;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.sharing.SharedLinkMetadata;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class SharedLinkAlreadyExistsMetadata {
    public static final SharedLinkAlreadyExistsMetadata OTHER = new SharedLinkAlreadyExistsMetadata().withTag(Tag.OTHER);
    private Tag _tag;
    private SharedLinkMetadata metadataValue;

    public enum Tag {
        METADATA,
        OTHER
    }

    private SharedLinkAlreadyExistsMetadata() {
    }

    private SharedLinkAlreadyExistsMetadata withTag(Tag tag) {
        SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsMetadata = new SharedLinkAlreadyExistsMetadata();
        sharedLinkAlreadyExistsMetadata._tag = tag;
        return sharedLinkAlreadyExistsMetadata;
    }

    private SharedLinkAlreadyExistsMetadata withTagAndMetadata(Tag tag, SharedLinkMetadata sharedLinkMetadata) {
        SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsMetadata = new SharedLinkAlreadyExistsMetadata();
        sharedLinkAlreadyExistsMetadata._tag = tag;
        sharedLinkAlreadyExistsMetadata.metadataValue = sharedLinkMetadata;
        return sharedLinkAlreadyExistsMetadata;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isMetadata() {
        return this._tag == Tag.METADATA;
    }

    public static SharedLinkAlreadyExistsMetadata metadata(SharedLinkMetadata sharedLinkMetadata) {
        if (sharedLinkMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharedLinkAlreadyExistsMetadata().withTagAndMetadata(Tag.METADATA, sharedLinkMetadata);
    }

    public SharedLinkMetadata getMetadataValue() {
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
        if (obj == null || !(obj instanceof SharedLinkAlreadyExistsMetadata)) {
            return false;
        }
        SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsMetadata = (SharedLinkAlreadyExistsMetadata) obj;
        if (this._tag != sharedLinkAlreadyExistsMetadata._tag) {
            return false;
        }
        int i = C43041.f736x7c92f224[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        SharedLinkMetadata sharedLinkMetadata = this.metadataValue;
        SharedLinkMetadata sharedLinkMetadata2 = sharedLinkAlreadyExistsMetadata.metadataValue;
        return sharedLinkMetadata == sharedLinkMetadata2 || sharedLinkMetadata.equals(sharedLinkMetadata2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SharedLinkAlreadyExistsMetadata$1 */
    static /* synthetic */ class C43041 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkAlreadyExistsMetadata$Tag */
        static final /* synthetic */ int[] f736x7c92f224;

        static {
            int[] iArr = new int[Tag.values().length];
            f736x7c92f224 = iArr;
            try {
                iArr[Tag.METADATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f736x7c92f224[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<SharedLinkAlreadyExistsMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsMetadata, JsonGenerator jsonGenerator) throws IOException {
            if (C43041.f736x7c92f224[sharedLinkAlreadyExistsMetadata.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag(TtmlNode.TAG_METADATA, jsonGenerator);
                jsonGenerator.writeFieldName(TtmlNode.TAG_METADATA);
                SharedLinkMetadata.Serializer.INSTANCE.serialize(sharedLinkAlreadyExistsMetadata.metadataValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedLinkAlreadyExistsMetadata deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsMetadataMetadata;
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
                sharedLinkAlreadyExistsMetadataMetadata = SharedLinkAlreadyExistsMetadata.metadata(SharedLinkMetadata.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                sharedLinkAlreadyExistsMetadataMetadata = SharedLinkAlreadyExistsMetadata.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedLinkAlreadyExistsMetadataMetadata;
        }
    }
}
