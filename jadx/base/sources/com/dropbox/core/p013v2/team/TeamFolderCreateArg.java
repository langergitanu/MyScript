package com.dropbox.core.p013v2.team;

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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class TeamFolderCreateArg {

    @Nonnull
    protected final String name;

    @Nullable
    protected final SyncSettingArg syncSetting;

    public TeamFolderCreateArg(@Nonnull String str, @Nullable SyncSettingArg syncSettingArg) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str;
        this.syncSetting = syncSettingArg;
    }

    public TeamFolderCreateArg(@Nonnull String str) {
        this(str, null);
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nullable
    public SyncSettingArg getSyncSetting() {
        return this.syncSetting;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, this.syncSetting});
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
        TeamFolderCreateArg teamFolderCreateArg = (TeamFolderCreateArg) obj;
        String str = this.name;
        String str2 = teamFolderCreateArg.name;
        return (str == str2 || str.equals(str2)) && ((syncSettingArg = this.syncSetting) == (syncSettingArg2 = teamFolderCreateArg.syncSetting) || (syncSettingArg != null && syncSettingArg.equals(syncSettingArg2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamFolderCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamFolderCreateArg teamFolderCreateArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(teamFolderCreateArg.name, jsonGenerator);
            if (teamFolderCreateArg.syncSetting != null) {
                jsonGenerator.writeFieldName("sync_setting");
                StoneSerializers.nullable(SyncSettingArg.Serializer.INSTANCE).serialize(teamFolderCreateArg.syncSetting, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamFolderCreateArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SyncSettingArg syncSettingArg = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("sync_setting".equals(currentName)) {
                        syncSettingArg = (SyncSettingArg) StoneSerializers.nullable(SyncSettingArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                TeamFolderCreateArg teamFolderCreateArg = new TeamFolderCreateArg(strDeserialize, syncSettingArg);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamFolderCreateArg, teamFolderCreateArg.toStringMultiline());
                return teamFolderCreateArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
