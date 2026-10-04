package com.dropbox.core.p013v2.teamlog;

import androidx.autofill.HintConstants;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum LoginMethod {
    APPLE_OAUTH,
    FIRST_PARTY_TOKEN_EXCHANGE,
    GOOGLE_OAUTH,
    LENOVO_OAUTH,
    PASSWORD,
    QR_CODE,
    SAML,
    TWO_FACTOR_AUTHENTICATION,
    WEB_SESSION,
    OTHER;

    static class Serializer extends UnionSerializer<LoginMethod> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LoginMethod loginMethod, JsonGenerator jsonGenerator) throws IOException {
            switch (C44921.$SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod[loginMethod.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("apple_oauth");
                    break;
                case 2:
                    jsonGenerator.writeString("first_party_token_exchange");
                    break;
                case 3:
                    jsonGenerator.writeString("google_oauth");
                    break;
                case 4:
                    jsonGenerator.writeString("lenovo_oauth");
                    break;
                case 5:
                    jsonGenerator.writeString(HintConstants.AUTOFILL_HINT_PASSWORD);
                    break;
                case 6:
                    jsonGenerator.writeString("qr_code");
                    break;
                case 7:
                    jsonGenerator.writeString("saml");
                    break;
                case 8:
                    jsonGenerator.writeString("two_factor_authentication");
                    break;
                case 9:
                    jsonGenerator.writeString("web_session");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LoginMethod deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LoginMethod loginMethod;
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
            if ("apple_oauth".equals(tag)) {
                loginMethod = LoginMethod.APPLE_OAUTH;
            } else if ("first_party_token_exchange".equals(tag)) {
                loginMethod = LoginMethod.FIRST_PARTY_TOKEN_EXCHANGE;
            } else if ("google_oauth".equals(tag)) {
                loginMethod = LoginMethod.GOOGLE_OAUTH;
            } else if ("lenovo_oauth".equals(tag)) {
                loginMethod = LoginMethod.LENOVO_OAUTH;
            } else if (HintConstants.AUTOFILL_HINT_PASSWORD.equals(tag)) {
                loginMethod = LoginMethod.PASSWORD;
            } else if ("qr_code".equals(tag)) {
                loginMethod = LoginMethod.QR_CODE;
            } else if ("saml".equals(tag)) {
                loginMethod = LoginMethod.SAML;
            } else if ("two_factor_authentication".equals(tag)) {
                loginMethod = LoginMethod.TWO_FACTOR_AUTHENTICATION;
            } else if ("web_session".equals(tag)) {
                loginMethod = LoginMethod.WEB_SESSION;
            } else {
                loginMethod = LoginMethod.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return loginMethod;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.LoginMethod$1 */
    static /* synthetic */ class C44921 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod;

        static {
            int[] iArr = new int[LoginMethod.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod = iArr;
            try {
                iArr[LoginMethod.APPLE_OAUTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod[LoginMethod.FIRST_PARTY_TOKEN_EXCHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod[LoginMethod.GOOGLE_OAUTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod[LoginMethod.LENOVO_OAUTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod[LoginMethod.PASSWORD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod[LoginMethod.QR_CODE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod[LoginMethod.SAML.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod[LoginMethod.TWO_FACTOR_AUTHENTICATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LoginMethod[LoginMethod.WEB_SESSION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
