package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.DeleteBatchResultData;
import com.dropbox.core.p013v2.files.DeleteError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class DeleteBatchResultEntry {
    private Tag _tag;
    private DeleteError failureValue;
    private DeleteBatchResultData successValue;

    public enum Tag {
        SUCCESS,
        FAILURE
    }

    private DeleteBatchResultEntry() {
    }

    private DeleteBatchResultEntry withTag(Tag tag) {
        DeleteBatchResultEntry deleteBatchResultEntry = new DeleteBatchResultEntry();
        deleteBatchResultEntry._tag = tag;
        return deleteBatchResultEntry;
    }

    private DeleteBatchResultEntry withTagAndSuccess(Tag tag, DeleteBatchResultData deleteBatchResultData) {
        DeleteBatchResultEntry deleteBatchResultEntry = new DeleteBatchResultEntry();
        deleteBatchResultEntry._tag = tag;
        deleteBatchResultEntry.successValue = deleteBatchResultData;
        return deleteBatchResultEntry;
    }

    private DeleteBatchResultEntry withTagAndFailure(Tag tag, DeleteError deleteError) {
        DeleteBatchResultEntry deleteBatchResultEntry = new DeleteBatchResultEntry();
        deleteBatchResultEntry._tag = tag;
        deleteBatchResultEntry.failureValue = deleteError;
        return deleteBatchResultEntry;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static DeleteBatchResultEntry success(DeleteBatchResultData deleteBatchResultData) {
        if (deleteBatchResultData == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteBatchResultEntry().withTagAndSuccess(Tag.SUCCESS, deleteBatchResultData);
    }

    public DeleteBatchResultData getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isFailure() {
        return this._tag == Tag.FAILURE;
    }

    public static DeleteBatchResultEntry failure(DeleteError deleteError) {
        if (deleteError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteBatchResultEntry().withTagAndFailure(Tag.FAILURE, deleteError);
    }

    public DeleteError getFailureValue() {
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
        if (obj == null || !(obj instanceof DeleteBatchResultEntry)) {
            return false;
        }
        DeleteBatchResultEntry deleteBatchResultEntry = (DeleteBatchResultEntry) obj;
        if (this._tag != deleteBatchResultEntry._tag) {
            return false;
        }
        int i = C41531.$SwitchMap$com$dropbox$core$v2$files$DeleteBatchResultEntry$Tag[this._tag.ordinal()];
        if (i == 1) {
            DeleteBatchResultData deleteBatchResultData = this.successValue;
            DeleteBatchResultData deleteBatchResultData2 = deleteBatchResultEntry.successValue;
            return deleteBatchResultData == deleteBatchResultData2 || deleteBatchResultData.equals(deleteBatchResultData2);
        }
        if (i != 2) {
            return false;
        }
        DeleteError deleteError = this.failureValue;
        DeleteError deleteError2 = deleteBatchResultEntry.failureValue;
        return deleteError == deleteError2 || deleteError.equals(deleteError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.DeleteBatchResultEntry$1 */
    static /* synthetic */ class C41531 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$DeleteBatchResultEntry$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$DeleteBatchResultEntry$Tag = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$DeleteBatchResultEntry$Tag[Tag.FAILURE.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<DeleteBatchResultEntry> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeleteBatchResultEntry deleteBatchResultEntry, JsonGenerator jsonGenerator) throws IOException {
            int i = C41531.$SwitchMap$com$dropbox$core$v2$files$DeleteBatchResultEntry$Tag[deleteBatchResultEntry.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                DeleteBatchResultData.Serializer.INSTANCE.serialize(deleteBatchResultEntry.successValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("failure", jsonGenerator);
                jsonGenerator.writeFieldName("failure");
                DeleteError.Serializer.INSTANCE.serialize(deleteBatchResultEntry.failureValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + deleteBatchResultEntry.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeleteBatchResultEntry deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeleteBatchResultEntry deleteBatchResultEntryFailure;
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
                deleteBatchResultEntryFailure = DeleteBatchResultEntry.success(DeleteBatchResultData.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failure".equals(tag)) {
                expectField("failure", jsonParser);
                deleteBatchResultEntryFailure = DeleteBatchResultEntry.failure(DeleteError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deleteBatchResultEntryFailure;
        }
    }
}
