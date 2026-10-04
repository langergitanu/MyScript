package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.RelocationBatchResult;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RelocationBatchLaunch {
    public static final RelocationBatchLaunch OTHER = new RelocationBatchLaunch().withTag(Tag.OTHER);
    private Tag _tag;
    private String asyncJobIdValue;
    private RelocationBatchResult completeValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE,
        OTHER
    }

    private RelocationBatchLaunch() {
    }

    private RelocationBatchLaunch withTag(Tag tag) {
        RelocationBatchLaunch relocationBatchLaunch = new RelocationBatchLaunch();
        relocationBatchLaunch._tag = tag;
        return relocationBatchLaunch;
    }

    private RelocationBatchLaunch withTagAndAsyncJobId(Tag tag, String str) {
        RelocationBatchLaunch relocationBatchLaunch = new RelocationBatchLaunch();
        relocationBatchLaunch._tag = tag;
        relocationBatchLaunch.asyncJobIdValue = str;
        return relocationBatchLaunch;
    }

    private RelocationBatchLaunch withTagAndComplete(Tag tag, RelocationBatchResult relocationBatchResult) {
        RelocationBatchLaunch relocationBatchLaunch = new RelocationBatchLaunch();
        relocationBatchLaunch._tag = tag;
        relocationBatchLaunch.completeValue = relocationBatchResult;
        return relocationBatchLaunch;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static RelocationBatchLaunch asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new RelocationBatchLaunch().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
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

    public static RelocationBatchLaunch complete(RelocationBatchResult relocationBatchResult) {
        if (relocationBatchResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchLaunch().withTagAndComplete(Tag.COMPLETE, relocationBatchResult);
    }

    public RelocationBatchResult getCompleteValue() {
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
        if (obj == null || !(obj instanceof RelocationBatchLaunch)) {
            return false;
        }
        RelocationBatchLaunch relocationBatchLaunch = (RelocationBatchLaunch) obj;
        if (this._tag != relocationBatchLaunch._tag) {
            return false;
        }
        int i = C41871.$SwitchMap$com$dropbox$core$v2$files$RelocationBatchLaunch$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.asyncJobIdValue;
            String str2 = relocationBatchLaunch.asyncJobIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return i == 3;
        }
        RelocationBatchResult relocationBatchResult = this.completeValue;
        RelocationBatchResult relocationBatchResult2 = relocationBatchLaunch.completeValue;
        return relocationBatchResult == relocationBatchResult2 || relocationBatchResult.equals(relocationBatchResult2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.RelocationBatchLaunch$1 */
    static /* synthetic */ class C41871 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$RelocationBatchLaunch$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$RelocationBatchLaunch$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchLaunch$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RelocationBatchLaunch$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<RelocationBatchLaunch> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RelocationBatchLaunch relocationBatchLaunch, JsonGenerator jsonGenerator) throws IOException {
            int i = C41871.$SwitchMap$com$dropbox$core$v2$files$RelocationBatchLaunch$Tag[relocationBatchLaunch.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(relocationBatchLaunch.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                RelocationBatchResult.Serializer.INSTANCE.serialize(relocationBatchLaunch.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RelocationBatchLaunch deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RelocationBatchLaunch relocationBatchLaunchComplete;
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
                relocationBatchLaunchComplete = RelocationBatchLaunch.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                relocationBatchLaunchComplete = RelocationBatchLaunch.complete(RelocationBatchResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                relocationBatchLaunchComplete = RelocationBatchLaunch.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return relocationBatchLaunchComplete;
        }
    }
}
