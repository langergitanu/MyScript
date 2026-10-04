package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.MemberAccessLevelResult;
import com.dropbox.core.p013v2.sharing.SharingFileAccessError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class FileMemberActionError {
    public static final FileMemberActionError INVALID_MEMBER = new FileMemberActionError().withTag(Tag.INVALID_MEMBER);
    public static final FileMemberActionError NO_PERMISSION = new FileMemberActionError().withTag(Tag.NO_PERMISSION);
    public static final FileMemberActionError OTHER = new FileMemberActionError().withTag(Tag.OTHER);
    private Tag _tag;
    private SharingFileAccessError accessErrorValue;
    private MemberAccessLevelResult noExplicitAccessValue;

    public enum Tag {
        INVALID_MEMBER,
        NO_PERMISSION,
        ACCESS_ERROR,
        NO_EXPLICIT_ACCESS,
        OTHER
    }

    private FileMemberActionError() {
    }

    private FileMemberActionError withTag(Tag tag) {
        FileMemberActionError fileMemberActionError = new FileMemberActionError();
        fileMemberActionError._tag = tag;
        return fileMemberActionError;
    }

    private FileMemberActionError withTagAndAccessError(Tag tag, SharingFileAccessError sharingFileAccessError) {
        FileMemberActionError fileMemberActionError = new FileMemberActionError();
        fileMemberActionError._tag = tag;
        fileMemberActionError.accessErrorValue = sharingFileAccessError;
        return fileMemberActionError;
    }

    private FileMemberActionError withTagAndNoExplicitAccess(Tag tag, MemberAccessLevelResult memberAccessLevelResult) {
        FileMemberActionError fileMemberActionError = new FileMemberActionError();
        fileMemberActionError._tag = tag;
        fileMemberActionError.noExplicitAccessValue = memberAccessLevelResult;
        return fileMemberActionError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInvalidMember() {
        return this._tag == Tag.INVALID_MEMBER;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static FileMemberActionError accessError(SharingFileAccessError sharingFileAccessError) {
        if (sharingFileAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileMemberActionError().withTagAndAccessError(Tag.ACCESS_ERROR, sharingFileAccessError);
    }

    public SharingFileAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isNoExplicitAccess() {
        return this._tag == Tag.NO_EXPLICIT_ACCESS;
    }

    public static FileMemberActionError noExplicitAccess(MemberAccessLevelResult memberAccessLevelResult) {
        if (memberAccessLevelResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileMemberActionError().withTagAndNoExplicitAccess(Tag.NO_EXPLICIT_ACCESS, memberAccessLevelResult);
    }

    public MemberAccessLevelResult getNoExplicitAccessValue() {
        if (this._tag != Tag.NO_EXPLICIT_ACCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.NO_EXPLICIT_ACCESS, but was Tag." + this._tag.name());
        }
        return this.noExplicitAccessValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue, this.noExplicitAccessValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof FileMemberActionError)) {
            return false;
        }
        FileMemberActionError fileMemberActionError = (FileMemberActionError) obj;
        if (this._tag != fileMemberActionError._tag) {
            return false;
        }
        int i = C42561.$SwitchMap$com$dropbox$core$v2$sharing$FileMemberActionError$Tag[this._tag.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                if (i != 4) {
                    return i == 5;
                }
                MemberAccessLevelResult memberAccessLevelResult = this.noExplicitAccessValue;
                MemberAccessLevelResult memberAccessLevelResult2 = fileMemberActionError.noExplicitAccessValue;
                return memberAccessLevelResult == memberAccessLevelResult2 || memberAccessLevelResult.equals(memberAccessLevelResult2);
            }
            SharingFileAccessError sharingFileAccessError = this.accessErrorValue;
            SharingFileAccessError sharingFileAccessError2 = fileMemberActionError.accessErrorValue;
            if (sharingFileAccessError != sharingFileAccessError2 && !sharingFileAccessError.equals(sharingFileAccessError2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.FileMemberActionError$1 */
    static /* synthetic */ class C42561 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$FileMemberActionError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$FileMemberActionError$Tag = iArr;
            try {
                iArr[Tag.INVALID_MEMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileMemberActionError$Tag[Tag.NO_PERMISSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileMemberActionError$Tag[Tag.ACCESS_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileMemberActionError$Tag[Tag.NO_EXPLICIT_ACCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileMemberActionError$Tag[Tag.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<FileMemberActionError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileMemberActionError fileMemberActionError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42561.$SwitchMap$com$dropbox$core$v2$sharing$FileMemberActionError$Tag[fileMemberActionError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invalid_member");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("no_permission");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                SharingFileAccessError.Serializer.INSTANCE.serialize(fileMemberActionError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 4) {
                jsonGenerator.writeStartObject();
                writeTag("no_explicit_access", jsonGenerator);
                MemberAccessLevelResult.Serializer.INSTANCE.serialize(fileMemberActionError.noExplicitAccessValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileMemberActionError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileMemberActionError fileMemberActionErrorNoExplicitAccess;
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
            if ("invalid_member".equals(tag)) {
                fileMemberActionErrorNoExplicitAccess = FileMemberActionError.INVALID_MEMBER;
            } else if ("no_permission".equals(tag)) {
                fileMemberActionErrorNoExplicitAccess = FileMemberActionError.NO_PERMISSION;
            } else if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                fileMemberActionErrorNoExplicitAccess = FileMemberActionError.accessError(SharingFileAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("no_explicit_access".equals(tag)) {
                fileMemberActionErrorNoExplicitAccess = FileMemberActionError.noExplicitAccess(MemberAccessLevelResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                fileMemberActionErrorNoExplicitAccess = FileMemberActionError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileMemberActionErrorNoExplicitAccess;
        }
    }
}
