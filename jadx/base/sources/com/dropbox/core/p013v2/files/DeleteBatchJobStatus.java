package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.DeleteBatchError;
import com.dropbox.core.p013v2.files.DeleteBatchResult;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class DeleteBatchJobStatus {
    public static final DeleteBatchJobStatus IN_PROGRESS = new DeleteBatchJobStatus().withTag(Tag.IN_PROGRESS);
    public static final DeleteBatchJobStatus OTHER = new DeleteBatchJobStatus().withTag(Tag.OTHER);
    private Tag _tag;
    private DeleteBatchResult completeValue;
    private DeleteBatchError failedValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE,
        FAILED,
        OTHER
    }

    private DeleteBatchJobStatus() {
    }

    private DeleteBatchJobStatus withTag(Tag tag) {
        DeleteBatchJobStatus deleteBatchJobStatus = new DeleteBatchJobStatus();
        deleteBatchJobStatus._tag = tag;
        return deleteBatchJobStatus;
    }

    private DeleteBatchJobStatus withTagAndComplete(Tag tag, DeleteBatchResult deleteBatchResult) {
        DeleteBatchJobStatus deleteBatchJobStatus = new DeleteBatchJobStatus();
        deleteBatchJobStatus._tag = tag;
        deleteBatchJobStatus.completeValue = deleteBatchResult;
        return deleteBatchJobStatus;
    }

    private DeleteBatchJobStatus withTagAndFailed(Tag tag, DeleteBatchError deleteBatchError) {
        DeleteBatchJobStatus deleteBatchJobStatus = new DeleteBatchJobStatus();
        deleteBatchJobStatus._tag = tag;
        deleteBatchJobStatus.failedValue = deleteBatchError;
        return deleteBatchJobStatus;
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

    public static DeleteBatchJobStatus complete(DeleteBatchResult deleteBatchResult) {
        if (deleteBatchResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteBatchJobStatus().withTagAndComplete(Tag.COMPLETE, deleteBatchResult);
    }

    public DeleteBatchResult getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isFailed() {
        return this._tag == Tag.FAILED;
    }

    public static DeleteBatchJobStatus failed(DeleteBatchError deleteBatchError) {
        if (deleteBatchError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteBatchJobStatus().withTagAndFailed(Tag.FAILED, deleteBatchError);
    }

    public DeleteBatchError getFailedValue() {
        if (this._tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + this._tag.name());
        }
        return this.failedValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.completeValue, this.failedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteBatchJobStatus)) {
            return false;
        }
        DeleteBatchJobStatus deleteBatchJobStatus = (DeleteBatchJobStatus) obj;
        if (this._tag != deleteBatchJobStatus._tag) {
            return false;
        }
        int i = C41511.$SwitchMap$com$dropbox$core$v2$files$DeleteBatchJobStatus$Tag[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return i == 4;
                }
                DeleteBatchError deleteBatchError = this.failedValue;
                DeleteBatchError deleteBatchError2 = deleteBatchJobStatus.failedValue;
                return deleteBatchError == deleteBatchError2 || deleteBatchError.equals(deleteBatchError2);
            }
            DeleteBatchResult deleteBatchResult = this.completeValue;
            DeleteBatchResult deleteBatchResult2 = deleteBatchJobStatus.completeValue;
            if (deleteBatchResult != deleteBatchResult2 && !deleteBatchResult.equals(deleteBatchResult2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.DeleteBatchJobStatus$1 */
    static /* synthetic */ class C41511 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$DeleteBatchJobStatus$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$DeleteBatchJobStatus$Tag = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DeleteBatchJobStatus$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DeleteBatchJobStatus$Tag[Tag.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DeleteBatchJobStatus$Tag[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<DeleteBatchJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeleteBatchJobStatus deleteBatchJobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C41511.$SwitchMap$com$dropbox$core$v2$files$DeleteBatchJobStatus$Tag[deleteBatchJobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                DeleteBatchResult.Serializer.INSTANCE.serialize(deleteBatchJobStatus.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("failed", jsonGenerator);
                jsonGenerator.writeFieldName("failed");
                DeleteBatchError.Serializer.INSTANCE.serialize(deleteBatchJobStatus.failedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeleteBatchJobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeleteBatchJobStatus deleteBatchJobStatusFailed;
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
                deleteBatchJobStatusFailed = DeleteBatchJobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                deleteBatchJobStatusFailed = DeleteBatchJobStatus.complete(DeleteBatchResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failed".equals(tag)) {
                expectField("failed", jsonParser);
                deleteBatchJobStatusFailed = DeleteBatchJobStatus.failed(DeleteBatchError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                deleteBatchJobStatusFailed = DeleteBatchJobStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deleteBatchJobStatusFailed;
        }
    }
}
