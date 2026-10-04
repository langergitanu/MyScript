package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.LinkMetadata;
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
public class GetSharedLinksResult {

    @Nonnull
    protected final List<LinkMetadata> links;

    public GetSharedLinksResult(@Nonnull List<LinkMetadata> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'links' is null");
        }
        Iterator<LinkMetadata> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'links' is null");
            }
        }
        this.links = list;
    }

    @Nonnull
    public List<LinkMetadata> getLinks() {
        return this.links;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.links});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<LinkMetadata> list = this.links;
        List<LinkMetadata> list2 = ((GetSharedLinksResult) obj).links;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetSharedLinksResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetSharedLinksResult getSharedLinksResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("links");
            StoneSerializers.list(LinkMetadata.Serializer.INSTANCE).serialize(getSharedLinksResult.links, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetSharedLinksResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("links".equals(currentName)) {
                        list = (List) StoneSerializers.list(LinkMetadata.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"links\" missing.");
                }
                GetSharedLinksResult getSharedLinksResult = new GetSharedLinksResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getSharedLinksResult, getSharedLinksResult.toStringMultiline());
                return getSharedLinksResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
