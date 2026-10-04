package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.ShareFolderError;
import com.dropbox.core.p013v2.sharing.SharedFolderMetadata;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ShareFolderJobStatus {
    public static final ShareFolderJobStatus IN_PROGRESS = new ShareFolderJobStatus().withTag(Tag.IN_PROGRESS);
    private Tag _tag;
    private SharedFolderMetadata completeValue;
    private ShareFolderError failedValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    private ShareFolderJobStatus() {
    }

    private ShareFolderJobStatus withTag(Tag tag) {
        ShareFolderJobStatus shareFolderJobStatus = new ShareFolderJobStatus();
        shareFolderJobStatus._tag = tag;
        return shareFolderJobStatus;
    }

    private ShareFolderJobStatus withTagAndComplete(Tag tag, SharedFolderMetadata sharedFolderMetadata) {
        ShareFolderJobStatus shareFolderJobStatus = new ShareFolderJobStatus();
        shareFolderJobStatus._tag = tag;
        shareFolderJobStatus.completeValue = sharedFolderMetadata;
        return shareFolderJobStatus;
    }

    private ShareFolderJobStatus withTagAndFailed(Tag tag, ShareFolderError shareFolderError) {
        ShareFolderJobStatus shareFolderJobStatus = new ShareFolderJobStatus();
        shareFolderJobStatus._tag = tag;
        shareFolderJobStatus.failedValue = shareFolderError;
        return shareFolderJobStatus;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInProgress() {
        return this._tag == Tag.IN_PROGRESS;
    }

    public boolean isComplete() {
        return this._tag == Tag.COMPLETE;
    }

    public static ShareFolderJobStatus complete(SharedFolderMetadata sharedFolderMetadata) {
        if (sharedFolderMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ShareFolderJobStatus().withTagAndComplete(Tag.COMPLETE, sharedFolderMetadata);
    }

    public SharedFolderMetadata getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isFailed() {
        return this._tag == Tag.FAILED;
    }

    public static ShareFolderJobStatus failed(ShareFolderError shareFolderError) {
        if (shareFolderError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ShareFolderJobStatus().withTagAndFailed(Tag.FAILED, shareFolderError);
    }

    public ShareFolderError getFailedValue() {
        if (this._tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + this._tag.name());
        }
        return this.failedValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.completeValue, this.failedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ShareFolderJobStatus)) {
            return false;
        }
        ShareFolderJobStatus shareFolderJobStatus = (ShareFolderJobStatus) obj;
        if (this._tag != shareFolderJobStatus._tag) {
            return false;
        }
        int i = C42981.$SwitchMap$com$dropbox$core$v2$sharing$ShareFolderJobStatus$Tag[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                ShareFolderError shareFolderError = this.failedValue;
                ShareFolderError shareFolderError2 = shareFolderJobStatus.failedValue;
                return shareFolderError == shareFolderError2 || shareFolderError.equals(shareFolderError2);
            }
            SharedFolderMetadata sharedFolderMetadata = this.completeValue;
            SharedFolderMetadata sharedFolderMetadata2 = shareFolderJobStatus.completeValue;
            if (sharedFolderMetadata != sharedFolderMetadata2 && !sharedFolderMetadata.equals(sharedFolderMetadata2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ShareFolderJobStatus$1 */
    static /* synthetic */ class C42981 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderJobStatus$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderJobStatus$Tag = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderJobStatus$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderJobStatus$Tag[Tag.FAILED.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<ShareFolderJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ShareFolderJobStatus shareFolderJobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C42981.$SwitchMap$com$dropbox$core$v2$sharing$ShareFolderJobStatus$Tag[shareFolderJobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                SharedFolderMetadata.Serializer.INSTANCE.serialize(shareFolderJobStatus.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("failed", jsonGenerator);
                jsonGenerator.writeFieldName("failed");
                ShareFolderError.Serializer.INSTANCE.serialize(shareFolderJobStatus.failedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + shareFolderJobStatus.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ShareFolderJobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ShareFolderJobStatus shareFolderJobStatusFailed;
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
            if ("in_progress".equals(tag)) {
                shareFolderJobStatusFailed = ShareFolderJobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                shareFolderJobStatusFailed = ShareFolderJobStatus.complete(SharedFolderMetadata.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failed".equals(tag)) {
                expectField("failed", jsonParser);
                shareFolderJobStatusFailed = ShareFolderJobStatus.failed(ShareFolderError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return shareFolderJobStatusFailed;
        }
    }
}
