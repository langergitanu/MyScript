package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class ListUsersOnFolderContinueArgs extends RefPaperDoc {

    @Nonnull
    protected final String cursor;

    public ListUsersOnFolderContinueArgs(@Nonnull String str, @Nonnull String str2) {
        super(str);
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = str2;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    @Nonnull
    public String getDocId() {
        return this.docId;
    }

    @Nonnull
    public String getCursor() {
        return this.cursor;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.cursor});
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ListUsersOnFolderContinueArgs listUsersOnFolderContinueArgs = (ListUsersOnFolderContinueArgs) obj;
        return (this.docId == listUsersOnFolderContinueArgs.docId || this.docId.equals(listUsersOnFolderContinueArgs.docId)) && ((str = this.cursor) == (str2 = listUsersOnFolderContinueArgs.cursor) || str.equals(str2));
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListUsersOnFolderContinueArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListUsersOnFolderContinueArgs listUsersOnFolderContinueArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("doc_id");
            StoneSerializers.string().serialize(listUsersOnFolderContinueArgs.docId, jsonGenerator);
            jsonGenerator.writeFieldName("cursor");
            StoneSerializers.string().serialize(listUsersOnFolderContinueArgs.cursor, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListUsersOnFolderContinueArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("doc_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"cursor\" missing.");
                }
                ListUsersOnFolderContinueArgs listUsersOnFolderContinueArgs = new ListUsersOnFolderContinueArgs(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listUsersOnFolderContinueArgs, listUsersOnFolderContinueArgs.toStringMultiline());
                return listUsersOnFolderContinueArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
