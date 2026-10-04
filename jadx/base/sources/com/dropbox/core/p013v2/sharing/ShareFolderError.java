package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharePathError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ShareFolderError {
    private Tag _tag;
    private SharePathError badPathValue;
    public static final ShareFolderError EMAIL_UNVERIFIED = new ShareFolderError().withTag(Tag.EMAIL_UNVERIFIED);
    public static final ShareFolderError TEAM_POLICY_DISALLOWS_MEMBER_POLICY = new ShareFolderError().withTag(Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);
    public static final ShareFolderError DISALLOWED_SHARED_LINK_POLICY = new ShareFolderError().withTag(Tag.DISALLOWED_SHARED_LINK_POLICY);
    public static final ShareFolderError OTHER = new ShareFolderError().withTag(Tag.OTHER);
    public static final ShareFolderError NO_PERMISSION = new ShareFolderError().withTag(Tag.NO_PERMISSION);

    public enum Tag {
        EMAIL_UNVERIFIED,
        BAD_PATH,
        TEAM_POLICY_DISALLOWS_MEMBER_POLICY,
        DISALLOWED_SHARED_LINK_POLICY,
        OTHER,
        NO_PERMISSION
    }

    private ShareFolderError() {
    }

    private ShareFolderError withTag(Tag tag) {
        ShareFolderError shareFolderError = new ShareFolderError();
        shareFolderError._tag = tag;
        return shareFolderError;
    }

    private ShareFolderError withTagAndBadPath(Tag tag, SharePathError sharePathError) {
        ShareFolderError shareFolderError = new ShareFolderError();
        shareFolderError._tag = tag;
        shareFolderError.badPathValue = sharePathError;
        return shareFolderError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isEmailUnverified() {
        return this._tag == Tag.EMAIL_UNVERIFIED;
    }

    public boolean isBadPath() {
        return this._tag == Tag.BAD_PATH;
    }

    public static ShareFolderError badPath(SharePathError sharePathError) {
        if (sharePathError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ShareFolderError().withTagAndBadPath(Tag.BAD_PATH, sharePathError);
    }

    public SharePathError getBadPathValue() {
        if (this._tag != Tag.BAD_PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.BAD_PATH, but was Tag." + this._tag.name());
        }
        return this.badPathValue;
    }

    public boolean isTeamPolicyDisallowsMemberPolicy() {
        return this._tag == Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
    }

    public boolean isDisallowedSharedLinkPolicy() {
        return this._tag == Tag.DISALLOWED_SHARED_LINK_POLICY;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.badPathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ShareFolderError)) {
            return false;
        }
        ShareFolderError shareFolderError = (ShareFolderError) obj;
        if (this._tag != shareFolderError._tag) {
            return false;
        }
        switch (C42971.$SwitchMap$com$dropbox$core$v2$sharing$ShareFolderError$Tag[this._tag.ordinal()]) {
            case 2:
                SharePathError sharePathError = this.badPathValue;
                SharePathError sharePathError2 = shareFolderError.badPathValue;
                if (sharePathError != sharePathError2 && !sharePathError.equals(sharePathError2)) {
                    return false;
                }
            case 1:
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ShareFolderError$1 */
    static /* synthetic */ class C42971 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderError$Tag = iArr;
            try {
                iArr[Tag.EMAIL_UNVERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderError$Tag[Tag.BAD_PATH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderError$Tag[Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderError$Tag[Tag.DISALLOWED_SHARED_LINK_POLICY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderError$Tag[Tag.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderError$Tag[Tag.NO_PERMISSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<ShareFolderError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ShareFolderError shareFolderError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42971.$SwitchMap$com$dropbox$core$v2$sharing$ShareFolderError$Tag[shareFolderError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeString("email_unverified");
                    return;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("bad_path", jsonGenerator);
                    jsonGenerator.writeFieldName("bad_path");
                    SharePathError.Serializer.INSTANCE.serialize(shareFolderError.badPathValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 3:
                    jsonGenerator.writeString("team_policy_disallows_member_policy");
                    return;
                case 4:
                    jsonGenerator.writeString("disallowed_shared_link_policy");
                    return;
                case 5:
                    jsonGenerator.writeString("other");
                    return;
                case 6:
                    jsonGenerator.writeString("no_permission");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + shareFolderError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ShareFolderError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ShareFolderError shareFolderErrorBadPath;
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
            if ("email_unverified".equals(tag)) {
                shareFolderErrorBadPath = ShareFolderError.EMAIL_UNVERIFIED;
            } else if ("bad_path".equals(tag)) {
                expectField("bad_path", jsonParser);
                shareFolderErrorBadPath = ShareFolderError.badPath(SharePathError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("team_policy_disallows_member_policy".equals(tag)) {
                shareFolderErrorBadPath = ShareFolderError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
            } else if ("disallowed_shared_link_policy".equals(tag)) {
                shareFolderErrorBadPath = ShareFolderError.DISALLOWED_SHARED_LINK_POLICY;
            } else if ("other".equals(tag)) {
                shareFolderErrorBadPath = ShareFolderError.OTHER;
            } else if ("no_permission".equals(tag)) {
                shareFolderErrorBadPath = ShareFolderError.NO_PERMISSION;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return shareFolderErrorBadPath;
        }
    }
}
