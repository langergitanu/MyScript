package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserSelectorArg;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class MembersSetPermissions2Arg {

    @Nullable
    protected final List<String> newRoles;

    @Nonnull
    protected final UserSelectorArg user;

    public MembersSetPermissions2Arg(@Nonnull UserSelectorArg userSelectorArg, @Nullable List<String> list) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
        if (list != null) {
            if (list.size() > 1) {
                throw new IllegalArgumentException("List 'newRoles' has more than 1 items");
            }
            for (String str : list) {
                if (str == null) {
                    throw new IllegalArgumentException("An item in list 'newRoles' is null");
                }
                if (str.length() > 128) {
                    throw new IllegalArgumentException("Stringan item in list 'newRoles' is longer than 128");
                }
                if (!Pattern.matches("pid_dbtmr:.*", str)) {
                    throw new IllegalArgumentException("Stringan item in list 'newRoles' does not match pattern");
                }
            }
        }
        this.newRoles = list;
    }

    public MembersSetPermissions2Arg(@Nonnull UserSelectorArg userSelectorArg) {
        this(userSelectorArg, null);
    }

    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Nullable
    public List<String> getNewRoles() {
        return this.newRoles;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, this.newRoles});
    }

    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MembersSetPermissions2Arg membersSetPermissions2Arg = (MembersSetPermissions2Arg) obj;
        UserSelectorArg userSelectorArg = this.user;
        UserSelectorArg userSelectorArg2 = membersSetPermissions2Arg.user;
        return (userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2)) && ((list = this.newRoles) == (list2 = membersSetPermissions2Arg.newRoles) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersSetPermissions2Arg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersSetPermissions2Arg membersSetPermissions2Arg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(membersSetPermissions2Arg.user, jsonGenerator);
            if (membersSetPermissions2Arg.newRoles != null) {
                jsonGenerator.writeFieldName("new_roles");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(membersSetPermissions2Arg.newRoles, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersSetPermissions2Arg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserSelectorArg userSelectorArgDeserialize = null;
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
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_roles".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                MembersSetPermissions2Arg membersSetPermissions2Arg = new MembersSetPermissions2Arg(userSelectorArgDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersSetPermissions2Arg, membersSetPermissions2Arg.toStringMultiline());
                return membersSetPermissions2Arg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
