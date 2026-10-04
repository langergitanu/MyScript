package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.FileMemberActionError;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class FileMemberActionIndividualResult {
    private Tag _tag;
    private FileMemberActionError memberErrorValue;
    private AccessLevel successValue;

    public enum Tag {
        SUCCESS,
        MEMBER_ERROR
    }

    private FileMemberActionIndividualResult() {
    }

    private FileMemberActionIndividualResult withTag(Tag tag) {
        FileMemberActionIndividualResult fileMemberActionIndividualResult = new FileMemberActionIndividualResult();
        fileMemberActionIndividualResult._tag = tag;
        return fileMemberActionIndividualResult;
    }

    private FileMemberActionIndividualResult withTagAndSuccess(Tag tag, AccessLevel accessLevel) {
        FileMemberActionIndividualResult fileMemberActionIndividualResult = new FileMemberActionIndividualResult();
        fileMemberActionIndividualResult._tag = tag;
        fileMemberActionIndividualResult.successValue = accessLevel;
        return fileMemberActionIndividualResult;
    }

    private FileMemberActionIndividualResult withTagAndMemberError(Tag tag, FileMemberActionError fileMemberActionError) {
        FileMemberActionIndividualResult fileMemberActionIndividualResult = new FileMemberActionIndividualResult();
        fileMemberActionIndividualResult._tag = tag;
        fileMemberActionIndividualResult.memberErrorValue = fileMemberActionError;
        return fileMemberActionIndividualResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static FileMemberActionIndividualResult success(AccessLevel accessLevel) {
        return new FileMemberActionIndividualResult().withTagAndSuccess(Tag.SUCCESS, accessLevel);
    }

    public static FileMemberActionIndividualResult success() {
        return success(null);
    }

    public AccessLevel getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isMemberError() {
        return this._tag == Tag.MEMBER_ERROR;
    }

    public static FileMemberActionIndividualResult memberError(FileMemberActionError fileMemberActionError) {
        if (fileMemberActionError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileMemberActionIndividualResult().withTagAndMemberError(Tag.MEMBER_ERROR, fileMemberActionError);
    }

    public FileMemberActionError getMemberErrorValue() {
        if (this._tag != Tag.MEMBER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_ERROR, but was Tag." + this._tag.name());
        }
        return this.memberErrorValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.memberErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof FileMemberActionIndividualResult)) {
            return false;
        }
        FileMemberActionIndividualResult fileMemberActionIndividualResult = (FileMemberActionIndividualResult) obj;
        if (this._tag != fileMemberActionIndividualResult._tag) {
            return false;
        }
        int i = C42571.f718x94b6406e[this._tag.ordinal()];
        if (i == 1) {
            AccessLevel accessLevel = this.successValue;
            AccessLevel accessLevel2 = fileMemberActionIndividualResult.successValue;
            return accessLevel == accessLevel2 || (accessLevel != null && accessLevel.equals(accessLevel2));
        }
        if (i != 2) {
            return false;
        }
        FileMemberActionError fileMemberActionError = this.memberErrorValue;
        FileMemberActionError fileMemberActionError2 = fileMemberActionIndividualResult.memberErrorValue;
        return fileMemberActionError == fileMemberActionError2 || fileMemberActionError.equals(fileMemberActionError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.FileMemberActionIndividualResult$1 */
    static /* synthetic */ class C42571 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$FileMemberActionIndividualResult$Tag */
        static final /* synthetic */ int[] f718x94b6406e;

        static {
            int[] iArr = new int[Tag.values().length];
            f718x94b6406e = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f718x94b6406e[Tag.MEMBER_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<FileMemberActionIndividualResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileMemberActionIndividualResult fileMemberActionIndividualResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C42571.f718x94b6406e[fileMemberActionIndividualResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.SUCCESS);
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(fileMemberActionIndividualResult.successValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("member_error", jsonGenerator);
                jsonGenerator.writeFieldName("member_error");
                FileMemberActionError.Serializer.INSTANCE.serialize(fileMemberActionIndividualResult.memberErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + fileMemberActionIndividualResult.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileMemberActionIndividualResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileMemberActionIndividualResult fileMemberActionIndividualResultMemberError;
            AccessLevel accessLevel;
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
                if (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                    expectField(FirebaseAnalytics.Param.SUCCESS, jsonParser);
                    accessLevel = (AccessLevel) StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                } else {
                    accessLevel = null;
                }
                if (accessLevel == null) {
                    fileMemberActionIndividualResultMemberError = FileMemberActionIndividualResult.success();
                } else {
                    fileMemberActionIndividualResultMemberError = FileMemberActionIndividualResult.success(accessLevel);
                }
            } else if ("member_error".equals(tag)) {
                expectField("member_error", jsonParser);
                fileMemberActionIndividualResultMemberError = FileMemberActionIndividualResult.memberError(FileMemberActionError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileMemberActionIndividualResultMemberError;
        }
    }
}
