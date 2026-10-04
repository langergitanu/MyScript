package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class GuestAdminSignedOutViaTrustedTeamsDetails {

    @Nullable
    protected final String teamName;

    @Nullable
    protected final String trustedTeamName;

    public GuestAdminSignedOutViaTrustedTeamsDetails(@Nullable String str, @Nullable String str2) {
        this.teamName = str;
        this.trustedTeamName = str2;
    }

    public GuestAdminSignedOutViaTrustedTeamsDetails() {
        this(null, null);
    }

    @Nullable
    public String getTeamName() {
        return this.teamName;
    }

    @Nullable
    public String getTrustedTeamName() {
        return this.trustedTeamName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String teamName = null;
        protected String trustedTeamName = null;

        protected Builder() {
        }

        public Builder withTeamName(String str) {
            this.teamName = str;
            return this;
        }

        public Builder withTrustedTeamName(String str) {
            this.trustedTeamName = str;
            return this;
        }

        public GuestAdminSignedOutViaTrustedTeamsDetails build() {
            return new GuestAdminSignedOutViaTrustedTeamsDetails(this.teamName, this.trustedTeamName);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamName, this.trustedTeamName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GuestAdminSignedOutViaTrustedTeamsDetails guestAdminSignedOutViaTrustedTeamsDetails = (GuestAdminSignedOutViaTrustedTeamsDetails) obj;
        String str3 = this.teamName;
        String str4 = guestAdminSignedOutViaTrustedTeamsDetails.teamName;
        return (str3 == str4 || (str3 != null && str3.equals(str4))) && ((str = this.trustedTeamName) == (str2 = guestAdminSignedOutViaTrustedTeamsDetails.trustedTeamName) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GuestAdminSignedOutViaTrustedTeamsDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GuestAdminSignedOutViaTrustedTeamsDetails guestAdminSignedOutViaTrustedTeamsDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (guestAdminSignedOutViaTrustedTeamsDetails.teamName != null) {
                jsonGenerator.writeFieldName("team_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(guestAdminSignedOutViaTrustedTeamsDetails.teamName, jsonGenerator);
            }
            if (guestAdminSignedOutViaTrustedTeamsDetails.trustedTeamName != null) {
                jsonGenerator.writeFieldName("trusted_team_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(guestAdminSignedOutViaTrustedTeamsDetails.trustedTeamName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GuestAdminSignedOutViaTrustedTeamsDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("trusted_team_name".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                GuestAdminSignedOutViaTrustedTeamsDetails guestAdminSignedOutViaTrustedTeamsDetails = new GuestAdminSignedOutViaTrustedTeamsDetails(str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(guestAdminSignedOutViaTrustedTeamsDetails, guestAdminSignedOutViaTrustedTeamsDetails.toStringMultiline());
                return guestAdminSignedOutViaTrustedTeamsDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
