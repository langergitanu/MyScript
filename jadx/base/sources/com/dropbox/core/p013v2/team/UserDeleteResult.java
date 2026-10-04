package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserDeleteEmailsResult;
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
public final class UserDeleteResult {
    public static final UserDeleteResult OTHER = new UserDeleteResult().withTag(Tag.OTHER);
    private Tag _tag;
    private UserSelectorArg invalidUserValue;
    private UserDeleteEmailsResult successValue;

    public enum Tag {
        SUCCESS,
        INVALID_USER,
        OTHER
    }

    private UserDeleteResult() {
    }

    private UserDeleteResult withTag(Tag tag) {
        UserDeleteResult userDeleteResult = new UserDeleteResult();
        userDeleteResult._tag = tag;
        return userDeleteResult;
    }

    private UserDeleteResult withTagAndSuccess(Tag tag, UserDeleteEmailsResult userDeleteEmailsResult) {
        UserDeleteResult userDeleteResult = new UserDeleteResult();
        userDeleteResult._tag = tag;
        userDeleteResult.successValue = userDeleteEmailsResult;
        return userDeleteResult;
    }

    private UserDeleteResult withTagAndInvalidUser(Tag tag, UserSelectorArg userSelectorArg) {
        UserDeleteResult userDeleteResult = new UserDeleteResult();
        userDeleteResult._tag = tag;
        userDeleteResult.invalidUserValue = userSelectorArg;
        return userDeleteResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static UserDeleteResult success(UserDeleteEmailsResult userDeleteEmailsResult) {
        if (userDeleteEmailsResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserDeleteResult().withTagAndSuccess(Tag.SUCCESS, userDeleteEmailsResult);
    }

    public UserDeleteEmailsResult getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isInvalidUser() {
        return this._tag == Tag.INVALID_USER;
    }

    public static UserDeleteResult invalidUser(UserSelectorArg userSelectorArg) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserDeleteResult().withTagAndInvalidUser(Tag.INVALID_USER, userSelectorArg);
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
        if (obj == null || !(obj instanceof UserDeleteResult)) {
            return false;
        }
        UserDeleteResult userDeleteResult = (UserDeleteResult) obj;
        if (this._tag != userDeleteResult._tag) {
            return false;
        }
        int i = C44221.$SwitchMap$com$dropbox$core$v2$team$UserDeleteResult$Tag[this._tag.ordinal()];
        if (i == 1) {
            UserDeleteEmailsResult userDeleteEmailsResult = this.successValue;
            UserDeleteEmailsResult userDeleteEmailsResult2 = userDeleteResult.successValue;
            return userDeleteEmailsResult == userDeleteEmailsResult2 || userDeleteEmailsResult.equals(userDeleteEmailsResult2);
        }
        if (i != 2) {
            return i == 3;
        }
        UserSelectorArg userSelectorArg = this.invalidUserValue;
        UserSelectorArg userSelectorArg2 = userDeleteResult.invalidUserValue;
        return userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.UserDeleteResult$1 */
    static /* synthetic */ class C44221 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$UserDeleteResult$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$UserDeleteResult$Tag = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UserDeleteResult$Tag[Tag.INVALID_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UserDeleteResult$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<UserDeleteResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UserDeleteResult userDeleteResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C44221.$SwitchMap$com$dropbox$core$v2$team$UserDeleteResult$Tag[userDeleteResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                UserDeleteEmailsResult.Serializer.INSTANCE.serialize(userDeleteResult.successValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("invalid_user", jsonGenerator);
                jsonGenerator.writeFieldName("invalid_user");
                UserSelectorArg.Serializer.INSTANCE.serialize(userDeleteResult.invalidUserValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UserDeleteResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UserDeleteResult userDeleteResultInvalidUser;
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
                userDeleteResultInvalidUser = UserDeleteResult.success(UserDeleteEmailsResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("invalid_user".equals(tag)) {
                expectField("invalid_user", jsonParser);
                userDeleteResultInvalidUser = UserDeleteResult.invalidUser(UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                userDeleteResultInvalidUser = UserDeleteResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return userDeleteResultInvalidUser;
        }
    }
}
