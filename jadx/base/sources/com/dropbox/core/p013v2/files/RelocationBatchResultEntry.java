package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.Metadata;
import com.dropbox.core.p013v2.files.RelocationBatchErrorEntry;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RelocationBatchResultEntry {
    public static final RelocationBatchResultEntry OTHER = new RelocationBatchResultEntry().withTag(Tag.OTHER);
    private Tag _tag;
    private RelocationBatchErrorEntry failureValue;
    private Metadata successValue;

    public enum Tag {
        SUCCESS,
        FAILURE,
        OTHER
    }

    private RelocationBatchResultEntry() {
    }

    private RelocationBatchResultEntry withTag(Tag tag) {
        RelocationBatchResultEntry relocationBatchResultEntry = new RelocationBatchResultEntry();
        relocationBatchResultEntry._tag = tag;
        return relocationBatchResultEntry;
    }

    private RelocationBatchResultEntry withTagAndSuccess(Tag tag, Metadata metadata) {
        RelocationBatchResultEntry relocationBatchResultEntry = new RelocationBatchResultEntry();
        relocationBatchResultEntry._tag = tag;
        relocationBatchResultEntry.successValue = metadata;
        return relocationBatchResultEntry;
    }

    private RelocationBatchResultEntry withTagAndFailure(Tag tag, RelocationBatchErrorEntry relocationBatchErrorEntry) {
        RelocationBatchResultEntry relocationBatchResultEntry = new RelocationBatchResultEntry();
        relocationBatchResultEntry._tag = tag;
        relocationBatchResultEntry.failureValue = relocationBatchErrorEntry;
        return relocationBatchResultEntry;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static RelocationBatchResultEntry success(Metadata metadata) {
        if (metadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchResultEntry().withTagAndSuccess(Tag.SUCCESS, metadata);
    }

    public Metadata getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isFailure() {
        return this._tag == Tag.FAILURE;
    }

    public static RelocationBatchResultEntry failure(RelocationBatchErrorEntry relocationBatchErrorEntry) {
        if (relocationBatchErrorEntry == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchResultEntry().withTagAndFailure(Tag.FAILURE, relocationBatchErrorEntry);
    }

    public RelocationBatchErrorEntry getFailureValue() {
        if (this._tag != Tag.FAILURE) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILURE, but was Tag." + this._tag.name());
        }
        return this.failureValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.failureValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RelocationBatchResultEntry)) {
            return false;
        }
        RelocationBatchResultEntry relocationBatchResultEntry = (RelocationBatchResultEntry) obj;
        if (this._tag != relocationBatchResultEntry._tag) {
            return false;
        }
        int i = C41881.f706xe16c8374[this._tag.ordinal()];
        if (i == 1) {
            Metadata metadata = this.successValue;
            Metadata metadata2 = relocationBatchResultEntry.successValue;
            return metadata == metadata2 || metadata.equals(metadata2);
        }
        if (i != 2) {
            return i == 3;
        }
        RelocationBatchErrorEntry relocationBatchErrorEntry = this.failureValue;
        RelocationBatchErrorEntry relocationBatchErrorEntry2 = relocationBatchResultEntry.failureValue;
        return relocationBatchErrorEntry == relocationBatchErrorEntry2 || relocationBatchErrorEntry.equals(relocationBatchErrorEntry2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.RelocationBatchResultEntry$1 */
    static /* synthetic */ class C41881 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$RelocationBatchResultEntry$Tag */
        static final /* synthetic */ int[] f706xe16c8374;

        static {
            int[] iArr = new int[Tag.values().length];
            f706xe16c8374 = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f706xe16c8374[Tag.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f706xe16c8374[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<RelocationBatchResultEntry> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RelocationBatchResultEntry relocationBatchResultEntry, JsonGenerator jsonGenerator) throws IOException {
            int i = C41881.f706xe16c8374[relocationBatchResultEntry.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.SUCCESS);
                Metadata.Serializer.INSTANCE.serialize(relocationBatchResultEntry.successValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("failure", jsonGenerator);
                jsonGenerator.writeFieldName("failure");
                RelocationBatchErrorEntry.Serializer.INSTANCE.serialize(relocationBatchResultEntry.failureValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RelocationBatchResultEntry deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RelocationBatchResultEntry relocationBatchResultEntryFailure;
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
                expectField(FirebaseAnalytics.Param.SUCCESS, jsonParser);
                relocationBatchResultEntryFailure = RelocationBatchResultEntry.success(Metadata.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("failure".equals(tag)) {
                expectField("failure", jsonParser);
                relocationBatchResultEntryFailure = RelocationBatchResultEntry.failure(RelocationBatchErrorEntry.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                relocationBatchResultEntryFailure = RelocationBatchResultEntry.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return relocationBatchResultEntryFailure;
        }
    }
}
