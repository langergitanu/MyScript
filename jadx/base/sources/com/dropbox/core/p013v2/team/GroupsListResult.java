package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.teamcommon.GroupSummary;
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
public class GroupsListResult {

    @Nonnull
    protected final String cursor;

    @Nonnull
    protected final List<GroupSummary> groups;
    protected final boolean hasMore;

    public GroupsListResult(@Nonnull List<GroupSummary> list, @Nonnull String str, boolean z) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'groups' is null");
        }
        Iterator<GroupSummary> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'groups' is null");
            }
        }
        this.groups = list;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = str;
        this.hasMore = z;
    }

    @Nonnull
    public List<GroupSummary> getGroups() {
        return this.groups;
    }

    @Nonnull
    public String getCursor() {
        return this.cursor;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.groups, this.cursor, Boolean.valueOf(this.hasMore)});
    }

    public boolean equals(Object obj) {
        GroupsListResult groupsListResult;
        List<GroupSummary> list;
        List<GroupSummary> list2;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.groups) == (list2 = (groupsListResult = (GroupsListResult) obj).groups) || list.equals(list2)) && (((str = this.cursor) == (str2 = groupsListResult.cursor) || str.equals(str2)) && this.hasMore == groupsListResult.hasMore);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupsListResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupsListResult groupsListResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("groups");
            StoneSerializers.list(GroupSummary.Serializer.INSTANCE).serialize(groupsListResult.groups, jsonGenerator);
            jsonGenerator.writeFieldName("cursor");
            StoneSerializers.string().serialize(groupsListResult.cursor, jsonGenerator);
            jsonGenerator.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(groupsListResult.hasMore), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupsListResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                Boolean boolDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("groups".equals(currentName)) {
                        list = (List) StoneSerializers.list(GroupSummary.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("cursor".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("has_more".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"groups\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"cursor\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"has_more\" missing.");
                }
                GroupsListResult groupsListResult = new GroupsListResult(list, strDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupsListResult, groupsListResult.toStringMultiline());
                return groupsListResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
