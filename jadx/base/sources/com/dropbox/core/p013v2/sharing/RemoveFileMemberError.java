package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.MemberAccessLevelResult;
import com.dropbox.core.p013v2.sharing.SharingFileAccessError;
import com.dropbox.core.p013v2.sharing.SharingUserError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoveFileMemberError {
    public static final RemoveFileMemberError OTHER = new RemoveFileMemberError().withTag(Tag.OTHER);
    private Tag _tag;
    private SharingFileAccessError accessErrorValue;
    private MemberAccessLevelResult noExplicitAccessValue;
    private SharingUserError userErrorValue;

    public enum Tag {
        USER_ERROR,
        ACCESS_ERROR,
        NO_EXPLICIT_ACCESS,
        OTHER
    }

    private RemoveFileMemberError() {
    }

    private RemoveFileMemberError withTag(Tag tag) {
        RemoveFileMemberError removeFileMemberError = new RemoveFileMemberError();
        removeFileMemberError._tag = tag;
        return removeFileMemberError;
    }

    private RemoveFileMemberError withTagAndUserError(Tag tag, SharingUserError sharingUserError) {
        RemoveFileMemberError removeFileMemberError = new RemoveFileMemberError();
        removeFileMemberError._tag = tag;
        removeFileMemberError.userErrorValue = sharingUserError;
        return removeFileMemberError;
    }

    private RemoveFileMemberError withTagAndAccessError(Tag tag, SharingFileAccessError sharingFileAccessError) {
        RemoveFileMemberError removeFileMemberError = new RemoveFileMemberError();
        removeFileMemberError._tag = tag;
        removeFileMemberError.accessErrorValue = sharingFileAccessError;
        return removeFileMemberError;
    }

    private RemoveFileMemberError withTagAndNoExplicitAccess(Tag tag, MemberAccessLevelResult memberAccessLevelResult) {
        RemoveFileMemberError removeFileMemberError = new RemoveFileMemberError();
        removeFileMemberError._tag = tag;
        removeFileMemberError.noExplicitAccessValue = memberAccessLevelResult;
        return removeFileMemberError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUserError() {
        return this._tag == Tag.USER_ERROR;
    }

    public static RemoveFileMemberError userError(SharingUserError sharingUserError) {
        if (sharingUserError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveFileMemberError().withTagAndUserError(Tag.USER_ERROR, sharingUserError);
    }

    public SharingUserError getUserErrorValue() {
        if (this._tag != Tag.USER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ERROR, but was Tag." + this._tag.name());
        }
        return this.userErrorValue;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static RemoveFileMemberError accessError(SharingFileAccessError sharingFileAccessError) {
        if (sharingFileAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveFileMemberError().withTagAndAccessError(Tag.ACCESS_ERROR, sharingFileAccessError);
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

    public static RemoveFileMemberError noExplicitAccess(MemberAccessLevelResult memberAccessLevelResult) {
        if (memberAccessLevelResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveFileMemberError().withTagAndNoExplicitAccess(Tag.NO_EXPLICIT_ACCESS, memberAccessLevelResult);
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
        return Arrays.hashCode(new Object[]{this._tag, this.userErrorValue, this.accessErrorValue, this.noExplicitAccessValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RemoveFileMemberError)) {
            return false;
        }
        RemoveFileMemberError removeFileMemberError = (RemoveFileMemberError) obj;
        if (this._tag != removeFileMemberError._tag) {
            return false;
        }
        int i = C42891.$SwitchMap$com$dropbox$core$v2$sharing$RemoveFileMemberError$Tag[this._tag.ordinal()];
        if (i == 1) {
            SharingUserError sharingUserError = this.userErrorValue;
            SharingUserError sharingUserError2 = removeFileMemberError.userErrorValue;
            return sharingUserError == sharingUserError2 || sharingUserError.equals(sharingUserError2);
        }
        if (i == 2) {
            SharingFileAccessError sharingFileAccessError = this.accessErrorValue;
            SharingFileAccessError sharingFileAccessError2 = removeFileMemberError.accessErrorValue;
            return sharingFileAccessError == sharingFileAccessError2 || sharingFileAccessError.equals(sharingFileAccessError2);
        }
        if (i != 3) {
            return i == 4;
        }
        MemberAccessLevelResult memberAccessLevelResult = this.noExplicitAccessValue;
        MemberAccessLevelResult memberAccessLevelResult2 = removeFileMemberError.noExplicitAccessValue;
        return memberAccessLevelResult == memberAccessLevelResult2 || memberAccessLevelResult.equals(memberAccessLevelResult2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.RemoveFileMemberError$1 */
    static /* synthetic */ class C42891 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$RemoveFileMemberError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$RemoveFileMemberError$Tag = iArr;
            try {
                iArr[Tag.USER_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RemoveFileMemberError$Tag[Tag.ACCESS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RemoveFileMemberError$Tag[Tag.NO_EXPLICIT_ACCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RemoveFileMemberError$Tag[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<RemoveFileMemberError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RemoveFileMemberError removeFileMemberError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42891.$SwitchMap$com$dropbox$core$v2$sharing$RemoveFileMemberError$Tag[removeFileMemberError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("user_error", jsonGenerator);
                jsonGenerator.writeFieldName("user_error");
                SharingUserError.Serializer.INSTANCE.serialize(removeFileMemberError.userErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                SharingFileAccessError.Serializer.INSTANCE.serialize(removeFileMemberError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("no_explicit_access", jsonGenerator);
                MemberAccessLevelResult.Serializer.INSTANCE.serialize(removeFileMemberError.noExplicitAccessValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RemoveFileMemberError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RemoveFileMemberError removeFileMemberErrorNoExplicitAccess;
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
            if ("user_error".equals(tag)) {
                expectField("user_error", jsonParser);
                removeFileMemberErrorNoExplicitAccess = RemoveFileMemberError.userError(SharingUserError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                removeFileMemberErrorNoExplicitAccess = RemoveFileMemberError.accessError(SharingFileAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("no_explicit_access".equals(tag)) {
                removeFileMemberErrorNoExplicitAccess = RemoveFileMemberError.noExplicitAccess(MemberAccessLevelResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                removeFileMemberErrorNoExplicitAccess = RemoveFileMemberError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return removeFileMemberErrorNoExplicitAccess;
        }
    }
}
