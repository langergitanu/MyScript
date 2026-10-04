package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class Cursor {

    @Nullable
    protected final Date expiration;

    @Nonnull
    protected final String value;

    public Cursor(@Nonnull String str, @Nullable Date date) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'value' is null");
        }
        this.value = str;
        this.expiration = LangUtil.truncateMillis(date);
    }

    public Cursor(@Nonnull String str) {
        this(str, null);
    }

    @Nonnull
    public String getValue() {
        return this.value;
    }

    @Nullable
    public Date getExpiration() {
        return this.expiration;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.value, this.expiration});
    }

    public boolean equals(Object obj) {
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        Cursor cursor = (Cursor) obj;
        String str = this.value;
        String str2 = cursor.value;
        return (str == str2 || str.equals(str2)) && ((date = this.expiration) == (date2 = cursor.expiration) || (date != null && date.equals(date2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<Cursor> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(Cursor cursor, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("value");
            StoneSerializers.string().serialize(cursor.value, jsonGenerator);
            if (cursor.expiration != null) {
                jsonGenerator.writeFieldName("expiration");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(cursor.expiration, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public Cursor deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Date date = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("value".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("expiration".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"value\" missing.");
                }
                Cursor cursor = new Cursor(strDeserialize, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(cursor, cursor.toStringMultiline());
                return cursor;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
