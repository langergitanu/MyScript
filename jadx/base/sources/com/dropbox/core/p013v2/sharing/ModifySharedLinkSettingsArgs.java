package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedLinkSettings;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class ModifySharedLinkSettingsArgs {
    protected final boolean removeExpiration;

    @Nonnull
    protected final SharedLinkSettings settings;

    @Nonnull
    protected final String url;

    public ModifySharedLinkSettingsArgs(@Nonnull String str, @Nonnull SharedLinkSettings sharedLinkSettings, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = str;
        if (sharedLinkSettings == null) {
            throw new IllegalArgumentException("Required value for 'settings' is null");
        }
        this.settings = sharedLinkSettings;
        this.removeExpiration = z;
    }

    public ModifySharedLinkSettingsArgs(@Nonnull String str, @Nonnull SharedLinkSettings sharedLinkSettings) {
        this(str, sharedLinkSettings, false);
    }

    @Nonnull
    public String getUrl() {
        return this.url;
    }

    @Nonnull
    public SharedLinkSettings getSettings() {
        return this.settings;
    }

    public boolean getRemoveExpiration() {
        return this.removeExpiration;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.url, this.settings, Boolean.valueOf(this.removeExpiration)});
    }

    public boolean equals(Object obj) {
        ModifySharedLinkSettingsArgs modifySharedLinkSettingsArgs;
        String str;
        String str2;
        SharedLinkSettings sharedLinkSettings;
        SharedLinkSettings sharedLinkSettings2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.url) == (str2 = (modifySharedLinkSettingsArgs = (ModifySharedLinkSettingsArgs) obj).url) || str.equals(str2)) && (((sharedLinkSettings = this.settings) == (sharedLinkSettings2 = modifySharedLinkSettingsArgs.settings) || sharedLinkSettings.equals(sharedLinkSettings2)) && this.removeExpiration == modifySharedLinkSettingsArgs.removeExpiration);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ModifySharedLinkSettingsArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ModifySharedLinkSettingsArgs modifySharedLinkSettingsArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ImagesContract.URL);
            StoneSerializers.string().serialize(modifySharedLinkSettingsArgs.url, jsonGenerator);
            jsonGenerator.writeFieldName("settings");
            SharedLinkSettings.Serializer.INSTANCE.serialize(modifySharedLinkSettingsArgs.settings, jsonGenerator);
            jsonGenerator.writeFieldName("remove_expiration");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(modifySharedLinkSettingsArgs.removeExpiration), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ModifySharedLinkSettingsArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                SharedLinkSettings sharedLinkSettingsDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ImagesContract.URL.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("settings".equals(currentName)) {
                        sharedLinkSettingsDeserialize = SharedLinkSettings.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("remove_expiration".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"url\" missing.");
                }
                if (sharedLinkSettingsDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"settings\" missing.");
                }
                ModifySharedLinkSettingsArgs modifySharedLinkSettingsArgs = new ModifySharedLinkSettingsArgs(strDeserialize, sharedLinkSettingsDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(modifySharedLinkSettingsArgs, modifySharedLinkSettingsArgs.toStringMultiline());
                return modifySharedLinkSettingsArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
