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
public class PaperDocCreateUpdateResult {

    @Nonnull
    protected final String docId;
    protected final long revision;

    @Nonnull
    protected final String title;

    public PaperDocCreateUpdateResult(@Nonnull String str, long j, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'docId' is null");
        }
        this.docId = str;
        this.revision = j;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'title' is null");
        }
        this.title = str2;
    }

    @Nonnull
    public String getDocId() {
        return this.docId;
    }

    public long getRevision() {
        return this.revision;
    }

    @Nonnull
    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.docId, Long.valueOf(this.revision), this.title});
    }

    public boolean equals(Object obj) {
        PaperDocCreateUpdateResult paperDocCreateUpdateResult;
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.docId) == (str2 = (paperDocCreateUpdateResult = (PaperDocCreateUpdateResult) obj).docId) || str.equals(str2)) && this.revision == paperDocCreateUpdateResult.revision && ((str3 = this.title) == (str4 = paperDocCreateUpdateResult.title) || str3.equals(str4));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDocCreateUpdateResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDocCreateUpdateResult paperDocCreateUpdateResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("doc_id");
            StoneSerializers.string().serialize(paperDocCreateUpdateResult.docId, jsonGenerator);
            jsonGenerator.writeFieldName("revision");
            StoneSerializers.int64().serialize(Long.valueOf(paperDocCreateUpdateResult.revision), jsonGenerator);
            jsonGenerator.writeFieldName("title");
            StoneSerializers.string().serialize(paperDocCreateUpdateResult.title, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDocCreateUpdateResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = null;
                String strDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("doc_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("revision".equals(currentName)) {
                        lDeserialize = StoneSerializers.int64().deserialize(jsonParser);
                    } else if ("title".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_id\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"revision\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"title\" missing.");
                }
                PaperDocCreateUpdateResult paperDocCreateUpdateResult = new PaperDocCreateUpdateResult(strDeserialize, lDeserialize.longValue(), strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDocCreateUpdateResult, paperDocCreateUpdateResult.toStringMultiline());
                return paperDocCreateUpdateResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
