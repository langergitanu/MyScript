package com.dropbox.core;

import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.util.StringUtil;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DbxWebAuth {
    private static final int CSRF_BYTES_SIZE = 16;
    public static final String ROLE_PERSONAL = "personal";
    public static final String ROLE_WORK = "work";
    final DbxAppInfo appInfo;
    final Request deprecatedRequest;
    final DbxRequestConfig requestConfig;
    private static final SecureRandom RAND = new SecureRandom();
    private static final int CSRF_STRING_SIZE = StringUtil.urlSafeBase64Encode(new byte[16]).length();

    @Deprecated
    public DbxWebAuth(DbxRequestConfig dbxRequestConfig, DbxAppInfo dbxAppInfo, String str, DbxSessionStore dbxSessionStore) {
        if (dbxRequestConfig == null) {
            throw new NullPointerException("requestConfig");
        }
        if (dbxAppInfo == null) {
            throw new NullPointerException("appInfo");
        }
        this.requestConfig = dbxRequestConfig;
        this.appInfo = dbxAppInfo;
        this.deprecatedRequest = newRequestBuilder().withRedirectUri(str, dbxSessionStore).build();
    }

    public DbxWebAuth(DbxRequestConfig dbxRequestConfig, DbxAppInfo dbxAppInfo) {
        if (dbxRequestConfig == null) {
            throw new NullPointerException("requestConfig");
        }
        if (dbxAppInfo == null) {
            throw new NullPointerException("appInfo");
        }
        this.requestConfig = dbxRequestConfig;
        this.appInfo = dbxAppInfo;
        this.deprecatedRequest = null;
    }

    @Deprecated
    public String start(String str) {
        Request request = this.deprecatedRequest;
        if (request == null) {
            throw new IllegalStateException("Must use DbxWebAuth.authorize instead.");
        }
        return authorizeImpl(request.copy().withState(str).build());
    }

    public String authorize(Request request) {
        if (this.deprecatedRequest != null) {
            throw new IllegalStateException("Must create this instance using DbxWebAuth(DbxRequestConfig,DbxAppInfo) to call this method.");
        }
        if (!this.appInfo.hasSecret()) {
            throw new IllegalStateException("For native apps, please use DbxPKCEWebAuth");
        }
        return authorizeImpl(request);
    }

    private String authorizeImpl(Request request) {
        return authorizeImpl(request, null);
    }

    String authorizeImpl(Request request, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("client_id", this.appInfo.getKey());
        map2.put("response_type", "code");
        if (request.redirectUri != null) {
            map2.put("redirect_uri", request.redirectUri);
            map2.put("state", appendCsrfToken(request));
        }
        if (request.requireRole != null) {
            map2.put("require_role", request.requireRole);
        }
        if (request.forceReapprove != null) {
            map2.put("force_reapprove", Boolean.toString(request.forceReapprove.booleanValue()).toLowerCase());
        }
        if (request.disableSignup != null) {
            map2.put("disable_signup", Boolean.toString(request.disableSignup.booleanValue()).toLowerCase());
        }
        if (request.tokenAccessType != null) {
            map2.put("token_access_type", request.tokenAccessType.toString());
        }
        if (request.scope != null) {
            map2.put("scope", request.scope);
        }
        if (request.includeGrantedScopes != null) {
            map2.put("include_granted_scopes", request.includeGrantedScopes.toString());
        }
        if (map != null) {
            for (String str : map.keySet()) {
                map2.put(str, map.get(str));
            }
        }
        return DbxRequestUtil.buildUrlWithParams(this.requestConfig.getUserLocale(), this.appInfo.getHost().getWeb(), "oauth2/authorize", DbxRequestUtil.toParamsArray(map2));
    }

    public DbxAuthFinish finishFromCode(String str) throws DbxException {
        return finish(str);
    }

    public DbxAuthFinish finishFromCode(String str, String str2) throws DbxException {
        return finish(str, str2, null);
    }

    public DbxAuthFinish finishFromRedirect(String str, DbxSessionStore dbxSessionStore, Map<String, String[]> map) throws CsrfException, ProviderException, DbxException, BadStateException, NotApprovedException, BadRequestException {
        return finish(getParam(map, "code"), str, validateRedirectUri(str, dbxSessionStore, map));
    }

    static String validateRedirectUri(String str, DbxSessionStore dbxSessionStore, Map<String, String[]> map) throws CsrfException, ProviderException, BadStateException, NotApprovedException, BadRequestException {
        String str2;
        if (str == null) {
            throw new NullPointerException("redirectUri");
        }
        if (dbxSessionStore == null) {
            throw new NullPointerException("sessionStore");
        }
        if (map == null) {
            throw new NullPointerException("params");
        }
        String param = getParam(map, "state");
        if (param == null) {
            throw new BadRequestException("Missing required parameter: \"state\".");
        }
        String param2 = getParam(map, "error");
        String param3 = getParam(map, "code");
        String param4 = getParam(map, "error_description");
        if (param3 == null && param2 == null) {
            throw new BadRequestException("Missing both \"code\" and \"error\".");
        }
        if (param3 != null && param2 != null) {
            throw new BadRequestException("Both \"code\" and \"error\" are set.");
        }
        if (param3 != null && param4 != null) {
            throw new BadRequestException("Both \"code\" and \"error_description\" are set.");
        }
        String strVerifyAndStripCsrfToken = verifyAndStripCsrfToken(param, dbxSessionStore);
        if (param2 == null) {
            return strVerifyAndStripCsrfToken;
        }
        if (param2.equals("access_denied")) {
            if (param4 == null) {
                str2 = "No additional description from Dropbox";
            } else {
                str2 = "Additional description from Dropbox: " + param4;
            }
            throw new NotApprovedException(str2);
        }
        if (param4 != null) {
            param2 = String.format("%s: %s", param2, param4);
        }
        throw new ProviderException(param2);
    }

    private DbxAuthFinish finish(String str) throws DbxException {
        return finish(str, null, null);
    }

    DbxAuthFinish finish(String str, String str2, final String str3) throws DbxException {
        if (str == null) {
            throw new NullPointerException("code");
        }
        if (!this.appInfo.hasSecret()) {
            throw new IllegalStateException("For native apps, please use DbxPKCEWebAuth");
        }
        HashMap map = new HashMap();
        map.put("grant_type", "authorization_code");
        map.put("code", str);
        map.put("locale", this.requestConfig.getUserLocale());
        if (str2 != null) {
            map.put("redirect_uri", str2);
        }
        ArrayList arrayList = new ArrayList();
        DbxRequestUtil.addBasicAuthHeader(arrayList, this.appInfo.getKey(), this.appInfo.getSecret());
        return (DbxAuthFinish) DbxRequestUtil.doPostNoAuth(this.requestConfig, DbxRawClientV2.USER_AGENT_ID, this.appInfo.getHost().getApi(), "oauth2/token", DbxRequestUtil.toParamsArray(map), arrayList, new DbxRequestUtil.ResponseHandler<DbxAuthFinish>() { // from class: com.dropbox.core.DbxWebAuth.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxAuthFinish handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return ((DbxAuthFinish) DbxRequestUtil.readJsonFromResponse(DbxAuthFinish.Reader, response)).withUrlState(str3);
            }
        });
    }

    @Deprecated
    public DbxAuthFinish finish(Map<String, String[]> map) throws CsrfException, ProviderException, DbxException, BadStateException, NotApprovedException, BadRequestException {
        Request request = this.deprecatedRequest;
        if (request == null) {
            throw new IllegalStateException("Must use DbxWebAuth.finishFromRedirect(..) instead.");
        }
        return finishFromRedirect(request.redirectUri, this.deprecatedRequest.sessionStore, map);
    }

    private static String appendCsrfToken(Request request) {
        byte[] bArr = new byte[16];
        RAND.nextBytes(bArr);
        String strUrlSafeBase64Encode = StringUtil.urlSafeBase64Encode(bArr);
        if (strUrlSafeBase64Encode.length() != CSRF_STRING_SIZE) {
            throw new AssertionError("unexpected CSRF token length: " + strUrlSafeBase64Encode.length());
        }
        if (request.sessionStore != null) {
            request.sessionStore.set(strUrlSafeBase64Encode);
        }
        if (request.state == null) {
            return strUrlSafeBase64Encode;
        }
        String str = strUrlSafeBase64Encode + request.state;
        if (str.length() <= 500) {
            return str;
        }
        throw new AssertionError("unexpected combined state length: " + str.length());
    }

    private static String verifyAndStripCsrfToken(String str, DbxSessionStore dbxSessionStore) throws CsrfException, BadStateException {
        String str2 = dbxSessionStore.get();
        if (str2 == null) {
            throw new BadStateException("No CSRF Token loaded from session store.");
        }
        int length = str2.length();
        int i = CSRF_STRING_SIZE;
        if (length < i) {
            throw new BadStateException("Token retrieved from session store is too small: " + str2);
        }
        if (str.length() < i) {
            throw new CsrfException("Token too small: " + str);
        }
        String strSubstring = str.substring(0, i);
        if (!StringUtil.secureStringEquals(str2, strSubstring)) {
            throw new CsrfException("expecting " + StringUtil.m531jq(str2) + ", got " + StringUtil.m531jq(strSubstring));
        }
        String strSubstring2 = str.substring(i, str.length());
        dbxSessionStore.clear();
        if (strSubstring2.isEmpty()) {
            return null;
        }
        return strSubstring2;
    }

    static String getParam(Map<String, String[]> map, String str) throws BadRequestException {
        String[] strArr = map.get(str);
        if (strArr == null) {
            return null;
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("Parameter \"" + str + "\" missing value.");
        }
        if (strArr.length == 1) {
            return strArr[0];
        }
        throw new BadRequestException("multiple occurrences of \"" + str + "\" parameter");
    }

    public static abstract class Exception extends java.lang.Exception {
        private static final long serialVersionUID = 0;

        public Exception(String str) {
            super(str);
        }
    }

    public static final class BadRequestException extends Exception {
        private static final long serialVersionUID = 0;

        public BadRequestException(String str) {
            super(str);
        }
    }

    public static final class BadStateException extends Exception {
        private static final long serialVersionUID = 0;

        public BadStateException(String str) {
            super(str);
        }
    }

    public static final class CsrfException extends Exception {
        private static final long serialVersionUID = 0;

        public CsrfException(String str) {
            super(str);
        }
    }

    public static final class NotApprovedException extends Exception {
        private static final long serialVersionUID = 0;

        public NotApprovedException(String str) {
            super(str);
        }
    }

    public static final class ProviderException extends Exception {
        private static final long serialVersionUID = 0;

        public ProviderException(String str) {
            super(str);
        }
    }

    public static Request.Builder newRequestBuilder() {
        return Request.newBuilder();
    }

    public static final class Request {
        private static final int MAX_STATE_SIZE = 500;
        private static final Charset UTF8 = Charset.forName("UTF-8");
        private final Boolean disableSignup;
        private final Boolean forceReapprove;
        private final IncludeGrantedScopes includeGrantedScopes;
        private final String redirectUri;
        private final String requireRole;
        private final String scope;
        private final DbxSessionStore sessionStore;
        private final String state;
        private final TokenAccessType tokenAccessType;

        private Request(String str, String str2, String str3, Boolean bool, Boolean bool2, DbxSessionStore dbxSessionStore, TokenAccessType tokenAccessType, String str4, IncludeGrantedScopes includeGrantedScopes) {
            this.redirectUri = str;
            this.state = str2;
            this.requireRole = str3;
            this.forceReapprove = bool;
            this.disableSignup = bool2;
            this.sessionStore = dbxSessionStore;
            this.tokenAccessType = tokenAccessType;
            this.scope = str4;
            this.includeGrantedScopes = includeGrantedScopes;
        }

        public Builder copy() {
            return new Builder(this.redirectUri, this.state, this.requireRole, this.forceReapprove, this.disableSignup, this.sessionStore, this.tokenAccessType, this.scope, this.includeGrantedScopes);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static final class Builder {
            private Boolean disableSignup;
            private Boolean forceReapprove;
            private IncludeGrantedScopes includeGrantedScopes;
            private String redirectUri;
            private String requireRole;
            private String scope;
            private DbxSessionStore sessionStore;
            private String state;
            private TokenAccessType tokenAccessType;

            private Builder() {
                this(null, null, null, null, null, null, null, null, null);
            }

            private Builder(String str, String str2, String str3, Boolean bool, Boolean bool2, DbxSessionStore dbxSessionStore, TokenAccessType tokenAccessType, String str4, IncludeGrantedScopes includeGrantedScopes) {
                this.redirectUri = str;
                this.state = str2;
                this.requireRole = str3;
                this.forceReapprove = bool;
                this.disableSignup = bool2;
                this.sessionStore = dbxSessionStore;
                this.tokenAccessType = tokenAccessType;
                this.scope = str4;
                this.includeGrantedScopes = includeGrantedScopes;
            }

            public Builder withNoRedirect() {
                this.redirectUri = null;
                this.sessionStore = null;
                return this;
            }

            public Builder withRedirectUri(String str, DbxSessionStore dbxSessionStore) {
                if (str == null) {
                    throw new NullPointerException("redirectUri");
                }
                if (dbxSessionStore == null) {
                    throw new NullPointerException("sessionStore");
                }
                this.redirectUri = str;
                this.sessionStore = dbxSessionStore;
                return this;
            }

            public Builder withState(String str) {
                if (str != null && str.getBytes(Request.UTF8).length + DbxWebAuth.CSRF_STRING_SIZE > 500) {
                    throw new IllegalArgumentException("UTF-8 encoded state cannot be greater than " + (500 - DbxWebAuth.CSRF_STRING_SIZE) + " bytes.");
                }
                this.state = str;
                return this;
            }

            public Builder withRequireRole(String str) {
                this.requireRole = str;
                return this;
            }

            public Builder withForceReapprove(Boolean bool) {
                this.forceReapprove = bool;
                return this;
            }

            public Builder withDisableSignup(Boolean bool) {
                this.disableSignup = bool;
                return this;
            }

            public Builder withTokenAccessType(TokenAccessType tokenAccessType) {
                this.tokenAccessType = tokenAccessType;
                return this;
            }

            public Builder withScope(Collection<String> collection) {
                if (collection != null) {
                    this.scope = StringUtil.join(collection, " ");
                }
                return this;
            }

            public Builder withIncludeGrantedScopes(IncludeGrantedScopes includeGrantedScopes) {
                this.includeGrantedScopes = includeGrantedScopes;
                return this;
            }

            public Request build() {
                if (this.redirectUri == null && this.state != null) {
                    throw new IllegalStateException("Cannot specify a state without a redirect URI.");
                }
                if (this.includeGrantedScopes != null && this.scope == null) {
                    throw new IllegalArgumentException("If you are using includeGrantedScopes, you must ask for specific new scopes");
                }
                return new Request(this.redirectUri, this.state, this.requireRole, this.forceReapprove, this.disableSignup, this.sessionStore, this.tokenAccessType, this.scope, this.includeGrantedScopes);
            }
        }
    }
}
