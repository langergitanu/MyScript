package com.dropbox.core.p013v2.files;

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
class ListFolderLongpollArg {

    @Nonnull
    protected final String cursor;
    protected final long timeout;

    public ListFolderLongpollArg(@Nonnull String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'cursor' is shorter than 1");
        }
        this.cursor = str;
        if (j < 30) {
            throw new IllegalArgumentException("Number 'timeout' is smaller than 30L");
        }
        if (j > 480) {
            throw new IllegalArgumentException("Number 'timeout' is larger than 480L");
        }
        this.timeout = j;
    }

    public ListFolderLongpollArg(@Nonnull String str) {
        this(str, 30L);
    }

    @Nonnull
    public String getCursor() {
        return this.cursor;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.cursor, Long.valueOf(this.timeout)});
    }

    public boolean equals(Object obj) {
        ListFolderLongpollArg listFolderLongpollArg;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.cursor) == (str2 = (listFolderLongpollArg = (ListFolderLongpollArg) obj).cursor) || str.equals(str2)) && this.timeout == listFolderLongpollArg.timeout;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListFolderLongpollArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListFolderLongpollArg listFolderLongpollArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("cursor");
            StoneSerializers.string().serialize(listFolderLongpollArg.cursor, jsonGenerator);
            jsonGenerator.writeFieldName("timeout");
            StoneSerializers.uInt64().serialize(Long.valueOf(listFolderLongpollArg.timeout), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListFolderLongpollArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = 30L;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("cursor".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("timeout".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"cursor\" missing.");
                }
                ListFolderLongpollArg listFolderLongpollArg = new ListFolderLongpollArg(strDeserialize, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listFolderLongpollArg, listFolderLongpollArg.toStringMultiline());
                return listFolderLongpollArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
