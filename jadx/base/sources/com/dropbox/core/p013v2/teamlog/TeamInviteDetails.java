package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.InviteMethod;
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
public class TeamInviteDetails {

    @Nullable
    protected final Boolean additionalLicensePurchase;

    @Nonnull
    protected final InviteMethod inviteMethod;

    public TeamInviteDetails(@Nonnull InviteMethod inviteMethod, @Nullable Boolean bool) {
        if (inviteMethod == null) {
            throw new IllegalArgumentException("Required value for 'inviteMethod' is null");
        }
        this.inviteMethod = inviteMethod;
        this.additionalLicensePurchase = bool;
    }

    public TeamInviteDetails(@Nonnull InviteMethod inviteMethod) {
        this(inviteMethod, null);
    }

    @Nonnull
    public InviteMethod getInviteMethod() {
        return this.inviteMethod;
    }

    @Nullable
    public Boolean getAdditionalLicensePurchase() {
        return this.additionalLicensePurchase;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.inviteMethod, this.additionalLicensePurchase});
    }

    public boolean equals(Object obj) {
        Boolean bool;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamInviteDetails teamInviteDetails = (TeamInviteDetails) obj;
        InviteMethod inviteMethod = this.inviteMethod;
        InviteMethod inviteMethod2 = teamInviteDetails.inviteMethod;
        return (inviteMethod == inviteMethod2 || inviteMethod.equals(inviteMethod2)) && ((bool = this.additionalLicensePurchase) == (bool2 = teamInviteDetails.additionalLicensePurchase) || (bool != null && bool.equals(bool2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamInviteDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamInviteDetails teamInviteDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("invite_method");
            InviteMethod.Serializer.INSTANCE.serialize(teamInviteDetails.inviteMethod, jsonGenerator);
            if (teamInviteDetails.additionalLicensePurchase != null) {
                jsonGenerator.writeFieldName("additional_license_purchase");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(teamInviteDetails.additionalLicensePurchase, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamInviteDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            InviteMethod inviteMethodDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean bool = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("invite_method".equals(currentName)) {
                        inviteMethodDeserialize = InviteMethod.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("additional_license_purchase".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (inviteMethodDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"invite_method\" missing.");
                }
                TeamInviteDetails teamInviteDetails = new TeamInviteDetails(inviteMethodDeserialize, bool);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamInviteDetails, teamInviteDetails.toStringMultiline());
                return teamInviteDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
