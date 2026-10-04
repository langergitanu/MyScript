package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.UploadSessionFinishBatchResult;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class UploadSessionFinishBatchJobStatus {
    public static final UploadSessionFinishBatchJobStatus IN_PROGRESS = new UploadSessionFinishBatchJobStatus().withTag(Tag.IN_PROGRESS);
    private Tag _tag;
    private UploadSessionFinishBatchResult completeValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE
    }

    private UploadSessionFinishBatchJobStatus() {
    }

    private UploadSessionFinishBatchJobStatus withTag(Tag tag) {
        UploadSessionFinishBatchJobStatus uploadSessionFinishBatchJobStatus = new UploadSessionFinishBatchJobStatus();
        uploadSessionFinishBatchJobStatus._tag = tag;
        return uploadSessionFinishBatchJobStatus;
    }

    private UploadSessionFinishBatchJobStatus withTagAndComplete(Tag tag, UploadSessionFinishBatchResult uploadSessionFinishBatchResult) {
        UploadSessionFinishBatchJobStatus uploadSessionFinishBatchJobStatus = new UploadSessionFinishBatchJobStatus();
        uploadSessionFinishBatchJobStatus._tag = tag;
        uploadSessionFinishBatchJobStatus.completeValue = uploadSessionFinishBatchResult;
        return uploadSessionFinishBatchJobStatus;
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

    public static UploadSessionFinishBatchJobStatus complete(UploadSessionFinishBatchResult uploadSessionFinishBatchResult) {
        if (uploadSessionFinishBatchResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishBatchJobStatus().withTagAndComplete(Tag.COMPLETE, uploadSessionFinishBatchResult);
    }

    public UploadSessionFinishBatchResult getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.completeValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UploadSessionFinishBatchJobStatus)) {
            return false;
        }
        UploadSessionFinishBatchJobStatus uploadSessionFinishBatchJobStatus = (UploadSessionFinishBatchJobStatus) obj;
        if (this._tag != uploadSessionFinishBatchJobStatus._tag) {
            return false;
        }
        int i = C42141.f710x420697f8[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            UploadSessionFinishBatchResult uploadSessionFinishBatchResult = this.completeValue;
            UploadSessionFinishBatchResult uploadSessionFinishBatchResult2 = uploadSessionFinishBatchJobStatus.completeValue;
            if (uploadSessionFinishBatchResult != uploadSessionFinishBatchResult2 && !uploadSessionFinishBatchResult.equals(uploadSessionFinishBatchResult2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.UploadSessionFinishBatchJobStatus$1 */
    static /* synthetic */ class C42141 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$UploadSessionFinishBatchJobStatus$Tag */
        static final /* synthetic */ int[] f710x420697f8;

        static {
            int[] iArr = new int[Tag.values().length];
            f710x420697f8 = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f710x420697f8[Tag.COMPLETE.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<UploadSessionFinishBatchJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UploadSessionFinishBatchJobStatus uploadSessionFinishBatchJobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C42141.f710x420697f8[uploadSessionFinishBatchJobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
            } else {
                if (i == 2) {
                    jsonGenerator.writeStartObject();
                    writeTag("complete", jsonGenerator);
                    UploadSessionFinishBatchResult.Serializer.INSTANCE.serialize(uploadSessionFinishBatchJobStatus.completeValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + uploadSessionFinishBatchJobStatus.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UploadSessionFinishBatchJobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UploadSessionFinishBatchJobStatus uploadSessionFinishBatchJobStatusComplete;
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
                uploadSessionFinishBatchJobStatusComplete = UploadSessionFinishBatchJobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                uploadSessionFinishBatchJobStatusComplete = UploadSessionFinishBatchJobStatus.complete(UploadSessionFinishBatchResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return uploadSessionFinishBatchJobStatusComplete;
        }
    }
}
