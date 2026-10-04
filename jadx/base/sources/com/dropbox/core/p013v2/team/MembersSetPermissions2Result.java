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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class MembersSetPermissions2Result {

    @Nullable
    protected final List<TeamMemberRole> roles;

    @Nonnull
    protected final String teamMemberId;

    public MembersSetPermissions2Result(@Nonnull String str, @Nullable List<TeamMemberRole> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = str;
        if (list != null) {
            Iterator<TeamMemberRole> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'roles' is null");
                }
            }
        }
        this.roles = list;
    }

    public MembersSetPermissions2Result(@Nonnull String str) {
        this(str, null);
    }

    @Nonnull
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    @Nullable
    public List<TeamMemberRole> getRoles() {
        return this.roles;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamMemberId, this.roles});
    }

    public boolean equals(Object obj) {
        List<TeamMemberRole> list;
        List<TeamMemberRole> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MembersSetPermissions2Result membersSetPermissions2Result = (MembersSetPermissions2Result) obj;
        String str = this.teamMemberId;
        String str2 = membersSetPermissions2Result.teamMemberId;
        return (str == str2 || str.equals(str2)) && ((list = this.roles) == (list2 = membersSetPermissions2Result.roles) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersSetPermissions2Result> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersSetPermissions2Result membersSetPermissions2Result, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(membersSetPermissions2Result.teamMemberId, jsonGenerator);
            if (membersSetPermissions2Result.roles != null) {
                jsonGenerator.writeFieldName("roles");
                StoneSerializers.nullable(StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE)).serialize(membersSetPermissions2Result.roles, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersSetPermissions2Result deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_member_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("roles".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(TeamMemberRole.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_member_id\" missing.");
                }
                MembersSetPermissions2Result membersSetPermissions2Result = new MembersSetPermissions2Result(strDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersSetPermissions2Result, membersSetPermissions2Result.toStringMultiline());
                return membersSetPermissions2Result;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
