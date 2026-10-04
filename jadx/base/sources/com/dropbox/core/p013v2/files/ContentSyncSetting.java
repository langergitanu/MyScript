package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.SyncSetting;
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
public class ContentSyncSetting {

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f691id;

    @Nonnull
    protected final SyncSetting syncSetting;

    public ContentSyncSetting(@Nonnull String str, @Nonnull SyncSetting syncSetting) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (str.length() < 4) {
            throw new IllegalArgumentException("String 'id' is shorter than 4");
        }
        if (!Pattern.matches("id:.+", str)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.f691id = str;
        if (syncSetting == null) {
            throw new IllegalArgumentException("Required value for 'syncSetting' is null");
        }
        this.syncSetting = syncSetting;
    }

    @Nonnull
    public String getId() {
        return this.f691id;
    }

    @Nonnull
    public SyncSetting getSyncSetting() {
        return this.syncSetting;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f691id, this.syncSetting});
    }

    public boolean equals(Object obj) {
        SyncSetting syncSetting;
        SyncSetting syncSetting2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ContentSyncSetting contentSyncSetting = (ContentSyncSetting) obj;
        String str = this.f691id;
        String str2 = contentSyncSetting.f691id;
        return (str == str2 || str.equals(str2)) && ((syncSetting = this.syncSetting) == (syncSetting2 = contentSyncSetting.syncSetting) || syncSetting.equals(syncSetting2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<ContentSyncSetting> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ContentSyncSetting contentSyncSetting, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(contentSyncSetting.f691id, jsonGenerator);
            jsonGenerator.writeFieldName("sync_setting");
            SyncSetting.Serializer.INSTANCE.serialize(contentSyncSetting.syncSetting, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ContentSyncSetting deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SyncSetting syncSettingDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("sync_setting".equals(currentName)) {
                        syncSettingDeserialize = SyncSetting.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                if (syncSettingDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"sync_setting\" missing.");
                }
                ContentSyncSetting contentSyncSetting = new ContentSyncSetting(strDeserialize, syncSettingDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(contentSyncSetting, contentSyncSetting.toStringMultiline());
                return contentSyncSetting;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
