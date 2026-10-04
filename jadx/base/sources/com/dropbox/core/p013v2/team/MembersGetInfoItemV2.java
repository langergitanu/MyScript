package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamMemberInfoV2;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class MembersGetInfoItemV2 {
    public static final MembersGetInfoItemV2 OTHER = new MembersGetInfoItemV2().withTag(Tag.OTHER);
    private Tag _tag;
    private String idNotFoundValue;
    private TeamMemberInfoV2 memberInfoValue;

    public enum Tag {
        ID_NOT_FOUND,
        MEMBER_INFO,
        OTHER
    }

    private MembersGetInfoItemV2() {
    }

    private MembersGetInfoItemV2 withTag(Tag tag) {
        MembersGetInfoItemV2 membersGetInfoItemV2 = new MembersGetInfoItemV2();
        membersGetInfoItemV2._tag = tag;
        return membersGetInfoItemV2;
    }

    private MembersGetInfoItemV2 withTagAndIdNotFound(Tag tag, String str) {
        MembersGetInfoItemV2 membersGetInfoItemV2 = new MembersGetInfoItemV2();
        membersGetInfoItemV2._tag = tag;
        membersGetInfoItemV2.idNotFoundValue = str;
        return membersGetInfoItemV2;
    }

    private MembersGetInfoItemV2 withTagAndMemberInfo(Tag tag, TeamMemberInfoV2 teamMemberInfoV2) {
        MembersGetInfoItemV2 membersGetInfoItemV2 = new MembersGetInfoItemV2();
        membersGetInfoItemV2._tag = tag;
        membersGetInfoItemV2.memberInfoValue = teamMemberInfoV2;
        return membersGetInfoItemV2;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isIdNotFound() {
        return this._tag == Tag.ID_NOT_FOUND;
    }

    public static MembersGetInfoItemV2 idNotFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersGetInfoItemV2().withTagAndIdNotFound(Tag.ID_NOT_FOUND, str);
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

    public static MembersGetInfoItemV2 memberInfo(TeamMemberInfoV2 teamMemberInfoV2) {
        if (teamMemberInfoV2 == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersGetInfoItemV2().withTagAndMemberInfo(Tag.MEMBER_INFO, teamMemberInfoV2);
    }

    public TeamMemberInfoV2 getMemberInfoValue() {
        if (this._tag != Tag.MEMBER_INFO) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_INFO, but was Tag." + this._tag.name());
        }
        return this.memberInfoValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.idNotFoundValue, this.memberInfoValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MembersGetInfoItemV2)) {
            return false;
        }
        MembersGetInfoItemV2 membersGetInfoItemV2 = (MembersGetInfoItemV2) obj;
        if (this._tag != membersGetInfoItemV2._tag) {
            return false;
        }
        int i = C43741.$SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItemV2$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.idNotFoundValue;
            String str2 = membersGetInfoItemV2.idNotFoundValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return i == 3;
        }
        TeamMemberInfoV2 teamMemberInfoV2 = this.memberInfoValue;
        TeamMemberInfoV2 teamMemberInfoV22 = membersGetInfoItemV2.memberInfoValue;
        return teamMemberInfoV2 == teamMemberInfoV22 || teamMemberInfoV2.equals(teamMemberInfoV22);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersGetInfoItemV2$1 */
    static /* synthetic */ class C43741 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItemV2$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItemV2$Tag = iArr;
            try {
                iArr[Tag.ID_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItemV2$Tag[Tag.MEMBER_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItemV2$Tag[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<MembersGetInfoItemV2> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersGetInfoItemV2 membersGetInfoItemV2, JsonGenerator jsonGenerator) throws IOException {
            int i = C43741.$SwitchMap$com$dropbox$core$v2$team$MembersGetInfoItemV2$Tag[membersGetInfoItemV2.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("id_not_found", jsonGenerator);
                jsonGenerator.writeFieldName("id_not_found");
                StoneSerializers.string().serialize(membersGetInfoItemV2.idNotFoundValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("member_info", jsonGenerator);
                TeamMemberInfoV2.Serializer.INSTANCE.serialize(membersGetInfoItemV2.memberInfoValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersGetInfoItemV2 deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersGetInfoItemV2 membersGetInfoItemV2MemberInfo;
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
                membersGetInfoItemV2MemberInfo = MembersGetInfoItemV2.idNotFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("member_info".equals(tag)) {
                membersGetInfoItemV2MemberInfo = MembersGetInfoItemV2.memberInfo(TeamMemberInfoV2.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                membersGetInfoItemV2MemberInfo = MembersGetInfoItemV2.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersGetInfoItemV2MemberInfo;
        }
    }
}
