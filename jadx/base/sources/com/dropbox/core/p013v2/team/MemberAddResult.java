package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamMemberInfo;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class MemberAddResult {
    private Tag _tag;
    private String duplicateExternalMemberIdValue;
    private String duplicateMemberPersistentIdValue;
    private String freeTeamMemberLimitReachedValue;
    private String persistentIdDisabledValue;
    private TeamMemberInfo successValue;
    private String teamLicenseLimitValue;
    private String userAlreadyOnTeamValue;
    private String userAlreadyPairedValue;
    private String userCreationFailedValue;
    private String userMigrationFailedValue;
    private String userOnAnotherTeamValue;

    public enum Tag {
        TEAM_LICENSE_LIMIT,
        FREE_TEAM_MEMBER_LIMIT_REACHED,
        USER_ALREADY_ON_TEAM,
        USER_ON_ANOTHER_TEAM,
        USER_ALREADY_PAIRED,
        USER_MIGRATION_FAILED,
        DUPLICATE_EXTERNAL_MEMBER_ID,
        DUPLICATE_MEMBER_PERSISTENT_ID,
        PERSISTENT_ID_DISABLED,
        USER_CREATION_FAILED,
        SUCCESS
    }

    private MemberAddResult() {
    }

    private MemberAddResult withTag(Tag tag) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        return memberAddResult;
    }

    private MemberAddResult withTagAndTeamLicenseLimit(Tag tag, String str) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.teamLicenseLimitValue = str;
        return memberAddResult;
    }

    private MemberAddResult withTagAndFreeTeamMemberLimitReached(Tag tag, String str) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.freeTeamMemberLimitReachedValue = str;
        return memberAddResult;
    }

    private MemberAddResult withTagAndUserAlreadyOnTeam(Tag tag, String str) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.userAlreadyOnTeamValue = str;
        return memberAddResult;
    }

    private MemberAddResult withTagAndUserOnAnotherTeam(Tag tag, String str) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.userOnAnotherTeamValue = str;
        return memberAddResult;
    }

    private MemberAddResult withTagAndUserAlreadyPaired(Tag tag, String str) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.userAlreadyPairedValue = str;
        return memberAddResult;
    }

    private MemberAddResult withTagAndUserMigrationFailed(Tag tag, String str) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.userMigrationFailedValue = str;
        return memberAddResult;
    }

    private MemberAddResult withTagAndDuplicateExternalMemberId(Tag tag, String str) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.duplicateExternalMemberIdValue = str;
        return memberAddResult;
    }

    private MemberAddResult withTagAndDuplicateMemberPersistentId(Tag tag, String str) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.duplicateMemberPersistentIdValue = str;
        return memberAddResult;
    }

    private MemberAddResult withTagAndPersistentIdDisabled(Tag tag, String str) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.persistentIdDisabledValue = str;
        return memberAddResult;
    }

    private MemberAddResult withTagAndUserCreationFailed(Tag tag, String str) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.userCreationFailedValue = str;
        return memberAddResult;
    }

    private MemberAddResult withTagAndSuccess(Tag tag, TeamMemberInfo teamMemberInfo) {
        MemberAddResult memberAddResult = new MemberAddResult();
        memberAddResult._tag = tag;
        memberAddResult.successValue = teamMemberInfo;
        return memberAddResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isTeamLicenseLimit() {
        return this._tag == Tag.TEAM_LICENSE_LIMIT;
    }

    public static MemberAddResult teamLicenseLimit(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult().withTagAndTeamLicenseLimit(Tag.TEAM_LICENSE_LIMIT, str);
    }

    public String getTeamLicenseLimitValue() {
        if (this._tag != Tag.TEAM_LICENSE_LIMIT) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_LICENSE_LIMIT, but was Tag." + this._tag.name());
        }
        return this.teamLicenseLimitValue;
    }

    public boolean isFreeTeamMemberLimitReached() {
        return this._tag == Tag.FREE_TEAM_MEMBER_LIMIT_REACHED;
    }

    public static MemberAddResult freeTeamMemberLimitReached(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult().withTagAndFreeTeamMemberLimitReached(Tag.FREE_TEAM_MEMBER_LIMIT_REACHED, str);
    }

    public String getFreeTeamMemberLimitReachedValue() {
        if (this._tag != Tag.FREE_TEAM_MEMBER_LIMIT_REACHED) {
            throw new IllegalStateException("Invalid tag: required Tag.FREE_TEAM_MEMBER_LIMIT_REACHED, but was Tag." + this._tag.name());
        }
        return this.freeTeamMemberLimitReachedValue;
    }

    public boolean isUserAlreadyOnTeam() {
        return this._tag == Tag.USER_ALREADY_ON_TEAM;
    }

    public static MemberAddResult userAlreadyOnTeam(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult().withTagAndUserAlreadyOnTeam(Tag.USER_ALREADY_ON_TEAM, str);
    }

    public String getUserAlreadyOnTeamValue() {
        if (this._tag != Tag.USER_ALREADY_ON_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ALREADY_ON_TEAM, but was Tag." + this._tag.name());
        }
        return this.userAlreadyOnTeamValue;
    }

    public boolean isUserOnAnotherTeam() {
        return this._tag == Tag.USER_ON_ANOTHER_TEAM;
    }

    public static MemberAddResult userOnAnotherTeam(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult().withTagAndUserOnAnotherTeam(Tag.USER_ON_ANOTHER_TEAM, str);
    }

    public String getUserOnAnotherTeamValue() {
        if (this._tag != Tag.USER_ON_ANOTHER_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ON_ANOTHER_TEAM, but was Tag." + this._tag.name());
        }
        return this.userOnAnotherTeamValue;
    }

    public boolean isUserAlreadyPaired() {
        return this._tag == Tag.USER_ALREADY_PAIRED;
    }

    public static MemberAddResult userAlreadyPaired(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult().withTagAndUserAlreadyPaired(Tag.USER_ALREADY_PAIRED, str);
    }

    public String getUserAlreadyPairedValue() {
        if (this._tag != Tag.USER_ALREADY_PAIRED) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ALREADY_PAIRED, but was Tag." + this._tag.name());
        }
        return this.userAlreadyPairedValue;
    }

    public boolean isUserMigrationFailed() {
        return this._tag == Tag.USER_MIGRATION_FAILED;
    }

    public static MemberAddResult userMigrationFailed(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult().withTagAndUserMigrationFailed(Tag.USER_MIGRATION_FAILED, str);
    }

    public String getUserMigrationFailedValue() {
        if (this._tag != Tag.USER_MIGRATION_FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_MIGRATION_FAILED, but was Tag." + this._tag.name());
        }
        return this.userMigrationFailedValue;
    }

    public boolean isDuplicateExternalMemberId() {
        return this._tag == Tag.DUPLICATE_EXTERNAL_MEMBER_ID;
    }

    public static MemberAddResult duplicateExternalMemberId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult().withTagAndDuplicateExternalMemberId(Tag.DUPLICATE_EXTERNAL_MEMBER_ID, str);
    }

    public String getDuplicateExternalMemberIdValue() {
        if (this._tag != Tag.DUPLICATE_EXTERNAL_MEMBER_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.DUPLICATE_EXTERNAL_MEMBER_ID, but was Tag." + this._tag.name());
        }
        return this.duplicateExternalMemberIdValue;
    }

    public boolean isDuplicateMemberPersistentId() {
        return this._tag == Tag.DUPLICATE_MEMBER_PERSISTENT_ID;
    }

    public static MemberAddResult duplicateMemberPersistentId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult().withTagAndDuplicateMemberPersistentId(Tag.DUPLICATE_MEMBER_PERSISTENT_ID, str);
    }

    public String getDuplicateMemberPersistentIdValue() {
        if (this._tag != Tag.DUPLICATE_MEMBER_PERSISTENT_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.DUPLICATE_MEMBER_PERSISTENT_ID, but was Tag." + this._tag.name());
        }
        return this.duplicateMemberPersistentIdValue;
    }

    public boolean isPersistentIdDisabled() {
        return this._tag == Tag.PERSISTENT_ID_DISABLED;
    }

    public static MemberAddResult persistentIdDisabled(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult().withTagAndPersistentIdDisabled(Tag.PERSISTENT_ID_DISABLED, str);
    }

    public String getPersistentIdDisabledValue() {
        if (this._tag != Tag.PERSISTENT_ID_DISABLED) {
            throw new IllegalStateException("Invalid tag: required Tag.PERSISTENT_ID_DISABLED, but was Tag." + this._tag.name());
        }
        return this.persistentIdDisabledValue;
    }

    public boolean isUserCreationFailed() {
        return this._tag == Tag.USER_CREATION_FAILED;
    }

    public static MemberAddResult userCreationFailed(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult().withTagAndUserCreationFailed(Tag.USER_CREATION_FAILED, str);
    }

    public String getUserCreationFailedValue() {
        if (this._tag != Tag.USER_CREATION_FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_CREATION_FAILED, but was Tag." + this._tag.name());
        }
        return this.userCreationFailedValue;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static MemberAddResult success(TeamMemberInfo teamMemberInfo) {
        if (teamMemberInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MemberAddResult().withTagAndSuccess(Tag.SUCCESS, teamMemberInfo);
    }

    public TeamMemberInfo getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.teamLicenseLimitValue, this.freeTeamMemberLimitReachedValue, this.userAlreadyOnTeamValue, this.userOnAnotherTeamValue, this.userAlreadyPairedValue, this.userMigrationFailedValue, this.duplicateExternalMemberIdValue, this.duplicateMemberPersistentIdValue, this.persistentIdDisabledValue, this.userCreationFailedValue, this.successValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MemberAddResult)) {
            return false;
        }
        MemberAddResult memberAddResult = (MemberAddResult) obj;
        if (this._tag != memberAddResult._tag) {
            return false;
        }
        switch (C43651.$SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[this._tag.ordinal()]) {
            case 1:
                String str = this.teamLicenseLimitValue;
                String str2 = memberAddResult.teamLicenseLimitValue;
                return str == str2 || str.equals(str2);
            case 2:
                String str3 = this.freeTeamMemberLimitReachedValue;
                String str4 = memberAddResult.freeTeamMemberLimitReachedValue;
                return str3 == str4 || str3.equals(str4);
            case 3:
                String str5 = this.userAlreadyOnTeamValue;
                String str6 = memberAddResult.userAlreadyOnTeamValue;
                return str5 == str6 || str5.equals(str6);
            case 4:
                String str7 = this.userOnAnotherTeamValue;
                String str8 = memberAddResult.userOnAnotherTeamValue;
                return str7 == str8 || str7.equals(str8);
            case 5:
                String str9 = this.userAlreadyPairedValue;
                String str10 = memberAddResult.userAlreadyPairedValue;
                return str9 == str10 || str9.equals(str10);
            case 6:
                String str11 = this.userMigrationFailedValue;
                String str12 = memberAddResult.userMigrationFailedValue;
                return str11 == str12 || str11.equals(str12);
            case 7:
                String str13 = this.duplicateExternalMemberIdValue;
                String str14 = memberAddResult.duplicateExternalMemberIdValue;
                return str13 == str14 || str13.equals(str14);
            case 8:
                String str15 = this.duplicateMemberPersistentIdValue;
                String str16 = memberAddResult.duplicateMemberPersistentIdValue;
                return str15 == str16 || str15.equals(str16);
            case 9:
                String str17 = this.persistentIdDisabledValue;
                String str18 = memberAddResult.persistentIdDisabledValue;
                return str17 == str18 || str17.equals(str18);
            case 10:
                String str19 = this.userCreationFailedValue;
                String str20 = memberAddResult.userCreationFailedValue;
                return str19 == str20 || str19.equals(str20);
            case 11:
                TeamMemberInfo teamMemberInfo = this.successValue;
                TeamMemberInfo teamMemberInfo2 = memberAddResult.successValue;
                return teamMemberInfo == teamMemberInfo2 || teamMemberInfo.equals(teamMemberInfo2);
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MemberAddResult$1 */
    static /* synthetic */ class C43651 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag = iArr;
            try {
                iArr[Tag.TEAM_LICENSE_LIMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[Tag.FREE_TEAM_MEMBER_LIMIT_REACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[Tag.USER_ALREADY_ON_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[Tag.USER_ON_ANOTHER_TEAM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[Tag.USER_ALREADY_PAIRED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[Tag.USER_MIGRATION_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[Tag.DUPLICATE_EXTERNAL_MEMBER_ID.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[Tag.DUPLICATE_MEMBER_PERSISTENT_ID.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[Tag.PERSISTENT_ID_DISABLED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[Tag.USER_CREATION_FAILED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[Tag.SUCCESS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<MemberAddResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberAddResult memberAddResult, JsonGenerator jsonGenerator) throws IOException {
            switch (C43651.$SwitchMap$com$dropbox$core$v2$team$MemberAddResult$Tag[memberAddResult.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("team_license_limit", jsonGenerator);
                    jsonGenerator.writeFieldName("team_license_limit");
                    StoneSerializers.string().serialize(memberAddResult.teamLicenseLimitValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("free_team_member_limit_reached", jsonGenerator);
                    jsonGenerator.writeFieldName("free_team_member_limit_reached");
                    StoneSerializers.string().serialize(memberAddResult.freeTeamMemberLimitReachedValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag("user_already_on_team", jsonGenerator);
                    jsonGenerator.writeFieldName("user_already_on_team");
                    StoneSerializers.string().serialize(memberAddResult.userAlreadyOnTeamValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 4:
                    jsonGenerator.writeStartObject();
                    writeTag("user_on_another_team", jsonGenerator);
                    jsonGenerator.writeFieldName("user_on_another_team");
                    StoneSerializers.string().serialize(memberAddResult.userOnAnotherTeamValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 5:
                    jsonGenerator.writeStartObject();
                    writeTag("user_already_paired", jsonGenerator);
                    jsonGenerator.writeFieldName("user_already_paired");
                    StoneSerializers.string().serialize(memberAddResult.userAlreadyPairedValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("user_migration_failed", jsonGenerator);
                    jsonGenerator.writeFieldName("user_migration_failed");
                    StoneSerializers.string().serialize(memberAddResult.userMigrationFailedValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 7:
                    jsonGenerator.writeStartObject();
                    writeTag("duplicate_external_member_id", jsonGenerator);
                    jsonGenerator.writeFieldName("duplicate_external_member_id");
                    StoneSerializers.string().serialize(memberAddResult.duplicateExternalMemberIdValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 8:
                    jsonGenerator.writeStartObject();
                    writeTag("duplicate_member_persistent_id", jsonGenerator);
                    jsonGenerator.writeFieldName("duplicate_member_persistent_id");
                    StoneSerializers.string().serialize(memberAddResult.duplicateMemberPersistentIdValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 9:
                    jsonGenerator.writeStartObject();
                    writeTag("persistent_id_disabled", jsonGenerator);
                    jsonGenerator.writeFieldName("persistent_id_disabled");
                    StoneSerializers.string().serialize(memberAddResult.persistentIdDisabledValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 10:
                    jsonGenerator.writeStartObject();
                    writeTag("user_creation_failed", jsonGenerator);
                    jsonGenerator.writeFieldName("user_creation_failed");
                    StoneSerializers.string().serialize(memberAddResult.userCreationFailedValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 11:
                    jsonGenerator.writeStartObject();
                    writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                    TeamMemberInfo.Serializer.INSTANCE.serialize(memberAddResult.successValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + memberAddResult.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberAddResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberAddResult memberAddResultSuccess;
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
            if ("team_license_limit".equals(tag)) {
                expectField("team_license_limit", jsonParser);
                memberAddResultSuccess = MemberAddResult.teamLicenseLimit(StoneSerializers.string().deserialize(jsonParser));
            } else if ("free_team_member_limit_reached".equals(tag)) {
                expectField("free_team_member_limit_reached", jsonParser);
                memberAddResultSuccess = MemberAddResult.freeTeamMemberLimitReached(StoneSerializers.string().deserialize(jsonParser));
            } else if ("user_already_on_team".equals(tag)) {
                expectField("user_already_on_team", jsonParser);
                memberAddResultSuccess = MemberAddResult.userAlreadyOnTeam(StoneSerializers.string().deserialize(jsonParser));
            } else if ("user_on_another_team".equals(tag)) {
                expectField("user_on_another_team", jsonParser);
                memberAddResultSuccess = MemberAddResult.userOnAnotherTeam(StoneSerializers.string().deserialize(jsonParser));
            } else if ("user_already_paired".equals(tag)) {
                expectField("user_already_paired", jsonParser);
                memberAddResultSuccess = MemberAddResult.userAlreadyPaired(StoneSerializers.string().deserialize(jsonParser));
            } else if ("user_migration_failed".equals(tag)) {
                expectField("user_migration_failed", jsonParser);
                memberAddResultSuccess = MemberAddResult.userMigrationFailed(StoneSerializers.string().deserialize(jsonParser));
            } else if ("duplicate_external_member_id".equals(tag)) {
                expectField("duplicate_external_member_id", jsonParser);
                memberAddResultSuccess = MemberAddResult.duplicateExternalMemberId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("duplicate_member_persistent_id".equals(tag)) {
                expectField("duplicate_member_persistent_id", jsonParser);
                memberAddResultSuccess = MemberAddResult.duplicateMemberPersistentId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("persistent_id_disabled".equals(tag)) {
                expectField("persistent_id_disabled", jsonParser);
                memberAddResultSuccess = MemberAddResult.persistentIdDisabled(StoneSerializers.string().deserialize(jsonParser));
            } else if ("user_creation_failed".equals(tag)) {
                expectField("user_creation_failed", jsonParser);
                memberAddResultSuccess = MemberAddResult.userCreationFailed(StoneSerializers.string().deserialize(jsonParser));
            } else if (FirebaseAnalytics.Param.SUCCESS.equals(tag)) {
                memberAddResultSuccess = MemberAddResult.success(TeamMemberInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberAddResultSuccess;
        }
    }
}
