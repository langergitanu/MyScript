package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamMemberInfoV2;
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
public final class MemberAddV2Result {
    public static final MemberAddV2Result OTHER = new MemberAddV2Result().withTag(Tag.OTHER);
    private Tag _tag;
    private String duplicateExternalMemberIdValue;
    private String duplicateMemberPersistentIdValue;
    private String freeTeamMemberLimitReachedValue;
    private String persistentIdDisabledValue;
    private TeamMemberInfoV2 successValue;
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
        SUCCESS,
        OTHER
    }

    private MemberAddV2Result() {
    }

    private MemberAddV2Result withTag(Tag tag) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndTeamLicenseLimit(Tag tag, String str) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.teamLicenseLimitValue = str;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndFreeTeamMemberLimitReached(Tag tag, String str) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.freeTeamMemberLimitReachedValue = str;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndUserAlreadyOnTeam(Tag tag, String str) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.userAlreadyOnTeamValue = str;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndUserOnAnotherTeam(Tag tag, String str) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.userOnAnotherTeamValue = str;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndUserAlreadyPaired(Tag tag, String str) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.userAlreadyPairedValue = str;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndUserMigrationFailed(Tag tag, String str) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.userMigrationFailedValue = str;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndDuplicateExternalMemberId(Tag tag, String str) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.duplicateExternalMemberIdValue = str;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndDuplicateMemberPersistentId(Tag tag, String str) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.duplicateMemberPersistentIdValue = str;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndPersistentIdDisabled(Tag tag, String str) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.persistentIdDisabledValue = str;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndUserCreationFailed(Tag tag, String str) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.userCreationFailedValue = str;
        return memberAddV2Result;
    }

    private MemberAddV2Result withTagAndSuccess(Tag tag, TeamMemberInfoV2 teamMemberInfoV2) {
        MemberAddV2Result memberAddV2Result = new MemberAddV2Result();
        memberAddV2Result._tag = tag;
        memberAddV2Result.successValue = teamMemberInfoV2;
        return memberAddV2Result;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isTeamLicenseLimit() {
        return this._tag == Tag.TEAM_LICENSE_LIMIT;
    }

    public static MemberAddV2Result teamLicenseLimit(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddV2Result().withTagAndTeamLicenseLimit(Tag.TEAM_LICENSE_LIMIT, str);
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

    public static MemberAddV2Result freeTeamMemberLimitReached(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddV2Result().withTagAndFreeTeamMemberLimitReached(Tag.FREE_TEAM_MEMBER_LIMIT_REACHED, str);
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

    public static MemberAddV2Result userAlreadyOnTeam(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddV2Result().withTagAndUserAlreadyOnTeam(Tag.USER_ALREADY_ON_TEAM, str);
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

    public static MemberAddV2Result userOnAnotherTeam(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddV2Result().withTagAndUserOnAnotherTeam(Tag.USER_ON_ANOTHER_TEAM, str);
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

    public static MemberAddV2Result userAlreadyPaired(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddV2Result().withTagAndUserAlreadyPaired(Tag.USER_ALREADY_PAIRED, str);
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

    public static MemberAddV2Result userMigrationFailed(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddV2Result().withTagAndUserMigrationFailed(Tag.USER_MIGRATION_FAILED, str);
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

    public static MemberAddV2Result duplicateExternalMemberId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddV2Result().withTagAndDuplicateExternalMemberId(Tag.DUPLICATE_EXTERNAL_MEMBER_ID, str);
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

    public static MemberAddV2Result duplicateMemberPersistentId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddV2Result().withTagAndDuplicateMemberPersistentId(Tag.DUPLICATE_MEMBER_PERSISTENT_ID, str);
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

    public static MemberAddV2Result persistentIdDisabled(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddV2Result().withTagAndPersistentIdDisabled(Tag.PERSISTENT_ID_DISABLED, str);
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

    public static MemberAddV2Result userCreationFailed(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddV2Result().withTagAndUserCreationFailed(Tag.USER_CREATION_FAILED, str);
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

    public static MemberAddV2Result success(TeamMemberInfoV2 teamMemberInfoV2) {
        if (teamMemberInfoV2 == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MemberAddV2Result().withTagAndSuccess(Tag.SUCCESS, teamMemberInfoV2);
    }

    public TeamMemberInfoV2 getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.teamLicenseLimitValue, this.freeTeamMemberLimitReachedValue, this.userAlreadyOnTeamValue, this.userOnAnotherTeamValue, this.userAlreadyPairedValue, this.userMigrationFailedValue, this.duplicateExternalMemberIdValue, this.duplicateMemberPersistentIdValue, this.persistentIdDisabledValue, this.userCreationFailedValue, this.successValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MemberAddV2Result)) {
            return false;
        }
        MemberAddV2Result memberAddV2Result = (MemberAddV2Result) obj;
        if (this._tag != memberAddV2Result._tag) {
            return false;
        }
        switch (C43661.$SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[this._tag.ordinal()]) {
            case 1:
                String str = this.teamLicenseLimitValue;
                String str2 = memberAddV2Result.teamLicenseLimitValue;
                return str == str2 || str.equals(str2);
            case 2:
                String str3 = this.freeTeamMemberLimitReachedValue;
                String str4 = memberAddV2Result.freeTeamMemberLimitReachedValue;
                return str3 == str4 || str3.equals(str4);
            case 3:
                String str5 = this.userAlreadyOnTeamValue;
                String str6 = memberAddV2Result.userAlreadyOnTeamValue;
                return str5 == str6 || str5.equals(str6);
            case 4:
                String str7 = this.userOnAnotherTeamValue;
                String str8 = memberAddV2Result.userOnAnotherTeamValue;
                return str7 == str8 || str7.equals(str8);
            case 5:
                String str9 = this.userAlreadyPairedValue;
                String str10 = memberAddV2Result.userAlreadyPairedValue;
                return str9 == str10 || str9.equals(str10);
            case 6:
                String str11 = this.userMigrationFailedValue;
                String str12 = memberAddV2Result.userMigrationFailedValue;
                return str11 == str12 || str11.equals(str12);
            case 7:
                String str13 = this.duplicateExternalMemberIdValue;
                String str14 = memberAddV2Result.duplicateExternalMemberIdValue;
                return str13 == str14 || str13.equals(str14);
            case 8:
                String str15 = this.duplicateMemberPersistentIdValue;
                String str16 = memberAddV2Result.duplicateMemberPersistentIdValue;
                return str15 == str16 || str15.equals(str16);
            case 9:
                String str17 = this.persistentIdDisabledValue;
                String str18 = memberAddV2Result.persistentIdDisabledValue;
                return str17 == str18 || str17.equals(str18);
            case 10:
                String str19 = this.userCreationFailedValue;
                String str20 = memberAddV2Result.userCreationFailedValue;
                return str19 == str20 || str19.equals(str20);
            case 11:
                TeamMemberInfoV2 teamMemberInfoV2 = this.successValue;
                TeamMemberInfoV2 teamMemberInfoV22 = memberAddV2Result.successValue;
                return teamMemberInfoV2 == teamMemberInfoV22 || teamMemberInfoV2.equals(teamMemberInfoV22);
            case 12:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MemberAddV2Result$1 */
    static /* synthetic */ class C43661 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag = iArr;
            try {
                iArr[Tag.TEAM_LICENSE_LIMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.FREE_TEAM_MEMBER_LIMIT_REACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.USER_ALREADY_ON_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.USER_ON_ANOTHER_TEAM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.USER_ALREADY_PAIRED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.USER_MIGRATION_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.DUPLICATE_EXTERNAL_MEMBER_ID.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.DUPLICATE_MEMBER_PERSISTENT_ID.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.PERSISTENT_ID_DISABLED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.USER_CREATION_FAILED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.SUCCESS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[Tag.OTHER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<MemberAddV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberAddV2Result memberAddV2Result, JsonGenerator jsonGenerator) throws IOException {
            switch (C43661.$SwitchMap$com$dropbox$core$v2$team$MemberAddV2Result$Tag[memberAddV2Result.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("team_license_limit", jsonGenerator);
                    jsonGenerator.writeFieldName("team_license_limit");
                    StoneSerializers.string().serialize(memberAddV2Result.teamLicenseLimitValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("free_team_member_limit_reached", jsonGenerator);
                    jsonGenerator.writeFieldName("free_team_member_limit_reached");
                    StoneSerializers.string().serialize(memberAddV2Result.freeTeamMemberLimitReachedValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag("user_already_on_team", jsonGenerator);
                    jsonGenerator.writeFieldName("user_already_on_team");
                    StoneSerializers.string().serialize(memberAddV2Result.userAlreadyOnTeamValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 4:
                    jsonGenerator.writeStartObject();
                    writeTag("user_on_another_team", jsonGenerator);
                    jsonGenerator.writeFieldName("user_on_another_team");
                    StoneSerializers.string().serialize(memberAddV2Result.userOnAnotherTeamValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 5:
                    jsonGenerator.writeStartObject();
                    writeTag("user_already_paired", jsonGenerator);
                    jsonGenerator.writeFieldName("user_already_paired");
                    StoneSerializers.string().serialize(memberAddV2Result.userAlreadyPairedValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("user_migration_failed", jsonGenerator);
                    jsonGenerator.writeFieldName("user_migration_failed");
                    StoneSerializers.string().serialize(memberAddV2Result.userMigrationFailedValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 7:
                    jsonGenerator.writeStartObject();
                    writeTag("duplicate_external_member_id", jsonGenerator);
                    jsonGenerator.writeFieldName("duplicate_external_member_id");
                    StoneSerializers.string().serialize(memberAddV2Result.duplicateExternalMemberIdValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 8:
                    jsonGenerator.writeStartObject();
                    writeTag("duplicate_member_persistent_id", jsonGenerator);
                    jsonGenerator.writeFieldName("duplicate_member_persistent_id");
                    StoneSerializers.string().serialize(memberAddV2Result.duplicateMemberPersistentIdValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 9:
                    jsonGenerator.writeStartObject();
                    writeTag("persistent_id_disabled", jsonGenerator);
                    jsonGenerator.writeFieldName("persistent_id_disabled");
                    StoneSerializers.string().serialize(memberAddV2Result.persistentIdDisabledValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 10:
                    jsonGenerator.writeStartObject();
                    writeTag("user_creation_failed", jsonGenerator);
                    jsonGenerator.writeFieldName("user_creation_failed");
                    StoneSerializers.string().serialize(memberAddV2Result.userCreationFailedValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 11:
                    jsonGenerator.writeStartObject();
                    writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                    TeamMemberInfoV2.Serializer.INSTANCE.serialize(memberAddV2Result.successValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberAddV2Result deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberAddV2Result memberAddV2ResultSuccess;
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
                memberAddV2ResultSuccess = MemberAddV2Result.teamLicenseLimit(StoneSerializers.string().deserialize(jsonParser));
            } else if ("free_team_member_limit_reached".equals(tag)) {
                expectField("free_team_member_limit_reached", jsonParser);
                memberAddV2ResultSuccess = MemberAddV2Result.freeTeamMemberLimitReached(StoneSerializers.string().deserialize(jsonParser));
            } else if ("user_already_on_team".equals(tag)) {
                expectField("user_already_on_team", jsonParser);
                memberAddV2ResultSuccess = MemberAddV2Result.userAlreadyOnTeam(StoneSerializers.string().deserialize(jsonParser));
            } else if ("user_on_another_team".equals(tag)) {
                expectField("user_on_another_team", jsonParser);
                memberAddV2ResultSuccess = MemberAddV2Result.userOnAnotherTeam(StoneSerializers.string().deserialize(jsonParser));
            } else if ("user_already_paired".equals(tag)) {
                expectField("user_already_paired", jsonParser);
                memberAddV2ResultSuccess = MemberAddV2Result.userAlreadyPaired(StoneSerializers.string().deserialize(jsonParser));
            } else if ("user_migration_failed".equals(tag)) {
                expectField("user_migration_failed", jsonParser);
                memberAddV2ResultSuccess = MemberAddV2Result.userMigrationFailed(StoneSerializers.string().deserialize(jsonParser));
            } else if ("duplicate_external_member_id".equals(tag)) {
                expectField("duplicate_external_member_id", jsonParser);
                memberAddV2ResultSuccess = MemberAddV2Result.duplicateExternalMemberId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("duplicate_member_persistent_id".equals(tag)) {
                expectField("duplicate_member_persistent_id", jsonParser);
                memberAddV2ResultSuccess = MemberAddV2Result.duplicateMemberPersistentId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("persistent_id_disabled".equals(tag)) {
                expectField("persistent_id_disabled", jsonParser);
                memberAddV2ResultSuccess = MemberAddV2Result.persistentIdDisabled(StoneSerializers.string().deserialize(jsonParser));
            } else if ("user_creation_failed".equals(tag)) {
                expectField("user_creation_failed", jsonParser);
                memberAddV2ResultSuccess = MemberAddV2Result.userCreationFailed(StoneSerializers.string().deserialize(jsonParser));
            } else if (FirebaseAnalytics.Param.SUCCESS.equals(tag)) {
                memberAddV2ResultSuccess = MemberAddV2Result.success(TeamMemberInfoV2.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                memberAddV2ResultSuccess = MemberAddV2Result.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberAddV2ResultSuccess;
        }
    }
}
