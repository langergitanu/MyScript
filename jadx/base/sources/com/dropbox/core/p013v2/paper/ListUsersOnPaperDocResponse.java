package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.Cursor;
import com.dropbox.core.p013v2.paper.InviteeInfoWithPermissionLevel;
import com.dropbox.core.p013v2.paper.UserInfoWithPermissionLevel;
import com.dropbox.core.p013v2.sharing.UserInfo;
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

/* JADX INFO: loaded from: classes4.dex */
public class ListUsersOnPaperDocResponse {

    @Nonnull
    protected final Cursor cursor;

    @Nonnull
    protected final UserInfo docOwner;
    protected final boolean hasMore;

    @Nonnull
    protected final List<InviteeInfoWithPermissionLevel> invitees;

    @Nonnull
    protected final List<UserInfoWithPermissionLevel> users;

    public ListUsersOnPaperDocResponse(@Nonnull List<InviteeInfoWithPermissionLevel> list, @Nonnull List<UserInfoWithPermissionLevel> list2, @Nonnull UserInfo userInfo, @Nonnull Cursor cursor, boolean z) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'invitees' is null");
        }
        Iterator<InviteeInfoWithPermissionLevel> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'invitees' is null");
            }
        }
        this.invitees = list;
        if (list2 == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        Iterator<UserInfoWithPermissionLevel> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = list2;
        if (userInfo == null) {
            throw new IllegalArgumentException("Required value for 'docOwner' is null");
        }
        this.docOwner = userInfo;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = z;
    }

    @Nonnull
    public List<InviteeInfoWithPermissionLevel> getInvitees() {
        return this.invitees;
    }

    @Nonnull
    public List<UserInfoWithPermissionLevel> getUsers() {
        return this.users;
    }

    @Nonnull
    public UserInfo getDocOwner() {
        return this.docOwner;
    }

    @Nonnull
    public Cursor getCursor() {
        return this.cursor;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.invitees, this.users, this.docOwner, this.cursor, Boolean.valueOf(this.hasMore)});
    }

    public boolean equals(Object obj) {
        ListUsersOnPaperDocResponse listUsersOnPaperDocResponse;
        List<InviteeInfoWithPermissionLevel> list;
        List<InviteeInfoWithPermissionLevel> list2;
        List<UserInfoWithPermissionLevel> list3;
        List<UserInfoWithPermissionLevel> list4;
        UserInfo userInfo;
        UserInfo userInfo2;
        Cursor cursor;
        Cursor cursor2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.invitees) == (list2 = (listUsersOnPaperDocResponse = (ListUsersOnPaperDocResponse) obj).invitees) || list.equals(list2)) && (((list3 = this.users) == (list4 = listUsersOnPaperDocResponse.users) || list3.equals(list4)) && (((userInfo = this.docOwner) == (userInfo2 = listUsersOnPaperDocResponse.docOwner) || userInfo.equals(userInfo2)) && (((cursor = this.cursor) == (cursor2 = listUsersOnPaperDocResponse.cursor) || cursor.equals(cursor2)) && this.hasMore == listUsersOnPaperDocResponse.hasMore)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListUsersOnPaperDocResponse> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListUsersOnPaperDocResponse listUsersOnPaperDocResponse, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("invitees");
            StoneSerializers.list(InviteeInfoWithPermissionLevel.Serializer.INSTANCE).serialize(listUsersOnPaperDocResponse.invitees, jsonGenerator);
            jsonGenerator.writeFieldName("users");
            StoneSerializers.list(UserInfoWithPermissionLevel.Serializer.INSTANCE).serialize(listUsersOnPaperDocResponse.users, jsonGenerator);
            jsonGenerator.writeFieldName("doc_owner");
            UserInfo.Serializer.INSTANCE.serialize(listUsersOnPaperDocResponse.docOwner, jsonGenerator);
            jsonGenerator.writeFieldName("cursor");
            Cursor.Serializer.INSTANCE.serialize(listUsersOnPaperDocResponse.cursor, jsonGenerator);
            jsonGenerator.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listUsersOnPaperDocResponse.hasMore), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListUsersOnPaperDocResponse deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                List list2 = null;
                UserInfo userInfoDeserialize = null;
                Cursor cursorDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("invitees".equals(currentName)) {
                        list = (List) StoneSerializers.list(InviteeInfoWithPermissionLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("users".equals(currentName)) {
                        list2 = (List) StoneSerializers.list(UserInfoWithPermissionLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("doc_owner".equals(currentName)) {
                        userInfoDeserialize = UserInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        cursorDeserialize = Cursor.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("has_more".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"invitees\" missing.");
                }
                if (list2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"users\" missing.");
                }
                if (userInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_owner\" missing.");
                }
                if (cursorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"cursor\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"has_more\" missing.");
                }
                ListUsersOnPaperDocResponse listUsersOnPaperDocResponse = new ListUsersOnPaperDocResponse(list, list2, userInfoDeserialize, cursorDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listUsersOnPaperDocResponse, listUsersOnPaperDocResponse.toStringMultiline());
                return listUsersOnPaperDocResponse;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
