package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.RelocationBatchV2Result;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RelocationBatchV2JobStatus {
    public static final RelocationBatchV2JobStatus IN_PROGRESS = new RelocationBatchV2JobStatus().withTag(Tag.IN_PROGRESS);
    private Tag _tag;
    private RelocationBatchV2Result completeValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE
    }

    private RelocationBatchV2JobStatus() {
    }

    private RelocationBatchV2JobStatus withTag(Tag tag) {
        RelocationBatchV2JobStatus relocationBatchV2JobStatus = new RelocationBatchV2JobStatus();
        relocationBatchV2JobStatus._tag = tag;
        return relocationBatchV2JobStatus;
    }

    private RelocationBatchV2JobStatus withTagAndComplete(Tag tag, RelocationBatchV2Result relocationBatchV2Result) {
        RelocationBatchV2JobStatus relocationBatchV2JobStatus = new RelocationBatchV2JobStatus();
        relocationBatchV2JobStatus._tag = tag;
        relocationBatchV2JobStatus.completeValue = relocationBatchV2Result;
        return relocationBatchV2JobStatus;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInProgress() {
        return this._tag == Tag.IN_PROGRESS;
    }

    public boolean isComplete() {
        return this._tag == Tag.COMPLETE;
    }

    public static RelocationBatchV2JobStatus complete(RelocationBatchV2Result relocationBatchV2Result) {
        if (relocationBatchV2Result == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchV2JobStatus().withTagAndComplete(Tag.COMPLETE, relocationBatchV2Result);
    }

    public RelocationBatchV2Result getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.completeValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RelocationBatchV2JobStatus)) {
            return false;
        }
        RelocationBatchV2JobStatus relocationBatchV2JobStatus = (RelocationBatchV2JobStatus) obj;
        if (this._tag != relocationBatchV2JobStatus._tag) {
            return false;
        }
        int i = C41891.f707x91099d12[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            RelocationBatchV2Result relocationBatchV2Result = this.completeValue;
            RelocationBatchV2Result relocationBatchV2Result2 = relocationBatchV2JobStatus.completeValue;
            if (relocationBatchV2Result != relocationBatchV2Result2 && !relocationBatchV2Result.equals(relocationBatchV2Result2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.RelocationBatchV2JobStatus$1 */
    static /* synthetic */ class C41891 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$RelocationBatchV2JobStatus$Tag */
        static final /* synthetic */ int[] f707x91099d12;

        static {
            int[] iArr = new int[Tag.values().length];
            f707x91099d12 = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f707x91099d12[Tag.COMPLETE.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<RelocationBatchV2JobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RelocationBatchV2JobStatus relocationBatchV2JobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C41891.f707x91099d12[relocationBatchV2JobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
            } else {
                if (i == 2) {
                    jsonGenerator.writeStartObject();
                    writeTag("complete", jsonGenerator);
                    RelocationBatchV2Result.Serializer.INSTANCE.serialize(relocationBatchV2JobStatus.completeValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + relocationBatchV2JobStatus.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RelocationBatchV2JobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RelocationBatchV2JobStatus relocationBatchV2JobStatusComplete;
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
            if ("in_progress".equals(tag)) {
                relocationBatchV2JobStatusComplete = RelocationBatchV2JobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                relocationBatchV2JobStatusComplete = RelocationBatchV2JobStatus.complete(RelocationBatchV2Result.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return relocationBatchV2JobStatusComplete;
        }
    }
}
