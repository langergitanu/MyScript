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
public final class CreateFolderError {
    private Tag _tag;
    private WriteError pathValue;

    public enum Tag {
        PATH
    }

    private CreateFolderError() {
    }

    private CreateFolderError withTag(Tag tag) {
        CreateFolderError createFolderError = new CreateFolderError();
        createFolderError._tag = tag;
        return createFolderError;
    }

    private CreateFolderError withTagAndPath(Tag tag, WriteError writeError) {
        CreateFolderError createFolderError = new CreateFolderError();
        createFolderError._tag = tag;
        createFolderError.pathValue = writeError;
        return createFolderError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static CreateFolderError path(WriteError writeError) {
        if (writeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateFolderError().withTagAndPath(Tag.PATH, writeError);
    }

    public WriteError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateFolderError)) {
            return false;
        }
        CreateFolderError createFolderError = (CreateFolderError) obj;
        if (this._tag != createFolderError._tag || C41491.$SwitchMap$com$dropbox$core$v2$files$CreateFolderError$Tag[this._tag.ordinal()] != 1) {
            return false;
        }
        WriteError writeError = this.pathValue;
        WriteError writeError2 = createFolderError.pathValue;
        return writeError == writeError2 || writeError.equals(writeError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.CreateFolderError$1 */
    static /* synthetic */ class C41491 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$CreateFolderError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$CreateFolderError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<CreateFolderError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CreateFolderError createFolderError, JsonGenerator jsonGenerator) throws IOException {
            if (C41491.$SwitchMap$com$dropbox$core$v2$files$CreateFolderError$Tag[createFolderError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                WriteError.Serializer.INSTANCE.serialize(createFolderError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + createFolderError.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CreateFolderError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
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
                CreateFolderError createFolderErrorPath = CreateFolderError.path(WriteError.Serializer.INSTANCE.deserialize(jsonParser));
                if (!z) {
                    skipFields(jsonParser);
                    expectEndObject(jsonParser);
                }
                return createFolderErrorPath;
            }
            throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
        }
    }
}
