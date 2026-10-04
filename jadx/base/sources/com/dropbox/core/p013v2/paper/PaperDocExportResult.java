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
public class PaperDocExportResult {

    @Nonnull
    protected final String mimeType;

    @Nonnull
    protected final String owner;
    protected final long revision;

    @Nonnull
    protected final String title;

    public PaperDocExportResult(@Nonnull String str, @Nonnull String str2, long j, @Nonnull String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'owner' is null");
        }
        this.owner = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'title' is null");
        }
        this.title = str2;
        this.revision = j;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'mimeType' is null");
        }
        this.mimeType = str3;
    }

    @Nonnull
    public String getOwner() {
        return this.owner;
    }

    @Nonnull
    public String getTitle() {
        return this.title;
    }

    public long getRevision() {
        return this.revision;
    }

    @Nonnull
    public String getMimeType() {
        return this.mimeType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.owner, this.title, Long.valueOf(this.revision), this.mimeType});
    }

    public boolean equals(Object obj) {
        PaperDocExportResult paperDocExportResult;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.owner) == (str2 = (paperDocExportResult = (PaperDocExportResult) obj).owner) || str.equals(str2)) && (((str3 = this.title) == (str4 = paperDocExportResult.title) || str3.equals(str4)) && this.revision == paperDocExportResult.revision && ((str5 = this.mimeType) == (str6 = paperDocExportResult.mimeType) || str5.equals(str6)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocExportResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocExportResult paperDocExportResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("owner");
            StoneSerializers.string().serialize(paperDocExportResult.owner, jsonGenerator);
            jsonGenerator.writeFieldName("title");
            StoneSerializers.string().serialize(paperDocExportResult.title, jsonGenerator);
            jsonGenerator.writeFieldName("revision");
            StoneSerializers.int64().serialize(Long.valueOf(paperDocExportResult.revision), jsonGenerator);
            jsonGenerator.writeFieldName("mime_type");
            StoneSerializers.string().serialize(paperDocExportResult.mimeType, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocExportResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("owner".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("title".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("revision".equals(currentName)) {
                        lDeserialize = StoneSerializers.int64().deserialize(jsonParser);
                    } else if ("mime_type".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"owner\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"title\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"revision\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"mime_type\" missing.");
                }
                PaperDocExportResult paperDocExportResult = new PaperDocExportResult(strDeserialize, strDeserialize2, lDeserialize.longValue(), strDeserialize3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocExportResult, paperDocExportResult.toStringMultiline());
                return paperDocExportResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
