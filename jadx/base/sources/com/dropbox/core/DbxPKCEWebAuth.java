package com.dropbox.core;

import com.dropbox.core.DbxWebAuth;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DbxPKCEWebAuth {
    private final DbxAppInfo appInfo;
    private boolean consumed;
    private final DbxPKCEManager dbxPKCEManager;
    private final DbxWebAuth dbxWebAuth;
    private final DbxRequestConfig requestConfig;
    private boolean started;

    public DbxPKCEWebAuth(DbxRequestConfig dbxRequestConfig, DbxAppInfo dbxAppInfo) {
        if (dbxAppInfo.hasSecret()) {
            throw new IllegalStateException("PKCE cdoe flow doesn't require app secret, if you decide to embed it in your app, please use regular DbxWebAuth instead.");
        }
        this.requestConfig = dbxRequestConfig;
        this.appInfo = dbxAppInfo;
        this.dbxWebAuth = new DbxWebAuth(dbxRequestConfig, dbxAppInfo);
        this.dbxPKCEManager = new DbxPKCEManager();
        this.started = false;
        this.consumed = false;
    }

    public String authorize(DbxWebAuth.Request request) {
        if (this.consumed) {
            throw new IllegalStateException("This DbxPKCEWebAuth instance has been consumed already. To start a new PKCE OAuth flow, please create a new instance.");
        }
        this.started = true;
        HashMap map = new HashMap();
        map.put("code_challenge", this.dbxPKCEManager.getCodeChallenge());
        map.put("code_challenge_method", DbxPKCEManager.CODE_CHALLENGE_METHODS);
        return this.dbxWebAuth.authorizeImpl(request, map);
    }

    public DbxAuthFinish finishFromCode(String str) throws DbxException {
        return finish(str, null, null);
    }

    public DbxAuthFinish finishFromRedirect(String str, DbxSessionStore dbxSessionStore, Map<String, String[]> map) throws DbxWebAuth.CsrfException, DbxWebAuth.ProviderException, DbxException, DbxWebAuth.BadStateException, DbxWebAuth.NotApprovedException, DbxWebAuth.BadRequestException {
        return finish(DbxWebAuth.getParam(map, "code"), str, DbxWebAuth.validateRedirectUri(str, dbxSessionStore, map));
    }

    DbxAuthFinish finish(String str, String str2, String str3) throws DbxException {
        if (str == null) {
            throw new NullPointerException("code");
        }
        if (!this.started) {
            throw new IllegalStateException("Must initialize the PKCE flow by calling authorize first.");
        }
        if (this.consumed) {
            throw new IllegalStateException("This DbxPKCEWebAuth instance has been consumed already. To start a new PKCE OAuth flow, please create a new instance.");
        }
        DbxAuthFinish dbxAuthFinishMakeTokenRequest = this.dbxPKCEManager.makeTokenRequest(this.requestConfig, str, this.appInfo.getKey(), str2, this.appInfo.getHost());
        this.consumed = true;
        return dbxAuthFinishMakeTokenRequest.withUrlState(str3);
    }
}
