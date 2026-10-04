package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.files.SyncSetting;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class TeamSelectiveSyncSettingsChangedDetails {

    @Nonnull
    protected final SyncSetting newValue;

    @Nonnull
    protected final SyncSetting previousValue;

    public TeamSelectiveSyncSettingsChangedDetails(@Nonnull SyncSetting syncSetting, @Nonnull SyncSetting syncSetting2) {
        if (syncSetting == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = syncSetting;
        if (syncSetting2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = syncSetting2;
    }

    @Nonnull
    public SyncSetting getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public SyncSetting getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
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
        TeamSelectiveSyncSettingsChangedDetails teamSelectiveSyncSettingsChangedDetails = (TeamSelectiveSyncSettingsChangedDetails) obj;
        SyncSetting syncSetting3 = this.previousValue;
        SyncSetting syncSetting4 = teamSelectiveSyncSettingsChangedDetails.previousValue;
        return (syncSetting3 == syncSetting4 || syncSetting3.equals(syncSetting4)) && ((syncSetting = this.newValue) == (syncSetting2 = teamSelectiveSyncSettingsChangedDetails.newValue) || syncSetting.equals(syncSetting2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamSelectiveSyncSettingsChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamSelectiveSyncSettingsChangedDetails teamSelectiveSyncSettingsChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            SyncSetting.Serializer.INSTANCE.serialize(teamSelectiveSyncSettingsChangedDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            SyncSetting.Serializer.INSTANCE.serialize(teamSelectiveSyncSettingsChangedDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamSelectiveSyncSettingsChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SyncSetting syncSettingDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SyncSetting syncSettingDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        syncSettingDeserialize = SyncSetting.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        syncSettingDeserialize2 = SyncSetting.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (syncSettingDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (syncSettingDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                TeamSelectiveSyncSettingsChangedDetails teamSelectiveSyncSettingsChangedDetails = new TeamSelectiveSyncSettingsChangedDetails(syncSettingDeserialize, syncSettingDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamSelectiveSyncSettingsChangedDetails, teamSelectiveSyncSettingsChangedDetails.toStringMultiline());
                return teamSelectiveSyncSettingsChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
