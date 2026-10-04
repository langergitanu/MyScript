package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.UploadSessionFinishBatchResult;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class UploadSessionFinishBatchLaunch {
    public static final UploadSessionFinishBatchLaunch OTHER = new UploadSessionFinishBatchLaunch().withTag(Tag.OTHER);
    private Tag _tag;
    private String asyncJobIdValue;
    private UploadSessionFinishBatchResult completeValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE,
        OTHER
    }

    private UploadSessionFinishBatchLaunch() {
    }

    private UploadSessionFinishBatchLaunch withTag(Tag tag) {
        UploadSessionFinishBatchLaunch uploadSessionFinishBatchLaunch = new UploadSessionFinishBatchLaunch();
        uploadSessionFinishBatchLaunch._tag = tag;
        return uploadSessionFinishBatchLaunch;
    }

    private UploadSessionFinishBatchLaunch withTagAndAsyncJobId(Tag tag, String str) {
        UploadSessionFinishBatchLaunch uploadSessionFinishBatchLaunch = new UploadSessionFinishBatchLaunch();
        uploadSessionFinishBatchLaunch._tag = tag;
        uploadSessionFinishBatchLaunch.asyncJobIdValue = str;
        return uploadSessionFinishBatchLaunch;
    }

    private UploadSessionFinishBatchLaunch withTagAndComplete(Tag tag, UploadSessionFinishBatchResult uploadSessionFinishBatchResult) {
        UploadSessionFinishBatchLaunch uploadSessionFinishBatchLaunch = new UploadSessionFinishBatchLaunch();
        uploadSessionFinishBatchLaunch._tag = tag;
        uploadSessionFinishBatchLaunch.completeValue = uploadSessionFinishBatchResult;
        return uploadSessionFinishBatchLaunch;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static UploadSessionFinishBatchLaunch asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new UploadSessionFinishBatchLaunch().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
    }

    public String getAsyncJobIdValue() {
        if (this._tag != Tag.ASYNC_JOB_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.ASYNC_JOB_ID, but was Tag." + this._tag.name());
        }
        return this.asyncJobIdValue;
    }

    public boolean isComplete() {
        return this._tag == Tag.COMPLETE;
    }

    public static UploadSessionFinishBatchLaunch complete(UploadSessionFinishBatchResult uploadSessionFinishBatchResult) {
        if (uploadSessionFinishBatchResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishBatchLaunch().withTagAndComplete(Tag.COMPLETE, uploadSessionFinishBatchResult);
    }

    public UploadSessionFinishBatchResult getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.asyncJobIdValue, this.completeValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UploadSessionFinishBatchLaunch)) {
            return false;
        }
        UploadSessionFinishBatchLaunch uploadSessionFinishBatchLaunch = (UploadSessionFinishBatchLaunch) obj;
        if (this._tag != uploadSessionFinishBatchLaunch._tag) {
            return false;
        }
        int i = C42151.f711xc1e97b56[this._tag.ordinal()];
        if (i == 1) {
            String str = this.asyncJobIdValue;
            String str2 = uploadSessionFinishBatchLaunch.asyncJobIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return i == 3;
        }
        UploadSessionFinishBatchResult uploadSessionFinishBatchResult = this.completeValue;
        UploadSessionFinishBatchResult uploadSessionFinishBatchResult2 = uploadSessionFinishBatchLaunch.completeValue;
        return uploadSessionFinishBatchResult == uploadSessionFinishBatchResult2 || uploadSessionFinishBatchResult.equals(uploadSessionFinishBatchResult2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.UploadSessionFinishBatchLaunch$1 */
    static /* synthetic */ class C42151 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$UploadSessionFinishBatchLaunch$Tag */
        static final /* synthetic */ int[] f711xc1e97b56;

        static {
            int[] iArr = new int[Tag.values().length];
            f711xc1e97b56 = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f711xc1e97b56[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f711xc1e97b56[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<UploadSessionFinishBatchLaunch> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UploadSessionFinishBatchLaunch uploadSessionFinishBatchLaunch, JsonGenerator jsonGenerator) throws IOException {
            int i = C42151.f711xc1e97b56[uploadSessionFinishBatchLaunch.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(uploadSessionFinishBatchLaunch.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                UploadSessionFinishBatchResult.Serializer.INSTANCE.serialize(uploadSessionFinishBatchLaunch.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UploadSessionFinishBatchLaunch deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UploadSessionFinishBatchLaunch uploadSessionFinishBatchLaunchComplete;
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
            if ("async_job_id".equals(tag)) {
                expectField("async_job_id", jsonParser);
                uploadSessionFinishBatchLaunchComplete = UploadSessionFinishBatchLaunch.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                uploadSessionFinishBatchLaunchComplete = UploadSessionFinishBatchLaunch.complete(UploadSessionFinishBatchResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                uploadSessionFinishBatchLaunchComplete = UploadSessionFinishBatchLaunch.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return uploadSessionFinishBatchLaunchComplete;
        }
    }
}
