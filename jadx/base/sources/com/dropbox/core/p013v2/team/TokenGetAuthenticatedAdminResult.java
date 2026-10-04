package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamMemberProfile;
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
public class TokenGetAuthenticatedAdminResult {

    @Nonnull
    protected final TeamMemberProfile adminProfile;

    public TokenGetAuthenticatedAdminResult(@Nonnull TeamMemberProfile teamMemberProfile) {
        if (teamMemberProfile == null) {
            throw new IllegalArgumentException("Required value for 'adminProfile' is null");
        }
        this.adminProfile = teamMemberProfile;
    }

    @Nonnull
    public TeamMemberProfile getAdminProfile() {
        return this.adminProfile;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.adminProfile});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMemberProfile teamMemberProfile = this.adminProfile;
        TeamMemberProfile teamMemberProfile2 = ((TokenGetAuthenticatedAdminResult) obj).adminProfile;
        return teamMemberProfile == teamMemberProfile2 || teamMemberProfile.equals(teamMemberProfile2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TokenGetAuthenticatedAdminResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TokenGetAuthenticatedAdminResult tokenGetAuthenticatedAdminResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("admin_profile");
            TeamMemberProfile.Serializer.INSTANCE.serialize(tokenGetAuthenticatedAdminResult.adminProfile, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TokenGetAuthenticatedAdminResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TeamMemberProfile teamMemberProfileDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("admin_profile".equals(currentName)) {
                        teamMemberProfileDeserialize = TeamMemberProfile.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (teamMemberProfileDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"admin_profile\" missing.");
                }
                TokenGetAuthenticatedAdminResult tokenGetAuthenticatedAdminResult = new TokenGetAuthenticatedAdminResult(teamMemberProfileDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(tokenGetAuthenticatedAdminResult, tokenGetAuthenticatedAdminResult.toStringMultiline());
                return tokenGetAuthenticatedAdminResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
