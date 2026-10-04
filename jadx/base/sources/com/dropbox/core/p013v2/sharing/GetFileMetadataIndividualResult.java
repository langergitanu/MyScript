package com.dropbox.core.p013v2.sharing;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.sharing.SharedFileMetadata;
import com.dropbox.core.p013v2.sharing.SharingFileAccessError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class GetFileMetadataIndividualResult {
    public static final GetFileMetadataIndividualResult OTHER = new GetFileMetadataIndividualResult().withTag(Tag.OTHER);
    private Tag _tag;
    private SharingFileAccessError accessErrorValue;
    private SharedFileMetadata metadataValue;

    public enum Tag {
        METADATA,
        ACCESS_ERROR,
        OTHER
    }

    private GetFileMetadataIndividualResult() {
    }

    private GetFileMetadataIndividualResult withTag(Tag tag) {
        GetFileMetadataIndividualResult getFileMetadataIndividualResult = new GetFileMetadataIndividualResult();
        getFileMetadataIndividualResult._tag = tag;
        return getFileMetadataIndividualResult;
    }

    private GetFileMetadataIndividualResult withTagAndMetadata(Tag tag, SharedFileMetadata sharedFileMetadata) {
        GetFileMetadataIndividualResult getFileMetadataIndividualResult = new GetFileMetadataIndividualResult();
        getFileMetadataIndividualResult._tag = tag;
        getFileMetadataIndividualResult.metadataValue = sharedFileMetadata;
        return getFileMetadataIndividualResult;
    }

    private GetFileMetadataIndividualResult withTagAndAccessError(Tag tag, SharingFileAccessError sharingFileAccessError) {
        GetFileMetadataIndividualResult getFileMetadataIndividualResult = new GetFileMetadataIndividualResult();
        getFileMetadataIndividualResult._tag = tag;
        getFileMetadataIndividualResult.accessErrorValue = sharingFileAccessError;
        return getFileMetadataIndividualResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isMetadata() {
        return this._tag == Tag.METADATA;
    }

    public static GetFileMetadataIndividualResult metadata(SharedFileMetadata sharedFileMetadata) {
        if (sharedFileMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetFileMetadataIndividualResult().withTagAndMetadata(Tag.METADATA, sharedFileMetadata);
    }

    public SharedFileMetadata getMetadataValue() {
        if (this._tag != Tag.METADATA) {
            throw new IllegalStateException("Invalid tag: required Tag.METADATA, but was Tag." + this._tag.name());
        }
        return this.metadataValue;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static GetFileMetadataIndividualResult accessError(SharingFileAccessError sharingFileAccessError) {
        if (sharingFileAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetFileMetadataIndividualResult().withTagAndAccessError(Tag.ACCESS_ERROR, sharingFileAccessError);
    }

    public SharingFileAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.metadataValue, this.accessErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GetFileMetadataIndividualResult)) {
            return false;
        }
        GetFileMetadataIndividualResult getFileMetadataIndividualResult = (GetFileMetadataIndividualResult) obj;
        if (this._tag != getFileMetadataIndividualResult._tag) {
            return false;
        }
        int i = C42611.f720xcb65c4b7[this._tag.ordinal()];
        if (i == 1) {
            SharedFileMetadata sharedFileMetadata = this.metadataValue;
            SharedFileMetadata sharedFileMetadata2 = getFileMetadataIndividualResult.metadataValue;
            return sharedFileMetadata == sharedFileMetadata2 || sharedFileMetadata.equals(sharedFileMetadata2);
        }
        if (i != 2) {
            return i == 3;
        }
        SharingFileAccessError sharingFileAccessError = this.accessErrorValue;
        SharingFileAccessError sharingFileAccessError2 = getFileMetadataIndividualResult.accessErrorValue;
        return sharingFileAccessError == sharingFileAccessError2 || sharingFileAccessError.equals(sharingFileAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.GetFileMetadataIndividualResult$1 */
    static /* synthetic */ class C42611 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$GetFileMetadataIndividualResult$Tag */
        static final /* synthetic */ int[] f720xcb65c4b7;

        static {
            int[] iArr = new int[Tag.values().length];
            f720xcb65c4b7 = iArr;
            try {
                iArr[Tag.METADATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f720xcb65c4b7[Tag.ACCESS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f720xcb65c4b7[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<GetFileMetadataIndividualResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetFileMetadataIndividualResult getFileMetadataIndividualResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C42611.f720xcb65c4b7[getFileMetadataIndividualResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(TtmlNode.TAG_METADATA, jsonGenerator);
                SharedFileMetadata.Serializer.INSTANCE.serialize(getFileMetadataIndividualResult.metadataValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                SharingFileAccessError.Serializer.INSTANCE.serialize(getFileMetadataIndividualResult.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetFileMetadataIndividualResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetFileMetadataIndividualResult getFileMetadataIndividualResultAccessError;
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
                getFileMetadataIndividualResultAccessError = GetFileMetadataIndividualResult.metadata(SharedFileMetadata.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                getFileMetadataIndividualResultAccessError = GetFileMetadataIndividualResult.accessError(SharingFileAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                getFileMetadataIndividualResultAccessError = GetFileMetadataIndividualResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getFileMetadataIndividualResultAccessError;
        }
    }
}
