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
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class ListSharedLinksArg {

    @Nullable
    protected final String cursor;

    @Nullable
    protected final Boolean directOnly;

    @Nullable
    protected final String path;

    public ListSharedLinksArg(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
        if (str != null && !Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        this.cursor = str2;
        this.directOnly = bool;
    }

    public ListSharedLinksArg() {
        this(null, null, null);
    }

    @Nullable
    public String getPath() {
        return this.path;
    }

    @Nullable
    public String getCursor() {
        return this.cursor;
    }

    @Nullable
    public Boolean getDirectOnly() {
        return this.directOnly;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String path = null;
        protected String cursor = null;
        protected Boolean directOnly = null;

        protected Builder() {
        }

        public Builder withPath(String str) {
            if (str != null && !Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", str)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = str;
            return this;
        }

        public Builder withCursor(String str) {
            this.cursor = str;
            return this;
        }

        public Builder withDirectOnly(Boolean bool) {
            this.directOnly = bool;
            return this;
        }

        public ListSharedLinksArg build() {
            return new ListSharedLinksArg(this.path, this.cursor, this.directOnly);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.cursor, this.directOnly});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Boolean bool;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ListSharedLinksArg listSharedLinksArg = (ListSharedLinksArg) obj;
        String str3 = this.path;
        String str4 = listSharedLinksArg.path;
        return (str3 == str4 || (str3 != null && str3.equals(str4))) && ((str = this.cursor) == (str2 = listSharedLinksArg.cursor) || (str != null && str.equals(str2))) && ((bool = this.directOnly) == (bool2 = listSharedLinksArg.directOnly) || (bool != null && bool.equals(bool2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListSharedLinksArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListSharedLinksArg listSharedLinksArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (listSharedLinksArg.path != null) {
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(listSharedLinksArg.path, jsonGenerator);
            }
            if (listSharedLinksArg.cursor != null) {
                jsonGenerator.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(listSharedLinksArg.cursor, jsonGenerator);
            }
            if (listSharedLinksArg.directOnly != null) {
                jsonGenerator.writeFieldName("direct_only");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(listSharedLinksArg.directOnly, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListSharedLinksArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str2 = null;
                Boolean bool = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("direct_only".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                ListSharedLinksArg listSharedLinksArg = new ListSharedLinksArg(str, str2, bool);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listSharedLinksArg, listSharedLinksArg.toStringMultiline());
                return listSharedLinksArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
