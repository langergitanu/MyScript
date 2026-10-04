package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.OrganizationDetails;
import com.dropbox.core.p013v2.teamlog.TeamDetails;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.survicate.surveys.surveys.FormSurveyFieldType;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class FedExtraDetails {
    public static final FedExtraDetails OTHER = new FedExtraDetails().withTag(Tag.OTHER);
    private Tag _tag;
    private OrganizationDetails organizationValue;
    private TeamDetails teamValue;

    public enum Tag {
        ORGANIZATION,
        TEAM,
        OTHER
    }

    private FedExtraDetails() {
    }

    private FedExtraDetails withTag(Tag tag) {
        FedExtraDetails fedExtraDetails = new FedExtraDetails();
        fedExtraDetails._tag = tag;
        return fedExtraDetails;
    }

    private FedExtraDetails withTagAndOrganization(Tag tag, OrganizationDetails organizationDetails) {
        FedExtraDetails fedExtraDetails = new FedExtraDetails();
        fedExtraDetails._tag = tag;
        fedExtraDetails.organizationValue = organizationDetails;
        return fedExtraDetails;
    }

    private FedExtraDetails withTagAndTeam(Tag tag, TeamDetails teamDetails) {
        FedExtraDetails fedExtraDetails = new FedExtraDetails();
        fedExtraDetails._tag = tag;
        fedExtraDetails.teamValue = teamDetails;
        return fedExtraDetails;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isOrganization() {
        return this._tag == Tag.ORGANIZATION;
    }

    public static FedExtraDetails organization(OrganizationDetails organizationDetails) {
        if (organizationDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FedExtraDetails().withTagAndOrganization(Tag.ORGANIZATION, organizationDetails);
    }

    public OrganizationDetails getOrganizationValue() {
        if (this._tag != Tag.ORGANIZATION) {
            throw new IllegalStateException("Invalid tag: required Tag.ORGANIZATION, but was Tag." + this._tag.name());
        }
        return this.organizationValue;
    }

    public boolean isTeam() {
        return this._tag == Tag.TEAM;
    }

    public static FedExtraDetails team(TeamDetails teamDetails) {
        if (teamDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FedExtraDetails().withTagAndTeam(Tag.TEAM, teamDetails);
    }

    public TeamDetails getTeamValue() {
        if (this._tag != Tag.TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM, but was Tag." + this._tag.name());
        }
        return this.teamValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.organizationValue, this.teamValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof FedExtraDetails)) {
            return false;
        }
        FedExtraDetails fedExtraDetails = (FedExtraDetails) obj;
        if (this._tag != fedExtraDetails._tag) {
            return false;
        }
        int i = C44731.$SwitchMap$com$dropbox$core$v2$teamlog$FedExtraDetails$Tag[this._tag.ordinal()];
        if (i == 1) {
            OrganizationDetails organizationDetails = this.organizationValue;
            OrganizationDetails organizationDetails2 = fedExtraDetails.organizationValue;
            return organizationDetails == organizationDetails2 || organizationDetails.equals(organizationDetails2);
        }
        if (i != 2) {
            return i == 3;
        }
        TeamDetails teamDetails = this.teamValue;
        TeamDetails teamDetails2 = fedExtraDetails.teamValue;
        return teamDetails == teamDetails2 || teamDetails.equals(teamDetails2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.FedExtraDetails$1 */
    static /* synthetic */ class C44731 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$FedExtraDetails$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$FedExtraDetails$Tag = iArr;
            try {
                iArr[Tag.ORGANIZATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FedExtraDetails$Tag[Tag.TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FedExtraDetails$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<FedExtraDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FedExtraDetails fedExtraDetails, JsonGenerator jsonGenerator) throws IOException {
            int i = C44731.$SwitchMap$com$dropbox$core$v2$teamlog$FedExtraDetails$Tag[fedExtraDetails.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FormSurveyFieldType.ORGANIZATION, jsonGenerator);
                OrganizationDetails.Serializer.INSTANCE.serialize(fedExtraDetails.organizationValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("team", jsonGenerator);
                TeamDetails.Serializer.INSTANCE.serialize(fedExtraDetails.teamValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FedExtraDetails deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FedExtraDetails fedExtraDetailsTeam;
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
            if (FormSurveyFieldType.ORGANIZATION.equals(tag)) {
                fedExtraDetailsTeam = FedExtraDetails.organization(OrganizationDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("team".equals(tag)) {
                fedExtraDetailsTeam = FedExtraDetails.team(TeamDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                fedExtraDetailsTeam = FedExtraDetails.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fedExtraDetailsTeam;
        }
    }
}
