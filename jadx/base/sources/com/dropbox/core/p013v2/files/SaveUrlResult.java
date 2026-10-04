package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class SaveUrlResult {
    private Tag _tag;
    private String asyncJobIdValue;
    private FileMetadata completeValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE
    }

    private SaveUrlResult() {
    }

    private SaveUrlResult withTag(Tag tag) {
        SaveUrlResult saveUrlResult = new SaveUrlResult();
        saveUrlResult._tag = tag;
        return saveUrlResult;
    }

    private SaveUrlResult withTagAndAsyncJobId(Tag tag, String str) {
        SaveUrlResult saveUrlResult = new SaveUrlResult();
        saveUrlResult._tag = tag;
        saveUrlResult.asyncJobIdValue = str;
        return saveUrlResult;
    }

    private SaveUrlResult withTagAndComplete(Tag tag, FileMetadata fileMetadata) {
        SaveUrlResult saveUrlResult = new SaveUrlResult();
        saveUrlResult._tag = tag;
        saveUrlResult.completeValue = fileMetadata;
        return saveUrlResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static SaveUrlResult asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new SaveUrlResult().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
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

    public static SaveUrlResult complete(FileMetadata fileMetadata) {
        if (fileMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SaveUrlResult().withTagAndComplete(Tag.COMPLETE, fileMetadata);
    }

    public FileMetadata getCompleteValue() {
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
        if (obj == null || !(obj instanceof SaveUrlResult)) {
            return false;
        }
        SaveUrlResult saveUrlResult = (SaveUrlResult) obj;
        if (this._tag != saveUrlResult._tag) {
            return false;
        }
        int i = C41971.$SwitchMap$com$dropbox$core$v2$files$SaveUrlResult$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.asyncJobIdValue;
            String str2 = saveUrlResult.asyncJobIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return false;
        }
        FileMetadata fileMetadata = this.completeValue;
        FileMetadata fileMetadata2 = saveUrlResult.completeValue;
        return fileMetadata == fileMetadata2 || fileMetadata.equals(fileMetadata2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SaveUrlResult$1 */
    static /* synthetic */ class C41971 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SaveUrlResult$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SaveUrlResult$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveUrlResult$Tag[Tag.COMPLETE.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<SaveUrlResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SaveUrlResult saveUrlResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C41971.$SwitchMap$com$dropbox$core$v2$files$SaveUrlResult$Tag[saveUrlResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(saveUrlResult.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                FileMetadata.Serializer.INSTANCE.serialize(saveUrlResult.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + saveUrlResult.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SaveUrlResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SaveUrlResult saveUrlResultComplete;
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
                saveUrlResultComplete = SaveUrlResult.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                saveUrlResultComplete = SaveUrlResult.complete(FileMetadata.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return saveUrlResultComplete;
        }
    }
}
