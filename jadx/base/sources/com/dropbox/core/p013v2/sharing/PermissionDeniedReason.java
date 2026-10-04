package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.InsufficientPlan;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class PermissionDeniedReason {
    private Tag _tag;
    private InsufficientPlan insufficientPlanValue;
    public static final PermissionDeniedReason USER_NOT_SAME_TEAM_AS_OWNER = new PermissionDeniedReason().withTag(Tag.USER_NOT_SAME_TEAM_AS_OWNER);
    public static final PermissionDeniedReason USER_NOT_ALLOWED_BY_OWNER = new PermissionDeniedReason().withTag(Tag.USER_NOT_ALLOWED_BY_OWNER);
    public static final PermissionDeniedReason TARGET_IS_INDIRECT_MEMBER = new PermissionDeniedReason().withTag(Tag.TARGET_IS_INDIRECT_MEMBER);
    public static final PermissionDeniedReason TARGET_IS_OWNER = new PermissionDeniedReason().withTag(Tag.TARGET_IS_OWNER);
    public static final PermissionDeniedReason TARGET_IS_SELF = new PermissionDeniedReason().withTag(Tag.TARGET_IS_SELF);
    public static final PermissionDeniedReason TARGET_NOT_ACTIVE = new PermissionDeniedReason().withTag(Tag.TARGET_NOT_ACTIVE);
    public static final PermissionDeniedReason FOLDER_IS_LIMITED_TEAM_FOLDER = new PermissionDeniedReason().withTag(Tag.FOLDER_IS_LIMITED_TEAM_FOLDER);
    public static final PermissionDeniedReason OWNER_NOT_ON_TEAM = new PermissionDeniedReason().withTag(Tag.OWNER_NOT_ON_TEAM);
    public static final PermissionDeniedReason PERMISSION_DENIED = new PermissionDeniedReason().withTag(Tag.PERMISSION_DENIED);
    public static final PermissionDeniedReason RESTRICTED_BY_TEAM = new PermissionDeniedReason().withTag(Tag.RESTRICTED_BY_TEAM);
    public static final PermissionDeniedReason USER_ACCOUNT_TYPE = new PermissionDeniedReason().withTag(Tag.USER_ACCOUNT_TYPE);
    public static final PermissionDeniedReason USER_NOT_ON_TEAM = new PermissionDeniedReason().withTag(Tag.USER_NOT_ON_TEAM);
    public static final PermissionDeniedReason FOLDER_IS_INSIDE_SHARED_FOLDER = new PermissionDeniedReason().withTag(Tag.FOLDER_IS_INSIDE_SHARED_FOLDER);
    public static final PermissionDeniedReason RESTRICTED_BY_PARENT_FOLDER = new PermissionDeniedReason().withTag(Tag.RESTRICTED_BY_PARENT_FOLDER);
    public static final PermissionDeniedReason OTHER = new PermissionDeniedReason().withTag(Tag.OTHER);

    public enum Tag {
        USER_NOT_SAME_TEAM_AS_OWNER,
        USER_NOT_ALLOWED_BY_OWNER,
        TARGET_IS_INDIRECT_MEMBER,
        TARGET_IS_OWNER,
        TARGET_IS_SELF,
        TARGET_NOT_ACTIVE,
        FOLDER_IS_LIMITED_TEAM_FOLDER,
        OWNER_NOT_ON_TEAM,
        PERMISSION_DENIED,
        RESTRICTED_BY_TEAM,
        USER_ACCOUNT_TYPE,
        USER_NOT_ON_TEAM,
        FOLDER_IS_INSIDE_SHARED_FOLDER,
        RESTRICTED_BY_PARENT_FOLDER,
        INSUFFICIENT_PLAN,
        OTHER
    }

    private PermissionDeniedReason() {
    }

    private PermissionDeniedReason withTag(Tag tag) {
        PermissionDeniedReason permissionDeniedReason = new PermissionDeniedReason();
        permissionDeniedReason._tag = tag;
        return permissionDeniedReason;
    }

    private PermissionDeniedReason withTagAndInsufficientPlan(Tag tag, InsufficientPlan insufficientPlan) {
        PermissionDeniedReason permissionDeniedReason = new PermissionDeniedReason();
        permissionDeniedReason._tag = tag;
        permissionDeniedReason.insufficientPlanValue = insufficientPlan;
        return permissionDeniedReason;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUserNotSameTeamAsOwner() {
        return this._tag == Tag.USER_NOT_SAME_TEAM_AS_OWNER;
    }

    public boolean isUserNotAllowedByOwner() {
        return this._tag == Tag.USER_NOT_ALLOWED_BY_OWNER;
    }

    public boolean isTargetIsIndirectMember() {
        return this._tag == Tag.TARGET_IS_INDIRECT_MEMBER;
    }

    public boolean isTargetIsOwner() {
        return this._tag == Tag.TARGET_IS_OWNER;
    }

    public boolean isTargetIsSelf() {
        return this._tag == Tag.TARGET_IS_SELF;
    }

    public boolean isTargetNotActive() {
        return this._tag == Tag.TARGET_NOT_ACTIVE;
    }

    public boolean isFolderIsLimitedTeamFolder() {
        return this._tag == Tag.FOLDER_IS_LIMITED_TEAM_FOLDER;
    }

    public boolean isOwnerNotOnTeam() {
        return this._tag == Tag.OWNER_NOT_ON_TEAM;
    }

    public boolean isPermissionDenied() {
        return this._tag == Tag.PERMISSION_DENIED;
    }

    public boolean isRestrictedByTeam() {
        return this._tag == Tag.RESTRICTED_BY_TEAM;
    }

    public boolean isUserAccountType() {
        return this._tag == Tag.USER_ACCOUNT_TYPE;
    }

    public boolean isUserNotOnTeam() {
        return this._tag == Tag.USER_NOT_ON_TEAM;
    }

    public boolean isFolderIsInsideSharedFolder() {
        return this._tag == Tag.FOLDER_IS_INSIDE_SHARED_FOLDER;
    }

    public boolean isRestrictedByParentFolder() {
        return this._tag == Tag.RESTRICTED_BY_PARENT_FOLDER;
    }

    public boolean isInsufficientPlan() {
        return this._tag == Tag.INSUFFICIENT_PLAN;
    }

    public static PermissionDeniedReason insufficientPlan(InsufficientPlan insufficientPlan) {
        if (insufficientPlan == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PermissionDeniedReason().withTagAndInsufficientPlan(Tag.INSUFFICIENT_PLAN, insufficientPlan);
    }

    public InsufficientPlan getInsufficientPlanValue() {
        if (this._tag != Tag.INSUFFICIENT_PLAN) {
            throw new IllegalStateException("Invalid tag: required Tag.INSUFFICIENT_PLAN, but was Tag." + this._tag.name());
        }
        return this.insufficientPlanValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.insufficientPlanValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof PermissionDeniedReason)) {
            return false;
        }
        PermissionDeniedReason permissionDeniedReason = (PermissionDeniedReason) obj;
        if (this._tag != permissionDeniedReason._tag) {
            return false;
        }
        switch (C42861.f727x39ebfdda[this._tag.ordinal()]) {
            case 15:
                InsufficientPlan insufficientPlan = this.insufficientPlanValue;
                InsufficientPlan insufficientPlan2 = permissionDeniedReason.insufficientPlanValue;
                if (insufficientPlan != insufficientPlan2 && !insufficientPlan.equals(insufficientPlan2)) {
                    return false;
                }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return true;
            case 16:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.PermissionDeniedReason$1 */
    static /* synthetic */ class C42861 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$PermissionDeniedReason$Tag */
        static final /* synthetic */ int[] f727x39ebfdda;

        static {
            int[] iArr = new int[Tag.values().length];
            f727x39ebfdda = iArr;
            try {
                iArr[Tag.USER_NOT_SAME_TEAM_AS_OWNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f727x39ebfdda[Tag.USER_NOT_ALLOWED_BY_OWNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f727x39ebfdda[Tag.TARGET_IS_INDIRECT_MEMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f727x39ebfdda[Tag.TARGET_IS_OWNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f727x39ebfdda[Tag.TARGET_IS_SELF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f727x39ebfdda[Tag.TARGET_NOT_ACTIVE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f727x39ebfdda[Tag.FOLDER_IS_LIMITED_TEAM_FOLDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f727x39ebfdda[Tag.OWNER_NOT_ON_TEAM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f727x39ebfdda[Tag.PERMISSION_DENIED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f727x39ebfdda[Tag.RESTRICTED_BY_TEAM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f727x39ebfdda[Tag.USER_ACCOUNT_TYPE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f727x39ebfdda[Tag.USER_NOT_ON_TEAM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f727x39ebfdda[Tag.FOLDER_IS_INSIDE_SHARED_FOLDER.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f727x39ebfdda[Tag.RESTRICTED_BY_PARENT_FOLDER.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f727x39ebfdda[Tag.INSUFFICIENT_PLAN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f727x39ebfdda[Tag.OTHER.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<PermissionDeniedReason> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PermissionDeniedReason permissionDeniedReason, JsonGenerator jsonGenerator) throws IOException {
            switch (C42861.f727x39ebfdda[permissionDeniedReason.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeString("user_not_same_team_as_owner");
                    break;
                case 2:
                    jsonGenerator.writeString("user_not_allowed_by_owner");
                    break;
                case 3:
                    jsonGenerator.writeString("target_is_indirect_member");
                    break;
                case 4:
                    jsonGenerator.writeString("target_is_owner");
                    break;
                case 5:
                    jsonGenerator.writeString("target_is_self");
                    break;
                case 6:
                    jsonGenerator.writeString("target_not_active");
                    break;
                case 7:
                    jsonGenerator.writeString("folder_is_limited_team_folder");
                    break;
                case 8:
                    jsonGenerator.writeString("owner_not_on_team");
                    break;
                case 9:
                    jsonGenerator.writeString("permission_denied");
                    break;
                case 10:
                    jsonGenerator.writeString("restricted_by_team");
                    break;
                case 11:
                    jsonGenerator.writeString("user_account_type");
                    break;
                case 12:
                    jsonGenerator.writeString("user_not_on_team");
                    break;
                case 13:
                    jsonGenerator.writeString("folder_is_inside_shared_folder");
                    break;
                case 14:
                    jsonGenerator.writeString("restricted_by_parent_folder");
                    break;
                case 15:
                    jsonGenerator.writeStartObject();
                    writeTag("insufficient_plan", jsonGenerator);
                    InsufficientPlan.Serializer.INSTANCE.serialize(permissionDeniedReason.insufficientPlanValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PermissionDeniedReason deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PermissionDeniedReason permissionDeniedReasonInsufficientPlan;
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
            if ("user_not_same_team_as_owner".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.USER_NOT_SAME_TEAM_AS_OWNER;
            } else if ("user_not_allowed_by_owner".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.USER_NOT_ALLOWED_BY_OWNER;
            } else if ("target_is_indirect_member".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.TARGET_IS_INDIRECT_MEMBER;
            } else if ("target_is_owner".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.TARGET_IS_OWNER;
            } else if ("target_is_self".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.TARGET_IS_SELF;
            } else if ("target_not_active".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.TARGET_NOT_ACTIVE;
            } else if ("folder_is_limited_team_folder".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.FOLDER_IS_LIMITED_TEAM_FOLDER;
            } else if ("owner_not_on_team".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.OWNER_NOT_ON_TEAM;
            } else if ("permission_denied".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.PERMISSION_DENIED;
            } else if ("restricted_by_team".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.RESTRICTED_BY_TEAM;
            } else if ("user_account_type".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.USER_ACCOUNT_TYPE;
            } else if ("user_not_on_team".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.USER_NOT_ON_TEAM;
            } else if ("folder_is_inside_shared_folder".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.FOLDER_IS_INSIDE_SHARED_FOLDER;
            } else if ("restricted_by_parent_folder".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.RESTRICTED_BY_PARENT_FOLDER;
            } else if ("insufficient_plan".equals(tag)) {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.insufficientPlan(InsufficientPlan.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                permissionDeniedReasonInsufficientPlan = PermissionDeniedReason.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return permissionDeniedReasonInsufficientPlan;
        }
    }
}
