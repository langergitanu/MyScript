package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamMemberProfile;
import com.dropbox.core.p013v2.team.TeamMemberRole;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class TeamMemberInfoV2 {

    @Nonnull
    protected final TeamMemberProfile profile;

    @Nullable
    protected final List<TeamMemberRole> roles;

    public TeamMemberInfoV2(@Nonnull TeamMemberProfile teamMemberProfile, @Nullable List<TeamMemberRole> list) {
        if (teamMemberProfile == null) {
            throw new IllegalArgumentException("Required value for 'profile' is null");
        }
        this.profile = teamMemberProfile;
        if (list != null) {
            Iterator<TeamMemberRole> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'roles' is null");
                }
            }
        }
        this.roles = list;
    }

    public TeamMemberInfoV2(@Nonnull TeamMemberProfile teamMemberProfile) {
        this(teamMemberProfile, null);
    }

    @Nonnull
    public TeamMemberProfile getProfile() {
        return this.profile;
    }

    @Nullable
    public List<TeamMemberRole> getRoles() {
        return this.roles;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.profile, this.roles});
    }

    public boolean equals(Object obj) {
        List<TeamMemberRole> list;
        List<TeamMemberRole> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMemberInfoV2 teamMemberInfoV2 = (TeamMemberInfoV2) obj;
        TeamMemberProfile teamMemberProfile = this.profile;
        TeamMemberProfile teamMemberProfile2 = teamMemberInfoV2.profile;
        return (teamMemberProfile == teamMemberProfile2 || teamMemberProfile.equals(teamMemberProfile2)) && ((list = this.roles) == (list2 = teamMemberInfoV2.roles) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMemberInfoV2> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMemberInfoV2 teamMemberInfoV2, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("profile");
            TeamMemberProfile.Serializer.INSTANCE.serialize(teamMemberInfoV2.profile, jsonGenerator);
            if (teamMemberInfoV2.roles != null) {
                jsonGenerator.writeFieldName("roles");
                StoneSerializers.nullable(StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE)).serialize(teamMemberInfoV2.roles, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMemberInfoV2 deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamMemberProfile teamMemberProfileDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("profile".equals(currentName)) {
                        teamMemberProfileDeserialize = TeamMemberProfile.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("roles".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamMemberProfileDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"profile\" missing.");
                }
                TeamMemberInfoV2 teamMemberInfoV2 = new TeamMemberInfoV2(teamMemberProfileDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMemberInfoV2, teamMemberInfoV2.toStringMultiline());
                return teamMemberInfoV2;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
