package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.CreateFolderEntryError;
import com.dropbox.core.p013v2.files.CreateFolderEntryResult;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class CreateFolderBatchResultEntry {
    private Tag _tag;
    private CreateFolderEntryError failureValue;
    private CreateFolderEntryResult successValue;

    public enum Tag {
        SUCCESS,
        FAILURE
    }

    private CreateFolderBatchResultEntry() {
    }

    private CreateFolderBatchResultEntry withTag(Tag tag) {
        CreateFolderBatchResultEntry createFolderBatchResultEntry = new CreateFolderBatchResultEntry();
        createFolderBatchResultEntry._tag = tag;
        return createFolderBatchResultEntry;
    }

    private CreateFolderBatchResultEntry withTagAndSuccess(Tag tag, CreateFolderEntryResult createFolderEntryResult) {
        CreateFolderBatchResultEntry createFolderBatchResultEntry = new CreateFolderBatchResultEntry();
        createFolderBatchResultEntry._tag = tag;
        createFolderBatchResultEntry.successValue = createFolderEntryResult;
        return createFolderBatchResultEntry;
    }

    private CreateFolderBatchResultEntry withTagAndFailure(Tag tag, CreateFolderEntryError createFolderEntryError) {
        CreateFolderBatchResultEntry createFolderBatchResultEntry = new CreateFolderBatchResultEntry();
        createFolderBatchResultEntry._tag = tag;
        createFolderBatchResultEntry.failureValue = createFolderEntryError;
        return createFolderBatchResultEntry;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static CreateFolderBatchResultEntry success(CreateFolderEntryResult createFolderEntryResult) {
        if (createFolderEntryResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateFolderBatchResultEntry().withTagAndSuccess(Tag.SUCCESS, createFolderEntryResult);
    }

    public CreateFolderEntryResult getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isFailure() {
        return this._tag == Tag.FAILURE;
    }

    public static CreateFolderBatchResultEntry failure(CreateFolderEntryError createFolderEntryError) {
        if (createFolderEntryError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateFolderBatchResultEntry().withTagAndFailure(Tag.FAILURE, createFolderEntryError);
    }

    public CreateFolderEntryError getFailureValue() {
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
        if (obj == null || !(obj instanceof CreateFolderBatchResultEntry)) {
            return false;
        }
        CreateFolderBatchResultEntry createFolderBatchResultEntry = (CreateFolderBatchResultEntry) obj;
        if (this._tag != createFolderBatchResultEntry._tag) {
            return false;
        }
        int i = C41471.f694x54ff6556[this._tag.ordinal()];
        if (i == 1) {
            CreateFolderEntryResult createFolderEntryResult = this.successValue;
            CreateFolderEntryResult createFolderEntryResult2 = createFolderBatchResultEntry.successValue;
            return createFolderEntryResult == createFolderEntryResult2 || createFolderEntryResult.equals(createFolderEntryResult2);
        }
        if (i != 2) {
            return false;
        }
        CreateFolderEntryError createFolderEntryError = this.failureValue;
        CreateFolderEntryError createFolderEntryError2 = createFolderBatchResultEntry.failureValue;
        return createFolderEntryError == createFolderEntryError2 || createFolderEntryError.equals(createFolderEntryError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.CreateFolderBatchResultEntry$1 */
    static /* synthetic */ class C41471 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$CreateFolderBatchResultEntry$Tag */
        static final /* synthetic */ int[] f694x54ff6556;

        static {
            int[] iArr = new int[Tag.values().length];
            f694x54ff6556 = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f694x54ff6556[Tag.FAILURE.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<CreateFolderBatchResultEntry> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CreateFolderBatchResultEntry createFolderBatchResultEntry, JsonGenerator jsonGenerator) throws IOException {
            int i = C41471.f694x54ff6556[createFolderBatchResultEntry.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                CreateFolderEntryResult.Serializer.INSTANCE.serialize(createFolderBatchResultEntry.successValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("failure", jsonGenerator);
                jsonGenerator.writeFieldName("failure");
                CreateFolderEntryError.Serializer.INSTANCE.serialize(createFolderBatchResultEntry.failureValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + createFolderBatchResultEntry.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CreateFolderBatchResultEntry deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CreateFolderBatchResultEntry createFolderBatchResultEntryFailure;
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
                createFolderBatchResultEntryFailure = CreateFolderBatchResultEntry.success(CreateFolderEntryResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failure".equals(tag)) {
                expectField("failure", jsonParser);
                createFolderBatchResultEntryFailure = CreateFolderBatchResultEntry.failure(CreateFolderEntryError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return createFolderBatchResultEntryFailure;
        }
    }
}
