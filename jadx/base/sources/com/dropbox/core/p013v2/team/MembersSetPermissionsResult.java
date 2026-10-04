package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.AdminTier;
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

/* JADX INFO: loaded from: classes5.dex */
public class MembersSetPermissionsResult {

    @Nonnull
    protected final AdminTier role;

    @Nonnull
    protected final String teamMemberId;

    public MembersSetPermissionsResult(@Nonnull String str, @Nonnull AdminTier adminTier) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = str;
        if (adminTier == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = adminTier;
    }

    @Nonnull
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    @Nonnull
    public AdminTier getRole() {
        return this.role;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamMemberId, this.role});
    }

    public boolean equals(Object obj) {
        AdminTier adminTier;
        AdminTier adminTier2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MembersSetPermissionsResult membersSetPermissionsResult = (MembersSetPermissionsResult) obj;
        String str = this.teamMemberId;
        String str2 = membersSetPermissionsResult.teamMemberId;
        return (str == str2 || str.equals(str2)) && ((adminTier = this.role) == (adminTier2 = membersSetPermissionsResult.role) || adminTier.equals(adminTier2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersSetPermissionsResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersSetPermissionsResult membersSetPermissionsResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(membersSetPermissionsResult.teamMemberId, jsonGenerator);
            jsonGenerator.writeFieldName("role");
            AdminTier.Serializer.INSTANCE.serialize(membersSetPermissionsResult.role, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersSetPermissionsResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AdminTier adminTierDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_member_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("role".equals(currentName)) {
                        adminTierDeserialize = AdminTier.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_member_id\" missing.");
                }
                if (adminTierDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"role\" missing.");
                }
                MembersSetPermissionsResult membersSetPermissionsResult = new MembersSetPermissionsResult(strDeserialize, adminTierDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersSetPermissionsResult, membersSetPermissionsResult.toStringMultiline());
                return membersSetPermissionsResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
