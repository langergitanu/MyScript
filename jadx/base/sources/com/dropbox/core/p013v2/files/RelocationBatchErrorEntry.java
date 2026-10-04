package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.RelocationError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RelocationBatchErrorEntry {
    private Tag _tag;
    private RelocationError relocationErrorValue;
    public static final RelocationBatchErrorEntry INTERNAL_ERROR = new RelocationBatchErrorEntry().withTag(Tag.INTERNAL_ERROR);
    public static final RelocationBatchErrorEntry TOO_MANY_WRITE_OPERATIONS = new RelocationBatchErrorEntry().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);
    public static final RelocationBatchErrorEntry OTHER = new RelocationBatchErrorEntry().withTag(Tag.OTHER);

    public enum Tag {
        RELOCATION_ERROR,
        INTERNAL_ERROR,
        TOO_MANY_WRITE_OPERATIONS,
        OTHER
    }

    private RelocationBatchErrorEntry() {
    }

    private RelocationBatchErrorEntry withTag(Tag tag) {
        RelocationBatchErrorEntry relocationBatchErrorEntry = new RelocationBatchErrorEntry();
        relocationBatchErrorEntry._tag = tag;
        return relocationBatchErrorEntry;
    }

    private RelocationBatchErrorEntry withTagAndRelocationError(Tag tag, RelocationError relocationError) {
        RelocationBatchErrorEntry relocationBatchErrorEntry = new RelocationBatchErrorEntry();
        relocationBatchErrorEntry._tag = tag;
        relocationBatchErrorEntry.relocationErrorValue = relocationError;
        return relocationBatchErrorEntry;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isRelocationError() {
        return this._tag == Tag.RELOCATION_ERROR;
    }

    public static RelocationBatchErrorEntry relocationError(RelocationError relocationError) {
        if (relocationError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchErrorEntry().withTagAndRelocationError(Tag.RELOCATION_ERROR, relocationError);
    }

    public RelocationError getRelocationErrorValue() {
        if (this._tag != Tag.RELOCATION_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.RELOCATION_ERROR, but was Tag." + this._tag.name());
        }
        return this.relocationErrorValue;
    }

    public boolean isInternalError() {
        return this._tag == Tag.INTERNAL_ERROR;
    }

    public boolean isTooManyWriteOperations() {
        return this._tag == Tag.TOO_MANY_WRITE_OPERATIONS;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.relocationErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RelocationBatchErrorEntry)) {
            return false;
        }
        RelocationBatchErrorEntry relocationBatchErrorEntry = (RelocationBatchErrorEntry) obj;
        if (this._tag != relocationBatchErrorEntry._tag) {
            return false;
        }
        int i = C41851.f704xf0678737[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4;
        }
        RelocationError relocationError = this.relocationErrorValue;
        RelocationError relocationError2 = relocationBatchErrorEntry.relocationErrorValue;
        return relocationError == relocationError2 || relocationError.equals(relocationError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.RelocationBatchErrorEntry$1 */
    static /* synthetic */ class C41851 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$RelocationBatchErrorEntry$Tag */
        static final /* synthetic */ int[] f704xf0678737;

        static {
            int[] iArr = new int[Tag.values().length];
            f704xf0678737 = iArr;
            try {
                iArr[Tag.RELOCATION_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f704xf0678737[Tag.INTERNAL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f704xf0678737[Tag.TOO_MANY_WRITE_OPERATIONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f704xf0678737[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<RelocationBatchErrorEntry> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RelocationBatchErrorEntry relocationBatchErrorEntry, JsonGenerator jsonGenerator) throws IOException {
            int i = C41851.f704xf0678737[relocationBatchErrorEntry.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("relocation_error", jsonGenerator);
                jsonGenerator.writeFieldName("relocation_error");
                RelocationError.Serializer.INSTANCE.serialize(relocationBatchErrorEntry.relocationErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("internal_error");
            } else if (i == 3) {
                jsonGenerator.writeString("too_many_write_operations");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RelocationBatchErrorEntry deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RelocationBatchErrorEntry relocationBatchErrorEntryRelocationError;
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
            if ("relocation_error".equals(tag)) {
                expectField("relocation_error", jsonParser);
                relocationBatchErrorEntryRelocationError = RelocationBatchErrorEntry.relocationError(RelocationError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("internal_error".equals(tag)) {
                relocationBatchErrorEntryRelocationError = RelocationBatchErrorEntry.INTERNAL_ERROR;
            } else if ("too_many_write_operations".equals(tag)) {
                relocationBatchErrorEntryRelocationError = RelocationBatchErrorEntry.TOO_MANY_WRITE_OPERATIONS;
            } else {
                relocationBatchErrorEntryRelocationError = RelocationBatchErrorEntry.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return relocationBatchErrorEntryRelocationError;
        }
    }
}
