package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupFullInfo;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class GroupsGetInfoItem {
    private Tag _tag;
    private GroupFullInfo groupInfoValue;
    private String idNotFoundValue;

    public enum Tag {
        ID_NOT_FOUND,
        GROUP_INFO
    }

    private GroupsGetInfoItem() {
    }

    private GroupsGetInfoItem withTag(Tag tag) {
        GroupsGetInfoItem groupsGetInfoItem = new GroupsGetInfoItem();
        groupsGetInfoItem._tag = tag;
        return groupsGetInfoItem;
    }

    private GroupsGetInfoItem withTagAndIdNotFound(Tag tag, String str) {
        GroupsGetInfoItem groupsGetInfoItem = new GroupsGetInfoItem();
        groupsGetInfoItem._tag = tag;
        groupsGetInfoItem.idNotFoundValue = str;
        return groupsGetInfoItem;
    }

    private GroupsGetInfoItem withTagAndGroupInfo(Tag tag, GroupFullInfo groupFullInfo) {
        GroupsGetInfoItem groupsGetInfoItem = new GroupsGetInfoItem();
        groupsGetInfoItem._tag = tag;
        groupsGetInfoItem.groupInfoValue = groupFullInfo;
        return groupsGetInfoItem;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isIdNotFound() {
        return this._tag == Tag.ID_NOT_FOUND;
    }

    public static GroupsGetInfoItem idNotFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GroupsGetInfoItem().withTagAndIdNotFound(Tag.ID_NOT_FOUND, str);
    }

    public String getIdNotFoundValue() {
        if (this._tag != Tag.ID_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.ID_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return this.idNotFoundValue;
    }

    public boolean isGroupInfo() {
        return this._tag == Tag.GROUP_INFO;
    }

    public static GroupsGetInfoItem groupInfo(GroupFullInfo groupFullInfo) {
        if (groupFullInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GroupsGetInfoItem().withTagAndGroupInfo(Tag.GROUP_INFO, groupFullInfo);
    }

    public GroupFullInfo getGroupInfoValue() {
        if (this._tag != Tag.GROUP_INFO) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_INFO, but was Tag." + this._tag.name());
        }
        return this.groupInfoValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.idNotFoundValue, this.groupInfoValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GroupsGetInfoItem)) {
            return false;
        }
        GroupsGetInfoItem groupsGetInfoItem = (GroupsGetInfoItem) obj;
        if (this._tag != groupsGetInfoItem._tag) {
            return false;
        }
        int i = C43441.$SwitchMap$com$dropbox$core$v2$team$GroupsGetInfoItem$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.idNotFoundValue;
            String str2 = groupsGetInfoItem.idNotFoundValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return false;
        }
        GroupFullInfo groupFullInfo = this.groupInfoValue;
        GroupFullInfo groupFullInfo2 = groupsGetInfoItem.groupInfoValue;
        return groupFullInfo == groupFullInfo2 || groupFullInfo.equals(groupFullInfo2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupsGetInfoItem$1 */
    static /* synthetic */ class C43441 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupsGetInfoItem$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupsGetInfoItem$Tag = iArr;
            try {
                iArr[Tag.ID_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupsGetInfoItem$Tag[Tag.GROUP_INFO.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<GroupsGetInfoItem> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupsGetInfoItem groupsGetInfoItem, JsonGenerator jsonGenerator) throws IOException {
            int i = C43441.$SwitchMap$com$dropbox$core$v2$team$GroupsGetInfoItem$Tag[groupsGetInfoItem.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("id_not_found", jsonGenerator);
                jsonGenerator.writeFieldName("id_not_found");
                StoneSerializers.string().serialize(groupsGetInfoItem.idNotFoundValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("group_info", jsonGenerator);
                GroupFullInfo.Serializer.INSTANCE.serialize(groupsGetInfoItem.groupInfoValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + groupsGetInfoItem.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupsGetInfoItem deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupsGetInfoItem groupsGetInfoItemGroupInfo;
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
            if ("id_not_found".equals(tag)) {
                expectField("id_not_found", jsonParser);
                groupsGetInfoItemGroupInfo = GroupsGetInfoItem.idNotFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("group_info".equals(tag)) {
                groupsGetInfoItemGroupInfo = GroupsGetInfoItem.groupInfo(GroupFullInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupsGetInfoItemGroupInfo;
        }
    }
}
