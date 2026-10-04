package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FedHandshakeAction;
import com.dropbox.core.p013v2.teamlog.FederationStatusChangeAdditionalInfo;
import com.dropbox.core.p013v2.teamlog.TrustedTeamsRequestState;
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
public class ChangedEnterpriseConnectedTeamStatusDetails {

    @Nonnull
    protected final FedHandshakeAction action;

    @Nonnull
    protected final FederationStatusChangeAdditionalInfo additionalInfo;

    @Nonnull
    protected final TrustedTeamsRequestState newValue;

    @Nonnull
    protected final TrustedTeamsRequestState previousValue;

    public ChangedEnterpriseConnectedTeamStatusDetails(@Nonnull FedHandshakeAction fedHandshakeAction, @Nonnull FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfo, @Nonnull TrustedTeamsRequestState trustedTeamsRequestState, @Nonnull TrustedTeamsRequestState trustedTeamsRequestState2) {
        if (fedHandshakeAction == null) {
            throw new IllegalArgumentException("Required value for 'action' is null");
        }
        this.action = fedHandshakeAction;
        if (federationStatusChangeAdditionalInfo == null) {
            throw new IllegalArgumentException("Required value for 'additionalInfo' is null");
        }
        this.additionalInfo = federationStatusChangeAdditionalInfo;
        if (trustedTeamsRequestState == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = trustedTeamsRequestState;
        if (trustedTeamsRequestState2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = trustedTeamsRequestState2;
    }

    @Nonnull
    public FedHandshakeAction getAction() {
        return this.action;
    }

    @Nonnull
    public FederationStatusChangeAdditionalInfo getAdditionalInfo() {
        return this.additionalInfo;
    }

    @Nonnull
    public TrustedTeamsRequestState getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public TrustedTeamsRequestState getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.action, this.additionalInfo, this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfo;
        FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfo2;
        TrustedTeamsRequestState trustedTeamsRequestState;
        TrustedTeamsRequestState trustedTeamsRequestState2;
        TrustedTeamsRequestState trustedTeamsRequestState3;
        TrustedTeamsRequestState trustedTeamsRequestState4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ChangedEnterpriseConnectedTeamStatusDetails changedEnterpriseConnectedTeamStatusDetails = (ChangedEnterpriseConnectedTeamStatusDetails) obj;
        FedHandshakeAction fedHandshakeAction = this.action;
        FedHandshakeAction fedHandshakeAction2 = changedEnterpriseConnectedTeamStatusDetails.action;
        return (fedHandshakeAction == fedHandshakeAction2 || fedHandshakeAction.equals(fedHandshakeAction2)) && ((federationStatusChangeAdditionalInfo = this.additionalInfo) == (federationStatusChangeAdditionalInfo2 = changedEnterpriseConnectedTeamStatusDetails.additionalInfo) || federationStatusChangeAdditionalInfo.equals(federationStatusChangeAdditionalInfo2)) && (((trustedTeamsRequestState = this.previousValue) == (trustedTeamsRequestState2 = changedEnterpriseConnectedTeamStatusDetails.previousValue) || trustedTeamsRequestState.equals(trustedTeamsRequestState2)) && ((trustedTeamsRequestState3 = this.newValue) == (trustedTeamsRequestState4 = changedEnterpriseConnectedTeamStatusDetails.newValue) || trustedTeamsRequestState3.equals(trustedTeamsRequestState4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ChangedEnterpriseConnectedTeamStatusDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ChangedEnterpriseConnectedTeamStatusDetails changedEnterpriseConnectedTeamStatusDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("action");
            FedHandshakeAction.Serializer.INSTANCE.serialize(changedEnterpriseConnectedTeamStatusDetails.action, jsonGenerator);
            jsonGenerator.writeFieldName("additional_info");
            FederationStatusChangeAdditionalInfo.Serializer.INSTANCE.serialize(changedEnterpriseConnectedTeamStatusDetails.additionalInfo, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            TrustedTeamsRequestState.Serializer.INSTANCE.serialize(changedEnterpriseConnectedTeamStatusDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            TrustedTeamsRequestState.Serializer.INSTANCE.serialize(changedEnterpriseConnectedTeamStatusDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ChangedEnterpriseConnectedTeamStatusDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FedHandshakeAction fedHandshakeActionDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FederationStatusChangeAdditionalInfo federationStatusChangeAdditionalInfoDeserialize = null;
                TrustedTeamsRequestState trustedTeamsRequestStateDeserialize = null;
                TrustedTeamsRequestState trustedTeamsRequestStateDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("action".equals(currentName)) {
                        fedHandshakeActionDeserialize = FedHandshakeAction.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("additional_info".equals(currentName)) {
                        federationStatusChangeAdditionalInfoDeserialize = FederationStatusChangeAdditionalInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        trustedTeamsRequestStateDeserialize = TrustedTeamsRequestState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        trustedTeamsRequestStateDeserialize2 = TrustedTeamsRequestState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fedHandshakeActionDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"action\" missing.");
                }
                if (federationStatusChangeAdditionalInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"additional_info\" missing.");
                }
                if (trustedTeamsRequestStateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (trustedTeamsRequestStateDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                ChangedEnterpriseConnectedTeamStatusDetails changedEnterpriseConnectedTeamStatusDetails = new ChangedEnterpriseConnectedTeamStatusDetails(fedHandshakeActionDeserialize, federationStatusChangeAdditionalInfoDeserialize, trustedTeamsRequestStateDeserialize, trustedTeamsRequestStateDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(changedEnterpriseConnectedTeamStatusDetails, changedEnterpriseConnectedTeamStatusDetails.toStringMultiline());
                return changedEnterpriseConnectedTeamStatusDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
