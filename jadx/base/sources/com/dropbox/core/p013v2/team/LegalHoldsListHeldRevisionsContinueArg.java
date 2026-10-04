package com.dropbox.core.p013v2.team;

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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class LegalHoldsListHeldRevisionsContinueArg {

    @Nullable
    protected final String cursor;

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f754id;

    public LegalHoldsListHeldRevisionsContinueArg(@Nonnull String str, @Nullable String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (!Pattern.matches("^pid_dbhid:.+", str)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.f754id = str;
        if (str2 != null && str2.length() < 1) {
            throw new IllegalArgumentException("String 'cursor' is shorter than 1");
        }
        this.cursor = str2;
    }

    public LegalHoldsListHeldRevisionsContinueArg(@Nonnull String str) {
        this(str, null);
    }

    @Nonnull
    public String getId() {
        return this.f754id;
    }

    @Nullable
    public String getCursor() {
        return this.cursor;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f754id, this.cursor});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LegalHoldsListHeldRevisionsContinueArg legalHoldsListHeldRevisionsContinueArg = (LegalHoldsListHeldRevisionsContinueArg) obj;
        String str3 = this.f754id;
        String str4 = legalHoldsListHeldRevisionsContinueArg.f754id;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.cursor) == (str2 = legalHoldsListHeldRevisionsContinueArg.cursor) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsListHeldRevisionsContinueArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsListHeldRevisionsContinueArg legalHoldsListHeldRevisionsContinueArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(legalHoldsListHeldRevisionsContinueArg.f754id, jsonGenerator);
            if (legalHoldsListHeldRevisionsContinueArg.cursor != null) {
                jsonGenerator.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legalHoldsListHeldRevisionsContinueArg.cursor, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsListHeldRevisionsContinueArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                LegalHoldsListHeldRevisionsContinueArg legalHoldsListHeldRevisionsContinueArg = new LegalHoldsListHeldRevisionsContinueArg(strDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsListHeldRevisionsContinueArg, legalHoldsListHeldRevisionsContinueArg.toStringMultiline());
                return legalHoldsListHeldRevisionsContinueArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
