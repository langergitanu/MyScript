package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class ListFileMembersBatchArg {

    @Nonnull
    protected final List<String> files;
    protected final long limit;

    public ListFileMembersBatchArg(@Nonnull List<String> list, long j) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'files' is null");
        }
        if (list.size() > 100) {
            throw new IllegalArgumentException("List 'files' has more than 100 items");
        }
        for (String str : list) {
            if (str == null) {
                throw new IllegalArgumentException("An item in list 'files' is null");
            }
            if (str.length() < 1) {
                throw new IllegalArgumentException("Stringan item in list 'files' is shorter than 1");
            }
            if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", str)) {
                throw new IllegalArgumentException("Stringan item in list 'files' does not match pattern");
            }
        }
        this.files = list;
        if (j > 20) {
            throw new IllegalArgumentException("Number 'limit' is larger than 20L");
        }
        this.limit = j;
    }

    public ListFileMembersBatchArg(@Nonnull List<String> list) {
        this(list, 10L);
    }

    @Nonnull
    public List<String> getFiles() {
        return this.files;
    }

    public long getLimit() {
        return this.limit;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.files, Long.valueOf(this.limit)});
    }

    public boolean equals(Object obj) {
        ListFileMembersBatchArg listFileMembersBatchArg;
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.files) == (list2 = (listFileMembersBatchArg = (ListFileMembersBatchArg) obj).files) || list.equals(list2)) && this.limit == listFileMembersBatchArg.limit;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListFileMembersBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListFileMembersBatchArg listFileMembersBatchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("files");
            StoneSerializers.list(StoneSerializers.string()).serialize(listFileMembersBatchArg.files, jsonGenerator);
            jsonGenerator.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(Long.valueOf(listFileMembersBatchArg.limit), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListFileMembersBatchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = 10L;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("files".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("limit".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"files\" missing.");
                }
                ListFileMembersBatchArg listFileMembersBatchArg = new ListFileMembersBatchArg(list, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listFileMembersBatchArg, listFileMembersBatchArg.toStringMultiline());
                return listFileMembersBatchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
