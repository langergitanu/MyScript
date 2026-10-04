package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.ImportFormat;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class PaperCreateArg {

    @Nonnull
    protected final ImportFormat importFormat;

    @Nonnull
    protected final String path;

    public PaperCreateArg(@Nonnull String str, @Nonnull ImportFormat importFormat) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (importFormat == null) {
            throw new IllegalArgumentException("Required value for 'importFormat' is null");
        }
        this.importFormat = importFormat;
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nonnull
    public ImportFormat getImportFormat() {
        return this.importFormat;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.importFormat});
    }

    public boolean equals(Object obj) {
        ImportFormat importFormat;
        ImportFormat importFormat2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperCreateArg paperCreateArg = (PaperCreateArg) obj;
        String str = this.path;
        String str2 = paperCreateArg.path;
        return (str == str2 || str.equals(str2)) && ((importFormat = this.importFormat) == (importFormat2 = paperCreateArg.importFormat) || importFormat.equals(importFormat2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperCreateArg paperCreateArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(paperCreateArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("import_format");
            ImportFormat.Serializer.INSTANCE.serialize(paperCreateArg.importFormat, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperCreateArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ImportFormat importFormatDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("import_format".equals(currentName)) {
                        importFormatDeserialize = ImportFormat.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                if (importFormatDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"import_format\" missing.");
                }
                PaperCreateArg paperCreateArg = new PaperCreateArg(strDeserialize, importFormatDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperCreateArg, paperCreateArg.toStringMultiline());
                return paperCreateArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
