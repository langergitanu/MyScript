package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.CreateFolderBatchError;
import com.dropbox.core.p013v2.files.CreateFolderBatchResult;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class CreateFolderBatchJobStatus {
    public static final CreateFolderBatchJobStatus IN_PROGRESS = new CreateFolderBatchJobStatus().withTag(Tag.IN_PROGRESS);
    public static final CreateFolderBatchJobStatus OTHER = new CreateFolderBatchJobStatus().withTag(Tag.OTHER);
    private Tag _tag;
    private CreateFolderBatchResult completeValue;
    private CreateFolderBatchError failedValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE,
        FAILED,
        OTHER
    }

    private CreateFolderBatchJobStatus() {
    }

    private CreateFolderBatchJobStatus withTag(Tag tag) {
        CreateFolderBatchJobStatus createFolderBatchJobStatus = new CreateFolderBatchJobStatus();
        createFolderBatchJobStatus._tag = tag;
        return createFolderBatchJobStatus;
    }

    private CreateFolderBatchJobStatus withTagAndComplete(Tag tag, CreateFolderBatchResult createFolderBatchResult) {
        CreateFolderBatchJobStatus createFolderBatchJobStatus = new CreateFolderBatchJobStatus();
        createFolderBatchJobStatus._tag = tag;
        createFolderBatchJobStatus.completeValue = createFolderBatchResult;
        return createFolderBatchJobStatus;
    }

    private CreateFolderBatchJobStatus withTagAndFailed(Tag tag, CreateFolderBatchError createFolderBatchError) {
        CreateFolderBatchJobStatus createFolderBatchJobStatus = new CreateFolderBatchJobStatus();
        createFolderBatchJobStatus._tag = tag;
        createFolderBatchJobStatus.failedValue = createFolderBatchError;
        return createFolderBatchJobStatus;
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

    public static CreateFolderBatchJobStatus complete(CreateFolderBatchResult createFolderBatchResult) {
        if (createFolderBatchResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateFolderBatchJobStatus().withTagAndComplete(Tag.COMPLETE, createFolderBatchResult);
    }

    public CreateFolderBatchResult getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isFailed() {
        return this._tag == Tag.FAILED;
    }

    public static CreateFolderBatchJobStatus failed(CreateFolderBatchError createFolderBatchError) {
        if (createFolderBatchError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateFolderBatchJobStatus().withTagAndFailed(Tag.FAILED, createFolderBatchError);
    }

    public CreateFolderBatchError getFailedValue() {
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
        if (obj == null || !(obj instanceof CreateFolderBatchJobStatus)) {
            return false;
        }
        CreateFolderBatchJobStatus createFolderBatchJobStatus = (CreateFolderBatchJobStatus) obj;
        if (this._tag != createFolderBatchJobStatus._tag) {
            return false;
        }
        int i = C41451.f693x90bd22d0[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return i == 4;
                }
                CreateFolderBatchError createFolderBatchError = this.failedValue;
                CreateFolderBatchError createFolderBatchError2 = createFolderBatchJobStatus.failedValue;
                return createFolderBatchError == createFolderBatchError2 || createFolderBatchError.equals(createFolderBatchError2);
            }
            CreateFolderBatchResult createFolderBatchResult = this.completeValue;
            CreateFolderBatchResult createFolderBatchResult2 = createFolderBatchJobStatus.completeValue;
            if (createFolderBatchResult != createFolderBatchResult2 && !createFolderBatchResult.equals(createFolderBatchResult2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.CreateFolderBatchJobStatus$1 */
    static /* synthetic */ class C41451 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchJobStatus$Tag */
        static final /* synthetic */ int[] f693x90bd22d0;

        static {
            int[] iArr = new int[Tag.values().length];
            f693x90bd22d0 = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f693x90bd22d0[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f693x90bd22d0[Tag.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f693x90bd22d0[Tag.OTHER.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<CreateFolderBatchJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CreateFolderBatchJobStatus createFolderBatchJobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C41451.f693x90bd22d0[createFolderBatchJobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                CreateFolderBatchResult.Serializer.INSTANCE.serialize(createFolderBatchJobStatus.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("failed", jsonGenerator);
                jsonGenerator.writeFieldName("failed");
                CreateFolderBatchError.Serializer.INSTANCE.serialize(createFolderBatchJobStatus.failedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CreateFolderBatchJobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CreateFolderBatchJobStatus createFolderBatchJobStatusFailed;
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
                createFolderBatchJobStatusFailed = CreateFolderBatchJobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                createFolderBatchJobStatusFailed = CreateFolderBatchJobStatus.complete(CreateFolderBatchResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failed".equals(tag)) {
                expectField("failed", jsonParser);
                createFolderBatchJobStatusFailed = CreateFolderBatchJobStatus.failed(CreateFolderBatchError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                createFolderBatchJobStatusFailed = CreateFolderBatchJobStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return createFolderBatchJobStatusFailed;
        }
    }
}
