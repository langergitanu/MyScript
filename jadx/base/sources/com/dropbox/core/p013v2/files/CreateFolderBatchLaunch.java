package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.CreateFolderBatchResult;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class CreateFolderBatchLaunch {
    public static final CreateFolderBatchLaunch OTHER = new CreateFolderBatchLaunch().withTag(Tag.OTHER);
    private Tag _tag;
    private String asyncJobIdValue;
    private CreateFolderBatchResult completeValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE,
        OTHER
    }

    private CreateFolderBatchLaunch() {
    }

    private CreateFolderBatchLaunch withTag(Tag tag) {
        CreateFolderBatchLaunch createFolderBatchLaunch = new CreateFolderBatchLaunch();
        createFolderBatchLaunch._tag = tag;
        return createFolderBatchLaunch;
    }

    private CreateFolderBatchLaunch withTagAndAsyncJobId(Tag tag, String str) {
        CreateFolderBatchLaunch createFolderBatchLaunch = new CreateFolderBatchLaunch();
        createFolderBatchLaunch._tag = tag;
        createFolderBatchLaunch.asyncJobIdValue = str;
        return createFolderBatchLaunch;
    }

    private CreateFolderBatchLaunch withTagAndComplete(Tag tag, CreateFolderBatchResult createFolderBatchResult) {
        CreateFolderBatchLaunch createFolderBatchLaunch = new CreateFolderBatchLaunch();
        createFolderBatchLaunch._tag = tag;
        createFolderBatchLaunch.completeValue = createFolderBatchResult;
        return createFolderBatchLaunch;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static CreateFolderBatchLaunch asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new CreateFolderBatchLaunch().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
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

    public static CreateFolderBatchLaunch complete(CreateFolderBatchResult createFolderBatchResult) {
        if (createFolderBatchResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateFolderBatchLaunch().withTagAndComplete(Tag.COMPLETE, createFolderBatchResult);
    }

    public CreateFolderBatchResult getCompleteValue() {
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
        if (obj == null || !(obj instanceof CreateFolderBatchLaunch)) {
            return false;
        }
        CreateFolderBatchLaunch createFolderBatchLaunch = (CreateFolderBatchLaunch) obj;
        if (this._tag != createFolderBatchLaunch._tag) {
            return false;
        }
        int i = C41461.$SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchLaunch$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.asyncJobIdValue;
            String str2 = createFolderBatchLaunch.asyncJobIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return i == 3;
        }
        CreateFolderBatchResult createFolderBatchResult = this.completeValue;
        CreateFolderBatchResult createFolderBatchResult2 = createFolderBatchLaunch.completeValue;
        return createFolderBatchResult == createFolderBatchResult2 || createFolderBatchResult.equals(createFolderBatchResult2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.CreateFolderBatchLaunch$1 */
    static /* synthetic */ class C41461 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchLaunch$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchLaunch$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchLaunch$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchLaunch$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<CreateFolderBatchLaunch> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CreateFolderBatchLaunch createFolderBatchLaunch, JsonGenerator jsonGenerator) throws IOException {
            int i = C41461.$SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchLaunch$Tag[createFolderBatchLaunch.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(createFolderBatchLaunch.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                CreateFolderBatchResult.Serializer.INSTANCE.serialize(createFolderBatchLaunch.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CreateFolderBatchLaunch deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CreateFolderBatchLaunch createFolderBatchLaunchComplete;
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
                createFolderBatchLaunchComplete = CreateFolderBatchLaunch.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                createFolderBatchLaunchComplete = CreateFolderBatchLaunch.complete(CreateFolderBatchResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                createFolderBatchLaunchComplete = CreateFolderBatchLaunch.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return createFolderBatchLaunchComplete;
        }
    }
}
