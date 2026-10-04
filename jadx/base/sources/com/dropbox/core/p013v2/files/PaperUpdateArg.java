package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.ImportFormat;
import com.dropbox.core.p013v2.files.PaperDocUpdatePolicy;
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
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class PaperUpdateArg {

    @Nonnull
    protected final PaperDocUpdatePolicy docUpdatePolicy;

    @Nonnull
    protected final ImportFormat importFormat;

    @Nullable
    protected final Long paperRevision;

    @Nonnull
    protected final String path;

    public PaperUpdateArg(@Nonnull String str, @Nonnull ImportFormat importFormat, @Nonnull PaperDocUpdatePolicy paperDocUpdatePolicy, @Nullable Long l) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (importFormat == null) {
            throw new IllegalArgumentException("Required value for 'importFormat' is null");
        }
        this.importFormat = importFormat;
        if (paperDocUpdatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'docUpdatePolicy' is null");
        }
        this.docUpdatePolicy = paperDocUpdatePolicy;
        this.paperRevision = l;
    }

    public PaperUpdateArg(@Nonnull String str, @Nonnull ImportFormat importFormat, @Nonnull PaperDocUpdatePolicy paperDocUpdatePolicy) {
        this(str, importFormat, paperDocUpdatePolicy, null);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nonnull
    public ImportFormat getImportFormat() {
        return this.importFormat;
    }

    @Nonnull
    public PaperDocUpdatePolicy getDocUpdatePolicy() {
        return this.docUpdatePolicy;
    }

    @Nullable
    public Long getPaperRevision() {
        return this.paperRevision;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.importFormat, this.docUpdatePolicy, this.paperRevision});
    }

    public boolean equals(Object obj) {
        ImportFormat importFormat;
        ImportFormat importFormat2;
        PaperDocUpdatePolicy paperDocUpdatePolicy;
        PaperDocUpdatePolicy paperDocUpdatePolicy2;
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperUpdateArg paperUpdateArg = (PaperUpdateArg) obj;
        String str = this.path;
        String str2 = paperUpdateArg.path;
        return (str == str2 || str.equals(str2)) && ((importFormat = this.importFormat) == (importFormat2 = paperUpdateArg.importFormat) || importFormat.equals(importFormat2)) && (((paperDocUpdatePolicy = this.docUpdatePolicy) == (paperDocUpdatePolicy2 = paperUpdateArg.docUpdatePolicy) || paperDocUpdatePolicy.equals(paperDocUpdatePolicy2)) && ((l = this.paperRevision) == (l2 = paperUpdateArg.paperRevision) || (l != null && l.equals(l2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperUpdateArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperUpdateArg paperUpdateArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(paperUpdateArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("import_format");
            ImportFormat.Serializer.INSTANCE.serialize(paperUpdateArg.importFormat, jsonGenerator);
            jsonGenerator.writeFieldName("doc_update_policy");
            PaperDocUpdatePolicy.Serializer.INSTANCE.serialize(paperUpdateArg.docUpdatePolicy, jsonGenerator);
            if (paperUpdateArg.paperRevision != null) {
                jsonGenerator.writeFieldName("paper_revision");
                StoneSerializers.nullable(StoneSerializers.int64()).serialize(paperUpdateArg.paperRevision, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperUpdateArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                PaperDocUpdatePolicy paperDocUpdatePolicyDeserialize = null;
                Long l = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("import_format".equals(currentName)) {
                        importFormatDeserialize = ImportFormat.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("doc_update_policy".equals(currentName)) {
                        paperDocUpdatePolicyDeserialize = PaperDocUpdatePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("paper_revision".equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.int64()).deserialize(jsonParser);
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
                if (paperDocUpdatePolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_update_policy\" missing.");
                }
                PaperUpdateArg paperUpdateArg = new PaperUpdateArg(strDeserialize, importFormatDeserialize, paperDocUpdatePolicyDeserialize, l);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperUpdateArg, paperUpdateArg.toStringMultiline());
                return paperUpdateArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
