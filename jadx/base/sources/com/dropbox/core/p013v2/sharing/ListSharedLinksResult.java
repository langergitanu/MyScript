package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedLinkMetadata;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ListSharedLinksResult {

    @Nullable
    protected final String cursor;
    protected final boolean hasMore;

    @Nonnull
    protected final List<SharedLinkMetadata> links;

    public ListSharedLinksResult(@Nonnull List<SharedLinkMetadata> list, boolean z, @Nullable String str) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'links' is null");
        }
        Iterator<SharedLinkMetadata> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'links' is null");
            }
        }
        this.links = list;
        this.hasMore = z;
        this.cursor = str;
    }

    public ListSharedLinksResult(@Nonnull List<SharedLinkMetadata> list, boolean z) {
        this(list, z, null);
    }

    @Nonnull
    public List<SharedLinkMetadata> getLinks() {
        return this.links;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    @Nullable
    public String getCursor() {
        return this.cursor;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.links, Boolean.valueOf(this.hasMore), this.cursor});
    }

    public boolean equals(Object obj) {
        ListSharedLinksResult listSharedLinksResult;
        List<SharedLinkMetadata> list;
        List<SharedLinkMetadata> list2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.links) == (list2 = (listSharedLinksResult = (ListSharedLinksResult) obj).links) || list.equals(list2)) && this.hasMore == listSharedLinksResult.hasMore && ((str = this.cursor) == (str2 = listSharedLinksResult.cursor) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListSharedLinksResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListSharedLinksResult listSharedLinksResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("links");
            StoneSerializers.list(SharedLinkMetadata.Serializer.INSTANCE).serialize(listSharedLinksResult.links, jsonGenerator);
            jsonGenerator.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listSharedLinksResult.hasMore), jsonGenerator);
            if (listSharedLinksResult.cursor != null) {
                jsonGenerator.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(listSharedLinksResult.cursor, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListSharedLinksResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("links".equals(currentName)) {
                        list = (List) StoneSerializers.list(SharedLinkMetadata.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("has_more".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"links\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"has_more\" missing.");
                }
                ListSharedLinksResult listSharedLinksResult = new ListSharedLinksResult(list, boolDeserialize.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listSharedLinksResult, listSharedLinksResult.toStringMultiline());
                return listSharedLinksResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
