package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.ListRevisionsMode;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class ListRevisionsArg {
    protected final long limit;

    @Nonnull
    protected final ListRevisionsMode mode;

    @Nonnull
    protected final String path;

    public ListRevisionsArg(@Nonnull String str, @Nonnull ListRevisionsMode listRevisionsMode, long j) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (listRevisionsMode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = listRevisionsMode;
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 100) {
            throw new IllegalArgumentException("Number 'limit' is larger than 100L");
        }
        this.limit = j;
    }

    public ListRevisionsArg(@Nonnull String str) {
        this(str, ListRevisionsMode.PATH, 10L);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nonnull
    public ListRevisionsMode getMode() {
        return this.mode;
    }

    public long getLimit() {
        return this.limit;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected long limit;
        protected ListRevisionsMode mode;
        protected final String path;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("/(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)", str)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = str;
            this.mode = ListRevisionsMode.PATH;
            this.limit = 10L;
        }

        public Builder withMode(ListRevisionsMode listRevisionsMode) {
            if (listRevisionsMode != null) {
                this.mode = listRevisionsMode;
                return this;
            }
            this.mode = ListRevisionsMode.PATH;
            return this;
        }

        public Builder withLimit(Long l) {
            if (l.longValue() < 1) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (l.longValue() > 100) {
                throw new IllegalArgumentException("Number 'limit' is larger than 100L");
            }
            if (l != null) {
                this.limit = l.longValue();
                return this;
            }
            this.limit = 10L;
            return this;
        }

        public ListRevisionsArg build() {
            return new ListRevisionsArg(this.path, this.mode, this.limit);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.mode, Long.valueOf(this.limit)});
    }

    public boolean equals(Object obj) {
        ListRevisionsArg listRevisionsArg;
        String str;
        String str2;
        ListRevisionsMode listRevisionsMode;
        ListRevisionsMode listRevisionsMode2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.path) == (str2 = (listRevisionsArg = (ListRevisionsArg) obj).path) || str.equals(str2)) && (((listRevisionsMode = this.mode) == (listRevisionsMode2 = listRevisionsArg.mode) || listRevisionsMode.equals(listRevisionsMode2)) && this.limit == listRevisionsArg.limit);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListRevisionsArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListRevisionsArg listRevisionsArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(listRevisionsArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("mode");
            ListRevisionsMode.Serializer.INSTANCE.serialize(listRevisionsArg.mode, jsonGenerator);
            jsonGenerator.writeFieldName("limit");
            StoneSerializers.uInt64().serialize(Long.valueOf(listRevisionsArg.limit), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListRevisionsArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ListRevisionsMode listRevisionsModeDeserialize = ListRevisionsMode.PATH;
                Long lDeserialize = 10L;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("mode".equals(currentName)) {
                        listRevisionsModeDeserialize = ListRevisionsMode.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("limit".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                ListRevisionsArg listRevisionsArg = new ListRevisionsArg(strDeserialize, listRevisionsModeDeserialize, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listRevisionsArg, listRevisionsArg.toStringMultiline());
                return listRevisionsArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
