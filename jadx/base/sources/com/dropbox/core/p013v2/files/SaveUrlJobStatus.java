package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.p013v2.files.SaveUrlError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class SaveUrlJobStatus {
    public static final SaveUrlJobStatus IN_PROGRESS = new SaveUrlJobStatus().withTag(Tag.IN_PROGRESS);
    private Tag _tag;
    private FileMetadata completeValue;
    private SaveUrlError failedValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    private SaveUrlJobStatus() {
    }

    private SaveUrlJobStatus withTag(Tag tag) {
        SaveUrlJobStatus saveUrlJobStatus = new SaveUrlJobStatus();
        saveUrlJobStatus._tag = tag;
        return saveUrlJobStatus;
    }

    private SaveUrlJobStatus withTagAndComplete(Tag tag, FileMetadata fileMetadata) {
        SaveUrlJobStatus saveUrlJobStatus = new SaveUrlJobStatus();
        saveUrlJobStatus._tag = tag;
        saveUrlJobStatus.completeValue = fileMetadata;
        return saveUrlJobStatus;
    }

    private SaveUrlJobStatus withTagAndFailed(Tag tag, SaveUrlError saveUrlError) {
        SaveUrlJobStatus saveUrlJobStatus = new SaveUrlJobStatus();
        saveUrlJobStatus._tag = tag;
        saveUrlJobStatus.failedValue = saveUrlError;
        return saveUrlJobStatus;
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

    public static SaveUrlJobStatus complete(FileMetadata fileMetadata) {
        if (fileMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SaveUrlJobStatus().withTagAndComplete(Tag.COMPLETE, fileMetadata);
    }

    public FileMetadata getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isFailed() {
        return this._tag == Tag.FAILED;
    }

    public static SaveUrlJobStatus failed(SaveUrlError saveUrlError) {
        if (saveUrlError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SaveUrlJobStatus().withTagAndFailed(Tag.FAILED, saveUrlError);
    }

    public SaveUrlError getFailedValue() {
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
        if (obj == null || !(obj instanceof SaveUrlJobStatus)) {
            return false;
        }
        SaveUrlJobStatus saveUrlJobStatus = (SaveUrlJobStatus) obj;
        if (this._tag != saveUrlJobStatus._tag) {
            return false;
        }
        int i = C41961.$SwitchMap$com$dropbox$core$v2$files$SaveUrlJobStatus$Tag[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                SaveUrlError saveUrlError = this.failedValue;
                SaveUrlError saveUrlError2 = saveUrlJobStatus.failedValue;
                return saveUrlError == saveUrlError2 || saveUrlError.equals(saveUrlError2);
            }
            FileMetadata fileMetadata = this.completeValue;
            FileMetadata fileMetadata2 = saveUrlJobStatus.completeValue;
            if (fileMetadata != fileMetadata2 && !fileMetadata.equals(fileMetadata2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SaveUrlJobStatus$1 */
    static /* synthetic */ class C41961 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SaveUrlJobStatus$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SaveUrlJobStatus$Tag = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveUrlJobStatus$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveUrlJobStatus$Tag[Tag.FAILED.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<SaveUrlJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SaveUrlJobStatus saveUrlJobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C41961.$SwitchMap$com$dropbox$core$v2$files$SaveUrlJobStatus$Tag[saveUrlJobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                FileMetadata.Serializer.INSTANCE.serialize(saveUrlJobStatus.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("failed", jsonGenerator);
                jsonGenerator.writeFieldName("failed");
                SaveUrlError.Serializer.INSTANCE.serialize(saveUrlJobStatus.failedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + saveUrlJobStatus.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SaveUrlJobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SaveUrlJobStatus saveUrlJobStatusFailed;
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
                saveUrlJobStatusFailed = SaveUrlJobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                saveUrlJobStatusFailed = SaveUrlJobStatus.complete(FileMetadata.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failed".equals(tag)) {
                expectField("failed", jsonParser);
                saveUrlJobStatusFailed = SaveUrlJobStatus.failed(SaveUrlError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return saveUrlJobStatusFailed;
        }
    }
}
