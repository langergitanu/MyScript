package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.p013v2.teampolicies.EmmState;
import com.dropbox.core.p013v2.teampolicies.OfficeAddInPolicy;
import com.dropbox.core.p013v2.teampolicies.SuggestMembersPolicy;
import com.dropbox.core.p013v2.teampolicies.TeamSharingPolicies;
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
public class TeamMemberPolicies {

    @Nonnull
    protected final EmmState emmState;

    @Nonnull
    protected final OfficeAddInPolicy officeAddin;

    @Nonnull
    protected final TeamSharingPolicies sharing;

    @Nonnull
    protected final SuggestMembersPolicy suggestMembersPolicy;

    public TeamMemberPolicies(@Nonnull TeamSharingPolicies teamSharingPolicies, @Nonnull EmmState emmState, @Nonnull OfficeAddInPolicy officeAddInPolicy, @Nonnull SuggestMembersPolicy suggestMembersPolicy) {
        if (teamSharingPolicies == null) {
            throw new IllegalArgumentException("Required value for 'sharing' is null");
        }
        this.sharing = teamSharingPolicies;
        if (emmState == null) {
            throw new IllegalArgumentException("Required value for 'emmState' is null");
        }
        this.emmState = emmState;
        if (officeAddInPolicy == null) {
            throw new IllegalArgumentException("Required value for 'officeAddin' is null");
        }
        this.officeAddin = officeAddInPolicy;
        if (suggestMembersPolicy == null) {
            throw new IllegalArgumentException("Required value for 'suggestMembersPolicy' is null");
        }
        this.suggestMembersPolicy = suggestMembersPolicy;
    }

    @Nonnull
    public TeamSharingPolicies getSharing() {
        return this.sharing;
    }

    @Nonnull
    public EmmState getEmmState() {
        return this.emmState;
    }

    @Nonnull
    public OfficeAddInPolicy getOfficeAddin() {
        return this.officeAddin;
    }

    @Nonnull
    public SuggestMembersPolicy getSuggestMembersPolicy() {
        return this.suggestMembersPolicy;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharing, this.emmState, this.officeAddin, this.suggestMembersPolicy});
    }

    public boolean equals(Object obj) {
        EmmState emmState;
        EmmState emmState2;
        OfficeAddInPolicy officeAddInPolicy;
        OfficeAddInPolicy officeAddInPolicy2;
        SuggestMembersPolicy suggestMembersPolicy;
        SuggestMembersPolicy suggestMembersPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMemberPolicies teamMemberPolicies = (TeamMemberPolicies) obj;
        TeamSharingPolicies teamSharingPolicies = this.sharing;
        TeamSharingPolicies teamSharingPolicies2 = teamMemberPolicies.sharing;
        return (teamSharingPolicies == teamSharingPolicies2 || teamSharingPolicies.equals(teamSharingPolicies2)) && ((emmState = this.emmState) == (emmState2 = teamMemberPolicies.emmState) || emmState.equals(emmState2)) && (((officeAddInPolicy = this.officeAddin) == (officeAddInPolicy2 = teamMemberPolicies.officeAddin) || officeAddInPolicy.equals(officeAddInPolicy2)) && ((suggestMembersPolicy = this.suggestMembersPolicy) == (suggestMembersPolicy2 = teamMemberPolicies.suggestMembersPolicy) || suggestMembersPolicy.equals(suggestMembersPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<TeamMemberPolicies> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMemberPolicies teamMemberPolicies, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("sharing");
            TeamSharingPolicies.Serializer.INSTANCE.serialize(teamMemberPolicies.sharing, jsonGenerator);
            jsonGenerator.writeFieldName("emm_state");
            EmmState.Serializer.INSTANCE.serialize(teamMemberPolicies.emmState, jsonGenerator);
            jsonGenerator.writeFieldName("office_addin");
            OfficeAddInPolicy.Serializer.INSTANCE.serialize(teamMemberPolicies.officeAddin, jsonGenerator);
            jsonGenerator.writeFieldName("suggest_members_policy");
            SuggestMembersPolicy.Serializer.INSTANCE.serialize(teamMemberPolicies.suggestMembersPolicy, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMemberPolicies deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamSharingPolicies teamSharingPoliciesDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                EmmState emmStateDeserialize = null;
                OfficeAddInPolicy officeAddInPolicyDeserialize = null;
                SuggestMembersPolicy suggestMembersPolicyDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("sharing".equals(currentName)) {
                        teamSharingPoliciesDeserialize = TeamSharingPolicies.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("emm_state".equals(currentName)) {
                        emmStateDeserialize = EmmState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("office_addin".equals(currentName)) {
                        officeAddInPolicyDeserialize = OfficeAddInPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("suggest_members_policy".equals(currentName)) {
                        suggestMembersPolicyDeserialize = SuggestMembersPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamSharingPoliciesDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"sharing\" missing.");
                }
                if (emmStateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"emm_state\" missing.");
                }
                if (officeAddInPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"office_addin\" missing.");
                }
                if (suggestMembersPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"suggest_members_policy\" missing.");
                }
                TeamMemberPolicies teamMemberPolicies = new TeamMemberPolicies(teamSharingPoliciesDeserialize, emmStateDeserialize, officeAddInPolicyDeserialize, suggestMembersPolicyDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMemberPolicies, teamMemberPolicies.toStringMultiline());
                return teamMemberPolicies;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
