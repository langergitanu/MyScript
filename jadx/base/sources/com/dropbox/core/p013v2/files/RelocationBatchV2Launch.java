package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.RelocationBatchV2Result;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RelocationBatchV2Launch {
    private Tag _tag;
    private String asyncJobIdValue;
    private RelocationBatchV2Result completeValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE
    }

    private RelocationBatchV2Launch() {
    }

    private RelocationBatchV2Launch withTag(Tag tag) {
        RelocationBatchV2Launch relocationBatchV2Launch = new RelocationBatchV2Launch();
        relocationBatchV2Launch._tag = tag;
        return relocationBatchV2Launch;
    }

    private RelocationBatchV2Launch withTagAndAsyncJobId(Tag tag, String str) {
        RelocationBatchV2Launch relocationBatchV2Launch = new RelocationBatchV2Launch();
        relocationBatchV2Launch._tag = tag;
        relocationBatchV2Launch.asyncJobIdValue = str;
        return relocationBatchV2Launch;
    }

    private RelocationBatchV2Launch withTagAndComplete(Tag tag, RelocationBatchV2Result relocationBatchV2Result) {
        RelocationBatchV2Launch relocationBatchV2Launch = new RelocationBatchV2Launch();
        relocationBatchV2Launch._tag = tag;
        relocationBatchV2Launch.completeValue = relocationBatchV2Result;
        return relocationBatchV2Launch;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static RelocationBatchV2Launch asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new RelocationBatchV2Launch().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
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

    public static RelocationBatchV2Launch complete(RelocationBatchV2Result relocationBatchV2Result) {
        if (relocationBatchV2Result == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchV2Launch().withTagAndComplete(Tag.COMPLETE, relocationBatchV2Result);
    }

    public RelocationBatchV2Result getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.asyncJobIdValue, this.completeValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RelocationBatchV2Launch)) {
            return false;
        }
        RelocationBatchV2Launch relocationBatchV2Launch = (RelocationBatchV2Launch) obj;
        if (this._tag != relocationBatchV2Launch._tag) {
            return false;
        }
        int i = C41901.$SwitchMap$com$dropbox$core$v2$files$RelocationBatchV2Launch$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.asyncJobIdValue;
            String str2 = relocationBatchV2Launch.asyncJobIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return false;
        }
        RelocationBatchV2Result relocationBatchV2Result = this.completeValue;
        RelocationBatchV2Result relocationBatchV2Result2 = relocationBatchV2Launch.completeValue;
        return relocationBatchV2Result == relocationBatchV2Result2 || relocationBatchV2Result.equals(relocationBatchV2Result2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.RelocationBatchV2Launch$1 */
    static /* synthetic */ class C41901 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$RelocationBatchV2Launch$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$RelocationBatchV2Launch$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchV2Launch$Tag[Tag.COMPLETE.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<RelocationBatchV2Launch> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RelocationBatchV2Launch relocationBatchV2Launch, JsonGenerator jsonGenerator) throws IOException {
            int i = C41901.$SwitchMap$com$dropbox$core$v2$files$RelocationBatchV2Launch$Tag[relocationBatchV2Launch.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(relocationBatchV2Launch.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                RelocationBatchV2Result.Serializer.INSTANCE.serialize(relocationBatchV2Launch.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + relocationBatchV2Launch.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RelocationBatchV2Launch deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RelocationBatchV2Launch relocationBatchV2LaunchComplete;
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
                relocationBatchV2LaunchComplete = RelocationBatchV2Launch.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                relocationBatchV2LaunchComplete = RelocationBatchV2Launch.complete(RelocationBatchV2Result.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return relocationBatchV2LaunchComplete;
        }
    }
}
