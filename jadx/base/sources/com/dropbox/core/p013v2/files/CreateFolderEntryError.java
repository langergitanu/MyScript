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
public final class CreateFolderEntryError {
    public static final CreateFolderEntryError OTHER = new CreateFolderEntryError().withTag(Tag.OTHER);
    private Tag _tag;
    private WriteError pathValue;

    public enum Tag {
        PATH,
        OTHER
    }

    private CreateFolderEntryError() {
    }

    private CreateFolderEntryError withTag(Tag tag) {
        CreateFolderEntryError createFolderEntryError = new CreateFolderEntryError();
        createFolderEntryError._tag = tag;
        return createFolderEntryError;
    }

    private CreateFolderEntryError withTagAndPath(Tag tag, WriteError writeError) {
        CreateFolderEntryError createFolderEntryError = new CreateFolderEntryError();
        createFolderEntryError._tag = tag;
        createFolderEntryError.pathValue = writeError;
        return createFolderEntryError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static CreateFolderEntryError path(WriteError writeError) {
        if (writeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateFolderEntryError().withTagAndPath(Tag.PATH, writeError);
    }

    public WriteError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
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
        if (obj == null || !(obj instanceof CreateFolderEntryError)) {
            return false;
        }
        CreateFolderEntryError createFolderEntryError = (CreateFolderEntryError) obj;
        if (this._tag != createFolderEntryError._tag) {
            return false;
        }
        int i = C41481.$SwitchMap$com$dropbox$core$v2$files$CreateFolderEntryError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        WriteError writeError = this.pathValue;
        WriteError writeError2 = createFolderEntryError.pathValue;
        return writeError == writeError2 || writeError.equals(writeError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.CreateFolderEntryError$1 */
    static /* synthetic */ class C41481 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$CreateFolderEntryError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$CreateFolderEntryError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$CreateFolderEntryError$Tag[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<CreateFolderEntryError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CreateFolderEntryError createFolderEntryError, JsonGenerator jsonGenerator) throws IOException {
            if (C41481.$SwitchMap$com$dropbox$core$v2$files$CreateFolderEntryError$Tag[createFolderEntryError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                WriteError.Serializer.INSTANCE.serialize(createFolderEntryError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CreateFolderEntryError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CreateFolderEntryError createFolderEntryErrorPath;
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
                createFolderEntryErrorPath = CreateFolderEntryError.path(WriteError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                createFolderEntryErrorPath = CreateFolderEntryError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return createFolderEntryErrorPath;
        }
    }
}
