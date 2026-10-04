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
class TeamFolderArchiveArg extends TeamFolderIdArg {
    protected final boolean forceAsyncOff;

    public TeamFolderArchiveArg(@Nonnull String str, boolean z) {
        super(str);
        this.forceAsyncOff = z;
    }

    public TeamFolderArchiveArg(@Nonnull String str) {
        this(str, false);
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    @Nonnull
    public String getTeamFolderId() {
        return this.teamFolderId;
    }

    public boolean getForceAsyncOff() {
        return this.forceAsyncOff;
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{Boolean.valueOf(this.forceAsyncOff)});
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            TeamFolderArchiveArg teamFolderArchiveArg = (TeamFolderArchiveArg) obj;
            if ((this.teamFolderId == teamFolderArchiveArg.teamFolderId || this.teamFolderId.equals(teamFolderArchiveArg.teamFolderId)) && this.forceAsyncOff == teamFolderArchiveArg.forceAsyncOff) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.TeamFolderIdArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamFolderArchiveArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamFolderArchiveArg teamFolderArchiveArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_folder_id");
            StoneSerializers.string().serialize(teamFolderArchiveArg.teamFolderId, jsonGenerator);
            jsonGenerator.writeFieldName("force_async_off");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(teamFolderArchiveArg.forceAsyncOff), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamFolderArchiveArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("force_async_off".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_folder_id\" missing.");
                }
                TeamFolderArchiveArg teamFolderArchiveArg = new TeamFolderArchiveArg(strDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamFolderArchiveArg, teamFolderArchiveArg.toStringMultiline());
                return teamFolderArchiveArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
