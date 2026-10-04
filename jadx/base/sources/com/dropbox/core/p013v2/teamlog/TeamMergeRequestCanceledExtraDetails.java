package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PrimaryTeamRequestCanceledDetails;
import com.dropbox.core.p013v2.teamlog.SecondaryTeamRequestCanceledDetails;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class TeamMergeRequestCanceledExtraDetails {
    public static final TeamMergeRequestCanceledExtraDetails OTHER = new TeamMergeRequestCanceledExtraDetails().withTag(Tag.OTHER);
    private Tag _tag;
    private PrimaryTeamRequestCanceledDetails primaryTeamValue;
    private SecondaryTeamRequestCanceledDetails secondaryTeamValue;

    public enum Tag {
        PRIMARY_TEAM,
        SECONDARY_TEAM,
        OTHER
    }

    private TeamMergeRequestCanceledExtraDetails() {
    }

    private TeamMergeRequestCanceledExtraDetails withTag(Tag tag) {
        TeamMergeRequestCanceledExtraDetails teamMergeRequestCanceledExtraDetails = new TeamMergeRequestCanceledExtraDetails();
        teamMergeRequestCanceledExtraDetails._tag = tag;
        return teamMergeRequestCanceledExtraDetails;
    }

    private TeamMergeRequestCanceledExtraDetails withTagAndPrimaryTeam(Tag tag, PrimaryTeamRequestCanceledDetails primaryTeamRequestCanceledDetails) {
        TeamMergeRequestCanceledExtraDetails teamMergeRequestCanceledExtraDetails = new TeamMergeRequestCanceledExtraDetails();
        teamMergeRequestCanceledExtraDetails._tag = tag;
        teamMergeRequestCanceledExtraDetails.primaryTeamValue = primaryTeamRequestCanceledDetails;
        return teamMergeRequestCanceledExtraDetails;
    }

    private TeamMergeRequestCanceledExtraDetails withTagAndSecondaryTeam(Tag tag, SecondaryTeamRequestCanceledDetails secondaryTeamRequestCanceledDetails) {
        TeamMergeRequestCanceledExtraDetails teamMergeRequestCanceledExtraDetails = new TeamMergeRequestCanceledExtraDetails();
        teamMergeRequestCanceledExtraDetails._tag = tag;
        teamMergeRequestCanceledExtraDetails.secondaryTeamValue = secondaryTeamRequestCanceledDetails;
        return teamMergeRequestCanceledExtraDetails;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPrimaryTeam() {
        return this._tag == Tag.PRIMARY_TEAM;
    }

    public static TeamMergeRequestCanceledExtraDetails primaryTeam(PrimaryTeamRequestCanceledDetails primaryTeamRequestCanceledDetails) {
        if (primaryTeamRequestCanceledDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMergeRequestCanceledExtraDetails().withTagAndPrimaryTeam(Tag.PRIMARY_TEAM, primaryTeamRequestCanceledDetails);
    }

    public PrimaryTeamRequestCanceledDetails getPrimaryTeamValue() {
        if (this._tag != Tag.PRIMARY_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.PRIMARY_TEAM, but was Tag." + this._tag.name());
        }
        return this.primaryTeamValue;
    }

    public boolean isSecondaryTeam() {
        return this._tag == Tag.SECONDARY_TEAM;
    }

    public static TeamMergeRequestCanceledExtraDetails secondaryTeam(SecondaryTeamRequestCanceledDetails secondaryTeamRequestCanceledDetails) {
        if (secondaryTeamRequestCanceledDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMergeRequestCanceledExtraDetails().withTagAndSecondaryTeam(Tag.SECONDARY_TEAM, secondaryTeamRequestCanceledDetails);
    }

    public SecondaryTeamRequestCanceledDetails getSecondaryTeamValue() {
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
        if (obj == null || !(obj instanceof TeamMergeRequestCanceledExtraDetails)) {
            return false;
        }
        TeamMergeRequestCanceledExtraDetails teamMergeRequestCanceledExtraDetails = (TeamMergeRequestCanceledExtraDetails) obj;
        if (this._tag != teamMergeRequestCanceledExtraDetails._tag) {
            return false;
        }
        int i = C45301.f798x498082c0[this._tag.ordinal()];
        if (i == 1) {
            PrimaryTeamRequestCanceledDetails primaryTeamRequestCanceledDetails = this.primaryTeamValue;
            PrimaryTeamRequestCanceledDetails primaryTeamRequestCanceledDetails2 = teamMergeRequestCanceledExtraDetails.primaryTeamValue;
            return primaryTeamRequestCanceledDetails == primaryTeamRequestCanceledDetails2 || primaryTeamRequestCanceledDetails.equals(primaryTeamRequestCanceledDetails2);
        }
        if (i != 2) {
            return i == 3;
        }
        SecondaryTeamRequestCanceledDetails secondaryTeamRequestCanceledDetails = this.secondaryTeamValue;
        SecondaryTeamRequestCanceledDetails secondaryTeamRequestCanceledDetails2 = teamMergeRequestCanceledExtraDetails.secondaryTeamValue;
        return secondaryTeamRequestCanceledDetails == secondaryTeamRequestCanceledDetails2 || secondaryTeamRequestCanceledDetails.equals(secondaryTeamRequestCanceledDetails2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TeamMergeRequestCanceledExtraDetails$1 */
    static /* synthetic */ class C45301 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$TeamMergeRequestCanceledExtraDetails$Tag */
        static final /* synthetic */ int[] f798x498082c0;

        static {
            int[] iArr = new int[Tag.values().length];
            f798x498082c0 = iArr;
            try {
                iArr[Tag.PRIMARY_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f798x498082c0[Tag.SECONDARY_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f798x498082c0[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<TeamMergeRequestCanceledExtraDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamMergeRequestCanceledExtraDetails teamMergeRequestCanceledExtraDetails, JsonGenerator jsonGenerator) throws IOException {
            int i = C45301.f798x498082c0[teamMergeRequestCanceledExtraDetails.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("primary_team", jsonGenerator);
                PrimaryTeamRequestCanceledDetails.Serializer.INSTANCE.serialize(teamMergeRequestCanceledExtraDetails.primaryTeamValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("secondary_team", jsonGenerator);
                SecondaryTeamRequestCanceledDetails.Serializer.INSTANCE.serialize(teamMergeRequestCanceledExtraDetails.secondaryTeamValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamMergeRequestCanceledExtraDetails deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamMergeRequestCanceledExtraDetails teamMergeRequestCanceledExtraDetailsSecondaryTeam;
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
                teamMergeRequestCanceledExtraDetailsSecondaryTeam = TeamMergeRequestCanceledExtraDetails.primaryTeam(PrimaryTeamRequestCanceledDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("secondary_team".equals(tag)) {
                teamMergeRequestCanceledExtraDetailsSecondaryTeam = TeamMergeRequestCanceledExtraDetails.secondaryTeam(SecondaryTeamRequestCanceledDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                teamMergeRequestCanceledExtraDetailsSecondaryTeam = TeamMergeRequestCanceledExtraDetails.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamMergeRequestCanceledExtraDetailsSecondaryTeam;
        }
    }
}
