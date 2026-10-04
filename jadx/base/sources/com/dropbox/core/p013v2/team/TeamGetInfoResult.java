package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.teampolicies.TeamMemberPolicies;
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
public class TeamGetInfoResult {

    @Nonnull
    protected final String name;
    protected final long numLicensedUsers;
    protected final long numProvisionedUsers;
    protected final long numUsedLicenses;

    @Nonnull
    protected final TeamMemberPolicies policies;

    @Nonnull
    protected final String teamId;

    public TeamGetInfoResult(@Nonnull String str, @Nonnull String str2, long j, long j2, @Nonnull TeamMemberPolicies teamMemberPolicies, long j3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'teamId' is null");
        }
        this.teamId = str2;
        this.numLicensedUsers = j;
        this.numProvisionedUsers = j2;
        this.numUsedLicenses = j3;
        if (teamMemberPolicies == null) {
            throw new IllegalArgumentException("Required value for 'policies' is null");
        }
        this.policies = teamMemberPolicies;
    }

    public TeamGetInfoResult(@Nonnull String str, @Nonnull String str2, long j, long j2, @Nonnull TeamMemberPolicies teamMemberPolicies) {
        this(str, str2, j, j2, teamMemberPolicies, 0L);
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getTeamId() {
        return this.teamId;
    }

    public long getNumLicensedUsers() {
        return this.numLicensedUsers;
    }

    public long getNumProvisionedUsers() {
        return this.numProvisionedUsers;
    }

    @Nonnull
    public TeamMemberPolicies getPolicies() {
        return this.policies;
    }

    public long getNumUsedLicenses() {
        return this.numUsedLicenses;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, this.teamId, Long.valueOf(this.numLicensedUsers), Long.valueOf(this.numProvisionedUsers), Long.valueOf(this.numUsedLicenses), this.policies});
    }

    public boolean equals(Object obj) {
        TeamGetInfoResult teamGetInfoResult;
        String str;
        String str2;
        String str3;
        String str4;
        TeamMemberPolicies teamMemberPolicies;
        TeamMemberPolicies teamMemberPolicies2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.name) == (str2 = (teamGetInfoResult = (TeamGetInfoResult) obj).name) || str.equals(str2)) && (((str3 = this.teamId) == (str4 = teamGetInfoResult.teamId) || str3.equals(str4)) && this.numLicensedUsers == teamGetInfoResult.numLicensedUsers && this.numProvisionedUsers == teamGetInfoResult.numProvisionedUsers && (((teamMemberPolicies = this.policies) == (teamMemberPolicies2 = teamGetInfoResult.policies) || teamMemberPolicies.equals(teamMemberPolicies2)) && this.numUsedLicenses == teamGetInfoResult.numUsedLicenses));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamGetInfoResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamGetInfoResult teamGetInfoResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(teamGetInfoResult.name, jsonGenerator);
            jsonGenerator.writeFieldName("team_id");
            StoneSerializers.string().serialize(teamGetInfoResult.teamId, jsonGenerator);
            jsonGenerator.writeFieldName("num_licensed_users");
            StoneSerializers.uInt32().serialize(Long.valueOf(teamGetInfoResult.numLicensedUsers), jsonGenerator);
            jsonGenerator.writeFieldName("num_provisioned_users");
            StoneSerializers.uInt32().serialize(Long.valueOf(teamGetInfoResult.numProvisionedUsers), jsonGenerator);
            jsonGenerator.writeFieldName("policies");
            TeamMemberPolicies.Serializer.INSTANCE.serialize(teamGetInfoResult.policies, jsonGenerator);
            jsonGenerator.writeFieldName("num_used_licenses");
            StoneSerializers.uInt32().serialize(Long.valueOf(teamGetInfoResult.numUsedLicenses), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamGetInfoResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                TeamMemberPolicies teamMemberPoliciesDeserialize = null;
                Long lDeserialize2 = 0L;
                Long lDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("team_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("num_licensed_users".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else if ("num_provisioned_users".equals(currentName)) {
                        lDeserialize3 = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else if ("policies".equals(currentName)) {
                        teamMemberPoliciesDeserialize = TeamMemberPolicies.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("num_used_licenses".equals(currentName)) {
                        lDeserialize2 = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_id\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"num_licensed_users\" missing.");
                }
                if (lDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"num_provisioned_users\" missing.");
                }
                if (teamMemberPoliciesDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"policies\" missing.");
                }
                TeamGetInfoResult teamGetInfoResult = new TeamGetInfoResult(strDeserialize, strDeserialize2, lDeserialize.longValue(), lDeserialize3.longValue(), teamMemberPoliciesDeserialize, lDeserialize2.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamGetInfoResult, teamGetInfoResult.toStringMultiline());
                return teamGetInfoResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
