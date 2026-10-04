package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.GroupMembershipInfo;
import com.dropbox.core.p013v2.sharing.InviteeMembershipInfo;
import com.dropbox.core.p013v2.sharing.UserFileMembershipInfo;
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

/* JADX INFO: loaded from: classes4.dex */
public class SharedFileMembers {

    @Nullable
    protected final String cursor;

    @Nonnull
    protected final List<GroupMembershipInfo> groups;

    @Nonnull
    protected final List<InviteeMembershipInfo> invitees;

    @Nonnull
    protected final List<UserFileMembershipInfo> users;

    public SharedFileMembers(@Nonnull List<UserFileMembershipInfo> list, @Nonnull List<GroupMembershipInfo> list2, @Nonnull List<InviteeMembershipInfo> list3, @Nullable String str) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        Iterator<UserFileMembershipInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = list;
        if (list2 == null) {
            throw new IllegalArgumentException("Required value for 'groups' is null");
        }
        Iterator<GroupMembershipInfo> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("An item in list 'groups' is null");
            }
        }
        this.groups = list2;
        if (list3 == null) {
            throw new IllegalArgumentException("Required value for 'invitees' is null");
        }
        Iterator<InviteeMembershipInfo> it3 = list3.iterator();
        while (it3.hasNext()) {
            if (it3.next() == null) {
                throw new IllegalArgumentException("An item in list 'invitees' is null");
            }
        }
        this.invitees = list3;
        this.cursor = str;
    }

    public SharedFileMembers(@Nonnull List<UserFileMembershipInfo> list, @Nonnull List<GroupMembershipInfo> list2, @Nonnull List<InviteeMembershipInfo> list3) {
        this(list, list2, list3, null);
    }

    @Nonnull
    public List<UserFileMembershipInfo> getUsers() {
        return this.users;
    }

    @Nonnull
    public List<GroupMembershipInfo> getGroups() {
        return this.groups;
    }

    @Nonnull
    public List<InviteeMembershipInfo> getInvitees() {
        return this.invitees;
    }

    @Nullable
    public String getCursor() {
        return this.cursor;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.users, this.groups, this.invitees, this.cursor});
    }

    public boolean equals(Object obj) {
        List<GroupMembershipInfo> list;
        List<GroupMembershipInfo> list2;
        List<InviteeMembershipInfo> list3;
        List<InviteeMembershipInfo> list4;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedFileMembers sharedFileMembers = (SharedFileMembers) obj;
        List<UserFileMembershipInfo> list5 = this.users;
        List<UserFileMembershipInfo> list6 = sharedFileMembers.users;
        return (list5 == list6 || list5.equals(list6)) && ((list = this.groups) == (list2 = sharedFileMembers.groups) || list.equals(list2)) && (((list3 = this.invitees) == (list4 = sharedFileMembers.invitees) || list3.equals(list4)) && ((str = this.cursor) == (str2 = sharedFileMembers.cursor) || (str != null && str.equals(str2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedFileMembers> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFileMembers sharedFileMembers, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("users");
            StoneSerializers.list(UserFileMembershipInfo.Serializer.INSTANCE).serialize(sharedFileMembers.users, jsonGenerator);
            jsonGenerator.writeFieldName("groups");
            StoneSerializers.list(GroupMembershipInfo.Serializer.INSTANCE).serialize(sharedFileMembers.groups, jsonGenerator);
            jsonGenerator.writeFieldName("invitees");
            StoneSerializers.list(InviteeMembershipInfo.Serializer.INSTANCE).serialize(sharedFileMembers.invitees, jsonGenerator);
            if (sharedFileMembers.cursor != null) {
                jsonGenerator.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFileMembers.cursor, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFileMembers deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list2 = null;
                List list3 = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("users".equals(currentName)) {
                        list = (List) StoneSerializers.list(UserFileMembershipInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("groups".equals(currentName)) {
                        list2 = (List) StoneSerializers.list(GroupMembershipInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("invitees".equals(currentName)) {
                        list3 = (List) StoneSerializers.list(InviteeMembershipInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"users\" missing.");
                }
                if (list2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"groups\" missing.");
                }
                if (list3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"invitees\" missing.");
                }
                SharedFileMembers sharedFileMembers = new SharedFileMembers(list, list2, list3, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFileMembers, sharedFileMembers.toStringMultiline());
                return sharedFileMembers;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
