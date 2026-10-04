package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamMemberRole;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class MembersGetAvailableTeamMemberRolesResult {

    @Nonnull
    protected final List<TeamMemberRole> roles;

    public MembersGetAvailableTeamMemberRolesResult(@Nonnull List<TeamMemberRole> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'roles' is null");
        }
        Iterator<TeamMemberRole> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'roles' is null");
            }
        }
        this.roles = list;
    }

    @Nonnull
    public List<TeamMemberRole> getRoles() {
        return this.roles;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.roles});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<TeamMemberRole> list = this.roles;
        List<TeamMemberRole> list2 = ((MembersGetAvailableTeamMemberRolesResult) obj).roles;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersGetAvailableTeamMemberRolesResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersGetAvailableTeamMemberRolesResult membersGetAvailableTeamMemberRolesResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("roles");
            StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE).serialize(membersGetAvailableTeamMemberRolesResult.roles, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersGetAvailableTeamMemberRolesResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
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
                    if ("roles".equals(currentName)) {
                        list = (List) StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"roles\" missing.");
                }
                MembersGetAvailableTeamMemberRolesResult membersGetAvailableTeamMemberRolesResult = new MembersGetAvailableTeamMemberRolesResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersGetAvailableTeamMemberRolesResult, membersGetAvailableTeamMemberRolesResult.toStringMultiline());
                return membersGetAvailableTeamMemberRolesResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
