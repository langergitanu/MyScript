package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedLinkSettings;
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
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class CreateSharedLinkWithSettingsArg {

    @Nonnull
    protected final String path;

    @Nullable
    protected final SharedLinkSettings settings;

    public CreateSharedLinkWithSettingsArg(@Nonnull String str, @Nullable SharedLinkSettings sharedLinkSettings) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        this.settings = sharedLinkSettings;
    }

    public CreateSharedLinkWithSettingsArg(@Nonnull String str) {
        this(str, null);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nullable
    public SharedLinkSettings getSettings() {
        return this.settings;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.settings});
    }

    public boolean equals(Object obj) {
        SharedLinkSettings sharedLinkSettings;
        SharedLinkSettings sharedLinkSettings2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        CreateSharedLinkWithSettingsArg createSharedLinkWithSettingsArg = (CreateSharedLinkWithSettingsArg) obj;
        String str = this.path;
        String str2 = createSharedLinkWithSettingsArg.path;
        return (str == str2 || str.equals(str2)) && ((sharedLinkSettings = this.settings) == (sharedLinkSettings2 = createSharedLinkWithSettingsArg.settings) || (sharedLinkSettings != null && sharedLinkSettings.equals(sharedLinkSettings2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CreateSharedLinkWithSettingsArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CreateSharedLinkWithSettingsArg createSharedLinkWithSettingsArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(createSharedLinkWithSettingsArg.path, jsonGenerator);
            if (createSharedLinkWithSettingsArg.settings != null) {
                jsonGenerator.writeFieldName("settings");
                StoneSerializers.nullableStruct(SharedLinkSettings.Serializer.INSTANCE).serialize(createSharedLinkWithSettingsArg.settings, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public CreateSharedLinkWithSettingsArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SharedLinkSettings sharedLinkSettings = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("settings".equals(currentName)) {
                        sharedLinkSettings = (SharedLinkSettings) StoneSerializers.nullableStruct(SharedLinkSettings.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                CreateSharedLinkWithSettingsArg createSharedLinkWithSettingsArg = new CreateSharedLinkWithSettingsArg(strDeserialize, sharedLinkSettings);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(createSharedLinkWithSettingsArg, createSharedLinkWithSettingsArg.toStringMultiline());
                return createSharedLinkWithSettingsArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
