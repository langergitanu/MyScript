package com.dropbox.core.p013v2.async;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class LaunchEmptyResult {
    public static final LaunchEmptyResult COMPLETE = new LaunchEmptyResult().withTag(Tag.COMPLETE);
    private Tag _tag;
    private String asyncJobIdValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE
    }

    private LaunchEmptyResult() {
    }

    private LaunchEmptyResult withTag(Tag tag) {
        LaunchEmptyResult launchEmptyResult = new LaunchEmptyResult();
        launchEmptyResult._tag = tag;
        return launchEmptyResult;
    }

    private LaunchEmptyResult withTagAndAsyncJobId(Tag tag, String str) {
        LaunchEmptyResult launchEmptyResult = new LaunchEmptyResult();
        launchEmptyResult._tag = tag;
        launchEmptyResult.asyncJobIdValue = str;
        return launchEmptyResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static LaunchEmptyResult asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new LaunchEmptyResult().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
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

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.asyncJobIdValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof LaunchEmptyResult)) {
            return false;
        }
        LaunchEmptyResult launchEmptyResult = (LaunchEmptyResult) obj;
        if (this._tag != launchEmptyResult._tag) {
            return false;
        }
        int i = C41031.$SwitchMap$com$dropbox$core$v2$async$LaunchEmptyResult$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        String str = this.asyncJobIdValue;
        String str2 = launchEmptyResult.asyncJobIdValue;
        return str == str2 || str.equals(str2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.async.LaunchEmptyResult$1 */
    static /* synthetic */ class C41031 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$async$LaunchEmptyResult$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$async$LaunchEmptyResult$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$async$LaunchEmptyResult$Tag[Tag.COMPLETE.ordinal()] = 2;
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

    public static class Serializer extends UnionSerializer<LaunchEmptyResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LaunchEmptyResult launchEmptyResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C41031.$SwitchMap$com$dropbox$core$v2$async$LaunchEmptyResult$Tag[launchEmptyResult.tag().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    jsonGenerator.writeString("complete");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + launchEmptyResult.tag());
            }
            jsonGenerator.writeStartObject();
            writeTag("async_job_id", jsonGenerator);
            jsonGenerator.writeFieldName("async_job_id");
            StoneSerializers.string().serialize(launchEmptyResult.asyncJobIdValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LaunchEmptyResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LaunchEmptyResult launchEmptyResultAsyncJobId;
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
                launchEmptyResultAsyncJobId = LaunchEmptyResult.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                launchEmptyResultAsyncJobId = LaunchEmptyResult.COMPLETE;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return launchEmptyResultAsyncJobId;
        }
    }
}
