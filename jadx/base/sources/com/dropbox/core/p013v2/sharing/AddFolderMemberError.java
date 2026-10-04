package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AddMemberSelectorError;
import com.dropbox.core.p013v2.sharing.SharedFolderAccessError;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class AddFolderMemberError {
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    private AddMemberSelectorError badMemberValue;
    private Long tooManyMembersValue;
    private Long tooManyPendingInvitesValue;
    public static final AddFolderMemberError EMAIL_UNVERIFIED = new AddFolderMemberError().withTag(Tag.EMAIL_UNVERIFIED);
    public static final AddFolderMemberError BANNED_MEMBER = new AddFolderMemberError().withTag(Tag.BANNED_MEMBER);
    public static final AddFolderMemberError CANT_SHARE_OUTSIDE_TEAM = new AddFolderMemberError().withTag(Tag.CANT_SHARE_OUTSIDE_TEAM);
    public static final AddFolderMemberError RATE_LIMIT = new AddFolderMemberError().withTag(Tag.RATE_LIMIT);
    public static final AddFolderMemberError TOO_MANY_INVITEES = new AddFolderMemberError().withTag(Tag.TOO_MANY_INVITEES);
    public static final AddFolderMemberError INSUFFICIENT_PLAN = new AddFolderMemberError().withTag(Tag.INSUFFICIENT_PLAN);
    public static final AddFolderMemberError TEAM_FOLDER = new AddFolderMemberError().withTag(Tag.TEAM_FOLDER);
    public static final AddFolderMemberError NO_PERMISSION = new AddFolderMemberError().withTag(Tag.NO_PERMISSION);
    public static final AddFolderMemberError INVALID_SHARED_FOLDER = new AddFolderMemberError().withTag(Tag.INVALID_SHARED_FOLDER);
    public static final AddFolderMemberError OTHER = new AddFolderMemberError().withTag(Tag.OTHER);

    public enum Tag {
        ACCESS_ERROR,
        EMAIL_UNVERIFIED,
        BANNED_MEMBER,
        BAD_MEMBER,
        CANT_SHARE_OUTSIDE_TEAM,
        TOO_MANY_MEMBERS,
        TOO_MANY_PENDING_INVITES,
        RATE_LIMIT,
        TOO_MANY_INVITEES,
        INSUFFICIENT_PLAN,
        TEAM_FOLDER,
        NO_PERMISSION,
        INVALID_SHARED_FOLDER,
        OTHER
    }

    private AddFolderMemberError() {
    }

    private AddFolderMemberError withTag(Tag tag) {
        AddFolderMemberError addFolderMemberError = new AddFolderMemberError();
        addFolderMemberError._tag = tag;
        return addFolderMemberError;
    }

    private AddFolderMemberError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        AddFolderMemberError addFolderMemberError = new AddFolderMemberError();
        addFolderMemberError._tag = tag;
        addFolderMemberError.accessErrorValue = sharedFolderAccessError;
        return addFolderMemberError;
    }

    private AddFolderMemberError withTagAndBadMember(Tag tag, AddMemberSelectorError addMemberSelectorError) {
        AddFolderMemberError addFolderMemberError = new AddFolderMemberError();
        addFolderMemberError._tag = tag;
        addFolderMemberError.badMemberValue = addMemberSelectorError;
        return addFolderMemberError;
    }

    private AddFolderMemberError withTagAndTooManyMembers(Tag tag, Long l) {
        AddFolderMemberError addFolderMemberError = new AddFolderMemberError();
        addFolderMemberError._tag = tag;
        addFolderMemberError.tooManyMembersValue = l;
        return addFolderMemberError;
    }

    private AddFolderMemberError withTagAndTooManyPendingInvites(Tag tag, Long l) {
        AddFolderMemberError addFolderMemberError = new AddFolderMemberError();
        addFolderMemberError._tag = tag;
        addFolderMemberError.tooManyPendingInvitesValue = l;
        return addFolderMemberError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static AddFolderMemberError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AddFolderMemberError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
    }

    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isEmailUnverified() {
        return this._tag == Tag.EMAIL_UNVERIFIED;
    }

    public boolean isBannedMember() {
        return this._tag == Tag.BANNED_MEMBER;
    }

    public boolean isBadMember() {
        return this._tag == Tag.BAD_MEMBER;
    }

    public static AddFolderMemberError badMember(AddMemberSelectorError addMemberSelectorError) {
        if (addMemberSelectorError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AddFolderMemberError().withTagAndBadMember(Tag.BAD_MEMBER, addMemberSelectorError);
    }

    public AddMemberSelectorError getBadMemberValue() {
        if (this._tag != Tag.BAD_MEMBER) {
            throw new IllegalStateException("Invalid tag: required Tag.BAD_MEMBER, but was Tag." + this._tag.name());
        }
        return this.badMemberValue;
    }

    public boolean isCantShareOutsideTeam() {
        return this._tag == Tag.CANT_SHARE_OUTSIDE_TEAM;
    }

    public boolean isTooManyMembers() {
        return this._tag == Tag.TOO_MANY_MEMBERS;
    }

    public static AddFolderMemberError tooManyMembers(long j) {
        return new AddFolderMemberError().withTagAndTooManyMembers(Tag.TOO_MANY_MEMBERS, Long.valueOf(j));
    }

    public long getTooManyMembersValue() {
        if (this._tag != Tag.TOO_MANY_MEMBERS) {
            throw new IllegalStateException("Invalid tag: required Tag.TOO_MANY_MEMBERS, but was Tag." + this._tag.name());
        }
        return this.tooManyMembersValue.longValue();
    }

    public boolean isTooManyPendingInvites() {
        return this._tag == Tag.TOO_MANY_PENDING_INVITES;
    }

    public static AddFolderMemberError tooManyPendingInvites(long j) {
        return new AddFolderMemberError().withTagAndTooManyPendingInvites(Tag.TOO_MANY_PENDING_INVITES, Long.valueOf(j));
    }

    public long getTooManyPendingInvitesValue() {
        if (this._tag != Tag.TOO_MANY_PENDING_INVITES) {
            throw new IllegalStateException("Invalid tag: required Tag.TOO_MANY_PENDING_INVITES, but was Tag." + this._tag.name());
        }
        return this.tooManyPendingInvitesValue.longValue();
    }

    public boolean isRateLimit() {
        return this._tag == Tag.RATE_LIMIT;
    }

    public boolean isTooManyInvitees() {
        return this._tag == Tag.TOO_MANY_INVITEES;
    }

    public boolean isInsufficientPlan() {
        return this._tag == Tag.INSUFFICIENT_PLAN;
    }

    public boolean isTeamFolder() {
        return this._tag == Tag.TEAM_FOLDER;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isInvalidSharedFolder() {
        return this._tag == Tag.INVALID_SHARED_FOLDER;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue, this.badMemberValue, this.tooManyMembersValue, this.tooManyPendingInvitesValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AddFolderMemberError)) {
            return false;
        }
        AddFolderMemberError addFolderMemberError = (AddFolderMemberError) obj;
        if (this._tag != addFolderMemberError._tag) {
            return false;
        }
        switch (C42501.$SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[this._tag.ordinal()]) {
            case 1:
                SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
                SharedFolderAccessError sharedFolderAccessError2 = addFolderMemberError.accessErrorValue;
                return sharedFolderAccessError == sharedFolderAccessError2 || sharedFolderAccessError.equals(sharedFolderAccessError2);
            case 4:
                AddMemberSelectorError addMemberSelectorError = this.badMemberValue;
                AddMemberSelectorError addMemberSelectorError2 = addFolderMemberError.badMemberValue;
                if (addMemberSelectorError != addMemberSelectorError2 && !addMemberSelectorError.equals(addMemberSelectorError2)) {
                    return false;
                }
            case 2:
            case 3:
                return true;
            case 5:
                return true;
            case 6:
                return this.tooManyMembersValue == addFolderMemberError.tooManyMembersValue;
            case 7:
                return this.tooManyPendingInvitesValue == addFolderMemberError.tooManyPendingInvitesValue;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.AddFolderMemberError$1 */
    static /* synthetic */ class C42501 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.EMAIL_UNVERIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.BANNED_MEMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.BAD_MEMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.CANT_SHARE_OUTSIDE_TEAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.TOO_MANY_MEMBERS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.TOO_MANY_PENDING_INVITES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.RATE_LIMIT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.TOO_MANY_INVITEES.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.INSUFFICIENT_PLAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.TEAM_FOLDER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.NO_PERMISSION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.INVALID_SHARED_FOLDER.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[Tag.OTHER.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<AddFolderMemberError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AddFolderMemberError addFolderMemberError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42501.$SwitchMap$com$dropbox$core$v2$sharing$AddFolderMemberError$Tag[addFolderMemberError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("access_error", jsonGenerator);
                    jsonGenerator.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(addFolderMemberError.accessErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeString("email_unverified");
                    break;
                case 3:
                    jsonGenerator.writeString("banned_member");
                    break;
                case 4:
                    jsonGenerator.writeStartObject();
                    writeTag("bad_member", jsonGenerator);
                    jsonGenerator.writeFieldName("bad_member");
                    AddMemberSelectorError.Serializer.INSTANCE.serialize(addFolderMemberError.badMemberValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 5:
                    jsonGenerator.writeString("cant_share_outside_team");
                    break;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("too_many_members", jsonGenerator);
                    jsonGenerator.writeFieldName("too_many_members");
                    StoneSerializers.uInt64().serialize(addFolderMemberError.tooManyMembersValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 7:
                    jsonGenerator.writeStartObject();
                    writeTag("too_many_pending_invites", jsonGenerator);
                    jsonGenerator.writeFieldName("too_many_pending_invites");
                    StoneSerializers.uInt64().serialize(addFolderMemberError.tooManyPendingInvitesValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 8:
                    jsonGenerator.writeString("rate_limit");
                    break;
                case 9:
                    jsonGenerator.writeString("too_many_invitees");
                    break;
                case 10:
                    jsonGenerator.writeString("insufficient_plan");
                    break;
                case 11:
                    jsonGenerator.writeString("team_folder");
                    break;
                case 12:
                    jsonGenerator.writeString("no_permission");
                    break;
                case 13:
                    jsonGenerator.writeString("invalid_shared_folder");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AddFolderMemberError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AddFolderMemberError addFolderMemberErrorBadMember;
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
            if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                addFolderMemberErrorBadMember = AddFolderMemberError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("email_unverified".equals(tag)) {
                addFolderMemberErrorBadMember = AddFolderMemberError.EMAIL_UNVERIFIED;
            } else if ("banned_member".equals(tag)) {
                addFolderMemberErrorBadMember = AddFolderMemberError.BANNED_MEMBER;
            } else if ("bad_member".equals(tag)) {
                expectField("bad_member", jsonParser);
                addFolderMemberErrorBadMember = AddFolderMemberError.badMember(AddMemberSelectorError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("cant_share_outside_team".equals(tag)) {
                addFolderMemberErrorBadMember = AddFolderMemberError.CANT_SHARE_OUTSIDE_TEAM;
            } else if ("too_many_members".equals(tag)) {
                expectField("too_many_members", jsonParser);
                addFolderMemberErrorBadMember = AddFolderMemberError.tooManyMembers(StoneSerializers.uInt64().deserialize(jsonParser).longValue());
            } else if ("too_many_pending_invites".equals(tag)) {
                expectField("too_many_pending_invites", jsonParser);
                addFolderMemberErrorBadMember = AddFolderMemberError.tooManyPendingInvites(StoneSerializers.uInt64().deserialize(jsonParser).longValue());
            } else if ("rate_limit".equals(tag)) {
                addFolderMemberErrorBadMember = AddFolderMemberError.RATE_LIMIT;
            } else if ("too_many_invitees".equals(tag)) {
                addFolderMemberErrorBadMember = AddFolderMemberError.TOO_MANY_INVITEES;
            } else if ("insufficient_plan".equals(tag)) {
                addFolderMemberErrorBadMember = AddFolderMemberError.INSUFFICIENT_PLAN;
            } else if ("team_folder".equals(tag)) {
                addFolderMemberErrorBadMember = AddFolderMemberError.TEAM_FOLDER;
            } else if ("no_permission".equals(tag)) {
                addFolderMemberErrorBadMember = AddFolderMemberError.NO_PERMISSION;
            } else if ("invalid_shared_folder".equals(tag)) {
                addFolderMemberErrorBadMember = AddFolderMemberError.INVALID_SHARED_FOLDER;
            } else {
                addFolderMemberErrorBadMember = AddFolderMemberError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return addFolderMemberErrorBadMember;
        }
    }
}
