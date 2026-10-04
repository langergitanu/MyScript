package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.ImportFormat;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class PaperDocCreateArgs {

    @Nonnull
    protected final ImportFormat importFormat;

    @Nullable
    protected final String parentFolderId;

    public PaperDocCreateArgs(@Nonnull ImportFormat importFormat, @Nullable String str) {
        this.parentFolderId = str;
        if (importFormat == null) {
            throw new IllegalArgumentException("Required value for 'importFormat' is null");
        }
        this.importFormat = importFormat;
    }

    public PaperDocCreateArgs(@Nonnull ImportFormat importFormat) {
        this(importFormat, null);
    }

    @Nonnull
    public ImportFormat getImportFormat() {
        return this.importFormat;
    }

    @Nullable
    public String getParentFolderId() {
        return this.parentFolderId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.parentFolderId, this.importFormat});
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
        PaperDocCreateArgs paperDocCreateArgs = (PaperDocCreateArgs) obj;
        ImportFormat importFormat = this.importFormat;
        ImportFormat importFormat2 = paperDocCreateArgs.importFormat;
        return (importFormat == importFormat2 || importFormat.equals(importFormat2)) && ((str = this.parentFolderId) == (str2 = paperDocCreateArgs.parentFolderId) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocCreateArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocCreateArgs paperDocCreateArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("import_format");
            ImportFormat.Serializer.INSTANCE.serialize(paperDocCreateArgs.importFormat, jsonGenerator);
            if (paperDocCreateArgs.parentFolderId != null) {
                jsonGenerator.writeFieldName("parent_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(paperDocCreateArgs.parentFolderId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocCreateArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ImportFormat importFormatDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("import_format".equals(currentName)) {
                        importFormatDeserialize = ImportFormat.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("parent_folder_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (importFormatDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"import_format\" missing.");
                }
                PaperDocCreateArgs paperDocCreateArgs = new PaperDocCreateArgs(importFormatDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocCreateArgs, paperDocCreateArgs.toStringMultiline());
                return paperDocCreateArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
