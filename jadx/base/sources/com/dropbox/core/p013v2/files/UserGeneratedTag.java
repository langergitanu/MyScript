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
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class UserGeneratedTag {

    @Nonnull
    protected final String tagText;

    public UserGeneratedTag(@Nonnull String str) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'tagText' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'tagText' is shorter than 1");
        }
        if (str.length() > 32) {
            throw new IllegalArgumentException("String 'tagText' is longer than 32");
        }
        if (!Pattern.matches("[\\w]+", str)) {
            throw new IllegalArgumentException("String 'tagText' does not match pattern");
        }
        this.tagText = str;
    }

    @Nonnull
    public String getTagText() {
        return this.tagText;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.tagText});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        String str = this.tagText;
        String str2 = ((UserGeneratedTag) obj).tagText;
        return str == str2 || str.equals(str2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserGeneratedTag> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserGeneratedTag userGeneratedTag, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("tag_text");
            StoneSerializers.string().serialize(userGeneratedTag.tagText, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserGeneratedTag deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
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
                    if ("tag_text".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"tag_text\" missing.");
                }
                UserGeneratedTag userGeneratedTag = new UserGeneratedTag(strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userGeneratedTag, userGeneratedTag.toStringMultiline());
                return userGeneratedTag;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
