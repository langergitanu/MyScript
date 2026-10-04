package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.NonTeamMemberLogInfo;
import com.dropbox.core.p013v2.teamlog.TeamLogInfo;
import com.dropbox.core.p013v2.teamlog.TeamMemberLogInfo;
import com.dropbox.core.p013v2.teamlog.TrustedNonTeamMemberLogInfo;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class ContextLogInfo {
    private Tag _tag;
    private NonTeamMemberLogInfo nonTeamMemberValue;
    private TeamLogInfo organizationTeamValue;
    private TeamMemberLogInfo teamMemberValue;
    private TrustedNonTeamMemberLogInfo trustedNonTeamMemberValue;
    public static final ContextLogInfo ANONYMOUS = new ContextLogInfo().withTag(Tag.ANONYMOUS);
    public static final ContextLogInfo TEAM = new ContextLogInfo().withTag(Tag.TEAM);
    public static final ContextLogInfo OTHER = new ContextLogInfo().withTag(Tag.OTHER);

    public enum Tag {
        ANONYMOUS,
        NON_TEAM_MEMBER,
        ORGANIZATION_TEAM,
        TEAM,
        TEAM_MEMBER,
        TRUSTED_NON_TEAM_MEMBER,
        OTHER
    }

    private ContextLogInfo() {
    }

    private ContextLogInfo withTag(Tag tag) {
        ContextLogInfo contextLogInfo = new ContextLogInfo();
        contextLogInfo._tag = tag;
        return contextLogInfo;
    }

    private ContextLogInfo withTagAndNonTeamMember(Tag tag, NonTeamMemberLogInfo nonTeamMemberLogInfo) {
        ContextLogInfo contextLogInfo = new ContextLogInfo();
        contextLogInfo._tag = tag;
        contextLogInfo.nonTeamMemberValue = nonTeamMemberLogInfo;
        return contextLogInfo;
    }

    private ContextLogInfo withTagAndOrganizationTeam(Tag tag, TeamLogInfo teamLogInfo) {
        ContextLogInfo contextLogInfo = new ContextLogInfo();
        contextLogInfo._tag = tag;
        contextLogInfo.organizationTeamValue = teamLogInfo;
        return contextLogInfo;
    }

    private ContextLogInfo withTagAndTeamMember(Tag tag, TeamMemberLogInfo teamMemberLogInfo) {
        ContextLogInfo contextLogInfo = new ContextLogInfo();
        contextLogInfo._tag = tag;
        contextLogInfo.teamMemberValue = teamMemberLogInfo;
        return contextLogInfo;
    }

    private ContextLogInfo withTagAndTrustedNonTeamMember(Tag tag, TrustedNonTeamMemberLogInfo trustedNonTeamMemberLogInfo) {
        ContextLogInfo contextLogInfo = new ContextLogInfo();
        contextLogInfo._tag = tag;
        contextLogInfo.trustedNonTeamMemberValue = trustedNonTeamMemberLogInfo;
        return contextLogInfo;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAnonymous() {
        return this._tag == Tag.ANONYMOUS;
    }

    public boolean isNonTeamMember() {
        return this._tag == Tag.NON_TEAM_MEMBER;
    }

    public static ContextLogInfo nonTeamMember(NonTeamMemberLogInfo nonTeamMemberLogInfo) {
        if (nonTeamMemberLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ContextLogInfo().withTagAndNonTeamMember(Tag.NON_TEAM_MEMBER, nonTeamMemberLogInfo);
    }

    public NonTeamMemberLogInfo getNonTeamMemberValue() {
        if (this._tag != Tag.NON_TEAM_MEMBER) {
            throw new IllegalStateException("Invalid tag: required Tag.NON_TEAM_MEMBER, but was Tag." + this._tag.name());
        }
        return this.nonTeamMemberValue;
    }

    public boolean isOrganizationTeam() {
        return this._tag == Tag.ORGANIZATION_TEAM;
    }

    public static ContextLogInfo organizationTeam(TeamLogInfo teamLogInfo) {
        if (teamLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ContextLogInfo().withTagAndOrganizationTeam(Tag.ORGANIZATION_TEAM, teamLogInfo);
    }

    public TeamLogInfo getOrganizationTeamValue() {
        if (this._tag != Tag.ORGANIZATION_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.ORGANIZATION_TEAM, but was Tag." + this._tag.name());
        }
        return this.organizationTeamValue;
    }

    public boolean isTeam() {
        return this._tag == Tag.TEAM;
    }

    public boolean isTeamMember() {
        return this._tag == Tag.TEAM_MEMBER;
    }

    public static ContextLogInfo teamMember(TeamMemberLogInfo teamMemberLogInfo) {
        if (teamMemberLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ContextLogInfo().withTagAndTeamMember(Tag.TEAM_MEMBER, teamMemberLogInfo);
    }

    public TeamMemberLogInfo getTeamMemberValue() {
        if (this._tag != Tag.TEAM_MEMBER) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_MEMBER, but was Tag." + this._tag.name());
        }
        return this.teamMemberValue;
    }

    public boolean isTrustedNonTeamMember() {
        return this._tag == Tag.TRUSTED_NON_TEAM_MEMBER;
    }

    public static ContextLogInfo trustedNonTeamMember(TrustedNonTeamMemberLogInfo trustedNonTeamMemberLogInfo) {
        if (trustedNonTeamMemberLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ContextLogInfo().withTagAndTrustedNonTeamMember(Tag.TRUSTED_NON_TEAM_MEMBER, trustedNonTeamMemberLogInfo);
    }

    public TrustedNonTeamMemberLogInfo getTrustedNonTeamMemberValue() {
        if (this._tag != Tag.TRUSTED_NON_TEAM_MEMBER) {
            throw new IllegalStateException("Invalid tag: required Tag.TRUSTED_NON_TEAM_MEMBER, but was Tag." + this._tag.name());
        }
        return this.trustedNonTeamMemberValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.nonTeamMemberValue, this.organizationTeamValue, this.teamMemberValue, this.trustedNonTeamMemberValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ContextLogInfo)) {
            return false;
        }
        ContextLogInfo contextLogInfo = (ContextLogInfo) obj;
        if (this._tag != contextLogInfo._tag) {
            return false;
        }
        switch (C44541.$SwitchMap$com$dropbox$core$v2$teamlog$ContextLogInfo$Tag[this._tag.ordinal()]) {
            case 2:
                NonTeamMemberLogInfo nonTeamMemberLogInfo = this.nonTeamMemberValue;
                NonTeamMemberLogInfo nonTeamMemberLogInfo2 = contextLogInfo.nonTeamMemberValue;
                if (nonTeamMemberLogInfo != nonTeamMemberLogInfo2 && !nonTeamMemberLogInfo.equals(nonTeamMemberLogInfo2)) {
                    return false;
                }
            case 1:
                return true;
            case 3:
                TeamLogInfo teamLogInfo = this.organizationTeamValue;
                TeamLogInfo teamLogInfo2 = contextLogInfo.organizationTeamValue;
                return teamLogInfo == teamLogInfo2 || teamLogInfo.equals(teamLogInfo2);
            case 5:
                TeamMemberLogInfo teamMemberLogInfo = this.teamMemberValue;
                TeamMemberLogInfo teamMemberLogInfo2 = contextLogInfo.teamMemberValue;
                if (teamMemberLogInfo != teamMemberLogInfo2 && !teamMemberLogInfo.equals(teamMemberLogInfo2)) {
                    return false;
                }
            case 4:
                return true;
            case 6:
                TrustedNonTeamMemberLogInfo trustedNonTeamMemberLogInfo = this.trustedNonTeamMemberValue;
                TrustedNonTeamMemberLogInfo trustedNonTeamMemberLogInfo2 = contextLogInfo.trustedNonTeamMemberValue;
                return trustedNonTeamMemberLogInfo == trustedNonTeamMemberLogInfo2 || trustedNonTeamMemberLogInfo.equals(trustedNonTeamMemberLogInfo2);
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ContextLogInfo$1 */
    static /* synthetic */ class C44541 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ContextLogInfo$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ContextLogInfo$Tag = iArr;
            try {
                iArr[Tag.ANONYMOUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ContextLogInfo$Tag[Tag.NON_TEAM_MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ContextLogInfo$Tag[Tag.ORGANIZATION_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ContextLogInfo$Tag[Tag.TEAM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ContextLogInfo$Tag[Tag.TEAM_MEMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ContextLogInfo$Tag[Tag.TRUSTED_NON_TEAM_MEMBER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ContextLogInfo$Tag[Tag.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<ContextLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ContextLogInfo contextLogInfo, JsonGenerator jsonGenerator) throws IOException {
            switch (C44541.$SwitchMap$com$dropbox$core$v2$teamlog$ContextLogInfo$Tag[contextLogInfo.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeString("anonymous");
                    break;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("non_team_member", jsonGenerator);
                    NonTeamMemberLogInfo.Serializer.INSTANCE.serialize(contextLogInfo.nonTeamMemberValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag("organization_team", jsonGenerator);
                    TeamLogInfo.Serializer.INSTANCE.serialize(contextLogInfo.organizationTeamValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 4:
                    jsonGenerator.writeString("team");
                    break;
                case 5:
                    jsonGenerator.writeStartObject();
                    writeTag("team_member", jsonGenerator);
                    TeamMemberLogInfo.Serializer.INSTANCE.serialize(contextLogInfo.teamMemberValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("trusted_non_team_member", jsonGenerator);
                    TrustedNonTeamMemberLogInfo.Serializer.INSTANCE.serialize(contextLogInfo.trustedNonTeamMemberValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ContextLogInfo deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ContextLogInfo contextLogInfoTrustedNonTeamMember;
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
            if ("anonymous".equals(tag)) {
                contextLogInfoTrustedNonTeamMember = ContextLogInfo.ANONYMOUS;
            } else if ("non_team_member".equals(tag)) {
                contextLogInfoTrustedNonTeamMember = ContextLogInfo.nonTeamMember(NonTeamMemberLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("organization_team".equals(tag)) {
                contextLogInfoTrustedNonTeamMember = ContextLogInfo.organizationTeam(TeamLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("team".equals(tag)) {
                contextLogInfoTrustedNonTeamMember = ContextLogInfo.TEAM;
            } else if ("team_member".equals(tag)) {
                contextLogInfoTrustedNonTeamMember = ContextLogInfo.teamMember(TeamMemberLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("trusted_non_team_member".equals(tag)) {
                contextLogInfoTrustedNonTeamMember = ContextLogInfo.trustedNonTeamMember(TrustedNonTeamMemberLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                contextLogInfoTrustedNonTeamMember = ContextLogInfo.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return contextLogInfoTrustedNonTeamMember;
        }
    }
}
