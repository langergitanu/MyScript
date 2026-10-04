package com.dropbox.core.p013v2.teamlog;

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

/* JADX INFO: loaded from: classes5.dex */
public class PaperFolderLogInfo {

    @Nonnull
    protected final String folderId;

    @Nonnull
    protected final String folderName;

    public PaperFolderLogInfo(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'folderId' is null");
        }
        this.folderId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'folderName' is null");
        }
        this.folderName = str2;
    }

    @Nonnull
    public String getFolderId() {
        return this.folderId;
    }

    @Nonnull
    public String getFolderName() {
        return this.folderName;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.folderId, this.folderName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperFolderLogInfo paperFolderLogInfo = (PaperFolderLogInfo) obj;
        String str3 = this.folderId;
        String str4 = paperFolderLogInfo.folderId;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.folderName) == (str2 = paperFolderLogInfo.folderName) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperFolderLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperFolderLogInfo paperFolderLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("folder_id");
            StoneSerializers.string().serialize(paperFolderLogInfo.folderId, jsonGenerator);
            jsonGenerator.writeFieldName("folder_name");
            StoneSerializers.string().serialize(paperFolderLogInfo.folderName, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperFolderLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("folder_name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"folder_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"folder_name\" missing.");
                }
                PaperFolderLogInfo paperFolderLogInfo = new PaperFolderLogInfo(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperFolderLogInfo, paperFolderLogInfo.toStringMultiline());
                return paperFolderLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
