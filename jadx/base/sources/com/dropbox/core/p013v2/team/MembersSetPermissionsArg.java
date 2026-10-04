package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.AdminTier;
import com.dropbox.core.p013v2.team.UserSelectorArg;
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
class MembersSetPermissionsArg {

    @Nonnull
    protected final AdminTier newRole;

    @Nonnull
    protected final UserSelectorArg user;

    public MembersSetPermissionsArg(@Nonnull UserSelectorArg userSelectorArg, @Nonnull AdminTier adminTier) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
        if (adminTier == null) {
            throw new IllegalArgumentException("Required value for 'newRole' is null");
        }
        this.newRole = adminTier;
    }

    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Nonnull
    public AdminTier getNewRole() {
        return this.newRole;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, this.newRole});
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
        MembersSetPermissionsArg membersSetPermissionsArg = (MembersSetPermissionsArg) obj;
        UserSelectorArg userSelectorArg = this.user;
        UserSelectorArg userSelectorArg2 = membersSetPermissionsArg.user;
        return (userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2)) && ((adminTier = this.newRole) == (adminTier2 = membersSetPermissionsArg.newRole) || adminTier.equals(adminTier2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersSetPermissionsArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersSetPermissionsArg membersSetPermissionsArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(membersSetPermissionsArg.user, jsonGenerator);
            jsonGenerator.writeFieldName("new_role");
            AdminTier.Serializer.INSTANCE.serialize(membersSetPermissionsArg.newRole, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersSetPermissionsArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserSelectorArg userSelectorArgDeserialize = null;
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
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_role".equals(currentName)) {
                        adminTierDeserialize = AdminTier.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                if (adminTierDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_role\" missing.");
                }
                MembersSetPermissionsArg membersSetPermissionsArg = new MembersSetPermissionsArg(userSelectorArgDeserialize, adminTierDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersSetPermissionsArg, membersSetPermissionsArg.toStringMultiline());
                return membersSetPermissionsArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
