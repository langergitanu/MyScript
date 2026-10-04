package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.users.Team;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class TeamMemberInfo {

    @Nonnull
    protected final String displayName;

    @Nullable
    protected final String memberId;

    @Nonnull
    protected final Team teamInfo;

    public TeamMemberInfo(@Nonnull Team team, @Nonnull String str, @Nullable String str2) {
        if (team == null) {
            throw new IllegalArgumentException("Required value for 'teamInfo' is null");
        }
        this.teamInfo = team;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'displayName' is null");
        }
        this.displayName = str;
        this.memberId = str2;
    }

    public TeamMemberInfo(@Nonnull Team team, @Nonnull String str) {
        this(team, str, null);
    }

    @Nonnull
    public Team getTeamInfo() {
        return this.teamInfo;
    }

    @Nonnull
    public String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public String getMemberId() {
        return this.memberId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamInfo, this.displayName, this.memberId});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMemberInfo teamMemberInfo = (TeamMemberInfo) obj;
        Team team = this.teamInfo;
        Team team2 = teamMemberInfo.teamInfo;
        return (team == team2 || team.equals(team2)) && ((str = this.displayName) == (str2 = teamMemberInfo.displayName) || str.equals(str2)) && ((str3 = this.memberId) == (str4 = teamMemberInfo.memberId) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMemberInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMemberInfo teamMemberInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_info");
            Team.Serializer.INSTANCE.serialize(teamMemberInfo.teamInfo, jsonGenerator);
            jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
            StoneSerializers.string().serialize(teamMemberInfo.displayName, jsonGenerator);
            if (teamMemberInfo.memberId != null) {
                jsonGenerator.writeFieldName("member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(teamMemberInfo.memberId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMemberInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Team teamDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_info".equals(currentName)) {
                        teamDeserialize = Team.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("member_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_info\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"display_name\" missing.");
                }
                TeamMemberInfo teamMemberInfo = new TeamMemberInfo(teamDeserialize, strDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMemberInfo, teamMemberInfo.toStringMultiline());
                return teamMemberInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
