package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.ExportFormat;
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
class PaperDocExport extends RefPaperDoc {

    @Nonnull
    protected final ExportFormat exportFormat;

    public PaperDocExport(@Nonnull String str, @Nonnull ExportFormat exportFormat) {
        super(str);
        if (exportFormat == null) {
            throw new IllegalArgumentException("Required value for 'exportFormat' is null");
        }
        this.exportFormat = exportFormat;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    @Nonnull
    public String getDocId() {
        return this.docId;
    }

    @Nonnull
    public ExportFormat getExportFormat() {
        return this.exportFormat;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.exportFormat});
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public boolean equals(Object obj) {
        ExportFormat exportFormat;
        ExportFormat exportFormat2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperDocExport paperDocExport = (PaperDocExport) obj;
        return (this.docId == paperDocExport.docId || this.docId.equals(paperDocExport.docId)) && ((exportFormat = this.exportFormat) == (exportFormat2 = paperDocExport.exportFormat) || exportFormat.equals(exportFormat2));
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocExport> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocExport paperDocExport, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("doc_id");
            StoneSerializers.string().serialize(paperDocExport.docId, jsonGenerator);
            jsonGenerator.writeFieldName("export_format");
            ExportFormat.Serializer.INSTANCE.serialize(paperDocExport.exportFormat, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocExport deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ExportFormat exportFormatDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("doc_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("export_format".equals(currentName)) {
                        exportFormatDeserialize = ExportFormat.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_id\" missing.");
                }
                if (exportFormatDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"export_format\" missing.");
                }
                PaperDocExport paperDocExport = new PaperDocExport(strDeserialize, exportFormatDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocExport, paperDocExport.toStringMultiline());
                return paperDocExport;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
