package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.MemberSelector;
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
class RemoveFileMemberArg {

    @Nonnull
    protected final String file;

    @Nonnull
    protected final MemberSelector member;

    public RemoveFileMemberArg(@Nonnull String str, @Nonnull MemberSelector memberSelector) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'file' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'file' is shorter than 1");
        }
        if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", str)) {
            throw new IllegalArgumentException("String 'file' does not match pattern");
        }
        this.file = str;
        if (memberSelector == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = memberSelector;
    }

    @Nonnull
    public String getFile() {
        return this.file;
    }

    @Nonnull
    public MemberSelector getMember() {
        return this.member;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.file, this.member});
    }

    public boolean equals(Object obj) {
        MemberSelector memberSelector;
        MemberSelector memberSelector2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        RemoveFileMemberArg removeFileMemberArg = (RemoveFileMemberArg) obj;
        String str = this.file;
        String str2 = removeFileMemberArg.file;
        return (str == str2 || str.equals(str2)) && ((memberSelector = this.member) == (memberSelector2 = removeFileMemberArg.member) || memberSelector.equals(memberSelector2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RemoveFileMemberArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RemoveFileMemberArg removeFileMemberArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("file");
            StoneSerializers.string().serialize(removeFileMemberArg.file, jsonGenerator);
            jsonGenerator.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(removeFileMemberArg.member, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RemoveFileMemberArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                MemberSelector memberSelectorDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("file".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("member".equals(currentName)) {
                        memberSelectorDeserialize = MemberSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"file\" missing.");
                }
                if (memberSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member\" missing.");
                }
                RemoveFileMemberArg removeFileMemberArg = new RemoveFileMemberArg(strDeserialize, memberSelectorDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(removeFileMemberArg, removeFileMemberArg.toStringMultiline());
                return removeFileMemberArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
