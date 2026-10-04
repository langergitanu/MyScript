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
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
class TeamFolderIdListArg {

    @Nonnull
    protected final List<String> teamFolderIds;

    public TeamFolderIdListArg(@Nonnull List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'teamFolderIds' is null");
        }
        if (list.size() < 1) {
            throw new IllegalArgumentException("List 'teamFolderIds' has fewer than 1 items");
        }
        for (String str : list) {
            if (str == null) {
                throw new IllegalArgumentException("An item in list 'teamFolderIds' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
                throw new IllegalArgumentException("Stringan item in list 'teamFolderIds' does not match pattern");
            }
        }
        this.teamFolderIds = list;
    }

    @Nonnull
    public List<String> getTeamFolderIds() {
        return this.teamFolderIds;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamFolderIds});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<String> list = this.teamFolderIds;
        List<String> list2 = ((TeamFolderIdListArg) obj).teamFolderIds;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamFolderIdListArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamFolderIdListArg teamFolderIdListArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_folder_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(teamFolderIdListArg.teamFolderIds, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamFolderIdListArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_folder_ids".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_folder_ids\" missing.");
                }
                TeamFolderIdListArg teamFolderIdListArg = new TeamFolderIdListArg(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamFolderIdListArg, teamFolderIdListArg.toStringMultiline());
                return teamFolderIdListArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
