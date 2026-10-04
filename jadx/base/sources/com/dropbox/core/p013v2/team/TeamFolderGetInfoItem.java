package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamFolderMetadata;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class TeamFolderGetInfoItem {
    private Tag _tag;
    private String idNotFoundValue;
    private TeamFolderMetadata teamFolderMetadataValue;

    public enum Tag {
        ID_NOT_FOUND,
        TEAM_FOLDER_METADATA
    }

    private TeamFolderGetInfoItem() {
    }

    private TeamFolderGetInfoItem withTag(Tag tag) {
        TeamFolderGetInfoItem teamFolderGetInfoItem = new TeamFolderGetInfoItem();
        teamFolderGetInfoItem._tag = tag;
        return teamFolderGetInfoItem;
    }

    private TeamFolderGetInfoItem withTagAndIdNotFound(Tag tag, String str) {
        TeamFolderGetInfoItem teamFolderGetInfoItem = new TeamFolderGetInfoItem();
        teamFolderGetInfoItem._tag = tag;
        teamFolderGetInfoItem.idNotFoundValue = str;
        return teamFolderGetInfoItem;
    }

    private TeamFolderGetInfoItem withTagAndTeamFolderMetadata(Tag tag, TeamFolderMetadata teamFolderMetadata) {
        TeamFolderGetInfoItem teamFolderGetInfoItem = new TeamFolderGetInfoItem();
        teamFolderGetInfoItem._tag = tag;
        teamFolderGetInfoItem.teamFolderMetadataValue = teamFolderMetadata;
        return teamFolderGetInfoItem;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isIdNotFound() {
        return this._tag == Tag.ID_NOT_FOUND;
    }

    public static TeamFolderGetInfoItem idNotFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderGetInfoItem().withTagAndIdNotFound(Tag.ID_NOT_FOUND, str);
    }

    public String getIdNotFoundValue() {
        if (this._tag != Tag.ID_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.ID_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return this.idNotFoundValue;
    }

    public boolean isTeamFolderMetadata() {
        return this._tag == Tag.TEAM_FOLDER_METADATA;
    }

    public static TeamFolderGetInfoItem teamFolderMetadata(TeamFolderMetadata teamFolderMetadata) {
        if (teamFolderMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderGetInfoItem().withTagAndTeamFolderMetadata(Tag.TEAM_FOLDER_METADATA, teamFolderMetadata);
    }

    public TeamFolderMetadata getTeamFolderMetadataValue() {
        if (this._tag != Tag.TEAM_FOLDER_METADATA) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_FOLDER_METADATA, but was Tag." + this._tag.name());
        }
        return this.teamFolderMetadataValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.idNotFoundValue, this.teamFolderMetadataValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TeamFolderGetInfoItem)) {
            return false;
        }
        TeamFolderGetInfoItem teamFolderGetInfoItem = (TeamFolderGetInfoItem) obj;
        if (this._tag != teamFolderGetInfoItem._tag) {
            return false;
        }
        int i = C44061.$SwitchMap$com$dropbox$core$v2$team$TeamFolderGetInfoItem$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.idNotFoundValue;
            String str2 = teamFolderGetInfoItem.idNotFoundValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return false;
        }
        TeamFolderMetadata teamFolderMetadata = this.teamFolderMetadataValue;
        TeamFolderMetadata teamFolderMetadata2 = teamFolderGetInfoItem.teamFolderMetadataValue;
        return teamFolderMetadata == teamFolderMetadata2 || teamFolderMetadata.equals(teamFolderMetadata2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderGetInfoItem$1 */
    static /* synthetic */ class C44061 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamFolderGetInfoItem$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamFolderGetInfoItem$Tag = iArr;
            try {
                iArr[Tag.ID_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderGetInfoItem$Tag[Tag.TEAM_FOLDER_METADATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<TeamFolderGetInfoItem> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderGetInfoItem teamFolderGetInfoItem, JsonGenerator jsonGenerator) throws IOException {
            int i = C44061.$SwitchMap$com$dropbox$core$v2$team$TeamFolderGetInfoItem$Tag[teamFolderGetInfoItem.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("id_not_found", jsonGenerator);
                jsonGenerator.writeFieldName("id_not_found");
                StoneSerializers.string().serialize(teamFolderGetInfoItem.idNotFoundValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("team_folder_metadata", jsonGenerator);
                TeamFolderMetadata.Serializer.INSTANCE.serialize(teamFolderGetInfoItem.teamFolderMetadataValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + teamFolderGetInfoItem.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderGetInfoItem deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderGetInfoItem teamFolderGetInfoItemTeamFolderMetadata;
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
            if ("id_not_found".equals(tag)) {
                expectField("id_not_found", jsonParser);
                teamFolderGetInfoItemTeamFolderMetadata = TeamFolderGetInfoItem.idNotFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("team_folder_metadata".equals(tag)) {
                teamFolderGetInfoItemTeamFolderMetadata = TeamFolderGetInfoItem.teamFolderMetadata(TeamFolderMetadata.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderGetInfoItemTeamFolderMetadata;
        }
    }
}
