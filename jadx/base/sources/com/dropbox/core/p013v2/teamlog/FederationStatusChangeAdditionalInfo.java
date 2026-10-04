package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ConnectedTeamName;
import com.dropbox.core.p013v2.teamlog.NonTrustedTeamDetails;
import com.dropbox.core.p013v2.teamlog.OrganizationName;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class FederationStatusChangeAdditionalInfo {
    public static final FederationStatusChangeAdditionalInfo OTHER = new FederationStatusChangeAdditionalInfo().withTag(Tag.OTHER);
    private Tag _tag;
    private ConnectedTeamName connectedTeamNameValue;
    private NonTrustedTeamDetails nonTrustedTeamDetailsValue;
    private OrganizationName organizationNameValue;

    public enum Tag {
        CONNECTED_TEAM_NAME,
        NON_TRUSTED_TEAM_DETAILS,
        ORGANIZATION_NAME,
        OTHER
    }

    private FederationStatusChangeAdditionalInfo() {
    }

    private FederationStatusChangeAdditionalInfo withTag(Tag tag) {
        FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfo = new FederationStatusChangeAdditionalInfo();
        federationStatusChangeAdditionalInfo._tag = tag;
        return federationStatusChangeAdditionalInfo;
    }

    private FederationStatusChangeAdditionalInfo withTagAndConnectedTeamName(Tag tag, ConnectedTeamName connectedTeamName) {
        FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfo = new FederationStatusChangeAdditionalInfo();
        federationStatusChangeAdditionalInfo._tag = tag;
        federationStatusChangeAdditionalInfo.connectedTeamNameValue = connectedTeamName;
        return federationStatusChangeAdditionalInfo;
    }

    private FederationStatusChangeAdditionalInfo withTagAndNonTrustedTeamDetails(Tag tag, NonTrustedTeamDetails nonTrustedTeamDetails) {
        FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfo = new FederationStatusChangeAdditionalInfo();
        federationStatusChangeAdditionalInfo._tag = tag;
        federationStatusChangeAdditionalInfo.nonTrustedTeamDetailsValue = nonTrustedTeamDetails;
        return federationStatusChangeAdditionalInfo;
    }

    private FederationStatusChangeAdditionalInfo withTagAndOrganizationName(Tag tag, OrganizationName organizationName) {
        FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfo = new FederationStatusChangeAdditionalInfo();
        federationStatusChangeAdditionalInfo._tag = tag;
        federationStatusChangeAdditionalInfo.organizationNameValue = organizationName;
        return federationStatusChangeAdditionalInfo;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isConnectedTeamName() {
        return this._tag == Tag.CONNECTED_TEAM_NAME;
    }

    public static FederationStatusChangeAdditionalInfo connectedTeamName(ConnectedTeamName connectedTeamName) {
        if (connectedTeamName == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FederationStatusChangeAdditionalInfo().withTagAndConnectedTeamName(Tag.CONNECTED_TEAM_NAME, connectedTeamName);
    }

    public ConnectedTeamName getConnectedTeamNameValue() {
        if (this._tag != Tag.CONNECTED_TEAM_NAME) {
            throw new IllegalStateException("Invalid tag: required Tag.CONNECTED_TEAM_NAME, but was Tag." + this._tag.name());
        }
        return this.connectedTeamNameValue;
    }

    public boolean isNonTrustedTeamDetails() {
        return this._tag == Tag.NON_TRUSTED_TEAM_DETAILS;
    }

    public static FederationStatusChangeAdditionalInfo nonTrustedTeamDetails(NonTrustedTeamDetails nonTrustedTeamDetails) {
        if (nonTrustedTeamDetails == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FederationStatusChangeAdditionalInfo().withTagAndNonTrustedTeamDetails(Tag.NON_TRUSTED_TEAM_DETAILS, nonTrustedTeamDetails);
    }

    public NonTrustedTeamDetails getNonTrustedTeamDetailsValue() {
        if (this._tag != Tag.NON_TRUSTED_TEAM_DETAILS) {
            throw new IllegalStateException("Invalid tag: required Tag.NON_TRUSTED_TEAM_DETAILS, but was Tag." + this._tag.name());
        }
        return this.nonTrustedTeamDetailsValue;
    }

    public boolean isOrganizationName() {
        return this._tag == Tag.ORGANIZATION_NAME;
    }

    public static FederationStatusChangeAdditionalInfo organizationName(OrganizationName organizationName) {
        if (organizationName == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FederationStatusChangeAdditionalInfo().withTagAndOrganizationName(Tag.ORGANIZATION_NAME, organizationName);
    }

    public OrganizationName getOrganizationNameValue() {
        if (this._tag != Tag.ORGANIZATION_NAME) {
            throw new IllegalStateException("Invalid tag: required Tag.ORGANIZATION_NAME, but was Tag." + this._tag.name());
        }
        return this.organizationNameValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.connectedTeamNameValue, this.nonTrustedTeamDetailsValue, this.organizationNameValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof FederationStatusChangeAdditionalInfo)) {
            return false;
        }
        FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfo = (FederationStatusChangeAdditionalInfo) obj;
        if (this._tag != federationStatusChangeAdditionalInfo._tag) {
            return false;
        }
        int i = C44751.f789x63a5ff9b[this._tag.ordinal()];
        if (i == 1) {
            ConnectedTeamName connectedTeamName = this.connectedTeamNameValue;
            ConnectedTeamName connectedTeamName2 = federationStatusChangeAdditionalInfo.connectedTeamNameValue;
            return connectedTeamName == connectedTeamName2 || connectedTeamName.equals(connectedTeamName2);
        }
        if (i == 2) {
            NonTrustedTeamDetails nonTrustedTeamDetails = this.nonTrustedTeamDetailsValue;
            NonTrustedTeamDetails nonTrustedTeamDetails2 = federationStatusChangeAdditionalInfo.nonTrustedTeamDetailsValue;
            return nonTrustedTeamDetails == nonTrustedTeamDetails2 || nonTrustedTeamDetails.equals(nonTrustedTeamDetails2);
        }
        if (i != 3) {
            return i == 4;
        }
        OrganizationName organizationName = this.organizationNameValue;
        OrganizationName organizationName2 = federationStatusChangeAdditionalInfo.organizationNameValue;
        return organizationName == organizationName2 || organizationName.equals(organizationName2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.FederationStatusChangeAdditionalInfo$1 */
    static /* synthetic */ class C44751 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$FederationStatusChangeAdditionalInfo$Tag */
        static final /* synthetic */ int[] f789x63a5ff9b;

        static {
            int[] iArr = new int[Tag.values().length];
            f789x63a5ff9b = iArr;
            try {
                iArr[Tag.CONNECTED_TEAM_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f789x63a5ff9b[Tag.NON_TRUSTED_TEAM_DETAILS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f789x63a5ff9b[Tag.ORGANIZATION_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f789x63a5ff9b[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<FederationStatusChangeAdditionalInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfo, JsonGenerator jsonGenerator) throws IOException {
            int i = C44751.f789x63a5ff9b[federationStatusChangeAdditionalInfo.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("connected_team_name", jsonGenerator);
                ConnectedTeamName.Serializer.INSTANCE.serialize(federationStatusChangeAdditionalInfo.connectedTeamNameValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("non_trusted_team_details", jsonGenerator);
                NonTrustedTeamDetails.Serializer.INSTANCE.serialize(federationStatusChangeAdditionalInfo.nonTrustedTeamDetailsValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("organization_name", jsonGenerator);
                OrganizationName.Serializer.INSTANCE.serialize(federationStatusChangeAdditionalInfo.organizationNameValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FederationStatusChangeAdditionalInfo deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfoOrganizationName;
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
            if ("connected_team_name".equals(tag)) {
                federationStatusChangeAdditionalInfoOrganizationName = FederationStatusChangeAdditionalInfo.connectedTeamName(ConnectedTeamName.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("non_trusted_team_details".equals(tag)) {
                federationStatusChangeAdditionalInfoOrganizationName = FederationStatusChangeAdditionalInfo.nonTrustedTeamDetails(NonTrustedTeamDetails.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("organization_name".equals(tag)) {
                federationStatusChangeAdditionalInfoOrganizationName = FederationStatusChangeAdditionalInfo.organizationName(OrganizationName.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                federationStatusChangeAdditionalInfoOrganizationName = FederationStatusChangeAdditionalInfo.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return federationStatusChangeAdditionalInfoOrganizationName;
        }
    }
}
