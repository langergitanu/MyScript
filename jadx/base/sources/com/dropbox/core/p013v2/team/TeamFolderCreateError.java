package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.files.SyncSettingsError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class TeamFolderCreateError {
    private Tag _tag;
    private SyncSettingsError syncSettingsErrorValue;
    public static final TeamFolderCreateError INVALID_FOLDER_NAME = new TeamFolderCreateError().withTag(Tag.INVALID_FOLDER_NAME);
    public static final TeamFolderCreateError FOLDER_NAME_ALREADY_USED = new TeamFolderCreateError().withTag(Tag.FOLDER_NAME_ALREADY_USED);
    public static final TeamFolderCreateError FOLDER_NAME_RESERVED = new TeamFolderCreateError().withTag(Tag.FOLDER_NAME_RESERVED);
    public static final TeamFolderCreateError OTHER = new TeamFolderCreateError().withTag(Tag.OTHER);

    public enum Tag {
        INVALID_FOLDER_NAME,
        FOLDER_NAME_ALREADY_USED,
        FOLDER_NAME_RESERVED,
        SYNC_SETTINGS_ERROR,
        OTHER
    }

    private TeamFolderCreateError() {
    }

    private TeamFolderCreateError withTag(Tag tag) {
        TeamFolderCreateError teamFolderCreateError = new TeamFolderCreateError();
        teamFolderCreateError._tag = tag;
        return teamFolderCreateError;
    }

    private TeamFolderCreateError withTagAndSyncSettingsError(Tag tag, SyncSettingsError syncSettingsError) {
        TeamFolderCreateError teamFolderCreateError = new TeamFolderCreateError();
        teamFolderCreateError._tag = tag;
        teamFolderCreateError.syncSettingsErrorValue = syncSettingsError;
        return teamFolderCreateError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInvalidFolderName() {
        return this._tag == Tag.INVALID_FOLDER_NAME;
    }

    public boolean isFolderNameAlreadyUsed() {
        return this._tag == Tag.FOLDER_NAME_ALREADY_USED;
    }

    public boolean isFolderNameReserved() {
        return this._tag == Tag.FOLDER_NAME_RESERVED;
    }

    public boolean isSyncSettingsError() {
        return this._tag == Tag.SYNC_SETTINGS_ERROR;
    }

    public static TeamFolderCreateError syncSettingsError(SyncSettingsError syncSettingsError) {
        if (syncSettingsError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderCreateError().withTagAndSyncSettingsError(Tag.SYNC_SETTINGS_ERROR, syncSettingsError);
    }

    public SyncSettingsError getSyncSettingsErrorValue() {
        if (this._tag != Tag.SYNC_SETTINGS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.SYNC_SETTINGS_ERROR, but was Tag." + this._tag.name());
        }
        return this.syncSettingsErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.syncSettingsErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TeamFolderCreateError)) {
            return false;
        }
        TeamFolderCreateError teamFolderCreateError = (TeamFolderCreateError) obj;
        if (this._tag != teamFolderCreateError._tag) {
            return false;
        }
        int i = C44051.$SwitchMap$com$dropbox$core$v2$team$TeamFolderCreateError$Tag[this._tag.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                return i == 5;
            }
            SyncSettingsError syncSettingsError = this.syncSettingsErrorValue;
            SyncSettingsError syncSettingsError2 = teamFolderCreateError.syncSettingsErrorValue;
            if (syncSettingsError != syncSettingsError2 && !syncSettingsError.equals(syncSettingsError2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderCreateError$1 */
    static /* synthetic */ class C44051 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamFolderCreateError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamFolderCreateError$Tag = iArr;
            try {
                iArr[Tag.INVALID_FOLDER_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderCreateError$Tag[Tag.FOLDER_NAME_ALREADY_USED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderCreateError$Tag[Tag.FOLDER_NAME_RESERVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderCreateError$Tag[Tag.SYNC_SETTINGS_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderCreateError$Tag[Tag.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<TeamFolderCreateError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderCreateError teamFolderCreateError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44051.$SwitchMap$com$dropbox$core$v2$team$TeamFolderCreateError$Tag[teamFolderCreateError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invalid_folder_name");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("folder_name_already_used");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("folder_name_reserved");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeStartObject();
                writeTag("sync_settings_error", jsonGenerator);
                jsonGenerator.writeFieldName("sync_settings_error");
                SyncSettingsError.Serializer.INSTANCE.serialize(teamFolderCreateError.syncSettingsErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderCreateError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderCreateError teamFolderCreateErrorSyncSettingsError;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("invalid_folder_name".equals(tag)) {
                teamFolderCreateErrorSyncSettingsError = TeamFolderCreateError.INVALID_FOLDER_NAME;
            } else if ("folder_name_already_used".equals(tag)) {
                teamFolderCreateErrorSyncSettingsError = TeamFolderCreateError.FOLDER_NAME_ALREADY_USED;
            } else if ("folder_name_reserved".equals(tag)) {
                teamFolderCreateErrorSyncSettingsError = TeamFolderCreateError.FOLDER_NAME_RESERVED;
            } else if ("sync_settings_error".equals(tag)) {
                expectField("sync_settings_error", jsonParser);
                teamFolderCreateErrorSyncSettingsError = TeamFolderCreateError.syncSettingsError(SyncSettingsError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                teamFolderCreateErrorSyncSettingsError = TeamFolderCreateError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderCreateErrorSyncSettingsError;
        }
    }
}
