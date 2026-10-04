package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class GroupsSelector {
    private Tag _tag;
    private List<String> groupExternalIdsValue;
    private List<String> groupIdsValue;

    public enum Tag {
        GROUP_IDS,
        GROUP_EXTERNAL_IDS
    }

    private GroupsSelector() {
    }

    private GroupsSelector withTag(Tag tag) {
        GroupsSelector groupsSelector = new GroupsSelector();
        groupsSelector._tag = tag;
        return groupsSelector;
    }

    private GroupsSelector withTagAndGroupIds(Tag tag, List<String> list) {
        GroupsSelector groupsSelector = new GroupsSelector();
        groupsSelector._tag = tag;
        groupsSelector.groupIdsValue = list;
        return groupsSelector;
    }

    private GroupsSelector withTagAndGroupExternalIds(Tag tag, List<String> list) {
        GroupsSelector groupsSelector = new GroupsSelector();
        groupsSelector._tag = tag;
        groupsSelector.groupExternalIdsValue = list;
        return groupsSelector;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isGroupIds() {
        return this._tag == Tag.GROUP_IDS;
    }

    public static GroupsSelector groupIds(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupsSelector().withTagAndGroupIds(Tag.GROUP_IDS, list);
    }

    public List<String> getGroupIdsValue() {
        if (this._tag != Tag.GROUP_IDS) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_IDS, but was Tag." + this._tag.name());
        }
        return this.groupIdsValue;
    }

    public boolean isGroupExternalIds() {
        return this._tag == Tag.GROUP_EXTERNAL_IDS;
    }

    public static GroupsSelector groupExternalIds(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupsSelector().withTagAndGroupExternalIds(Tag.GROUP_EXTERNAL_IDS, list);
    }

    public List<String> getGroupExternalIdsValue() {
        if (this._tag != Tag.GROUP_EXTERNAL_IDS) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_EXTERNAL_IDS, but was Tag." + this._tag.name());
        }
        return this.groupExternalIdsValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.groupIdsValue, this.groupExternalIdsValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GroupsSelector)) {
            return false;
        }
        GroupsSelector groupsSelector = (GroupsSelector) obj;
        if (this._tag != groupsSelector._tag) {
            return false;
        }
        int i = C43481.$SwitchMap$com$dropbox$core$v2$team$GroupsSelector$Tag[this._tag.ordinal()];
        if (i == 1) {
            List<String> list = this.groupIdsValue;
            List<String> list2 = groupsSelector.groupIdsValue;
            return list == list2 || list.equals(list2);
        }
        if (i != 2) {
            return false;
        }
        List<String> list3 = this.groupExternalIdsValue;
        List<String> list4 = groupsSelector.groupExternalIdsValue;
        return list3 == list4 || list3.equals(list4);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupsSelector$1 */
    static /* synthetic */ class C43481 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupsSelector$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupsSelector$Tag = iArr;
            try {
                iArr[Tag.GROUP_IDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupsSelector$Tag[Tag.GROUP_EXTERNAL_IDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<GroupsSelector> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupsSelector groupsSelector, JsonGenerator jsonGenerator) throws IOException {
            int i = C43481.$SwitchMap$com$dropbox$core$v2$team$GroupsSelector$Tag[groupsSelector.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("group_ids", jsonGenerator);
                jsonGenerator.writeFieldName("group_ids");
                StoneSerializers.list(StoneSerializers.string()).serialize(groupsSelector.groupIdsValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("group_external_ids", jsonGenerator);
                jsonGenerator.writeFieldName("group_external_ids");
                StoneSerializers.list(StoneSerializers.string()).serialize(groupsSelector.groupExternalIdsValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + groupsSelector.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupsSelector deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupsSelector groupsSelectorGroupExternalIds;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("group_ids".equals(tag)) {
                expectField("group_ids", jsonParser);
                groupsSelectorGroupExternalIds = GroupsSelector.groupIds((List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser));
            } else if ("group_external_ids".equals(tag)) {
                expectField("group_external_ids", jsonParser);
                groupsSelectorGroupExternalIds = GroupsSelector.groupExternalIds((List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupsSelectorGroupExternalIds;
        }
    }
}
