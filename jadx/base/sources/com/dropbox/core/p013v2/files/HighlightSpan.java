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
public class HighlightSpan {

    @Nonnull
    protected final String highlightStr;
    protected final boolean isHighlighted;

    public HighlightSpan(@Nonnull String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'highlightStr' is null");
        }
        this.highlightStr = str;
        this.isHighlighted = z;
    }

    @Nonnull
    public String getHighlightStr() {
        return this.highlightStr;
    }

    public boolean getIsHighlighted() {
        return this.isHighlighted;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.highlightStr, Boolean.valueOf(this.isHighlighted)});
    }

    public boolean equals(Object obj) {
        HighlightSpan highlightSpan;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.highlightStr) == (str2 = (highlightSpan = (HighlightSpan) obj).highlightStr) || str.equals(str2)) && this.isHighlighted == highlightSpan.isHighlighted;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<HighlightSpan> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(HighlightSpan highlightSpan, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("highlight_str");
            StoneSerializers.string().serialize(highlightSpan.highlightStr, jsonGenerator);
            jsonGenerator.writeFieldName("is_highlighted");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(highlightSpan.isHighlighted), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public HighlightSpan deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("highlight_str".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("is_highlighted".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"highlight_str\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_highlighted\" missing.");
                }
                HighlightSpan highlightSpan = new HighlightSpan(strDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(highlightSpan, highlightSpan.toStringMultiline());
                return highlightSpan;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
