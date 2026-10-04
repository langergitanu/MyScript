package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserResendEmailsResult;
import com.dropbox.core.p013v2.team.UserSelectorArg;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class UserResendResult {
    public static final UserResendResult OTHER = new UserResendResult().withTag(Tag.OTHER);
    private Tag _tag;
    private UserSelectorArg invalidUserValue;
    private UserResendEmailsResult successValue;

    public enum Tag {
        SUCCESS,
        INVALID_USER,
        OTHER
    }

    private UserResendResult() {
    }

    private UserResendResult withTag(Tag tag) {
        UserResendResult userResendResult = new UserResendResult();
        userResendResult._tag = tag;
        return userResendResult;
    }

    private UserResendResult withTagAndSuccess(Tag tag, UserResendEmailsResult userResendEmailsResult) {
        UserResendResult userResendResult = new UserResendResult();
        userResendResult._tag = tag;
        userResendResult.successValue = userResendEmailsResult;
        return userResendResult;
    }

    private UserResendResult withTagAndInvalidUser(Tag tag, UserSelectorArg userSelectorArg) {
        UserResendResult userResendResult = new UserResendResult();
        userResendResult._tag = tag;
        userResendResult.invalidUserValue = userSelectorArg;
        return userResendResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static UserResendResult success(UserResendEmailsResult userResendEmailsResult) {
        if (userResendEmailsResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserResendResult().withTagAndSuccess(Tag.SUCCESS, userResendEmailsResult);
    }

    public UserResendEmailsResult getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isInvalidUser() {
        return this._tag == Tag.INVALID_USER;
    }

    public static UserResendResult invalidUser(UserSelectorArg userSelectorArg) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserResendResult().withTagAndInvalidUser(Tag.INVALID_USER, userSelectorArg);
    }

    public UserSelectorArg getInvalidUserValue() {
        if (this._tag != Tag.INVALID_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_USER, but was Tag." + this._tag.name());
        }
        return this.invalidUserValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.invalidUserValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UserResendResult)) {
            return false;
        }
        UserResendResult userResendResult = (UserResendResult) obj;
        if (this._tag != userResendResult._tag) {
            return false;
        }
        int i = C44231.$SwitchMap$com$dropbox$core$v2$team$UserResendResult$Tag[this._tag.ordinal()];
        if (i == 1) {
            UserResendEmailsResult userResendEmailsResult = this.successValue;
            UserResendEmailsResult userResendEmailsResult2 = userResendResult.successValue;
            return userResendEmailsResult == userResendEmailsResult2 || userResendEmailsResult.equals(userResendEmailsResult2);
        }
        if (i != 2) {
            return i == 3;
        }
        UserSelectorArg userSelectorArg = this.invalidUserValue;
        UserSelectorArg userSelectorArg2 = userResendResult.invalidUserValue;
        return userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.UserResendResult$1 */
    static /* synthetic */ class C44231 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$UserResendResult$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$UserResendResult$Tag = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UserResendResult$Tag[Tag.INVALID_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UserResendResult$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<UserResendResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UserResendResult userResendResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C44231.$SwitchMap$com$dropbox$core$v2$team$UserResendResult$Tag[userResendResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                UserResendEmailsResult.Serializer.INSTANCE.serialize(userResendResult.successValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("invalid_user", jsonGenerator);
                jsonGenerator.writeFieldName("invalid_user");
                UserSelectorArg.Serializer.INSTANCE.serialize(userResendResult.invalidUserValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UserResendResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UserResendResult userResendResultInvalidUser;
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
                userResendResultInvalidUser = UserResendResult.success(UserResendEmailsResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("invalid_user".equals(tag)) {
                expectField("invalid_user", jsonParser);
                userResendResultInvalidUser = UserResendResult.invalidUser(UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                userResendResultInvalidUser = UserResendResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return userResendResultInvalidUser;
        }
    }
}
