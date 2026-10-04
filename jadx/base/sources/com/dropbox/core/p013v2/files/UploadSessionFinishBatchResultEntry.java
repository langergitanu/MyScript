package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.p013v2.files.UploadSessionFinishError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class UploadSessionFinishBatchResultEntry {
    private Tag _tag;
    private UploadSessionFinishError failureValue;
    private FileMetadata successValue;

    public enum Tag {
        SUCCESS,
        FAILURE
    }

    private UploadSessionFinishBatchResultEntry() {
    }

    private UploadSessionFinishBatchResultEntry withTag(Tag tag) {
        UploadSessionFinishBatchResultEntry uploadSessionFinishBatchResultEntry = new UploadSessionFinishBatchResultEntry();
        uploadSessionFinishBatchResultEntry._tag = tag;
        return uploadSessionFinishBatchResultEntry;
    }

    private UploadSessionFinishBatchResultEntry withTagAndSuccess(Tag tag, FileMetadata fileMetadata) {
        UploadSessionFinishBatchResultEntry uploadSessionFinishBatchResultEntry = new UploadSessionFinishBatchResultEntry();
        uploadSessionFinishBatchResultEntry._tag = tag;
        uploadSessionFinishBatchResultEntry.successValue = fileMetadata;
        return uploadSessionFinishBatchResultEntry;
    }

    private UploadSessionFinishBatchResultEntry withTagAndFailure(Tag tag, UploadSessionFinishError uploadSessionFinishError) {
        UploadSessionFinishBatchResultEntry uploadSessionFinishBatchResultEntry = new UploadSessionFinishBatchResultEntry();
        uploadSessionFinishBatchResultEntry._tag = tag;
        uploadSessionFinishBatchResultEntry.failureValue = uploadSessionFinishError;
        return uploadSessionFinishBatchResultEntry;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static UploadSessionFinishBatchResultEntry success(FileMetadata fileMetadata) {
        if (fileMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishBatchResultEntry().withTagAndSuccess(Tag.SUCCESS, fileMetadata);
    }

    public FileMetadata getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isFailure() {
        return this._tag == Tag.FAILURE;
    }

    public static UploadSessionFinishBatchResultEntry failure(UploadSessionFinishError uploadSessionFinishError) {
        if (uploadSessionFinishError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishBatchResultEntry().withTagAndFailure(Tag.FAILURE, uploadSessionFinishError);
    }

    public UploadSessionFinishError getFailureValue() {
        if (this._tag != Tag.FAILURE) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILURE, but was Tag." + this._tag.name());
        }
        return this.failureValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.failureValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UploadSessionFinishBatchResultEntry)) {
            return false;
        }
        UploadSessionFinishBatchResultEntry uploadSessionFinishBatchResultEntry = (UploadSessionFinishBatchResultEntry) obj;
        if (this._tag != uploadSessionFinishBatchResultEntry._tag) {
            return false;
        }
        int i = C42161.f712xd9c0307e[this._tag.ordinal()];
        if (i == 1) {
            FileMetadata fileMetadata = this.successValue;
            FileMetadata fileMetadata2 = uploadSessionFinishBatchResultEntry.successValue;
            return fileMetadata == fileMetadata2 || fileMetadata.equals(fileMetadata2);
        }
        if (i != 2) {
            return false;
        }
        UploadSessionFinishError uploadSessionFinishError = this.failureValue;
        UploadSessionFinishError uploadSessionFinishError2 = uploadSessionFinishBatchResultEntry.failureValue;
        return uploadSessionFinishError == uploadSessionFinishError2 || uploadSessionFinishError.equals(uploadSessionFinishError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.UploadSessionFinishBatchResultEntry$1 */
    static /* synthetic */ class C42161 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$UploadSessionFinishBatchResultEntry$Tag */
        static final /* synthetic */ int[] f712xd9c0307e;

        static {
            int[] iArr = new int[Tag.values().length];
            f712xd9c0307e = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f712xd9c0307e[Tag.FAILURE.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<UploadSessionFinishBatchResultEntry> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UploadSessionFinishBatchResultEntry uploadSessionFinishBatchResultEntry, JsonGenerator jsonGenerator) throws IOException {
            int i = C42161.f712xd9c0307e[uploadSessionFinishBatchResultEntry.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                FileMetadata.Serializer.INSTANCE.serialize(uploadSessionFinishBatchResultEntry.successValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("failure", jsonGenerator);
                jsonGenerator.writeFieldName("failure");
                UploadSessionFinishError.Serializer.INSTANCE.serialize(uploadSessionFinishBatchResultEntry.failureValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + uploadSessionFinishBatchResultEntry.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UploadSessionFinishBatchResultEntry deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UploadSessionFinishBatchResultEntry uploadSessionFinishBatchResultEntryFailure;
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
            if (FirebaseAnalytics.Param.SUCCESS.equals(tag)) {
                uploadSessionFinishBatchResultEntryFailure = UploadSessionFinishBatchResultEntry.success(FileMetadata.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failure".equals(tag)) {
                expectField("failure", jsonParser);
                uploadSessionFinishBatchResultEntryFailure = UploadSessionFinishBatchResultEntry.failure(UploadSessionFinishError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return uploadSessionFinishBatchResultEntryFailure;
        }
    }
}
