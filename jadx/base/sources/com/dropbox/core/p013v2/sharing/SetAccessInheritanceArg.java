package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessInheritance;
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
class SetAccessInheritanceArg {

    @Nonnull
    protected final AccessInheritance accessInheritance;

    @Nonnull
    protected final String sharedFolderId;

    public SetAccessInheritanceArg(@Nonnull String str, @Nonnull AccessInheritance accessInheritance) {
        if (accessInheritance == null) {
            throw new IllegalArgumentException("Required value for 'accessInheritance' is null");
        }
        this.accessInheritance = accessInheritance;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = str;
    }

    public SetAccessInheritanceArg(@Nonnull String str) {
        this(str, AccessInheritance.INHERIT);
    }

    @Nonnull
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    @Nonnull
    public AccessInheritance getAccessInheritance() {
        return this.accessInheritance;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accessInheritance, this.sharedFolderId});
    }

    public boolean equals(Object obj) {
        AccessInheritance accessInheritance;
        AccessInheritance accessInheritance2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SetAccessInheritanceArg setAccessInheritanceArg = (SetAccessInheritanceArg) obj;
        String str = this.sharedFolderId;
        String str2 = setAccessInheritanceArg.sharedFolderId;
        return (str == str2 || str.equals(str2)) && ((accessInheritance = this.accessInheritance) == (accessInheritance2 = setAccessInheritanceArg.accessInheritance) || accessInheritance.equals(accessInheritance2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SetAccessInheritanceArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SetAccessInheritanceArg setAccessInheritanceArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(setAccessInheritanceArg.sharedFolderId, jsonGenerator);
            jsonGenerator.writeFieldName("access_inheritance");
            AccessInheritance.Serializer.INSTANCE.serialize(setAccessInheritanceArg.accessInheritance, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SetAccessInheritanceArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AccessInheritance accessInheritanceDeserialize = AccessInheritance.INHERIT;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("access_inheritance".equals(currentName)) {
                        accessInheritanceDeserialize = AccessInheritance.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_id\" missing.");
                }
                SetAccessInheritanceArg setAccessInheritanceArg = new SetAccessInheritanceArg(strDeserialize, accessInheritanceDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(setAccessInheritanceArg, setAccessInheritanceArg.toStringMultiline());
                return setAccessInheritanceArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
