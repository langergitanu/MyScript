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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class MembersInfo {
    protected final long permanentlyDeletedUsers;

    @Nonnull
    protected final List<String> teamMemberIds;

    public MembersInfo(@Nonnull List<String> list, long j) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberIds' is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'teamMemberIds' is null");
            }
        }
        this.teamMemberIds = list;
        this.permanentlyDeletedUsers = j;
    }

    @Nonnull
    public List<String> getTeamMemberIds() {
        return this.teamMemberIds;
    }

    public long getPermanentlyDeletedUsers() {
        return this.permanentlyDeletedUsers;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.teamMemberIds, Long.valueOf(this.permanentlyDeletedUsers)});
    }

    public boolean equals(Object obj) {
        MembersInfo membersInfo;
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.teamMemberIds) == (list2 = (membersInfo = (MembersInfo) obj).teamMemberIds) || list.equals(list2)) && this.permanentlyDeletedUsers == membersInfo.permanentlyDeletedUsers;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersInfo membersInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("team_member_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(membersInfo.teamMemberIds, jsonGenerator);
            jsonGenerator.writeFieldName("permanently_deleted_users");
            StoneSerializers.uInt64().serialize(Long.valueOf(membersInfo.permanentlyDeletedUsers), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("team_member_ids".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("permanently_deleted_users".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_member_ids\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"permanently_deleted_users\" missing.");
                }
                MembersInfo membersInfo = new MembersInfo(list, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersInfo, membersInfo.toStringMultiline());
                return membersInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
