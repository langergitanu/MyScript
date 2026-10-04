package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PrimaryTeamRequestExpiredDetails;
import com.dropbox.core.p013v2.teamlog.SecondaryTeamRequestExpiredDetails;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class TeamMergeRequestExpiredExtraDetails {
    public static final TeamMergeRequestExpiredExtraDetails OTHER = new TeamMergeRequestExpiredExtraDetails().withTag(Tag.OTHER);
    private Tag _tag;
    private PrimaryTeamRequestExpiredDetails primaryTeamValue;
    private SecondaryTeamRequestExpiredDetails secondaryTeamValue;

    public enum Tag {
        PRIMARY_TEAM,
        SECONDARY_TEAM,
        OTHER
    }

    private TeamMergeRequestExpiredExtraDetails() {
    }

    private TeamMergeRequestExpiredExtraDetails withTag(Tag tag) {
        TeamMergeRequestExpiredExtraDetails teamMergeRequestExpiredExtraDetails = new TeamMergeRequestExpiredExtraDetails();
        teamMergeRequestExpiredExtraDetails._tag = tag;
        return teamMergeRequestExpiredExtraDetails;
    }

    private TeamMergeRequestExpiredExtraDetails withTagAndPrimaryTeam(Tag tag, PrimaryTeamRequestExpiredDetails primaryTeamRequestExpiredDetails) {
        TeamMergeRequestExpiredExtraDetails teamMergeRequestExpiredExtraDetails = new TeamMergeRequestExpiredExtraDetails();
        teamMergeRequestExpiredExtraDetails._tag = tag;
        teamMergeRequestExpiredExtraDetails.primaryTeamValue = primaryTeamRequestExpiredDetails;
        return teamMergeRequestExpiredExtraDetails;
    }

    private TeamMergeRequestExpiredExtraDetails withTagAndSecondaryTeam(Tag tag, SecondaryTeamRequestExpiredDetails secondaryTeamRequestExpiredDetails) {
        TeamMergeRequestExpiredExtraDetails teamMergeRequestExpiredExtraDetails = new TeamMergeRequestExpiredExtraDetails();
        teamMergeRequestExpiredExtraDetails._tag = tag;
        teamMergeRequestExpiredExtraDetails.secondaryTeamValue = secondaryTeamRequestExpiredDetails;
        return teamMergeRequestExpiredExtraDetails;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPrimaryTeam() {
        return this._tag == Tag.PRIMARY_TEAM;
    }

    public static TeamMergeRequestExpiredExtraDetails primaryTeam(PrimaryTeamRequestExpiredDetails primaryTeamRequestExpiredDetails) {
        if (primaryTeamRequestExpiredDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMergeRequestExpiredExtraDetails().withTagAndPrimaryTeam(Tag.PRIMARY_TEAM, primaryTeamRequestExpiredDetails);
    }

    public PrimaryTeamRequestExpiredDetails getPrimaryTeamValue() {
        if (this._tag != Tag.PRIMARY_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.PRIMARY_TEAM, but was Tag." + this._tag.name());
        }
        return this.primaryTeamValue;
    }

    public boolean isSecondaryTeam() {
        return this._tag == Tag.SECONDARY_TEAM;
    }

    public static TeamMergeRequestExpiredExtraDetails secondaryTeam(SecondaryTeamRequestExpiredDetails secondaryTeamRequestExpiredDetails) {
        if (secondaryTeamRequestExpiredDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamMergeRequestExpiredExtraDetails().withTagAndSecondaryTeam(Tag.SECONDARY_TEAM, secondaryTeamRequestExpiredDetails);
    }

    public SecondaryTeamRequestExpiredDetails getSecondaryTeamValue() {
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
        if (obj == null || !(obj instanceof TeamMergeRequestExpiredExtraDetails)) {
            return false;
        }
        TeamMergeRequestExpiredExtraDetails teamMergeRequestExpiredExtraDetails = (TeamMergeRequestExpiredExtraDetails) obj;
        if (this._tag != teamMergeRequestExpiredExtraDetails._tag) {
            return false;
        }
        int i = C45311.f799x133b952e[this._tag.ordinal()];
        if (i == 1) {
            PrimaryTeamRequestExpiredDetails primaryTeamRequestExpiredDetails = this.primaryTeamValue;
            PrimaryTeamRequestExpiredDetails primaryTeamRequestExpiredDetails2 = teamMergeRequestExpiredExtraDetails.primaryTeamValue;
            return primaryTeamRequestExpiredDetails == primaryTeamRequestExpiredDetails2 || primaryTeamRequestExpiredDetails.equals(primaryTeamRequestExpiredDetails2);
        }
        if (i != 2) {
            return i == 3;
        }
        SecondaryTeamRequestExpiredDetails secondaryTeamRequestExpiredDetails = this.secondaryTeamValue;
        SecondaryTeamRequestExpiredDetails secondaryTeamRequestExpiredDetails2 = teamMergeRequestExpiredExtraDetails.secondaryTeamValue;
        return secondaryTeamRequestExpiredDetails == secondaryTeamRequestExpiredDetails2 || secondaryTeamRequestExpiredDetails.equals(secondaryTeamRequestExpiredDetails2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TeamMergeRequestExpiredExtraDetails$1 */
    static /* synthetic */ class C45311 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$TeamMergeRequestExpiredExtraDetails$Tag */
        static final /* synthetic */ int[] f799x133b952e;

        static {
            int[] iArr = new int[Tag.values().length];
            f799x133b952e = iArr;
            try {
                iArr[Tag.PRIMARY_TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f799x133b952e[Tag.SECONDARY_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f799x133b952e[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<TeamMergeRequestExpiredExtraDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamMergeRequestExpiredExtraDetails teamMergeRequestExpiredExtraDetails, JsonGenerator jsonGenerator) throws IOException {
            int i = C45311.f799x133b952e[teamMergeRequestExpiredExtraDetails.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("primary_team", jsonGenerator);
                PrimaryTeamRequestExpiredDetails.Serializer.INSTANCE.serialize(teamMergeRequestExpiredExtraDetails.primaryTeamValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("secondary_team", jsonGenerator);
                SecondaryTeamRequestExpiredDetails.Serializer.INSTANCE.serialize(teamMergeRequestExpiredExtraDetails.secondaryTeamValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamMergeRequestExpiredExtraDetails deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamMergeRequestExpiredExtraDetails teamMergeRequestExpiredExtraDetailsSecondaryTeam;
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
                teamMergeRequestExpiredExtraDetailsSecondaryTeam = TeamMergeRequestExpiredExtraDetails.primaryTeam(PrimaryTeamRequestExpiredDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("secondary_team".equals(tag)) {
                teamMergeRequestExpiredExtraDetailsSecondaryTeam = TeamMergeRequestExpiredExtraDetails.secondaryTeam(SecondaryTeamRequestExpiredDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                teamMergeRequestExpiredExtraDetailsSecondaryTeam = TeamMergeRequestExpiredExtraDetails.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamMergeRequestExpiredExtraDetailsSecondaryTeam;
        }
    }
}
