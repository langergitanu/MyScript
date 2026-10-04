package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PrimaryTeamRequestReminderDetails;
import com.dropbox.core.p013v2.teamlog.SecondaryTeamRequestReminderDetails;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class TeamMergeRequestReminderExtraDetails {
    public static final TeamMergeRequestReminderExtraDetails OTHER = new TeamMergeRequestReminderExtraDetails().withTag(Tag.OTHER);
    private Tag _tag;
    private PrimaryTeamRequestReminderDetails primaryTeamValue;
    private SecondaryTeamRequestReminderDetails secondaryTeamValue;

    public enum Tag {
        PRIMARY_TEAM,
        SECONDARY_TEAM,
        OTHER
    }

    private TeamMergeRequestReminderExtraDetails() {
    }

    private TeamMergeRequestReminderExtraDetails withTag(Tag tag) {
        TeamMergeRequestReminderExtraDetails teamMergeRequestReminderExtraDetails = new TeamMergeRequestReminderExtraDetails();
        teamMergeRequestReminderExtraDetails._tag = tag;
        return teamMergeRequestReminderExtraDetails;
    }

    private TeamMergeRequestReminderExtraDetails withTagAndPrimaryTeam(Tag tag, PrimaryTeamRequestReminderDetails primaryTeamRequestReminderDetails) {
        TeamMergeRequestReminderExtraDetails teamMergeRequestReminderExtraDetails = new TeamMergeRequestReminderExtraDetails();
        teamMergeRequestReminderExtraDetails._tag = tag;
        teamMergeRequestReminderExtraDetails.primaryTeamValue = primaryTeamRequestReminderDetails;
        return teamMergeRequestReminderExtraDetails;
    }

    private TeamMergeRequestReminderExtraDetails withTagAndSecondaryTeam(Tag tag, SecondaryTeamRequestReminderDetails secondaryTeamRequestReminderDetails) {
        TeamMergeRequestReminderExtraDetails teamMergeRequestReminderExtraDetails = new TeamMergeRequestReminderExtraDetails();
        teamMergeRequestReminderExtraDetails._tag = tag;
        teamMergeRequestReminderExtraDetails.secondaryTeamValue = secondaryTeamRequestReminderDetails;
        return teamMergeRequestReminderExtraDetails;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPrimaryTeam() {
        return this._tag == Tag.PRIMARY_TEAM;
    }

    public static TeamMergeRequestReminderExtraDetails primaryTeam(PrimaryTeamRequestReminderDetails primaryTeamRequestReminderDetails) {
        if (primaryTeamRequestReminderDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMergeRequestReminderExtraDetails().withTagAndPrimaryTeam(Tag.PRIMARY_TEAM, primaryTeamRequestReminderDetails);
    }

    public PrimaryTeamRequestReminderDetails getPrimaryTeamValue() {
        if (this._tag != Tag.PRIMARY_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.PRIMARY_TEAM, but was Tag." + this._tag.name());
        }
        return this.primaryTeamValue;
    }

    public boolean isSecondaryTeam() {
        return this._tag == Tag.SECONDARY_TEAM;
    }

    public static TeamMergeRequestReminderExtraDetails secondaryTeam(SecondaryTeamRequestReminderDetails secondaryTeamRequestReminderDetails) {
        if (secondaryTeamRequestReminderDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMergeRequestReminderExtraDetails().withTagAndSecondaryTeam(Tag.SECONDARY_TEAM, secondaryTeamRequestReminderDetails);
    }

    public SecondaryTeamRequestReminderDetails getSecondaryTeamValue() {
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
        if (obj == null || !(obj instanceof TeamMergeRequestReminderExtraDetails)) {
            return false;
        }
        TeamMergeRequestReminderExtraDetails teamMergeRequestReminderExtraDetails = (TeamMergeRequestReminderExtraDetails) obj;
        if (this._tag != teamMergeRequestReminderExtraDetails._tag) {
            return false;
        }
        int i = C45321.f800x1c15ec99[this._tag.ordinal()];
        if (i == 1) {
            PrimaryTeamRequestReminderDetails primaryTeamRequestReminderDetails = this.primaryTeamValue;
            PrimaryTeamRequestReminderDetails primaryTeamRequestReminderDetails2 = teamMergeRequestReminderExtraDetails.primaryTeamValue;
            return primaryTeamRequestReminderDetails == primaryTeamRequestReminderDetails2 || primaryTeamRequestReminderDetails.equals(primaryTeamRequestReminderDetails2);
        }
        if (i != 2) {
            return i == 3;
        }
        SecondaryTeamRequestReminderDetails secondaryTeamRequestReminderDetails = this.secondaryTeamValue;
        SecondaryTeamRequestReminderDetails secondaryTeamRequestReminderDetails2 = teamMergeRequestReminderExtraDetails.secondaryTeamValue;
        return secondaryTeamRequestReminderDetails == secondaryTeamRequestReminderDetails2 || secondaryTeamRequestReminderDetails.equals(secondaryTeamRequestReminderDetails2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TeamMergeRequestReminderExtraDetails$1 */
    static /* synthetic */ class C45321 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$TeamMergeRequestReminderExtraDetails$Tag */
        static final /* synthetic */ int[] f800x1c15ec99;

        static {
            int[] iArr = new int[Tag.values().length];
            f800x1c15ec99 = iArr;
            try {
                iArr[Tag.PRIMARY_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f800x1c15ec99[Tag.SECONDARY_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f800x1c15ec99[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<TeamMergeRequestReminderExtraDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamMergeRequestReminderExtraDetails teamMergeRequestReminderExtraDetails, JsonGenerator jsonGenerator) throws IOException {
            int i = C45321.f800x1c15ec99[teamMergeRequestReminderExtraDetails.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("primary_team", jsonGenerator);
                PrimaryTeamRequestReminderDetails.Serializer.INSTANCE.serialize(teamMergeRequestReminderExtraDetails.primaryTeamValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("secondary_team", jsonGenerator);
                SecondaryTeamRequestReminderDetails.Serializer.INSTANCE.serialize(teamMergeRequestReminderExtraDetails.secondaryTeamValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamMergeRequestReminderExtraDetails deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamMergeRequestReminderExtraDetails teamMergeRequestReminderExtraDetailsSecondaryTeam;
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
                teamMergeRequestReminderExtraDetailsSecondaryTeam = TeamMergeRequestReminderExtraDetails.primaryTeam(PrimaryTeamRequestReminderDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("secondary_team".equals(tag)) {
                teamMergeRequestReminderExtraDetailsSecondaryTeam = TeamMergeRequestReminderExtraDetails.secondaryTeam(SecondaryTeamRequestReminderDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                teamMergeRequestReminderExtraDetailsSecondaryTeam = TeamMergeRequestReminderExtraDetails.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamMergeRequestReminderExtraDetailsSecondaryTeam;
        }
    }
}
