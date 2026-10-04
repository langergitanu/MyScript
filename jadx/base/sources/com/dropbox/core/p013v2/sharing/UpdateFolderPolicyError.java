package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedFolderAccessError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateFolderPolicyError {
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    public static final UpdateFolderPolicyError NOT_ON_TEAM = new UpdateFolderPolicyError().withTag(Tag.NOT_ON_TEAM);
    public static final UpdateFolderPolicyError TEAM_POLICY_DISALLOWS_MEMBER_POLICY = new UpdateFolderPolicyError().withTag(Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);
    public static final UpdateFolderPolicyError DISALLOWED_SHARED_LINK_POLICY = new UpdateFolderPolicyError().withTag(Tag.DISALLOWED_SHARED_LINK_POLICY);
    public static final UpdateFolderPolicyError NO_PERMISSION = new UpdateFolderPolicyError().withTag(Tag.NO_PERMISSION);
    public static final UpdateFolderPolicyError TEAM_FOLDER = new UpdateFolderPolicyError().withTag(Tag.TEAM_FOLDER);
    public static final UpdateFolderPolicyError OTHER = new UpdateFolderPolicyError().withTag(Tag.OTHER);

    public enum Tag {
        ACCESS_ERROR,
        NOT_ON_TEAM,
        TEAM_POLICY_DISALLOWS_MEMBER_POLICY,
        DISALLOWED_SHARED_LINK_POLICY,
        NO_PERMISSION,
        TEAM_FOLDER,
        OTHER
    }

    private UpdateFolderPolicyError() {
    }

    private UpdateFolderPolicyError withTag(Tag tag) {
        UpdateFolderPolicyError updateFolderPolicyError = new UpdateFolderPolicyError();
        updateFolderPolicyError._tag = tag;
        return updateFolderPolicyError;
    }

    private UpdateFolderPolicyError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        UpdateFolderPolicyError updateFolderPolicyError = new UpdateFolderPolicyError();
        updateFolderPolicyError._tag = tag;
        updateFolderPolicyError.accessErrorValue = sharedFolderAccessError;
        return updateFolderPolicyError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static UpdateFolderPolicyError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdateFolderPolicyError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
    }

    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isNotOnTeam() {
        return this._tag == Tag.NOT_ON_TEAM;
    }

    public boolean isTeamPolicyDisallowsMemberPolicy() {
        return this._tag == Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
    }

    public boolean isDisallowedSharedLinkPolicy() {
        return this._tag == Tag.DISALLOWED_SHARED_LINK_POLICY;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isTeamFolder() {
        return this._tag == Tag.TEAM_FOLDER;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateFolderPolicyError)) {
            return false;
        }
        UpdateFolderPolicyError updateFolderPolicyError = (UpdateFolderPolicyError) obj;
        if (this._tag != updateFolderPolicyError._tag) {
            return false;
        }
        switch (C43151.f740x68d3a61f[this._tag.ordinal()]) {
            case 1:
                SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
                SharedFolderAccessError sharedFolderAccessError2 = updateFolderPolicyError.accessErrorValue;
                return sharedFolderAccessError == sharedFolderAccessError2 || sharedFolderAccessError.equals(sharedFolderAccessError2);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.UpdateFolderPolicyError$1 */
    static /* synthetic */ class C43151 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$UpdateFolderPolicyError$Tag */
        static final /* synthetic */ int[] f740x68d3a61f;

        static {
            int[] iArr = new int[Tag.values().length];
            f740x68d3a61f = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f740x68d3a61f[Tag.NOT_ON_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f740x68d3a61f[Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f740x68d3a61f[Tag.DISALLOWED_SHARED_LINK_POLICY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f740x68d3a61f[Tag.NO_PERMISSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f740x68d3a61f[Tag.TEAM_FOLDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f740x68d3a61f[Tag.OTHER.ordinal()] = 7;
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

    static class Serializer extends UnionSerializer<UpdateFolderPolicyError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UpdateFolderPolicyError updateFolderPolicyError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43151.f740x68d3a61f[updateFolderPolicyError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("access_error", jsonGenerator);
                    jsonGenerator.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(updateFolderPolicyError.accessErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeString("not_on_team");
                    break;
                case 3:
                    jsonGenerator.writeString("team_policy_disallows_member_policy");
                    break;
                case 4:
                    jsonGenerator.writeString("disallowed_shared_link_policy");
                    break;
                case 5:
                    jsonGenerator.writeString("no_permission");
                    break;
                case 6:
                    jsonGenerator.writeString("team_folder");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UpdateFolderPolicyError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UpdateFolderPolicyError updateFolderPolicyErrorAccessError;
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
                updateFolderPolicyErrorAccessError = UpdateFolderPolicyError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("not_on_team".equals(tag)) {
                updateFolderPolicyErrorAccessError = UpdateFolderPolicyError.NOT_ON_TEAM;
            } else if ("team_policy_disallows_member_policy".equals(tag)) {
                updateFolderPolicyErrorAccessError = UpdateFolderPolicyError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
            } else if ("disallowed_shared_link_policy".equals(tag)) {
                updateFolderPolicyErrorAccessError = UpdateFolderPolicyError.DISALLOWED_SHARED_LINK_POLICY;
            } else if ("no_permission".equals(tag)) {
                updateFolderPolicyErrorAccessError = UpdateFolderPolicyError.NO_PERMISSION;
            } else if ("team_folder".equals(tag)) {
                updateFolderPolicyErrorAccessError = UpdateFolderPolicyError.TEAM_FOLDER;
            } else {
                updateFolderPolicyErrorAccessError = UpdateFolderPolicyError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return updateFolderPolicyErrorAccessError;
        }
    }
}
