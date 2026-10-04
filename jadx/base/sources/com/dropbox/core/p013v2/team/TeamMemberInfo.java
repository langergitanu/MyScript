package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.AdminTier;
import com.dropbox.core.p013v2.team.TeamMemberProfile;
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
public class TeamMemberInfo {

    @Nonnull
    protected final TeamMemberProfile profile;

    @Nonnull
    protected final AdminTier role;

    public TeamMemberInfo(@Nonnull TeamMemberProfile teamMemberProfile, @Nonnull AdminTier adminTier) {
        if (teamMemberProfile == null) {
            throw new IllegalArgumentException("Required value for 'profile' is null");
        }
        this.profile = teamMemberProfile;
        if (adminTier == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = adminTier;
    }

    @Nonnull
    public TeamMemberProfile getProfile() {
        return this.profile;
    }

    @Nonnull
    public AdminTier getRole() {
        return this.role;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.profile, this.role});
    }

    public boolean equals(Object obj) {
        AdminTier adminTier;
        AdminTier adminTier2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMemberInfo teamMemberInfo = (TeamMemberInfo) obj;
        TeamMemberProfile teamMemberProfile = this.profile;
        TeamMemberProfile teamMemberProfile2 = teamMemberInfo.profile;
        return (teamMemberProfile == teamMemberProfile2 || teamMemberProfile.equals(teamMemberProfile2)) && ((adminTier = this.role) == (adminTier2 = teamMemberInfo.role) || adminTier.equals(adminTier2));
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
            jsonGenerator.writeFieldName("profile");
            TeamMemberProfile.Serializer.INSTANCE.serialize(teamMemberInfo.profile, jsonGenerator);
            jsonGenerator.writeFieldName("role");
            AdminTier.Serializer.INSTANCE.serialize(teamMemberInfo.role, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMemberInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamMemberProfile teamMemberProfileDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AdminTier adminTierDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("profile".equals(currentName)) {
                        teamMemberProfileDeserialize = TeamMemberProfile.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("role".equals(currentName)) {
                        adminTierDeserialize = AdminTier.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamMemberProfileDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"profile\" missing.");
                }
                if (adminTierDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"role\" missing.");
                }
                TeamMemberInfo teamMemberInfo = new TeamMemberInfo(teamMemberProfileDeserialize, adminTierDeserialize);
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
