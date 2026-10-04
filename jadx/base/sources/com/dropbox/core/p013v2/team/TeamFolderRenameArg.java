package com.dropbox.core.p013v2.team;

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

/* JADX INFO: loaded from: classes5.dex */
class TeamFolderRenameArg extends TeamFolderIdArg {

    @Nonnull
    protected final String name;

    public TeamFolderRenameArg(@Nonnull String str, @Nonnull String str2) {
        super(str);
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    @Nonnull
    public String getTeamFolderId() {
        return this.teamFolderId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.name});
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamFolderRenameArg teamFolderRenameArg = (TeamFolderRenameArg) obj;
        return (this.teamFolderId == teamFolderRenameArg.teamFolderId || this.teamFolderId.equals(teamFolderRenameArg.teamFolderId)) && ((str = this.name) == (str2 = teamFolderRenameArg.name) || str.equals(str2));
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamFolderRenameArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamFolderRenameArg teamFolderRenameArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_folder_id");
            StoneSerializers.string().serialize(teamFolderRenameArg.teamFolderId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(teamFolderRenameArg.name, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamFolderRenameArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_folder_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                TeamFolderRenameArg teamFolderRenameArg = new TeamFolderRenameArg(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamFolderRenameArg, teamFolderRenameArg.toStringMultiline());
                return teamFolderRenameArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
