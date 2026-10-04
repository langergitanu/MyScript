package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class TeamMemberRole {

    @Nonnull
    protected final String description;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final String roleId;

    public TeamMemberRole(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'roleId' is null");
        }
        if (str.length() > 128) {
            throw new IllegalArgumentException("String 'roleId' is longer than 128");
        }
        if (!Pattern.matches("pid_dbtmr:.*", str)) {
            throw new IllegalArgumentException("String 'roleId' does not match pattern");
        }
        this.roleId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        if (str2.length() > 32) {
            throw new IllegalArgumentException("String 'name' is longer than 32");
        }
        this.name = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'description' is null");
        }
        if (str3.length() > 256) {
            throw new IllegalArgumentException("String 'description' is longer than 256");
        }
        this.description = str3;
    }

    @Nonnull
    public String getRoleId() {
        return this.roleId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.roleId, this.name, this.description});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMemberRole teamMemberRole = (TeamMemberRole) obj;
        String str5 = this.roleId;
        String str6 = teamMemberRole.roleId;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.name) == (str2 = teamMemberRole.name) || str.equals(str2)) && ((str3 = this.description) == (str4 = teamMemberRole.description) || str3.equals(str4));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMemberRole> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMemberRole teamMemberRole, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("role_id");
            StoneSerializers.string().serialize(teamMemberRole.roleId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(teamMemberRole.name, jsonGenerator);
            jsonGenerator.writeFieldName("description");
            StoneSerializers.string().serialize(teamMemberRole.description, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public TeamMemberRole deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("role_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("description".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"role_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"description\" missing.");
                }
                TeamMemberRole teamMemberRole = new TeamMemberRole(strDeserialize, strDeserialize2, strDeserialize3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMemberRole, teamMemberRole.toStringMultiline());
                return teamMemberRole;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
