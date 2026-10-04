package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.FileMemberActionError;
import com.dropbox.core.p013v2.sharing.MemberAccessLevelResult;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class FileMemberRemoveActionResult {
    public static final FileMemberRemoveActionResult OTHER = new FileMemberRemoveActionResult().withTag(Tag.OTHER);
    private Tag _tag;
    private FileMemberActionError memberErrorValue;
    private MemberAccessLevelResult successValue;

    public enum Tag {
        SUCCESS,
        MEMBER_ERROR,
        OTHER
    }

    private FileMemberRemoveActionResult() {
    }

    private FileMemberRemoveActionResult withTag(Tag tag) {
        FileMemberRemoveActionResult fileMemberRemoveActionResult = new FileMemberRemoveActionResult();
        fileMemberRemoveActionResult._tag = tag;
        return fileMemberRemoveActionResult;
    }

    private FileMemberRemoveActionResult withTagAndSuccess(Tag tag, MemberAccessLevelResult memberAccessLevelResult) {
        FileMemberRemoveActionResult fileMemberRemoveActionResult = new FileMemberRemoveActionResult();
        fileMemberRemoveActionResult._tag = tag;
        fileMemberRemoveActionResult.successValue = memberAccessLevelResult;
        return fileMemberRemoveActionResult;
    }

    private FileMemberRemoveActionResult withTagAndMemberError(Tag tag, FileMemberActionError fileMemberActionError) {
        FileMemberRemoveActionResult fileMemberRemoveActionResult = new FileMemberRemoveActionResult();
        fileMemberRemoveActionResult._tag = tag;
        fileMemberRemoveActionResult.memberErrorValue = fileMemberActionError;
        return fileMemberRemoveActionResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static FileMemberRemoveActionResult success(MemberAccessLevelResult memberAccessLevelResult) {
        if (memberAccessLevelResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileMemberRemoveActionResult().withTagAndSuccess(Tag.SUCCESS, memberAccessLevelResult);
    }

    public MemberAccessLevelResult getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isMemberError() {
        return this._tag == Tag.MEMBER_ERROR;
    }

    public static FileMemberRemoveActionResult memberError(FileMemberActionError fileMemberActionError) {
        if (fileMemberActionError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileMemberRemoveActionResult().withTagAndMemberError(Tag.MEMBER_ERROR, fileMemberActionError);
    }

    public FileMemberActionError getMemberErrorValue() {
        if (this._tag != Tag.MEMBER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_ERROR, but was Tag." + this._tag.name());
        }
        return this.memberErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.memberErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof FileMemberRemoveActionResult)) {
            return false;
        }
        FileMemberRemoveActionResult fileMemberRemoveActionResult = (FileMemberRemoveActionResult) obj;
        if (this._tag != fileMemberRemoveActionResult._tag) {
            return false;
        }
        int i = C42581.f719x6b60ab19[this._tag.ordinal()];
        if (i == 1) {
            MemberAccessLevelResult memberAccessLevelResult = this.successValue;
            MemberAccessLevelResult memberAccessLevelResult2 = fileMemberRemoveActionResult.successValue;
            return memberAccessLevelResult == memberAccessLevelResult2 || memberAccessLevelResult.equals(memberAccessLevelResult2);
        }
        if (i != 2) {
            return i == 3;
        }
        FileMemberActionError fileMemberActionError = this.memberErrorValue;
        FileMemberActionError fileMemberActionError2 = fileMemberRemoveActionResult.memberErrorValue;
        return fileMemberActionError == fileMemberActionError2 || fileMemberActionError.equals(fileMemberActionError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.FileMemberRemoveActionResult$1 */
    static /* synthetic */ class C42581 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$FileMemberRemoveActionResult$Tag */
        static final /* synthetic */ int[] f719x6b60ab19;

        static {
            int[] iArr = new int[Tag.values().length];
            f719x6b60ab19 = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f719x6b60ab19[Tag.MEMBER_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f719x6b60ab19[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<FileMemberRemoveActionResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileMemberRemoveActionResult fileMemberRemoveActionResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C42581.f719x6b60ab19[fileMemberRemoveActionResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                MemberAccessLevelResult.Serializer.INSTANCE.serialize(fileMemberRemoveActionResult.successValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("member_error", jsonGenerator);
                jsonGenerator.writeFieldName("member_error");
                FileMemberActionError.Serializer.INSTANCE.serialize(fileMemberRemoveActionResult.memberErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileMemberRemoveActionResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileMemberRemoveActionResult fileMemberRemoveActionResultMemberError;
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
            if (FirebaseAnalytics.Param.SUCCESS.equals(tag)) {
                fileMemberRemoveActionResultMemberError = FileMemberRemoveActionResult.success(MemberAccessLevelResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("member_error".equals(tag)) {
                expectField("member_error", jsonParser);
                fileMemberRemoveActionResultMemberError = FileMemberRemoveActionResult.memberError(FileMemberActionError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                fileMemberRemoveActionResultMemberError = FileMemberRemoveActionResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileMemberRemoveActionResultMemberError;
        }
    }
}
