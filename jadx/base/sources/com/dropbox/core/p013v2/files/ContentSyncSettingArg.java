package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.SyncSettingArg;
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
public class ContentSyncSettingArg {

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f692id;

    @Nonnull
    protected final SyncSettingArg syncSetting;

    public ContentSyncSettingArg(@Nonnull String str, @Nonnull SyncSettingArg syncSettingArg) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (str.length() < 4) {
            throw new IllegalArgumentException("String 'id' is shorter than 4");
        }
        if (!Pattern.matches("id:.+", str)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.f692id = str;
        if (syncSettingArg == null) {
            throw new IllegalArgumentException("Required value for 'syncSetting' is null");
        }
        this.syncSetting = syncSettingArg;
    }

    @Nonnull
    public String getId() {
        return this.f692id;
    }

    @Nonnull
    public SyncSettingArg getSyncSetting() {
        return this.syncSetting;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f692id, this.syncSetting});
    }

    public boolean equals(Object obj) {
        SyncSettingArg syncSettingArg;
        SyncSettingArg syncSettingArg2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ContentSyncSettingArg contentSyncSettingArg = (ContentSyncSettingArg) obj;
        String str = this.f692id;
        String str2 = contentSyncSettingArg.f692id;
        return (str == str2 || str.equals(str2)) && ((syncSettingArg = this.syncSetting) == (syncSettingArg2 = contentSyncSettingArg.syncSetting) || syncSettingArg.equals(syncSettingArg2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<ContentSyncSettingArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ContentSyncSettingArg contentSyncSettingArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(contentSyncSettingArg.f692id, jsonGenerator);
            jsonGenerator.writeFieldName("sync_setting");
            SyncSettingArg.Serializer.INSTANCE.serialize(contentSyncSettingArg.syncSetting, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ContentSyncSettingArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SyncSettingArg syncSettingArgDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("sync_setting".equals(currentName)) {
                        syncSettingArgDeserialize = SyncSettingArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                if (syncSettingArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"sync_setting\" missing.");
                }
                ContentSyncSettingArg contentSyncSettingArg = new ContentSyncSettingArg(strDeserialize, syncSettingArgDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(contentSyncSettingArg, contentSyncSettingArg.toStringMultiline());
                return contentSyncSettingArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
