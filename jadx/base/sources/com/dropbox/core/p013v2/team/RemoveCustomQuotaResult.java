package com.dropbox.core.p013v2.team;

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
public final class RemoveCustomQuotaResult {
    public static final RemoveCustomQuotaResult OTHER = new RemoveCustomQuotaResult().withTag(Tag.OTHER);
    private Tag _tag;
    private UserSelectorArg invalidUserValue;
    private UserSelectorArg successValue;

    public enum Tag {
        SUCCESS,
        INVALID_USER,
        OTHER
    }

    private RemoveCustomQuotaResult() {
    }

    private RemoveCustomQuotaResult withTag(Tag tag) {
        RemoveCustomQuotaResult removeCustomQuotaResult = new RemoveCustomQuotaResult();
        removeCustomQuotaResult._tag = tag;
        return removeCustomQuotaResult;
    }

    private RemoveCustomQuotaResult withTagAndSuccess(Tag tag, UserSelectorArg userSelectorArg) {
        RemoveCustomQuotaResult removeCustomQuotaResult = new RemoveCustomQuotaResult();
        removeCustomQuotaResult._tag = tag;
        removeCustomQuotaResult.successValue = userSelectorArg;
        return removeCustomQuotaResult;
    }

    private RemoveCustomQuotaResult withTagAndInvalidUser(Tag tag, UserSelectorArg userSelectorArg) {
        RemoveCustomQuotaResult removeCustomQuotaResult = new RemoveCustomQuotaResult();
        removeCustomQuotaResult._tag = tag;
        removeCustomQuotaResult.invalidUserValue = userSelectorArg;
        return removeCustomQuotaResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static RemoveCustomQuotaResult success(UserSelectorArg userSelectorArg) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveCustomQuotaResult().withTagAndSuccess(Tag.SUCCESS, userSelectorArg);
    }

    public UserSelectorArg getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isInvalidUser() {
        return this._tag == Tag.INVALID_USER;
    }

    public static RemoveCustomQuotaResult invalidUser(UserSelectorArg userSelectorArg) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveCustomQuotaResult().withTagAndInvalidUser(Tag.INVALID_USER, userSelectorArg);
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
        if (obj == null || !(obj instanceof RemoveCustomQuotaResult)) {
            return false;
        }
        RemoveCustomQuotaResult removeCustomQuotaResult = (RemoveCustomQuotaResult) obj;
        if (this._tag != removeCustomQuotaResult._tag) {
            return false;
        }
        int i = C43891.$SwitchMap$com$dropbox$core$v2$team$RemoveCustomQuotaResult$Tag[this._tag.ordinal()];
        if (i == 1) {
            UserSelectorArg userSelectorArg = this.successValue;
            UserSelectorArg userSelectorArg2 = removeCustomQuotaResult.successValue;
            return userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2);
        }
        if (i != 2) {
            return i == 3;
        }
        UserSelectorArg userSelectorArg3 = this.invalidUserValue;
        UserSelectorArg userSelectorArg4 = removeCustomQuotaResult.invalidUserValue;
        return userSelectorArg3 == userSelectorArg4 || userSelectorArg3.equals(userSelectorArg4);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.RemoveCustomQuotaResult$1 */
    static /* synthetic */ class C43891 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$RemoveCustomQuotaResult$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$RemoveCustomQuotaResult$Tag = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$RemoveCustomQuotaResult$Tag[Tag.INVALID_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$RemoveCustomQuotaResult$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<RemoveCustomQuotaResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RemoveCustomQuotaResult removeCustomQuotaResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C43891.$SwitchMap$com$dropbox$core$v2$team$RemoveCustomQuotaResult$Tag[removeCustomQuotaResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.SUCCESS);
                UserSelectorArg.Serializer.INSTANCE.serialize(removeCustomQuotaResult.successValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("invalid_user", jsonGenerator);
                jsonGenerator.writeFieldName("invalid_user");
                UserSelectorArg.Serializer.INSTANCE.serialize(removeCustomQuotaResult.invalidUserValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RemoveCustomQuotaResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RemoveCustomQuotaResult removeCustomQuotaResultInvalidUser;
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
                expectField(FirebaseAnalytics.Param.SUCCESS, jsonParser);
                removeCustomQuotaResultInvalidUser = RemoveCustomQuotaResult.success(UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("invalid_user".equals(tag)) {
                expectField("invalid_user", jsonParser);
                removeCustomQuotaResultInvalidUser = RemoveCustomQuotaResult.invalidUser(UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                removeCustomQuotaResultInvalidUser = RemoveCustomQuotaResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return removeCustomQuotaResultInvalidUser;
        }
    }
}
