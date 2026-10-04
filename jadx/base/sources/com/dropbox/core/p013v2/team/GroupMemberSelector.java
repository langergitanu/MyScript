package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupSelector;
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
class GroupMemberSelector {

    @Nonnull
    protected final GroupSelector group;

    @Nonnull
    protected final UserSelectorArg user;

    public GroupMemberSelector(@Nonnull GroupSelector groupSelector, @Nonnull UserSelectorArg userSelectorArg) {
        if (groupSelector == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = groupSelector;
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
    }

    @Nonnull
    public GroupSelector getGroup() {
        return this.group;
    }

    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.group, this.user});
    }

    public boolean equals(Object obj) {
        UserSelectorArg userSelectorArg;
        UserSelectorArg userSelectorArg2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GroupMemberSelector groupMemberSelector = (GroupMemberSelector) obj;
        GroupSelector groupSelector = this.group;
        GroupSelector groupSelector2 = groupMemberSelector.group;
        return (groupSelector == groupSelector2 || groupSelector.equals(groupSelector2)) && ((userSelectorArg = this.user) == (userSelectorArg2 = groupMemberSelector.user) || userSelectorArg.equals(userSelectorArg2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    private static class Serializer extends StructSerializer<GroupMemberSelector> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupMemberSelector groupMemberSelector, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(groupMemberSelector.group, jsonGenerator);
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(groupMemberSelector.user, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupMemberSelector deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            GroupSelector groupSelectorDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                UserSelectorArg userSelectorArgDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("group".equals(currentName)) {
                        groupSelectorDeserialize = GroupSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (groupSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group\" missing.");
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                GroupMemberSelector groupMemberSelector = new GroupMemberSelector(groupSelectorDeserialize, userSelectorArgDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupMemberSelector, groupMemberSelector.toStringMultiline());
                return groupMemberSelector;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
