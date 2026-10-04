package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.ImportFormat;
import com.dropbox.core.p013v2.paper.PaperDocUpdatePolicy;
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
class PaperDocUpdateArgs extends RefPaperDoc {

    @Nonnull
    protected final PaperDocUpdatePolicy docUpdatePolicy;

    @Nonnull
    protected final ImportFormat importFormat;
    protected final long revision;

    public PaperDocUpdateArgs(@Nonnull String str, @Nonnull PaperDocUpdatePolicy paperDocUpdatePolicy, long j, @Nonnull ImportFormat importFormat) {
        super(str);
        if (paperDocUpdatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'docUpdatePolicy' is null");
        }
        this.docUpdatePolicy = paperDocUpdatePolicy;
        this.revision = j;
        if (importFormat == null) {
            throw new IllegalArgumentException("Required value for 'importFormat' is null");
        }
        this.importFormat = importFormat;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    @Nonnull
    public String getDocId() {
        return this.docId;
    }

    @Nonnull
    public PaperDocUpdatePolicy getDocUpdatePolicy() {
        return this.docUpdatePolicy;
    }

    public long getRevision() {
        return this.revision;
    }

    @Nonnull
    public ImportFormat getImportFormat() {
        return this.importFormat;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.docUpdatePolicy, Long.valueOf(this.revision), this.importFormat});
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public boolean equals(Object obj) {
        PaperDocUpdatePolicy paperDocUpdatePolicy;
        PaperDocUpdatePolicy paperDocUpdatePolicy2;
        ImportFormat importFormat;
        ImportFormat importFormat2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            PaperDocUpdateArgs paperDocUpdateArgs = (PaperDocUpdateArgs) obj;
            if ((this.docId == paperDocUpdateArgs.docId || this.docId.equals(paperDocUpdateArgs.docId)) && (((paperDocUpdatePolicy = this.docUpdatePolicy) == (paperDocUpdatePolicy2 = paperDocUpdateArgs.docUpdatePolicy) || paperDocUpdatePolicy.equals(paperDocUpdatePolicy2)) && this.revision == paperDocUpdateArgs.revision && ((importFormat = this.importFormat) == (importFormat2 = paperDocUpdateArgs.importFormat) || importFormat.equals(importFormat2)))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocUpdateArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocUpdateArgs paperDocUpdateArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("doc_id");
            StoneSerializers.string().serialize(paperDocUpdateArgs.docId, jsonGenerator);
            jsonGenerator.writeFieldName("doc_update_policy");
            PaperDocUpdatePolicy.Serializer.INSTANCE.serialize(paperDocUpdateArgs.docUpdatePolicy, jsonGenerator);
            jsonGenerator.writeFieldName("revision");
            StoneSerializers.int64().serialize(Long.valueOf(paperDocUpdateArgs.revision), jsonGenerator);
            jsonGenerator.writeFieldName("import_format");
            ImportFormat.Serializer.INSTANCE.serialize(paperDocUpdateArgs.importFormat, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocUpdateArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                PaperDocUpdatePolicy paperDocUpdatePolicyDeserialize = null;
                ImportFormat importFormatDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("doc_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("doc_update_policy".equals(currentName)) {
                        paperDocUpdatePolicyDeserialize = PaperDocUpdatePolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("revision".equals(currentName)) {
                        lDeserialize = StoneSerializers.int64().deserialize(jsonParser);
                    } else if ("import_format".equals(currentName)) {
                        importFormatDeserialize = ImportFormat.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_id\" missing.");
                }
                if (paperDocUpdatePolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_update_policy\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"revision\" missing.");
                }
                if (importFormatDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"import_format\" missing.");
                }
                PaperDocUpdateArgs paperDocUpdateArgs = new PaperDocUpdateArgs(strDeserialize, paperDocUpdatePolicyDeserialize, lDeserialize.longValue(), importFormatDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocUpdateArgs, paperDocUpdateArgs.toStringMultiline());
                return paperDocUpdateArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
