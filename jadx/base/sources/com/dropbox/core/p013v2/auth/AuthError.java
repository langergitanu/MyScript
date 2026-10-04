package com.dropbox.core.p013v2.auth;

import com.dropbox.core.p013v2.auth.TokenScopeError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class AuthError {
    private Tag _tag;
    private TokenScopeError missingScopeValue;
    public static final AuthError INVALID_ACCESS_TOKEN = new AuthError().withTag(Tag.INVALID_ACCESS_TOKEN);
    public static final AuthError INVALID_SELECT_USER = new AuthError().withTag(Tag.INVALID_SELECT_USER);
    public static final AuthError INVALID_SELECT_ADMIN = new AuthError().withTag(Tag.INVALID_SELECT_ADMIN);
    public static final AuthError USER_SUSPENDED = new AuthError().withTag(Tag.USER_SUSPENDED);
    public static final AuthError EXPIRED_ACCESS_TOKEN = new AuthError().withTag(Tag.EXPIRED_ACCESS_TOKEN);
    public static final AuthError ROUTE_ACCESS_DENIED = new AuthError().withTag(Tag.ROUTE_ACCESS_DENIED);
    public static final AuthError OTHER = new AuthError().withTag(Tag.OTHER);

    public enum Tag {
        INVALID_ACCESS_TOKEN,
        INVALID_SELECT_USER,
        INVALID_SELECT_ADMIN,
        USER_SUSPENDED,
        EXPIRED_ACCESS_TOKEN,
        MISSING_SCOPE,
        ROUTE_ACCESS_DENIED,
        OTHER
    }

    private AuthError() {
    }

    private AuthError withTag(Tag tag) {
        AuthError authError = new AuthError();
        authError._tag = tag;
        return authError;
    }

    private AuthError withTagAndMissingScope(Tag tag, TokenScopeError tokenScopeError) {
        AuthError authError = new AuthError();
        authError._tag = tag;
        authError.missingScopeValue = tokenScopeError;
        return authError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInvalidAccessToken() {
        return this._tag == Tag.INVALID_ACCESS_TOKEN;
    }

    public boolean isInvalidSelectUser() {
        return this._tag == Tag.INVALID_SELECT_USER;
    }

    public boolean isInvalidSelectAdmin() {
        return this._tag == Tag.INVALID_SELECT_ADMIN;
    }

    public boolean isUserSuspended() {
        return this._tag == Tag.USER_SUSPENDED;
    }

    public boolean isExpiredAccessToken() {
        return this._tag == Tag.EXPIRED_ACCESS_TOKEN;
    }

    public boolean isMissingScope() {
        return this._tag == Tag.MISSING_SCOPE;
    }

    public static AuthError missingScope(TokenScopeError tokenScopeError) {
        if (tokenScopeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AuthError().withTagAndMissingScope(Tag.MISSING_SCOPE, tokenScopeError);
    }

    public TokenScopeError getMissingScopeValue() {
        if (this._tag != Tag.MISSING_SCOPE) {
            throw new IllegalStateException("Invalid tag: required Tag.MISSING_SCOPE, but was Tag." + this._tag.name());
        }
        return this.missingScopeValue;
    }

    public boolean isRouteAccessDenied() {
        return this._tag == Tag.ROUTE_ACCESS_DENIED;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.missingScopeValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AuthError)) {
            return false;
        }
        AuthError authError = (AuthError) obj;
        if (this._tag != authError._tag) {
            return false;
        }
        switch (C41081.$SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag[this._tag.ordinal()]) {
            case 6:
                TokenScopeError tokenScopeError = this.missingScopeValue;
                TokenScopeError tokenScopeError2 = authError.missingScopeValue;
                if (tokenScopeError != tokenScopeError2 && !tokenScopeError.equals(tokenScopeError2)) {
                    return false;
                }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.auth.AuthError$1 */
    static /* synthetic */ class C41081 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag = iArr;
            try {
                iArr[Tag.INVALID_ACCESS_TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag[Tag.INVALID_SELECT_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag[Tag.INVALID_SELECT_ADMIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag[Tag.USER_SUSPENDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag[Tag.EXPIRED_ACCESS_TOKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag[Tag.MISSING_SCOPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag[Tag.ROUTE_ACCESS_DENIED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag[Tag.OTHER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<AuthError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AuthError authError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41081.$SwitchMap$com$dropbox$core$v2$auth$AuthError$Tag[authError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeString("invalid_access_token");
                    break;
                case 2:
                    jsonGenerator.writeString("invalid_select_user");
                    break;
                case 3:
                    jsonGenerator.writeString("invalid_select_admin");
                    break;
                case 4:
                    jsonGenerator.writeString("user_suspended");
                    break;
                case 5:
                    jsonGenerator.writeString("expired_access_token");
                    break;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("missing_scope", jsonGenerator);
                    TokenScopeError.Serializer.INSTANCE.serialize(authError.missingScopeValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 7:
                    jsonGenerator.writeString("route_access_denied");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AuthError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AuthError authErrorMissingScope;
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
            if ("invalid_access_token".equals(tag)) {
                authErrorMissingScope = AuthError.INVALID_ACCESS_TOKEN;
            } else if ("invalid_select_user".equals(tag)) {
                authErrorMissingScope = AuthError.INVALID_SELECT_USER;
            } else if ("invalid_select_admin".equals(tag)) {
                authErrorMissingScope = AuthError.INVALID_SELECT_ADMIN;
            } else if ("user_suspended".equals(tag)) {
                authErrorMissingScope = AuthError.USER_SUSPENDED;
            } else if ("expired_access_token".equals(tag)) {
                authErrorMissingScope = AuthError.EXPIRED_ACCESS_TOKEN;
            } else if ("missing_scope".equals(tag)) {
                authErrorMissingScope = AuthError.missingScope(TokenScopeError.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("route_access_denied".equals(tag)) {
                authErrorMissingScope = AuthError.ROUTE_ACCESS_DENIED;
            } else {
                authErrorMissingScope = AuthError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return authErrorMissingScope;
        }
    }
}
