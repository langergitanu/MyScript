package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PaperDownloadFormat;
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
public class PaperDocDownloadDetails {

    @Nonnull
    protected final String eventUuid;

    @Nonnull
    protected final PaperDownloadFormat exportFileFormat;

    public PaperDocDownloadDetails(@Nonnull String str, @Nonnull PaperDownloadFormat paperDownloadFormat) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        if (paperDownloadFormat == null) {
            throw new IllegalArgumentException("Required value for 'exportFileFormat' is null");
        }
        this.exportFileFormat = paperDownloadFormat;
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    @Nonnull
    public PaperDownloadFormat getExportFileFormat() {
        return this.exportFileFormat;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.exportFileFormat});
    }

    public boolean equals(Object obj) {
        PaperDownloadFormat paperDownloadFormat;
        PaperDownloadFormat paperDownloadFormat2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperDocDownloadDetails paperDocDownloadDetails = (PaperDocDownloadDetails) obj;
        String str = this.eventUuid;
        String str2 = paperDocDownloadDetails.eventUuid;
        return (str == str2 || str.equals(str2)) && ((paperDownloadFormat = this.exportFileFormat) == (paperDownloadFormat2 = paperDocDownloadDetails.exportFileFormat) || paperDownloadFormat.equals(paperDownloadFormat2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocDownloadDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocDownloadDetails paperDocDownloadDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(paperDocDownloadDetails.eventUuid, jsonGenerator);
            jsonGenerator.writeFieldName("export_file_format");
            PaperDownloadFormat.Serializer.INSTANCE.serialize(paperDocDownloadDetails.exportFileFormat, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocDownloadDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PaperDownloadFormat paperDownloadFormatDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("event_uuid".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("export_file_format".equals(currentName)) {
                        paperDownloadFormatDeserialize = PaperDownloadFormat.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                if (paperDownloadFormatDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"export_file_format\" missing.");
                }
                PaperDocDownloadDetails paperDocDownloadDetails = new PaperDocDownloadDetails(strDeserialize, paperDownloadFormatDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocDownloadDetails, paperDocDownloadDetails.toStringMultiline());
                return paperDocDownloadDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
