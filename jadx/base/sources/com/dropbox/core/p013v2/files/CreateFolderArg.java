package com.dropbox.core.p013v2.files;

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
class CreateFolderArg {
    protected final boolean autorename;

    @Nonnull
    protected final String path;

    public CreateFolderArg(@Nonnull String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        this.autorename = z;
    }

    public CreateFolderArg(@Nonnull String str) {
        this(str, false);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    public boolean getAutorename() {
        return this.autorename;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, Boolean.valueOf(this.autorename)});
    }

    public boolean equals(Object obj) {
        CreateFolderArg createFolderArg;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.path) == (str2 = (createFolderArg = (CreateFolderArg) obj).path) || str.equals(str2)) && this.autorename == createFolderArg.autorename;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CreateFolderArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CreateFolderArg createFolderArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(createFolderArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(createFolderArg.autorename), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public CreateFolderArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("autorename".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                CreateFolderArg createFolderArg = new CreateFolderArg(strDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(createFolderArg, createFolderArg.toStringMultiline());
                return createFolderArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
