package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.Cursor;
import com.dropbox.core.p013v2.sharing.InviteeInfo;
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
public class ListUsersOnFolderResponse {

    @Nonnull
    protected final Cursor cursor;
    protected final boolean hasMore;

    @Nonnull
    protected final List<InviteeInfo> invitees;

    @Nonnull
    protected final List<UserInfo> users;

    public ListUsersOnFolderResponse(@Nonnull List<InviteeInfo> list, @Nonnull List<UserInfo> list2, @Nonnull Cursor cursor, boolean z) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'invitees' is null");
        }
        Iterator<InviteeInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'invitees' is null");
            }
        }
        this.invitees = list;
        if (list2 == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        Iterator<UserInfo> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = list2;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = z;
    }

    @Nonnull
    public List<InviteeInfo> getInvitees() {
        return this.invitees;
    }

    @Nonnull
    public List<UserInfo> getUsers() {
        return this.users;
    }

    @Nonnull
    public Cursor getCursor() {
        return this.cursor;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.invitees, this.users, this.cursor, Boolean.valueOf(this.hasMore)});
    }

    public boolean equals(Object obj) {
        ListUsersOnFolderResponse listUsersOnFolderResponse;
        List<InviteeInfo> list;
        List<InviteeInfo> list2;
        List<UserInfo> list3;
        List<UserInfo> list4;
        Cursor cursor;
        Cursor cursor2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.invitees) == (list2 = (listUsersOnFolderResponse = (ListUsersOnFolderResponse) obj).invitees) || list.equals(list2)) && (((list3 = this.users) == (list4 = listUsersOnFolderResponse.users) || list3.equals(list4)) && (((cursor = this.cursor) == (cursor2 = listUsersOnFolderResponse.cursor) || cursor.equals(cursor2)) && this.hasMore == listUsersOnFolderResponse.hasMore));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListUsersOnFolderResponse> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListUsersOnFolderResponse listUsersOnFolderResponse, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("invitees");
            StoneSerializers.list(InviteeInfo.Serializer.INSTANCE).serialize(listUsersOnFolderResponse.invitees, jsonGenerator);
            jsonGenerator.writeFieldName("users");
            StoneSerializers.list(UserInfo.Serializer.INSTANCE).serialize(listUsersOnFolderResponse.users, jsonGenerator);
            jsonGenerator.writeFieldName("cursor");
            Cursor.Serializer.INSTANCE.serialize(listUsersOnFolderResponse.cursor, jsonGenerator);
            jsonGenerator.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listUsersOnFolderResponse.hasMore), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListUsersOnFolderResponse deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                Cursor cursorDeserialize = null;
                Boolean boolDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("invitees".equals(currentName)) {
                        list = (List) StoneSerializers.list(InviteeInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("users".equals(currentName)) {
                        list2 = (List) StoneSerializers.list(UserInfo.Serializer.INSTANCE).deserialize(jsonParser);
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
                if (cursorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"cursor\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"has_more\" missing.");
                }
                ListUsersOnFolderResponse listUsersOnFolderResponse = new ListUsersOnFolderResponse(list, list2, cursorDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listUsersOnFolderResponse, listUsersOnFolderResponse.toStringMultiline());
                return listUsersOnFolderResponse;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
