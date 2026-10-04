package com.dropbox.core;

import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes4.dex */
public class DbxPKCEManager {
    public static final String CODE_CHALLENGE_METHODS = "S256";
    private static final String CODE_VERIFIER_CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-._~";
    public static final int CODE_VERIFIER_SIZE = 128;
    private static final SecureRandom RAND = new SecureRandom();
    private String codeChallenge;
    private String codeVerifier;

    public DbxPKCEManager() {
        String strGenerateCodeVerifier = generateCodeVerifier();
        this.codeVerifier = strGenerateCodeVerifier;
        this.codeChallenge = generateCodeChallenge(strGenerateCodeVerifier);
    }

    public DbxPKCEManager(String str) {
        this.codeVerifier = str;
        this.codeChallenge = generateCodeChallenge(str);
    }

    String generateCodeVerifier() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            sb.append(CODE_VERIFIER_CHAR_SET.charAt(RAND.nextInt(CODE_VERIFIER_CHAR_SET.length())));
        }
        return sb.toString();
    }

    static String generateCodeChallenge(String str) {
        try {
            return StringUtil.urlSafeBase64Encode(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(str.getBytes("US-ASCII"))).replaceAll("=+$", "");
        } catch (UnsupportedEncodingException e) {
            throw LangUtil.mkAssert("Impossible", e);
        } catch (NoSuchAlgorithmException e2) {
            throw LangUtil.mkAssert("Impossible", e2);
        }
    }

    public String getCodeVerifier() {
        return this.codeVerifier;
    }

    public String getCodeChallenge() {
        return this.codeChallenge;
    }

    public DbxAuthFinish makeTokenRequest(DbxRequestConfig dbxRequestConfig, String str, String str2, String str3, DbxHost dbxHost) throws DbxException {
        HashMap map = new HashMap();
        map.put("grant_type", "authorization_code");
        map.put("code", str);
        map.put("locale", dbxRequestConfig.getUserLocale());
        map.put("client_id", str2);
        map.put("code_verifier", this.codeVerifier);
        if (str3 != null) {
            map.put("redirect_uri", str3);
        }
        return (DbxAuthFinish) DbxRequestUtil.doPostNoAuth(dbxRequestConfig, DbxRawClientV2.USER_AGENT_ID, dbxHost.getApi(), "oauth2/token", DbxRequestUtil.toParamsArray(map), null, new DbxRequestUtil.ResponseHandler<DbxAuthFinish>() { // from class: com.dropbox.core.DbxPKCEManager.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxAuthFinish handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (DbxAuthFinish) DbxRequestUtil.readJsonFromResponse(DbxAuthFinish.Reader, response);
            }
        });
    }
}
