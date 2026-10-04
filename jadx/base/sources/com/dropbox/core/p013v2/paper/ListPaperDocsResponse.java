package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.Cursor;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class ListPaperDocsResponse {

    @Nonnull
    protected final Cursor cursor;

    @Nonnull
    protected final List<String> docIds;
    protected final boolean hasMore;

    public ListPaperDocsResponse(@Nonnull List<String> list, @Nonnull Cursor cursor, boolean z) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'docIds' is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'docIds' is null");
            }
        }
        this.docIds = list;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = z;
    }

    @Nonnull
    public List<String> getDocIds() {
        return this.docIds;
    }

    @Nonnull
    public Cursor getCursor() {
        return this.cursor;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.docIds, this.cursor, Boolean.valueOf(this.hasMore)});
    }

    public boolean equals(Object obj) {
        ListPaperDocsResponse listPaperDocsResponse;
        List<String> list;
        List<String> list2;
        Cursor cursor;
        Cursor cursor2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.docIds) == (list2 = (listPaperDocsResponse = (ListPaperDocsResponse) obj).docIds) || list.equals(list2)) && (((cursor = this.cursor) == (cursor2 = listPaperDocsResponse.cursor) || cursor.equals(cursor2)) && this.hasMore == listPaperDocsResponse.hasMore);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListPaperDocsResponse> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListPaperDocsResponse listPaperDocsResponse, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("doc_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(listPaperDocsResponse.docIds, jsonGenerator);
            jsonGenerator.writeFieldName("cursor");
            Cursor.Serializer.INSTANCE.serialize(listPaperDocsResponse.cursor, jsonGenerator);
            jsonGenerator.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listPaperDocsResponse.hasMore), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListPaperDocsResponse deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Cursor cursorDeserialize = null;
                Boolean boolDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("doc_ids".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        cursorDeserialize = Cursor.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("has_more".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_ids\" missing.");
                }
                if (cursorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"cursor\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"has_more\" missing.");
                }
                ListPaperDocsResponse listPaperDocsResponse = new ListPaperDocsResponse(list, cursorDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listPaperDocsResponse, listPaperDocsResponse.toStringMultiline());
                return listPaperDocsResponse;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
