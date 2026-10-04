package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserSecondaryEmailsResult;
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
public final class UserAddResult {
    public static final UserAddResult OTHER = new UserAddResult().withTag(Tag.OTHER);
    private Tag _tag;
    private UserSelectorArg invalidUserValue;
    private UserSelectorArg placeholderUserValue;
    private UserSecondaryEmailsResult successValue;
    private UserSelectorArg unverifiedValue;

    public enum Tag {
        SUCCESS,
        INVALID_USER,
        UNVERIFIED,
        PLACEHOLDER_USER,
        OTHER
    }

    private UserAddResult() {
    }

    private UserAddResult withTag(Tag tag) {
        UserAddResult userAddResult = new UserAddResult();
        userAddResult._tag = tag;
        return userAddResult;
    }

    private UserAddResult withTagAndSuccess(Tag tag, UserSecondaryEmailsResult userSecondaryEmailsResult) {
        UserAddResult userAddResult = new UserAddResult();
        userAddResult._tag = tag;
        userAddResult.successValue = userSecondaryEmailsResult;
        return userAddResult;
    }

    private UserAddResult withTagAndInvalidUser(Tag tag, UserSelectorArg userSelectorArg) {
        UserAddResult userAddResult = new UserAddResult();
        userAddResult._tag = tag;
        userAddResult.invalidUserValue = userSelectorArg;
        return userAddResult;
    }

    private UserAddResult withTagAndUnverified(Tag tag, UserSelectorArg userSelectorArg) {
        UserAddResult userAddResult = new UserAddResult();
        userAddResult._tag = tag;
        userAddResult.unverifiedValue = userSelectorArg;
        return userAddResult;
    }

    private UserAddResult withTagAndPlaceholderUser(Tag tag, UserSelectorArg userSelectorArg) {
        UserAddResult userAddResult = new UserAddResult();
        userAddResult._tag = tag;
        userAddResult.placeholderUserValue = userSelectorArg;
        return userAddResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static UserAddResult success(UserSecondaryEmailsResult userSecondaryEmailsResult) {
        if (userSecondaryEmailsResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserAddResult().withTagAndSuccess(Tag.SUCCESS, userSecondaryEmailsResult);
    }

    public UserSecondaryEmailsResult getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isInvalidUser() {
        return this._tag == Tag.INVALID_USER;
    }

    public static UserAddResult invalidUser(UserSelectorArg userSelectorArg) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserAddResult().withTagAndInvalidUser(Tag.INVALID_USER, userSelectorArg);
    }

    public UserSelectorArg getInvalidUserValue() {
        if (this._tag != Tag.INVALID_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_USER, but was Tag." + this._tag.name());
        }
        return this.invalidUserValue;
    }

    public boolean isUnverified() {
        return this._tag == Tag.UNVERIFIED;
    }

    public static UserAddResult unverified(UserSelectorArg userSelectorArg) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserAddResult().withTagAndUnverified(Tag.UNVERIFIED, userSelectorArg);
    }

    public UserSelectorArg getUnverifiedValue() {
        if (this._tag != Tag.UNVERIFIED) {
            throw new IllegalStateException("Invalid tag: required Tag.UNVERIFIED, but was Tag." + this._tag.name());
        }
        return this.unverifiedValue;
    }

    public boolean isPlaceholderUser() {
        return this._tag == Tag.PLACEHOLDER_USER;
    }

    public static UserAddResult placeholderUser(UserSelectorArg userSelectorArg) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserAddResult().withTagAndPlaceholderUser(Tag.PLACEHOLDER_USER, userSelectorArg);
    }

    public UserSelectorArg getPlaceholderUserValue() {
        if (this._tag != Tag.PLACEHOLDER_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.PLACEHOLDER_USER, but was Tag." + this._tag.name());
        }
        return this.placeholderUserValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.invalidUserValue, this.unverifiedValue, this.placeholderUserValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UserAddResult)) {
            return false;
        }
        UserAddResult userAddResult = (UserAddResult) obj;
        if (this._tag != userAddResult._tag) {
            return false;
        }
        int i = C44211.$SwitchMap$com$dropbox$core$v2$team$UserAddResult$Tag[this._tag.ordinal()];
        if (i == 1) {
            UserSecondaryEmailsResult userSecondaryEmailsResult = this.successValue;
            UserSecondaryEmailsResult userSecondaryEmailsResult2 = userAddResult.successValue;
            return userSecondaryEmailsResult == userSecondaryEmailsResult2 || userSecondaryEmailsResult.equals(userSecondaryEmailsResult2);
        }
        if (i == 2) {
            UserSelectorArg userSelectorArg = this.invalidUserValue;
            UserSelectorArg userSelectorArg2 = userAddResult.invalidUserValue;
            return userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2);
        }
        if (i == 3) {
            UserSelectorArg userSelectorArg3 = this.unverifiedValue;
            UserSelectorArg userSelectorArg4 = userAddResult.unverifiedValue;
            return userSelectorArg3 == userSelectorArg4 || userSelectorArg3.equals(userSelectorArg4);
        }
        if (i != 4) {
            return i == 5;
        }
        UserSelectorArg userSelectorArg5 = this.placeholderUserValue;
        UserSelectorArg userSelectorArg6 = userAddResult.placeholderUserValue;
        return userSelectorArg5 == userSelectorArg6 || userSelectorArg5.equals(userSelectorArg6);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.UserAddResult$1 */
    static /* synthetic */ class C44211 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$UserAddResult$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$UserAddResult$Tag = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UserAddResult$Tag[Tag.INVALID_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UserAddResult$Tag[Tag.UNVERIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UserAddResult$Tag[Tag.PLACEHOLDER_USER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UserAddResult$Tag[Tag.OTHER.ordinal()] = 5;
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

    static class Serializer extends UnionSerializer<UserAddResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UserAddResult userAddResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C44211.$SwitchMap$com$dropbox$core$v2$team$UserAddResult$Tag[userAddResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                UserSecondaryEmailsResult.Serializer.INSTANCE.serialize(userAddResult.successValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("invalid_user", jsonGenerator);
                jsonGenerator.writeFieldName("invalid_user");
                UserSelectorArg.Serializer.INSTANCE.serialize(userAddResult.invalidUserValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("unverified", jsonGenerator);
                jsonGenerator.writeFieldName("unverified");
                UserSelectorArg.Serializer.INSTANCE.serialize(userAddResult.unverifiedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 4) {
                jsonGenerator.writeStartObject();
                writeTag("placeholder_user", jsonGenerator);
                jsonGenerator.writeFieldName("placeholder_user");
                UserSelectorArg.Serializer.INSTANCE.serialize(userAddResult.placeholderUserValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UserAddResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UserAddResult userAddResultPlaceholderUser;
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
                userAddResultPlaceholderUser = UserAddResult.success(UserSecondaryEmailsResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("invalid_user".equals(tag)) {
                expectField("invalid_user", jsonParser);
                userAddResultPlaceholderUser = UserAddResult.invalidUser(UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("unverified".equals(tag)) {
                expectField("unverified", jsonParser);
                userAddResultPlaceholderUser = UserAddResult.unverified(UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("placeholder_user".equals(tag)) {
                expectField("placeholder_user", jsonParser);
                userAddResultPlaceholderUser = UserAddResult.placeholderUser(UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                userAddResultPlaceholderUser = UserAddResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return userAddResultPlaceholderUser;
        }
    }
}
