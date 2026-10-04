package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.DeleteBatchResult;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class DeleteBatchLaunch {
    public static final DeleteBatchLaunch OTHER = new DeleteBatchLaunch().withTag(Tag.OTHER);
    private Tag _tag;
    private String asyncJobIdValue;
    private DeleteBatchResult completeValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE,
        OTHER
    }

    private DeleteBatchLaunch() {
    }

    private DeleteBatchLaunch withTag(Tag tag) {
        DeleteBatchLaunch deleteBatchLaunch = new DeleteBatchLaunch();
        deleteBatchLaunch._tag = tag;
        return deleteBatchLaunch;
    }

    private DeleteBatchLaunch withTagAndAsyncJobId(Tag tag, String str) {
        DeleteBatchLaunch deleteBatchLaunch = new DeleteBatchLaunch();
        deleteBatchLaunch._tag = tag;
        deleteBatchLaunch.asyncJobIdValue = str;
        return deleteBatchLaunch;
    }

    private DeleteBatchLaunch withTagAndComplete(Tag tag, DeleteBatchResult deleteBatchResult) {
        DeleteBatchLaunch deleteBatchLaunch = new DeleteBatchLaunch();
        deleteBatchLaunch._tag = tag;
        deleteBatchLaunch.completeValue = deleteBatchResult;
        return deleteBatchLaunch;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static DeleteBatchLaunch asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new DeleteBatchLaunch().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
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

    public static DeleteBatchLaunch complete(DeleteBatchResult deleteBatchResult) {
        if (deleteBatchResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteBatchLaunch().withTagAndComplete(Tag.COMPLETE, deleteBatchResult);
    }

    public DeleteBatchResult getCompleteValue() {
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
        if (obj == null || !(obj instanceof DeleteBatchLaunch)) {
            return false;
        }
        DeleteBatchLaunch deleteBatchLaunch = (DeleteBatchLaunch) obj;
        if (this._tag != deleteBatchLaunch._tag) {
            return false;
        }
        int i = C41521.$SwitchMap$com$dropbox$core$v2$files$DeleteBatchLaunch$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.asyncJobIdValue;
            String str2 = deleteBatchLaunch.asyncJobIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return i == 3;
        }
        DeleteBatchResult deleteBatchResult = this.completeValue;
        DeleteBatchResult deleteBatchResult2 = deleteBatchLaunch.completeValue;
        return deleteBatchResult == deleteBatchResult2 || deleteBatchResult.equals(deleteBatchResult2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.DeleteBatchLaunch$1 */
    static /* synthetic */ class C41521 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$DeleteBatchLaunch$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$DeleteBatchLaunch$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DeleteBatchLaunch$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DeleteBatchLaunch$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<DeleteBatchLaunch> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeleteBatchLaunch deleteBatchLaunch, JsonGenerator jsonGenerator) throws IOException {
            int i = C41521.$SwitchMap$com$dropbox$core$v2$files$DeleteBatchLaunch$Tag[deleteBatchLaunch.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(deleteBatchLaunch.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                DeleteBatchResult.Serializer.INSTANCE.serialize(deleteBatchLaunch.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeleteBatchLaunch deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeleteBatchLaunch deleteBatchLaunchComplete;
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
                deleteBatchLaunchComplete = DeleteBatchLaunch.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                deleteBatchLaunchComplete = DeleteBatchLaunch.complete(DeleteBatchResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                deleteBatchLaunchComplete = DeleteBatchLaunch.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deleteBatchLaunchComplete;
        }
    }
}
