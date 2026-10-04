package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class GroupSelector {
    private Tag _tag;
    private String groupExternalIdValue;
    private String groupIdValue;

    public enum Tag {
        GROUP_ID,
        GROUP_EXTERNAL_ID
    }

    private GroupSelector() {
    }

    private GroupSelector withTag(Tag tag) {
        GroupSelector groupSelector = new GroupSelector();
        groupSelector._tag = tag;
        return groupSelector;
    }

    private GroupSelector withTagAndGroupId(Tag tag, String str) {
        GroupSelector groupSelector = new GroupSelector();
        groupSelector._tag = tag;
        groupSelector.groupIdValue = str;
        return groupSelector;
    }

    private GroupSelector withTagAndGroupExternalId(Tag tag, String str) {
        GroupSelector groupSelector = new GroupSelector();
        groupSelector._tag = tag;
        groupSelector.groupExternalIdValue = str;
        return groupSelector;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isGroupId() {
        return this._tag == Tag.GROUP_ID;
    }

    public static GroupSelector groupId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GroupSelector().withTagAndGroupId(Tag.GROUP_ID, str);
    }

    public String getGroupIdValue() {
        if (this._tag != Tag.GROUP_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_ID, but was Tag." + this._tag.name());
        }
        return this.groupIdValue;
    }

    public boolean isGroupExternalId() {
        return this._tag == Tag.GROUP_EXTERNAL_ID;
    }

    public static GroupSelector groupExternalId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GroupSelector().withTagAndGroupExternalId(Tag.GROUP_EXTERNAL_ID, str);
    }

    public String getGroupExternalIdValue() {
        if (this._tag != Tag.GROUP_EXTERNAL_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_EXTERNAL_ID, but was Tag." + this._tag.name());
        }
        return this.groupExternalIdValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.groupIdValue, this.groupExternalIdValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GroupSelector)) {
            return false;
        }
        GroupSelector groupSelector = (GroupSelector) obj;
        if (this._tag != groupSelector._tag) {
            return false;
        }
        int i = C43401.$SwitchMap$com$dropbox$core$v2$team$GroupSelector$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.groupIdValue;
            String str2 = groupSelector.groupIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return false;
        }
        String str3 = this.groupExternalIdValue;
        String str4 = groupSelector.groupExternalIdValue;
        return str3 == str4 || str3.equals(str4);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupSelector$1 */
    static /* synthetic */ class C43401 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupSelector$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupSelector$Tag = iArr;
            try {
                iArr[Tag.GROUP_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupSelector$Tag[Tag.GROUP_EXTERNAL_ID.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<GroupSelector> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupSelector groupSelector, JsonGenerator jsonGenerator) throws IOException {
            int i = C43401.$SwitchMap$com$dropbox$core$v2$team$GroupSelector$Tag[groupSelector.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.GROUP_ID, jsonGenerator);
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.GROUP_ID);
                StoneSerializers.string().serialize(groupSelector.groupIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("group_external_id", jsonGenerator);
                jsonGenerator.writeFieldName("group_external_id");
                StoneSerializers.string().serialize(groupSelector.groupExternalIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + groupSelector.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupSelector deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupSelector groupSelectorGroupExternalId;
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
            if (FirebaseAnalytics.Param.GROUP_ID.equals(tag)) {
                expectField(FirebaseAnalytics.Param.GROUP_ID, jsonParser);
                groupSelectorGroupExternalId = GroupSelector.groupId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("group_external_id".equals(tag)) {
                expectField("group_external_id", jsonParser);
                groupSelectorGroupExternalId = GroupSelector.groupExternalId(StoneSerializers.string().deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupSelectorGroupExternalId;
        }
    }
}
