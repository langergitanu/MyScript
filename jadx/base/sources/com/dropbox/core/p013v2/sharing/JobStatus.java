package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.JobError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class JobStatus {
    private Tag _tag;
    private JobError failedValue;
    public static final JobStatus IN_PROGRESS = new JobStatus().withTag(Tag.IN_PROGRESS);
    public static final JobStatus COMPLETE = new JobStatus().withTag(Tag.COMPLETE);

    public enum Tag {
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    private JobStatus() {
    }

    private JobStatus withTag(Tag tag) {
        JobStatus jobStatus = new JobStatus();
        jobStatus._tag = tag;
        return jobStatus;
    }

    private JobStatus withTagAndFailed(Tag tag, JobError jobError) {
        JobStatus jobStatus = new JobStatus();
        jobStatus._tag = tag;
        jobStatus.failedValue = jobError;
        return jobStatus;
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

    public boolean isFailed() {
        return this._tag == Tag.FAILED;
    }

    public static JobStatus failed(JobError jobError) {
        if (jobError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new JobStatus().withTagAndFailed(Tag.FAILED, jobError);
    }

    public JobError getFailedValue() {
        if (this._tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + this._tag.name());
        }
        return this.failedValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.failedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JobStatus)) {
            return false;
        }
        JobStatus jobStatus = (JobStatus) obj;
        if (this._tag != jobStatus._tag) {
            return false;
        }
        int i = C42661.$SwitchMap$com$dropbox$core$v2$sharing$JobStatus$Tag[this._tag.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                return false;
            }
            JobError jobError = this.failedValue;
            JobError jobError2 = jobStatus.failedValue;
            if (jobError != jobError2 && !jobError.equals(jobError2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.JobStatus$1 */
    static /* synthetic */ class C42661 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$JobStatus$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$JobStatus$Tag = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$JobStatus$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$JobStatus$Tag[Tag.FAILED.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<JobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(JobStatus jobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C42661.$SwitchMap$com$dropbox$core$v2$sharing$JobStatus$Tag[jobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("complete");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("failed", jsonGenerator);
                jsonGenerator.writeFieldName("failed");
                JobError.Serializer.INSTANCE.serialize(jobStatus.failedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + jobStatus.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public JobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            JobStatus jobStatusFailed;
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
                jobStatusFailed = JobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                jobStatusFailed = JobStatus.COMPLETE;
            } else if ("failed".equals(tag)) {
                expectField("failed", jsonParser);
                jobStatusFailed = JobStatus.failed(JobError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return jobStatusFailed;
        }
    }
}
