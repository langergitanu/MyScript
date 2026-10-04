package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.MemberAccessLevelResult;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class SharedFolderMemberError {
    public static final SharedFolderMemberError INVALID_DROPBOX_ID = new SharedFolderMemberError().withTag(Tag.INVALID_DROPBOX_ID);
    public static final SharedFolderMemberError NOT_A_MEMBER = new SharedFolderMemberError().withTag(Tag.NOT_A_MEMBER);
    public static final SharedFolderMemberError OTHER = new SharedFolderMemberError().withTag(Tag.OTHER);
    private Tag _tag;
    private MemberAccessLevelResult noExplicitAccessValue;

    public enum Tag {
        INVALID_DROPBOX_ID,
        NOT_A_MEMBER,
        NO_EXPLICIT_ACCESS,
        OTHER
    }

    private SharedFolderMemberError() {
    }

    private SharedFolderMemberError withTag(Tag tag) {
        SharedFolderMemberError sharedFolderMemberError = new SharedFolderMemberError();
        sharedFolderMemberError._tag = tag;
        return sharedFolderMemberError;
    }

    private SharedFolderMemberError withTagAndNoExplicitAccess(Tag tag, MemberAccessLevelResult memberAccessLevelResult) {
        SharedFolderMemberError sharedFolderMemberError = new SharedFolderMemberError();
        sharedFolderMemberError._tag = tag;
        sharedFolderMemberError.noExplicitAccessValue = memberAccessLevelResult;
        return sharedFolderMemberError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInvalidDropboxId() {
        return this._tag == Tag.INVALID_DROPBOX_ID;
    }

    public boolean isNotAMember() {
        return this._tag == Tag.NOT_A_MEMBER;
    }

    public boolean isNoExplicitAccess() {
        return this._tag == Tag.NO_EXPLICIT_ACCESS;
    }

    public static SharedFolderMemberError noExplicitAccess(MemberAccessLevelResult memberAccessLevelResult) {
        if (memberAccessLevelResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharedFolderMemberError().withTagAndNoExplicitAccess(Tag.NO_EXPLICIT_ACCESS, memberAccessLevelResult);
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
        return Arrays.hashCode(new Object[]{this._tag, this.noExplicitAccessValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof SharedFolderMemberError)) {
            return false;
        }
        SharedFolderMemberError sharedFolderMemberError = (SharedFolderMemberError) obj;
        if (this._tag != sharedFolderMemberError._tag) {
            return false;
        }
        int i = C43021.f734x8bb57b9b[this._tag.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                return i == 4;
            }
            MemberAccessLevelResult memberAccessLevelResult = this.noExplicitAccessValue;
            MemberAccessLevelResult memberAccessLevelResult2 = sharedFolderMemberError.noExplicitAccessValue;
            if (memberAccessLevelResult != memberAccessLevelResult2 && !memberAccessLevelResult.equals(memberAccessLevelResult2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SharedFolderMemberError$1 */
    static /* synthetic */ class C43021 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$SharedFolderMemberError$Tag */
        static final /* synthetic */ int[] f734x8bb57b9b;

        static {
            int[] iArr = new int[Tag.values().length];
            f734x8bb57b9b = iArr;
            try {
                iArr[Tag.INVALID_DROPBOX_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f734x8bb57b9b[Tag.NOT_A_MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f734x8bb57b9b[Tag.NO_EXPLICIT_ACCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f734x8bb57b9b[Tag.OTHER.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<SharedFolderMemberError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedFolderMemberError sharedFolderMemberError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43021.f734x8bb57b9b[sharedFolderMemberError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invalid_dropbox_id");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("not_a_member");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("no_explicit_access", jsonGenerator);
                MemberAccessLevelResult.Serializer.INSTANCE.serialize(sharedFolderMemberError.noExplicitAccessValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedFolderMemberError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedFolderMemberError sharedFolderMemberErrorNoExplicitAccess;
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
            if ("invalid_dropbox_id".equals(tag)) {
                sharedFolderMemberErrorNoExplicitAccess = SharedFolderMemberError.INVALID_DROPBOX_ID;
            } else if ("not_a_member".equals(tag)) {
                sharedFolderMemberErrorNoExplicitAccess = SharedFolderMemberError.NOT_A_MEMBER;
            } else if ("no_explicit_access".equals(tag)) {
                sharedFolderMemberErrorNoExplicitAccess = SharedFolderMemberError.noExplicitAccess(MemberAccessLevelResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                sharedFolderMemberErrorNoExplicitAccess = SharedFolderMemberError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedFolderMemberErrorNoExplicitAccess;
        }
    }
}
