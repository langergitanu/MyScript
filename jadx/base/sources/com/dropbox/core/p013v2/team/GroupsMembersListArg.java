package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupSelector;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
class GroupsMembersListArg {

    @Nonnull
    protected final GroupSelector group;
    protected final long limit;

    public GroupsMembersListArg(@Nonnull GroupSelector groupSelector, long j) {
        if (groupSelector == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = groupSelector;
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = j;
    }

    public GroupsMembersListArg(@Nonnull GroupSelector groupSelector) {
        this(groupSelector, 1000L);
    }

    @Nonnull
    public GroupSelector getGroup() {
        return this.group;
    }

    public long getLimit() {
        return this.limit;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.group, Long.valueOf(this.limit)});
    }

    public boolean equals(Object obj) {
        GroupsMembersListArg groupsMembersListArg;
        GroupSelector groupSelector;
        GroupSelector groupSelector2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((groupSelector = this.group) == (groupSelector2 = (groupsMembersListArg = (GroupsMembersListArg) obj).group) || groupSelector.equals(groupSelector2)) && this.limit == groupsMembersListArg.limit;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupsMembersListArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupsMembersListArg groupsMembersListArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(groupsMembersListArg.group, jsonGenerator);
            jsonGenerator.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(Long.valueOf(groupsMembersListArg.limit), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupsMembersListArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            GroupSelector groupSelectorDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = 1000L;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("group".equals(currentName)) {
                        groupSelectorDeserialize = GroupSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("limit".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (groupSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group\" missing.");
                }
                GroupsMembersListArg groupsMembersListArg = new GroupsMembersListArg(groupSelectorDeserialize, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupsMembersListArg, groupsMembersListArg.toStringMultiline());
                return groupsMembersListArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
