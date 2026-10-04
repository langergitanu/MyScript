package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.p013v2.files.WriteError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RestoreError {
    public static final RestoreError INVALID_REVISION = new RestoreError().withTag(Tag.INVALID_REVISION);
    public static final RestoreError IN_PROGRESS = new RestoreError().withTag(Tag.IN_PROGRESS);
    public static final RestoreError OTHER = new RestoreError().withTag(Tag.OTHER);
    private Tag _tag;
    private LookupError pathLookupValue;
    private WriteError pathWriteValue;

    public enum Tag {
        PATH_LOOKUP,
        PATH_WRITE,
        INVALID_REVISION,
        IN_PROGRESS,
        OTHER
    }

    private RestoreError() {
    }

    private RestoreError withTag(Tag tag) {
        RestoreError restoreError = new RestoreError();
        restoreError._tag = tag;
        return restoreError;
    }

    private RestoreError withTagAndPathLookup(Tag tag, LookupError lookupError) {
        RestoreError restoreError = new RestoreError();
        restoreError._tag = tag;
        restoreError.pathLookupValue = lookupError;
        return restoreError;
    }

    private RestoreError withTagAndPathWrite(Tag tag, WriteError writeError) {
        RestoreError restoreError = new RestoreError();
        restoreError._tag = tag;
        restoreError.pathWriteValue = writeError;
        return restoreError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPathLookup() {
        return this._tag == Tag.PATH_LOOKUP;
    }

    public static RestoreError pathLookup(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RestoreError().withTagAndPathLookup(Tag.PATH_LOOKUP, lookupError);
    }

    public LookupError getPathLookupValue() {
        if (this._tag != Tag.PATH_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_LOOKUP, but was Tag." + this._tag.name());
        }
        return this.pathLookupValue;
    }

    public boolean isPathWrite() {
        return this._tag == Tag.PATH_WRITE;
    }

    public static RestoreError pathWrite(WriteError writeError) {
        if (writeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RestoreError().withTagAndPathWrite(Tag.PATH_WRITE, writeError);
    }

    public WriteError getPathWriteValue() {
        if (this._tag != Tag.PATH_WRITE) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_WRITE, but was Tag." + this._tag.name());
        }
        return this.pathWriteValue;
    }

    public boolean isInvalidRevision() {
        return this._tag == Tag.INVALID_REVISION;
    }

    public boolean isInProgress() {
        return this._tag == Tag.IN_PROGRESS;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathLookupValue, this.pathWriteValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RestoreError)) {
            return false;
        }
        RestoreError restoreError = (RestoreError) obj;
        if (this._tag != restoreError._tag) {
            return false;
        }
        int i = C41931.$SwitchMap$com$dropbox$core$v2$files$RestoreError$Tag[this._tag.ordinal()];
        if (i == 1) {
            LookupError lookupError = this.pathLookupValue;
            LookupError lookupError2 = restoreError.pathLookupValue;
            return lookupError == lookupError2 || lookupError.equals(lookupError2);
        }
        if (i != 2) {
            return i == 3 || i == 4 || i == 5;
        }
        WriteError writeError = this.pathWriteValue;
        WriteError writeError2 = restoreError.pathWriteValue;
        return writeError == writeError2 || writeError.equals(writeError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.RestoreError$1 */
    static /* synthetic */ class C41931 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$RestoreError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$RestoreError$Tag = iArr;
            try {
                iArr[Tag.PATH_LOOKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RestoreError$Tag[Tag.PATH_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RestoreError$Tag[Tag.INVALID_REVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RestoreError$Tag[Tag.IN_PROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RestoreError$Tag[Tag.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<RestoreError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RestoreError restoreError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41931.$SwitchMap$com$dropbox$core$v2$files$RestoreError$Tag[restoreError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("path_lookup", jsonGenerator);
                jsonGenerator.writeFieldName("path_lookup");
                LookupError.Serializer.INSTANCE.serialize(restoreError.pathLookupValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("path_write", jsonGenerator);
                jsonGenerator.writeFieldName("path_write");
                WriteError.Serializer.INSTANCE.serialize(restoreError.pathWriteValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("invalid_revision");
            } else if (i == 4) {
                jsonGenerator.writeString("in_progress");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RestoreError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RestoreError restoreErrorPathWrite;
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
            if ("path_lookup".equals(tag)) {
                expectField("path_lookup", jsonParser);
                restoreErrorPathWrite = RestoreError.pathLookup(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("path_write".equals(tag)) {
                expectField("path_write", jsonParser);
                restoreErrorPathWrite = RestoreError.pathWrite(WriteError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("invalid_revision".equals(tag)) {
                restoreErrorPathWrite = RestoreError.INVALID_REVISION;
            } else if ("in_progress".equals(tag)) {
                restoreErrorPathWrite = RestoreError.IN_PROGRESS;
            } else {
                restoreErrorPathWrite = RestoreError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return restoreErrorPathWrite;
        }
    }
}
