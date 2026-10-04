package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PrimaryTeamRequestAcceptedDetails;
import com.dropbox.core.p013v2.teamlog.SecondaryTeamRequestAcceptedDetails;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class TeamMergeRequestAcceptedExtraDetails {
    public static final TeamMergeRequestAcceptedExtraDetails OTHER = new TeamMergeRequestAcceptedExtraDetails().withTag(Tag.OTHER);
    private Tag _tag;
    private PrimaryTeamRequestAcceptedDetails primaryTeamValue;
    private SecondaryTeamRequestAcceptedDetails secondaryTeamValue;

    public enum Tag {
        PRIMARY_TEAM,
        SECONDARY_TEAM,
        OTHER
    }

    private TeamMergeRequestAcceptedExtraDetails() {
    }

    private TeamMergeRequestAcceptedExtraDetails withTag(Tag tag) {
        TeamMergeRequestAcceptedExtraDetails teamMergeRequestAcceptedExtraDetails = new TeamMergeRequestAcceptedExtraDetails();
        teamMergeRequestAcceptedExtraDetails._tag = tag;
        return teamMergeRequestAcceptedExtraDetails;
    }

    private TeamMergeRequestAcceptedExtraDetails withTagAndPrimaryTeam(Tag tag, PrimaryTeamRequestAcceptedDetails primaryTeamRequestAcceptedDetails) {
        TeamMergeRequestAcceptedExtraDetails teamMergeRequestAcceptedExtraDetails = new TeamMergeRequestAcceptedExtraDetails();
        teamMergeRequestAcceptedExtraDetails._tag = tag;
        teamMergeRequestAcceptedExtraDetails.primaryTeamValue = primaryTeamRequestAcceptedDetails;
        return teamMergeRequestAcceptedExtraDetails;
    }

    private TeamMergeRequestAcceptedExtraDetails withTagAndSecondaryTeam(Tag tag, SecondaryTeamRequestAcceptedDetails secondaryTeamRequestAcceptedDetails) {
        TeamMergeRequestAcceptedExtraDetails teamMergeRequestAcceptedExtraDetails = new TeamMergeRequestAcceptedExtraDetails();
        teamMergeRequestAcceptedExtraDetails._tag = tag;
        teamMergeRequestAcceptedExtraDetails.secondaryTeamValue = secondaryTeamRequestAcceptedDetails;
        return teamMergeRequestAcceptedExtraDetails;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPrimaryTeam() {
        return this._tag == Tag.PRIMARY_TEAM;
    }

    public static TeamMergeRequestAcceptedExtraDetails primaryTeam(PrimaryTeamRequestAcceptedDetails primaryTeamRequestAcceptedDetails) {
        if (primaryTeamRequestAcceptedDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMergeRequestAcceptedExtraDetails().withTagAndPrimaryTeam(Tag.PRIMARY_TEAM, primaryTeamRequestAcceptedDetails);
    }

    public PrimaryTeamRequestAcceptedDetails getPrimaryTeamValue() {
        if (this._tag != Tag.PRIMARY_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.PRIMARY_TEAM, but was Tag." + this._tag.name());
        }
        return this.primaryTeamValue;
    }

    public boolean isSecondaryTeam() {
        return this._tag == Tag.SECONDARY_TEAM;
    }

    public static TeamMergeRequestAcceptedExtraDetails secondaryTeam(SecondaryTeamRequestAcceptedDetails secondaryTeamRequestAcceptedDetails) {
        if (secondaryTeamRequestAcceptedDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMergeRequestAcceptedExtraDetails().withTagAndSecondaryTeam(Tag.SECONDARY_TEAM, secondaryTeamRequestAcceptedDetails);
    }

    public SecondaryTeamRequestAcceptedDetails getSecondaryTeamValue() {
        if (this._tag != Tag.SECONDARY_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.SECONDARY_TEAM, but was Tag." + this._tag.name());
        }
        return this.secondaryTeamValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.primaryTeamValue, this.secondaryTeamValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TeamMergeRequestAcceptedExtraDetails)) {
            return false;
        }
        TeamMergeRequestAcceptedExtraDetails teamMergeRequestAcceptedExtraDetails = (TeamMergeRequestAcceptedExtraDetails) obj;
        if (this._tag != teamMergeRequestAcceptedExtraDetails._tag) {
            return false;
        }
        int i = C45291.f797x989ac1ce[this._tag.ordinal()];
        if (i == 1) {
            PrimaryTeamRequestAcceptedDetails primaryTeamRequestAcceptedDetails = this.primaryTeamValue;
            PrimaryTeamRequestAcceptedDetails primaryTeamRequestAcceptedDetails2 = teamMergeRequestAcceptedExtraDetails.primaryTeamValue;
            return primaryTeamRequestAcceptedDetails == primaryTeamRequestAcceptedDetails2 || primaryTeamRequestAcceptedDetails.equals(primaryTeamRequestAcceptedDetails2);
        }
        if (i != 2) {
            return i == 3;
        }
        SecondaryTeamRequestAcceptedDetails secondaryTeamRequestAcceptedDetails = this.secondaryTeamValue;
        SecondaryTeamRequestAcceptedDetails secondaryTeamRequestAcceptedDetails2 = teamMergeRequestAcceptedExtraDetails.secondaryTeamValue;
        return secondaryTeamRequestAcceptedDetails == secondaryTeamRequestAcceptedDetails2 || secondaryTeamRequestAcceptedDetails.equals(secondaryTeamRequestAcceptedDetails2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TeamMergeRequestAcceptedExtraDetails$1 */
    static /* synthetic */ class C45291 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$TeamMergeRequestAcceptedExtraDetails$Tag */
        static final /* synthetic */ int[] f797x989ac1ce;

        static {
            int[] iArr = new int[Tag.values().length];
            f797x989ac1ce = iArr;
            try {
                iArr[Tag.PRIMARY_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f797x989ac1ce[Tag.SECONDARY_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f797x989ac1ce[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<TeamMergeRequestAcceptedExtraDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamMergeRequestAcceptedExtraDetails teamMergeRequestAcceptedExtraDetails, JsonGenerator jsonGenerator) throws IOException {
            int i = C45291.f797x989ac1ce[teamMergeRequestAcceptedExtraDetails.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("primary_team", jsonGenerator);
                PrimaryTeamRequestAcceptedDetails.Serializer.INSTANCE.serialize(teamMergeRequestAcceptedExtraDetails.primaryTeamValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("secondary_team", jsonGenerator);
                SecondaryTeamRequestAcceptedDetails.Serializer.INSTANCE.serialize(teamMergeRequestAcceptedExtraDetails.secondaryTeamValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamMergeRequestAcceptedExtraDetails deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamMergeRequestAcceptedExtraDetails teamMergeRequestAcceptedExtraDetailsSecondaryTeam;
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
            if ("primary_team".equals(tag)) {
                teamMergeRequestAcceptedExtraDetailsSecondaryTeam = TeamMergeRequestAcceptedExtraDetails.primaryTeam(PrimaryTeamRequestAcceptedDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("secondary_team".equals(tag)) {
                teamMergeRequestAcceptedExtraDetailsSecondaryTeam = TeamMergeRequestAcceptedExtraDetails.secondaryTeam(SecondaryTeamRequestAcceptedDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                teamMergeRequestAcceptedExtraDetailsSecondaryTeam = TeamMergeRequestAcceptedExtraDetails.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamMergeRequestAcceptedExtraDetailsSecondaryTeam;
        }
    }
}
