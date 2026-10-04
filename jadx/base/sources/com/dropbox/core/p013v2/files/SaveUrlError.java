package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.WriteError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class SaveUrlError {
    public static final SaveUrlError DOWNLOAD_FAILED = new SaveUrlError().withTag(Tag.DOWNLOAD_FAILED);
    public static final SaveUrlError INVALID_URL = new SaveUrlError().withTag(Tag.INVALID_URL);
    public static final SaveUrlError NOT_FOUND = new SaveUrlError().withTag(Tag.NOT_FOUND);
    public static final SaveUrlError OTHER = new SaveUrlError().withTag(Tag.OTHER);
    private Tag _tag;
    private WriteError pathValue;

    public enum Tag {
        PATH,
        DOWNLOAD_FAILED,
        INVALID_URL,
        NOT_FOUND,
        OTHER
    }

    private SaveUrlError() {
    }

    private SaveUrlError withTag(Tag tag) {
        SaveUrlError saveUrlError = new SaveUrlError();
        saveUrlError._tag = tag;
        return saveUrlError;
    }

    private SaveUrlError withTagAndPath(Tag tag, WriteError writeError) {
        SaveUrlError saveUrlError = new SaveUrlError();
        saveUrlError._tag = tag;
        saveUrlError.pathValue = writeError;
        return saveUrlError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static SaveUrlError path(WriteError writeError) {
        if (writeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SaveUrlError().withTagAndPath(Tag.PATH, writeError);
    }

    public WriteError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isDownloadFailed() {
        return this._tag == Tag.DOWNLOAD_FAILED;
    }

    public boolean isInvalidUrl() {
        return this._tag == Tag.INVALID_URL;
    }

    public boolean isNotFound() {
        return this._tag == Tag.NOT_FOUND;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof SaveUrlError)) {
            return false;
        }
        SaveUrlError saveUrlError = (SaveUrlError) obj;
        if (this._tag != saveUrlError._tag) {
            return false;
        }
        int i = C41951.$SwitchMap$com$dropbox$core$v2$files$SaveUrlError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4 || i == 5;
        }
        WriteError writeError = this.pathValue;
        WriteError writeError2 = saveUrlError.pathValue;
        return writeError == writeError2 || writeError.equals(writeError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SaveUrlError$1 */
    static /* synthetic */ class C41951 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SaveUrlError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SaveUrlError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveUrlError$Tag[Tag.DOWNLOAD_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveUrlError$Tag[Tag.INVALID_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveUrlError$Tag[Tag.NOT_FOUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SaveUrlError$Tag[Tag.OTHER.ordinal()] = 5;
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

    static class Serializer extends UnionSerializer<SaveUrlError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SaveUrlError saveUrlError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41951.$SwitchMap$com$dropbox$core$v2$files$SaveUrlError$Tag[saveUrlError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                WriteError.Serializer.INSTANCE.serialize(saveUrlError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("download_failed");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("invalid_url");
            } else if (i == 4) {
                jsonGenerator.writeString("not_found");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SaveUrlError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SaveUrlError saveUrlErrorPath;
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
            if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                saveUrlErrorPath = SaveUrlError.path(WriteError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("download_failed".equals(tag)) {
                saveUrlErrorPath = SaveUrlError.DOWNLOAD_FAILED;
            } else if ("invalid_url".equals(tag)) {
                saveUrlErrorPath = SaveUrlError.INVALID_URL;
            } else if ("not_found".equals(tag)) {
                saveUrlErrorPath = SaveUrlError.NOT_FOUND;
            } else {
                saveUrlErrorPath = SaveUrlError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return saveUrlErrorPath;
        }
    }
}
