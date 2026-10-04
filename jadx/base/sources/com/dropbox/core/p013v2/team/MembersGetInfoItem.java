package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamMemberInfo;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class MembersGetInfoItem {
    private Tag _tag;
    private String idNotFoundValue;
    private TeamMemberInfo memberInfoValue;

    public enum Tag {
        ID_NOT_FOUND,
        MEMBER_INFO
    }

    private MembersGetInfoItem() {
    }

    private MembersGetInfoItem withTag(Tag tag) {
        MembersGetInfoItem membersGetInfoItem = new MembersGetInfoItem();
        membersGetInfoItem._tag = tag;
        return membersGetInfoItem;
    }

    private MembersGetInfoItem withTagAndIdNotFound(Tag tag, String str) {
        MembersGetInfoItem membersGetInfoItem = new MembersGetInfoItem();
        membersGetInfoItem._tag = tag;
        membersGetInfoItem.idNotFoundValue = str;
        return membersGetInfoItem;
    }

    private MembersGetInfoItem withTagAndMemberInfo(Tag tag, TeamMemberInfo teamMemberInfo) {
        MembersGetInfoItem membersGetInfoItem = new MembersGetInfoItem();
        membersGetInfoItem._tag = tag;
        membersGetInfoItem.memberInfoValue = teamMemberInfo;
        return membersGetInfoItem;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isIdNotFound() {
        return this._tag == Tag.ID_NOT_FOUND;
    }

    public static MembersGetInfoItem idNotFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersGetInfoItem().withTagAndIdNotFound(Tag.ID_NOT_FOUND, str);
    }

    public String getIdNotFoundValue() {
        if (this._tag != Tag.ID_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.ID_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return this.idNotFoundValue;
    }

    public boolean isMemberInfo() {
        return this._tag == Tag.MEMBER_INFO;
    }

    public static MembersGetInfoItem memberInfo(TeamMemberInfo teamMemberInfo) {
        if (teamMemberInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersGetInfoItem().withTagAndMemberInfo(Tag.MEMBER_INFO, teamMemberInfo);
    }

    public TeamMemberInfo getMemberInfoValue() {
        if (this._tag != Tag.MEMBER_INFO) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_INFO, but was Tag." + this._tag.name());
        }
        return this.memberInfoValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.idNotFoundValue, this.memberInfoValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MembersGetInfoItem)) {
            return false;
        }
        MembersGetInfoItem membersGetInfoItem = (MembersGetInfoItem) obj;
        if (this._tag != membersGetInfoItem._tag) {
            return false;
        }
        int i = C43731.$SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItem$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.idNotFoundValue;
            String str2 = membersGetInfoItem.idNotFoundValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return false;
        }
        TeamMemberInfo teamMemberInfo = this.memberInfoValue;
        TeamMemberInfo teamMemberInfo2 = membersGetInfoItem.memberInfoValue;
        return teamMemberInfo == teamMemberInfo2 || teamMemberInfo.equals(teamMemberInfo2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersGetInfoItem$1 */
    static /* synthetic */ class C43731 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItem$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItem$Tag = iArr;
            try {
                iArr[Tag.ID_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItem$Tag[Tag.MEMBER_INFO.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<MembersGetInfoItem> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersGetInfoItem membersGetInfoItem, JsonGenerator jsonGenerator) throws IOException {
            int i = C43731.$SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItem$Tag[membersGetInfoItem.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("id_not_found", jsonGenerator);
                jsonGenerator.writeFieldName("id_not_found");
                StoneSerializers.string().serialize(membersGetInfoItem.idNotFoundValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("member_info", jsonGenerator);
                TeamMemberInfo.Serializer.INSTANCE.serialize(membersGetInfoItem.memberInfoValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + membersGetInfoItem.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersGetInfoItem deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersGetInfoItem membersGetInfoItemMemberInfo;
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
                membersGetInfoItemMemberInfo = MembersGetInfoItem.idNotFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("member_info".equals(tag)) {
                membersGetInfoItemMemberInfo = MembersGetInfoItem.memberInfo(TeamMemberInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersGetInfoItemMemberInfo;
        }
    }
}
