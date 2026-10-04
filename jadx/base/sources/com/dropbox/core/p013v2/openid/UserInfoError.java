package com.dropbox.core.p013v2.openid;

import com.dropbox.core.p013v2.openid.OpenIdError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class UserInfoError {
    public static final UserInfoError OTHER = new UserInfoError().withTag(Tag.OTHER);
    private Tag _tag;
    private OpenIdError openidErrorValue;

    public enum Tag {
        OPENID_ERROR,
        OTHER
    }

    private UserInfoError() {
    }

    private UserInfoError withTag(Tag tag) {
        UserInfoError userInfoError = new UserInfoError();
        userInfoError._tag = tag;
        return userInfoError;
    }

    private UserInfoError withTagAndOpenidError(Tag tag, OpenIdError openIdError) {
        UserInfoError userInfoError = new UserInfoError();
        userInfoError._tag = tag;
        userInfoError.openidErrorValue = openIdError;
        return userInfoError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isOpenidError() {
        return this._tag == Tag.OPENID_ERROR;
    }

    public static UserInfoError openidError(OpenIdError openIdError) {
        if (openIdError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserInfoError().withTagAndOpenidError(Tag.OPENID_ERROR, openIdError);
    }

    public OpenIdError getOpenidErrorValue() {
        if (this._tag != Tag.OPENID_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.OPENID_ERROR, but was Tag." + this._tag.name());
        }
        return this.openidErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.openidErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UserInfoError)) {
            return false;
        }
        UserInfoError userInfoError = (UserInfoError) obj;
        if (this._tag != userInfoError._tag) {
            return false;
        }
        int i = C42251.$SwitchMap$com$dropbox$core$v2$openid$UserInfoError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        OpenIdError openIdError = this.openidErrorValue;
        OpenIdError openIdError2 = userInfoError.openidErrorValue;
        return openIdError == openIdError2 || openIdError.equals(openIdError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.openid.UserInfoError$1 */
    static /* synthetic */ class C42251 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$openid$UserInfoError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$openid$UserInfoError$Tag = iArr;
            try {
                iArr[Tag.OPENID_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$openid$UserInfoError$Tag[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<UserInfoError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UserInfoError userInfoError, JsonGenerator jsonGenerator) throws IOException {
            if (C42251.$SwitchMap$com$dropbox$core$v2$openid$UserInfoError$Tag[userInfoError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("openid_error", jsonGenerator);
                jsonGenerator.writeFieldName("openid_error");
                OpenIdError.Serializer.INSTANCE.serialize(userInfoError.openidErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UserInfoError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UserInfoError userInfoErrorOpenidError;
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
            if ("openid_error".equals(tag)) {
                expectField("openid_error", jsonParser);
                userInfoErrorOpenidError = UserInfoError.openidError(OpenIdError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                userInfoErrorOpenidError = UserInfoError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return userInfoErrorOpenidError;
        }
    }
}
