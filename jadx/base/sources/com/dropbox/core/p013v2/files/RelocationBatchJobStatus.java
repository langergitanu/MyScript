package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.RelocationBatchError;
import com.dropbox.core.p013v2.files.RelocationBatchResult;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RelocationBatchJobStatus {
    public static final RelocationBatchJobStatus IN_PROGRESS = new RelocationBatchJobStatus().withTag(Tag.IN_PROGRESS);
    private Tag _tag;
    private RelocationBatchResult completeValue;
    private RelocationBatchError failedValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    private RelocationBatchJobStatus() {
    }

    private RelocationBatchJobStatus withTag(Tag tag) {
        RelocationBatchJobStatus relocationBatchJobStatus = new RelocationBatchJobStatus();
        relocationBatchJobStatus._tag = tag;
        return relocationBatchJobStatus;
    }

    private RelocationBatchJobStatus withTagAndComplete(Tag tag, RelocationBatchResult relocationBatchResult) {
        RelocationBatchJobStatus relocationBatchJobStatus = new RelocationBatchJobStatus();
        relocationBatchJobStatus._tag = tag;
        relocationBatchJobStatus.completeValue = relocationBatchResult;
        return relocationBatchJobStatus;
    }

    private RelocationBatchJobStatus withTagAndFailed(Tag tag, RelocationBatchError relocationBatchError) {
        RelocationBatchJobStatus relocationBatchJobStatus = new RelocationBatchJobStatus();
        relocationBatchJobStatus._tag = tag;
        relocationBatchJobStatus.failedValue = relocationBatchError;
        return relocationBatchJobStatus;
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

    public static RelocationBatchJobStatus complete(RelocationBatchResult relocationBatchResult) {
        if (relocationBatchResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchJobStatus().withTagAndComplete(Tag.COMPLETE, relocationBatchResult);
    }

    public RelocationBatchResult getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isFailed() {
        return this._tag == Tag.FAILED;
    }

    public static RelocationBatchJobStatus failed(RelocationBatchError relocationBatchError) {
        if (relocationBatchError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchJobStatus().withTagAndFailed(Tag.FAILED, relocationBatchError);
    }

    public RelocationBatchError getFailedValue() {
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
        if (obj == null || !(obj instanceof RelocationBatchJobStatus)) {
            return false;
        }
        RelocationBatchJobStatus relocationBatchJobStatus = (RelocationBatchJobStatus) obj;
        if (this._tag != relocationBatchJobStatus._tag) {
            return false;
        }
        int i = C41861.f705xe377306e[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                RelocationBatchError relocationBatchError = this.failedValue;
                RelocationBatchError relocationBatchError2 = relocationBatchJobStatus.failedValue;
                return relocationBatchError == relocationBatchError2 || relocationBatchError.equals(relocationBatchError2);
            }
            RelocationBatchResult relocationBatchResult = this.completeValue;
            RelocationBatchResult relocationBatchResult2 = relocationBatchJobStatus.completeValue;
            if (relocationBatchResult != relocationBatchResult2 && !relocationBatchResult.equals(relocationBatchResult2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.RelocationBatchJobStatus$1 */
    static /* synthetic */ class C41861 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$RelocationBatchJobStatus$Tag */
        static final /* synthetic */ int[] f705xe377306e;

        static {
            int[] iArr = new int[Tag.values().length];
            f705xe377306e = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f705xe377306e[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f705xe377306e[Tag.FAILED.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<RelocationBatchJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RelocationBatchJobStatus relocationBatchJobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C41861.f705xe377306e[relocationBatchJobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                RelocationBatchResult.Serializer.INSTANCE.serialize(relocationBatchJobStatus.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("failed", jsonGenerator);
                jsonGenerator.writeFieldName("failed");
                RelocationBatchError.Serializer.INSTANCE.serialize(relocationBatchJobStatus.failedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + relocationBatchJobStatus.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RelocationBatchJobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RelocationBatchJobStatus relocationBatchJobStatusFailed;
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
                relocationBatchJobStatusFailed = RelocationBatchJobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                relocationBatchJobStatusFailed = RelocationBatchJobStatus.complete(RelocationBatchResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failed".equals(tag)) {
                expectField("failed", jsonParser);
                relocationBatchJobStatusFailed = RelocationBatchJobStatus.failed(RelocationBatchError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return relocationBatchJobStatusFailed;
        }
    }
}
