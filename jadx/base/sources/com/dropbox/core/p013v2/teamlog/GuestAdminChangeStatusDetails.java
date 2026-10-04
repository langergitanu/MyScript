package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TrustedTeamsRequestAction;
import com.dropbox.core.p013v2.teamlog.TrustedTeamsRequestState;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class GuestAdminChangeStatusDetails {

    @Nonnull
    protected final TrustedTeamsRequestAction actionDetails;

    @Nullable
    protected final String guestTeamName;

    @Nullable
    protected final String hostTeamName;
    protected final boolean isGuest;

    @Nonnull
    protected final TrustedTeamsRequestState newValue;

    @Nonnull
    protected final TrustedTeamsRequestState previousValue;

    public GuestAdminChangeStatusDetails(boolean z, @Nonnull TrustedTeamsRequestState trustedTeamsRequestState, @Nonnull TrustedTeamsRequestState trustedTeamsRequestState2, @Nonnull TrustedTeamsRequestAction trustedTeamsRequestAction, @Nullable String str, @Nullable String str2) {
        this.isGuest = z;
        this.guestTeamName = str;
        this.hostTeamName = str2;
        if (trustedTeamsRequestState == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = trustedTeamsRequestState;
        if (trustedTeamsRequestState2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = trustedTeamsRequestState2;
        if (trustedTeamsRequestAction == null) {
            throw new IllegalArgumentException("Required value for 'actionDetails' is null");
        }
        this.actionDetails = trustedTeamsRequestAction;
    }

    public GuestAdminChangeStatusDetails(boolean z, @Nonnull TrustedTeamsRequestState trustedTeamsRequestState, @Nonnull TrustedTeamsRequestState trustedTeamsRequestState2, @Nonnull TrustedTeamsRequestAction trustedTeamsRequestAction) {
        this(z, trustedTeamsRequestState, trustedTeamsRequestState2, trustedTeamsRequestAction, null, null);
    }

    public boolean getIsGuest() {
        return this.isGuest;
    }

    @Nonnull
    public TrustedTeamsRequestState getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public TrustedTeamsRequestState getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public TrustedTeamsRequestAction getActionDetails() {
        return this.actionDetails;
    }

    @Nullable
    public String getGuestTeamName() {
        return this.guestTeamName;
    }

    @Nullable
    public String getHostTeamName() {
        return this.hostTeamName;
    }

    public static Builder newBuilder(boolean z, TrustedTeamsRequestState trustedTeamsRequestState, TrustedTeamsRequestState trustedTeamsRequestState2, TrustedTeamsRequestAction trustedTeamsRequestAction) {
        return new Builder(z, trustedTeamsRequestState, trustedTeamsRequestState2, trustedTeamsRequestAction);
    }

    public static class Builder {
        protected final TrustedTeamsRequestAction actionDetails;
        protected String guestTeamName;
        protected String hostTeamName;
        protected final boolean isGuest;
        protected final TrustedTeamsRequestState newValue;
        protected final TrustedTeamsRequestState previousValue;

        protected Builder(boolean z, TrustedTeamsRequestState trustedTeamsRequestState, TrustedTeamsRequestState trustedTeamsRequestState2, TrustedTeamsRequestAction trustedTeamsRequestAction) {
            this.isGuest = z;
            if (trustedTeamsRequestState == null) {
                throw new IllegalArgumentException("Required value for 'previousValue' is null");
            }
            this.previousValue = trustedTeamsRequestState;
            if (trustedTeamsRequestState2 == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = trustedTeamsRequestState2;
            if (trustedTeamsRequestAction == null) {
                throw new IllegalArgumentException("Required value for 'actionDetails' is null");
            }
            this.actionDetails = trustedTeamsRequestAction;
            this.guestTeamName = null;
            this.hostTeamName = null;
        }

        public Builder withGuestTeamName(String str) {
            this.guestTeamName = str;
            return this;
        }

        public Builder withHostTeamName(String str) {
            this.hostTeamName = str;
            return this;
        }

        public GuestAdminChangeStatusDetails build() {
            return new GuestAdminChangeStatusDetails(this.isGuest, this.previousValue, this.newValue, this.actionDetails, this.guestTeamName, this.hostTeamName);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.isGuest), this.guestTeamName, this.hostTeamName, this.previousValue, this.newValue, this.actionDetails});
    }

    public boolean equals(Object obj) {
        TrustedTeamsRequestState trustedTeamsRequestState;
        TrustedTeamsRequestState trustedTeamsRequestState2;
        TrustedTeamsRequestState trustedTeamsRequestState3;
        TrustedTeamsRequestState trustedTeamsRequestState4;
        TrustedTeamsRequestAction trustedTeamsRequestAction;
        TrustedTeamsRequestAction trustedTeamsRequestAction2;
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            GuestAdminChangeStatusDetails guestAdminChangeStatusDetails = (GuestAdminChangeStatusDetails) obj;
            if (this.isGuest == guestAdminChangeStatusDetails.isGuest && (((trustedTeamsRequestState = this.previousValue) == (trustedTeamsRequestState2 = guestAdminChangeStatusDetails.previousValue) || trustedTeamsRequestState.equals(trustedTeamsRequestState2)) && (((trustedTeamsRequestState3 = this.newValue) == (trustedTeamsRequestState4 = guestAdminChangeStatusDetails.newValue) || trustedTeamsRequestState3.equals(trustedTeamsRequestState4)) && (((trustedTeamsRequestAction = this.actionDetails) == (trustedTeamsRequestAction2 = guestAdminChangeStatusDetails.actionDetails) || trustedTeamsRequestAction.equals(trustedTeamsRequestAction2)) && (((str = this.guestTeamName) == (str2 = guestAdminChangeStatusDetails.guestTeamName) || (str != null && str.equals(str2))) && ((str3 = this.hostTeamName) == (str4 = guestAdminChangeStatusDetails.hostTeamName) || (str3 != null && str3.equals(str4)))))))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GuestAdminChangeStatusDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GuestAdminChangeStatusDetails guestAdminChangeStatusDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("is_guest");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(guestAdminChangeStatusDetails.isGuest), jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            TrustedTeamsRequestState.Serializer.INSTANCE.serialize(guestAdminChangeStatusDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            TrustedTeamsRequestState.Serializer.INSTANCE.serialize(guestAdminChangeStatusDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("action_details");
            TrustedTeamsRequestAction.Serializer.INSTANCE.serialize(guestAdminChangeStatusDetails.actionDetails, jsonGenerator);
            if (guestAdminChangeStatusDetails.guestTeamName != null) {
                jsonGenerator.writeFieldName("guest_team_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(guestAdminChangeStatusDetails.guestTeamName, jsonGenerator);
            }
            if (guestAdminChangeStatusDetails.hostTeamName != null) {
                jsonGenerator.writeFieldName("host_team_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(guestAdminChangeStatusDetails.hostTeamName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GuestAdminChangeStatusDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                TrustedTeamsRequestState trustedTeamsRequestStateDeserialize = null;
                TrustedTeamsRequestState trustedTeamsRequestStateDeserialize2 = null;
                TrustedTeamsRequestAction trustedTeamsRequestActionDeserialize = null;
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("is_guest".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        trustedTeamsRequestStateDeserialize = TrustedTeamsRequestState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        trustedTeamsRequestStateDeserialize2 = TrustedTeamsRequestState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("action_details".equals(currentName)) {
                        trustedTeamsRequestActionDeserialize = TrustedTeamsRequestAction.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("guest_team_name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("host_team_name".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_guest\" missing.");
                }
                if (trustedTeamsRequestStateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (trustedTeamsRequestStateDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (trustedTeamsRequestActionDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"action_details\" missing.");
                }
                GuestAdminChangeStatusDetails guestAdminChangeStatusDetails = new GuestAdminChangeStatusDetails(boolDeserialize.booleanValue(), trustedTeamsRequestStateDeserialize, trustedTeamsRequestStateDeserialize2, trustedTeamsRequestActionDeserialize, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(guestAdminChangeStatusDetails, guestAdminChangeStatusDetails.toStringMultiline());
                return guestAdminChangeStatusDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
